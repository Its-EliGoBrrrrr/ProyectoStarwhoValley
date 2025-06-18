-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 18-06-2025 a las 02:34:03
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `starwho_valley`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `preguntas`
--

CREATE TABLE `preguntas` (
  `id` int(11) NOT NULL,
  `Pregunta` varchar(128) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `preguntas`
--

INSERT INTO `preguntas` (`id`, `Pregunta`) VALUES
(1, '¿Tu personaje es un Hombre?'),
(2, '¿Tu personaje es una mujer?'),
(3, '¿Tu personaje es un Hombre?'),
(4, '¿Tu personaje es una mujer?'),
(5, '¿Tu personaje es un adulto?'),
(6, '¿Tu personaje es un joven?'),
(7, '¿Tu personaje es un anciano?'),
(8, '¿Tu personaje es calvo?'),
(9, '¿Tu personaje tiene lentes?'),
(10, '¿Tu personaje tiene cejas delgadas?'),
(11, '¿Tu personaje tiene cejas pobladas?'),
(12, '¿Tu personaje pelo largo?'),
(13, '¿Tu personaje tiene pelo corto?'),
(14, '¿Tu personaje tiene pelo negro?'),
(15, '¿Tu personaje tiene pelo rubio?'),
(16, '¿Tu personaje tiene pelo castaño?'),
(17, '¿Tu personaje tiene lentes?'),
(18, '¿Tu personaje tiene ojos azules?'),
(19, '¿Tu personaje tiene ojos marrones?'),
(20, '¿Tu personaje tiene ojos azules?'),
(21, '¿Tu personaje tiene ojos verdes?'),
(22, '¿Tu personaje tiene ropa negra?'),
(23, '¿Tu personaje tiene ropa verde?'),
(24, '¿Tu personaje tiene ropa roja?'),
(25, '¿Tu personaje tiene ropa azul?'),
(26, '¿Tu personaje tiene ropa gris?'),
(27, '¿Tu personaje tiene piel clara?'),
(28, '¿Tu personaje tiene piel oscura?'),
(29, '¿Tu personaje esta bronceado?'),
(30, '¿Tu personaje tiene un gorro en la cabeza?'),
(31, '¿Tu personaje tiene barba?');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `preguntas`
--
ALTER TABLE `preguntas`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `preguntas`
--
ALTER TABLE `preguntas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
