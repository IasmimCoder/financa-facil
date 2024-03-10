package br.ifpb.iasmim.financafacil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifpb.iasmim.financafacil.mapper.UserMapper;
import br.ifpb.iasmim.financafacil.model.User;
import br.ifpb.iasmim.financafacil.model.dto.UserDTO;
import br.ifpb.iasmim.financafacil.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    public UserDTO create(UserDTO dto) {

        User entity = userMapper.toEntity(dto);
        User createdEntity = userRepository.save(entity);
        UserDTO createdDto = userMapper.toDto(createdEntity);
        return createdDto;
    }
}
