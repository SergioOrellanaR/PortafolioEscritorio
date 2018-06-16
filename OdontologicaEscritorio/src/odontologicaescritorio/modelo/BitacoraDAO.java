/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odontologicaescritorio.modelo;

import java.time.LocalDate;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Marco Antonio
 */
public class BitacoraDAO implements DatosConexion{
    private int id;
    private String descripcion;
    private LocalDate fecha;
    private int rutFuncionario;
    private int rutCliente;

    public BitacoraDAO(int id, String descripcion, LocalDate fecha, int rutFuncionario, int rutCliente) {
        this.id = id;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.rutFuncionario = rutFuncionario;
        this.rutCliente = rutCliente;
    }

    public BitacoraDAO() {
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

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getRutFuncionario() {
        return rutFuncionario;
    }

    public void setRutFuncionario(int rutFuncionario) {
        this.rutFuncionario = rutFuncionario;
    }

    public int getRutCliente() {
        return rutCliente;
    }

    public void setRutCliente(int rutCliente) {
        this.rutCliente = rutCliente;
    }
    
    public ArrayList<BitacoraDTO> obtenerBitacorasPorRutClienteBD(int rutConsulta){
        ArrayList<BitacoraDTO> listaBitacoras = new ArrayList<BitacoraDTO>();
        try{
            Class.forName(DRIVER);
            Connection conexion =  DriverManager.getConnection(URL,USUARIO,CLAVE);
            Statement declaracion = conexion.createStatement();
            ResultSet resultado = declaracion.executeQuery("SELECT ID, DESCRIPCION, TO_CHAR(FECHA, 'YYYY-MM-DD'), RUT_FUNCIONARIO, RUT_CLIENTE FROM HIST_ATENCION WHERE RUT_CLIENTE = " + rutConsulta);
            while (resultado.next()) {
                this.setId(resultado.getInt(1));
                this.setDescripcion(resultado.getString(2));
                this.setFecha(LocalDate.parse(resultado.getString(3)));
                this.setRutFuncionario(resultado.getInt(4));
                this.setRutCliente(resultado.getInt(5));
                listaBitacoras.add(new BitacoraDTO(this.getId(), this.getDescripcion(), this.getFecha(), this.getRutFuncionario(), this.getRutCliente()));
            }  
            conexion.close();
            return listaBitacoras;
        }catch(Exception e){
            System.out.println("Error : " + e);
            return listaBitacoras;
        }
    }
    
    public String registrarBitacoraBD(){
        String fechaFormateada = String.format("%d-%d-%d", this.getFecha().getYear(), this.getFecha().getMonthValue(), this.getFecha().getDayOfMonth());
        try{
            Class.forName(DRIVER);
            Connection conexion =  DriverManager.getConnection(URL,USUARIO,CLAVE);
            Statement declaracion = conexion.createStatement();
            declaracion.executeUpdate("INSERT INTO HIST_ATENCION (ID, DESCRIPCION, FECHA, RUT_FUNCIONARIO, RUT_CLIENTE) VALUES (SEQ_ID_ATENCION.NEXTVAL,'" + this.getDescripcion() + "', TO_DATE(" + fechaFormateada + ",'YYYY-MM-DD')," + this.getRutFuncionario() + "," + this.getRutCliente() + ")");
            conexion.close();
            return "Registro de bitacora en la base de datos, fue exitoso.";
        }catch(Exception e){
            System.out.println("Error : " + e);
            return "No se pudo registrar bitacora en la base de datos: " + e;
        }        
    }    
}
