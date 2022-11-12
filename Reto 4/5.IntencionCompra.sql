CREATE TABLE IntencionCompra(
	id_compra int not null,
	alias varchar(40) not null,
	id_bicicleta int,
	id_motocicleta int,
	fecha datetime not null,
	primary key (id_compra),
	foreign key (alias) references Cliente(alias),
	foreign key (id_bicicleta) references Bicicleta(id_bicicleta),
	foreign key (id_motocicleta) references Motocicleta(id_motocicleta)
);
insert into IntencionCompra values (1, 'lucky', 1, null, '2017-10-25 20:00:00');
insert into IntencionCompra values (2, 'lucky', 2, null, '2019-03-15 18:30:00');
insert into IntencionCompra values (3,'lucky', null, 1, '2019-05-20 20:30:00');
insert into IntencionCompra values (4, 'malopez', 1, null, '2018-05-20 20:30:00');
insert into IntencionCompra values (5, 'malopez', null, 1, '2020-01-20 20:30:00');
insert into IntencionCompra values (6, 'diva', 3, null, '2019-05-20 20:30:00');
insert into IntencionCompra values (7, 'diva', 4, null, '2018-06-22 21:30:00');
insert into IntencionCompra values (8, 'diva', null, 2, '2020-03-17 15:30:20');
insert into IntencionCompra values (9, 'dreamer', null, 2, '2020-03-17 15:30:20');
insert into IntencionCompra values (10, 'dreamer', null, 3, '2020-04-10 18:30:20');
insert into IntencionCompra values (11, 'ninja', null, 4, '2020-02-17 20:30:20');
insert into IntencionCompra values (12, 'ninja', null, 1, '2020-02-20 16:30:20');
insert into IntencionCompra values (13, 'ninja', null, 5, '2020-03-27 18:30:20');
insert into IntencionCompra values (14, 'rose', null, 6, '2020-03-20 21:30:20');
insert into IntencionCompra values (15, 'green', 3, null, '2020-01-10 17:30:20');
insert into IntencionCompra values (16, 'green', 2, null, '2020-02-15 20:30:20');
insert into IntencionCompra values (17, 'green', 5, null, '2020-03-17 18:30:20');