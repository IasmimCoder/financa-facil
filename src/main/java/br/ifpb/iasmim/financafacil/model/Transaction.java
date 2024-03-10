package br.ifpb.iasmim.financafacil.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;


import br.ifpb.iasmim.financafacil.model.enums.TransactionType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "tb_transaction")
public class Transaction {

    @Id
	@GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private LocalDate date;
    private BigDecimal value;

    @Enumerated(EnumType.STRING)
    private TransactionType type;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    public Transaction() {
    }

    public Transaction(UUID id, LocalDate date, BigDecimal value, TransactionType type) {
        this.id = id;
        this.date = date;
        this.value = value;
        this.type = type;
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public BigDecimal getValue() {
        return this.value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public TransactionType getType() {
        return this.type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Transaction)) {
            return false;
        }
        Transaction transaction = (Transaction) o;
        return Objects.equals(id, transaction.id) && Objects.equals(date, transaction.date) && Objects.equals(value, transaction.value) && Objects.equals(type, transaction.type) && Objects.equals(category, transaction.category) && Objects.equals(user, transaction.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, value, type, category, user);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", date='" + getDate() + "'" +
            ", value='" + getValue() + "'" +
            ", type='" + getType() + "'" +
            ", category='" + getCategory() + "'" +
            ", user='" + getUser() + "'" +
            "}";
    }
    
}
