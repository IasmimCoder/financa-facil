package br.ifpb.iasmim.financafacil.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class TransactionDTO {

    private UUID id;
    private LocalDate date;
    private BigDecimal value;
    private String type;
    private UUID categoryId;
    private UUID userId;

    public TransactionDTO() {
    }

    public TransactionDTO(UUID id, LocalDate date, BigDecimal value, String type, UUID categoryId, UUID userId) {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
                ", type='" + type + '\'' +
                ", categoryId=" + categoryId +
                ", userId=" + userId +
                '}';
    }
}
