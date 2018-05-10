/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odontologicaescritorio.modelo;

import java.util.ArrayList;

/**
 *
 * @author Marco Antonio
 */
public class UsuarioDTO {
    int id;
    String nombre;
    String clave;
    int id_pregunta;
    String respuesta;
    ArrayList<Integer> permisos;
    int rut_persona;

    public UsuarioDTO(int id, String nombre, String clave, int id_pregunta, String respuesta, ArrayList<Integer> permisos, int rut_persona) {
        this.id = id;
        this.nombre = nombre;
        this.clave = clave;
        this.id_pregunta = id_pregunta;
        this.respuesta = respuesta;
        this.permisos = permisos;
        this.rut_persona = rut_persona;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getId_pregunta() {
        return id_pregunta;
    }

    public void setId_pregunta(int id_pregunta) {
        this.id_pregunta = id_pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public ArrayList<Integer> getPermisos() {
        return permisos;
    }

    public void setPermisos(ArrayList<Integer> permisos) {
        this.permisos = permisos;
    }

    public int getRut_persona() {
        return rut_persona;
    }

    public void setRut_persona(int rut_persona) {
        this.rut_persona = rut_persona;
    }
    
    
}
