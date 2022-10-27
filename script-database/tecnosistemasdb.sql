-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 27-10-2022 a las 11:28:53
-- Versión del servidor: 5.7.36
-- Versión de PHP: 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `tecnosistemasdb`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `employee`
--

DROP TABLE IF EXISTS `employee`;
CREATE TABLE IF NOT EXISTS `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `employee`
--

INSERT INTO `employee` (`id`, `name`) VALUES
(4, 'Marce Castaño'),
(6, 'Angela Cristina'),
(7, 'Cristian Mauricio'),
(8, 'Juan Camilo'),
(9, 'Cristian Camilo'),
(12, 'Leonel Gonzalez');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `task`
--

DROP TABLE IF EXISTS `task`;
CREATE TABLE IF NOT EXISTS `task` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  `execution` datetime DEFAULT NULL,
  `employee_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_task_employee_idx` (`employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `task`
--

INSERT INTO `task` (`id`, `name`, `status`, `execution`, `employee_id`) VALUES
(13, 'adadas', 'Pending', '2022-10-27 09:53:10', 4),
(14, 'ALSDSA', 'Pending', '2022-10-27 11:05:22', 4);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `task`
--
ALTER TABLE `task`
  ADD CONSTRAINT `fk_task_employee` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`) ON DELETE SET NULL ON UPDATE SET NULL;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
