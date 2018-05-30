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
public class RubroDTO {
    private String idDescripcion;

    public RubroDTO(String idDescripcion) {
        this.idDescripcion = idDescripcion;
    }
    
    public String getIdDescripcion() {
        return idDescripcion;
    }

    public void setIdDescripcion(String idDescripcion) {
        this.idDescripcion = idDescripcion;
    }    
}
