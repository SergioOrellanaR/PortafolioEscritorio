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
public class ProveedorDTO {
    private int id;
    private String nombreEmpresa;
    private int rutEmpresa;
    private char dvEmpresa;
    private int telefono;
    private String email;
    private String nombreRepresentante;
    private int rutRepresentante;
    private char dvRepresentante;
    private String idRubro;

    public ProveedorDTO() {
    }

    public ProveedorDTO(int id, String nombreEmpresa, int rutEmpresa, char dvEmpresa, int telefono, String email, String nombreRepresentante, int rutRepresentante, char dvRepresentante, String idRubro) {
        this.id = id;
        this.nombreEmpresa = nombreEmpresa;
        this.rutEmpresa = rutEmpresa;
        this.dvEmpresa = dvEmpresa;
        this.telefono = telefono;
        this.email = email;
        this.nombreRepresentante = nombreRepresentante;
        this.rutRepresentante = rutRepresentante;
        this.dvRepresentante = dvRepresentante;
        this.idRubro = idRubro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public int getRutEmpresa() {
        return rutEmpresa;
    }

    public void setRutEmpresa(int rutEmpresa) {
        this.rutEmpresa = rutEmpresa;
    }

    public char getDvEmpresa() {
        return dvEmpresa;
    }

    public void setDvEmpresa(char dvEmpresa) {
        this.dvEmpresa = dvEmpresa;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombreRepresentante() {
        return nombreRepresentante;
    }

    public void setNombreRepresentante(String nombreRepresentante) {
        this.nombreRepresentante = nombreRepresentante;
    }

    public int getRutRepresentante() {
        return rutRepresentante;
    }

    public void setRutRepresentante(int rutRepresentante) {
        this.rutRepresentante = rutRepresentante;
    }

    public char getDvRepresentante() {
        return dvRepresentante;
    }

    public void setDvRepresentante(char dvRepresentante) {
        this.dvRepresentante = dvRepresentante;
    }

    public String getIdRubro() {
        return idRubro;
    }

    public void setIdRubro(String idRubro) {
        this.idRubro = idRubro;
    }
        
}
