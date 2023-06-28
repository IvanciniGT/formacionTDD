package com.curso.dtos;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class DatosAnimalito extends DatosDeNuevoAnimalito{ //AnimalitoDto
    private Long id;
}
