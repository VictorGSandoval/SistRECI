create database db_civil;
use db_civil;

-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2020-03-01 03:20:25.801

-- tables
-- Table: ACTA
CREATE TABLE ACTA (
    IDACTA int NOT NULL AUTO_INCREMENT COMMENT 'Contiene el
identificado de cada
acta Registrada',
    LIBACTA varchar(150) NOT NULL COMMENT 'Contiene referencia del libro donde se encuentra el acta , ya q se tiene libros de actas de cada año (Actas de las persona que se casan,nacen y fallecen)',
    FECREGACTA char(10) NOT NULL COMMENT 'Contiene la Fecha de Registro del Acta',
    OBSACTA varchar(500) NOT NULL COMMENT 'Contiene la observación del acta ,La Observación del acta es opcional',
    TIPACTA char(15) NOT NULL COMMENT 'Contiene el tipo de Acta : nacimiento,matrimonio y defunción',
    ESTACTA char(10) NOT NULL COMMENT 'Contiene el estado del acta : activo o inactivo(fortalecimiento,cambio de nombre) ',
    
    CONSTRAINT ACTA_pk PRIMARY KEY (IDACTA)
) COMMENT 'Contiene los datos referentes a las Actas ';

INSERT INTO `acta` (`IDACTA`, `LIBACTA`, `FECREGACTA`, `OBSACTA`, `TIPACTA`, `ESTACTA`) VALUES
(1, 'Actas Matrimonial 2017', '02-05-2017', 'Se comprometieron dos personas', 'Matrimonio', 'Activo'),
(2, 'Actas Matrimonial 2015', '03-06-2015', 'Se comprometieron dos personas', 'Matrimonio', 'Inactivo'),
(3, 'Actas Matrimonial 2016', '04-07-2016', 'Se comprometieron dos personas', 'Matrimonio', 'Activo'),
(4, 'Actas Nacimientos 2017', '05-08-2027', 'Nacio un niño ', 'Nacimiento', 'Inactivo'),
(5, 'Actas Nacimientos 2018', '06-09-2018', 'Nacio una niña ', 'Nacimiento', 'Activo'),
(6, 'Actas Nacimientos 2019', '07-10-2019', 'Nacio un niño', 'Nacimiento', 'Inactivo'),
(7, 'Actas Defunsión 2020', '08-11-2020', 'Se Presento la familia para declarar a la persona fallecida', 'Defunción', 'Activo'),
(8, 'Actas Defunsión 2020', '09-12-2017', 'Se Presento la familia para declarar a la persona fallecida', 'Defunción', 'Inactivo'),
(9, 'Actas Defunsión 2018', '20-13-2018', 'Se Presento la familia para declarar a la persona fallecida', 'Defunción', 'Activo'),
(10, 'Actas Matrimonial 2019', '02-14-2019', 'Se comprometieron dos personas', 'Defunción', 'Inactivo');

-- Table: LOGIN
CREATE TABLE LOGIN (
    IDLOG int NOT NULL AUTO_INCREMENT COMMENT 'Identificador del
login',
    USRLOG varchar(32) NULL COMMENT 'Muestra los nombre de
los usuarios para el login',
    PSSWLOG varchar(32) NULL COMMENT 'Contraseña de login
del usuario',
    TIPLOG varchar(15) NULL COMMENT 'Contiene el Tipo de
Usuario : administrador y usuario normal(solo puede ver)',
    ESTLOG char(1) NOT NULL COMMENT 'Estado de login : activo o inactivo I o A',
    
    CONSTRAINT LOGIN_pk PRIMARY KEY (IDLOG)
) COMMENT 'Contiene los datos del Login.';

