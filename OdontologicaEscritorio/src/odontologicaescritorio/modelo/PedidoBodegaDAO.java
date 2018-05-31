/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odontologicaescritorio.modelo;
import java.util.ArrayList;
import java.time.LocalDate;
import java.sql.*;

/**
 *
 * @author Marco Antonio
 */
public class PedidoBodegaDAO implements DatosConexion{
    private int id;
    private String descripcion;
    private LocalDate fecha;
    private String rutEmisor;
    private int estado;

    public PedidoBodegaDAO() {
    }

    public PedidoBodegaDAO(int id, String descripcion, LocalDate fecha, String rutEmisor, int estado) {
        this.id = id;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.rutEmisor = rutEmisor;
        this.estado = estado;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getRutEmisor() {
        return rutEmisor;
    }

    public void setRutEmisor(String rutEmisor) {
        this.rutEmisor = rutEmisor;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
public ArrayList<PedidoBodegaDTO> obtenerTodosLosPedidosBD(){
        ArrayList<PedidoBodegaDTO> listaPedidos = new ArrayList<PedidoBodegaDTO>();
        try{
            Class.forName(DRIVER);
            Connection conexion =  DriverManager.getConnection(URL,USUARIO,CLAVE);
            Statement declaracion = conexion.createStatement();
            ResultSet resultado = declaracion.executeQuery("SELECT PEDIDO_A_BODEGA.ID, PEDIDO_A_BODEGA.DESCRIPCION, TO_CHAR(PEDIDO_A_BODEGA.FECHA, 'YYYY-MM-DD'), PEDIDO_A_BODEGA.RUT_EMISOR ||' - '|| FUNCIONARIO.P_NOMBRE ||' '||FUNCIONARIO.P_APELLIDO, PEDIDO_A_BODEGA.ESTADO FROM PEDIDO_A_BODEGA JOIN FUNCIONARIO ON (FUNCIONARIO.RUT = PEDIDO_A_BODEGA.RUT_EMISOR) ORDER BY PEDIDO_A_BODEGA.ID DESC");
            while (resultado.next()) {
                this.setId(resultado.getInt(1));
                this.setDescripcion(resultado.getString(2));
                this.setFecha(LocalDate.parse(resultado.getString(3)));
                this.setRutEmisor(resultado.getString(4));
                this.setEstado(resultado.getInt(5));
                listaPedidos.add(new PedidoBodegaDTO(this.getId(), this.getDescripcion(), this.getFecha(), this.getRutEmisor(), this.getEstado()));
            }  
            conexion.close();
            return listaPedidos;
        }catch(Exception e){
            System.out.println("Error : " + e);
            return listaPedidos;
        }
    } 

    public int obtenerNumeroSolicitudesPendientesBD(){
        int numeroSolicitudes = -1;
        try{
            Class.forName(DRIVER);
            Connection conexion =  DriverManager.getConnection(URL,USUARIO,CLAVE);
            Statement declaracion = conexion.createStatement();
            ResultSet resultado = declaracion.executeQuery("SELECT COUNT(PEDIDO_A_BODEGA.ID) FROM PEDIDO_A_BODEGA WHERE PEDIDO_A_BODEGA.ESTADO = 0");
            while (resultado.next()) {
                numeroSolicitudes = resultado.getInt(1);
            }  
            conexion.close();
            return numeroSolicitudes;
        }catch(Exception e){
            System.out.println("Error : " + e);
            return numeroSolicitudes;
        }
    }
    
    public String registrarPedidoBD(int rut){
        try{
            Class.forName(DRIVER);
            Connection conexion =  DriverManager.getConnection(URL,USUARIO,CLAVE);
            Statement declaracion = conexion.createStatement();
            declaracion.executeUpdate("INSERT INTO PEDIDO_A_BODEGA (ID, DESCRIPCION, FECHA, RUT_EMISOR, ESTADO) VALUES (SEQ_ID_BODEGA.NEXTVAL, '" + this.getDescripcion() + "', TO_DATE('" + this.getFecha() + "', 'YYYY-MM-DD')," + rut + "," + this.getEstado() + ")");
            conexion.close();
            return "Solicitud enviada con éxito al módulo de bodegas.";
        }catch(Exception e){
            System.out.println("Error : " + e);
            return "No se pudo entregar solicitud a módulo de bodegas: " + e;
        }        
    }    
    
    public String actualizarEstado(int id, int estado){
        try{
            Class.forName(DRIVER);
            Connection conexion =  DriverManager.getConnection(URL,USUARIO,CLAVE);
            Statement declaracion = conexion.createStatement();
            declaracion.executeUpdate("UPDATE PEDIDO_A_BODEGA SET ESTADO = " + estado + " WHERE ID = " + id);
            conexion.close();
            return "Estado de solicitud cambiado correctamente.";
        }catch(Exception e){
            System.out.println("Error : " + e);
            return "No se pudo cambiar estado de solicitud: " + e;
        }        
    }      
}
