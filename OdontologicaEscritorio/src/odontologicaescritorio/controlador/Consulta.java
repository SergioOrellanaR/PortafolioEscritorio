/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odontologicaescritorio.controlador;
import java.util.ArrayList;
import odontologicaescritorio.modelo.*;

/**
 *
 * @author Marco Antonio
 */
public class Consulta {
    public UsuarioDTO obtenerUsuarioPorNombreClave(String nombre, String clave){
        return new UsuarioDAO().obtenerUsuarioPorNombreClaveBD(nombre, clave);
    }
    
    public int validarUsuario(String nombre, String clave){
        return new UsuarioDAO().validarUsuarioBD(nombre, clave);
    }     
}
