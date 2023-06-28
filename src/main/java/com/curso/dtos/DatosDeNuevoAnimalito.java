package com.curso.dtos;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class DatosDeNuevoAnimalito extends DatosParaModificarAnimalito{
    private String tipo;
}
