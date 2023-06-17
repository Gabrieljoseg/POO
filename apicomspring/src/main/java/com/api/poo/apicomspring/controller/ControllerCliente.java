package com.api.poo.apicomspring.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

import com.api.poo.apicomspring.exception.EntityAlreadyExistsException;
import com.api.poo.apicomspring.exception.ResourceNotFoundException;
import com.api.poo.apicomspring.model.Cliente;

import jakarta.transaction.Transactional;

public class ControllerCliente {
    private final ServiceCliente serviceCliente;

    public ServiceCliente(ServiceCliente serviceCliente) {
        this.serviceCliente = serviceCliente;
    }

    @GetMapping
    public List<Cliente> getAll() {
        return serviceCliente.getAll();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Cliente> create(@RequestBody @Validated Cliente newCliente, UriComponentsBuilder uriBuilder) throws EntityAlreadyExistsException {
        Cliente cliente = serviceCliente.create(newCliente);
        URI uri = uriBuilder.path("/Cliente/{id}").buildAndExpand(newCliente.getId()).toUri();
        return ResponseEntity.created(uri).body(cliente);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> read(@PathVariable Long id) {
        Optional<Cliente> Cliente = serviceCliente.findById(id);
        return cliente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Cliente> update(@PathVariable Long id, @RequestBody @Validated Cliente newCliente) throws ResourceNotFoundException {
        Cliente cliente = serviceCliente.update(newCliente, id);
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> delete(@PathVariable Long id) throws ResourceNotFoundException {
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
