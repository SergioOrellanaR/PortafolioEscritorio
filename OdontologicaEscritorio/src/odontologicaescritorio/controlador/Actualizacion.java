/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odontologicaescritorio.controlador;
import odontologicaescritorio.modelo.*;
/**
 *
 * @author Marco Antonio
 */
public class Actualizacion {
    public String actualizarPermisosUsuario(int id, int administrador, int odontologo, int recepcionista, int bodega, int cliente){
        return new UsuarioDAO().modificarPermisos(id, administrador, odontologo, recepcionista, bodega, cliente);
    }
    
    public String actualizarEstadoSolicitud(int id, int estado){
        return new PedidoBodegaDAO().actualizarEstado(id, estado);
    }
}
