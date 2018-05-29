/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odontologicaescritorio.modelo;
import java.time.LocalDate;
import java.sql.*;
import java.time.*;
import java.util.ArrayList;
/**
 *
 * @author Marco Antonio
 */
public class FuncionarioDAO implements DatosConexion{
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
    private String tipoFuncionario;

    public FuncionarioDAO(){};

    public FuncionarioDAO(int rut, char dv, String p_nombre, String s_nombre, String p_apellido, String s_apellido, LocalDate f_nacimiento, char sexo, String direccion, int telefono, String email, String comuna, String ciudad, String tipoFuncionario) {
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
        this.tipoFuncionario = tipoFuncionario;
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

    public String getTipoFuncionario() {
        return tipoFuncionario;
    }

    public void setTipoFuncionario(String tipoFuncionario) {
        this.tipoFuncionario = tipoFuncionario;
    }
    
    public FuncionarioDTO obtenerFuncionarioBD(int rut){
        try{
            Class.forName(DRIVER);
            Connection conexion =  DriverManager.getConnection(URL,USUARIO,CLAVE);
            Statement declaracion = conexion.createStatement();
            ResultSet resultado = declaracion.executeQuery("SELECT FUNCIONARIO.RUT, FUNCIONARIO.DV, FUNCIONARIO.P_NOMBRE, FUNCIONARIO.S_NOMBRE, FUNCIONARIO.P_APELLIDO, FUNCIONARIO.S_APELLIDO, TO_CHAR(FUNCIONARIO.FECHA_NAC, 'YYYY-MM-DD'), FUNCIONARIO.SEXO, FUNCIONARIO.DIRECCION, FUNCIONARIO.TELEFONO, FUNCIONARIO.EMAIL, FUNCIONARIO.ID_COMUNA ||' - '|| COMUNA.NOMBRE, CIUDAD.ID ||' - '|| CIUDAD.NOMBRE, FUNCIONARIO.ID_TIPO || ' - ' || TIPO_FUNCIONARIO.DESCRIPCION FROM FUNCIONARIO JOIN COMUNA ON (FUNCIONARIO.ID_COMUNA = COMUNA.ID) JOIN CIUDAD ON (COMUNA.ID_CIUDAD = CIUDAD.ID) JOIN TIPO_FUNCIONARIO ON (TIPO_FUNCIONARIO.ID = FUNCIONARIO.ID_TIPO) WHERE FUNCIONARIO.RUT = " + rut);
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
            }
            conexion.close();
            System.out.println("FUNCIONARIO CARGADO EN DAO: " + this.getRut());
            return new FuncionarioDTO(this.getRut(), this.getDv(), this.getP_nombre(), this.getS_nombre(), this.getP_apellido(), this.getS_apellido(), this.getF_nacimiento(), this.getSexo(), this.getDireccion(), this.getTelefono(), this.getEmail(), this.getComuna(), this.getCiudad(), this.getTipoFuncionario());
        }catch(Exception e){
            System.out.println("Error en obtención de funcionario desde BD: " + e);
        }
        return new FuncionarioDTO(this.getRut(), this.getDv(), this.getP_nombre(), this.getS_nombre(), this.getP_apellido(), this.getS_apellido(), this.getF_nacimiento(), this.getSexo(), this.getDireccion(), this.getTelefono(), this.getEmail(), this.getComuna(), this.getCiudad(), this.getTipoFuncionario());
    }

