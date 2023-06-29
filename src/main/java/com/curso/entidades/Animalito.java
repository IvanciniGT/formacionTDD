package com.curso.entidades;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(
        name ="Animalitos"
)
public class Animalito {

    @Column( nullable = false)
    private String nombre;

    @Column(updatable=false, nullable = false)
    private String tipo;

    private String color;

    private Integer edad;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
