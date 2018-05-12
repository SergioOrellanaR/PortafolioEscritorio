/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odontologicaescritorio.modelo;

/**
 *
 * @author Marco Antonio
 */
public class ServicioDTO {
    int Id;
    String descripcion;
    int precio;

    public ServicioDTO(int Id, String descripcion, int precio) {
        this.Id = Id;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
        
}
