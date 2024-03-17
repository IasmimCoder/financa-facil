package br.ifpb.iasmim.financafacil.model.dto;

import java.util.List;
import java.util.UUID;

public class CategoryDTO {

    private UUID id;
    private String name;
    private String description;
    private List<TransactionDTO> transactions;

    public CategoryDTO() {
    }

    public CategoryDTO(UUID id, String name, String description, List<TransactionDTO> transactions) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.transactions = transactions;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<TransactionDTO> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<TransactionDTO> transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return "CategoryDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", transactions=" + transactions +
                '}';
    }
}
