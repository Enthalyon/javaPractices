DROP SCHEMA IF EXISTS ecoDosRuedas;
CREATE SCHEMA IF NOT EXISTS ecoDosRuedas DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci;
USE ecoDosRuedas;
SELECT * FROM Fabricante;
SELECT * FROM Proveedor;
SELECT * FROM Cliente;
SELECT * FROM Bicicleta;
SELECT * FROM Motocicleta;
SELECT * FROM IntencionCompra;
DROP TABLE Fabricante;
DROP TABLE Proveedor;
DROP TABLE Cliente;
DROP TABLE Bicicleta;
DROP TABLE Motocicleta;
DROP TABLE IntencionCompra;
-- UPDATE Fabricante SET fabricante = 'hola' WHERE id_fabricante = 1;

-- Table Fabricante con su respectivo insert
CREATE TABLE Fabricante(
	id_fabricante int auto_increment,-- id_fabricante int not null,
	fabricante varchar(40) not null,
	primary key (id_fabricante)
);
insert into Fabricante (fabricante) values ('Cannondale');
insert into Fabricante (fabricante) values ('Trek');
insert into Fabricante (fabricante) values ('Yeti');
insert into Fabricante (fabricante) values ('Fuji');
insert into Fabricante (fabricante) values ('Bmc');
insert into Fabricante (fabricante) values ('Starker');
insert into Fabricante (fabricante) values ('Lucky Lion');
insert into Fabricante (fabricante) values ('Be Electric');
insert into Fabricante (fabricante) values ('Aima');
insert into Fabricante (fabricante) values ('Mec de Colombia');
insert into Fabricante (fabricante) values ('Atom Electric');

select * from fabricante;


-- Table Proveedor con su respectivo insert
CREATE TABLE Proveedor(
	id_proveedor int auto_increment, -- int not null
	nombre varchar(50) not null,
	direccion varchar(50) not null,
	telefono varchar(20) not null,
	primary key (id_proveedor)
);
insert into proveedor (nombre, direccion, telefono) values ('Auteco','calle 7 No. 45-17', '05713224459');
insert into proveedor (nombre, direccion, telefono) values ('Hitachi', 'calle 19 No. 108-26', '05714223344');
insert into proveedor (nombre, direccion, telefono) values ('Bosch', 'carrera 68 No. 26-45', '05715678798');
insert into proveedor (nombre, direccion, telefono) values ('Teco', 'calle 77 No. 68-33', '05712213243');
insert into proveedor (nombre, direccion, telefono) values ('General Electric', 'calle 29 No. 26-12', '05717239919'); 




-- Table Cliente con su respectivo insert
CREATE TABLE Cliente(
	alias varchar(40) not null,
	nombres varchar(60) not null,
	apellidos varchar(60) not null,
	email varchar(40) null, 
	celular varchar(20) not null,
	contrasena decimal(8) not null,
	fecha_nacimiento datetime not null,
	primary key (alias)
);
insert into Cliente values ('lucky','Pedro', 'Perez','Perez@gmail.com','310234213', '12312', '2020-03-17 15:30:20');
insert into Cliente values ('malopez','Maria', 'Lopez','Perez@gmail.com','310234213', '12312', '2020-03-17 15:30:20');
insert into Cliente values ('diva','Ana', 'Diaz','Perez@gmail.com','310234213', '12312', '2020-03-17 15:30:20');
insert into Cliente values ('dreamer','Luis', 'Rojas','Perez@gmail.com','310234213', '12312', '2020-03-17 15:30:20');
insert into Cliente values ('ninja','Andres', 'Cruz','Perez@gmail.com','310234213', '12312', '2020-03-17 15:30:20');
insert into Cliente values ('neon','Nelson', 'Ruiz','Perez@gmail.com','310234213', '12312', '2020-03-17 15:30:20');
insert into Cliente values ('rose','Claudia', 'Mendez','Perez@gmail.com','310234213', '12312', '2020-03-17 15:30:20');
insert into Cliente values ('green','Jorge', 'Rodriguez','Rodriguez@gmail.com','310234213', '12312', '2020-03-17 15:30:20');

SELECT * FROM Bicicleta;
-- -- Table Bicicleta con su respectivo insert
CREATE TABLE Bicicleta(
	id_bicicleta int auto_increment,
	nombre_fabricante int not null,
	precio_unitario varchar(100) not null,
	anio_construccion varchar(20) not null,
	primary key(id_bicicleta),
    foreign key (nombre_fabricante) references Fabricante(id_fabricante)
);
insert into Bicicleta (nombre_fabricante, precio_unitario, anio_construccion) values (1, '1200000', '2017');
insert into Bicicleta (nombre_fabricante, precio_unitario, anio_construccion) values (2, '1450000', '2019');
insert into Bicicleta (nombre_fabricante, precio_unitario, anio_construccion) values (3, '2000000', '2020');
insert into Bicicleta (nombre_fabricante, precio_unitario, anio_construccion) values (4, '950000', '2021');
insert into Bicicleta (nombre_fabricante, precio_unitario, anio_construccion) values (5, '1950000', '1018');


