package com.curso.test.unitarias.servicio.animalitos;
import com.curso.servicios.RespuestaDelServicioDeEmails;
import com.curso.servicios.ServicioDeEmails;
import lombok.Getter;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

// Le indica a Spring, que cuando alguien pida un ServicioDeEmail,
// le entregue una instancia de esta clase
@Service
@Primary
@Profile("pruebas.unitarias.del.servicio.animalitos.spy")
@Getter
public class ServicioDeEmailsSpy implements ServicioDeEmails {

    @Getter
    private String destinatario;
    @Getter
    private String asunto;
    @Getter
    private String contenido;
    @Getter
    private int llamadas = 0;
    @Override
    public void enviarEmail(String destinatario, String asunto, String contenido) {
        this.destinatario = destinatario;
        this.asunto = asunto;
        this.contenido = contenido;
        llamadas++;
    }

    @Override
    public RespuestaDelServicioDeEmails hanDeEnviarseEmails() {
        return null;
    }

}
