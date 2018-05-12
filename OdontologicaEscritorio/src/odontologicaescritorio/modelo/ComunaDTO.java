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
public class ComunaDTO {
    String idNombre;
    String idNombreCiudad;

    public ComunaDTO(String idNombre, String idNombreCiudad) {
        this.idNombre = idNombre;
        this.idNombreCiudad = idNombreCiudad;
    }

    public String getIdNombre() {
        return idNombre;
    }

    public void setIdNombre(String idNombre) {
        this.idNombre = idNombre;
    }

    public String getIdNombreCiudad() {
        return idNombreCiudad;
    }

    public void setIdNombreCiudad(String idNombreCiudad) {
        this.idNombreCiudad = idNombreCiudad;
    }
    
}
