/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odontologicaescritorio.controlador;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import odontologicaescritorio.modelo.*;

/**
 *
 * @author Marco Antonio
 */
public class Registro {
    public String registrarPacienteYUsuarioBD(int rut, char dv, String p_nombre, String s_nombre, String p_apellido, String s_apellido, LocalDate f_nacimiento, char sexo, String direccion, int telefono, String email, String comuna, String ciudad){
        return new PacienteDAO(rut, dv, p_nombre, s_nombre, p_apellido, s_apellido, f_nacimiento, sexo, direccion, telefono, email, comuna, ciudad).registrarPacienteBD();
    }
    
    public String registrarFuncionarioYUsuarioBD(int rut, char dv, String p_nombre, String s_nombre, String p_apellido, String s_apellido, LocalDate f_nacimiento, char sexo, String direccion, int telefono, String email, String comuna, String ciudad, String tipo){
        return new FuncionarioDAO(rut, dv, p_nombre, s_nombre, p_apellido, s_apellido, f_nacimiento, sexo, direccion, telefono, email, comuna, ciudad, tipo).registrarFuncionarioBD();
    }
    
    public String registrarServicioBD(String descripcion, int precio){
        return new ServicioDAO(0, descripcion, precio).registrarServicioBD();
    }
    
    public String registrarHoraBD(int id, LocalDate fecha, LocalTime hora, int rutFuncionario, int rutCliente){
        return new HoraDAO(id, fecha, hora, rutFuncionario, rutCliente).registrarHoraBD();
    }    
}
