package br.ifpb.iasmim.financafacil.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.ifpb.iasmim.financafacil.model.User;
import br.ifpb.iasmim.financafacil.model.dto.UserDTO;

@Component
public class UserMapper {


    @Autowired
    TransactionMapper transactionMapper;

    public User toEntity(UserDTO dto) {
        User entity = new User();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());
        return entity;
    }

    public UserDTO toDto(User entity) {
        UserDTO dto = new UserDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setEmail(entity.getEmail());
        dto.setPassword(entity.getPassword());
        return dto;
    }

    public List<UserDTO> toListDto(List<User> listEntity) {
        
        return listEntity.stream()
            .map(entity -> toDto(entity)) // Converte cada entidade em um DTO
            .collect(Collectors.toList()); // Coleta os DTOs em uma lista e retorna

    }
}
