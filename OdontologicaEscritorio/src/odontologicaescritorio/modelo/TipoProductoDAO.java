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
public class TipoProductoDAO implements DatosConexion{
    int id;
    String descripcion;
    String familiaTipo;
    
    public TipoProductoDAO(){}

    public TipoProductoDAO(int id, String descripcion, String familiaTipo) {
        this.id = id;
        this.descripcion = descripcion;
        this.familiaTipo = familiaTipo;
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

    public String getFamiliaTipo() {
        return familiaTipo;
    }

    public void setFamiliaTipo(String familiaTipo) {
        this.familiaTipo = familiaTipo;
    }
    
    public ArrayList<TipoProductoDTO> obtenerTiposProductoPorIdFamiliaBD(int id){
        ArrayList<TipoProductoDTO> listaTiposProducto = new ArrayList<TipoProductoDTO>();
        try{
            Class.forName(DRIVER);
            Connection conexion =  DriverManager.getConnection(URL,USUARIO,CLAVE);
            Statement declaracion = conexion.createStatement();
            ResultSet resultado = declaracion.executeQuery("SELECT TIPO_PRODUCTO.ID, TIPO_PRODUCTO.DESCRIPCION, TIPO_PRODUCTO.ID_FAMILIA ||' - '|| FAMILIA.DESCRIPCION FROM TIPO_PRODUCTO JOIN FAMILIA_PRODUCTO ON (TIPO_PRODUCTO.ID_FAMILIA = FAMILIA_PRODUCTO.ID) WHERE FAMILIA_PRODUCTO.ID = " + id);
            while (resultado.next()) {
                this.setId(resultado.getInt(1));
                this.setDescripcion(resultado.getString(2));
                listaTiposProducto.add(new TipoProductoDTO(this.getId(), this.getDescripcion(), this.getFamiliaTipo()));
            }  
            conexion.close();
            return listaTiposProducto;
        }catch(Exception e){
            System.out.println("Error : " + e);
            return listaTiposProducto;
        }
    }

    public ArrayList<TipoProductoDTO> obtenerTiposProductoBD(){
        ArrayList<TipoProductoDTO> listaTiposProducto = new ArrayList<TipoProductoDTO>();
        try{
            Class.forName(DRIVER);
            Connection conexion =  DriverManager.getConnection(URL,USUARIO,CLAVE);
            Statement declaracion = conexion.createStatement();
            ResultSet resultado = declaracion.executeQuery("SELECT TIPO_PRODUCTO.ID, TIPO_PRODUCTO.DESCRIPCION, TIPO_PRODUCTO.ID_FAMILIA ||' - '|| FAMILIA_PRODUCTO.DESCRIPCION FROM TIPO_PRODUCTO JOIN FAMILIA_PRODUCTO ON (TIPO_PRODUCTO.ID_FAMILIA = FAMILIA_PRODUCTO.ID)");
            while (resultado.next()) {
                this.setId(resultado.getInt(1));
                this.setDescripcion(resultado.getString(2));
                listaTiposProducto.add(new TipoProductoDTO(this.getId(), this.getDescripcion(), this.getFamiliaTipo()));
            }  
            conexion.close();
            return listaTiposProducto;
        }catch(Exception e){
            System.out.println("Error : " + e);
            return listaTiposProducto;
        }
    }    
    
    public String registrarServicioBD(){
        try{
            Class.forName(DRIVER);
            Connection conexion =  DriverManager.getConnection(URL,USUARIO,CLAVE);
            Statement declaracion = conexion.createStatement();
            int idFamilia = Integer.parseInt(getFamiliaTipo().split(" ")[0]);
            declaracion.executeUpdate("INSERT INTO TIPO_PRODUCTO(TIPO_PRODUCTO.ID, TIPO_PRODUCTO.DESCRIPCION, TIPO_PRODUCTO.ID_FAMILIA) VALUES (SEQ_ID_TIPO_PROD.NEXTVAL,'" + this.getDescripcion() + "'," + idFamilia + ")");
            conexion.close();
            return "Registro de tipo de producto en la base de datos fue exitoso.";
        }catch(Exception e){
            System.out.println("Error : " + e);
            return "No se pudo registrar tipo de producto en base de datos: " + e;
        }        
    }
}
