package com.curso.repositorios;

import com.curso.entidades.Animalito;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioDeAnimalitos extends JpaRepository<Animalito, Long> {

}
