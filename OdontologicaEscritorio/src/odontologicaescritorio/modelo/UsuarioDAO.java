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
public class UsuarioDAO implements DatosConexion{
    int id;
    String nombre;
    String clave;
    int id_pregunta;
    String respuesta;
    ArrayList<Integer> permisos;
    int rut_persona;

    public UsuarioDAO(){};

    public UsuarioDAO(int id, String nombre, String clave, int id_pregunta, String respuesta, ArrayList<Integer> permisos, int rut_persona) {
        this.id = id;
        this.nombre = nombre;
        this.clave = clave;
        this.id_pregunta = id_pregunta;
        this.respuesta = respuesta;
        this.permisos = permisos;
        this.rut_persona = rut_persona;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getId_pregunta() {
        return id_pregunta;
    }

    public void setId_pregunta(int id_pregunta) {
        this.id_pregunta = id_pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public ArrayList<Integer> getPermisos() {
        return permisos;
    }

    public void setPermisos(ArrayList<Integer> permisos) {
        this.permisos = permisos;
    }

    public int getRut_persona() {
        return rut_persona;
    }

    public void setRut_persona(int rut_persona) {
        this.rut_persona = rut_persona;
    }
    
    public ArrayList<UsuarioDTO> obtenerTodosLosUsuariosBD(){
        ArrayList<UsuarioDTO> listaUsuarios = new ArrayList<UsuarioDTO>();
        try{
            Class.forName(DRIVER);
            Connection conexion =  DriverManager.getConnection(URL,USUARIO,CLAVE);
            Statement declaracion = conexion.createStatement();
            ResultSet resultado = declaracion.executeQuery("SELECT ID FROM USUARIO");
            while (resultado.next()) {
                listaUsuarios.add(obtenerUsuarioPorIdBD(resultado.getInt(1)));
            }
            conexion.close();
        }catch(Exception e){
            System.out.println("Error en obtención de usuario desde BD: " + e);
        }
        return listaUsuarios;
    }    
    
    public UsuarioDTO obtenerUsuarioPorIdBD(int id){
        try{
            Class.forName(DRIVER);
            Connection conexion =  DriverManager.getConnection(URL,USUARIO,CLAVE);
            Statement declaracion = conexion.createStatement();
            ResultSet resultado = declaracion.executeQuery("SELECT USUARIO.ID, USUARIO.NOMBRE, USUARIO.CLAVE, USUARIO.ID_PREGUNTA, USUARIO.RESP_PREGUNTA FROM USUARIO WHERE USUARIO.ID = " + id);
            while (resultado.next()) {
                this.setId(resultado.getInt(1));
                this.setNombre(resultado.getString(2));
                this.setClave(resultado.getString(3));
                this.setId_pregunta(resultado.getInt(4));
                this.setRespuesta(resultado.getString(5));
                this.setRut_persona(0);
            }
            //Obtener permisos
            resultado = declaracion.executeQuery("SELECT ID_PERMISO FROM PERMISO_USUARIO WHERE ID_USUARIO = " + id);
            ArrayList<Integer> permisosEncontrados = new ArrayList<Integer>();
            while (resultado.next()) {
                permisosEncontrados.add(resultado.getInt(1));
            }
            this.setPermisos(permisosEncontrados);
            conexion.close();
        }catch(Exception e){
            System.out.println("Error en obtención de usuario desde BD: " + e);
        }
        return new UsuarioDTO(this.getId(), this.getNombre(), this.getClave(), this.getId_pregunta(), this.getRespuesta(), this.getPermisos(), this.getRut_persona());
    }    
    
    public UsuarioDTO obtenerUsuarioPorNombreClaveBD(String nombre, String clave){
        try{
            Class.forName(DRIVER);
            Connection conexion =  DriverManager.getConnection(URL,USUARIO,CLAVE);
            Statement declaracion = conexion.createStatement();
            ResultSet resultado = declaracion.executeQuery("SELECT USUARIO.ID, USUARIO.NOMBRE, USUARIO.CLAVE, USUARIO.ID_PREGUNTA, USUARIO.RESP_PREGUNTA, FUNCIONARIO.RUT FROM USUARIO JOIN FUNCIONARIO ON (FUNCIONARIO.ID_USUARIO = USUARIO.ID) WHERE USUARIO.NOMBRE = '" + nombre + "' AND USUARIO.CLAVE = '" + clave + "'");
            while (resultado.next()) {
                this.setId(resultado.getInt(1));
                this.setNombre(resultado.getString(2));
                this.setClave(resultado.getString(3));
                this.setId_pregunta(resultado.getInt(4));
                this.setRespuesta(resultado.getString(5));
                this.setRut_persona(Integer.parseInt(resultado.getString(6)));
            }
            //Obtener permisos
            resultado = declaracion.executeQuery("SELECT ID_PERMISO FROM PERMISO_USUARIO WHERE ID_USUARIO = " + this.getId());
            ArrayList<Integer> permisosEncontrados = new ArrayList<Integer>();
            while (resultado.next()) {
                permisosEncontrados.add(resultado.getInt(1));
            }
            this.setPermisos(permisosEncontrados);
            conexion.close();
        }catch(Exception e){
            System.out.println("Error en obtención de usuario desde BD: " + e);
        }
        return new UsuarioDTO(this.getId(), this.getNombre(), this.getClave(), this.getId_pregunta(), this.getRespuesta(), this.getPermisos(), this.getRut_persona());
    }
    
    public int validarUsuarioBD(String nombre, String clave){
        int validacion = 0;
        try{
            Class.forName(DRIVER);
            Connection conexion =  DriverManager.getConnection(URL,USUARIO,CLAVE);
            Statement declaracion = conexion.createStatement();
            ResultSet resultado = declaracion.executeQuery("SELECT COUNT(ID) FROM USUARIO WHERE NOMBRE = '" + nombre + "' AND CLAVE = '" + clave + "'");
            while (resultado.next()) {
                validacion = resultado.getInt(1);
            }
            conexion.close();
        }catch(Exception e){
            System.out.println("Error en obtención de usuario desde BD: " + e);
        }
        return validacion;
    }
    
    public String modificarPermisos(int id, int administrador, int odontologo, int recepcionista, int bodega, int cliente){
        try{
            Class.forName(DRIVER);
            Connection conexion =  DriverManager.getConnection(URL,USUARIO,CLAVE);
            CallableStatement procedimientoAlmacenado = conexion.prepareCall("{CALL PRC_CONF_PERMISOS (" + id + "," + administrador + "," + odontologo + "," + recepcionista + "," + bodega + "," + cliente + ")}");
            procedimientoAlmacenado.execute();
            conexion.close();
            return "Se han modificado correctamente los permisos del usuario";
        }catch(Exception e){
            return "Error en modificación de permisos de usuario: " + e;
        }        
    }
    
}
