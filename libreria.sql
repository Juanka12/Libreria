-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 21-01-2021 a las 10:01:52
-- Versión del servidor: 10.4.11-MariaDB
-- Versión de PHP: 7.4.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `libreria`
--

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `addBook` (IN `myisbn` VARCHAR(13), IN `myautor` VARCHAR(50), IN `mytitulo` VARCHAR(50), IN `myeditorial` VARCHAR(50), IN `mygenero` INT(10), IN `myestado` INT(10), IN `myformato` INT(10), IN `mycantidad` INT(11), IN `myprecio` FLOAT)  NO SQL
BEGIN
INSERT INTO libro(`isbn`,`autor`,`titulo`,`editorial`,`tematica`,`estado`,`formato`,`unidades`,`precio`) VALUES(myisbn,myautor,mytitulo,myeditorial,mygenero,myestado,myformato,mycantidad,myprecio);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `removeBook` (IN `myisbn` VARCHAR(13))  NO SQL
BEGIN
DELETE FROM libro WHERE isbn = myisbn;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `updateCantidad` (IN `myisbn` VARCHAR(13), IN `mycantidad` INT(11))  NO SQL
BEGIN
UPDATE libro set unidades = (SELECT `unidades` FROM `libro` WHERE `isbn` = myisbn)-mycantidad WHERE isbn = myisbn;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `vaciarTabla` ()  NO SQL
BEGIN
TRUNCATE TABLE libro;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estado`
--

CREATE TABLE `estado` (
  `id` tinyint(126) NOT NULL,
  `nombre` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `estado`
--

INSERT INTO `estado` (`id`, `nombre`) VALUES
(2, 'Novedad'),
(1, 'Reedicion');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `formato`
--

CREATE TABLE `formato` (
  `id` tinyint(126) NOT NULL,
  `nombre` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `formato`
--

INSERT INTO `formato` (`id`, `nombre`) VALUES
(1, 'Cartone'),
(4, 'Espiral'),
(3, 'Grapada'),
(2, 'Rustica');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libro`
--

CREATE TABLE `libro` (
  `id` int(11) NOT NULL,
  `isbn` varchar(13) COLLATE utf8_unicode_ci NOT NULL,
  `autor` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `titulo` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `editorial` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `tematica` tinyint(126) NOT NULL,
  `estado` tinyint(126) NOT NULL,
  `formato` tinyint(126) NOT NULL,
  `unidades` int(11) NOT NULL,
  `precio` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `libro`
--

INSERT INTO `libro` (`id`, `isbn`, `autor`, `titulo`, `editorial`, `tematica`, `estado`, `formato`, `unidades`, `precio`) VALUES
(3, '1111111111111', 'Yo', 'Prueba', 'Nueva', 1, 1, 1, 4, 300000),
(4, '2222222222222', 'Rumpelstiltskin', 'Donde cazar gamusinos', 'PatataBrava', 3, 2, 2, 6, 39.45),
(5, '3333333333333', 'Otro', 'Nuevo', 'Dam', 1, 1, 1, 2, 23),
(6, '4444444444444', 'Jdbc', 'Nuevo', 'RowSet', 1, 1, 1, 4, 26);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tematica`
--

CREATE TABLE `tematica` (
  `id` tinyint(126) NOT NULL,
  `nombre` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `tematica`
--

INSERT INTO `tematica` (`id`, `nombre`) VALUES
(2, 'Accion'),
(1, 'Aventura'),
(7, 'Distopica'),
(4, 'Fantasia'),
(6, 'Paranormal'),
(5, 'Romance'),
(3, 'Terror');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `estado`
--
ALTER TABLE `estado`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nombre` (`nombre`);

--
-- Indices de la tabla `formato`
--
ALTER TABLE `formato`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nombre` (`nombre`);

--
-- Indices de la tabla `libro`
--
ALTER TABLE `libro`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `isbn` (`isbn`),
  ADD KEY `formato` (`formato`),
  ADD KEY `estado` (`estado`),
  ADD KEY `tematica` (`tematica`);

--
-- Indices de la tabla `tematica`
--
ALTER TABLE `tematica`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nombre` (`nombre`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `estado`
--
ALTER TABLE `estado`
  MODIFY `id` tinyint(126) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `formato`
--
ALTER TABLE `formato`
  MODIFY `id` tinyint(126) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `libro`
--
ALTER TABLE `libro`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `tematica`
--
ALTER TABLE `tematica`
  MODIFY `id` tinyint(126) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `libro`
--
ALTER TABLE `libro`
  ADD CONSTRAINT `libro_ibfk_1` FOREIGN KEY (`formato`) REFERENCES `formato` (`id`),
  ADD CONSTRAINT `libro_ibfk_2` FOREIGN KEY (`estado`) REFERENCES `estado` (`id`),
  ADD CONSTRAINT `libro_ibfk_3` FOREIGN KEY (`tematica`) REFERENCES `tematica` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
