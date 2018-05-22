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
public class ProductoDAO implements DatosConexion{
    int id;
    String nombre;
    int precioCompra;
    int precioVenta;
    String idProveedor;
    String idTipo;
    String idFamilia;

    public ProductoDAO() {
    }

    public ProductoDAO(int id, String nombre, int precioCompra, int precioVenta, String idProveedor, String idTipo, String idFamilia) {
        this.id = id;
        this.nombre = nombre;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.idProveedor = idProveedor;
        this.idTipo = idTipo;
        this.idFamilia = idFamilia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(int precioCompra) {
        this.precioCompra = precioCompra;
    }

    public int getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(int precioVenta) {
        this.precioVenta = precioVenta;
    }

    public String getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(String idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(String idTipo) {
        this.idTipo = idTipo;
    }

    public String getIdFamilia() {
        return idFamilia;
    }

    public void setIdFamilia(String idFamilia) {
        this.idFamilia = idFamilia;
    }
    
    public ArrayList<ProductoDTO> obtenerTodosLosProductosBD(){
        ArrayList<ProductoDTO> listaProductos = new ArrayList<ProductoDTO>();
        try{
            Class.forName(DRIVER);
            Connection conexion =  DriverManager.getConnection(URL,USUARIO,CLAVE);
            Statement declaracion = conexion.createStatement();
            ResultSet resultado = declaracion.executeQuery("SELECT PRODUCTO.ID, PRODUCTO.NOMBRE, PRODUCTO.PRECIO_COMPRA, PRODUCTO.PRECIO_VENTA, PRODUCTO.ID_PROVEEDOR||' - '||PROVEEDOR.NOMBRE_EMPRESA, PRODUCTO.ID_TIPOPRODUCTO||' - '||TIPO_PRODUCTO.DESCRIPCION, TIPO_PRODUCTO.ID_FAMILIA||' - '||FAMILIA_PRODUCTO.DESCRIPCION FROM PRODUCTO JOIN PROVEEDOR ON (PRODUCTO.ID_PROVEEDOR = PROVEEDOR.ID) JOIN TIPO_PRODUCTO ON (TIPO_PRODUCTO.ID = PRODUCTO.ID_TIPOPRODUCTO) JOIN FAMILIA_PRODUCTO ON (FAMILIA_PRODUCTO.ID = TIPO_PRODUCTO.ID_FAMILIA)");
            while (resultado.next()) {
                this.setId(resultado.getInt(1));
                this.setNombre(resultado.getString(2));
                this.setPrecioCompra(resultado.getInt(3));
                this.setPrecioVenta(resultado.getInt(4));
                this.setIdProveedor(resultado.getString(5));
                this.setIdTipo(resultado.getString(6));
                this.setIdFamilia(resultado.getString(7));
                listaProductos.add(new ProductoDTO(this.getId(), this.getNombre(), this.getPrecioCompra(), this.getPrecioVenta(), this.getIdProveedor(), this.getIdTipo(), this.getIdFamilia()));
            }  
            conexion.close();
            return listaProductos;
        }catch(Exception e){
            System.out.println("Error : " + e);
            return listaProductos;
        }
    }    
}
