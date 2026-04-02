# Gestión de Institutos

Proyecto académico del módulo de **Acceso a Datos** desarrollado en **Java** utilizando **JPA / Hibernate** y **MySQL en Docker**.

## Descripción
Aplicación orientada a la gestión de centros educativos, profesores, especialidades y asignaturas, utilizando persistencia con JPA/Hibernate sobre una base de datos relacional.

## Funcionalidades
- Listado de asignaturas y profesores
- Listado de centros y número total de profesores
- Inserción de asignaturas y profesores
- Interfaz gráfica básica para ejecutar operaciones
- Carga inicial de datos mediante script SQL

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

También incluye relaciones **1:N**, **N:M** y una relación reflexiva en **Profesor** para representar la supervisión o jefatura.

## Contenido del proyecto
- Código fuente Java
- Script de base de datos
- Diagramas UML y de base de datos
- Documentación del proyecto

## Notas
Proyecto realizado con fines académicos dentro del módulo de Acceso a Datos.
