package br.ifpb.iasmim.financafacil.model.dto;

import br.ifpb.iasmim.financafacil.model.Category;
import br.ifpb.iasmim.financafacil.model.User;
import br.ifpb.iasmim.financafacil.model.enums.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class TransactionDTO {

    private UUID id;
    private LocalDate date;
    private BigDecimal value;
    private TransactionType type;
    private Category categoryId;
    private User userId;

    public TransactionDTO() {
    }

    public TransactionDTO(UUID id, LocalDate date, BigDecimal value, TransactionType type, Category categoryId, User userId) {
        this.id = id;
        this.date = date;
        this.value = value;
        this.type = type;
        this.categoryId = categoryId;
        this.userId = userId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "TransactionDTO{" +
                "id=" + id +
                ", date=" + date +
                ", value=" + value +
                ", type='" + type + '\'' +
                ", categoryId=" + categoryId +
                ", userId=" + userId +
                '}';
    }
}
