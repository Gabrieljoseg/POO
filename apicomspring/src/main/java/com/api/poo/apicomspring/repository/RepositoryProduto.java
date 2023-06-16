package com.api.poo.apicomspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryProduto<Producto, Produto> extends JpaRepository<Produto, Long> {
}