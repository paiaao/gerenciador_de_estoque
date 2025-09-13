package com.github.paiaao.gerenciador_estoque.controller;

import com.github.paiaao.gerenciador_estoque.model.Produto;
import com.github.paiaao.gerenciador_estoque.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/produtos")

public class ProdutoController {

    @Autowired

    private ProdutoRepository repositorio;

    @PostMapping

    public Produto criar(@RequestBody Produto produto) {

        return repositorio.save(produto);

    }

    @GetMapping

    public List listar() {

        return repositorio.findAll();

    }

    @GetMapping("/{id}")

    public ResponseEntity buscar(@PathVariable Long id) {

        return repositorio.findById(id)

                .map(ResponseEntity::ok)

                .orElse(ResponseEntity.notFound().build());

    }

    @PutMapping("/{id}")

    public ResponseEntity atualizar(@PathVariable Long id, @RequestBody Produto produto) {

        return repositorio.findById(id).map(existente -> {

            produto.setId(id);

            return ResponseEntity.ok(repositorio.save(produto));

        }).orElse(ResponseEntity.notFound().build());

    }

    @DeleteMapping("/{id}")

    public ResponseEntity deletar(@PathVariable Long id) {

        if (repositorio.existsById(id)) {

            repositorio.deleteById(id);

            return ResponseEntity.noContent().build();

        }

        return ResponseEntity.notFound().build();

    }

}