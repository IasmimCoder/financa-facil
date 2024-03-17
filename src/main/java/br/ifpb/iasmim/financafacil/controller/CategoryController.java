package br.ifpb.iasmim.financafacil.controller;

import br.ifpb.iasmim.financafacil.model.dto.CategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.ifpb.iasmim.financafacil.service.CategoryService;

import java.util.List;
import java.util.UUID;



@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping()
    public ResponseEntity<CategoryDTO> create(@RequestBody CategoryDTO dto) {
        CategoryDTO createdCategory = categoryService.create(dto);
        return ResponseEntity.created(null).body(createdCategory);
    }

    @GetMapping()
    public ResponseEntity<List<CategoryDTO>> findAll() {
        List<CategoryDTO> categories = categoryService.findAll();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> findById(@PathVariable UUID id) throws Exception {
        CategoryDTO category = categoryService.findById(id);
        return ResponseEntity.ok(category);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id){
        categoryService.deleteById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDTO> updateCategory(@PathVariable UUID id, @RequestBody CategoryDTO updatedCategory){
        CategoryDTO category = categoryService.updateCategory(id, updatedCategory);
        return ResponseEntity.ok(category);
    }


}