INSERT INTO `login` (`IDLOG`, `USRLOG`, `PSSWLOG`, `TIPLOG`, `ESTLOG`) VALUES
(1, 'admin', 'admin', 'Administrador', 'A'),
(2, 'gova', 'gova', 'Invitado', 'A'),
(3, 'Diego', 'Diego', 'Administrador', 'A'),
(4, 'Juan', 'Juan', 'Invitado', 'A'),
(5, 'JuniorJR', 'Junior', 'Administrador', 'A'),
(6, 'Juanito', 'Mascana', 'Invitado', 'A'),
(7, 'Lucio', 'Lucio', 'Administrador', 'A'),
(8, 'Julio', 'Julio', 'Invitado', 'A'),
(9, 'Luis', 'Luis', 'Administrador', 'A'),
(10, 'Compares', 'Compares', 'Invitado', 'A');

-- Table: MUNICIPALIDAD
CREATE TABLE MUNICIPALIDAD (
    IDMUN int NOT NULL AUTO_INCREMENT COMMENT 'Este campo es el
identificador de cada
municipalidad registrada.',
    DIRMUN varchar(100) NOT NULL COMMENT 'Contiene la dirección
de la municipalidad',
    NOMMUN varchar(100) NOT NULL COMMENT 'Contiene el nombre
de la municipalidad',
    TLFMUN varchar(11) NOT NULL COMMENT 'Contiene el número de teléfono
de la persona',
    ESTMUN varchar(10) NOT NULL COMMENT 'Contiene el estado 
de la municipalidad: activo o inactivo',
    
    CONSTRAINT MUNICIPALIDAD_pk PRIMARY KEY (IDMUN)
) COMMENT 'Esta tabla contiene datos de la Municipalidad.';

INSERT INTO `municipalidad` (`IDMUN`, `DIRMUN`, `NOMMUN`, `TLFMUN`, `ESTMUN`) VALUES
(1, 'Jr. 28 de julio Nº 335 ', 'Municipalidad Distrital de Imperial', '987654321', 'Activo'),
(2, 'Plaza de Armas S/N', 'Municipalidad Distrital de Lunahuana', '932165478', 'Activo'),
(3, 'Calle Bolognesi N° 250', 'Municipalidad Distrital de San Vicente de Cañete', '987654321', 'Activo'),
(4, 'Calle La Mar Nº 315 ', 'Municipalidad Distrital de Asia', '932165478', 'Activo'),
(5, 'Jr. Alfonso Ugarte Nº 500', 'Municipalidad Distrital de Cerro Azul', '987654321', 'Activo'),
(6, 'Av. Mariano Ignacio Prado Nº 496 Km. 64', 'Municipalidad Distrital de Chilca', '932165478', 'Activo'),
(7, 'Jr. Miraflores N° 165', 'Municipalidad Distrital de Pacarán', '987654321', 'Activo'),
(8, 'Av. Lima N° 451', 'Municipalidad Distrital de Quilmana', '932165478', 'Activo'),
(9, 'Jr. Pedro Advíncula Quispe Chumpitaz N° 137', 'Municipalidad Distrital de San Antonio', '987654321', 'Activo'),
(10, 'Plaza de Armas S/N 0', 'Municipalidad Distrital de San Luis', '932165478', 'Activo');

-- Table: PERSONA
CREATE TABLE PERSONA (
    IDPER int NOT NULL AUTO_INCREMENT COMMENT 'Este campo es el
identificador de cada
persona registrada.',
    APEPATPER varchar(50) NOT NULL COMMENT 'Contiene los apellidos paternos
de la persona',
    APEMATERPER varchar(50) NOT NULL COMMENT 'Contiene los apellidos maternos
de la persona',
    NOMPER varchar(50) NOT NULL COMMENT 'Contiene los nombres
de la persona',
    FECNACPER char(10) NULL,
    DNIPER varchar(8) NULL COMMENT 'Este campo es el
número de DNI  de cada
persona registrada, teniendo en
cuenta que el DNI
esta conformado por 8 
números por ejemplo : 60323413',
    DIRPER varchar(100) NULL COMMENT 'Contiene la dirección
de la persona',
    GENPER char(1) NOT NULL COMMENT 'Contiene el genero de la
persona',
    CELPER char(11) NULL COMMENT 'Contiene el numero telefónico de la
persona',
    ESTPER char(1) NOT NULL COMMENT 'Contiene el estado de la
persona : activo o inactivo (fallece)',
    
    ESTCIVPER char(10) NOT NULL COMMENT 'Contiene el Estado Civil de la Persona :Casado,Viudo o Divorciado',
    CONSTRAINT PERSONA_pk PRIMARY KEY (IDPER)
) COMMENT 'Esta tabla contiene toda la información de las Personas.';

