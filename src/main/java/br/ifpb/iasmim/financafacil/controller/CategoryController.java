package br.ifpb.iasmim.financafacil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ifpb.iasmim.financafacil.model.dto.CategoryDTO;
import br.ifpb.iasmim.financafacil.model.dto.UserDTO;
import br.ifpb.iasmim.financafacil.service.CategoryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping()
    public ResponseEntity<CategoryDTO> create(@RequestBody CategoryDTO categoryDTO) {
        
        CategoryService.create(categoryDTO);
        
        return null;
    }
    
}
