CREATE TABLE Bicicleta(
	id_bicicleta int,
	nombre_fabricante varchar(40) not null,
	precio_unitario varchar(100) not null,
	anio_construccion date not null,
	primary key(id_bicicleta)
);
insert into Bicicleta values (1, 1, '1200000', '2017');
insert into Bicicleta values (2, 2, '1450000', '2019');
insert into Bicicleta values (3, 3, '2000000', '2020');
insert into Bicicleta values (4, 4, '950000', '2021');
insert into Bicicleta values (5, 5, '1950000', '1018');