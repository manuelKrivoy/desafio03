package com.example.clienteApiRest.controllers;

import com.example.clienteApiRest.Service.ClienteService;
import com.example.clienteApiRest.models.Cliente;
import com.example.clienteApiRest.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
public class ClienteController { //En la clase controller solo determinaremos los endpoints
    @Autowired
    private ClienteService clienteService;

    @GetMapping //determino path de endpoint y es solititud get
    public String index() {
        return "Conectado";
    }

    @GetMapping("clientes")
    public List<Cliente> getClientes() {
        return clienteService.getClientes(); //llama a capa service para que implemente la lógica solicitada
    }


    @PostMapping("alta")
    public String post(@RequestBody Cliente cliente) {
        return clienteService.post(cliente);
    }

    @GetMapping("cliente/{id}")
    public ResponseEntity<?> getClienteById(@PathVariable Long id) { //se define la funcion de tipo ResponseEntity porque no se sabe que va a retornar, depende de si existe el ID o no.
    return clienteService.getClienteById(id);
    }

    @GetMapping("edad/{id}")
    public ResponseEntity<?> getEdadCliente(@PathVariable Long id) {
        return clienteService.getEdadCliente(id);
    }


}


