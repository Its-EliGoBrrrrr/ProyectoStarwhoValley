-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 23-06-2025 a las 03:02:01
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
(2, 'Jugador1', 'Jugador2', 'Jugador2', 'Alex', '2025-06-22', '00:00:30'),
(3, 'Jugador1', 'Jugador2', 'Jugador1', 'Jodi', '2025-06-22', '00:00:10'),
(4, 'jugador1', 'jugador2', 'jugador2', 'Sam', '2025-06-22', '00:00:19'),
(5, 'Oziel', 'Adriano', 'Adriano', 'Jodi', '2025-06-22', '00:00:23'),
(6, 'Fer', 'Adriano', 'Fer', 'Leah', '2025-06-22', '00:00:11'),
(7, 'Jugador1', 'Jugador2', 'Jugador1', 'Caroline', '2025-06-22', '00:00:24'),
(8, 'Jugador1', 'Jugador2', 'Jugador2', 'Penny', '2025-06-22', '00:00:15'),
(9, 'Jugador1', 'Jugador2', 'Jugador1', 'Penny', '2025-06-22', '00:00:27'),
(10, 'Jugador1', 'Jugador2', 'Jugador1', 'Mr Qi', '2025-06-22', '00:01:02'),
(11, 'Jugador1', 'Jugador2', 'Jugador2', 'Marnie', '2025-06-22', '00:03:29'),
(12, 'Jugador1', 'Jugador2', 'Jugador1', 'Linus', '2025-06-22', '00:00:11');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `personajes`
--

