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
import odontologicaescritorio.vista.SolicitudesBodega;

/**
 *
 * @author Marco Antonio
 */
public class Registro {
    public String registrarPacienteYUsuarioBD(int rut, char dv, String p_nombre, String s_nombre, String p_apellido, String s_apellido, LocalDate f_nacimiento, char sexo, String direccion, int telefono, String email, String comuna, String ciudad, int vulnerable){
        return new PacienteDAO(rut, dv, p_nombre, s_nombre, p_apellido, s_apellido, f_nacimiento, sexo, direccion, telefono, email, comuna, ciudad, vulnerable).registrarPacienteBD();
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
    
    public String registrarBoletaBD(LocalDate fecha, int rutCliente){
        return new BoletaDAO(0, fecha, rutCliente).registrarBoletaBD();
    }        

    public boolean registrarDetalleBoletaBD(int idBoleta, int idServicio, int valor){
        return new BoletaDAO().registrarDetalleBoletaBD(idBoleta, idServicio, valor);
    }   
    
   public String registrarProveedorBD(String nombreEmpresa, int rutEmpresa, char dvEmpresa, int telefono, String email, String nombreRepresentante, int rutRepresentante, char dvRepresentante, String idRubro){
        return new ProveedorDAO(0, nombreEmpresa, rutEmpresa, dvEmpresa, telefono, email, nombreRepresentante, rutRepresentante, dvRepresentante, idRubro).registrarProveedorBD();
   }
   
   public String registrarSolicitudBodegaBD(String descripcion, LocalDate fecha, int rutEmisor){
       return new PedidoBodegaDAO(0, descripcion, fecha, "0", 0).registrarPedidoBD(rutEmisor);
   }
}
