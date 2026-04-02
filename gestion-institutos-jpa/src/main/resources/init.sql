-- ==========================================
-- 1. CENTROS
-- ==========================================
INSERT INTO Centro (codigo, nombre, localidad) VALUES ('C01', 'IES Palomeras', 'Madrid');
INSERT INTO Centro (codigo, nombre, localidad) VALUES ('C02', 'IES Villa Vallecas', 'Madrid');
INSERT INTO Centro (codigo, nombre, localidad) VALUES ('C03', 'IES Santa Eugenia', 'Madrid');
INSERT INTO Centro (codigo, nombre, localidad) VALUES ('C04', 'IES Madrid Sur', 'Madrid');
INSERT INTO Centro (codigo, nombre, localidad) VALUES ('C05', 'IES Tirso Molina', 'Madrid');

-- ==========================================
-- 2. ESPECIALIDADES
-- ==========================================
INSERT INTO Especialidad (nombre) VALUES ('Matematicas');
INSERT INTO Especialidad (nombre) VALUES ('Lengua');
INSERT INTO Especialidad (nombre) VALUES ('Geografia e Historia');
INSERT INTO Especialidad (nombre) VALUES ('Biologia');
INSERT INTO Especialidad (nombre) VALUES ('Fisica y Quimica');
INSERT INTO Especialidad (nombre) VALUES ('Ingles');
INSERT INTO Especialidad (nombre) VALUES ('Educacion Fisica');
INSERT INTO Especialidad (nombre) VALUES ('Tecnologia');

-- ==========================================
-- 3. ASIGNATURAS
-- ==========================================
INSERT INTO Asignatura (nombre) VALUES ('Matematicas I');
INSERT INTO Asignatura (nombre) VALUES ('Matematicas II');
INSERT INTO Asignatura (nombre) VALUES ('Lengua I');
INSERT INTO Asignatura (nombre) VALUES ('Literatura');
INSERT INTO Asignatura (nombre) VALUES ('Historia');
INSERT INTO Asignatura (nombre) VALUES ('Geografia');
INSERT INTO Asignatura (nombre) VALUES ('Biologia Humana');
INSERT INTO Asignatura (nombre) VALUES ('Geologia');
INSERT INTO Asignatura (nombre) VALUES ('Fisica');
INSERT INTO Asignatura (nombre) VALUES ('Quimica');
INSERT INTO Asignatura (nombre) VALUES ('Ingles I');
INSERT INTO Asignatura (nombre) VALUES ('Ingles II');
INSERT INTO Asignatura (nombre) VALUES ('Educacion Fisica');
INSERT INTO Asignatura (nombre) VALUES ('Tecnologia');
INSERT INTO Asignatura (nombre) VALUES ('Informatica');

-- ==========================================
-- 4. PROFESORES
-- ==========================================

INSERT INTO Profesor (nombre, centro_id, especialidad_id, jefeDepartamento_id) VALUES ('Carlos Matematico', 1, 1, NULL);
INSERT INTO Profesor (nombre, centro_id, especialidad_id, jefeDepartamento_id) VALUES ('Laura Numeros', 1, 1, 1);
INSERT INTO Profesor (nombre, centro_id, especialidad_id, jefeDepartamento_id) VALUES ('Miguel Cervantes', 1, 2, NULL);

-- CENTRO 2: IES Villa Vallecas (Historia)
INSERT INTO Profesor (nombre, centro_id, especialidad_id, jefeDepartamento_id) VALUES ('Isabel Catolica', 2, 3, NULL);
INSERT INTO Profesor (nombre, centro_id, especialidad_id, jefeDepartamento_id) VALUES ('Paco Mapas', 2, 3, 4);

-- CENTRO 3: IES Santa Eugenia (Ciencias)
INSERT INTO Profesor (nombre, centro_id, especialidad_id, jefeDepartamento_id) VALUES ('Ana Celula', 3, 4, NULL);
INSERT INTO Profesor (nombre, centro_id, especialidad_id, jefeDepartamento_id) VALUES ('Marie Curie', 3, 5, NULL);

