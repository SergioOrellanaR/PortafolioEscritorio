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
public class PedidoBodegaDTO {
    private int id;
    private String descripcion;
    private LocalDate fecha;
    private String rutEmisor;
    private int estado;

    public PedidoBodegaDTO() {
    }

    public PedidoBodegaDTO(int id, String descripcion, LocalDate fecha, String rutEmisor, int estado) {
        this.id = id;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.rutEmisor = rutEmisor;
        this.estado = estado;
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

    public String getRutEmisor() {
        return rutEmisor;
    }

    public void setRutEmisor(String rutEmisor) {
        this.rutEmisor = rutEmisor;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
