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
    
    public ArrayList<ComunaDTO> listarComunas(int idCiudad){
        ArrayList<ComunaDTO> listaComunas = new ComunaDAO().obtenerTodasLasComunasPorCiudadBD(idCiudad);
        return listaComunas;
    }
    
    public ArrayList<CiudadDTO> listarCiudades(){
        ArrayList<CiudadDTO> listaCiudades = new CiudadDAO().obtenerTodasLasCiudadesBD();
        return listaCiudades;
    }    
    
    public ArrayList<ServicioDTO> listarServicios(){
        ArrayList<ServicioDTO> listaServicios = new ServicioDAO().obtenerTodosLosServiciosBD();
        return listaServicios;
    }
    
    public ArrayList<FamiliaProductoDTO> listaFamiliasProducto(){
        ArrayList<FamiliaProductoDTO> listaFamiliasProducto = new FamiliaProductoDAO().obtenerTodasLasFamiliasProductoBD();
        return listaFamiliasProducto;       
    }
    
    public ArrayList<TipoProductoDTO> listaTiposProductoPorIdFamilia(int id){
        ArrayList<TipoProductoDTO> listaTiposProducto = new TipoProductoDAO().obtenerTiposProductoPorIdFamiliaBD(id);
        return listaTiposProducto;       
    }  
    
    public ArrayList<TipoProductoDTO> listaTiposProducto(){
        ArrayList<TipoProductoDTO> listaTiposProducto = new TipoProductoDAO().obtenerTiposProductoBD();
        return listaTiposProducto;       
    } 
    
    public ArrayList<ProductoDTO> listaProductos(){
        ArrayList<ProductoDTO> listaProductos = new ProductoDAO().obtenerTodosLosProductosBD();
        return listaProductos;       
    }     
}
