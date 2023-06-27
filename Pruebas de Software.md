# Pruebas de Software

## Vocabulario en el mundo del testing

- Error     Los humanos cometemos errores (malas decisiones por falta de conocimiento, estar cansados, falta de atención...)
- Defecto   Al cometer un error introducimos defectos en los productos
- Fallo     Esos defectos pueden manifestarse como fallos en tiempo de ejecución.

## Para que sirven?

- Asegurar la calidad del producto
- Asegurar el cumplimiento de unos requisitos de distinta naturaleza

- Detectar el mayor número posible de fallos antes de la puesta en producción de un sistema     -> Implica ejecución del programa
    -> Quiera arreglar el defecto que lo ocasiona. Lo primero que necesito es Identificar el defecto: DEPURACION / DEBBUGING
    - Recopilar información (que aporte luz) para facilitar la rápida identificación de un defecto desde un fallo. <<<< (1)
- Detectar el mayor número posible de defectos antes de la puesta en producción de un sistema   -> Implica la no ejecución del programa
- Prevenir errores futuros... Análisis de causas raíces -> Acciones preventivas

- Extraer información (conocimiento) de mi sistema.
    Rendimiento
- Ayudarnos con el desarrollo del producto
- Ayudarnos a entender el estado del proyecto.

## Tipos de pruebas existen (software)

Cualquier prueba debe probar una única cosa, se debe centrar en un único aspecto de un sistema/componente  (1)

Las pruebas las podemos clasificar en base a distintas taxonomías, que usamos paralelamente.

### En base al nivel de la prueba

- Unitarias             Prueba un aspecto de un componente AISLADO del sistema
                        No siempre es fácil: Testing doubles (Mocks... mal llamados)

                            SISTEMA TREN:       MOTOR       BIELAS      RUEDAS      FRENOS

- Integración           Se centran en la COMUNICACIÓN entre componentes
                            RUEDA <> FRENO

- Sistema (End2End)     Se centran en el COMPORTAMIENTO del sistema en su conjunto
                        Y si tuviera todas las pruebas de sistema posibles definidas y ejecutándose sin problemas, necesito para algo las pruebas unitarias y las de integración? Para nada!
                        El truco en esa pregunta está en 2 conceptos:
                        - ejecutándose sin problemas.... y si los hay?
                        - el sistema en su conjunto.... puede ser muy tarde para resolver problemas... al menos de forma económica

  - Pruebas de aceptación   Suelen ser un subconjunto de nuestras pruebas de sistema.

### En base al procedimiento de ejecución de la prueba

- Estáticas: Es la  que no requiere poner el sistema/componente en funcionamiento para su ejecución
                -> Defectos
             Revisión de:
                - Modelo BBDD
                - Requisitos
                - Diseño del sistema
                - Código del programa -> SonarQube (Revisión de calidad del código)
                - Configuración

- Dinámicas: Es la que SI requiere poner el sistema/componente en funcionamiento para su ejecución
                -> Fallos

### En base al objeto de prueba

- Funcionales       Se centran en la funcionalidad del sistema/componente
- No funcionales    Se centran en otros aspectos
  - Rendimiento
        Tal operación del sistema OP1 debe ser realizada con unos tiempos de respuesta cómodos y aceptables por el usuario.

        Tal operación del sistema OP1 debe ser realizada con unos tiempos de respuesta inferiores a 200ms.
        
        Tal operación OP1, estando mi sistema instalado en tal entorno Y, y con la configuración X, y estando sometyido a una determinada carga de trabajo, debe ser realizada con un percentil 95 inferior a 200ms. <> Prueba de rendimiento (del sistema)

  - Carga
  - Estrés
  - HA
  - UX
  - ...

### En base al conocimiento que tengo del objeto de prueba (sistema/componente)

- Caja blanca       Conozco los entresijos del componente
- Caja negra        No conozco los entresijos del componente

### Pruebas de regresión

Cualquier prueba que repito (normalmente después de introducir cambios en el sistema/componente).

Pregunta... y si una prueba la tengo que repetir muchas veces... que me va a interesar? AUTOMATIZARLA

---

# Metodologías ágiles

Llamamos metodología ágil a aquella metodología que cumplen con los principios del manifiesto ágil para el desarrollo de software.
agilemanifesto.org

## Puntos del manifiesto ágil:

Nuestra mayor prioridad es satisfacer al cliente                            >       SPRINT
mediante la entrega temprana y continua de software
con valor.

Entregamos software FUNCIONAL frecuentemente, entre dos                     >       SPRINT
semanas y dos meses, con preferencia al periodo de
tiempo más corto posible.

El software FUNCIONANDO es la medida principal de progreso.

