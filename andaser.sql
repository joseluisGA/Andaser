-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 09-11-2016 a las 09:33:22
-- Versión del servidor: 10.1.16-MariaDB
-- Versión de PHP: 5.6.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `andaser`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `caracteristica`
--

CREATE TABLE `caracteristica` (
  `id` int(11) NOT NULL,
  `ref_producto` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `nombre` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `contenido` varchar(500) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `ID` int(11) NOT NULL,
  `NOMBRE` varchar(30) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`ID`, `NOMBRE`) VALUES
(1, 'Barniz'),
(2, 'Herrajes'),
(3, 'Abrasivos');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `DNI` varchar(9) COLLATE utf8_spanish_ci NOT NULL,
  `usuario` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `nombre` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `apellido1` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `apellido2` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `direccion` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `poblacion` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `codigo_postal` int(5) NOT NULL,
  `provincia` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `pais` varchar(30) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `direccion`
--

CREATE TABLE `direccion` (
  `ID` int(11) NOT NULL,
  `CALLE` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `POBLACION` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `CODIGO_POSTAL` int(5) NOT NULL,
  `PROVINCIA` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `PAIS` varchar(30) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `REF` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `NOMBRE` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `DESCRIPCION` varchar(500) COLLATE utf8_spanish_ci DEFAULT NULL,
  `ID_CATEGORIA` int(11) NOT NULL,
  `ID_SUBCATEGORIA` int(11) DEFAULT NULL,
  `PRECIO1` int(11) NOT NULL,
  `PRECIO2` int(11) NOT NULL,
  `PRECIO3` int(11) NOT NULL,
  `FICHA` varchar(500) COLLATE utf8_spanish_ci DEFAULT NULL,
  `IMAGEN` varchar(500) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`REF`, `NOMBRE`, `DESCRIPCION`, `ID_CATEGORIA`, `ID_SUBCATEGORIA`, `PRECIO1`, `PRECIO2`, `PRECIO3`, `FICHA`, `IMAGEN`) VALUES
('455dfs', 'Laca blanca', 'dfsdfsdfsd', 1, 1, 32423, 64363, 23424, NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `roles`
--

CREATE TABLE `roles` (
  `ID` int(11) NOT NULL,
  `NOMBRE` varchar(30) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `roles`
--

INSERT INTO `roles` (`ID`, `NOMBRE`) VALUES
(1, 'admin'),
(2, 'particular'),
(3, 'carpintero'),
(4, 'mayorista');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `subcategoria`
--

CREATE TABLE `subcategoria` (
  `ID` int(11) NOT NULL,
  `ID_CATEGORIA` int(11) NOT NULL,
  `NOMBRE` varchar(30) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `subcategoria`
--

INSERT INTO `subcategoria` (`ID`, `ID_CATEGORIA`, `NOMBRE`) VALUES
(1, 1, 'Laca'),
(2, 1, 'Tintes');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `NOMBRE` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `PASSWORD` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `EMAIL` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `ROL` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`NOMBRE`, `PASSWORD`, `EMAIL`, `ROL`) VALUES
('admin', 'admin', 'ComercialAndaser@gmail.com', 1),
('Joservid', 'joservid', 'joservid@live.com', 3);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `caracteristica`
--
ALTER TABLE `caracteristica`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nombre` (`nombre`),
  ADD KEY `id_producto` (`ref_producto`);

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`DNI`),
  ADD KEY `id_usuario` (`usuario`);

--
-- Indices de la tabla `direccion`
--
ALTER TABLE `direccion`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`REF`),
  ADD UNIQUE KEY `NOMBRE` (`NOMBRE`),
  ADD KEY `ID_CATEGORIA` (`ID_CATEGORIA`),
  ADD KEY `ID_SUBCATEGORIA` (`ID_SUBCATEGORIA`);

--
-- Indices de la tabla `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `subcategoria`
--
ALTER TABLE `subcategoria`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `NOMBRE` (`NOMBRE`),
  ADD KEY `ID_CATEGORIA` (`ID_CATEGORIA`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`NOMBRE`),
  ADD KEY `ROL` (`ROL`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `caracteristica`
--
ALTER TABLE `caracteristica`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `categoria`
--
ALTER TABLE `categoria`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `direccion`
--
ALTER TABLE `direccion`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `roles`
--
ALTER TABLE `roles`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de la tabla `subcategoria`
--
ALTER TABLE `subcategoria`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `caracteristica`
--
ALTER TABLE `caracteristica`
  ADD CONSTRAINT `caracteristica_ibfk_1` FOREIGN KEY (`ref_producto`) REFERENCES `producto` (`REF`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Filtros para la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `cliente_ibfk_1` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`NOMBRE`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `producto`
--
ALTER TABLE `producto`
  ADD CONSTRAINT `producto_ibfk_1` FOREIGN KEY (`ID_CATEGORIA`) REFERENCES `categoria` (`ID`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `producto_ibfk_4` FOREIGN KEY (`ID_SUBCATEGORIA`) REFERENCES `subcategoria` (`ID`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Filtros para la tabla `subcategoria`
--
ALTER TABLE `subcategoria`
  ADD CONSTRAINT `subcategoria_ibfk_1` FOREIGN KEY (`ID_CATEGORIA`) REFERENCES `categoria` (`ID`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`ROL`) REFERENCES `roles` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
