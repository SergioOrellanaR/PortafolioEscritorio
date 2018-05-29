/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odontologicaescritorio.modelo;
import java.time.LocalTime;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author Marco Antonio
 */
public class HoraDAO implements DatosConexion{
    private int id;
    private LocalDate fecha;
    private LocalTime hora;
    private int rutFuncionario;
    private int rutCliente;

    public HoraDAO(int id, LocalDate fecha, LocalTime hora, int rutFuncionario, int rutCliente) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.rutFuncionario = rutFuncionario;
        this.rutCliente = rutCliente;
    }
    
    public HoraDAO(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
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
    
    public ArrayList<HoraDTO> obtenerHorasPorFuncionarioBD(int rut, int mes, int ano){
        ArrayList<HoraDTO> listaHoras = new ArrayList<HoraDTO>();
        try{
            Class.forName(DRIVER);
            Connection conexion =  DriverManager.getConnection(URL,USUARIO,CLAVE);
            Statement declaracion = conexion.createStatement();
            ResultSet resultado = declaracion.executeQuery("SELECT ID, TO_CHAR(FECHA_HORA, 'YYYY-MM-DD'), TO_CHAR(FECHA_HORA, 'HH24:MI:SS'), RUT_FUNCIONARIO, RUT_CLIENTE FROM HORA WHERE RUT_FUNCIONARIO = " + rut + " AND TO_CHAR(FECHA_HORA, 'MM') = " + mes + " AND TO_CHAR(FECHA_HORA, 'YYYY') = " + ano);
            while (resultado.next()) {
                this.setId(resultado.getInt(1));
                this.setFecha(LocalDate.parse(resultado.getString(2)));
                this.setHora(LocalTime.parse(resultado.getString(3)));
                this.setRutFuncionario(resultado.getInt(4));
                this.setRutCliente(resultado.getInt(5));
                listaHoras.add(new HoraDTO(this.getId(), this.getFecha(), this.getHora(), this.getRutFuncionario(), this.getRutCliente()));
            }
            conexion.close();
            return listaHoras;
        }catch(Exception e){
            System.out.println("Error en obtención de horas desde BD: " + e);
        }
        return listaHoras;
    }

    public String registrarHoraBD(){
        String fechaFormateada = String.format("%d-%d-%d:%d:%d:00", this.getFecha().getYear(), this.getFecha().getMonthValue(), this.getFecha().getDayOfMonth(), this.getHora().getHour(), this.getHora().getMinute());
        try{
            Class.forName(DRIVER);
            Connection conexion =  DriverManager.getConnection(URL,USUARIO,CLAVE);
            Statement declaracion = conexion.createStatement();
            declaracion.executeUpdate("INSERT INTO HORA VALUES (SEQ_ID_HORA.NEXTVAL, TO_DATE('" + fechaFormateada + "', 'YYYY-MM-DD:HH24:MI:SS'), " + this.rutFuncionario + ", " + this.rutCliente + ")");
            conexion.close();
            return "Registro de hora en la base de datos fue exitoso.";
        }catch(Exception e){
            System.out.println("Error : " + e);
            return "No se pudo registrar hora en base de datos: " + e;
        }        
    }

    public String eliminarHoraBD(int idHora){
        try{
            Class.forName(DRIVER);
            Connection conexion =  DriverManager.getConnection(URL,USUARIO,CLAVE);
            Statement declaracion = conexion.createStatement();
            declaracion.executeUpdate("DELETE FROM HORA WHERE ID = " + idHora + "");
            conexion.close();
            return "Se eliminó la hora seleccionada.";
        }catch(Exception e){
            System.out.println("Error : " + e);
            return "No se pudo eliminar la hora seleccionada: " + e;
        }        
    }     
}