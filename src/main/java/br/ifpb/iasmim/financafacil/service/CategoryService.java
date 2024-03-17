package br.ifpb.iasmim.financafacil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifpb.iasmim.financafacil.mapper.CategoryMapper;
import br.ifpb.iasmim.financafacil.model.Category;
import br.ifpb.iasmim.financafacil.model.dto.CategoryDTO;

@Service
public class CategoryService {

    @Autowired
    CategoryService categoryService;

    @Autowired
    CategoryMapper categoryMapper;

    public static void create(CategoryDTO categoryDTO) {
        
       Category category = categoryMapper.toEntity(categoryDTO);

       
    }

}
