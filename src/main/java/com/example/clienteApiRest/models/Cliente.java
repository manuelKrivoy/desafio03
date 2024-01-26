package com.example.clienteApiRest.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;


//Defino la entidad Cliente, con sus atributos
@Entity //configuramos para que sea una Entity
@Data //uso lombok para no tener que escribir los getters y setters
public class Cliente {

    @Id //Marco que es el id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column()
    private String name;

    @Column()
    private String surname;

    @Column(name="fecha_de_nacimiento")
    private LocalDate fechaDeNacimiento;


}

