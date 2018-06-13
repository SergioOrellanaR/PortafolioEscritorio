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
public class FamiliaProductoDAO implements DatosConexion{
    int id;
    String descripcion;

    public FamiliaProductoDAO(){}
    
    public FamiliaProductoDAO(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }  
    
    public ArrayList<FamiliaProductoDTO> obtenerTodasLasFamiliasProductoBD(){
        ArrayList<FamiliaProductoDTO> listaFamiliasProducto = new ArrayList<FamiliaProductoDTO>();
        try{
            Class.forName(DRIVER);
            Connection conexion =  DriverManager.getConnection(URL,USUARIO,CLAVE);
            Statement declaracion = conexion.createStatement();
            ResultSet resultado = declaracion.executeQuery("SELECT FAMILIA_PRODUCTO.ID, FAMILIA_PRODUCTO.DESCRIPCION FROM FAMILIA_PRODUCTO");
            while (resultado.next()) {
                this.setId(resultado.getInt(1));
                this.setDescripcion(resultado.getString(2));
                listaFamiliasProducto.add(new FamiliaProductoDTO(this.getId(), this.getDescripcion()));
            }  
            conexion.close();
            return listaFamiliasProducto;
        }catch(Exception e){
            System.out.println("Error : " + e);
            return listaFamiliasProducto;
        }
    }
    
    public String registrarFamiliaBD(){
        try{
            Class.forName(DRIVER);
            Connection conexion =  DriverManager.getConnection(URL,USUARIO,CLAVE);
            Statement declaracion = conexion.createStatement();
            declaracion.executeUpdate("INSERT INTO FAMILIA_PRODUCTO(FAMILIA_PRODUCTO.ID, FAMILIA_PRODUCTO.DESCRIPCION) VALUES (SEQ_ID_FAMILIA_PROD.NEXTVAL,'" + this.getDescripcion() + "')");
            conexion.close();
            return "Registro de familia de producto en la base de datos fue exitoso.";
        }catch(Exception e){
            System.out.println("Error : " + e);
            return "No se pudo registrar familia de producto en base de datos: " + e;
        }        
    }    
}