INSERT INTO `persona` (`IDPER`, `APEPATPER`, `APEMATERPER`, `NOMPER`, `FECNACPER`, `DNIPER`, `DIRPER`, `GENPER`, `CELPER`, `ESTPER`, `ESTCIVPER`) VALUES
(1, 'Mateo', 'Rojas', 'Jose', '2020-02-14', '60323411', 'Jr. Miraflores N° 165', 'M', '945615432', 'I', 'Casado'),
(2, 'Mateus', 'Quispe', 'Luis', '02-05-2002', '60352682', 'Jr.Tarapaca', 'M', '948954321', 'A', 'Soltero'),
(3, 'Marc ', 'Solar ', 'Gaceo', '2020-02-14', '60323413', 'Jr. Unión N° 490', 'M', '987154323', 'I', 'Casado'),
(4, 'Gonza', 'Velasquez', 'Jose', '02-05-2002', '60352684', 'Jr. 3 de Octubre N° 125', 'M', '988354324', 'A', 'Soltero'),
(5, 'Hañari', 'Huayanacho', 'Clever', '2020-02-14', '60323415', 'Jr. Tacna N° 562', 'M', '987754325', 'I', 'Viudo'),
(6, 'Morales', 'Taype', 'Jorge', '02-05-2002', '60352686', 'Jr. Alfonso Ugarte N° 218', 'M', '988884326', 'A', 'Soltero'),
(7, 'Navarro', 'Tacca', 'Uriel', '2020-02-14', '60323417', 'Jr. Lima N° 133', 'M', '989994327', 'I', 'Divorciado'),
(8, 'Larico', 'Apaza', 'Mario', '02-05-2002', '60352688', 'Jr. Cultura S/N', 'M', '984494328', 'A', 'Soltero'),
(9, 'Quispe', 'Vilca', 'Cesario', '2020-02-14', '60323419', 'Jr. San Román N° 415', 'M', '981114329', 'I', 'Soltero'),
(10, 'Tipo', 'Chura', 'Leonardo', '02-05-2002', '60352610', 'Jr. Arica N° 420', 'M', '984824310', 'A', 'Soltero');
(11, 'Sandoval', 'Rosales', 'Geovani', '07-07-2002', '60323413', 'Jr. Tarapaca N° 420', 'M', '984824311', 'A', 'Soltero');



-- Table: UBIGEO
CREATE TABLE UBIGEO (
    CODUBI varchar(6) NOT NULL COMMENT 'Campo de identificador
de ubigeo',
    DEPUBI varchar(13) NOT NULL COMMENT 'Departamento donde se
encuentra la persona',
    PROVUBI varchar(25) NULL COMMENT 'Provincia donde se
ubica la persona',
    DISTUBI varchar(36) NULL COMMENT 'Distrito donde se
encuentra la persona',
    CONSTRAINT UBIGEO_pk PRIMARY KEY (CODUBI)
) COMMENT 'Contiene la ubicación Geográfica';

INSERT INTO `ubigeo` (`CODUBI`, `DEPUBI`, `PROVUBI`, `DISTUBI`) VALUES
('140401', 'Lima', 'Cañete', 'SAN VICENTE'),
('140403', 'Lima', 'Cañete', 'CERRO AZUL'),
('140405', 'Lima', 'Cañete', 'CHILCA'),
('140406', 'Lima', 'Cañete', 'IMPERIAL'),
('140408', 'Lima', 'Cañete', 'MALA'),
('140410', 'Lima', 'Cañete', 'PACARAN'),
('140411', 'Lima', 'Cañete', 'QUILMANA'),
('140412', 'Lima', 'Cañete', 'SAN ANTONIO'),
('140415', 'Lima', 'Cañete', 'ZUÑIGA'),
('140416', 'Lima', 'Cañete', 'ASIA');


