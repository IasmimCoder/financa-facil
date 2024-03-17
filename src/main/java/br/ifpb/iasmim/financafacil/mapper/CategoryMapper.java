package br.ifpb.iasmim.financafacil.mapper;

import br.ifpb.iasmim.financafacil.model.Category;
import br.ifpb.iasmim.financafacil.model.User;
import br.ifpb.iasmim.financafacil.model.dto.CategoryDTO;
import br.ifpb.iasmim.financafacil.model.dto.UserDTO;

public class CategoryMapper {


    public Category toEntity(CategoryDTO dto) {
        Category category = new Category();
        category.setId(dto.getId());
        category.setDescription(dto.getDescription());
        category.setName(dto.getName());
        category.setTransactions(dto.getTransactions());

}

}
