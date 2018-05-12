/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odontologicaescritorio.modelo;
import java.sql.*;
import java.time.*;
import java.util.ArrayList;

/**
 *
 * @author Marco Antonio
 */
public class ServicioDAO implements DatosConexion{
    int Id;
    String descripcion;
    int precio;

    public ServicioDAO(){}
    
    public ServicioDAO(int Id, String descripcion, int precio) {
        this.Id = Id;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
    public ArrayList<ServicioDTO> obtenerTodosLosServiciosBD(){
        ArrayList<ServicioDTO> listaServicios = new ArrayList<ServicioDTO>();
        try{
            Class.forName(DRIVER);
            Connection conexion =  DriverManager.getConnection(URL,USUARIO,CLAVE);
            Statement declaracion = conexion.createStatement();
            ResultSet resultado = declaracion.executeQuery("SELECT SERVICIO.ID, SERVICIO.DESCRIPCION, SERVICIO.PRECIO FROM SERVICIO");
            while (resultado.next()) {
                this.setId(resultado.getInt(1));
                this.setDescripcion(resultado.getString(2));
                this.setPrecio(resultado.getInt(3));
                listaServicios.add(new ServicioDTO(this.getId(), this.getDescripcion(), this.getPrecio()));
            }  
            conexion.close();
            return listaServicios;
        }catch(Exception e){
            System.out.println("Error : " + e);
            return listaServicios;
        }
    }  
    
    public String registrarServicioBD(){
        try{
            Class.forName(DRIVER);
            Connection conexion =  DriverManager.getConnection(URL,USUARIO,CLAVE);
            Statement declaracion = conexion.createStatement();
            declaracion.executeUpdate("INSERT INTO SERVICIO(SERVICIO.ID, SERVICIO.DESCRIPCION, SERVICIO.PRECIO) VALUES (SEQ_ID_SERVICIO.NEXTVAL,'" + this.getDescripcion() + "'," + this.getPrecio() + ")");
            conexion.close();
            return "Registro de servicio en la base de datos fue exitoso.";
        }catch(Exception e){
            System.out.println("Error : " + e);
            return "No se pudo registrar servicio en base de datos: " + e;
        }        
    }
}
