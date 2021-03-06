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
public class PacienteDAO implements DatosConexion{
    private int rut;
    private char dv;
    private String p_nombre;
    private String s_nombre;
    private String p_apellido;
    private String s_apellido;
    private LocalDate f_nacimiento;
    private char sexo;
    private String direccion;
    private int telefono;
    private String email;
    private String comuna;
    private String ciudad;
    private int vulnerable;

    public PacienteDAO(){};

    public PacienteDAO(int rut, char dv, String p_nombre, String s_nombre, String p_apellido, String s_apellido, LocalDate f_nacimiento, char sexo, String direccion, int telefono, String email, String comuna, String ciudad, int vulnerable) {
        this.rut = rut;
        this.dv = dv;
        this.p_nombre = p_nombre;
        this.s_nombre = s_nombre;
        this.p_apellido = p_apellido;
        this.s_apellido = s_apellido;
        this.f_nacimiento = f_nacimiento;
        this.sexo = sexo;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.comuna = comuna;
        this.ciudad = ciudad;
        this.vulnerable = vulnerable;
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public char getDv() {
        return dv;
    }

    public void setDv(char dv) {
        this.dv = dv;
    }

    public String getP_nombre() {
        return p_nombre;
    }

    public void setP_nombre(String p_nombre) {
        this.p_nombre = p_nombre;
    }

    public String getS_nombre() {
        return s_nombre;
    }

    public void setS_nombre(String s_nombre) {
        this.s_nombre = s_nombre;
    }

    public String getP_apellido() {
        return p_apellido;
    }

    public void setP_apellido(String p_apellido) {
        this.p_apellido = p_apellido;
    }

    public String getS_apellido() {
        return s_apellido;
    }

    public void setS_apellido(String s_apellido) {
        this.s_apellido = s_apellido;
    }

    public LocalDate getF_nacimiento() {
        return f_nacimiento;
    }

    public void setF_nacimiento(LocalDate f_nacimiento) {
        this.f_nacimiento = f_nacimiento;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getVulnerable() {
        return vulnerable;
    }

    public void setVulnerable(int vulnerable) {
        this.vulnerable = vulnerable;
    }
    
    public ArrayList<PacienteDTO> obtenerTodosLosPacientesBD(){
        ArrayList<PacienteDTO> listaPacientes = new ArrayList<PacienteDTO>();
        try{
            Class.forName(DRIVER);
            Connection conexion =  DriverManager.getConnection(URL,USUARIO,CLAVE);
            Statement declaracion = conexion.createStatement();
            ResultSet resultado = declaracion.executeQuery("SELECT CLIENTE.RUT, CLIENTE.DV, CLIENTE.P_NOMBRE, CLIENTE.S_NOMBRE, CLIENTE.P_APELLIDO, CLIENTE.S_APELLIDO, TO_CHAR(CLIENTE.FECHA_NAC, 'YYYY-MM-DD'), CLIENTE.SEXO, CLIENTE.DIRECCION, CLIENTE.TELEFONO, CLIENTE.EMAIL, CLIENTE.ID_COMUNA ||' - '|| COMUNA.NOMBRE, CIUDAD.ID ||' - '|| CIUDAD.NOMBRE, CLIENTE.VULNERABLE FROM CLIENTE JOIN COMUNA ON (CLIENTE.ID_COMUNA = COMUNA.ID) JOIN CIUDAD ON (COMUNA.ID_CIUDAD = CIUDAD.ID)");
            while (resultado.next()) {
                this.setRut(resultado.getInt(1));
                this.setDv(resultado.getString(2).charAt(0));
                this.setP_nombre(resultado.getString(3));
                this.setS_nombre(resultado.getString(4));
                this.setP_apellido(resultado.getString(5));
                this.setS_apellido(resultado.getString(6));
                this.setF_nacimiento(LocalDate.parse(resultado.getString(7)));
                this.setSexo(resultado.getString(8).charAt(0));
                this.setDireccion(resultado.getString(9));
                this.setTelefono(resultado.getInt(10));
                this.setEmail(resultado.getString(11));
                this.setComuna(resultado.getString(12));
                this.setCiudad(resultado.getString(13));
                this.setVulnerable(resultado.getInt(14));
                listaPacientes.add(new PacienteDTO(this.getRut(), this.getDv(), this.getP_nombre(), this.getS_nombre(), this.getP_apellido(), this.getS_apellido(), this.getF_nacimiento(), this.getSexo(), this.getDireccion(), this.getTelefono(), this.getEmail(), this.getComuna(), this.getCiudad(), this.getVulnerable()));
            }  
            conexion.close();
            return listaPacientes;
        }catch(Exception e){
            System.out.println("Error : " + e);
            return listaPacientes;
        }
    }
    
    public String registrarPacienteBD(String nombreUsuario){
        int idComuna = Integer.parseInt(this.getComuna().split(" ")[0]);
        try{
            Class.forName(DRIVER);
            Connection conexion =  DriverManager.getConnection(URL,USUARIO,CLAVE);
            //Statement declaracion = conexion.createStatement();
            CallableStatement procedimientoAlmacenado = conexion.prepareCall("{CALL PRC_REG_CLIENTEYUSUARIO (" + this.getRut() + ",'"+ this.getDv() + "','" + this.getP_nombre() + "','" + this.getS_nombre() + "','" + this.getP_apellido() + "','" + this.getS_apellido() + "', TO_DATE('" + getF_nacimiento().toString() + "', 'YYYY-MM-DD'),'" + this.getSexo() + "','" + this.getDireccion() + "'," + this.getTelefono() + " ,'" + this.getEmail() + "'," + idComuna + ",'" + nombreUsuario + "')}");
            procedimientoAlmacenado.execute();
            //declaracion.executeUpdate("EXEC PRC_REG_CLIENTEYUSUARIO (" + this.getRut() + ",'"+ this.getDv() + "','" + this.getP_nombre() + "','" + this.getS_nombre() + "','" + this.getP_apellido() + "','" + this.getS_apellido() + "', TO_DATE('" + getF_nacimiento().toString() + "', 'YYYY-MM-DD'),'" + this.getSexo() + "','" + this.getDireccion() + "'," + this.getTelefono() + " ,'" + this.getEmail() + "'," + idComuna + " )");
            conexion.close();
            System.out.println("PRC_REG_CLIENTEYUSUARIO (" + this.getRut() + ",'"+ this.getDv() + "','" + this.getP_nombre() + "','" + this.getS_nombre() + "','" + this.getP_apellido() + "','" + this.getS_apellido() + "', TO_DATE('" + getF_nacimiento().toString() + "', 'YYYY-MM-DD'),'" + this.getSexo() + "','" + this.getDireccion() + "'," + this.getTelefono() + " ,'" + this.getEmail() + "'," + idComuna + ",'" + nombreUsuario + "')");
            return "El registro del paciente y su usuario en la base de datos fue exitoso.";
        }catch(Exception e){
            return "Error en registro de paciente: " + e;
        }
    }    
    
    public String actualizarVulnerabilidadBD(int rut, int porcentaje){
        try{
            Class.forName(DRIVER);
            Connection conexion =  DriverManager.getConnection(URL,USUARIO,CLAVE);
            Statement declaracion = conexion.createStatement();
            declaracion.executeUpdate("UPDATE CLIENTE SET VULNERABLE = " + porcentaje + " WHERE CLIENTE.RUT = " + rut);
            conexion.close();
            return "Se ha actualizado registro de vulnerabilidad del paciente " + rut + " a un índice de " + porcentaje + "%";
        }catch(Exception e){
            return "Error la actualización de vulnerabilidad del paciente: " + e;
        }
    }     
    
    public int buscarPacienteBD(int rut){
        int contador = 0;
        try{
            Class.forName(DRIVER);
            Connection conexion =  DriverManager.getConnection(URL,USUARIO,CLAVE);
            Statement declaracion = conexion.createStatement();
            ResultSet resultado = declaracion.executeQuery("SELECT COUNT(CLIENTE.RUT) FROM CLIENTE WHERE CLIENTE.RUT = " + rut);
            while (resultado.next()) {
                contador = resultado.getInt(1);
            }  
            conexion.close();
            return contador;
        }catch(Exception e){
            System.out.println("Error : " + e);
            return contador;
        }
    }

    public PacienteDTO obtenerPacienteBD(int rut){
        try{
            Class.forName(DRIVER);
            Connection conexion =  DriverManager.getConnection(URL,USUARIO,CLAVE);
            Statement declaracion = conexion.createStatement();
            ResultSet resultado = declaracion.executeQuery("SELECT CLIENTE.RUT, CLIENTE.DV, CLIENTE.P_NOMBRE, CLIENTE.S_NOMBRE, CLIENTE.P_APELLIDO, CLIENTE.S_APELLIDO, TO_CHAR(CLIENTE.FECHA_NAC, 'YYYY-MM-DD'), CLIENTE.SEXO, CLIENTE.DIRECCION, CLIENTE.TELEFONO, CLIENTE.EMAIL, CLIENTE.ID_COMUNA ||' - '|| COMUNA.NOMBRE, CIUDAD.ID ||' - '|| CIUDAD.NOMBRE, CLIENTE.VULNERABLE FROM CLIENTE JOIN COMUNA ON (CLIENTE.ID_COMUNA = COMUNA.ID) JOIN CIUDAD ON (COMUNA.ID_CIUDAD = CIUDAD.ID) WHERE CLIENTE.RUT = " + rut);
            while (resultado.next()) {
                this.setRut(resultado.getInt(1));
                this.setDv(resultado.getString(2).charAt(0));
                this.setP_nombre(resultado.getString(3));
                this.setS_nombre(resultado.getString(4));
                this.setP_apellido(resultado.getString(5));
                this.setS_apellido(resultado.getString(6));
                this.setF_nacimiento(LocalDate.parse(resultado.getString(7)));
                this.setSexo(resultado.getString(8).charAt(0));
                this.setDireccion(resultado.getString(9));
                this.setTelefono(resultado.getInt(10));
                this.setEmail(resultado.getString(11));
                this.setComuna(resultado.getString(12));
                this.setCiudad(resultado.getString(13));
                this.setVulnerable(resultado.getInt(14));
            }  
            conexion.close();
            return new PacienteDTO(this.getRut(), this.getDv(), this.getP_nombre(), this.getS_nombre(), this.getP_apellido(), this.getS_apellido(), this.getF_nacimiento(), this.getSexo(), this.getDireccion(), this.getTelefono(), this.getEmail(), this.getComuna(), this.getCiudad(), this.getVulnerable());
        }catch(Exception e){
            System.out.println("Error : " + e);
            return new PacienteDTO(this.getRut(), this.getDv(), this.getP_nombre(), this.getS_nombre(), this.getP_apellido(), this.getS_apellido(), this.getF_nacimiento(), this.getSexo(), this.getDireccion(), this.getTelefono(), this.getEmail(), this.getComuna(), this.getCiudad(), this.getVulnerable());
        }
    }    
}
