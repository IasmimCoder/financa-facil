package br.ifpb.iasmim.financafacil.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.ifpb.iasmim.financafacil.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID>{

}
