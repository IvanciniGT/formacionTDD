#language:es
  Característica: Alta de Animalito en el Repositorio de Animales

    Esquema del escenario: Alta con datos guays. Todos los datos
      Dado que tengo un repositorio vacio
      Y que tengo un animalito
      Y que tiene por "nombre" "<nombre>"
      Y que tiene por "edad" <edad>
      Y que tiene por "tipo" "<tipo>"
      Y que tiene por "color" "<color>"
      Cuando guardo el animalito en el repositorio
      Entonces el repositorio me devuelve un animalito
      Y el animalito tiene por "nombre" "<nombre>"
      Y el animalito tiene por "edad" <edad>
      Y el animalito tiene por "tipo" "<tipo>"
      Y el animalito tiene por "color" "<color>"
      Y tiene un "id" asignado
      Y en el respositorio me queda 1 animalito

      Ejemplos:

        |nombre | edad | tipo  | color |
        |Pepito | 2    | perro | marrón|
        |Pepita | 3    | gato  | blanco|
        |Pepote | 4    | pájaro| verde|

    Escenario: Alta sin color
      Dado que tengo un repositorio vacio
      Y que tengo un animalito
      Y que tiene por "nombre" "Pepito"
      Y que tiene por "edad" 2
      Y que tiene por "tipo" "perro"
      Cuando guardo el animalito en el repositorio
      Entonces el repositorio me devuelve un animalito
      Y el animalito tiene por "nombre" "Pepito"
      Y el animalito tiene por "edad" 2
      Y el animalito tiene por "tipo" "perro"
      Y el animalito no tiene "color"
      Y tiene un "id" asignado
      Y en el respositorio me queda 1 animalito


    Escenario: Alta sin edad
      Dado que tengo un repositorio vacio
      Y que tengo un animalito
      Y que tiene por "nombre" "Pepito"
      Y que tiene por "tipo" "perro"
      Y que tiene por "color" "marrón"
      Cuando guardo el animalito en el repositorio
      Entonces el repositorio me devuelve un animalito
      Y el animalito tiene por "nombre" "Pepito"
      Y el animalito no tiene "edad"
      Y el animalito tiene por "tipo" "perro"
      Y el animalito tiene por "color" "marrón"
      Y tiene un "id" asignado
      Y en el respositorio me queda 1 animalito
