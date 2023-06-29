package com.curso.test.sistema;

import com.curso.AplicacionTest;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.en.Given;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


// Le dice a Java que esta clase, contiene pruebas que son procesadas a través de la plataforma JUnit
@Suite
// Las pruebas las hemos definido a través de Cucumber...
@IncludeEngines("cucumber")
// JUNIT: En la carpeta features están los ficheros .feature... para que se los pases al cucumber
@SelectClasspathResource("sistema")
// JUnit: Este fichero, una instgancia de él para trabajar, creala a través de Spring
@ExtendWith(SpringExtension.class)
// Permite la integración entre cucumber y Spring
//@CucumberContextConfiguration
// Esto me da un cliente para atacar por http a mi servidor de test
@AutoConfigureMockMvc
//Esto me monta un tomcat con mi app despliegada y sus microservicios
@SpringBootTest( classes = AplicacionTest.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ServicioAltaAnimalitosCucumberSteps {

    private JSONObject objetoJson;

    private MockMvc clienteHTTP;

    private ResultActions respuesta;

    public ServicioAltaAnimalitosCucumberSteps(MockMvc clienteHTTP){
        this.clienteHTTP=clienteHTTP;
    }

    @Given("un objeto JSON")
    public void unObjetoJSON() {
        objetoJson = new JSONObject();
    }

    @Given("el objeto JSON tiene por valor del campo {string}: {string}")
    public void elObjetoJSONTienePorValorDelCampo(String campo, String valor) throws JSONException {
        objetoJson.put(campo, valor);
    }

    @Given("el objeto JSON tiene por valor del campo {string}: {int}")
    public void elObjetoJSONTienePorValorDelCampo(String campo, int valor) throws JSONException {
        objetoJson.put(campo, valor);
    }

    @Cuando("invoco al servicio {string} con método {string} y envío ese objeto JSON")
    public void invocoAlServicioConMétodoYEnvíoEseObjetoJSON(String servicio, String metodo) throws Exception {
        // Qué necesito aquí?
        // 1º Un servidor de aplciaciones.. con mi aplicación y sus microservicios desplegados
        // 2º Un cliente para acceder por http a ese microservicio (alquien que lance peticiones http)
        // 3º Un servidor de email de mentirijilla o no tanto más de verdad. Docker (1 minuto)
        // mailhog
        // 4º Necesito quizás una BBDD?
        switch(metodo) {
            case "post":
                respuesta = this.clienteHTTP.perform(MockMvcRequestBuilders.post(servicio)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objetoJson.toString()));
                break;
        }
    }

    @Entonces("el servicio debe contestar con código http {string}")
    public void elServicioDebeContestarConCódigoHttp(String codigo) throws Exception {
        switch (codigo){
            case "CREATED":
                respuesta.andExpect(status().isCreated());
        }
    }

    @Y("el servicio debería devolver un objeto json")
    public void elServicioDeberíaDevolverUnObjetoJson() throws Exception {
        respuesta.andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Y("el objeto JSON debe tener por valor del campo {string}: {string}")
    public void elObjetoJSONDebeTenerPorValorDelCampo(String campo, String valor) {
    }

    @Y("el objeto JSON debe tener por valor del campo {string}: {int}")
    public void elObjetoJSONDebeTenerPorValorDelCampo(String campo, int valor) {
    }

    @Y("el objeto JSON debe tener por valor del campo {string} un número")
    public void elObjetoJSONDebeTenerPorValorDelCampoUnNúmero(String campo) {
    }

    @Y("se debe haber añadido el animalito a la BBDD en la tabla {string}")
    public void seDebeHaberAñadidoElAnimalitoALaBBDDEnLaTabla(String tabla) {
    }

    @Y("en esa tabla se debe haber introducido el campo {string}, con el valor {string}")
    public void enEsaTablaSeDebeHaberIntroducidoElCampoConElValor(String campo, String valor) {
    }

    @Y("en esa tabla se debe haber introducido el campo {string}, con el valor {int}")
    public void enEsaTablaSeDebeHaberIntroducidoElCampoConElValor(String campo, int valor) {
    }

    @Y("en esa tabla se debe haber introducido el campo {string}, con un valor numérico")
    public void enEsaTablaSeDebeHaberIntroducidoElCampoConUnValorNumérico(String campo) {
    }

    @Y("se debe haber enviado un email a: {string}")
    public void seDebeHaberEnviadoUnEmailA(String destinatario) {
    }

    @Y("ese email debe tener en el asunto {string}")
    public void eseEmailDebeTenerEnElAsunto(String asunto) {
    }

    @Y("ese email debe tener en el cuerpo {string}")
    public void eseEmailDebeTenerEnElCuerpo(String contenido) {
    }
}
