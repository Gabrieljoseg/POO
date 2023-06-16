package com.api.poo.apicomspring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.poo.apicomspring.model.Cliente;

public interface RepositoryCliente extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByEmail(String email);
}