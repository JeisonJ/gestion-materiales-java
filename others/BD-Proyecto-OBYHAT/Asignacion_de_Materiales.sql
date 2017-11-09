-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 27-04-2017 a las 03:43:55
-- Versión del servidor: 10.1.22-MariaDB
-- Versión de PHP: 7.1.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `Asignacion_de_Materiales`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asignar`
--

CREATE TABLE `asignar` (
  `idAsignacion` int(5) UNSIGNED ZEROFILL NOT NULL,
  `fechaAsignacion` date NOT NULL,
  `idObra` int(5) UNSIGNED ZEROFILL NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `asignar`
--

INSERT INTO `asignar` (`idAsignacion`, `fechaAsignacion`, `idObra`) VALUES
(00001, '2017-04-12', 00001),
(00002, '2017-04-25', 00002),
(00003, '2017-05-03', 00001);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalleAsignar`
--

CREATE TABLE `detalleAsignar` (
  `idDetalle` int(5) UNSIGNED ZEROFILL NOT NULL,
  `cantidad` int(4) NOT NULL,
  `idMaterial` int(5) UNSIGNED ZEROFILL NOT NULL,
  `idAsignacion` int(5) UNSIGNED ZEROFILL NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `detalleAsignar`
--

INSERT INTO `detalleAsignar` (`idDetalle`, `cantidad`, `idMaterial`, `idAsignacion`) VALUES
(00001, 50, 00003, 00001),
(00002, 500, 00010, 00001),
(00003, 45, 00004, 00001),
(00004, 58, 00001, 00002),
(00005, 25, 00001, 00001),
(00006, 20, 00001, 00003);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `material`
--

CREATE TABLE `material` (
  `idMaterial` int(5) UNSIGNED ZEROFILL NOT NULL,
  `nombre` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `existencia` int(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `material`
--

INSERT INTO `material` (`idMaterial`, `nombre`, `existencia`) VALUES
(00001, 'Clavos', 1000),
(00002, 'Cabillas 3x2', 1000),
(00003, 'Cemento', 1000),
(00004, 'Arena', 1000),
(00005, 'Cabillas 2x10', 1000),
(00006, 'Tractor', 1000),
(00007, 'Cepillo', 1000),
(00008, 'Perrito', 1000),
(00009, 'Gatito', 1000),
(00010, 'Martillos', 1000),
(00011, 'Baldosas', 1000),
(00012, 'Picos', 1000),
(00013, 'Palas', 1000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `obra`
--

CREATE TABLE `obra` (
  `idObra` int(5) UNSIGNED ZEROFILL NOT NULL,
  `nombre` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `direccion` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `obra`
--

INSERT INTO `obra` (`idObra`, `nombre`, `direccion`) VALUES
(00001, 'Obra 1', 'Av. San Diego'),
(00002, 'Obra 2', 'Av. Intercomunal'),
(00003, 'Obra 3', 'Av. San Diego'),
(00004, 'Obra 4', 'Av. Intercomunal'),
(00005, 'Obra 5', 'Av. Bolivar Norte'),
(00006, 'Obra 6', 'Av. Terepaima'),
(00007, 'Obra 7', 'Av. San Jose de Tarbez'),
(00008, 'Obra 8', 'Av. LizandroLecuna'),
(00009, 'Obra 9', 'Av. Bolivar Sur'),
(00010, 'Obra 10', 'Av. Los Almendrones'),
(00011, 'Obra 11', 'Av. 190'),
(00012, 'Obra 12', 'Av. 191'),
(00013, 'Obra 13', 'Av. 192');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `asignar`
--
ALTER TABLE `asignar`
  ADD PRIMARY KEY (`idAsignacion`),
  ADD KEY `idObra` (`idObra`);

--
-- Indices de la tabla `detalleAsignar`
--
ALTER TABLE `detalleAsignar`
  ADD PRIMARY KEY (`idDetalle`),
  ADD KEY `idMaterial` (`idMaterial`),
  ADD KEY `idAsignacion` (`idAsignacion`);

--
-- Indices de la tabla `material`
--
ALTER TABLE `material`
  ADD PRIMARY KEY (`idMaterial`),
  ADD UNIQUE KEY `nombre` (`nombre`);

--
-- Indices de la tabla `obra`
--
ALTER TABLE `obra`
  ADD PRIMARY KEY (`idObra`),
  ADD UNIQUE KEY `nombre` (`nombre`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `asignar`
--
ALTER TABLE `asignar`
  MODIFY `idAsignacion` int(5) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `detalleAsignar`
--
ALTER TABLE `detalleAsignar`
  MODIFY `idDetalle` int(5) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT de la tabla `material`
--
ALTER TABLE `material`
  MODIFY `idMaterial` int(5) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT de la tabla `obra`
--
ALTER TABLE `obra`
  MODIFY `idObra` int(5) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `asignar`
--
ALTER TABLE `asignar`
  ADD CONSTRAINT `asignar_ibfk_1` FOREIGN KEY (`idObra`) REFERENCES `obra` (`idObra`);

--
-- Filtros para la tabla `detalleAsignar`
--
ALTER TABLE `detalleAsignar`
  ADD CONSTRAINT `detalleAsignar_ibfk_1` FOREIGN KEY (`idMaterial`) REFERENCES `material` (`idMaterial`),
  ADD CONSTRAINT `detalleAsignar_ibfk_2` FOREIGN KEY (`idAsignacion`) REFERENCES `asignar` (`idAsignacion`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
