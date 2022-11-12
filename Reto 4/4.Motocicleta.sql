CREATE TABLE Motocicleta(
	id_motocicleta int,
	id_proveedor int not null,
	nombre_fabricante varchar(40) not null,
	precio_unitario decimal not null,
	autonomia_bateria varchar(40) not null,
	primary key(id_motocicleta),
	foreign key(id_proveedor) references Proveedor(id_proveedor)
);
insert into Motocicleta values (1, 1, 6, 4200000, '18 horas');
insert into Motocicleta values (2, 2, 7, 5600000, '14 horas');
insert into Motocicleta values (3, 1, 8, 4600000, '26 horas');
insert into Motocicleta values (4, 3, 9, 8000000, '36 horas');
insert into Motocicleta values (5, 4, 10, 5900000, '20 horas');
insert into Motocicleta values (6, 5, 11, 4500000, '12 horas');