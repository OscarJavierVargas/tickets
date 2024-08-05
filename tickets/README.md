# Proyecto Tickets

Este es un proyecto de ejemplo en Java que utiliza Spring Boot y MySQL para gestionar tickets. A continuacion, te muestro como puedes probar el proyecto en local utilizando Docker para la base de datos.

## Requisitos

tener descargado java 8
- [Java 8]
tener descargado Docker
- [Docker]

## Instrucciones

### 1. Clonar el repositorio

Primero, clona el repositorio en tu maquina local:


git clone <URL_DEL_REPOSITORIO>


Configurar la base de datos:
colocar esta instruccion en la cosola cdm; para crear contenedo de base de datos MySql.
docker run --name prueba -e MYSQL_ROOT_PASSWORD=80144 -e MYSQL_DATABASE=mydatabase -e MYSQL_USER=Oscar -e MYSQL_PASSWORD=80144 -p 3307:3306 -d mysql:latest




Construye el proyecto usando Maven:

cd <NOMBRE_DEL_DIRECTORIO_DEL_REPOSITORIO>
mvn clean install

Luego, ejecuta la aplicacion:
mvn spring-boot:run





La aplicacion deberia estar disponible en http://localhost:8080.


Probar los endpoints
Puedes probar los endpoints de tu aplicacion utilizando herramientas como Postman . Aqui tienes algunos ejemplos de como probar los endpoints:

Listar todos los tickets:

GET http://localhost:8080/tickets
Obtener un ticket por ID:

GET http://localhost:8080/tickets/{id}
Crear un nuevo ticket:

POST http://localhost:8080/tickets



Cuerpo de la solicitud (JSON):
para crear un ticket nuevo con el metodo post: POST http://localhost:8080/tickets
{
  "usuario": "usuario1",
  "estatus": "ABIERTO"
}


Actualizar un ticket:

PUT http://localhost:8080/tickets/{id}
Cuerpo de la solicitud (JSON)

{
  "usuario": "usuario1",
  "fechaCreacion": "2024-08-01T12:00:00",
  "fechaActualizacion": "2024-08-02T12:00:00",
  "estatus": "CERRADO"
}

Eliminar un ticket:

DELETE http://localhost:8080/tickets/{id}


para detner eldocker
docker stop prueba


paginacion:

GET http://localhost:8080/filter

colocar en los parametros los siguientes datos:

usuario= nombre de alguno de los usuarios creados
pageable = el numero de la pagina que quiere ver