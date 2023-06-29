package com.curso.servicios.impl;

import com.curso.servicios.RespuestaDelServicioDeEmails;
import com.curso.servicios.ServicioDeEmails;
import org.springframework.stereotype.Service;

@Service
public class ServicioDeEmailsImpl implements ServicioDeEmails {
    @Override
    public void enviarEmail(String destinatario, String asunto, String contenido) {
        System.out.println("Enviando email a " + destinatario + " con asunto " + asunto + " y contenido " + contenido);
    }

    @Override
    public RespuestaDelServicioDeEmails hanDeEnviarseEmails() {
        return null;
    }
}
