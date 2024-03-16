package br.ifpb.iasmim.financafacil.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ifpb.iasmim.financafacil.model.dto.UserDTO;
import br.ifpb.iasmim.financafacil.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping()
    public ResponseEntity<UserDTO> create(@RequestBody UserDTO dto) {
        UserDTO createdUser = userService.create(dto);
        return ResponseEntity.created(null).body(createdUser);
    }

    //get p/ read
    @GetMapping()
    public ResponseEntity<List<UserDTO>> findAll() {
        List<UserDTO> users = userService.findAll();
        return ResponseEntity.ok(users);
    }
    
}
