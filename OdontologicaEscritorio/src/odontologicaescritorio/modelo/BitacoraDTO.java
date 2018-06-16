/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odontologicaescritorio.modelo;

import java.time.LocalDate;

/**
 *
 * @author Marco Antonio
 */
public class BitacoraDTO {
    private int id;
    private String descripcion;
    private LocalDate fecha;
    private int rutFuncionario;
    private int rutCliente;

    public BitacoraDTO(int id, String descripcion, LocalDate fecha, int rutFuncionario, int rutCliente) {
        this.id = id;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.rutFuncionario = rutFuncionario;
        this.rutCliente = rutCliente;
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
}
