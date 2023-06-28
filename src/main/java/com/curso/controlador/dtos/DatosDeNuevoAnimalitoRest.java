package com.curso.controlador.dtos;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class DatosDeNuevoAnimalitoRest extends DatosParaModificarAnimalitoRest {
    private String tipo;
}
