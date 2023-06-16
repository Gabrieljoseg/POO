package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.api.poo.apicomspring.exception.EntityAlreadyExistsException;
import com.api.poo.apicomspring.exception.ResourceNotFoundException;
import com.api.poo.apicomspring.model.Cliente;
import com.api.poo.apicomspring.repository.RepositoryCliente;

@Service
public class ServiceCliente {
    private final RepositoryCliente customerRepository;

    public ServiceCliente(RepositoryCliente customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Cliente create(Cliente cliente) throws EntityAlreadyExistsException {
        this.findByEmail(cliente.getEmail()).orElseThrow(() -> new EntityAlreadyExistsException(""));
        return this.customerRepository.save(cliente);
    }

    public Optional<Cliente> findById(Long id) {
        return this.customerRepository.findById(id);
    }

    public List<Cliente> getAll() {
        return new ArrayList<>(customerRepository.findAll());

    }

    public Cliente update(Cliente newCliente, Long id) throws ResourceNotFoundException {
        Optional<Cliente> optionalCliente = this.findById(id);
        Cliente cliente = optionalCliente.orElseThrow(() -> new ResourceNotFoundException(""));
        cliente.setEmail(newCliente.getEmail());
        cliente.setName(newCliente.getName());
        return cliente;
    }
    
    public void delete(Long id) throws ResourceNotFoundException {
        Optional<Cliente> optionalCliente = this.findById(id);
        Cliente cliente = optionalCliente.orElseThrow(() -> new ResourceNotFoundException(""));
        this.customerRepository.delete(cliente);
    }

    public Optional<Cliente> findByEmail(String email) {
        return this.customerRepository.findByEmail(email);
    }
}
