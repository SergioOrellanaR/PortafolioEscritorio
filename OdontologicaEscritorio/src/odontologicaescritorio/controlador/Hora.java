/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odontologicaescritorio.controlador;
import java.util.ArrayList;
import odontologicaescritorio.modelo.*;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Marco Antonio
 */
public class Hora {
    public ArrayList<DiaDTO> obtenerDiasPorFuncionario(int rut){
        return new DiaDAO().obtenerDiasPorFuncionarioBD(rut);
    }

    public ArrayList<HoraDTO> obtenerHorasPorFuncionario(int rut, int mes, int ano){
        return new HoraDAO().obtenerHorasPorFuncionarioBD(rut, mes, ano);
    }
    
    public LocalTime[] obtenerMaximoLargoJornada(int mes, int ano){
        return new DiaDAO().obtenerMaximoLargoJornadaBD(mes, ano);
    }
    
    public double obtenerMaximoTotalHorasJornadaBD(int mes, int ano){
        return new DiaDAO().obtenerMaximoTotalHorasJornadaBD(mes, ano);
    }
    
    
}
