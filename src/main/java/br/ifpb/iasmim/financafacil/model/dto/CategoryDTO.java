package br.ifpb.iasmim.financafacil.model.dto;

import java.util.UUID;


import br.ifpb.iasmim.financafacil.model.enums.CategoryType;
import java.util.Objects;

public class CategoryDTO {

    private UUID id;
    private String name;
    private String description;
    private CategoryType type;


    public CategoryDTO() {
    }

    public CategoryDTO(UUID id, String name, String description, CategoryType type) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CategoryType getType() {
        return this.type;
    }

    public void setType(CategoryType type) {
        this.type = type;
    }



    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CategoryDTO)) {
            return false;
        }
        CategoryDTO categoryDTO = (CategoryDTO) o;
        return Objects.equals(id, categoryDTO.id) && Objects.equals(name, categoryDTO.name) && Objects.equals(description, categoryDTO.description) && Objects.equals(type, categoryDTO.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, type);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", description='" + getDescription() + "'" +
            ", type='" + getType() + "'" +
            "}";
    }

}
