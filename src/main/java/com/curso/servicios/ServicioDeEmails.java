package com.curso.servicios;

public interface ServicioDeEmails {

    void enviarEmail(String destinatario, String asunto, String contenido);

    RespuestaDelServicioDeEmails hanDeEnviarseEmails();

}
