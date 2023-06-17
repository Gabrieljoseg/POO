package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.api.poo.apicomspring.exception.ResourceNotFoundException;
import com.api.poo.apicomspring.repository.RepositoryProduto;

import jakarta.transaction.Transactional;

@Service
public class ServiceProduto {
    private final RepositoryProduto repositoryProduto;

    public ServiceProduto(RepositoryProduto repositoryProduto) {
        this.repositoryProduto = repositoryProduto;
    }

    public Produto create(Produto produto) {
        return this.repositoryProduto.save(produto);
    }

    public Optional<Produto> findById(Long id) {
        return this.repositoryProduto.findById(id);
    }

    public List<Produto> getAll() {
        return new ArrayList<>(repositoryProduto.findAll());
    }

    public Produto update(Produto newProduto, Long id) throws ResourceNotFoundException {
        Optional<Produto> optionalProduto = this.findById(id);
        Produto produto = optionalProduto.orElseThrow(() -> new ResourceNotFoundException(""));
        produto.setTitle(newProduto.getTitle());
        produto.setPrice(newProduto.getPrice());
        return produto;
    }

    @Transactional
    public void delete(Long id) throws ResourceNotFoundException {
        Optional<Produto> optionalProduto = this.findById(id);
        Produto produto = optionalProduto.orElseThrow(() -> new ResourceNotFoundException(""));
        this.repositoryProduto.delete(produto);
    }
}
