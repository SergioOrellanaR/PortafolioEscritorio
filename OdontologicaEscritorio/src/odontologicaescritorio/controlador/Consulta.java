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
    
    public int buscarPaciente(int rut){
        return new PacienteDAO().buscarPacienteBD(rut);
    }
    
    public PacienteDTO obtenerPaciente(int rut){
        return new PacienteDAO().obtenerPacienteBD(rut);
    }
    
    public int solicitudesPendientesBodega(){
        return new PedidoBodegaDAO().obtenerNumeroSolicitudesPendientesBD();
    }    
    
    public int consultarMesAnoAgenda(int mes, int ano, int rutFuncionario){
        return new DiaDAO().existeMesBD(mes, ano, rutFuncionario);
    } 
    
    public String pacienteDeHora(int idHora){
        return new HoraDAO().pacineteDeHoraBD(idHora);
    }    
}
