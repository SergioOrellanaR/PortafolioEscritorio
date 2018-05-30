/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odontologicaescritorio.modelo;
import java.sql.*;
import java.time.LocalDate;

/**
 *
 * @author Marco Antonio
 */
public class BoletaDAO implements DatosConexion{
    private int id;
    private LocalDate fecha;
    private int rutCliente;

    public BoletaDAO(int id, LocalDate fecha, int rutCliente) {
        this.id = id;
        this.fecha = fecha;
        this.rutCliente = rutCliente;
    }

    public BoletaDAO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getRutCliente() {
        return rutCliente;
    }

    public void setRutCliente(int rutCliente) {
        this.rutCliente = rutCliente;
    }
    
    public String registrarBoletaBD(){
        try{
            Class.forName(DRIVER);
            Connection conexion =  DriverManager.getConnection(URL,USUARIO,CLAVE);
            Statement declaracion = conexion.createStatement();
            declaracion.executeUpdate("INSERT INTO BOLETA_CLIENTE (ID, FECHA, RUT_CLIENTE) VALUES (SEQ_ID_BOLETA_CLI.NEXTVAL, TO_DATE('" + fecha + "', 'YYYY-MM-DD')," + rutCliente + ")");
            conexion.close();
            return "Registro de boleta en la base de datos fue exitoso.";
        }catch(Exception e){
            System.out.println("Error : " + e);
            return "No se pudo registrar servicio en base de datos: " + e;
        }        
    }  
    
    public boolean registrarDetalleBoletaBD(int idBoleta, int idServicio, int valor){
        try{
            Class.forName(DRIVER);
            Connection conexion =  DriverManager.getConnection(URL,USUARIO,CLAVE);
            Statement declaracion = conexion.createStatement();
            declaracion.executeUpdate("INSERT INTO DETALLE_BOLETA_CLI (ID_BOLETA_CLI, ID_SERVICIO, VALOR) VALUES (" + idBoleta + "," + idServicio + "," + valor + ")");
            conexion.close();
            return true;
        }catch(Exception e){
            System.out.println("Error en registro de detalle: " + e);
            return false;
        }        
    }       
}
