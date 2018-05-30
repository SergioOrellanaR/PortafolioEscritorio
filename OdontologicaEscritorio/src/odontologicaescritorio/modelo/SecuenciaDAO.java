/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odontologicaescritorio.modelo;

import java.sql.*;

/**
 *
 * @author Marco Antonio
 */
public class SecuenciaDAO implements DatosConexion{
    private String nombreTabla;
    private String nombreColumna;
    public SecuenciaDAO(String nombreTabla, String nombreColumna) {
        this.nombreTabla = nombreTabla;
        this.nombreColumna = nombreColumna;
    }

    public String getNombreTabla() {
        return nombreTabla;
    }

    public void setNombreTabla(String nombreTabla) {
        this.nombreTabla = nombreTabla;
    }

    public String getNombreColumna() {
        return nombreColumna;
    }

    public void setNombreColumna(String nombreColumna) {
        this.nombreColumna = nombreColumna;
    }
    
    public int ultimoValorSecuenciaBD(){
        int ultimoValor = -1;
        try{
            Class.forName(DRIVER);
            Connection conexion =  DriverManager.getConnection(URL,USUARIO,CLAVE);
            Statement declaracion = conexion.createStatement();
            ResultSet resultado = declaracion.executeQuery("SELECT MAX(" + this.getNombreColumna() + ") FROM " + this.getNombreTabla());
            while (resultado.next()) {
                ultimoValor = resultado.getInt(1);
            }  
            conexion.close();
            return ultimoValor;
        }catch(Exception e){
            System.out.println("Error : " + e);
            return ultimoValor;
        }
    }    
}
