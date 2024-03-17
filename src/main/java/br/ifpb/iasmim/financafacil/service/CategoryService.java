package br.ifpb.iasmim.financafacil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifpb.iasmim.financafacil.mapper.CategoryMapper;

@Service
public class CategoryService {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryMapper categoryMapper;

}
