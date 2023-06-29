interface Diccionario {
    String getIdioma();
    boolean existe(String palabra)
    List<String> getSignificados(String palabra)
    List<String> getAlternativas(String palabra)
}
interface SuministradorDeDiccionarios {
    boolean tienesDiccionarioDe(String idioma)
    Diccionario getDiccionario(String idioma)
}
class DiccionarioFromBBDD implements Diccionario {
    ...
}
class SuministradorDeDiccionariosFromBBDD implements SuministradorDeDiccionarios {
    ...
}
---

# Pruebas unitarias

# Pruebas de integración

# Pruebas de sistema

---
SuministradorDeDiccionarios
    tienesDiccionarioDe(idioma)
    Probar pasando un null
    Probar pasando un idioma que existe
    Probar pasando un idioma que no existe

## Partes de una prueba                     Gherkin
    PRECONDICIONES... ESTADO INICIAL        GIVEN       Dado
    TRABAJO QUE HACEMOS                     WHEN        Cuando
    POST COMPROBACIONES                     THEN        Entonces

CARACTERISTICA: Función tienesDiccionarioDe(idioma)

    ESCENARIO: CASO: Probar a pasar un null
        Dado que tengo un SuministradorDeDiccionarios
        Cuando llamo a la función tienesDiccionarioDe, con el idioma null
        Entonces debo recibir: NullPointerException                             # false.. Quiero que mi librería se comporte así

    ESCENARIO: CASO: Probar pasando un idioma que existe
        Dado que tengo un SuministradorDeDiccionarios
           Y que el suministrador tiene el idioma "ES"
        Cuando llamo a la función tienesDiccionarioDe, con el idioma "ES"
        Entonces: Debo recibir true

        Datos: ES, es, Es

    ESCENARIO: CASO: Probar pasando un idioma que no existe
        Dado que tengo un SuministradorDeDiccionarios
           Y que el suministrador no tiene el idioma "DE LOS ELFOS"
        Cuando llamo a la función tienesDiccionarioDe, con el idioma "DE LOS ELFOS"
        Entonces: Debo recibir false

CARACTERISTICA:     Función getDiccionario(String idioma)


    ESCENARIO: CASO: Probar a pasar un null
        Dado que tengo un SuministradorDeDiccionarios
        Cuando llamo a la función getDiccionario, con el idioma null
        Entonces debo recibir: NullPointerException                             # false.. Quiero que mi librería se comporte así

    ESCENARIO: CASO: Probar pasando un idioma que existe
        Dado que tengo un SuministradorDeDiccionarios
           Y que el suministrador tiene el idioma "ES"
        Cuando llamo a la función getDiccionario, con el idioma "ES"
        Entonces: Debo recibir un diccionario
               Y el diccionario debe ser de idioma "ES"

        Datos: ES, es, Es

        SuministradorDeDiccionario suministrador = ...;
        ASSERT TRUE -> suministrador.tienesDiccionarioDe("ES")
        Diccionario diccionario = suministrador.getDiccionario("ES")
        ASSERT EQUALS -> "ES" == diccionario.getIdioma()

    ESCENARIO: CASO: Probar pasando un idioma que no existe
        Dado que tengo un SuministradorDeDiccionarios
           Y que el suministrador no tiene el idioma "DE LOS ELFOS"
        Cuando llamo a la función getDiccionario, con el idioma "DE LOS ELFOS"
        Entonces: Debo recibir 
            - NoSuchLanguageException
            - null
            - Objeto Dummy

    Optional<Diccionario> getDiccionario(String idioma)

    Optional<List<String>> getSignificados(String palabra)
        Con la palabra "manana" en el idioma "ES"
        Qué devuelve?
                No está dando pistar al 3º que usa la función de que está pasando algo anómalo.
            Una lista vacia         \ No son explicitas. Un tercero que quiera usar la función NO SABE A PRIORI 
            null                    /   cómo se comporta la función: DOCUMENTACION, CODIGO 
                    Diferencia comportamientos
            NoSuchWordException     Nunca debería usar una exception para controlar lógica de la aplicación
                                    Una exception es muy cara computacionalmente de constuir
                                    ALGO BUENO: Diferencia comportamientos y es explicita

            La única opción válida desde JAVA 1.8 es Optional!
                TODAS SON UNA MIERDA GIGANTESCA !


    List<String> getAlternativas(String palabra)
            manana -> ["mañana", "manzana", "Banana"]
            mesa   -> ["mesa", "fresa", "misa"]
            7y82783Ç$$$092·$()!=·"¢#¢¢∞∞###:'() -> [] Lista vacia... y es perfectamente válido

        datos                    datos que también conozco
Prueba ----->  |   Suministrador ---------+  ----------------> Repositorio ----> BBDD   |
        <----                    <--------+  -----------------
        respuesta que debería       respuesta que también conozco


Qué prueba he montado? Sistema [] -> Behavior Driven Development

