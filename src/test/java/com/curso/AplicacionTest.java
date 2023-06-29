package com.curso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

// Oye spring, mira en el mismo paquete donde está esta clase.. y de paso en los subpaquetes de éste
// Que por ahí te voy dejando el detalle de cómo debe funcionar esta applicación.
@SpringBootApplication
@ComponentScan("com.curso")
@EntityScan(basePackages = {"com.curso"})
@EnableJpaRepositories(basePackages = {"com.curso"})
public class AplicacionTest {
}
