package odontologicaescritorio.modelo;

public class OrdenPedidoDTO {
    private String id;
    private int cantidad;
    private int estado;
    private String idProducto;

    public OrdenPedidoDTO(String id, int cantidad, int estado, String idProducto) {
        this.id = id;
        this.cantidad = cantidad;
        this.estado = estado;
        this.idProducto = idProducto;
    }

    public OrdenPedidoDTO() {
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
}
