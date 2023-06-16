package com.api.poo.apicomspring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryListadeDesejos<ListadeDesejos> extends JpaRepository<ListadeDesejos, Long> {
    Optional<ListadeDesejos> findByClienteId(Long clienteId);
}