> La medida principal del progreso de un proyecto es el software FUNCIONANDO.
>
>   SOFTWARE FUNCIONANDO = Número de pruebas pasadas
>
> Cómo medir el progreso que he realizado en un proyecto... qué tal vamos? 
> En las met. trad... qué usábamos para saber cómo íbamos en el proyecto? 
>   HITO 1:     A tal fecha     14 de Marzo de 2024 : *R1, R2, R3, R4, R5*
>                   Si llegada la fecha, no tenía los requisitos implementados:
>                   1º Alarmas
>                   2º Ostias
>                   3º Se re-planifica el HITO -> 21 de Marzo
>   Hito 2      ""
>   Hito 3      ""

>   Sprint 1:   A tal fecha     *14 de Marzo de 2024* : R1, R2, R3, R4, R5
>               Si llegada la fecha, no tengo los requisitos. SE INSTALA ese día. La fecha NO SE TOCA.
>               Los requisitos que no estén acabados para el siguiente
>   Sprint 2    ""
>   ...

La simplicidad, o el arte de maximizar la cantidad de trabajo no realizado, es esencial.

> No escriban nada que no sea necesario... y es que antes tirábamos mucho del "por si acaso"

### Software funcional... software funcionando ?

Software que funciona... que hace lo que tiene que hacer.
Quién dice que un software funciona?    PRUEBAS 

## Características básicas

Entregar el producto al cliente de forma INCREMENTAL <> Metodologías tradicionales (en cascada) = Se entregaba cuando el sistema completo estaba desarrollado.

    Sprint 1  Fecha 1... a los 30 días de empezar el proyecto                   INSTALACIÓN EN PRODUCCIÓN
                                                                                10% de la funcionalidad - 100% funcional
        Pruebas     10% ... pruebas a nivel de producción!!!
    Sprint 2  Fecha 2... a los 45 días de empezar el proyecto                   INSTALACIÓN EN PRODUCCIÓN
                                                                                +5% de la funcionalidad - 100% funcional
        Pruebas     +5% (+10%)    pruebas a nivel de producción
    Sprint 3  Fecha 3... a los 60 días de empezar el proyecto                   INSTALACIÓN EN PRODUCCIÓN
                                                                                +15% de la funcionalidad - 100% funcional
        Pruebas     +15% (+5% +10%)    pruebas a nivel de producción

## Qué problemas NUEVOS que no tenía antes me dan las met. Ágiles? 

Qué pasa con las pruebas? comparado con una met. tradicional.           Se me multiplican
Qué pasa con las instalaciones? comparado con una met. tradicional.     Se me multiplican

Y de dónde cojo - ness saco la pasta? No hay pasta!!! Ni recursos.... 
Me hace falta algo.. o si no me hace falta, me va a traer mucha cuenta: AUTOMATIZAR (pruebas, instalaciones... todo lo que pueda)

---

# DEVOPS

No... no es un perfil... al menos en origen.
Cultura, movimiento en pro de la AUTOMATIZACION: De todo lo que esté entre el desarrollo y la operación de un sistema.
                                                                            Desarrollo  CI
                        Automatizable       Herramientas                      ágil
PLAN                        x                                                   |       |
CODE                        ~               -> SCM (git)                        |       |
BUILD                       √               JAVA: Maven, Gradle, SBT            v       |
                                            .net: nuget, msbuild, dotnet                |
                                            JS:   npm, yarn, webpack                    |
                                            PYTHON: pip, poetry                         |
TEST                                                                                    |
    Definición de la prueba  x                                                          |
    Ejecución de la prueba   √                                                          |
                                            Calidad de código: SonarQube                |
                                            Pruebas interfaz gráfica Web:               |
                                                Katalon studio                          |
                                                Selenium, cypress, webdriver.io         |
                                            Pruebas funcionales de servicios web:       |
                                                Karate, SoapUI, Postman, ReadyAPI       |
                                            Pruebas interfaz gráfica teléfono           |
                                                Appium, Katalon                         |
                                            Pruebas rendimiento:                        |
                                                JMeter, Loadrunner                      |
                                            Frameworks de autom. de pruebas:            |
                                                JUnit, TestNG, NUnit, UnitTest,         |
                                                Mocha, Cucumber (GHERKIN)               v       C.Delivery
RELEASE                                                                                         |
    Generación y puesta en mano del cliente                                                     |
    final de la última versión de mi sistema                                                    |
        Docker hub, nexus, maven central, artifactory                                           |
        Página web                                                                              v       C. Deployment
DEPLOY                      √                                                                           |
    Kubernetes,                                                                                         |
    Puppet,                                                                                             |
    Ansible                                                                                             |
    Terraform                                                                                           |
    Vagrant                                                                                             v
