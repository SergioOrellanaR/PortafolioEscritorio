/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odontologicaescritorio.controlador;

import java.time.LocalDate;
import odontologicaescritorio.modelo.*;

/**
 *
 * @author Marco Antonio
 */
public class Eliminacion {
    public String eliminarHora(int id){
        return new HoraDAO().eliminarHoraBD(id);
    }    
}
