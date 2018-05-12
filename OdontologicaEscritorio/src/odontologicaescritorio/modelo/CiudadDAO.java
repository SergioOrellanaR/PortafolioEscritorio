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
public class CiudadDAO implements DatosConexion{
    String idNombre;

    public CiudadDAO(){}
    
    public CiudadDAO(String idNombre) {
        this.idNombre = idNombre;
    }

    public String getIdNombre() {
        return idNombre;
    }

    public void setIdNombre(String idNombre) {
        this.idNombre = idNombre;
    }
    
    public ArrayList<CiudadDTO> obtenerTodasLasCiudadesBD(){
        ArrayList<CiudadDTO> listaCiudades = new ArrayList<CiudadDTO>();
        try{
            Class.forName(DRIVER);
            Connection conexion =  DriverManager.getConnection(URL,USUARIO,CLAVE);
            Statement declaracion = conexion.createStatement();
            ResultSet resultado = declaracion.executeQuery("SELECT CIUDAD.ID ||' - '|| CIUDAD.NOMBRE FROM CIUDAD");
            while (resultado.next()) {
                this.setIdNombre(resultado.getString(1));
                listaCiudades.add(new CiudadDTO(this.getIdNombre()));
            }  
            conexion.close();
            return listaCiudades;
        }catch(Exception e){
            System.out.println("Error : " + e);
            return listaCiudades;
        }
    }      
}
