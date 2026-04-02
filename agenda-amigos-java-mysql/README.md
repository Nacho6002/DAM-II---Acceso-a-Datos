# Agenda de Amigos

Proyecto académico del módulo de **Acceso a Datos** desarrollado en **Java**, con interfaz gráfica en **Swing** y conexión a **MySQL**.

## Descripción
Aplicación de escritorio orientada a la gestión de una agenda de amigos, permitiendo registrar sus datos personales y asociarlos a una pandilla.

El proyecto aplica una arquitectura basada en el patrón **DAO**, separando la lógica de acceso a datos de la interfaz gráfica y facilitando el mantenimiento del código.

## Funcionalidades
- Alta de amigos
- Listado de registros
- Búsqueda por nombre o teléfono
- Modificación de datos
- Asociación de amigos con una pandilla
- Persistencia de datos en MySQL

## Tecnologías utilizadas
- Java
- Swing
- JDBC
- MySQL
- Docker
- Eclipse

## Diseño de base de datos
El modelo parte de dos entidades principales:
- **Amigo**
- **Pandilla**

La relación entre ambas es de **1:N**, donde una pandilla puede tener varios amigos y cada amigo pertenece a una única pandilla.

## Contenido del proyecto
- Código fuente Java
- Script de base de datos
- Diagramas UML y de base de datos
- Documentación del proyecto

## Notas
Proyecto realizado con fines académicos dentro del módulo de Acceso a Datos.
