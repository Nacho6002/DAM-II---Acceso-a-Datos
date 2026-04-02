# Gestión de Institutos

Proyecto académico del módulo de **Acceso a Datos** desarrollado en **Java** utilizando **JPA/Hibernate** y **MySQL en Docker**.

## Descripción
Esta aplicación permite gestionar información de centros educativos, profesores, especialidades y asignaturas a partir de un modelo relacional.

El proyecto trabaja con persistencia mediante JPA/Hibernate y permite realizar distintas operaciones sobre los datos a través de una interfaz sencilla.

## Funcionalidades
- Listado de asignaturas y profesores
- Listado de centros y número total de profesores
- Inserción de asignaturas y profesores
- Interfaz gráfica básica para ejecutar operaciones
- Carga inicial de datos desde script SQL

## Tecnologías utilizadas
- Java
- JPA / Hibernate
- MySQL
- Docker
- Eclipse

## Diseño de base de datos
El sistema parte de un modelo con entidades como:
- Centro
- Profesor
- Especialidad
- Asignatura

También incluye relaciones 1:N, N:M y una relación reflexiva en Profesor para representar la supervisión/jefatura.

## Contenido del proyecto
- Código fuente Java
- Script de base de datos
- Diagramas UML y de base de datos
- Documentación del proyecto

## Notas
Proyecto realizado con fines académicos dentro del módulo de Acceso a Datos.
