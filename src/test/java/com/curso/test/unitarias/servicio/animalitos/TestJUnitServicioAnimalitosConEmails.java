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
@ActiveProfiles("pruebas.unitarias.del.servicio.animalitos.emails.si")
@ExtendWith(SpringExtension.class)
// Permite la integración entre cucumber y Spring
@SpringBootTest( classes = AplicacionTest.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestJUnitServicioAnimalitosConEmails {

    private ServicioDeAnimalitos servicioDeAnimalitos;
    private RepositorioDeAnimalitos repositorioDeAnimalitos;

    private ServicioDeEmails servicioDeEmails;

    @Autowired
    public TestJUnitServicioAnimalitosConEmails(ServicioDeEmails servicioDeEmails, RepositorioDeAnimalitos repositorioDeAnimalitos, ServicioDeAnimalitos servicioDeAnimalitos) {
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

    }
}