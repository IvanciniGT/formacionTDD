package com.curso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Oye spring, mira en el mismo paquete donde está esta clase.. y de paso en los subpaquetes de éste
// Que por ahí te voy dejando el detalle de cómo debe funcionar esta applicación.
@SpringBootApplication
public class Aplicacion {

    public static void main(String[] args){
        // ESTA ES LA INVERSION DE CONTROL
        SpringApplication.run(Aplicacion.class);
    }

}