OPERATION
MONITOR

Servidor de Automatización, servidores de CI/CD:
    Jenkins, Bamboo, TeamCity, AzureDevops (TFS), TravisCI, GitlabCI/CD, Github Actions...
---

# TDD? (BDD, ATDD)

Test Driven Development. Su uso (seguimiento) es obligatorio en algunas metodologías de gestión (EXTREME PROGRAMMING)

Procedimiento (metodología) de desarrollo de software.

Cuidado que TDD no es lo mismo que Test-First-Development (haz primero las pruebas)

TDD = Test-First development + Refactorización.

## Test-First development

Diseña primero las pruebas... cuidado, que no a ejecutar (que también)
Antes de escribir ni una sola linea de código.
Y adicionalmente, programado todas las pruebas.

### Fases:

1º Diseñar / codificar todas las pruebas de un determinado requisito
2º Ejecutar las pruebas y ver que todas fallan                      ---> Algo estoy probando
3º Escribo la cantidad mínima de código para que las pruebas sean superadas
4º Pruebo de nuevo y me aseguro que todo se pone en verdecito!!! En ese momento no tengo que escribir ni una linea más de código.

### Desarrollo y pruebas

No encaja en la misma frase!

## Refactorización

Reescribir código, sin cambiar su comportamiento, para facilitar:
- Legibilidad **
- Mantenimiento

Tareas:
- Adecuar los nombres de variables, métodos, clases...
- Seguir estándares y buenas prácticas
- Unificar código duplicado
- Crear funciones más pequeñas:
  - Más legibles
  - Más reutilizables

---

# Sonarqube

Dentro de las métricas de SonarQube:
- Complejidad ciclomática:
    Es el número potencial de caminos diferentes que puede tomar un código al ejecutarse

    tarea1                                                          switch(variable)
    SI condicion1                                                       case(1): tarea1
        tarea2                                                          case(2): tarea2
        SI condicion2                                                   case(3): tarea3
            tarea3                                                      case(4): tarea4
        SI NO, SI condicion3                                            case(5): tarea5
            tarea4                                                      case(6): tarea6
    SI NO                                                               case(7): tarea7
        tarea5
        SI condicion4
            tarea6
        SINO 
            tarea7

    Complejidad ciclomática:    4   I                                   7
                                5   III *****
                                6   I   
                                7   I

        tarea1 + tarea2
        tarea1 + tarea2 + tarea3
        tarea1 + tarea2 + tarea4
        tarea1 + tarea5 + tarea6
        tarea1 + tarea5 + tarea7

    La complejidad ciclomática es algo que rara vez puedo manipular... depende de qué? de los requerimientos
        Para qué me sirve este dato? Es el número mínimo de PRUEBAS que debo realizar

- Complejidad cognitiva:
    Cómo de complejo es un código para un ser humano.

---

EN NINGÚN CASO, vamos a montar un sistema monolítico:
- Quiero descomponer el sistema en distintos COMPONENTES / MODULOS
- Esos módulos NO DEBEN TENER UNA RELACIÓN FUERTE ENTRE SI. NO DEBEN ESTAR ACOPLADOS
Problemas de los diseños MONOLITICOS:
- Lentitud a la hora de hacer una actualización 
- Escalabilidad
- Problemas de mantenimiento. Cualquier cambio implica que necesito cambiar TODO el sistema

App que a un usuario le permita buscar desde una terminal una palabra en un diccionario de un idioma...

    $ palabra ES manana

Si la palabra existe, la app debe suministrarle las definiciones
Si la palabra no existe, la app debe suministrarle alternativas a la palabra

COMPONENTES
- Quien gestiona los diccionarios (BBDD, fichero de texto)
  - API que permita comunicar ambas
- App de consola

## API que permita comunicar ambas

    interface Diccionario {
        boolean existe(String palabra)
        List<String> getSignificados(String palabra)
        List<String> getAlternativas(String palabra)
    }
    interface SuministradorDeDiccionarios {
        boolean tienesDiccionarioDe(String idioma)
        Diccionario getDiccionario(String idioma)
    }

## Quien gestiona los diccionarios: Quiero una implementación del API

### Pero antes de meterle mano a esa implementación... Voy a definir las pruebas que necesito pasar.



### Habrá una implementación....

    class DiccionarioFromBBDD implements Diccionario {
        ...
    }
    class SuministradorDeDiccionariosFromBBDD implements SuministradorDeDiccionarios {
        ...
    }