CREATE TABLE `personajes` (
  `Id` int(11) NOT NULL,
  `Nombre` varchar(20) NOT NULL,
  `Imagen` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `personajes`
--

INSERT INTO `personajes` (`Id`, `Nombre`, `Imagen`) VALUES
(1, 'Abigail', 'src/Resources/Assets/Abigail.png'),
(2, 'Alex', 'src/Resources/Assets/Alex.png'),
(3, 'Birdie', 'src/Resources/Assets/Birdie.png'),
(4, 'Bouncer', 'src/Resources/Assets/Bouncer.png'),
(5, 'Caroline', 'src/Resources/Assets/Caroline.png'),
(6, 'Clint', 'src/Resources/Assets/Clint.png'),
(7, 'Demetrius', 'src/Resources/Assets/Demetrius.png'),
(8, 'Elliott', 'src/Resources/Assets/Elliott.png'),
(9, 'Emily', 'src/Resources/Assets/Emily.png'),
(10, 'Evelyn', 'src/Resources/Assets/Evelyn.png'),
(11, 'George', 'src/Resources/Assets/George.png'),
(12, 'Gil', 'src/Resources/Assets/Gil.png'),
(13, 'Governador', 'src/Resources/Assets/Governor.png'),
(14, 'Gunther', 'src/Resources/Assets/Gunther.png'),
(15, 'Gus', 'src/Resources/Assets/Gus.png'),
(16, 'Hailey', 'src/Resources/Assets/Hailey.png'),
(17, 'Harvey', 'src/Resources/Assets/Harvey.png'),
(18, 'Jas', 'src/Resources/Assets/Jas.png'),
(19, 'Jodi', 'src/Resources/Assets/Jodi.png'),
(20, 'Kent', 'src/Resources/Assets/Kent.png'),
(21, 'Leah', 'src/Resources/Assets/Leah.png'),
(22, 'Leo', 'src/Resources/Assets/Leo.png'),
(23, 'Lewis', 'src/Resources/Assets/Lewis.png'),
(24, 'Linus', 'src/Resources/Assets/Linus.png'),
(25, 'Marlon', 'src/Resources/Assets/Marlon.png'),
(26, 'Marnie', 'src/Resources/Assets/Marnie.png'),
(27, 'Maru', 'src/Resources/Assets/Maru.png'),
(28, 'Morris', 'src/Resources/Assets/Morris.png'),
(29, 'Mr Qi', 'src/Resources/Assets/Mr Qi.png'),
(30, 'Pam', 'src/Resources/Assets/Pam.png'),
(31, 'Penny', 'src/Resources/Assets/Penny.png'),
(32, 'Pierre', 'src/Resources/Assets/Pierre.png'),
(33, 'Prof. Snail', 'src/Resources/Assets/Prof Snail.png'),
(34, 'Robin', 'src/Resources/Assets/Robin.png'),
(35, 'Sam', 'src/Resources/Assets/Sam.png'),
(36, 'Sandy', 'src/Resources/Assets/Sandy.png'),
(37, 'Sebastian', 'src/Resources/Assets/Sebastian.png'),
(38, 'Shane', 'src/Resources/Assets/Shane.png'),
(39, 'Vincent', 'src/Resources/Assets/Vincent.png'),
(40, 'Willy', 'src/Resources/Assets/Willy.png'),
(41, 'Hechizero', 'src/Resources/Assets/Wizard.png');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `preguntas_partida`
--

CREATE TABLE `preguntas_partida` (
  `id` int(11) NOT NULL,
  `Pregunta` varchar(80) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pregunta_adjetivo`
--

CREATE TABLE `pregunta_adjetivo` (
  `id` int(11) NOT NULL,
  `adjetivo` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pregunta_adjetivo`
--

INSERT INTO `pregunta_adjetivo` (`id`, `adjetivo`) VALUES
(1, 'Pobladas'),
(2, 'Delgadas'),
(3, 'Largo'),
(4, 'Corto'),
(5, 'Blanco'),
(6, 'Negro'),
(7, 'Cafe'),
(8, 'Rojo'),
(9, 'Naranja'),
(10, 'Rubio/Amarillo'),
(11, 'Verde'),
(12, 'Azul'),
(13, 'Morado'),
(14, 'Clara'),
(15, 'Obscura'),
(16, 'Bronceada');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pregunta_objeto`
--

CREATE TABLE `pregunta_objeto` (
  `id` int(11) NOT NULL,
  `objeto` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pregunta_objeto`
--

INSERT INTO `pregunta_objeto` (`id`, `objeto`) VALUES
(1, 'Hombre'),
(2, 'Mujer'),
(3, 'un Adulto'),
(4, 'un Joven'),
(5, 'un Anciano'),
(6, 'Calvo'),
(7, 'Lentes'),
(8, 'Cejas'),
(9, 'Pelo'),
(10, 'Ojos'),
(11, 'Ropa'),
(12, 'Piel'),
(13, 'un Gorro'),
(14, 'Vello facial');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pregunta_sujeto`
--

CREATE TABLE `pregunta_sujeto` (
  `id` int(11) NOT NULL,
  `Pregunta` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pregunta_sujeto`
--

INSERT INTO `pregunta_sujeto` (`id`, `Pregunta`) VALUES
(1, 'Es'),
(2, 'Tiene');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `partidas`
--
ALTER TABLE `partidas`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `personajes`
--
ALTER TABLE `personajes`
  ADD PRIMARY KEY (`Id`);

--
-- Indices de la tabla `preguntas_partida`
--
ALTER TABLE `preguntas_partida`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `pregunta_adjetivo`
--
ALTER TABLE `pregunta_adjetivo`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `pregunta_objeto`
--
ALTER TABLE `pregunta_objeto`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `pregunta_sujeto`
--
ALTER TABLE `pregunta_sujeto`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `partidas`
--
ALTER TABLE `partidas`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `personajes`
--
ALTER TABLE `personajes`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42;

--
-- AUTO_INCREMENT de la tabla `preguntas_partida`
--
ALTER TABLE `preguntas_partida`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `pregunta_adjetivo`
--
ALTER TABLE `pregunta_adjetivo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT de la tabla `pregunta_objeto`
--
ALTER TABLE `pregunta_objeto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
