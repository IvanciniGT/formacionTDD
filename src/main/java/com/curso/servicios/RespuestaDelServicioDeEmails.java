package com.curso.servicios;

import lombok.Data;

@Data
public class RespuestaDelServicioDeEmails {

    private boolean hayQueEnviar;

    private boolean seguroQueNoHayQueEnviar;
}
