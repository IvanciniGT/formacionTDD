package com.curso.test.unitarias.servicio.animalitos;

import com.curso.AplicacionTest;
import com.curso.dtos.DatosAnimalito;
import com.curso.dtos.DatosDeNuevoAnimalito;
import com.curso.repositorios.RepositorioDeAnimalitos;
import com.curso.servicios.ServicioDeAnimalitos;
import com.curso.servicios.ServicioDeEmails;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;


// Que se tome como implementación del ServicioDeEmails, la clase ServicioDeEmailsDummy
@ActiveProfiles("pruebas.unitarias.del.servicio.animalitos")
@ExtendWith(SpringExtension.class)
// Permite la integración entre cucumber y Spring
@SpringBootTest( classes = AplicacionTest.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestJUnitServicioAnimalitos {

    private ServicioDeAnimalitos servicioDeAnimalitos;
    private RepositorioDeAnimalitos repositorioDeAnimalitos;

    private ServicioDeEmails servicioDeEmails;

    @Autowired
    public TestJUnitServicioAnimalitos(ServicioDeEmails servicioDeEmails, RepositorioDeAnimalitos repositorioDeAnimalitos, ServicioDeAnimalitos servicioDeAnimalitos) {
        this.repositorioDeAnimalitos = repositorioDeAnimalitos;
        this.servicioDeAnimalitos = servicioDeAnimalitos;
        this.servicioDeEmails = servicioDeEmails;
    }

    @Test
    public void pruebaAltaAnimalitoConEnvioDeEmail() {
        // Punto de partida
        repositorioDeAnimalitos.deleteAll();

        DatosDeNuevoAnimalito animalito = new DatosDeNuevoAnimalito();
        animalito.setNombre("Firulais");
        animalito.setTipo("Perro");
        animalito.setColor("Cafe");
        animalito.setEdad(3);

        // Trabajo de la prueba
        DatosAnimalito nuevoAnimalito = servicioDeAnimalitos.altaDeAnimalito(animalito);

        // Comprobaciones
        Assertions.assertNotNull(nuevoAnimalito.getId());
        Assertions.assertEquals(animalito.getNombre(), nuevoAnimalito.getNombre());
        Assertions.assertEquals(animalito.getTipo(), nuevoAnimalito.getTipo());
        Assertions.assertEquals(animalito.getColor(), nuevoAnimalito.getColor());
        Assertions.assertEquals(animalito.getEdad(), nuevoAnimalito.getEdad());

        // Que se pidió enviar un email al Servicio de Emails
        // No lo estamos comprobando con el Dummy
        // Pero lo podríamos comprobar si implementásemos un Spy o un Mock
        //ServicioDeEmailsSpy servicioDeEmailsSpy = (ServicioDeEmailsSpy) servicioDeEmails;
        //Assertions.assertEquals(1, servicioDeEmailsSpy.getLlamadas());
        //Assertions.assertTrue(servicioDeEmailsSpy.getContenido().contains("Firulais"));
        //Assertions.assertEquals("Alta de animalito",servicioDeEmailsSpy.getAsunto());
        //Assertions.assertEquals("destinatiario@prueba.com",servicioDeEmailsSpy.getDestinatario());
        ServicioDeEmailsMock servicioDeEmailsMock = (ServicioDeEmailsMock) servicioDeEmails;
        servicioDeEmailsMock.verify("Firulais");
    }
}