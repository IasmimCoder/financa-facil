package br.ifpb.iasmim.financafacil.service;

import br.ifpb.iasmim.financafacil.model.Category;
import br.ifpb.iasmim.financafacil.model.User;
import br.ifpb.iasmim.financafacil.model.dto.CategoryDTO;
import br.ifpb.iasmim.financafacil.model.dto.UserDTO;
import br.ifpb.iasmim.financafacil.repository.CategoryRepository;
import exceptions.CategoryNotFoundException;
import exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifpb.iasmim.financafacil.mapper.CategoryMapper;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper categoryMapper;

    public CategoryDTO create(CategoryDTO dto){

        Category entity = categoryMapper.toEntity(dto);
        Category createdEntity = categoryRepository.save(entity);
        CategoryDTO createdDTO = categoryMapper.toDto(createdEntity);
        return  createdDTO;
    }

    public List<CategoryDTO> findAll(){
        List<Category> categories = categoryRepository.findAll();
        return categoryMapper.toListDto(categories);
    }

    public CategoryDTO findById(UUID id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if(optionalCategory.isPresent()){
            return categoryMapper.toDto(optionalCategory.get());
        }

        return null;
    }

    public void deleteById(UUID id) {
        categoryRepository.deleteById(id);
    }

    public CategoryDTO updateCategory(UUID id, CategoryDTO updatedCategoryDTO){

        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent()) {
            Category category = optionalCategory.get();

            // Atualize os campos do usuário com os novos valores fornecidos
            category.setName(updatedCategoryDTO.getName());
            category.setDescription(updatedCategoryDTO.getDescription());

            // Salve as alterações no banco de dados
            categoryRepository.save(category);
            return categoryMapper.toDto(category);
        }

        throw new CategoryNotFoundException("");
    }

}
