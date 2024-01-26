package com.example.clienteApiRest.repository;

import com.example.clienteApiRest.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {

}