## App de consola

    import com.diccionario.Diccionario;
    import com.diccionario.SuministradorDeDiccionarios;
    // import com.diccionario.SuministradorDeDiccionariosFromTextFile;     /// ESTA ES LA RUINA !!!!

    ...
    public void procesarPeticion(SuministradorDeDiccionarios suministrador){ // Inyección de dependencias
        ...
        String palabra = "manana";
        String idioma = "ES";
        // SuministradorDeDiccionarios suministrador = new SuministradorDeDiccionariosFromTextFile();
        if( suministrador.tienesDiccionarioDe(idioma) ){
            Diccionario diccionario = suministrador.getDiccionario(idioma);
            if(diccionario.existe(palabra)){
                List<String> significados = diccionario.getSignificados(palabra);
                // Los pongo por pantalla
            }else{
                List<String> alternativas = diccionario.getAlternativas(palabra);
                // Los pongo por pantalla
            }
        }
        ...
    }

---

# Principios Solid de desarrollo de software. Uncle BOB

1: S    Principio de Responsabilidad UNICA (Single responsibility principle)
        Un componente (objeto, modulo) debería tener un UNICO MOTIVO PARA CAMBIAR

3: L    Principio de sustitución de Liskov
        Un componente del sistema debería poder ser reemplazado por subtipos sin alterar el funcionamiento del programa.

5: D    Principio de inversión de dependencias
        Un componente de alto nivel no debería depender de Implementaciones... solo de abstracciones (contratos, interfaces)
        Inyección de dependencias es una forma de conseguir respetar este principio

# Patrón: Inyección de dependencias

Una clase no debe crear instancias concretas de un tipo ... sino que le deben ser suministradas.






- Algún sitio donde almacenar (de donde leer) palabras y sus definiciones: BBDD o Fichero de texto (XML, txt)

---

Sistema de Animalitos Fermín !

Frontal                                                                     Backend
- Web -> Detalle v2.0.0                                                     Alta de animalito     BBDD de los animalitos
- App Android  -> Detalle v1.0.0                                            Baja de animalito
- App iOS  -> Detalle v2.0.0                                                Recuperar animalitos
- Alexa, OK Google, Siri  -> Detalle v1.0.0                                 Detalle de animalito v1.1.0
- Desktop para las tiendas y los empleados  -> Detalle v2.0.0                       nombre
                                                                                    peso
                                                                            Detalle de animalito v2
                                                                                    name
                                                                                    weight
                                                                                    pics

---

Versiones software:
    1.2.3

                Cuando los incremento

    1 Major     Cuando hay un cambio que NO RESPETA RETROCOMPATIBILIDAD. Breaking changes
                    Quito algo del programa (se elimina ... o se sustituye)
    2 Minor     Nueva funcionalidad
                Marcar algo como deprecated
                    + Arreglos de bugs
    3 Patch     Arreglo de bugs

---

Características de los entornos de producción:
- ALTA DISPONIBILIDAD
    Tratar de garantizar que el sistema está en funcionamiento una determinada cantidad de tiempo, preestablecida contractualmente (SLA)
    Tratar de garantizar la no pérdida de información
        3Tbs -> 3 HDD 3Tbs de los buenos.
    "TE VOY A TRATAR DE GARANTIZAR QUE LA APP ESTARÁ ONLINE 99% del tiempo que debería" -> REDUNDANCIA

        App web
            Blog de "TDD"
            Peluquería Citas
            Página web de un supermercado
            Sistema de gestión de un hospital
        
                                        OFFLINE
        Te intento garantizar el 90%    36 dias/año     |   €                           3€/mes
        Te intento garantizar el 99%    3,6 días/año    |   €€                          30€/mes
        Te intento garantizar el 99,9%  8 horas/año     |   €€€€€€€                     120€/mes
        Te intento garantizar el 99,99% minutos/año     v   €€€€€€€€€€€€€€€€€€€€€€€     400€/mes

- ESCALABILIDAD 
    Capacidad de ajustar la infra a las necesidades de cada momento

        App1: Sistema de gestión de un hospital... donde los médicos meten los informes... radiografías.
            Dia 1:     100 usuarios
            Dia 100:   102 usuarios     No necesito ESCALABILIDAD
            Dia 500:    98 usuarios
        
        App2: 
            Dia 1:     100 usuarios
            Dia 100:   1000 usuarios    Necesito escalabilidad: ESCALABILIDAD VERTICAL: MAS MAQUINA !
            Dia 500:   10000 usuarios
        
        App3: ESTO ES EL HOY EN DIA .... INTERNET
            Hora n:          100 usuarios
            Hora n + 1:      1000000 usuarios           Escalabilidad Horizontal: MAS MAQUINAS !!!!
            Hora n + 2:      2000 usuarios
            Hora n + 3:      300000 usuarios
