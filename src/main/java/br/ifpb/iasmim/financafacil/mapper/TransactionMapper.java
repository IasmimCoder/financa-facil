package br.ifpb.iasmim.financafacil.mapper;

import br.ifpb.iasmim.financafacil.model.Transaction;
import br.ifpb.iasmim.financafacil.model.dto.TransactionDTO;

public class TransactionMapper {

    public Transaction toEntity(TransactionDTO dto){
        Transaction transaction = new Transaction();
        transaction.setCategory(dto.getCategoryId());
    }

}
