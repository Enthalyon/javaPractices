package database;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
public class DataBaseConnection {

    private Connection conn;

    public void ConnectToDataBase() {
        String dbUrl = Credenciales.DATABASE_URL;
        String userName = Credenciales.USER;
        String passWord = Credenciales.PASSWORD;

        try {
            conn = DriverManager.getConnection(dbUrl, userName, passWord);
            if (conn != null) {
                System.out.println("Conexión exítosa");
            }
        } catch (SQLException ex) {
            System.out.println("Conexíon fallida");
        }
    }

    // Metodos fabricante
    public void insertarFabricante(String NombreFabricante) throws SQLException {
        String sql = "INSERT INTO Fabricante(fabricante) VALUES (?)";
        PreparedStatement statement = this.conn.prepareStatement(sql);
        statement.setString(1, NombreFabricante);
        int insertedRows = statement.executeUpdate();
        if (insertedRows > 0) {
            System.out.println("Inserción exítosa");
        } else {
            System.out.println("Inserción fallida");
        }
    }

    public void consultarFabricantes() throws SQLException {
        String sql = "SELECT * FROM Fabricante";
        PreparedStatement statement = this.conn.prepareStatement(sql);
        statement.executeQuery();
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            System.out.println("Id: " + rs.getInt(1) + ", Fabricante: " + rs.getString(2));
        }
        rs.close();
        statement.close();

    }

    public void modificarFabricante(int id, String NombreFabricante) throws SQLException {
        String sql = "UPDATE Fabricante SET fabricante = (?) WHERE id_fabricante = (?)";
        PreparedStatement statement = this.conn.prepareStatement(sql);
        statement.setString(1, NombreFabricante);
        statement.setInt(2, id);
        int insertedRows = statement.executeUpdate();
        if (insertedRows > 0) {
            System.out.println("Actualización exítosa");
        } else {
            System.out.println("Actualización fallida");
        }
    }

    public void eliminarFabricante(int id) throws SQLException {
        String sql = "DELETE FROM Fabricante WHERE id_fabricante = ?";
        PreparedStatement statement = this.conn.prepareStatement(sql);
        statement.setInt(1, id);
        int insertedRows = statement.executeUpdate();
        if (insertedRows > 0) {
            System.out.println("Eliminación exítosa");
        } else {
            System.out.println("Eliminación fallida");
        }
    }

    // Metodos proveedor
    public void insertarProveedor(String nombreProveedor, String direccionProveedor, String telefonoProveedor) throws SQLException {
        String sql = "INSERT INTO Proveedor(nombre, direccion, telefono) VALUES (?, ?, ?)";
        PreparedStatement statement = this.conn.prepareStatement(sql);
        statement.setString(1, nombreProveedor);
        statement.setString(2, direccionProveedor);
        statement.setString(3, telefonoProveedor);
        int insertedRows = statement.executeUpdate();
        if (insertedRows > 0) {
            System.out.println("Inserción exítosa");
        } else {
            System.out.println("Inserción fallida");
        }
    }
    
     public void consultarProveedor() throws SQLException {
        String sql = "SELECT * FROM Proveedor";
        PreparedStatement statement = this.conn.prepareStatement(sql);
        statement.executeQuery();
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            System.out.println("Id: " + rs.getInt(1) + ", Fabricante: " + rs.getString(2) + ", Dirección: " + rs.getString(3) + ", Telefono: " + rs.getString(4));
        }
        rs.close();
        statement.close();

    }
     
     public void modificarProveedor(int id, String nombreProveedor, String direccionProveedor, String telefonoProveedor) throws SQLException {
        String sql = "UPDATE Proveedor SET nombre = (?), direccion = (?), telefono = (?) WHERE id_proveedor = (?)";
        PreparedStatement statement = this.conn.prepareStatement(sql);
        statement.setString(1, nombreProveedor);
        statement.setString(2, direccionProveedor);
        statement.setString(3, telefonoProveedor);
        statement.setInt(4, id);
        int insertedRows = statement.executeUpdate();
        if (insertedRows > 0) {
            System.out.println("Actualización exítosa");
        } else {
            System.out.println("Actualización fallida");
        }
    }
     
      public void eliminarProveedor(int id) throws SQLException {
        String sql = "DELETE FROM Proveedor WHERE id_proveedor = ?";
        PreparedStatement statement = this.conn.prepareStatement(sql);
        statement.setInt(1, id);
        int insertedRows = statement.executeUpdate();
        if (insertedRows > 0) {
            System.out.println("Eliminación exítosa");
        } else {
            System.out.println("Eliminación fallida");
        }
    }
      // Metodos cliente
      public void insertarCliente(String alias, String nombreCliente, String apellidoCliente, String emailCliente, String celularCliente, Double contrasenaCliente, String fechaNacimientoCliente) throws SQLException {
        String sql = "INSERT INTO Cliente(alias, nombres, apellidos, email, celular, contrasena, fecha_nacimiento) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = this.conn.prepareStatement(sql);
        statement.setString(1, alias);
        statement.setString(2, nombreCliente);
        statement.setString(3, apellidoCliente);
        statement.setString(4, emailCliente);
        statement.setString(5, celularCliente);
        statement.setDouble(6, contrasenaCliente);
        statement.setString(7, fechaNacimientoCliente);
        int insertedRows = statement.executeUpdate();
        if (insertedRows > 0) {
            System.out.println("Inserción exítosa");
        } else {
            System.out.println("Inserción fallida");
        }
    }
      
     public void consultarCliente() throws SQLException {
        String sql = "SELECT * FROM Cliente";
        PreparedStatement statement = this.conn.prepareStatement(sql);
        statement.executeQuery();
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            System.out.println("Alias: " + rs.getString(1) + ", Nombre: " + rs.getString(2) + ", Apellidos: " + rs.getString(3) + ", Email: " + rs.getString(4) + ", Celular: " + rs.getString(5) + ", Contraseña: " + rs.getDouble(6) + ", Fecha de nacimiento: " + rs.getString(7));
        }
        rs.close();
        statement.close();

    }   
     public void modificarCliente(String aliasCliente, String nombreCliente, String apellidoCliente, String emailCliente, String celularCliente, Double contrasenaCliente, String fechaNacimientoCliente) throws SQLException {
        String sql = "UPDATE Cliente SET nombres = (?), apellidos = (?), email = (?), celular = (?), contrasena = (?), fecha_nacimiento = (?) WHERE alias = (?)";
        PreparedStatement statement = this.conn.prepareStatement(sql);
        statement.setString(1, nombreCliente);
        statement.setString(2, apellidoCliente);
        statement.setString(3, emailCliente);
        statement.setString(4, celularCliente);
        statement.setDouble(5, contrasenaCliente);
        statement.setString(6, fechaNacimientoCliente);
        statement.setString(7, aliasCliente);
        int insertedRows = statement.executeUpdate();
        if (insertedRows > 0) {
            System.out.println("Actualización exítosa");
        } else {
            System.out.println("Actualización fallida");
        }
        
    }
      public void eliminarCliente(String aliasCliente) throws SQLException {
        String sql = "DELETE FROM Cliente WHERE alias = ?";
        PreparedStatement statement = this.conn.prepareStatement(sql);
        statement.setString(1, aliasCliente);
        int insertedRows = statement.executeUpdate();
        if (insertedRows > 0) {
            System.out.println("Eliminación exítosa");
        } else {
            System.out.println("Eliminación fallida");
        }
    }
      //Metodos Bicicleta
      public void insertarBicicleta(int nombreFabricante, String precioUnitario, String anioConstruccion) throws SQLException {
        String sql = "INSERT INTO Bicicleta (nombre_fabricante, precio_unitario, anio_construccion) VALUES (?, ?, ?)";
        PreparedStatement statement = this.conn.prepareStatement(sql);
        statement.setInt(1, nombreFabricante);
        statement.setString(2, precioUnitario);
        statement.setString(3, anioConstruccion);
        int insertedRows = statement.executeUpdate();
        if (insertedRows > 0) {
            System.out.println("Inserción exítosa");
        } else {
            System.out.println("Inserción fallida");
        }
    }
      public void consultarBicicleta() throws SQLException {
        String sql = "SELECT * FROM Bicicleta";
        PreparedStatement statement = this.conn.prepareStatement(sql);
        statement.executeQuery();
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            System.out.println("Id bicicleta: " + rs.getInt(1) + ", Id Fabricante: " + rs.getInt(2) + ", Precio unitario: " + rs.getString(3) + ", año de construcción: " + rs.getString(4));
        }
        rs.close();
        statement.close();

    }
       public void modificarBicicleta(int idBicicleta, int idFabricante, String precioUnitario, String anioConstruccion) throws SQLException {
        String sql = "UPDATE Bicicleta SET nombre_fabricante = (?), precio_unitario = (?), anio_construccion = (?) WHERE id_bicicleta = (?)";
        PreparedStatement statement = this.conn.prepareStatement(sql);
        statement.setInt(1, idFabricante);
        statement.setString(2, precioUnitario);
        statement.setString(3, anioConstruccion);
        statement.setInt(4, idBicicleta);
        int insertedRows = statement.executeUpdate();
        if (insertedRows > 0) {
            System.out.println("Actualización exítosa");
        } else {
            System.out.println("Actualización fallida");
        }
    }
       public void eliminarBicicleta(int idBicicleta) throws SQLException {
        String sql = "DELETE FROM Bicicleta WHERE id_bicicleta = ?";
        PreparedStatement statement = this.conn.prepareStatement(sql);
        statement.setInt(1, idBicicleta);
        int insertedRows = statement.executeUpdate();
        if (insertedRows > 0) {
            System.out.println("Eliminación exítosa");
        } else {
            System.out.println("Eliminación fallida");
        }
    }
       //Metodos motocicleta
        public void insertarMotocicleta(int idProveedor, int idFabricante, Double precioUnitario, int autonomiaBateria) throws SQLException {
        String sql = "INSERT INTO Motocicleta (id_proveedor, nombre_fabricante, precio_unitario, autonomia_bateria) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = this.conn.prepareStatement(sql);
        statement.setInt(1, idProveedor);
        statement.setInt(2, idFabricante);
        statement.setDouble(3, precioUnitario);
        statement.setString(4, autonomiaBateria + " horas");
        int insertedRows = statement.executeUpdate();
        if (insertedRows > 0) {
            System.out.println("Inserción exítosa");
        } else {
            System.out.println("Inserción fallida");
        }
    }
        public void consultarMotocicleta() throws SQLException {
        String sql = "SELECT * FROM Motocicleta";
        PreparedStatement statement = this.conn.prepareStatement(sql);
        statement.executeQuery();
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            System.out.println("Id motocicleta: " + rs.getInt(1) + ", Id proveedor: " + rs.getInt(2) + ", Id fabricante: " + rs.getInt(3) + ", Precio Unitario: " + rs.getDouble(4) + ", Autonomia de la bateria: " + rs.getString(5));
        }
        rs.close();
        statement.close();

    }
        public void modificarMotocicleta(int idMotocicleta, int idProveedor, int idFabricante, Double precioUnitario, int autonomiaBateria) throws SQLException {
        String sql = "UPDATE Motocicleta SET id_proveedor = (?), nombre_fabricante = (?), precio_unitario, autonomia_bateria = (?) WHERE id_motocicleta = (?)";
        PreparedStatement statement = this.conn.prepareStatement(sql);
        statement.setInt(1, idProveedor);
        statement.setInt(2, idFabricante);
        statement.setDouble(3, precioUnitario);
        statement.setInt(4, autonomiaBateria);
        statement.setInt(5, idMotocicleta);
        int insertedRows = statement.executeUpdate();
        if (insertedRows > 0) {
            System.out.println("Actualización exítosa");
        } else {
            System.out.println("Actualización fallida");
        }
    }
        public void eliminarMotocicleta(int idMotocicleta) throws SQLException {
        String sql = "DELETE FROM Motocicleta WHERE id_motocicleta = ?";
        PreparedStatement statement = this.conn.prepareStatement(sql);
        statement.setInt(1, idMotocicleta);
        int insertedRows = statement.executeUpdate();
        if (insertedRows > 0) {
            System.out.println("Eliminación exítosa");
        } else {
            System.out.println("Eliminación fallida");
        }
    }
        //Metodos intención de compra
    public void insertarIntencionCompra(String alias, int idBicicleta, int idMotocicleta, long fecha) throws SQLException {
        String sql = "INSERT INTO IntencionCompra(alias, id_bicicleta, id_motocicleta, fecha) values (?, ?, ?, ?)";
        PreparedStatement statement = this.conn.prepareStatement(sql);
        statement.setString(1, alias);
        statement.setInt(2, idBicicleta);
        statement.setInt(3, idMotocicleta);
        statement.setTimestamp(4, new Timestamp(fecha));
        int insertedRows = statement.executeUpdate();
        if (insertedRows > 0) {
            System.out.println("Inserción exítosa");
        } else {
            System.out.println("Inserción fallida");
        }
    }

    public void consultarIntencionCompra() throws SQLException {
        String sql = "SELECT * FROM IntencionCompra";
        PreparedStatement statement = this.conn.prepareStatement(sql);
        statement.executeQuery();
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            System.out.println("Id Compra: " + rs.getInt(1) + ", alias comprador: " + rs.getString(2) + ", id bicileta: " + rs.getInt(3) + ", id motocileta: " + rs.getInt(4) + ", año de construcción: " + rs.getTimestamp(5));
        }
        rs.close();
        statement.close();
    }

    public void modificarIntencionCompra(String alias, int idBicicleta, int idMotocicleta, long fecha, int idCompra) throws SQLException {
        String sql = "UPDATE IntencionCompra SET alias = (?), id_bicicleta = (?), id_motocicleta = (?), fecha = (?) WHERE id_compra = (?)";
        PreparedStatement statement = this.conn.prepareStatement(sql);
        statement.setString(1, alias);
        statement.setInt(2, idBicicleta);
        statement.setInt(3, idMotocicleta);
        statement.setTimestamp(4, new Timestamp(fecha));
        statement.setInt(5, idCompra);
        int insertedRows = statement.executeUpdate();
        if (insertedRows > 0) {
            System.out.println("Actualización exítosa");
        } else {
            System.out.println("Actualización fallida");
        }
    }
    public void eliminarIntencionCompra(int idCompra) throws SQLException {
        String sql = "DELETE FROM IntencionCompra WHERE id_compra = ?";
        PreparedStatement statement = this.conn.prepareStatement(sql);
        statement.setInt(1, idCompra);
        int insertedRows = statement.executeUpdate();
        if (insertedRows > 0) {
            System.out.println("Eliminación exítosa");
        } else {
            System.out.println("Eliminación fallida");
        }
    }
}
