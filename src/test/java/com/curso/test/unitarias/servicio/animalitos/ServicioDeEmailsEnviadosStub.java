package com.curso.test.unitarias.servicio.animalitos;

import com.curso.servicios.RespuestaDelServicioDeEmails;
import com.curso.servicios.ServicioDeEmails;
import lombok.Getter;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Primary
@Profile("pruebas.unitarias.del.servicio.animalitos.emails.si")
@Getter
@Service
public class ServicioDeEmailsEnviadosStub implements ServicioDeEmails {
    @Override
    public void enviarEmail(String destinatario, String asunto, String contenido) {
    }

    @Override
    public RespuestaDelServicioDeEmails hanDeEnviarseEmails() {
        RespuestaDelServicioDeEmails respuesta = new RespuestaDelServicioDeEmails();
        respuesta.setHayQueEnviar(true);
        respuesta.setSeguroQueNoHayQueEnviar(true);
        return respuesta;
    }
}
