/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odontologicaescritorio.modelo;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Marco Antonio
 */
public class DiaDTO {
    private LocalDate dia;
    private LocalTime horaInicio;
    private LocalTime horaTermino;
    private int rutFuncionario;

    public DiaDTO() {}
    
    public DiaDTO(LocalDate dia, LocalTime horaInicio, LocalTime horaTermino, int rutFuncionario) {
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
}
