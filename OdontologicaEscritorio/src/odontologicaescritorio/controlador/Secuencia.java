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
public class Secuencia {
    public int ultimoValor(String nombreTabla, String nombreColumna){
        return new SecuenciaDAO(nombreTabla, nombreColumna).ultimoValorSecuenciaBD();
    }
}
