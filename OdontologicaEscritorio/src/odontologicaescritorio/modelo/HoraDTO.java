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
public class HoraDTO{
    private int id;
    private LocalDate fecha;
    private LocalTime hora;
    private int rutFuncionario;
    private int rutCliente;

    public HoraDTO(int id, LocalDate fecha, LocalTime hora, int rutFuncionario, int rutCliente) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.rutFuncionario = rutFuncionario;
        this.rutCliente = rutCliente;
    }

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
}
