package br.ifpb.iasmim.financafacil.repository;

import br.ifpb.iasmim.financafacil.model.Transaction;
import br.ifpb.iasmim.financafacil.model.enums.CategoryType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public interface TransactionRepository extends JpaRepository<Transaction, UUID> {

    @Query("SELECT t FROM Transaction t WHERE EXTRACT(MONTH FROM t.date) = :month AND EXTRACT(YEAR FROM t.date) = :year AND t.category.type = :type AND t.user.id = :userId")
    List<Transaction> findByMonthAndYearAndType(
        @Param("month") int month,
        @Param("year") int year,
        @Param("type") CategoryType type,
        @Param("userId") UUID userId
    );

    @Query("SELECT t FROM Transaction t WHERE EXTRACT(MONTH FROM t.date) = :month AND EXTRACT(YEAR FROM t.date) = :year AND t.user.id = :userId")
    List<Transaction> findByUserIdAndMonthAndYear(
        @Param("month") int month,
        @Param("year") int year,
        @Param("userId") UUID userId
    );
}
