package com.curso.test.unitarias.repositorio;

import com.curso.entidades.Animalito;
import com.curso.repositorios.RepositorioDeAnimalitos;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.curso.AplicacionTest;

@ExtendWith(SpringExtension.class)
// Permite la integración entre cucumber y Spring
@SpringBootTest( classes = AplicacionTest.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestJUnitRepositorioAnimalitos {

    private final RepositorioDeAnimalitos repositorioDeAnimalitos;

    // Ese argumento del contructor no es por un TEST PARAMETRIZADO de JUNIT... sino que es de SPRING
    @Autowired
    public TestJUnitRepositorioAnimalitos(RepositorioDeAnimalitos repositorioDeAnimalitos){
        this.repositorioDeAnimalitos = repositorioDeAnimalitos;
    }
    @Test
    public void probarAltaAnimalito(){
        String nombre = "Lucas";
        int edad = 3;
        String tipo = "Perrito";
        String color = "Canelita";

        Animalito miAnimalito = new Animalito();
        miAnimalito.setNombre(nombre);
        miAnimalito.setEdad(edad);
        miAnimalito.setTipo(tipo);
        miAnimalito.setColor(color);

        Animalito miAnimalitoDevuelto = repositorioDeAnimalitos.save(miAnimalito);

        Assertions.assertNotNull(miAnimalitoDevuelto.getId());
        Assertions.assertEquals(nombre, miAnimalitoDevuelto.getNombre());
        Assertions.assertEquals(edad, miAnimalitoDevuelto.getEdad());
        Assertions.assertEquals(tipo, miAnimalitoDevuelto.getTipo());
        Assertions.assertEquals(color, miAnimalitoDevuelto.getColor());


        //System.out.println("El id del animalito es: " + miAnimalito.getId());
        //System.out.println("El animalito es: " + miAnimalito);
    }
    @Test
    public void probarAltaAnimalitoSinColor(){
        String nombre = "Lucas";
        int edad = 3;
        String tipo = "Perrito";

        Animalito miAnimalito = new Animalito();
        miAnimalito.setNombre(nombre);
        miAnimalito.setEdad(edad);
        miAnimalito.setTipo(tipo);

        Animalito miAnimalitoDevuelto = repositorioDeAnimalitos.save(miAnimalito);

        Assertions.assertNotNull(miAnimalitoDevuelto.getId());
        Assertions.assertEquals(nombre, miAnimalitoDevuelto.getNombre());
        Assertions.assertEquals(edad, miAnimalitoDevuelto.getEdad());
        Assertions.assertEquals(tipo, miAnimalitoDevuelto.getTipo());
        Assertions.assertNull( miAnimalitoDevuelto.getColor());

    }
    @Test
    public void probarAltaAnimalitoSinTipo(){
        String nombre = "Lucas";
        int edad = 3;
        String color = "Canelita";

        Animalito miAnimalito = new Animalito();
        miAnimalito.setNombre(nombre);
        miAnimalito.setEdad(edad);
        miAnimalito.setColor(color);

        Assertions.assertThrows(Exception.class, () -> {
            repositorioDeAnimalitos.save(miAnimalito);
        });

    }
    @Test
    public void probarAltaAnimalitoSinNombre(){
        String tipo = "Chihuahua";
        int edad = 3;
        String color = "Canelita";

        Animalito miAnimalito = new Animalito();
        miAnimalito.setTipo(tipo);
        miAnimalito.setEdad(edad);
        miAnimalito.setColor(color);

        Assertions.assertThrows(Exception.class, () -> {
            repositorioDeAnimalitos.save(miAnimalito);
        });

    }
    @Test
    public void probarAltaAnimalitoSinEdad(){
        String nombre = "Lucas";
        String tipo = "Chihuahua";
        String color = "Canelita";

        Animalito miAnimalito = new Animalito();
        miAnimalito.setNombre(nombre);
        miAnimalito.setTipo(tipo);
        miAnimalito.setColor(color);
        Animalito miAnimalitoDevuelto = repositorioDeAnimalitos.save(miAnimalito);

        Assertions.assertNotNull(miAnimalitoDevuelto.getId());
        Assertions.assertEquals(nombre, miAnimalitoDevuelto.getNombre());
        Assertions.assertNull( miAnimalitoDevuelto.getEdad());
        Assertions.assertEquals(tipo, miAnimalitoDevuelto.getTipo());
        Assertions.assertEquals(color, miAnimalitoDevuelto.getColor());
    }

}
