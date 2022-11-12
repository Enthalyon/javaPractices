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