Unitarias   = AISLADO
Integración = COMUNICACION 
Sistema     = COMPORTAMIENTO


        
Quiero ahora montar una prueba unitaria. En que me centro? En el comportamiento/funcionalidad de un COMPONENTE AISLADO!

    SuministradorDeDiccionariosBBDD{

        private IdiomasRepository repositorioDeIdiomas
        private EmailService emailService

        public SuministradorDeDiccionarioBBDD(IdiomasRepository repositorioDeIdiomas, EmailService emailService ){
            this.repositorioDeIdiomas=repositorioDeIdiomas
            this.emailService=emailService
        }

        Optional<Diccionario> getDiccionario(String idioma){
                // Paso 1: Mirar si tengo el diccionario en la BBDD (query)
                repositorioDeIdiomas.select(idioma);
                // Paso 2: Si tengo diccionario: query: Recupera las palabras
                // Paso 3: Creo un objeto de tipo diccionario, con esas palabras y el idioma que me han dicho)
                // Paso 3.5: Mandar un email a algún sitio
                emailService.sendEmail("DATOS")
                // Paso 4: Devuelvo el objeto.
        }
    }

    Podría usar un Stub. Si alguien intenta ir a la BBDD y tira la query: SELECT id from IDIOMAS where nombre = 'LO QUE SEA'
                            Devuelve 3;
                         Si alguien intenta ir a la BBDD y tira la query: SELECT palabra from PALABRAS where idioma = LO QUE SEA
                            Devuelve ['manzana', mañana, federico]

    Estoy aislando a la función de la BBDD... Ya que :
    1- No hay conexión real a una BBDD
    2- Tengo controlado la respuesta que va a recibir la función.

    Simplemente por usar ese Stub, tengo UNA PRUEBA UNITARIA

        ESCENARIO: CASO: Probar pasando un idioma que existe
            Dado que tengo un SuministradorDeDiccionarios
            Y que el suministrador tiene el idioma "ES"
            Y que estoy usando un STUB para aislar a mi función, que devuelve 3, federico
            Cuando llamo a la función getDiccionario, con el idioma "ES"
            Entonces: Debo recibir un diccionario
                Y el diccionario debe ser de idioma "ES"

            Datos: ES, es, Es

---
## Test Doubles (Mock)

El primero que creo un paper con toda esta info fué: Martin Fowler

Stub        Es un objeto que devuelve unas respuesta predefinidas... fijas
Spy         Es un objeto que puede o no devolver unas respuestas prediseñadas, pero 
            que controla las llamadas que se van haciendo al objeto
Mock        Es un objeto que puede o no devolver unas respuestas prediseñadas, pero 
            que sabe si las llamadas que se han hecho son las adecuadas
Fake        Es un objeto que simula el comportamiento de algo (BBDD) con cierta lógica
            Si el fake le empiezo a dotar de demasiada lógica se convierte en: El componente real.
Dummy


            class RepositorioDeIdiomasQueExistenStub{
                int selectId(String idioma){
                    return 3;
                }
            }
            class RepositorioDeIdiomasQueNoExistenStub{
                int selectId(String idioma){
                    return -1;
                }
            }
            class RepositorioDeIdiomasFake{
                int selectId(String idioma){
                    return 3?idioma.startsWith("SI_EXISTE_"):-1;
                }
            }

            SI_EXISTE_ES -> 3
            DE LOS ELFOS -> -1
            
            SuministradorDeDiccionarios 
                getDiccionario()        <---------      RepositorioDeIdiomas (BBDD)
                                        stub
                                        fake
                getDiccionario()        ---------->     Mandar Email cuando alguien pide un idioma
                                        spy
                                        mock
                                        dummy

            class EmailServiceSpy {
                private int llamadas = 0;

                public boolean sendEmail(DATOS) {
                    llamadas++;
                    return true;
                }

                public int getNumeroEmailsMandados(){
                    return this.llamadas;
                }
            }

            class EmailServiceMock {
                private int llamadas = 0;

                public boolean sendEmail(DATOS) {
                    llamadas++;
                    return true;
                }

                public boolean verifyEmailSend(){
                    // Mirar los datos que se mandan
                    return this.llamadas == 1;
                }
            }

            En el spy recopilo información que luego proceso
            En el mock, añado lógica de validación.

            Al hacer la prueba, inyectaré al SuministradorDeDiccionarios , el spy
            haré las operaciones... getDiccionario()
            Comprobaciones:
                - Las propias de lo que devuelve la función getDiccionario() que si me da uno... que es de español...
                - ASSERT EmailServiceSpy.getNumeroEmailsMandados() == 1
                - Si hubiera usando un Mock : ASSERT EmailServiceMock.verifyEmailSend()
---

# Para qué me están sirviendo las pruebas?

- Entender el comportamiento que debe tener mi componente ->Sonarqube : Complejidad ciclomática
- Validar el API
- Poder comprobar que la función tiene el comportamiento adecuado

## Seguimos los principios FIRST

F ast               La prueba debe ser rápida al ejecutarse.... no tengo la mañana para esperar
I ndependent        La prueba no debe depender de nadie (de estados previos no definidos en la prueba)
R epeteable         La prueba debe poder ejecutarse 50 veces
S elf-validating    La prueba compruebe TODO LO QUE NECESITA COMPROBAR
T imely             A tiempo

Quiero probar que una vez hecho login en un sistema, soy capaz de llamar a una función que haga una búsqueda y devuelve datos.
    Voy a montar un fake del Autenticador... Para que si pongo cualquier nombre, acceda
        Qué me quito? de accesos a BBDD y queries y comprobaciones = tiempo
