update Bicicleta set anio_construccion = '2017' where nombre_fabricante = 'Cannondale';
update Cliente set celular = 3115678432 where alias = 'ninja';
delete from IntencionCompra where alias = 'green' and id_bicicleta = 2;