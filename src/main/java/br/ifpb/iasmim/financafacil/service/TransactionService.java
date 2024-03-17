package br.ifpb.iasmim.financafacil.service;

import br.ifpb.iasmim.financafacil.mapper.TransactionMapper;
import br.ifpb.iasmim.financafacil.model.Category;
import br.ifpb.iasmim.financafacil.model.Transaction;
import br.ifpb.iasmim.financafacil.model.User;
import br.ifpb.iasmim.financafacil.model.dto.TransactionDTO;
import br.ifpb.iasmim.financafacil.repository.CategoryRepository;
import br.ifpb.iasmim.financafacil.repository.TransactionRepository;
import br.ifpb.iasmim.financafacil.repository.UserRepository;
import exceptions.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public TransactionDTO create(TransactionDTO dto) {
        Transaction transaction = new Transaction();
        transaction.setDate(dto.getDate());
        transaction.setValue(dto.getValue());
        transaction.setType(dto.getType());

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

            transaction.setDate(updateTransactionDTO.getDate());
            transaction.setValue(updateTransactionDTO.getValue());
            transaction.setType(updateTransactionDTO.getType());

            transactionRepository.save(transaction);
            return transactionMapper.toDto(transaction);

        }

        throw new NotFoundException("");

    }
}
