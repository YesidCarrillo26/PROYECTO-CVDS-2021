--drop table reservas;
--drop table recursos;
--drop table tiporecurso;
--drop table ubicaciones;
--drop table Usuarios;
--drop table roles;

--TipoRecurso
--CREATE TABLE TIPORECURSO (
--	codigo SERIAL not null,
	--nombre VARCHAR(17) NOT NULL,
	--descripcion varchar(200) NOT NULL,
	--horaMinima time not null,
--	horaMaxima time not null
--);

--ALTER TABLE TIPORECURSO ADD PRIMARY KEY (codigo);

--Ubicaciones
--CREATE TABLE UBICACIONES (
	--codigo SERIAL not null,
	--nombre VARCHAR(30) NOT NULL,
	--horaMinima time not null,
	--horaMaxima time not null
--);

--ALTER table UBICACIONES ADD PRIMARY KEY (codigo);

--Recursos
--CREATE TABLE RECURSOS (
--	codigo SERIAL NOT NULL,
--	tipo SERIAL NOT NULL,
--	ubicacion SERIAL not null,
--	nombre VARCHAR(20) not NULL,
--	estado VARCHAR(8) not null,
--	capacidad smallint not null,
--	CONSTRAINT FK_recursos_tipoR FOREIGN KEY(tipo) REFERENCES TIPORECURSO(codigo),
--	CONSTRAINT FK_recursos_ubi FOREIGN KEY(ubicacion) REFERENCES UBICACIONES(codigo),
--	UNIQUE(nombre)
--);

--ALTER table RECURSOS ADD PRIMARY KEY (codigo);


--Reservas
 --CREATE TABLE RESERVAS (
--	codigo SERIAL NOT NULL,
	--recurso SERIAL not null,
--	usuario SERIAL not null,
--	horaInicial time not null,
--	horaFinal time not null,
--	periodicidad VARCHAR(17) NOT NULL,
--	fechaFinal date not NULL,
--	CONSTRAINT FK_reserva_recurso FOREIGN KEY(recurso) REFERENCES RECURSOS(codigo),
--	CONSTRAINT FK_reserva_usuario FOREIGN KEY(usuario) REFERENCES USUARIOS(codigo)
--);

--ALTER table RESERVAS ADD PRIMARY KEY (codigo);

--Table Roles
--CREATE TABLE ROLES (
--	tipo VARCHAR(50) not null
--);

--ALTER table ROLES ADD PRIMARY KEY (tipo);


--Table Usuario
--CREATE TABLE USUARIOS (
--	codigo SERIAL not null,
--	correo VARCHAR(50) not null,
--	apellidos VARCHAR(50) NOT NULL,
--	nombres VARCHAR(50) NOT NULL,
--	contrasena VARCHAR(20) not null,
--	programa VARCHAR(50) NOT null,
--	rol VARCHAR(50) not null,
--	CONSTRAINT FK_usuarios_rol FOREIGN KEY(rol) REFERENCES ROLES(tipo)
--);

--ALTER table USUARIOS ADD PRIMARY KEY (correo);



--Población
--insert into tiporecurso values (default, 'Sala de estudio', 'Se usa para realizar trabajos intelectuales, leer o trabajar individualmente o en grupo', '9:00:00', '17:00:00');
--insert into tiporecurso values (default, 'Equipo de computo', 'Dispositivo electrónico que le permite al usuario conectarse a distintas herramientas', '7:00:00', '18:30:00');
--insert into tiporecurso values (default, 'Equipo multimedia', 'Herramienta o objeto útiles para el desarrollo de actividades académicas', '7:00:00', '18:30:00');

--insert into ubicaciones values (default, 'Biblioteca Principal', '7:00:00', '19:00:00');
--insert into ubicaciones values (default, 'Biblioteca Satelite', '9:00:00', '19:00:00');
--insert into ubicaciones values (default, 'Edificio I', '9:00:00', '19:00:00');


--insert into recursos values (default, 1, 1, 'Sala Estudio 1', 'Activo', 7);
--insert into recursos values (default, 2, 2, 'PC Portatil 1', 'Inactivo', 1);
--insert into recursos values (default, 3, 3, 'VideoBean 1', 'Activo', 1);
--insert into recursos values (default, 1, 2, 'Sala Estudio 2', 'Inactivo', 8);
--insert into recursos values (default, 2, 1, 'PC Portatil 2', 'Activo', 1);
--insert into recursos values (default, 3, 2, 'Televisor 1', 'Inactivo', 1);
--insert into recursos values (default, 1, 1, 'Sala Estudio 3', 'Activo', 5);
--insert into recursos values (default, 2, 2, 'PC Portatil 3', 'Inactivo', 1);

--insert into roles values ('Administrador');
--insert into roles values ('Usuario');