-- Table Motocicleta con su respectivo insert
CREATE TABLE Motocicleta(
	id_motocicleta int auto_increment,
	id_proveedor int not null,
	nombre_fabricante int not null,
	precio_unitario decimal not null,
	autonomia_bateria varchar(40) not null,
	primary key(id_motocicleta),
	foreign key(id_proveedor) references Proveedor(id_proveedor),
    foreign key (nombre_fabricante) references Fabricante(id_fabricante)
);
insert into Motocicleta (id_proveedor, nombre_fabricante, precio_unitario, autonomia_bateria ) values (1, 6, 4200000, '18 horas');
insert into Motocicleta (id_proveedor, nombre_fabricante, precio_unitario, autonomia_bateria ) values (2, 7, 5600000, '14 horas');
insert into Motocicleta (id_proveedor, nombre_fabricante, precio_unitario, autonomia_bateria ) values (1, 8, 4600000, '26 horas');
insert into Motocicleta (id_proveedor, nombre_fabricante, precio_unitario, autonomia_bateria ) values (3, 9, 8000000, '36 horas');
insert into Motocicleta (id_proveedor, nombre_fabricante, precio_unitario, autonomia_bateria ) values (4, 10, 5900000, '20 horas');
insert into Motocicleta (id_proveedor, nombre_fabricante, precio_unitario, autonomia_bateria ) values (5, 11, 4500000, '12 horas');


-- Table Intencion de compra con su respectivo insert
-- Table Intencion de compra con su respectivo insert
CREATE TABLE IntencionCompra(
	id_compra int auto_increment,
	alias varchar(40) not null,
	id_bicicleta int,
	id_motocicleta int,
	fecha datetime not null,
	primary key (id_compra),
	foreign key (alias) references Cliente(alias),
	foreign key (id_bicicleta) references Bicicleta(id_bicicleta),
	foreign key (id_motocicleta) references Motocicleta(id_motocicleta)
);
insert into IntencionCompra(alias, id_bicicleta, id_motocicleta, fecha) values ( 'lucky', 1, null, '2017-10-25 20:00:00');
insert into IntencionCompra(alias, id_bicicleta, id_motocicleta, fecha) values ( 'lucky', 2, null, '2019-03-15 18:30:00');
insert into IntencionCompra(alias, id_bicicleta, id_motocicleta, fecha) values ('lucky', null, 1, '2019-05-20 20:30:00');
insert into IntencionCompra(alias, id_bicicleta, id_motocicleta, fecha) values ( 'malopez', 1, null, '2018-05-20 20:30:00');
insert into IntencionCompra(alias, id_bicicleta, id_motocicleta, fecha) values ( 'malopez', null, 1, '2020-01-20 20:30:00');
insert into IntencionCompra(alias, id_bicicleta, id_motocicleta, fecha) values ( 'diva', 3, null, '2019-05-20 20:30:00');
insert into IntencionCompra(alias, id_bicicleta, id_motocicleta, fecha) values ( 'diva', 4, null, '2018-06-22 21:30:00');
insert into IntencionCompra(alias, id_bicicleta, id_motocicleta, fecha) values ( 'diva', null, 2, '2020-03-17 15:30:20');
insert into IntencionCompra(alias, id_bicicleta, id_motocicleta, fecha) values ( 'dreamer', null, 2, '2020-03-17 15:30:20');
insert into IntencionCompra(alias, id_bicicleta, id_motocicleta, fecha) values ( 'dreamer', null, 3, '2020-04-10 18:30:20');
insert into IntencionCompra(alias, id_bicicleta, id_motocicleta, fecha) values ( 'ninja', null, 4, '2020-02-17 20:30:20');
insert into IntencionCompra(alias, id_bicicleta, id_motocicleta, fecha) values ( 'ninja', null, 1, '2020-02-20 16:30:20');
insert into IntencionCompra(alias, id_bicicleta, id_motocicleta, fecha) values ( 'ninja', null, 5, '2020-03-27 18:30:20');
insert into IntencionCompra(alias, id_bicicleta, id_motocicleta, fecha) values ( 'rose', null, 6, '2020-03-20 21:30:20');
insert into IntencionCompra(alias, id_bicicleta, id_motocicleta, fecha) values ( 'green', 3, null, '2020-01-10 17:30:20');
insert into IntencionCompra(alias, id_bicicleta, id_motocicleta, fecha) values ( 'green', 2, null, '2020-02-15 20:30:20');
insert into IntencionCompra(alias, id_bicicleta, id_motocicleta, fecha) values ( 'green', 5, null, '2020-03-17 18:30:20');