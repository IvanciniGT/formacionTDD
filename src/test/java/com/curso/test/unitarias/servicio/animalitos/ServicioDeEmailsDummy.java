package com.curso.test.unitarias.servicio.animalitos;
import com.curso.servicios.RespuestaDelServicioDeEmails;
import com.curso.servicios.ServicioDeEmails;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

// Le indica a Spring, que cuando alguien pida un ServicioDeEmail,
// le entregue una instancia de esta clase
@Service
@Primary
@Profile("pruebas.unitarias.del.servicio.animalitos.dummy")
public class ServicioDeEmailsDummy  implements ServicioDeEmails {

    @Override
    public void enviarEmail(String destinatario, String asunto, String contenido) {
        // Nada!
    }

    @Override
    public RespuestaDelServicioDeEmails hanDeEnviarseEmails() {
        return null;
    }
}
