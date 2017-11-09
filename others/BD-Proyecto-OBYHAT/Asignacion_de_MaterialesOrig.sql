CREATE DATABASE Asignacion_de_Materiales;
USE Asignacion_de_Materiales;

CREATE TABLE `material` (
  `idMaterial`     INTEGER(5)   UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT,
  `nombre` 		   VARCHAR(100) DEFAULT NULL,
  `existencia`     INTEGER(5)   DEFAULT NULL,
  UNIQUE (nombre),
  PRIMARY KEY (`idMaterial`)) 
ENGINE INNODB;

CREATE TABLE `obra` (
  `idObra` 		INTEGER(5)   UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT,
  `nombre`  	VARCHAR(100) NOT NULL,
  `direccion` 	VARCHAR(100) NOT NULL,
  PRIMARY KEY (idObra),
  UNIQUE (nombre)) 
ENGINE INNODB;

CREATE TABLE `asignar` (
  `idAsignacion` 	INTEGER(5) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT,
  `fechaAsignacion` DATE 	   NOT NULL,
  `idObra` 	   		INTEGER(5) UNSIGNED ZEROFILL NOT NULL,
  PRIMARY KEY (idAsignacion),
  FOREIGN KEY (idObra)     REFERENCES `obra`(idObra))
  ENGINE INNODB;

CREATE TABLE detalleAsignar (
  `idDetalle`    INTEGER(5) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT,
  `cantidad`     INTEGER(4) NOT NULL,
  `idMaterial`   INTEGER(5) UNSIGNED ZEROFILL NOT NULL,
  `idAsignacion` INTEGER(5) UNSIGNED ZEROFILL NOT NULL,
  PRIMARY KEY (idDetalle),
  FOREIGN KEY (idMaterial) REFERENCES `material`(idMaterial),
  FOREIGN KEY (idAsignacion) REFERENCES `asignar`(idAsignacion)) 
ENGINE INNODB;