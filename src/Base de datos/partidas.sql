-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 23-06-2025 a las 03:00:16
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
-- Estructura de tabla para la tabla `partidas`
--

CREATE TABLE `partidas` (
  `ID` int(11) NOT NULL,
  `Jugador_1` varchar(25) NOT NULL,
  `Jugador_2` varchar(25) NOT NULL,
  `Ganador` varchar(25) NOT NULL,
  `Personaje` varchar(20) NOT NULL,
  `Fecha` date NOT NULL,
  `Duracion_partida` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `partidas`
--

INSERT INTO `partidas` (`ID`, `Jugador_1`, `Jugador_2`, `Ganador`, `Personaje`, `Fecha`, `Duracion_partida`) VALUES
(1, 'Jugador1', 'Jugador2', 'Jugador1', 'Lewis', '2025-06-22', '00:01:53'),
(2, 'Jugador1', 'Jugador2', '', '', '2025-06-22', '00:00:30'),
(3, 'Jugador1', 'Jugador2', 'Jugador1', 'Jodi', '2025-06-22', '00:00:10'),
(4, 'jugador1', 'jugador2', '', '', '2025-06-22', '00:00:19'),
(5, 'Oziel', 'Adriano', 'Adriano', 'Jodi', '2025-06-22', '00:00:23'),
(6, 'Fer', 'Adriano', 'Fer', 'Leah', '2025-06-22', '00:00:11'),
(7, 'Jugador1', 'Jugador2', 'Jugador1', 'Caroline', '2025-06-22', '00:00:24'),
(8, 'Jugador1', 'Jugador2', 'Jugador2', 'Penny', '2025-06-22', '00:00:15'),
(9, 'Jugador1', 'Jugador2', 'Jugador1', 'Penny', '2025-06-22', '00:00:27'),
(10, 'Jugador1', 'Jugador2', 'Jugador1', 'Mr Qi', '2025-06-22', '00:01:02'),
(11, 'Jugador1', 'Jugador2', 'Jugador2', 'Marnie', '2025-06-22', '00:03:29'),
(12, 'Jugador1', 'Jugador2', 'Jugador1', 'Linus', '2025-06-22', '00:00:11');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `partidas`
--
ALTER TABLE `partidas`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `partidas`
--
ALTER TABLE `partidas`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
