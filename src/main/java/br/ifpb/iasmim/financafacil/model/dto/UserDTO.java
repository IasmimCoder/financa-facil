package br.ifpb.iasmim.financafacil.model.dto;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.ifpb.iasmim.financafacil.model.Transaction;
import java.util.Objects;


public class UserDTO {

    private UUID id;

    private String name;
    private String email;

    @JsonIgnore
    private String password;

    private List<Transaction> transactions;


    public UserDTO() {
    }

    public UserDTO(UUID id, String name, String email, String password, List<Transaction> transactions) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.transactions = transactions;
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

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Transaction> getTransactions() {
        return this.transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UserDTO)) {
            return false;
        }
        UserDTO userDTO = (UserDTO) o;
        return Objects.equals(id, userDTO.id) && Objects.equals(name, userDTO.name) && Objects.equals(email, userDTO.email) && Objects.equals(password, userDTO.password) && Objects.equals(transactions, userDTO.transactions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, password, transactions);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", email='" + getEmail() + "'" +
            ", password='" + getPassword() + "'" +
            ", transactions='" + getTransactions() + "'" +
            "}";
    }
    
}