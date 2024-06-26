package br.ifpb.iasmim.financafacil.service;

import br.ifpb.iasmim.financafacil.model.Category;
import br.ifpb.iasmim.financafacil.model.dto.CategoryDTO;
import br.ifpb.iasmim.financafacil.repository.CategoryRepository;
import exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifpb.iasmim.financafacil.mapper.CategoryMapper;

import java.util.List;
import java.util.Objects;
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

    public CategoryDTO findById(UUID id) throws Exception {
        Category category = categoryRepository.findById(id)
            .orElseThrow(
                () -> new NotFoundException("Categoria não encontrada com o ID: " + id)
            );

        return categoryMapper.toDto(category);
    }

    public void deleteById(UUID id) {
        categoryRepository.deleteById(id);
    }

  public CategoryDTO updateCategory(UUID id, CategoryDTO updatedCategoryDTO){
    Optional<Category> optionalCategory = categoryRepository.findById(id);
    if (optionalCategory.isPresent()) {
        Category category = optionalCategory.get();

        // Atualize os campos do usuário com os novos valores fornecidos
        category.setName(Objects.requireNonNullElse(updatedCategoryDTO.getName(), category.getName()));
        category.setDescription(Objects.requireNonNullElse(updatedCategoryDTO.getDescription(), category.getDescription()));

        // Salve as alterações no banco de dados
        categoryRepository.save(category);
        return categoryMapper.toDto(category);
    }

        throw new NotFoundException("Category not found with id: " + id);
    }   

}
