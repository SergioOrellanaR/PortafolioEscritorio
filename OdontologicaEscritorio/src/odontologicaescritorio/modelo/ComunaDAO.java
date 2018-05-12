/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odontologicaescritorio.modelo;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author Marco Antonio
 */
public class ComunaDAO implements DatosConexion {
    String idNombre;
    String idNombreCiudad;

    public ComunaDAO(){}
    
    public ComunaDAO(String idNombre, String idNombreCiudad) {
        this.idNombre = idNombre;
        this.idNombreCiudad = idNombreCiudad;
    }

    public String getIdNombre() {
        return idNombre;
    }

    public void setIdNombre(String idNombre) {
        this.idNombre = idNombre;
    }

    public String getIdNombreCiudad() {
        return idNombreCiudad;
    }

    public void setIdNombreCiudad(String idNombreCiudad) {
        this.idNombreCiudad = idNombreCiudad;
    }
    
    public ArrayList<ComunaDTO> obtenerTodasLasComunasPorCiudadBD(int id){
        ArrayList<ComunaDTO> listaComunas = new ArrayList<ComunaDTO>();
        try{
            Class.forName(DRIVER);
            Connection conexion =  DriverManager.getConnection(URL,USUARIO,CLAVE);
            Statement declaracion = conexion.createStatement();
            ResultSet resultado = declaracion.executeQuery("SELECT COMUNA.ID ||' - '|| COMUNA.NOMBRE, CIUDAD.ID ||' - '|| CIUDAD.NOMBRE FROM COMUNA JOIN CIUDAD ON (CIUDAD.ID = COMUNA.ID_CIUDAD) WHERE CIUDAD.ID = " + id);
            while (resultado.next()) {
                this.setIdNombre(resultado.getString(1));
                this.setIdNombreCiudad(resultado.getString(2));
                listaComunas.add(new ComunaDTO(this.getIdNombre(), this.getIdNombreCiudad()));
            }  
            conexion.close();
            return listaComunas;
        }catch(Exception e){
            System.out.println("Error : " + e);
            return listaComunas;
        }
    }      
}
