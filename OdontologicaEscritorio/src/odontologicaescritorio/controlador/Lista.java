package odontologicaescritorio.controlador;
import java.util.ArrayList;
import odontologicaescritorio.modelo.*;

/**
 *
 * @author Marco Antonio
 */
public class Lista {
    public Lista(){};
    
    public ArrayList<PacienteDTO> listarPacientes(){
        ArrayList<PacienteDTO> listaPacientes = new PacienteDAO().obtenerTodosLosPacientesBD();
        System.out.println("RUT: " + listaPacientes.get(0).getRut());
        return listaPacientes;
    }
    
    public ArrayList<FuncionarioDTO> listarFuncionarios(){
        ArrayList<FuncionarioDTO> listaFuncionarios = new FuncionarioDAO().obtenerTodosLosFuncionariosBD();
        return listaFuncionarios;
    }    
    
    public ArrayList<UsuarioDTO> listarUsuarios(){
        ArrayList<UsuarioDTO> listaUsuarios = new UsuarioDAO().obtenerTodosLosUsuariosBD();
        return listaUsuarios;
    }
}
