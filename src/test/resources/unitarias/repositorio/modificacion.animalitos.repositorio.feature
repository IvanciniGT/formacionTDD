#language:es
  Característica: Modificacion de Animalito en el Repositorio de Animales

    Esquema del escenario: Alta con datos guays. Todos los datos
      Dado que tengo un repositorio vacio
      Y que tengo un animalito
      Y que tiene por "nombre" "<nombre>"
      Y que tiene por "edad" <edad>
      Y que tiene por "tipo" "<tipo>"
      Y que tiene por "color" "<color>"
      Y guardo el animalito en el repositorio
      Cuando modifico al animalito su "nombre" por "<nombre2>"
      Y guardo el animalito en el repositorio
      Y el animalito tiene por "nombre" "<nombre2>"
      Y el animalito tiene por "edad" <edad>
      Y el animalito tiene por "tipo" "<tipo>"
      Y el animalito tiene por "color" "<color>"
      Y tiene un "id" asignado
      Y en el respositorio me queda 1 animalito

      Ejemplos:

        |nombre | edad | tipo  | color | nombre2 |
        |Pepito | 2    | perro | marrón| Cerdito  |
        |Pepita | 3    | gato  | blanco| Cerdita  |
        |Pepote | 4    | pájaro| verde| Cerdote  |
