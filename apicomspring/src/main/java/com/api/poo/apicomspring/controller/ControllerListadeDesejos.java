package com.api.poo.apicomspring.controller;

import java.net.URI;
import java.util.Optional;
import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.api.poo.apicomspring.exception.ResourceNotFoundException;
import com.service.serviceListadeDesejos;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/listadeDesejos")
public class ControllerListadeDesejos {
    private final ServiceListadeDesejos serviceListadeDesejos;

    public ControllerListadeDesejos(ServiceListadeDesejos serviceListadeDesejos) {
        this.serviceListadeDesejos = serviceListadeDesejos;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ListadeDesejos> create(@RequestBody @Valid ListadeDesejos newlistadeDesejos, UriComponentsBuilder uriBuilder) {
        ListadeDesejos listadeDesejos = serviceListadeDesejos.create(newlistadeDesejos);
        URI uri = uriBuilder.path("/listadeDesejos/{id}").buildAndExpand(newlistadeDesejos.getId()).toUri();
        return ResponseEntity.created(uri).body(listadeDesejos);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<ListadeDesejos> read(@PathVariable Long clienteId) {
        Optional<ListadeDesejos> ListadeDesejos = serviceListadeDesejos.findByCustomerId(clienteId);
        return listadeDesejos.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ListadeDesejos> addProduct(@PathVariable Long id, @RequestBody @Valid Set<Produto> newProducts) throws ResourceNotFoundException {
        ListadeDesejos listadeDesejos = serviceListadeDesejos.addProduct(newProducts, id);
        return ResponseEntity.ok(listadeDesejos);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> delete(@PathVariable Long id){
        serviceListadeDesejos.delete(id);
        return ResponseEntity.noContent().build();
    }
}
