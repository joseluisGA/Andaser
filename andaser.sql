-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 08-01-2017 a las 20:26:49
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
-- Estructura de tabla para la tabla `albaran`
--

CREATE TABLE `albaran` (
  `ID` int(11) NOT NULL,
  `ID_PEDIDO` int(11) NOT NULL,
  `RUTA` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `FECHA` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

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
(5, 'Abrasivos'),
(6, 'Barnices'),
(4, 'Herrajes');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `DNI` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `usuario` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `nombre` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `apellido1` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `apellido2` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `ID_DIRECCION` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`DNI`, `usuario`, `nombre`, `apellido1`, `apellido2`, `ID_DIRECCION`) VALUES
('05722193T', 'Jose', 'Jose Luis', 'Gómez', 'Álvarez', 9);

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
  `PAIS` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `TLFN1` int(9) NOT NULL,
  `TLFN2` int(9) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `direccion`
--

INSERT INTO `direccion` (`ID`, `CALLE`, `POBLACION`, `CODIGO_POSTAL`, `PROVINCIA`, `PAIS`, `TLFN1`, `TLFN2`) VALUES
(4, 'jghjghj', 'ghjhgj', 4564, 'ghhfg', 'fghgfh', 4563, 346364),
(9, 'Bernardas 22', 'Almagro', 13270, 'Ciudad Real', 'España', 699616687, 53543453),
(19, 'asd', 'asd', 123, 'asd', 'asd', 123, NULL),
(21, 'Bernardas 22', 'Almagro', 13270, 'Ciudad Real', 'España', 699616687, 926860358),
(22, 'Bernardas 22', 'Almagro', 13270, 'Ciudad Real', 'España', 699616687, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empresa`
--

CREATE TABLE `empresa` (
  `NIF` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `NOMBRE_EMPRESA` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `USUARIO` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `ID_DIRECCION` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `empresa`
--

INSERT INTO `empresa` (`NIF`, `NOMBRE_EMPRESA`, `USUARIO`, `ID_DIRECCION`) VALUES
('45565454', 'Joservid', 'Joservid', 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `lista_pedidos`
--

CREATE TABLE `lista_pedidos` (
  `ID` int(11) NOT NULL,
  `USUARIO` varchar(30) COLLATE utf8_spanish_ci DEFAULT NULL,
  `DNI_NIF` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `ID_DIR` int(11) NOT NULL,
  `FECHA` date NOT NULL,
  `PRECIO_TOTAL` int(11) NOT NULL,
  `ACEPTADO` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `lista_pedidos`
--

INSERT INTO `lista_pedidos` (`ID`, `USUARIO`, `DNI_NIF`, `ID_DIR`, `FECHA`, `PRECIO_TOTAL`, `ACEPTADO`) VALUES
(4, 'Jose', '05722193T', 9, '2017-01-03', 72, 1),
(5, 'Jose', '05722193T', 9, '2017-01-08', 112, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido`
--

CREATE TABLE `pedido` (
  `ID` int(11) NOT NULL,
  `ID_LISTA_PED` int(11) NOT NULL,
  `REF` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `PRECIO` int(11) NOT NULL,
  `CANTIDAD` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `pedido`
--

INSERT INTO `pedido` (`ID`, `ID_LISTA_PED`, `REF`, `PRECIO`, `CANTIDAD`) VALUES
(1, 4, '455dfs', 32, 1),
(2, 4, 'hghg', 40, 1),
(3, 5, 'hghg', 20, 2),
(4, 5, '455dfs', 32, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `REF` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `NOMBRE` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `DESCRIPCION` varchar(500) COLLATE utf8_spanish_ci DEFAULT NULL,
  `ID_CATEGORIA` int(11) DEFAULT NULL,
  `ID_SUBCATEGORIA` int(11) DEFAULT NULL,
  `PRECIO1` int(11) NOT NULL,
  `PRECIO2` int(11) NOT NULL,
  `FICHA` varchar(500) COLLATE utf8_spanish_ci DEFAULT NULL,
  `IMAGEN` varchar(500) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`REF`, `NOMBRE`, `DESCRIPCION`, `ID_CATEGORIA`, `ID_SUBCATEGORIA`, `PRECIO1`, `PRECIO2`, `FICHA`, `IMAGEN`) VALUES
('455dfs', 'Laca blanc', 'gghgjkjjhgdfsdaddghj', 6, 5, 32, 30, 'GÓMEZ ÁLVAREZ JOSÉ LUIS.pdf', 'IMG_2966_Masquelack_443-25.png'),
('ertert', 'Acabado PU 20', 'Acabado poliuretano 20 litros', 6, 7, 40, 35, 'Curriculum2(1).pdf', 'IMG_2966_Masquelack_443-25.png'),
('hghg', 'Laca acabado 20', 'Laca acabado blanca 20 litros', 6, 5, 40, 35, 'Curriculum2(1).pdf', 'IMG_2966_Masquelack_443-25.png');

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
(3, 'empressa');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `subcategoria`
--

CREATE TABLE `subcategoria` (
  `ID` int(11) NOT NULL,
  `ID_CATEGORIA` int(11) DEFAULT NULL,
  `NOMBRE` varchar(30) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `subcategoria`
--

INSERT INTO `subcategoria` (`ID`, `ID_CATEGORIA`, `NOMBRE`) VALUES
(2, 5, 'Lijas'),
(5, 6, 'Lacas'),
(6, 6, 'Al agua'),
(7, 6, 'Acabados'),
(8, 6, 'Fondo'),
(9, 6, 'Endurecedor');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `NOMBRE` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `PASSWORD` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `EMAIL` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `ROL` int(11) NOT NULL,
  `UsuarioConfirmado` tinyint(1) NOT NULL DEFAULT '0',
  `ContrasenyaCambiada` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`NOMBRE`, `PASSWORD`, `EMAIL`, `ROL`, `UsuarioConfirmado`, `ContrasenyaCambiada`) VALUES
('admin', 'admin', 'ComercialAndaser@gmail.com', 1, 1, 1),
('Jose', 'jose', 'joseluis.gomezalvarez94@gmail.com', 2, 1, 1),
('Joservid', 'joservid', 'joservid@live.com', 3, 0, 0);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `albaran`
--
ALTER TABLE `albaran`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `ID_PEDIDO` (`ID_PEDIDO`);

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
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `NOMBRE` (`NOMBRE`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`DNI`),
  ADD KEY `id_usuario` (`usuario`),
  ADD KEY `idDireccion` (`ID_DIRECCION`);

--
-- Indices de la tabla `direccion`
--
ALTER TABLE `direccion`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `empresa`
--
ALTER TABLE `empresa`
  ADD PRIMARY KEY (`NIF`),
  ADD UNIQUE KEY `NOMBRE_EMPRESA` (`NOMBRE_EMPRESA`),
  ADD KEY `USUARIO` (`USUARIO`),
  ADD KEY `ID_DIRECCION` (`ID_DIRECCION`);

--
-- Indices de la tabla `lista_pedidos`
--
ALTER TABLE `lista_pedidos`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `USUARIO` (`USUARIO`),
  ADD KEY `DNI_NIE` (`DNI_NIF`),
  ADD KEY `USUARIO_2` (`USUARIO`),
  ADD KEY `ID_DIR` (`ID_DIR`);

--
-- Indices de la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `REF` (`REF`),
  ADD KEY `ID_LISTA_PED` (`ID_LISTA_PED`);

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
-- AUTO_INCREMENT de la tabla `albaran`
--
ALTER TABLE `albaran`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `caracteristica`
--
ALTER TABLE `caracteristica`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `categoria`
--
ALTER TABLE `categoria`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT de la tabla `direccion`
--
ALTER TABLE `direccion`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;
--
-- AUTO_INCREMENT de la tabla `lista_pedidos`
--
ALTER TABLE `lista_pedidos`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT de la tabla `pedido`
--
ALTER TABLE `pedido`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de la tabla `roles`
--
ALTER TABLE `roles`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `subcategoria`
--
ALTER TABLE `subcategoria`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `albaran`
--
ALTER TABLE `albaran`
  ADD CONSTRAINT `albaran_ibfk_1` FOREIGN KEY (`ID_PEDIDO`) REFERENCES `pedido` (`ID`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Filtros para la tabla `caracteristica`
--
ALTER TABLE `caracteristica`
  ADD CONSTRAINT `caracteristica_ibfk_1` FOREIGN KEY (`ref_producto`) REFERENCES `producto` (`REF`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Filtros para la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `cliente_ibfk_2` FOREIGN KEY (`ID_DIRECCION`) REFERENCES `direccion` (`ID`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `cliente_ibfk_3` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`NOMBRE`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `empresa`
--
ALTER TABLE `empresa`
  ADD CONSTRAINT `empresa_ibfk_2` FOREIGN KEY (`ID_DIRECCION`) REFERENCES `direccion` (`ID`),
  ADD CONSTRAINT `empresa_ibfk_3` FOREIGN KEY (`USUARIO`) REFERENCES `usuario` (`NOMBRE`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Filtros para la tabla `lista_pedidos`
--
ALTER TABLE `lista_pedidos`
  ADD CONSTRAINT `lista_pedidos_ibfk_3` FOREIGN KEY (`ID_DIR`) REFERENCES `direccion` (`ID`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `lista_pedidos_ibfk_4` FOREIGN KEY (`USUARIO`) REFERENCES `usuario` (`NOMBRE`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Filtros para la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD CONSTRAINT `pedido_ibfk_2` FOREIGN KEY (`REF`) REFERENCES `producto` (`REF`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `pedido_ibfk_3` FOREIGN KEY (`ID_LISTA_PED`) REFERENCES `lista_pedidos` (`ID`);

--
-- Filtros para la tabla `producto`
--
ALTER TABLE `producto`
  ADD CONSTRAINT `producto_ibfk_4` FOREIGN KEY (`ID_SUBCATEGORIA`) REFERENCES `subcategoria` (`ID`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `producto_ibfk_5` FOREIGN KEY (`ID_CATEGORIA`) REFERENCES `categoria` (`ID`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Filtros para la tabla `subcategoria`
--
ALTER TABLE `subcategoria`
  ADD CONSTRAINT `subcategoria_ibfk_1` FOREIGN KEY (`ID_CATEGORIA`) REFERENCES `categoria` (`ID`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`ROL`) REFERENCES `roles` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
