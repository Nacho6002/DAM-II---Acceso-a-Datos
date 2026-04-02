DROP DATABASE IF EXISTS mis_amigos;
CREATE DATABASE mis_amigos CHARSET utf8mb4;
USE mis_amigos;

-- Tabla 1: PANDILLA
CREATE TABLE pandilla (
    id_pandilla INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    lugar_vacaciones VARCHAR(50)
) ENGINE=InnoDB;

-- Tabla 2: AMIGOS
CREATE TABLE amigo (
    id_amigo INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    direccion VARCHAR(100),
    telefono VARCHAR(15),
    aficiones VARCHAR(100),
    id_pandilla INT NOT NULL,
    CONSTRAINT fk_amigo_pandilla FOREIGN KEY (id_pandilla) REFERENCES pandilla(id_pandilla) ON DELETE CASCADE
) ENGINE=InnoDB;

-- INSERCIÓN DE DATOS INICIALES (Pandillas)
INSERT INTO pandilla (nombre, lugar_vacaciones) VALUES ('Los del Barrio', 'Benidorm');
INSERT INTO pandilla (nombre, lugar_vacaciones) VALUES ('Frikis del insti', 'Japón');
INSERT INTO pandilla (nombre, lugar_vacaciones) VALUES ('Equipo Futbol', 'Madrid');

-- INSERCIÓN DE DATOS INICIALES (Amigos)
INSERT INTO amigo (nombre, direccion, telefono, aficiones, id_pandilla)
VALUES ('Carlos Perez', 'Calle Mayor 1', '600111222', 'Fútbol, Videojuegos', 1);

INSERT INTO amigo (nombre, direccion, telefono, aficiones, id_pandilla)
VALUES ('Lucia Gomez', 'Plaza Sol 2', '600333444', 'Música, Leer', 1);

INSERT INTO amigo (nombre, direccion, telefono, aficiones, id_pandilla)
VALUES ('Mario Bross', 'Calle Champiñón 3', '600555666', 'Videojuegos, Anime', 2);

INSERT INTO amigo (nombre, direccion, telefono, aficiones, id_pandilla)
VALUES ('Ana Torres', 'Avenida Estadio 4', '600777888', 'Fútbol, Atletismo', 3);