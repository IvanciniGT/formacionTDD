Gherkin = Lenguaje formal para la definición de requisitos/pruebas

La gracia de usar Gherkin es que detrás tengo al Pepino (Cucumber)

Cucumber está disponible para 8000000 de lenguajes de programación.

La idea es escribir unos ficheros en lenguaje HUMANO, a elegir:
- Español
- Inglés
Realmente usamos un lenguaje humano... pero... con algunas restricciones

En cualquier caso, incluso con esas restricciones, quedan unos ficheros que son legibles y entendibles
por "cualquier persona".

Pero esos ficheros, de requisitos, en paralelo, se convierten en las pruebas que ejecuto en un sistema.

- Creamos un fichero Gherkin... en español... 
- y ejecutamos ese fichero.

Tengo una UNICA fuente de verdad (requisitos = pruebas)

No hay magia (código me toca escribir), pero:
  1º Voy a partir de un esqueleto que se genera en automático
  2º El poco código que voy a escribir, es ALTAMENTE reutilizable


---

Tienda de animales Felipe.

Microservicio REST que exponga la funcionalidad de el alta de un animalito nuevo.
Al darse de alta el animalito, será necesario suministrar unos cuantos datos
Y en paralelo, aquello se grabará en una BBDD y se mandará un email.

---

Maven es una herramienta de automatización de las tareas que hacemos habitualmente en un proyecto java:
- compilación
- empaquetado
- test
- mandar el código a sonarqube
- ejecutar un proyecto
- gestión de dependencias

---

# Spring: 

Framework para el desarrollo de apps en JAVA que ofrece INVERSION DE CONTROL.

## Inversión de control

Significa que YO YA NO CONTROLO EL FLUJO DE MI PROGRAMA (lenguaje imperativo)
Sino que le delego esa responsabilidad al framework.

# Cuando trabajamos con frameworks de inversión de control, como spring

No montamos un programa / aplicación... eso lo hace el framework
Lo que le contamos es al framework cómo es mi aplicación... que componentes tiene... (lenguaje declarativo)

Oye Spring:
- Mi aplicación controla Animalitos
- Y quiero un repositorio de BBDD donde dejarlos
- Y quiero tener un servicio de envío de emails
- Y.. quiero tener un servicio de gestion de animalitos... que me permita dar de alta animalitos... y solicitar el envío de un email al hacerlo... ah, y pedirle al repositorio que lo guarde
- Ah... y quiero que ese servicio sea accesible por http... en un determinado endpoint
- Y ... ya... Montamelo !

---

El asunto es que quien va a ir invocando a mi código no voy a ser yo... sino Spring.

Yo tendré una clase llamada EmailService, con un método sendEmail()

Pero yo no voy a tener por ningún sitio en mi código new EmailService()
Esa línea de código la escribirá Spring.

Yo tendré una clase llamada AnimalitosService, con un método addAnimalito()

Pero yo no voy a tener por ningún sitio en mi código new AnimalitosService()
Esa línea de código la escribirá Spring.

Yo tendré una clase llamada AnimalitosRepository, con un método .save(animalito)

Pero yo no voy a tener por ningún sitio en mi código new AnimalitosRepository()
Esa línea de código la escribirá Spring.

Y eso es una ventaja GIGANTESCA... ya que si es Spring quien llama a mi constructor...
Spring puede mirar los argumentos que mi constructor necesita... y suministrarselos <- INYECCION DE DEPENDENCIAS

---

Las tecnologías, las metodologías, las arquitecturas y las herramientas 
evolucionan en paralelo

mongo

---

Por ahora tenemos una prueba de sistema definida -> BDD

Animalitos - DAO

RepositorioDeAnimalitos -> BBDD

ServicioDeEmails

ServicioDeAnimalitos -DTO
    .altaDeAnimalito
        -> Repositorio
        -> ServicioEmail


http://miservidor:8080/api/v1/animalitos -DTO2
                                ^^^
                                vvv
                                ServicioDeAnimalitos.alta


CAPA DOMINIO: Donde defino los datos (entidades) sobre las que trabajo

FRONTEND        
            Llame al servicio REST
                        v
EXPOSICION          Lógica
            ControladorRest
            ExposiciónDelServicioREST
                       v
NEGOCIO             Lógica                                               Datos
            ServicioDeAnimalitos    > ServicioDeEmails                   DatosDeNuevoAnimalito DTO
                       v                                                        v
DOMINIO             Lógica                                               Datos  v Mapper
            RepositorioDeAnimalitos                                      Animalito          ENTITY


La entidades son objetos de transporte de datos... pero único... identificados... ID
DataTransferObject es otro objeto de transporte de datos... pero no es UNICO... 
    Dos DTOS con los mismo datos... los consideraría iguales entre si


----

Framework Spring - Framework de inversión de control
    new ServicioAltaAnimalitosSteps()
Framework JUnit  - Framework de pruebas automatizadas
    new ServicioAltaAnimalitosSteps()
Framework Cucumber - Definir y ejecutar pruebas de sistema (BDD)
    new ServicioAltaAnimalitosSteps()


Junit -> JUnit Platform  <- CucumberPlatformJunit    <-  Cucumber