CREATE TABLE Proveedor(
	id_proveedor int not null,
	nombre varchar(50) not null,
	direccion varchar(50) not null,
	telefono varchar(20) not null,
	primary key (id_proveedor)
);
insert into proveedor values (1,'Auteco','calle 7 No. 45-17', '05713224459');
insert into proveedor values (2,'Hitachi', 'calle 19 No. 108-26', '05714223344');
insert into proveedor values (3,'Bosch', 'carrera 68 No. 26-45', '05715678798');
insert into proveedor values (4,'Teco', 'calle 77 No. 68-33', '05712213243');
insert into proveedor values (5,'General Electric', 'calle 29 No. 26-12', '05717239919'); 