package com.curso.test.unitarias.repositorio;

import com.curso.AplicacionTest;
import com.curso.entidades.Animalito;
import com.curso.repositorios.RepositorioDeAnimalitos;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

// Le dice a Java que esta clase, contiene pruebas que son procesadas a través de la plataforma JUnit
@Suite
// Las pruebas las hemos definido a través de Cucumber...
@IncludeEngines("cucumber")
// JUNIT: En la carpeta features están los ficheros .feature... para que se los pases al cucumber
@SelectClasspathResource("unitarias/repositorio")
// JUnit: Este fichero, una instgancia de él para trabajar, creala a través de Spring
@ExtendWith(SpringExtension.class)
// Permite la integración entre cucumber y Spring
@CucumberContextConfiguration
// Esto me da un cliente para atacar por http a mi servidor de test
//Esto me monta un tomcat con mi app despliegada y sus microservicios
@SpringBootTest( classes = AplicacionTest.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RepositorioDeAnimalitosCucumberSteps {

    private RepositorioDeAnimalitos repositorio;
    private Animalito animalito;
    private Animalito animalitoDevuelto;
    @Autowired
    public RepositorioDeAnimalitosCucumberSteps(RepositorioDeAnimalitos repositorio){
        this.repositorio = repositorio;
    }

    @Dado("que tengo un repositorio vacio")
    public void queTengoUnRepositorioVacio() {
        repositorio.deleteAll();
    }

    @Y("que tengo un animalito")
    public void queTengoUnAnimalito() {
        animalito = new Animalito();
    }

    @Y("que tiene por {string} {string}")
    public void queTienePor(String campo, String valor) {
        switch(campo){
            case ("nombre"):
                animalito.setNombre(valor);
                break;
            case ("color"):
                animalito.setColor(valor);
                break;
            case ("tipo"):
                animalito.setTipo(valor);
                break;
        }
    }
    @Y("que tiene por {string} {int}")
    public void queTienePor(String campo, int valor) {
        switch(campo){
            case ("edad"):
                animalito.setEdad(valor);
                break;
        }
    }

    @Cuando("guardo el animalito en el repositorio")
    public void guardoElAnimalitoEnElRepositorio() {
        animalitoDevuelto = repositorio.save(animalito);
    }

    @Entonces("el repositorio me devuelve un animalito")
    public void elRepositorioMeDevuelveUnAnimalito() {
        Assertions.assertNotNull(animalitoDevuelto);
    }

    @Y("el animalito tiene por {string} {string}")
    public void elAnimalitoTienePor(String campo, String valor) {
        switch(campo){
            case ("nombre"):
                Assertions.assertEquals(valor, animalitoDevuelto.getNombre());
                break;
            case ("color"):
                Assertions.assertEquals(valor, animalitoDevuelto.getColor());
                break;
            case ("tipo"):
                Assertions.assertEquals(valor, animalitoDevuelto.getTipo());
                break;
        }
    }
    @Y("el animalito tiene por {string} {int}")
    public void elAnimalitoTienePor(String campo, int valor) {
        switch(campo){
            case ("edad"):
                Assertions.assertEquals(valor, animalitoDevuelto.getEdad());
                break;
        }
    }

    @Y("tiene un {string} asignado")
    public void tieneUnAsignado(String campo) {
        switch(campo){
            case ("id"):
                Assertions.assertNotNull(animalitoDevuelto.getId());
                break;
        }
    }

    @Y("en el respositorio me queda {int} animalito")
    public void enElRespositorioMeQuedaAnimalito(int cantidad) {
        Assertions.assertEquals(cantidad, repositorio.count());
    }

    @Y("el animalito no tiene {string}")
    public void elAnimalitoNoTiene(String campo) {
        switch(campo){
            case ("color"):
                Assertions.assertNull(animalitoDevuelto.getColor());
                break;
            case ("edad"):
                Assertions.assertNull(animalitoDevuelto.getEdad());
                break;
        }
    }

    @Cuando("modifico al animalito su {string} por {string}")
    public void modificoAlAnimalitoSuPor(String campo, String valor) {
        switch(campo){
            case ("nombre"):
                animalitoDevuelto.setNombre(valor);
                break;
            case ("color"):
                animalitoDevuelto.setColor(valor);
                break;
            case ("tipo"):
                animalitoDevuelto.setTipo(valor);
                break;
        }
    }
}
