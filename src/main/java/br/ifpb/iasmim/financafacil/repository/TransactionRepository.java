package br.ifpb.iasmim.financafacil.repository;

import br.ifpb.iasmim.financafacil.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface TransactionRepository extends JpaRepository<Transaction, UUID> {

}
