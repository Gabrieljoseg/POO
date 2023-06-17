package com.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.api.poo.apicomspring.exception.ResourceNotFoundException;
import com.api.poo.apicomspring.repository.RepositoryListadeDesejos;

@Service
public class ServiceListadeDesejos<ListadeDesejos> {
    private final RepositoryListadeDesejos repositoryListadeDesejos;

    public ServiceListaDeDesejos(RepositoryListadeDesejos repositoryListadeDesejos) {
        this.repositoryListadeDesejos = repositoryListadeDesejos;
    }
    public ListadeDesejos create(ListadeDesejos listadeDesejos) {
        return this.repositoryListadeDesejos.save(listadeDesejos);
    }

    public Optional<ListadeDesejos> findByClienteId(Long clienteId) {
        return this.repositoryListadeDesejos.findByClienteId(clienteId);
    }

    public ListadeDesejos addProduto(Set<Produto> newProduto, Long id) throws ResourceNotFoundException {
        ListadeDesejos listadeDesejos = this.repositoryListadeDesejos.findById(id).orElseThrow(() -> new ResourceNotFoundException(""));
        listadeDesejos.getProduto().addAll(newProduto);
        return listadeDesejos;
    }

    public void delete(Long id) {
        Object listadeDesejos = this.repositoryListadeDesejos.getOne(id);
        this.repositoryListadeDesejos.delete(listadeDesejos);
    }
}