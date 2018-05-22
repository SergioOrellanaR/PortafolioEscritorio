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
public class ProveedorDAO implements DatosConexion{
    private int id;
    private String nombreEmpresa;
    private int rutEmpresa;
    private char dvEmpresa;
    private int telefono;
    private String email;
    private String nombreRepresentante;
    private int rutRepresentante;
    private char dvRepresentante;
    private String idRubro;

    public ProveedorDAO() {
    }

    public ProveedorDAO(int id, String nombreEmpresa, int rutEmpresa, char dvEmpresa, int telefono, String email, String nombreRepresentante, int rutRepresentante, char dvRepresentante, String idRubro) {
        this.id = id;
        this.nombreEmpresa = nombreEmpresa;
        this.rutEmpresa = rutEmpresa;
        this.dvEmpresa = dvEmpresa;
        this.telefono = telefono;
        this.email = email;
        this.nombreRepresentante = nombreRepresentante;
        this.rutRepresentante = rutRepresentante;
        this.dvRepresentante = dvRepresentante;
        this.idRubro = idRubro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public int getRutEmpresa() {
        return rutEmpresa;
    }

    public void setRutEmpresa(int rutEmpresa) {
        this.rutEmpresa = rutEmpresa;
    }

    public char getDvEmpresa() {
        return dvEmpresa;
    }

    public void setDvEmpresa(char dvEmpresa) {
        this.dvEmpresa = dvEmpresa;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombreRepresentante() {
        return nombreRepresentante;
    }

    public void setNombreRepresentante(String nombreRepresentante) {
        this.nombreRepresentante = nombreRepresentante;
    }

    public int getRutRepresentante() {
        return rutRepresentante;
    }

    public void setRutRepresentante(int rutRepresentante) {
        this.rutRepresentante = rutRepresentante;
    }

    public char getDvRepresentante() {
        return dvRepresentante;
    }

    public void setDvRepresentante(char dvRepresentante) {
        this.dvRepresentante = dvRepresentante;
    }

    public String getIdRubro() {
        return idRubro;
    }

    public void setIdRubro(String idRubro) {
        this.idRubro = idRubro;
    }

    public ArrayList<ProveedorDTO> obtenerTodasLasFamiliasProductoBD(){
        ArrayList<ProveedorDTO> listaProveedores = new ArrayList<ProveedorDTO>();
        try{
            Class.forName(DRIVER);
            Connection conexion =  DriverManager.getConnection(URL,USUARIO,CLAVE);
            Statement declaracion = conexion.createStatement();
            ResultSet resultado = declaracion.executeQuery("SELECT PROVEEDOR.ID, PROVEEDOR.NOMBRE_EMPRESA, PROVEEDOR.RUT_EMPRESA, PROVEEDOR.DV_EMPRESA, PROVEEDOR.TELEFONO, PROVEEDOR.EMAIL, NOMBRE_REPRESENTANTE, PROVEEDOR.RUT_REPRESENTANTE, PROVEEDOR.DV_REPRESENTANTE, PROVEEDOR.ID_RUBRO|| ' - '||RUBRO_PROVEEDOR.DESCRIPCION FROM PROVEEDOR JOIN RUBRO_PROVEEDOR ON (RUBRO_PROVEEDOR.ID = PROVEEDOR.ID_RUBRO)");
            while (resultado.next()) {
                this.setId(resultado.getInt(1));
                this.setNombreEmpresa(resultado.getString(2));
                this.setRutEmpresa(resultado.getInt(3));
                this.setDvEmpresa(resultado.getString(4).charAt(0));
                this.setTelefono(resultado.getInt(5));
                this.setEmail(resultado.getString(6));
                this.setNombreRepresentante(resultado.getString(7));
                this.setRutRepresentante(resultado.getInt(8));
                this.setDvRepresentante(resultado.getString(9).charAt(0));                
            }  
            conexion.close();
            return listaProveedores;
        }catch(Exception e){
            System.out.println("Error : " + e);
            return listaProveedores;
        }
    }
    
}
