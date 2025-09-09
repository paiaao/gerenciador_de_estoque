package com.github.paiaao.gerenciador_estoque.repository;

import com.github.paiaao.gerenciador_estoque.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}