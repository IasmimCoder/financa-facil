package br.ifpb.iasmim.financafacil.service;

import br.ifpb.iasmim.financafacil.mapper.TransactionMapper;
import br.ifpb.iasmim.financafacil.model.Category;
import br.ifpb.iasmim.financafacil.model.Transaction;
import br.ifpb.iasmim.financafacil.model.User;
import br.ifpb.iasmim.financafacil.model.dto.CreateTransactionDTO;
import br.ifpb.iasmim.financafacil.model.dto.MonthlySummaryDTO;
import br.ifpb.iasmim.financafacil.model.dto.TransactionDTO;
import br.ifpb.iasmim.financafacil.model.enums.EnumMonth;
import br.ifpb.iasmim.financafacil.model.enums.CategoryType;
import br.ifpb.iasmim.financafacil.repository.CategoryRepository;
import br.ifpb.iasmim.financafacil.repository.TransactionRepository;
import br.ifpb.iasmim.financafacil.repository.UserRepository;
import exceptions.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    TransactionMapper transactionMapper;

    public TransactionDTO create(CreateTransactionDTO dto) {
        Transaction transaction = new Transaction();
        transaction.setDate(dto.getDate());
        transaction.setValue(dto.getValue());

        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(
                        () -> new NotFoundException("Categoria não encontrada com o ID: " + dto.getCategoryId()));

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(
                        () -> new NotFoundException("Usuário não encontrada com o ID: " + dto.getUserId()));

        transaction.setCategory(category);
        transaction.setUser(user);
        Transaction createdEntity = transactionRepository.save(transaction);
        TransactionDTO createdDto = transactionMapper.toDto(createdEntity);
        return createdDto;
    }

    public List<TransactionDTO> findAll() {
        List<Transaction> transactions = transactionRepository.findAll();
        return transactionMapper.toListDto(transactions);
    }

    public TransactionDTO findById(UUID id) {
        Optional<Transaction> optionalTransaction = transactionRepository.findById(id);
        if (optionalTransaction.isPresent()) {
            return transactionMapper.toDto(optionalTransaction.get());
        }

        return null;
    }

    public void deleteById(UUID id) {
        transactionRepository.deleteById(id);
    }

    public TransactionDTO updateTransaction(UUID id, TransactionDTO updateTransactionDTO) {
        Optional<Transaction> optionalTransaction = transactionRepository.findById(id);
        if (optionalTransaction.isPresent()) {
            Transaction transaction = optionalTransaction.get();

            transaction.setDate(Objects.requireNonNullElse(updateTransactionDTO.getDate(), transaction.getDate()));
            
            transaction.setValue(Objects.requireNonNullElse(updateTransactionDTO.getValue(), transaction.getValue()));
            
            transactionRepository.save(transaction);
            return transactionMapper.toDto(transaction);

        }

        throw new NotFoundException("");

    }

    public List<TransactionDTO> findByMonthAndType(String monthString, int year, CategoryType type, UUID userId) {

        EnumMonth monthEnum = EnumMonth.getMonthOrDefault(monthString);
        List<Transaction> transactions = transactionRepository.findByMonthAndYearAndType(monthEnum.getMonth().getValue(), year, type, userId);
        return transactionMapper.toListDto(transactions);
    }

    public MonthlySummaryDTO getMonthlySummary(String monthString, int year, UUID userId) {
        EnumMonth monthEnum = EnumMonth.getMonthOrDefault(monthString);
        // Obtém todas as transações para o mês atual
        List<Transaction> transactions = transactionRepository.findByUserIdAndMonthAndYear(monthEnum.getMonth().getValue(), year, userId);

        // Calcula o total de entradas e saídas
        BigDecimal totalIncome = transactions.stream()
                .filter(transaction -> transaction.getCategory().getType() == CategoryType.ENTRADA)
                .map(transaction -> transaction.getValue())
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal totalExpense = transactions.stream()
                .filter(transaction -> transaction.getCategory().getType() == CategoryType.SAIDA)
                .map(transaction -> transaction.getValue())
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        // Cria e retorna o DTO do resumo mensal
        return new MonthlySummaryDTO(monthEnum.getNome(), year, totalIncome, totalExpense);
    }
}
