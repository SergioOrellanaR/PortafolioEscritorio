/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odontologicaescritorio.modelo;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Duration;
import java.util.ArrayList;

/**
 *
 * @author Marco Antonio
 */
public class DiaDAO implements DatosConexion{
    private LocalDate dia;
    private LocalTime horaInicio;
    private LocalTime horaTermino;
    private int rutFuncionario;

    public DiaDAO() {}
    
    public DiaDAO(LocalDate dia, LocalTime horaInicio, LocalTime horaTermino, int rutFuncionario) {
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaTermino = horaTermino;
        this.rutFuncionario = rutFuncionario;
    }

    public LocalDate getDia() {
        return dia;
    }

    public void setDia(LocalDate dia) {
        this.dia = dia;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraTermino() {
        return horaTermino;
    }

    public void setHoraTermino(LocalTime horaTermino) {
        this.horaTermino = horaTermino;
    }

    public int getRutFuncionario() {
        return rutFuncionario;
    }

    public void setRutFuncionario(int rutFuncionario) {
        this.rutFuncionario = rutFuncionario;
    }
    
    public ArrayList<DiaDTO> obtenerDiasPorFuncionarioBD(int rut){
        ArrayList<DiaDTO> listaDias = new ArrayList<DiaDTO>();
        try{
            Class.forName(DRIVER);
            Connection conexion =  DriverManager.getConnection(URL,USUARIO,CLAVE);
            Statement declaracion = conexion.createStatement();
            ResultSet resultado = declaracion.executeQuery("SELECT TO_CHAR(DIA, 'YYYY-MM-DD'), TO_CHAR(HORA_INICIO, 'HH24:MI'), TO_CHAR(HORA_TERMINO, 'HH24:MI'), RUT_FUNCIONARIO FROM DIA WHERE RUT_FUNCIONARIO = " + rut);
            while (resultado.next()) {
                this.setDia(LocalDate.parse(resultado.getString(1)));
                this.setHoraInicio(LocalTime.parse(resultado.getString(2)));
                this.setHoraTermino(LocalTime.parse(resultado.getString(3)));
                this.setRutFuncionario(resultado.getInt(4));
                listaDias.add(new DiaDTO(this.getDia(), this.getHoraInicio(), this.getHoraTermino(), this.getRutFuncionario()));
            }
            conexion.close();
            return listaDias;
        }catch(Exception e){
            System.out.println("Error en obtención de horas desde BD: " + e);
        }
        return listaDias;
    }    
    
    //El resultado de este método es un arrego de dos horas, la de inicio y la de término.
    public LocalTime[] obtenerMaximoLargoJornadaBD(int mes, int ano){
        LocalTime inicioYTermino[] = new LocalTime[2];
        try{
            
            Class.forName(DRIVER);
            Connection conexion =  DriverManager.getConnection(URL,USUARIO,CLAVE);
            Statement declaracion = conexion.createStatement();
            ResultSet resultado = declaracion.executeQuery("SELECT TO_CHAR(MIN(HORA_INICIO), 'HH24:MI'), TO_CHAR(MAX(HORA_TERMINO), 'HH24:MI') FROM DIA WHERE TO_CHAR(DIA, 'MM') = " + mes + " AND TO_CHAR(DIA, 'YYYY') = " + ano + "");
            while (resultado.next()) {
                inicioYTermino[0] = LocalTime.parse(resultado.getString(1));
                inicioYTermino[1] = LocalTime.parse(resultado.getString(2));
            }
            conexion.close();
            return inicioYTermino;
        }catch(Exception e){
            System.out.println("Error en obtención de inicio y termino de jornada desde BD: " + e);
        }
        return inicioYTermino;
    } 
    
    //Obtiene la duración de la jornada, en horas, de un mes.
    public double obtenerMaximoTotalHorasJornadaBD(int mes, int ano){
        double total = 0;
        try{
            Class.forName(DRIVER);
            Connection conexion =  DriverManager.getConnection(URL,USUARIO,CLAVE);
            Statement declaracion = conexion.createStatement();
            ResultSet resultado = declaracion.executeQuery("SELECT MAX(HORA_TERMINO - HORA_INICIO) * 24 FROM DIA WHERE TO_CHAR(DIA, 'MM') = " + mes + " AND TO_CHAR(DIA, 'YYYY') = " + ano + "");
            while (resultado.next()) {
                total = resultado.getDouble(1);
            }
            conexion.close();
            return total;
        }catch(Exception e){
            System.out.println("Error en obtención de total de horas de jornada desde BD: " + e);
        }
        return total;  
    }
}
