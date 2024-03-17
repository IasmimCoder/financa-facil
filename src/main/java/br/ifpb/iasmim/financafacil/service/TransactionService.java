package br.ifpb.iasmim.financafacil.service;

import br.ifpb.iasmim.financafacil.mapper.TransactionMapper;
import br.ifpb.iasmim.financafacil.model.Transaction;
import br.ifpb.iasmim.financafacil.model.dto.TransactionDTO;
import br.ifpb.iasmim.financafacil.repository.TransactionRepository;
import exceptions.TransactionNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    TransactionMapper transactionMapper;

    public TransactionDTO create(TransactionDTO dto){

        Transaction entity = transactionMapper.toEntity(dto);
        Transaction createdEntity = transactionRepository.save(entity);
        TransactionDTO createdDto = transactionMapper.toDto(createdEntity);
        return createdDto;
    }

    public List<TransactionDTO> findAll(){
        List<Transaction> transactions = transactionRepository.findAll();
        return transactionMapper.toListDto(transactions);
    }

    public TransactionDTO findById(UUID id){
        Optional<Transaction> optionalTransaction = transactionRepository.findById(id);
        if(optionalTransaction.isPresent()){
            return transactionMapper.toDto(optionalTransaction.get());
        }

        return null;
    }

    public void deleteById(UUID id){
        transactionRepository.deleteById(id);
    }

    public TransactionDTO updateTransaction(UUID id, TransactionDTO updateTransactionDTO){
        Optional<Transaction> optionalTransaction = transactionRepository.findById(id);
        if (optionalTransaction.isPresent()){
            Transaction transaction = optionalTransaction.get();

            transaction.setId(updateTransactionDTO.getId());
            transaction.setDate(updateTransactionDTO.getDate());
            transaction.setValue(updateTransactionDTO.getValue());

            transactionRepository.save(transaction);
            return transactionMapper.toDto(transaction);

        }

        throw new TransactionNotFoundException("");

    }
}
