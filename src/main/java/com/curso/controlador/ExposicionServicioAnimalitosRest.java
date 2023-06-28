package com.curso.controlador;

import com.curso.controlador.dtos.DatosAnimalitoRest;
import com.curso.controlador.dtos.DatosDeNuevoAnimalitoRest;

public interface ExposicionServicioAnimalitosRest {

    DatosAnimalitoRest altaDeAnimalito(DatosDeNuevoAnimalitoRest animalito);

}
