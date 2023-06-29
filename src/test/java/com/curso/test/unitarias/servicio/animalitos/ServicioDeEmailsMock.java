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
@Profile("pruebas.unitarias.del.servicio.animalitos.mock")
@Getter
public class ServicioDeEmailsMock implements ServicioDeEmails {

    private String destinatario;
    private String asunto;
    private String contenido;
    private int llamadas = 0;
    @Override
    public void enviarEmail(String destinatario, String asunto, String contenido) {
        this.destinatario = destinatario;
        this.asunto = asunto;
        this.contenido = contenido;
        if (contenido == null) {
            throw new RuntimeException("No se puede enviar un email sin contenido");
        }
        if (asunto == null) {
            throw new RuntimeException("No se puede enviar un email sin asunto");
        }
        if (destinatario == null) {
            throw new RuntimeException("No se puede enviar un email sin destinatario");
        }
        llamadas++;
    }

    @Override
    public RespuestaDelServicioDeEmails hanDeEnviarseEmails() {
        return null;
    }

    public void verify(String nombre) {
        if (llamadas == 0) {
            throw new RuntimeException("No se llamó al método enviarEmail");
        }
        if (!contenido.contains(nombre)) {
            throw new RuntimeException("El email no es válido. No se incluye el nombre del animalito" + nombre);
        }
    }

}
