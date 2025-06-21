-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 09-06-2025 a las 06:14:19
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
(1, 'Alex', 'src/Resources/Assets/Alex.png'),
(2, 'Birdie', 'src/Resources/Assets/Birdie.png'),
(3, 'Bouncer', 'src/Resources/Assets/Bouncer.png'),
(4, 'CardBackDrop', 'src/Resources/Assets/CardBackdrop.png'),
(5, 'Caroline', 'src/Resources/Assets/Caroline.png'),
(6, 'Clint', 'src/Resources/Assets/Clint.png'),
(7, 'Demetrius', 'src/Resources/Assets/Demetrius.png'),
(8, 'Elliot', 'src/Resources/Assets/Elliot.png'),
(9, 'Emily', 'src/Resources/Assets/Emily.png'),
(10, 'Evelyn', 'src/Resources/Assets/Evelyne.png'),
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
(23, 'Abigail', 'src/Resources/Assets/Abigail.png'),
(24, 'Linus', 'src/Resources/Assets/Linus.png'),
(26, 'Marlon', 'src/Resources/Assets/Marlon.png'),
(27, 'Marnie', 'src/Resources/Assets/Marnie.png'),
(28, 'Maru', 'src/Resources/Assets/Maru.png'),
(29, 'Morris', 'src/Resources/Assets/Morris.png'),
(30, 'Mr Qi', 'src/Resources/Assets/Mr_Qi.png'),
(31, 'Pam', 'src/Resources/Assets/Pam.png'),
(32, 'Penny', 'src/Resources/Assets/Penny.png'),
(33, 'Pierre', 'src/Resources/Assets/Pierre.png'),
(34, 'Profesor Snail', 'src/Resources/Assets/Prof_Snail.png'),
(35, 'Robin', 'src/Resources/Assets/Robin.png'),
(36, 'Sam', 'src/Resources/Assets/Sandy.png'),
(37, 'Sebastian', 'src/Resources/Assets/Sebastian.png'),
(38, 'Shane', 'src/Resources/Assets/Shane.png'),
(39, 'Vincent', 'src/Resources/Assets/Vincent.png'),
(40, 'Willy', 'src/Resources/Assets/Willy.png'),
(41, 'Hechizero', 'src/Resources/Assets/Wizard.png');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `personajes`
--
ALTER TABLE `personajes`
  ADD PRIMARY KEY (`Id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `personajes`
--
ALTER TABLE `personajes`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
