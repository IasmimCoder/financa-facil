package br.ifpb.iasmim.financafacil.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
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

    public List<UserDTO> findAll() {
       List<User> users = userRepository.findAll();
       return userMapper.toListDto(users);
    }

    public UserDTO findById(UUID id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()){
            return userMapper.toDto(optionalUser.get());
        } 

        return null;
    }

    public void deleteById(UUID id) {
        //User user = userMapper.toEntity(findById(id));
       userRepository.deleteById(id);
    }

    public UserDTO updateUser(UUID id, UserDTO updatedUserDTO){

        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();

            // Atualize os campos do usuário com os novos valores fornecidos
            user.setName(updatedUserDTO.getName());
            user.setEmail(updatedUserDTO.getEmail());
            user.setPassword(updatedUserDTO.getPassword()); 
            
            // Salve as alterações no banco de dados
            userRepository.save(user);
            return userMapper.toDto(user);
        }
        
        throw new UserNotFoundException("User not found with id: " + id);
    }
}
