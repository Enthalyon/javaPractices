select "Consulta 1";
select fabricante from fabricante order by fabricante;
select "Consulta 2";
select F.fabricante, B.precio_unitario,B.anio_construccion FROM Bicicleta B
inner join fabricante F ON F.id_fabricante = B.nombre_fabricante 
where B.anio_construccion >='2019' order by F.fabricante;
select "Consulta 3";
SELECT F.fabricante from fabricante F
inner join motocicleta M on M.nombre_fabricante = F.id_fabricante
inner join proveedor P on M.id_proveedor = P.id_proveedor
where P.id_proveedor = 1;
select "Consulta 4";
SELECT F.fabricante from Fabricante F
left join Motocicleta M on F.id_fabricante = M.nombre_fabricante
left join Bicicleta B on F.id_fabricante = B.nombre_fabricante
left join IntencionCompra I on I.id_bicicleta = B.id_bicicleta OR I.id_motocicleta = M.id_motocicleta
where I.alias = 'lucky' ORDER BY F.Fabricante;
select "Consulta 5";
select C.alias, C.Nombres, C.apellidos From Cliente C
left join IntencionCompra I on C.alias = I.alias 
where I.id_bicicleta = 3 order by C.nombres;
select "Consulta 6";
select count(id_bicicleta) from bicicleta where anio_construccion >= '2019';