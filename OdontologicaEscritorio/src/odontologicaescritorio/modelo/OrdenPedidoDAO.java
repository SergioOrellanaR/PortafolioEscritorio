/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odontologicaescritorio.modelo;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author Marco Antonio
 */
public class OrdenPedidoDAO implements DatosConexion{
    private String id;
    private int cantidad;
    private int estado;
    private String idProducto;

    public OrdenPedidoDAO(String id, int cantidad, int estado, String idProducto) {
        this.id = id;
        this.cantidad = cantidad;
        this.estado = estado;
        this.idProducto = idProducto;
    }

    public OrdenPedidoDAO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }
    
    public String registrarOrdenPedidoBD(){
        try{
            Class.forName(DRIVER);
            Connection conexion =  DriverManager.getConnection(URL,USUARIO,CLAVE);
            Statement declaracion = conexion.createStatement();
            declaracion.executeUpdate("INSERT INTO ORDEN_PEDIDO (ID, CANTIDAD, ID_PRODUCTO, ESTADO) VALUES ('" + this.getId() + "'," + this.getCantidad() + ",'" + this.getIdProducto().split(" ")[0] + "'," + this.getEstado() + ")");
            conexion.close();
            System.out.println("INSERT INTO ORDEN_PEDIDO (ID, CANTIDAD, ID_PRODUCTO, ESTADO) VALUES ('" + this.getId() + "'," + this.getCantidad() + ",'" + this.getIdProducto().split(" ")[0] + "'," + this.getEstado() + ")");
            return "Registro de orden en la base de datos fue exitoso.";
        }catch(Exception e){
            System.out.println("Error : " + e);
            return "No se pudo registrar orden en base de datos: " + e;
        }        
    }
    
    public ArrayList<OrdenPedidoDTO> obtenerTodasLasOrdenesPedidoBD(){
        ArrayList<OrdenPedidoDTO> listaOrdenesPedido = new ArrayList<OrdenPedidoDTO>();
        try{
            Class.forName(DRIVER);
            Connection conexion =  DriverManager.getConnection(URL,USUARIO,CLAVE);
            Statement declaracion = conexion.createStatement();
            ResultSet resultado = declaracion.executeQuery("SELECT ORDEN_PEDIDO.ID, ORDEN_PEDIDO.CANTIDAD, ORDEN_PEDIDO.ESTADO, ORDEN_PEDIDO.ID_PRODUCTO ||' - '|| PRODUCTO.NOMBRE FROM ORDEN_PEDIDO JOIN PRODUCTO ON (ORDEN_PEDIDO.ID_PRODUCTO = PRODUCTO.ID)");
            while (resultado.next()) {
                this.setId(resultado.getString(1));
                this.setCantidad(resultado.getInt(2));
                this.setEstado(resultado.getInt(3));
                this.setIdProducto(resultado.getString(4));
                listaOrdenesPedido.add(new OrdenPedidoDTO(this.getId(), this.getCantidad(), this.getEstado(), this.getIdProducto()));
            }  
            conexion.close();
            return listaOrdenesPedido;
        }catch(Exception e){
            System.out.println("Error ??: " + e);
            return listaOrdenesPedido;
        }
    }

    public String actualizarOrdenPedidoBD(String nuevaId){
        try{
            Class.forName(DRIVER);
            Connection conexion =  DriverManager.getConnection(URL,USUARIO,CLAVE);
            Statement declaracion = conexion.createStatement();
            declaracion.executeUpdate("UPDATE ORDEN_PEDIDO SET ID = '" + nuevaId + "', CANTIDAD = " + this.getCantidad() + ", ESTADO = " + this.getEstado() + ", ID_PRODUCTO = " + this.getIdProducto().split(" ")[0] + " WHERE ID = '" + this.getId() + "'");
            conexion.close();
            return "Actualización de orden en la base de datos fue exitoso.";
        }catch(Exception e){
            System.out.println("Error : " + e);
            return "No se pudo actualizar orden en base de datos: " + e;
        }    
    }
    
}
