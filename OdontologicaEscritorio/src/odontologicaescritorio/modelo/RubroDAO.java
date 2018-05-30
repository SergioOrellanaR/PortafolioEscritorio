/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odontologicaescritorio.modelo;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author Marco Antonio
 */
public class RubroDAO implements DatosConexion{
    private String idDescripcion;

    public RubroDAO(String idDescripcion) {
        this.idDescripcion = idDescripcion;
    }
    
    public RubroDAO(){}
    
    public String getIdDescripcion() {
        return idDescripcion;
    }

    public void setIdDescripcion(String idDescripcion) {
        this.idDescripcion = idDescripcion;
    }
    
    public ArrayList<RubroDTO> obtenerTodasLasCiudadesBD(){
        ArrayList<RubroDTO> listaRubros = new ArrayList<RubroDTO>();
        try{
            Class.forName(DRIVER);
            Connection conexion =  DriverManager.getConnection(URL,USUARIO,CLAVE);
            Statement declaracion = conexion.createStatement();
            ResultSet resultado = declaracion.executeQuery("SELECT RUBRO_PROVEEDOR.ID ||' - '|| RUBRO_PROVEEDOR.DESCRIPCION FROM RUBRO_PROVEEDOR");
            while (resultado.next()) {
                this.setIdDescripcion(resultado.getString(1));
                listaRubros.add(new RubroDTO(this.getIdDescripcion()));
            }  
            conexion.close();
            return listaRubros;
        }catch(Exception e){
            System.out.println("Error al traer lista de rubros de proveedor: " + e);
            return listaRubros;
        }
    }     
}
