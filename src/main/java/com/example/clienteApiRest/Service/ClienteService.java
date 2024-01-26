package com.example.clienteApiRest.Service;

import com.example.clienteApiRest.models.Cliente;
import com.example.clienteApiRest.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Service
public class ClienteService { //la capa service implementa todo la lógica de la información recibida del controller y la trabaja para retornar lo pedido
    @Autowired
    private ClienteRepository repoCliente;
    public List<Cliente> getClientes(){
        return repoCliente.findAll();
    };


    public String post(Cliente cliente) {
        repoCliente.save(cliente);
        return "Cliente guardado";
    };

    public ResponseEntity<?> getClienteById(Long id) { //se define la funcion de tipo ResponseEntity porque no se sabe que va a retornar, depende de si existe el ID o no.
        Optional<Cliente> optionalCliente = repoCliente.findById(id);

        if (optionalCliente.isPresent()) {
            return ResponseEntity.ok(optionalCliente.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El id no existe");
        }
    }

    public ResponseEntity<?> getEdadCliente(Long id) {
        Optional<Cliente> optionalCliente = repoCliente.findById(id);

        if (optionalCliente.isPresent()) {
            Cliente cliente = optionalCliente.get();
            Long edad = ChronoUnit.YEARS.between(cliente.getFechaDeNacimiento(), LocalDate.now()); //calculo edad con libreria ChronoUnit

            // Se crea un mapa para almacenar la información del cliente formateada
            // Se utiliza LinkedHashMap para mantener el orden de inserción
            Map<String, Object> clienteFormateado = new LinkedHashMap<>();
            clienteFormateado.put("id", cliente.getId());
            clienteFormateado.put("name", cliente.getName());
            clienteFormateado.put("surname", cliente.getSurname());
            clienteFormateado.put("edad", edad);

            // Se devuelve una respuesta HTTP 200 (OK) con la información del cliente formateada en JSON
            return ResponseEntity.ok(clienteFormateado); // El mapa se crea porque para que retorne un JSON hay que pasarle un objeto
        } else {
            // Si el cliente no existe, se devuelve una respuesta HTTP 404 (NOT FOUND)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El id no existe");
        }
    }

}

