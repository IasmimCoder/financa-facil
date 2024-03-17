package br.ifpb.iasmim.financafacil.mapper;

import br.ifpb.iasmim.financafacil.model.Category;
import br.ifpb.iasmim.financafacil.model.dto.CategoryDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryMapper {

    public Category toEntity(CategoryDTO dto){
        Category entity = new Category();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        return entity;
    }

    public CategoryDTO toDto(Category entity){
        CategoryDTO dto = new CategoryDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        return dto;
    }

    public List<CategoryDTO> toListDto(List<Category> listEntity){

        return listEntity.stream()
                .map(entity -> toDto(entity))
                .collect(Collectors.toList());
    }
}
