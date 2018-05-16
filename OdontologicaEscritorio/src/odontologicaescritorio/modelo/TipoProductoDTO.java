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
public class TipoProductoDTO {
    int id;
    String descripcion;
    String familiaTipo;
    
    public TipoProductoDTO(){}

    public TipoProductoDTO(int id, String descripcion, String familiaTipo) {
        this.id = id;
        this.descripcion = descripcion;
        this.familiaTipo = familiaTipo;
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

    public String getFamiliaTipo() {
        return familiaTipo;
    }

    public void setFamiliaTipo(String familiaTipo) {
        this.familiaTipo = familiaTipo;
    }
    
    
}
