package conexionbasededatos;

import database.Credenciales;
import database.DataBaseConnection;

import java.sql.*;
// import Datos.Producto;
import java.sql.Connection;         // El profe uso esta libreria
import java.sql.DriverManager;
import java.sql.ResultSet;          // El profe uso esta libreria 
import java.sql.SQLException;       // El profe uso esta libreria
import java.sql.Statement;          // El profe uso esta libreria
import java.sql.PreparedStatement;  // El profe uso esta libreria
import java.util.ArrayList;         // El profe uso esta libreria
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

// pascal case = clases, ejemplo = DataBase 
// camel case = metodos, ejemplo = database
public class ConexionBaseDeDatos {
    public static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) throws SQLException, ParseException {
        DataBaseConnection dbConnection = new DataBaseConnection();
        dbConnection.ConnectToDataBase();
        String menu1 = "\nMenú\n\nSeleccione una tabla\n\n1. Fabricante\n2. Proveedor\n3. Cliente\n4. Bicicleta\n5. Motocicleta\n6. Intencion de Compra\n7. Salir\n";
        String menu2 = "\n1. Insertar\n2. Consultar\n3. Actualizar\n4. Borrar\n5. Paso atras\n";
        int option = 0, option1 = 0, option2 = 0, option3 = 0, option4 = 0, option5 = 0, option6 = 0;

        do {
            System.out.println(menu1);
            option = sc.nextInt();
            switch (option) {
                case 1:
                    System.out.println("\nQuery que desea realizar\n");

                    do {
                        System.out.println(menu2);
                        option1 = sc.nextInt();
                        switch (option1) {
                            case 1:
                                System.out.println("\nInserte el nombre del fabricante\n");
                                String insertarNombreFabricante = sc.next();
                                dbConnection.insertarFabricante(insertarNombreFabricante);
                                break;
                            case 2:                                
                                System.out.println("\nConsulta fabricantes\n");                                
                                dbConnection.consultarFabricantes();
                                break;
                            case 3:
                                System.out.println("\nActualizar Fabricantes\n");
                                System.out.println("Id de Fabricante a actualizar\n");
                                int idUpdate = sc.nextInt();           
                                System.out.println("\nNuevo nombre del fabricante\n");
                                String nombreUpdate = sc.next();                                                                
                                dbConnection.modificarFabricante(idUpdate, nombreUpdate);
                               break;
                            case 4:
                                System.out.println("\nId  del Fabricante a eliminar\n");
                                int idDelete = sc.nextInt();
                                dbConnection.eliminarFabricante(idDelete);
                                break;                           
                        }
                    } while (option1 != 5);
                case 2:
                    System.out.println("\nQuery que desea realizar\n");
                    do{
                        System.out.println(menu2);
                        option2 = sc.nextInt();
                        switch (option2) {
                            case 1:
                                System.out.println("\nInserte el nombre del proveedor\n");
                                String nombreProveedor = sc.next();
                                System.out.println("\nInserte la dirección del proveedor\n");
                                String direccionProveedor = sc.next();
                                System.out.println("\nInserte el telefono del proveedor\n");
                                String telefonoProveedor = sc.next();
                                dbConnection.insertarProveedor(nombreProveedor, direccionProveedor, telefonoProveedor);
                                break;
                            case 2:
                                System.out.println("\nConsultar proveedor\n");
                                dbConnection.consultarProveedor();
                                break;
                            case 3:
                                System.out.println("\nActualizar Proveedor\n");
                                System.out.println("Id del proveedor a actualiar\n");
                                int idUpdate = sc.nextInt();           
                                System.out.println("\nNuevo nombre del proveedor\n");
                                String nombreUpdate = sc.next();
                                System.out.println("\nNueva dirección del proveedor\n");
                                String direccionUpdate = sc.next();
                                System.out.println("\nNuevo telefono del proveedor\n");
                                String telefonoUpdate = sc.next();
                                dbConnection.modificarProveedor(idUpdate, nombreUpdate, direccionUpdate, telefonoUpdate);
                                break;
                            case 4:
                                System.out.println("Id  del Proveedor a eliminar");
                                int idDelete = sc.nextInt();
                                dbConnection.eliminarProveedor(idDelete);
                                break;
                        }
                    } while (option2 != 5);
                case 3:
                    System.out.println("\nQuery que desea realizar\n");
                    do {                        
                        System.out.println(menu2);
                        option3 = sc.nextInt();
                        switch (option3) {
                            case 1:
                                System.out.println("\nInsertar el alias del cliente\n");
                                String aliasInsert = sc.next();
                                System.out.println("\nInsertar el nombre del cliente\n");
                                String nombreCliente = sc.next();
                                System.out.println("\nInsertar el apellido del cliente\n");
                                String apellidoCliente = sc.next();
                                System.out.println("\nInsertar el email del cliente\n");
                                String emailCliente = sc.next();
                                System.out.println("\nInsertar el celular del cliente\n");
                                String celularCliente = sc.next();
                                System.out.println("\nInsertar la contraseña del cliente\n");
                                double contraseñaCliente = sc.nextDouble();
                                System.out.println("\nInsertar la fecha de nacimiento del cliente\n");
                                String nacimientoCliente = sc.nextLine();
                                
                                dbConnection.insertarCliente(aliasInsert, nombreCliente, apellidoCliente, emailCliente, celularCliente, contraseñaCliente, nacimientoCliente);
                                break;
                            case 2:
                                System.out.println("\nConsultar clientes\n");
                                dbConnection.consultarCliente();
                                break;
                            case 3:
                                System.out.println("\nActualizar cliente\n");
                                System.out.println("Alias del cliente a actualizar\n");
                                String aliasUpdate = sc.next();
                                System.out.println("\nNuevo nombre del cliente\n");
                                String nombreUpdate = sc.next();
                                System.out.println("\nNuevo apellido del cliente\n");
                                String apellidoUpdate = sc.next();
                                System.out.println("\nNuevo email del cliente\n");
                                String emailUpdate = sc.next();
                                System.out.println("\nNuevo celular del cliente\n");
                                String celularUpdate = sc.next();
                                System.out.println("\nNueva contraseña del cliente\n");
                                double contrasenaUpdate = sc.nextDouble();
                                System.out.println("\nNueva de fecha de nacimiento del cliente\n");
                                String nacimientoUpdate = sc.next(); 
                                dbConnection.modificarCliente(aliasUpdate, nombreUpdate, apellidoUpdate, emailUpdate, celularUpdate, contrasenaUpdate, nacimientoUpdate);
                                break;
                            case 4:
                                System.out.println("Alias del cliente a eliminar");
                                String aliasDelete = sc.next();
                                dbConnection.eliminarCliente(aliasDelete);
                                break;
                        }
                    } while (option3 != 5);
                case 4:
                    System.out.println("\nQuery que desea realizar\n");
                    do {                        
                        System.out.println(menu2);
                        option4 = sc.nextInt();
                        switch (option4) {
                            case 1:
                                System.out.println("\nInserte el id del fabricante de la bicicleta\n");
                                int nombreBicicleta = sc.nextInt();
                                System.out.println("\nInserte el precio unitario de la bicicleta\n");
                                String precioUnitario = sc.next();
                                System.out.println("\nInserte el año de construcción de la bicicleta\n");
                                String anioConstruccion = sc.next();
                                dbConnection.insertarBicicleta(nombreBicicleta, precioUnitario, anioConstruccion);
                                break;
                            case 2:
                                System.out.println("\nConsulta bicicleta\n");
                                dbConnection.consultarBicicleta();
                                break;
                            case 3:
                                System.out.println("\nActualizar Bicicletas\n");
                                System.out.println("Id de la bicicleta a actualiar\n");
                                int bicicletaUpdate = sc.nextInt();           
                                System.out.println("\nNuevo id del fabricante de la bicicleta\n");
                                int fabricateUpdate = sc.nextInt();
                                System.out.println("\nNuevo precio de la bicicleta\n");
                                String precioUpdate = sc.next();
                                System.out.println("\nNuevo año de construcción de la bicicleta\n");
                                String construccionUpdate = sc.next();
                                dbConnection.modificarBicicleta(bicicletaUpdate, fabricateUpdate, precioUpdate, construccionUpdate);
                                break;
                            case 4:
                                System.out.println("Bicicleta a eliminar");
                                int bicicletaDelete = sc.nextInt();
                                dbConnection.eliminarBicicleta(bicicletaDelete);
                                break;
                        }
                    } while (option4 != 5);
                case 5:
                    System.out.println("\nQuery que desea realizar\n");
                    do {                        
                        System.out.println(menu2);
                        option5 = sc.nextInt();
                        switch (option5) {
                            case 1:
                                System.out.println("\nInserte el id del proveedor de la motocicleta\n");
                                int idProveedor = sc.nextInt();
                                System.out.println("\nInserte el id del fabricante de la motocicleta\n");
                                int idFabricante = sc.nextInt();
                                System.out.println("\nInserte el precio unitario de la motocicleta\n");
                                double precioMotocicleta = sc.nextDouble();
                                System.out.println("Inserte las horas de autonomia de la bateria");
                                int autonomiaBateria =sc.nextInt();
                                dbConnection.insertarMotocicleta(idProveedor, idFabricante, precioMotocicleta, autonomiaBateria);
                                break;
                            case 2:
                                System.out.println("\nConsulta motocicleta\n");
                                dbConnection.consultarMotocicleta();
                                break;
                            case 3:
                                System.out.println("\nActualizar motocicletas\n");
                                System.out.println("Id de la motocicleta a actualizar\n");
                                int motocicletaUpdate = sc.nextInt();           
                                System.out.println("\nNuevo id del proveedor\n");
                                int proveedorUpdate = sc.nextInt();
                                System.out.println("\nNuevo id del fabricante\n");
                                int fabricanteUpdate = sc.nextInt();
                                System.out.println("\nNuevo precio de la motocicleta\n");
                                double precioUpdate = sc.nextDouble();
                                System.out.println("\nNueva autonomia de la bateria");
                                int autonomiaUpdate = sc.nextInt();
                                dbConnection.modificarMotocicleta(motocicletaUpdate, proveedorUpdate, fabricanteUpdate, precioUpdate, autonomiaUpdate);
                                break;
                            case 4:
                                System.out.println("Motocicleta a eliminar");
                                int motocicletaDelete = sc.nextInt();
                                dbConnection.eliminarMotocicleta(motocicletaDelete);
                                break;                               
                        }
                    } while (option5 != 5);
                case 6:
                    System.out.println("\nQuery que desea realizar\n");
                    do {
                        System.out.println(menu2);
                        option6 = sc.nextInt();
                        switch (option6) {
                            case 1:
                                System.out.println("alias de la intención de compra");
                                String aliasIntencionCompraAInsertar = sc.next();
                                System.out.println("IdBicileta de la intención de compra a actualizar");
                                int idBicicletaIntencionCompraAInsertar = sc.nextInt();
                                System.out.println("IdMotocicleta de la intención de compra a actualizar");
                                int idMotocicletaIntencionCompraAInsertar = sc.nextInt();
                                dbConnection.insertarIntencionCompra(
                                        aliasIntencionCompraAInsertar, 
                                        idBicicletaIntencionCompraAInsertar,
                                        idMotocicletaIntencionCompraAInsertar,
                                        new java.util.Date().getTime()                                        
                                );
                                break;
                            case 2:
                                System.out.println("Consultar inteciones de compra");
                                dbConnection.consultarIntencionCompra();
                                break;
                            case 3:
                                System.out.println("Id de la intención de compra a actualizar");
                                int idIntencionCompraAModificar = sc.nextInt();
                                System.out.println("alias de la intención de compra a actualizar");
                                String aliasIntencionCompraAModificar = sc.next();
                                System.out.println("IdBicileta de la intención de compra a actualizar");
                                int idBicicletaIntencionCompraAModificar = sc.nextInt();
                                System.out.println("IdMotocicleta de la intención de compra a actualizar");
                                int idMotocicletaIntencionCompraAModificar = sc.nextInt();
                                dbConnection.modificarIntencionCompra(
                                        aliasIntencionCompraAModificar, 
                                        idBicicletaIntencionCompraAModificar,
                                        idMotocicletaIntencionCompraAModificar,
                                        new java.util.Date().getTime(),
                                        idIntencionCompraAModificar
                                );
                                break;
                            case 4:
                                System.out.println("Id de la intención de compra a eliminar");
                                int idIntencionCompra = sc.nextInt();
                                dbConnection.eliminarIntencionCompra(idIntencionCompra);
                                break;
                        }
                    } while (option5 != 5);
            }

        } while (option != 7);
    }
}
