CREATE DATABASE proyectoobyhat;
  USE proyectoobyhat;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedor`
--

CREATE TABLE `proveedor` (
  `rif` 		        VARCHAR(20)   NOT NULL,
  `razonSocial`     VARCHAR(150)  NOT NULL,
  `telefono` 	      VARCHAR(25)   NOT NULL,
  `direccion` 	    VARCHAR(100)  NOT NULL,
  `email`           VARCHAR(80)   DEFAULT NULL,
  PRIMARY KEY(rif),
  UNIQUE (razonSocial)) 
ENGINE INNODB;

-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `categoriaMaterial`
--

CREATE TABLE `categoriaMaterial` (
  `idCategoria`   INTEGER(5)   UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT,
  `nombre`  	    VARCHAR(80)  NOT NULL,
  `descripcion`   VARCHAR(100) DEFAULT NULL,
  PRIMARY KEY (idCategoria),
  UNIQUE (nombre)) 
ENGINE INNODB;

--
-- Volcado de datos para la tabla `categoriaMaterial`
--

INSERT INTO `categoriaMaterial` (`idCategoria`,`nombre`, `descripcion`) VALUES
(00001, 'Seleccionar categoria...', '-OPCIONAL-'),
(00002, 'Piedra',     '-OPCIONAL-'),
(00003, 'Arena',      '-OPCIONAL-'),
(00004, 'Arcilla',    '-OPCIONAL-'),
(00005, 'Metálicos',  '-OPCIONAL-'),
(00006, 'Orgánico',   '-OPCIONAL-'),
(00007, 'Sintéticos', '-OPCIONAL-'),
(00008, 'Vidrios',    '-OPCIONAL-');

-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `material`
--

/*
CREATE TABLE `material` (
  `idMaterial`      INTEGER(5)   UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT,
  `nombreMaterial`  VARCHAR(100) DEFAULT NULL,
  `cantidadMaterial`INTEGER(5)   DEFAULT NULL,
  `existenciaMIN`   INTEGER(5)   DEFAULT NULL,
  `existenciaMAX`   INTEGER(5)   DEFAULT NULL,
  `fechaRegistro`   DATE         DEFAULT NULL,
  UNIQUE (nombreMaterial),
  PRIMARY KEY (`idMaterial`)) 
ENGINE INNODB;
*/

CREATE TABLE `material` (
  `idMaterial` 	    INTEGER(5)   NOT NULL AUTO_INCREMENT,
  `nombreMaterial`  VARCHAR(100) NOT NULL,
  `cantidadMaterial`INTEGER(5)   DEFAULT 0,
  `existenciaMIN`   INTEGER(5)   DEFAULT NULL,
  `existenciaMAX`   INTEGER(5)   DEFAULT NULL,
  `fechaRegistro`   DATE         NOT NULL,
  UNIQUE (nombreMaterial),
  PRIMARY KEY (`idMaterial`)) 
ENGINE INNODB;

--
-- Volcado de datos para la tabla `material`
--

INSERT INTO `material` (`nombreMaterial`,`idCategoria`) VALUES
-- Solo es necesario insertar el nombre del material y el id de proveedor.
-- Ejemplo:
('Palas' ,2),
('Cascos',3);

--
-- Índices para tablas volcadas
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compra`
--
/*
CREATE TABLE `compra` (
  `idOrdenLlegada` INTEGER(5) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT,
  `fechaLlegada`   DATE	      NOT NULL,
  `cantidad` 	     INTEGER(4) NOT NULL,
  `rif` 		       VARCHAR(20)NOT NULL,
  `idMaterial` 	   INTEGER(5) UNSIGNED ZEROFILL NOT NULL,
   PRIMARY KEY(idOrdenLlegada,rif,idMaterial),
   FOREIGN KEY(rif) 	     REFERENCES `proveedor`(rif),
   FOREIGN KEY(idMaterial) REFERENCES `material`(idMaterial)) 
ENGINE INNODB;
*/
CREATE TABLE `compra` (
  `idOrdenLlegada`  INTEGER(5)  NOT NULL AUTO_INCREMENT,
  `fechaLlegada`    DATE	    NOT NULL,
  `rif` 		    VARCHAR(20) NOT NULL,
   PRIMARY KEY(idOrdenLlegada,rif),
   FOREIGN KEY(rif) REFERENCES `proveedor`(rif)) 
