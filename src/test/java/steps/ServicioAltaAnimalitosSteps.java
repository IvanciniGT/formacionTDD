package steps;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.en.Given;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

// Esto me da un cliente para atacar por http a mi servidor de test
@AutoConfigureMockMvc
//Esto me monta un tomcat con mi app despliegada y sus microservicios
@SpringBootTest( classes = AplicacionTest.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ServicioAltaAnimalitosSteps {

    private JSONObject objetoJson;

    private MockMvc clienteHTTP;

    private ResultActions respuesta;

    public ServicioAltaAnimalitosSteps(MockMvc clienteHTTP){
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
    public void elServicioDebeContestarConCódigoHttp(String codigo) {
    }

    @Y("el servicio debería devolver un objeto json")
    public void elServicioDeberíaDevolverUnObjetoJson() {
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
