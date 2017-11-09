-- --------------------------------------------------------

--
-- Consultas para la tabla `usuario`
--
-- Mostrara el nombre del usuario y el nombre del tipo de usuario.
SELECT usuario.nombre, tipo_de_usuario.nombre
FROM usuario INNER JOIN tipo_de_usuario USING(idTipo)

SELECT nombre FROM obra
INNER JOIN asignar ON asignar.idObra = obra.idObra

SELECT obra.nombre, asignar.fechaAsignacion 
FROM asignar
INNER JOIN obra USING (idObra)

-- Insertando una nueva Asignacion.
INSERT INTO `asignar`(`fechaAsignacion`, `idObra`) VALUES ("2017-5-3",1);

-- Obteniendo esa ultima asignacion hecha.
SELECT `idAsignacion` FROM `asignar`
ORDER BY idAsignacion DESC LIMIT 1

-- Obtener informacion de las asignaciones.
SELECT detalleAsignar.idDetalle, asignar.idAsignacion, asignar.idObra, asignar.fechaAsignacion, detalleAsignar.idMaterial,detalleAsignar.cantidad 
FROM detalleAsignar
INNER JOIN asignar USING (idAsignacion)
ORDER BY `asignar`.`idObra` ASC

INSERT INTO `detalleAsignar` (`cantidad`, `idMaterial`, `idAsignacion`) VALUES 
('50', '00004', '00001');

SELECT asignar.idAsignacion AS "Codigo de Asignacion", asignar.fechaAsignacion AS "Fecha", obra.nombre, detalleAsignar.cantidad 
FROM detalleAsignar
INNER JOIN asignar USING (idAsignacion)
INNER JOIN obra USING (idObra)  
ORDER BY `Codigo de Asignacion` ASC

SELECT asignar.idAsignacion, asignar.fechaAsignacion, obra.nombre, SUM(detalleAsignar.cantidad)
FROM detalleAsignar
INNER JOIN asignar ON detalleAsignar.idAsignacion = asignar.idAsignacion  
INNER JOIN obra USING (idObra)  
WHERE asignar.idAsignacion = 1
ORDER BY `asignar`.`idAsignacion` ASC

SELECT `nombre`, asignar.idAsignacion, asignar.fechaAsignacion, SUM(detalleAsignar.cantidad)
FROM `obra`
INNER JOIN asignar USING (idObra)
INNER JOIN detalleAsignar USING (idAsignacion)
WHERE asignar.idAsignacion = 2
ORDER BY `asignar`.`idAsignacion` ASC

-- Funcionando! Obtener las la cantidad total de materiales en una asignacion.
SELECT `nombre`, asignar.idAsignacion, asignar.fechaAsignacion, SUM(detalleAsignar.cantidad)
FROM `obra`
INNER JOIN asignar USING (idObra)
INNER JOIN detalleAsignar USING (idAsignacion)
GROUP BY detalleAsignar.idAsignacion

SELECT  asignar.idAsignacion, asignar.fechaAsignacion, `nombre`, encargado, SUM(detalleAsignar.cantidad)
FROM `obra`
INNER JOIN asignar USING (idObra)
INNER JOIN detalleAsignar USING (idAsignacion)
GROUP BY detalleAsignar.idAsignacion  
ORDER BY `asignar`.`fechaAsignacion` DESC

-- Mostrar los materiales que le asigne a una obra en especifico.
SELECT obra.`nombre`, asignar.idAsignacion, asignar.fechaAsignacion, material.nombre, detalleAsignar.cantidad
FROM `obra`
INNER JOIN asignar USING (idObra)
INNER JOIN detalleAsignar USING (idAsignacion)
INNER JOIN material USING (idMaterial)
WHERE asignar.idAsignacion = 1  
ORDER BY `detalleAsignar`.`cantidad` ASC

SELECT obra.`nombre`, asignar.idAsignacion, asignar.fechaAsignacion, material.nombreMaterial, detalleAsignar.cantidad
FROM `obra`
INNER JOIN asignar USING (idObra)
INNER JOIN detalleAsignar USING (idAsignacion)
INNER JOIN material USING (idMaterial)
WHERE asignar.idAsignacion = 1  
ORDER BY `material`.`nombreMaterial` ASC