-- CENTRO 4: IES Madrid Sur (Ingles)
INSERT INTO Profesor (nombre, centro_id, especialidad_id, jefeDepartamento_id) VALUES ('John Smith', 4, 6, NULL);
INSERT INTO Profesor (nombre, centro_id, especialidad_id, jefeDepartamento_id) VALUES ('Mary Johnson', 4, 6, 8);

-- CENTRO 5: IES Tirso Molina (Gimnasia y Tecnologia)
INSERT INTO Profesor (nombre, centro_id, especialidad_id, jefeDepartamento_id) VALUES ('Rafa Nadal', 5, 7, NULL);
INSERT INTO Profesor (nombre, centro_id, especialidad_id, jefeDepartamento_id) VALUES ('Steve Jobs', 5, 8, NULL);
INSERT INTO Profesor (nombre, centro_id, especialidad_id, jefeDepartamento_id) VALUES ('Bill Gates', 5, 8, 11);

-- ==========================================
-- 5. ASIGNACIONES
-- ==========================================

INSERT INTO profesor_asignatura (profesor_id, asignatura_id) VALUES (1, 1); -- Carlos (Jefe) da Matematicas I
INSERT INTO profesor_asignatura (profesor_id, asignatura_id) VALUES (1, 2); -- Carlos (Jefe) también da Matematicas II
INSERT INTO profesor_asignatura (profesor_id, asignatura_id) VALUES (2, 1); -- Laura (Subordinada) da Matematicas I

-- Departamento Lengua
INSERT INTO profesor_asignatura (profesor_id, asignatura_id) VALUES (3, 3); -- Miguel (Jefe) da Lengua I
INSERT INTO profesor_asignatura (profesor_id, asignatura_id) VALUES (3, 4); -- Miguel (Jefe) da Literatura

-- Departamento Historia
INSERT INTO profesor_asignatura (profesor_id, asignatura_id) VALUES (4, 5); -- Isabel (Jefa) da Historia
INSERT INTO profesor_asignatura (profesor_id, asignatura_id) VALUES (5, 6); -- Paco (Subordinado) da Geografia

-- Departamentos de Ciencias
INSERT INTO profesor_asignatura (profesor_id, asignatura_id) VALUES (6, 7); -- Ana (Jefa Bio) da Biologia Humana
INSERT INTO profesor_asignatura (profesor_id, asignatura_id) VALUES (6, 8); -- Ana (Jefa Bio) da Geologia
INSERT INTO profesor_asignatura (profesor_id, asignatura_id) VALUES (7, 9); -- Marie (Jefa F&Q) da Fisica
INSERT INTO profesor_asignatura (profesor_id, asignatura_id) VALUES (7, 10);-- Marie (Jefa F&Q) da Quimica

-- Departamento Ingles
INSERT INTO profesor_asignatura (profesor_id, asignatura_id) VALUES (8, 12); -- John (Jefe) da Ingles II
INSERT INTO profesor_asignatura (profesor_id, asignatura_id) VALUES (9, 11); -- Mary (Subordinada) da Ingles I

-- Departamento Ed. Fisica
INSERT INTO profesor_asignatura (profesor_id, asignatura_id) VALUES (10, 13);-- Rafa (Jefe) da Educacion Fisica

-- Departamento Tecnologia
INSERT INTO profesor_asignatura (profesor_id, asignatura_id) VALUES (11, 14);-- Steve (Jefe) da Tecnologia
INSERT INTO profesor_asignatura (profesor_id, asignatura_id) VALUES (11, 15);-- Steve (Jefe) da Informatica
INSERT INTO profesor_asignatura (profesor_id, asignatura_id) VALUES (12, 15);-- Bill (Subordinado) da Informatica