ENGINE INNODB;

CREATE TABLE `detalleCompra` (
  `idOrdenLlegada` 	INTEGER(5) 		 NOT NULL AUTO_INCREMENT,
  `idMaterial`   	INTEGER(5) 		 NOT NULL,
  `cantidad`     	INTEGER(4) 		 NOT NULL,
  FOREIGN KEY    	(idMaterial) 	 REFERENCES `material`(idMaterial),
  FOREIGN KEY    	(idOrdenLlegada) REFERENCES `compra`(idOrdenLlegada)) 
ENGINE INNODB;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_de_usuario`
--

CREATE TABLE `tipo_de_usuario` (
  `idTipo` INTEGER(5) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(40) NOT NULL,
  PRIMARY KEY (idTipo),
  UNIQUE (nombre)) 
ENGINE INNODB;

--
-- Volcado de datos para la tabla `tipo_de_usuario`
--

INSERT INTO `tipo_de_usuario` (`idTipo`,`nombre`) VALUES
(00001, 'Seleccione un tipo de usuario...'),
(00002, 'Administrador'),
(00003, 'Chismoso'),
(00004, 'Desarrollador'),
(00005, 'Empleado'),
(00006, 'Mantenedor');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `idUsuario` INTEGER(5)  UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT,
  `nombre` 	  VARCHAR(40) NOT NULL,
  `password`  VARCHAR(20) NOT NULL,
  `idTipo` 	  INTEGER(5)  UNSIGNED ZEROFILL NOT NULL,
  UNIQUE (nombre),
  PRIMARY KEY (idUsuario,idTipo),
  FOREIGN KEY(idTipo) REFERENCES `tipo_de_usuario`(idTipo)) 
ENGINE INNODB;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`idUsuario`,`nombre`, `password`,idTipo) VALUES
(00001, 'Fernando', 'Admin',  00003),
(00002, 'User',     'User',   00002),
(00003, 'Zophia',   'zophia', 00002),
(00004, 'Pepe',     'pepe',   00002),
(00005, 'juan',     '2445',   00004),
(00006, 'Coco',     '5655',   00003),
(00007, 'Desarrolladores',    '123', 00002);

-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `obra`
--

CREATE TABLE `obra` (
  `idObra` 		 INTEGER(5)   UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT,
  `nombre`  	 VARCHAR(100) NOT NULL,
  `encargado`  VARCHAR(80)  NOT NULL,
  `telefono` 	 VARCHAR(20)  NOT NULL,
  `direccion`  VARCHAR(100) NOT NULL,
  PRIMARY KEY (idObra),
  UNIQUE (nombre)) 
ENGINE INNODB;

--
-- Volcado de datos para la tabla `obra`
--

INSERT INTO `obra` (`idObra`, `nombre`, `encargado`, `telefono`, `direccion`) VALUES
(00001, 'Seleccione una obra...', '', '', ''),
(00002, 'El coronel no tiene quien le escriba', 'G. G. Marquez', '1961', 'America Latina'),
(00003, 'La mala hora', 'G. G. Marquez', '1962', 'America Latina'),
(00004, 'Cien años de soledad', 'G. G. Marquez', '1967', 'America Latina'),
(00006, 'Crónica de una muerte anunciada', 'G. G. Marquez', '1981', 'America Latina'),
(00007, 'El amor en los tiempos del cólera', 'G. G. Marquez', '1985', 'America Latina'),
(00008, 'El general en su laberinto', 'G. G. Marquez', '1989', 'America Latina'),
(00009, 'Del amor y otros demonios', 'G. G. Marquez', '1994', 'America Latina'),
(00010, 'Ojos de perro azul', 'G. G. Marquez', '1972', 'America Latina'),
(00011, 'Memoria de mis putas tristes', 'G. G. Marquez', '2004', 'America Latina'),
(00012, 'Los cuentos de mi abuelo el coronel', 'G. G. Marquez', '1988', 'America Latina'),
(00013, 'Doce cuentos peregrinos', 'G. G. Marquez', '1992', 'America Latina'),
(00014, 'Relato de un náufrago', 'G. G. Marquez', '1970', 'America Latina'),
(00017, 'Prueba', 'Pedro', '1234', 'AV. Direccion'),
(00023, 'swsw', 'sws', '1', 'qsq');

--
-- Estructura de tabla para la tabla `asignar`
--

/*CREATE TABLE `asignar` (
  *`idOrdenSalida` 	INTEGER(5) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT,
  *`fechaAsignacion` DATE 	   NOT NULL,
  *`cantidad`        INTEGER(4) NOT NULL,
  *`idMaterial` 	    INTEGER(5) UNSIGNED ZEROFILL NOT NULL,
  *`idUsuario`       INTEGER(5) UNSIGNED ZEROFILL NOT NULL,
  *`idObra` 		    INTEGER(5) UNSIGNED ZEROFILL NOT NULL,
  *PRIMARY KEY (idOrdenSalida,idMaterial,idUsuario),
  *FOREIGN KEY (idMaterial) REFERENCES `material`(idMaterial),
  *FOREIGN KEY (idUsuario)  REFERENCES `usuario`(idUsuario),
  *FOREIGN KEY (idObra)     REFERENCES `obra`(idObra)) 
*ENGINE INNODB;*/

-- --------------------------------------------------------

CREATE TABLE `asignar` (
  `idAsignacion`    INTEGER(5) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT,
  `fechaAsignacion` DATE     NOT NULL,
  `idObra`          INTEGER(5) UNSIGNED ZEROFILL NOT NULL,
  PRIMARY KEY (idAsignacion),
  FOREIGN KEY (idObra) REFERENCES `obra`(idObra)) 
ENGINE INNODB;

--
-- Volcado de datos para la tabla `asignar`
--

INSERT INTO `asignar` (`idAsignacion`, `fechaAsignacion`, `idObra`) VALUES
(00001, '2017-04-12', 00001),
(00002, '2017-04-25', 00002),
(00003, '2017-05-03', 00001),
(00018, '2017-04-06', 00004),
(00019, '2017-05-18', 00008),
(00020, '2017-05-12', 00007),
(00021, '2017-05-06', 00003),
(00022, '2017-05-06', 00003),
(00023, '2017-05-05', 00004),
(00024, '2017-05-05', 00004),
(00025, '2017-05-05', 00004),
(00029, '2017-05-05', 00014),
(00033, '0207-03-03', 00001),
(00034, '2017-05-06', 00013),
(00035, '2017-05-06', 00013),
(00036, '2017-05-06', 00014),
(00039, '2017-05-19', 00004),
(00040, '2017-05-05', 00001),
(00041, '2017-05-13', 00006),
(00042, '2017-05-05', 00017);

--
-- Índices para tablas volcadas
--
-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `obra`
--

/*CREATE TABLE `detalleAsignar` (
  `idDetalle`    INTEGER(5) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT,
  `cantidad`     INTEGER(4) NOT NULL,
  `idMaterial`   INTEGER(5) UNSIGNED ZEROFILL NOT NULL,
  `idAsignacion` INTEGER(5) UNSIGNED ZEROFILL NOT NULL,
  PRIMARY KEY    (`idDetalle`),
  FOREIGN KEY    (idMaterial) REFERENCES `material`(idMaterial),
  FOREIGN KEY    (idAsignacion) REFERENCES `asignar`(idAsignacion)) 
ENGINE INNODB;
*/
CREATE TABLE `detalleAsignar` (
  `idAsignacion` INTEGER(5) UNSIGNED ZEROFILL NOT NULL,
  `cantidad`     INTEGER(4) NOT NULL,
  `idMaterial`   INTEGER(5) NOT NULL,
  FOREIGN KEY    (idMaterial) REFERENCES `material`(idMaterial),
  FOREIGN KEY    (idAsignacion) REFERENCES `asignar`(idAsignacion)) 
ENGINE INNODB;
--
-- Volcado de datos para la tabla `detalleAsignar`
--

INSERT INTO `detalleAsignar` (`cantidad`, `idMaterial`, `idAsignacion`) VALUES
(50, 00004, 00001),
(50, 00004, 00001),
(50, 00004, 00001),
(5, 00004, 00042);

--
-- Índices para tablas volcadas
--
