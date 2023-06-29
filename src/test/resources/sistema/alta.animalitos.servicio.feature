#language:es

Característica: Micro-servicio de alta de animalitos

  Escenario: Alta de un animalito con datos adecuados
        Dado un objeto JSON
           Y el objeto JSON tiene por valor del campo "nombre": "Luciano"
           Y el objeto JSON tiene por valor del campo "tipo": "Periquito"
           Y el objeto JSON tiene por valor del campo "color": "verde lima"
           Y el objeto JSON tiene por valor del campo "edad": 6
      Cuando invoco al servicio "/api/v1/animalitos" con método "POST" y envío ese objeto JSON
    Entonces el servicio debe contestar con código http "CREATED"
           Y el servicio debería devolver un objeto json
           Y el objeto JSON debe tener por valor del campo "nombre": "Luciano"
           Y el objeto JSON debe tener por valor del campo "tipo": "Periquito"
           Y el objeto JSON debe tener por valor del campo "color": "verde lima"
           Y el objeto JSON debe tener por valor del campo "edad": 6
           Y el objeto JSON debe tener por valor del campo "id" un número
           Y se debe haber añadido el animalito a la BBDD en la tabla "ANIMALITOS"
           Y en esa tabla se debe haber introducido el campo "name", con el valor "Luciano"
           Y en esa tabla se debe haber introducido el campo "type", con el valor "Periquito"
           Y en esa tabla se debe haber introducido el campo "color", con el valor "verde lima"
           Y en esa tabla se debe haber introducido el campo "age", con el valor 6
           Y en esa tabla se debe haber introducido el campo "id", con un valor numérico
           Y se debe haber enviado un email a: "gestion@animalitosfelipe.com"
           Y ese email debe tener en el asunto "Nuevo animalito"
           Y ese email debe tener en el cuerpo "Luciano"
           Y ese email debe tener en el cuerpo "Periquito"


#  Escenario: Modificación de un animalito con datos adecuados
#    Dado que tengo en la BBDD de animalitos un animalito con id 1
#    Y un objeto JSON
#    Y el objeto JSON tiene por valor del campo "nombre": "Lucianito"
#    Y el objeto JSON tiene por valor del campo "tipo": "Periquito"
#    Y el objeto JSON tiene por valor del campo "color": "verde limón"
#    Y el objeto JSON tiene por valor del campo "edad": 7
#    Cuando invoco al servicio "/api/v1/animalitos/1" con método "PUT" y envío ese objeto JSON
#    Entonces el servicio debe contestar con código http "200"
#    Y el servicio debería devolver un objeto json
#    Y el objeto JSON debe tener por valor del campo "nombre": "Lucianito"
#    Y el objeto JSON debe tener por valor del campo "tipo": "Periquito"
#    Y el objeto JSON debe tener por valor del campo "color": "verde limón"
#    Y el objeto JSON debe tener por valor del campo "edad": 7
#    Y el objeto JSON debe tener por valor del campo "id": 1
#    Y se debe haber modificado el animalito a la BBDD en la tabla "ANIMALITOS"
#    Y en esa tabla se debe haber introducido el campo "name", con el valor "Lucianito"
#    Y en esa tabla se debe haber introducido el campo "type", con el valor "Periquito"
#    Y en esa tabla se debe haber introducido el campo "color", con el valor "verde limón"
#    Y en esa tabla se debe haber introducido el campo "age", con el valor 7
#    Y en esa tabla se debe haber introducido el campo "id" con el valor 1