    public ArrayList<FuncionarioDTO> obtenerTodosLosFuncionariosBD(){
        ArrayList<FuncionarioDTO> listaFuncionarios = new ArrayList<FuncionarioDTO>();
        try{
            Class.forName(DRIVER);
            Connection conexion =  DriverManager.getConnection(URL,USUARIO,CLAVE);
            Statement declaracion = conexion.createStatement();
            ResultSet resultado = declaracion.executeQuery("SELECT FUNCIONARIO.RUT, FUNCIONARIO.DV, FUNCIONARIO.P_NOMBRE, FUNCIONARIO.S_NOMBRE, FUNCIONARIO.P_APELLIDO, FUNCIONARIO.S_APELLIDO, TO_CHAR(FUNCIONARIO.FECHA_NAC, 'YYYY-MM-DD'), FUNCIONARIO.SEXO, FUNCIONARIO.DIRECCION, FUNCIONARIO.TELEFONO, FUNCIONARIO.EMAIL, FUNCIONARIO.ID_COMUNA ||' - '|| COMUNA.NOMBRE, CIUDAD.ID ||' - '|| CIUDAD.NOMBRE, FUNCIONARIO.ID_TIPO || ' - ' || TIPO_FUNCIONARIO.DESCRIPCION FROM FUNCIONARIO JOIN COMUNA ON (FUNCIONARIO.ID_COMUNA = COMUNA.ID) JOIN CIUDAD ON (COMUNA.ID_CIUDAD = CIUDAD.ID) JOIN TIPO_FUNCIONARIO ON (TIPO_FUNCIONARIO.ID = FUNCIONARIO.ID_TIPO)");
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
                this.setTipoFuncionario(resultado.getString(14));
                listaFuncionarios.add(new FuncionarioDTO(this.getRut(), this.getDv(), this.getP_nombre(), this.getS_nombre(), this.getP_apellido(), this.getS_apellido(), this.getF_nacimiento(), this.getSexo(), this.getDireccion(), this.getTelefono(), this.getEmail(), this.getComuna(), this.getCiudad(), this.getTipoFuncionario()));
            }  
            conexion.close();
            return listaFuncionarios;
        }catch(Exception e){
            System.out.println("Error : " + e);
            return listaFuncionarios;
        }  
    }    
    
    public ArrayList<FuncionarioDTO> obtenerFuncionariosPorTipoBD(int idTipo){
        ArrayList<FuncionarioDTO> listaFuncionarios = new ArrayList<FuncionarioDTO>();
        try{
            Class.forName(DRIVER);
            Connection conexion =  DriverManager.getConnection(URL,USUARIO,CLAVE);
            Statement declaracion = conexion.createStatement();
            ResultSet resultado = declaracion.executeQuery("SELECT FUNCIONARIO.RUT, FUNCIONARIO.DV, FUNCIONARIO.P_NOMBRE, FUNCIONARIO.S_NOMBRE, FUNCIONARIO.P_APELLIDO, FUNCIONARIO.S_APELLIDO, TO_CHAR(FUNCIONARIO.FECHA_NAC, 'YYYY-MM-DD'), FUNCIONARIO.SEXO, FUNCIONARIO.DIRECCION, FUNCIONARIO.TELEFONO, FUNCIONARIO.EMAIL, FUNCIONARIO.ID_COMUNA ||' - '|| COMUNA.NOMBRE, CIUDAD.ID ||' - '|| CIUDAD.NOMBRE, FUNCIONARIO.ID_TIPO || ' - ' || TIPO_FUNCIONARIO.DESCRIPCION FROM FUNCIONARIO JOIN COMUNA ON (FUNCIONARIO.ID_COMUNA = COMUNA.ID) JOIN CIUDAD ON (COMUNA.ID_CIUDAD = CIUDAD.ID) JOIN TIPO_FUNCIONARIO ON (TIPO_FUNCIONARIO.ID = FUNCIONARIO.ID_TIPO) WHERE FUNCIONARIO.ID_TIPO = " + idTipo);
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
                this.setTipoFuncionario(resultado.getString(14));
                listaFuncionarios.add(new FuncionarioDTO(this.getRut(), this.getDv(), this.getP_nombre(), this.getS_nombre(), this.getP_apellido(), this.getS_apellido(), this.getF_nacimiento(), this.getSexo(), this.getDireccion(), this.getTelefono(), this.getEmail(), this.getComuna(), this.getCiudad(), this.getTipoFuncionario()));
            }  
            conexion.close();
            return listaFuncionarios;
        }catch(Exception e){
            System.out.println("Error : " + e);
            return listaFuncionarios;
        }  
    }     
    
    public String registrarFuncionarioBD(){
        int idComuna = Integer.parseInt(this.getComuna().split(" ")[0]);
        int idTipoFuncionario = Integer.parseInt(this.getTipoFuncionario().split(" ")[0]);
        try{
            Class.forName(DRIVER);
            Connection conexion =  DriverManager.getConnection(URL,USUARIO,CLAVE);
            //Statement declaracion = conexion.createStatement();
            CallableStatement procedimientoAlmacenado = conexion.prepareCall("{CALL PRC_REG_FUNCYUSUARIO (" + this.getRut() + ",'"+ this.getDv() + "','" + this.getP_nombre() + "','" + this.getS_nombre() + "','" + this.getP_apellido() + "','" + this.getS_apellido() + "', TO_DATE('" + getF_nacimiento().toString() + "', 'YYYY-MM-DD'),'" + this.getSexo() + "','" + this.getDireccion() + "'," + this.getTelefono() + " ,'" + this.getEmail() + "'," + idComuna + "," + idTipoFuncionario + ")}");
            procedimientoAlmacenado.execute();
            //declaracion.executeUpdate("EXEC PRC_REG_CLIENTEYUSUARIO (" + this.getRut() + ",'"+ this.getDv() + "','" + this.getP_nombre() + "','" + this.getS_nombre() + "','" + this.getP_apellido() + "','" + this.getS_apellido() + "', TO_DATE('" + getF_nacimiento().toString() + "', 'YYYY-MM-DD'),'" + this.getSexo() + "','" + this.getDireccion() + "'," + this.getTelefono() + " ,'" + this.getEmail() + "'," + idComuna + " )");
            conexion.close();
            return "El registro del funcionario y su usuario en la base de datos fue exitoso.";
        }catch(Exception e){
            return "Error en registro de paciente: " + e;
        }
    }    
}
