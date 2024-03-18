package br.ifpb.iasmim.financafacil.repository;

import br.ifpb.iasmim.financafacil.model.Transaction;
import br.ifpb.iasmim.financafacil.model.enums.TransactionType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * @Query: Esta anotação indica que você está definindo uma consulta JPQL personalizada.

 * "SELECT t FROM Transaction t WHERE EXTRACT(MONTH FROM t.date) = :month AND t.type = :type": Esta é a consulta JPQL em si. Ela seleciona todas as transações onde o mês da data da transação é igual ao mês fornecido como parâmetro (:month) e o tipo de transação é igual ao tipo fornecido como parâmetro (:type).

* t: é um alias para a entidade Transaction. Isso permite que você se refira à entidade Transaction na consulta.

* EXTRACT(MONTH FROM t.date) = :month: Aqui, usamos a função EXTRACT para extrair o mês da data da transação (t.date) e comparamos com o mês fornecido como parâmetro.

* t.type = :type: Aqui, comparamos o tipo da transação (t.type) com o tipo fornecido como parâmetro.

* List<Transaction>: Este método retorna uma lista de objetos Transaction que correspondem aos critérios da consulta.

* findByMonthAndType(@Param("month") int month, @Param("type") TransactionType type): Este é o método do repositório. Ele recebe dois parâmetros:

   * month: O mês para filtrar as transações.
   * type: O tipo de transação para filtrar as transações.
   * Esses parâmetros são passados para a consulta JPQL como parâmetros nomeados :month e :type respectivamente.
 */

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, UUID> {

    @Query("SELECT t FROM Transaction t WHERE EXTRACT(MONTH FROM t.date) = :month AND EXTRACT(YEAR FROM t.date) = :year AND t.type = :type AND t.user.id = :userId")
    List<Transaction> findByMonthAndYearAndType(
        @Param("month") int month,
        @Param("year") int year,
        @Param("type") TransactionType type,
        @Param("userId") UUID userId
    );

    @Query("SELECT t FROM Transaction t WHERE EXTRACT(MONTH FROM t.date) = :month AND EXTRACT(YEAR FROM t.date) = :year AND t.user.id = :userId")
    List<Transaction> findByUserIdAndMonthAndYear(
        @Param("month") int month,
        @Param("year") int year,
        @Param("userId") UUID userId
    );
}
