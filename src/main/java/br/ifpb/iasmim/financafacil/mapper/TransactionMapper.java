package br.ifpb.iasmim.financafacil.mapper;

import br.ifpb.iasmim.financafacil.model.Transaction;
import br.ifpb.iasmim.financafacil.model.dto.TransactionDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TransactionMapper {

    public Transaction toEntity(TransactionDTO dto){
        Transaction entity = new Transaction();
        entity.setId(dto.getId());
        entity.setDate(dto.getDate());
        entity.setValue(dto.getValue());
        entity.setType(dto.getType());
        entity.setUser(dto.getUserId());
        entity.setCategory(dto.getCategoryId());
        return entity;
    }

    public TransactionDTO toDto(Transaction entity){
        TransactionDTO dto = new TransactionDTO();
        dto.setId(entity.getId());
        dto.setDate(entity.getDate());
        dto.setValue(entity.getValue());
        return dto;
    }

    public List<TransactionDTO> toListDto(List<Transaction> listEntity){

        return  listEntity.stream()
                .map(entity -> toDto(entity))//Converte cada entidade em um DTO
                .collect(Collectors.toList());//Coleta os DTOs em uma lista e retorna
    }
}
