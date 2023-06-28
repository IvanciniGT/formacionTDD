package com.curso.servicios;

import com.curso.dtos.DatosAnimalito;
import com.curso.dtos.DatosDeNuevoAnimalito;

public interface ServicioDeAnimalitos {

    DatosAnimalito altaDeAnimalito(DatosDeNuevoAnimalito animalito);

}
