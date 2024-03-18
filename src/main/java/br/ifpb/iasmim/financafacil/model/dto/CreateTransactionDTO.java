package br.ifpb.iasmim.financafacil.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class CreateTransactionDTO {

    private UUID id;
    private LocalDate date;
    private BigDecimal value;
    private UUID categoryId;
    private UUID userId;

    public CreateTransactionDTO() {
    }

    public CreateTransactionDTO(UUID id, LocalDate date, BigDecimal value, UUID categoryId, UUID userId) {
        this.id = id;
        this.date = date;
        this.value = value;
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

    public UUID getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(UUID categoryId) {
        this.categoryId = categoryId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "TransactionDTO{" +
                "id=" + id +
                ", date=" + date +
                ", value=" + value +
                ", categoryId=" + categoryId +
                ", userId=" + userId +
                '}';
    }
}
