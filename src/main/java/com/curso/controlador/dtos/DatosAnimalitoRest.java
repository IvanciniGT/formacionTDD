package com.curso.controlador.dtos;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class DatosAnimalitoRest extends DatosDeNuevoAnimalitoRest { //AnimalitoDto
    private Long id;
}
