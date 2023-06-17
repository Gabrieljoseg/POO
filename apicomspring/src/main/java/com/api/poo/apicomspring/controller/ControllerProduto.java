package com.api.poo.apicomspring.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

import com.api.poo.apicomspring.exception.ResourceNotFoundException;
import com.service.ServiceProduto;

import jakarta.transaction.Transactional;

public class ControllerProduto {
    private final ServiceProduto Produto;
    public ControllerProduto(ServiceProduto serviceProduto) {
        this.serviceProduto = serviceProduto;
    }

    @GetMapping
    public List<Produto> getAll() {
        return serviceProduto.getAll();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Produto> create(@RequestBody @Valid Produto newProduto, UriComponentsBuilder uriBuilder) {
        Produto produto = serviceProduto.create(newProduto);
        URI uri = uriBuilder.path("/produto/{id}").buildAndExpand(newProduto.getId()).toUri();
        return ResponseEntity.created(uri).body(produto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> read(@PathVariable Long id) {
        Optional<Produto> produto = serviceProduto.findById(id);
        return produto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Produto> update(@PathVariable Long id, @RequestBody @Valid Produto newProduto) throws ResourceNotFoundException {
        Produto produto = serviceProduto.update(newProduto, id);
        return ResponseEntity.ok(produto);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> delete(@PathVariable Long id) throws ResourceNotFoundException {
        serviceProduto.delete(id);
        return ResponseEntity.noContent().build();
    }
}
