package com.github.paiaao.gerenciador_estoque.repository;

import com.github.paiaao.gerenciador_estoque.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
