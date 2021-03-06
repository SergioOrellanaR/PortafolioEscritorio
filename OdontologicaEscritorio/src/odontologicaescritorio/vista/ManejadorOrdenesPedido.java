package odontologicaescritorio.vista;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import odontologicaescritorio.modelo.*;
import odontologicaescritorio.controlador.*;
/**
 *
 * @author Marco Antonio
 */
public class ManejadorOrdenesPedido extends javax.swing.JInternalFrame {
private ArrayList<ProductoDTO> listaProductos = new Lista().listaProductos();
private ArrayList<OrdenPedidoDTO> listaOrdenesPedido = new Lista().listaOrdenesPedido();
    /**
     * Creates new form GenerarOrdenPedido
     */
    public ManejadorOrdenesPedido() {
        initComponents();
        actualizarCboProductos();
        actualizarTablaProductos();
    }
    
    public void actualizarCboProductos(){
        for(ProductoDTO producto : listaProductos){
            cboProducto.addItem(producto.getId() + " - " + producto.getNombre());
        }
    }
    
    public void actualizarTablaProductos(){
        listaOrdenesPedido = new Lista().listaOrdenesPedido();
        String[] columnas = {"ID","Cantidad","Estado", "Producto"};
        DefaultTableModel modeloTabla = new DefaultTableModel(columnas, 0);
        
        for(OrdenPedidoDTO orden : listaOrdenesPedido){
            String id = String.valueOf(orden.getId());
            String cantidad = String.valueOf(orden.getCantidad());
            String estado = "-";
            if(orden.getEstado() == 0) estado = "Cancelado";
            if(orden.getEstado() == 1) estado = "En espera";
            if(orden.getEstado() == 2) estado = "Recibido";
            String producto = orden.getIdProducto().split(" ")[2];
            Object[] elemento = {id, cantidad, estado, producto};
            modeloTabla.addRow(elemento);
        };
        tblOrdenes.setModel(modeloTabla);         
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        cboProducto = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        chkTieneFecha = new javax.swing.JCheckBox();
        cboMes = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cboEstadoOrden = new javax.swing.JComboBox<>();
        btnEditarOrden = new javax.swing.JButton();
        btnCancelarOrden = new javax.swing.JButton();
        lblModo = new javax.swing.JLabel();
        spnAno = new javax.swing.JSpinner();
        spnDia = new javax.swing.JSpinner();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        txtRutBusqueda = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        btnCargarFichaOrden = new javax.swing.JButton();
        btnRegistrarOrden = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOrdenes = new javax.swing.JTable();

        setBackground(new java.awt.Color(139, 156, 168));
        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Manejador de ordenes de pedido");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/odontologicaescritorio/vista/img/icn_pedido.png"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(218, 210, 226));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel8.setBackground(new java.awt.Color(146, 128, 183));
        jLabel8.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/odontologicaescritorio/vista/img/icn_pedido.png"))); // NOI18N
        jLabel8.setText("Datos de la orden");
        jLabel8.setIconTextGap(0);
        jLabel8.setOpaque(true);

        cboProducto.setEnabled(false);

        jLabel1.setText("Producto:");

        jLabel2.setText("ID:");

        lblID.setText("-");

        jLabel4.setText("Cantidad:");

        txtCantidad.setEditable(false);

        chkTieneFecha.setText("Fecha de vencimiento:");
        chkTieneFecha.setEnabled(false);

        cboMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1 - Enero", "2 - Febrero", "3 - Marzo", "4 - Abril", "5 - Mayo", "6 - Junio", "7 - Julio", "8 - Agosto", "9 - Septiembre", "10 - Octubre", "11 - Noviembre", "12 - Diciembre" }));
        cboMes.setEnabled(false);

        jLabel5.setText("Día:");

        jLabel6.setText("Mes:");

        jLabel7.setText("Año:");

        jLabel10.setText("Estado:");

        cboEstadoOrden.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0 - Cancelado", "1 - En espera", "2 - Recibido" }));
        cboEstadoOrden.setEnabled(false);

        btnEditarOrden.setIcon(new javax.swing.ImageIcon(getClass().getResource("/odontologicaescritorio/vista/img/icn_editar.png"))); // NOI18N
        btnEditarOrden.setText("Editar orden");
        btnEditarOrden.setEnabled(false);
        btnEditarOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarOrdenActionPerformed(evt);
            }
        });

        btnCancelarOrden.setIcon(new javax.swing.ImageIcon(getClass().getResource("/odontologicaescritorio/vista/img/icn_cancelar.png"))); // NOI18N
        btnCancelarOrden.setText("Cancelar edición");
        btnCancelarOrden.setEnabled(false);
        btnCancelarOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarOrdenActionPerformed(evt);
            }
        });

        lblModo.setBackground(new java.awt.Color(204, 255, 204));
        lblModo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/odontologicaescritorio/vista/img/icn_ver.png"))); // NOI18N
        lblModo.setText("Usted está en modo vista.");
        lblModo.setOpaque(true);

        spnAno.setModel(new javax.swing.SpinnerNumberModel(2000, 1990, 3000, 1));
        spnAno.setEnabled(false);

        spnDia.setModel(new javax.swing.SpinnerNumberModel(1, 1, 31, 1));
        spnDia.setOpaque(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblModo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboProducto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblID))
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(chkTieneFecha)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(spnDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cboMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(spnAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel7)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel10)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cboEstadoOrden, 0, 149, Short.MAX_VALUE))
                                .addComponent(btnCancelarOrden, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnEditarOrden, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 139, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblModo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkTieneFecha)
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cboEstadoOrden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEditarOrden)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelarOrden)
                .addContainerGap(67, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(218, 210, 226));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel9.setBackground(new java.awt.Color(146, 128, 183));
        jLabel9.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/odontologicaescritorio/vista/img/icn_pedido.png"))); // NOI18N
        jLabel9.setText("Lista de órdenes de pedido");
        jLabel9.setIconTextGap(0);
        jLabel9.setOpaque(true);

        jLabel32.setBackground(new java.awt.Color(204, 255, 204));
        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/odontologicaescritorio/vista/img/icn_lupa.png"))); // NOI18N
        jLabel32.setText("Buscar por ID:");
        jLabel32.setIconTextGap(0);
        jLabel32.setOpaque(true);

        jLabel13.setBackground(new java.awt.Color(146, 128, 183));
        jLabel13.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Centro de acciones");
        jLabel13.setOpaque(true);

        btnCargarFichaOrden.setIcon(new javax.swing.ImageIcon(getClass().getResource("/odontologicaescritorio/vista/img/icn_cargarficha.png"))); // NOI18N
        btnCargarFichaOrden.setText("Cargar ficha");
        btnCargarFichaOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarFichaOrdenActionPerformed(evt);
            }
        });

        btnRegistrarOrden.setIcon(new javax.swing.ImageIcon(getClass().getResource("/odontologicaescritorio/vista/img/icn_agregar.png"))); // NOI18N
        btnRegistrarOrden.setText("Registrar");
        btnRegistrarOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarOrdenActionPerformed(evt);
            }
        });

        tblOrdenes.setBackground(new java.awt.Color(255, 255, 153));
        tblOrdenes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblOrdenes);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRutBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnCargarFichaOrden, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
                    .addComponent(btnRegistrarOrden, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRutBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCargarFichaOrden)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegistrarOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCargarFichaOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarFichaOrdenActionPerformed
        // TODO add your handling code here:
        int fila = tblOrdenes.getSelectedRow();
        String id  = String.valueOf(tblOrdenes.getValueAt(fila, 0)).split("-")[0];
        for(OrdenPedidoDTO ordenPedido : listaOrdenesPedido){
            if(ordenPedido.getId() == id){
                lblID.setText(id);
                cboProducto.setSelectedItem(ordenPedido.getId());
                txtCantidad.setText(String.valueOf(ordenPedido.getCantidad()));
                if(!ordenPedido.getId().substring(6, 14).equals("00000000")){
                    spnDia.setValue(Integer.parseInt(ordenPedido.getId().substring(6,8).replaceFirst("^0+(?!$)", "")));
                    cboMes.setSelectedIndex(Integer.parseInt(ordenPedido.getId().substring(8,10).replaceFirst("^0+(?!$)", "")) + 1);
                    spnAno.setValue(Integer.parseInt(ordenPedido.getId().substring(10, 14)));                    
                }else{
                    spnDia.setValue(0);
                    cboMes.setSelectedIndex(0);
                    spnAno.setValue(2000);
                    chkTieneFecha.setSelected(false);
                }
                cboEstadoOrden.setSelectedIndex(ordenPedido.getEstado());
                //y y y z z z x x x x x x x x
                //0 1 2 3 4 5 6 7 8 9 A B C D        
            }
        }
        cboProducto.setEnabled(true);
        txtCantidad.setEditable(true);
        spnDia.setEnabled(true);
        spnAno.setEnabled(true);
        cboMes.setEnabled(true);
        cboEstadoOrden.setEnabled(true);
        chkTieneFecha.setEnabled(true);
        btnEditarOrden.setEnabled(true);
        btnCancelarOrden.setEnabled(true);
    }//GEN-LAST:event_btnCargarFichaOrdenActionPerformed

    private void btnRegistrarOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarOrdenActionPerformed
        estaRegistrando = true;
        btnEditarOrden.setText("Registrar orden");
        cboProducto.setEnabled(true);
        txtCantidad.setEditable(true);
        spnDia.setEnabled(true);
        spnAno.setEnabled(true);
        cboMes.setEnabled(true);
        cboEstadoOrden.setEnabled(true);
        chkTieneFecha.setEnabled(true);
        btnEditarOrden.setEnabled(true);
        btnCancelarOrden.setEnabled(true);         
    }//GEN-LAST:event_btnRegistrarOrdenActionPerformed

    boolean estaRegistrando = false;
    boolean estaEditando = false;
    private void btnEditarOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarOrdenActionPerformed
        if(estaRegistrando){
            lblID.setText(generarId());
            JOptionPane.showMessageDialog(rootPane, new Registro().registrarOrdenPedidoBD(lblID.getText(), Integer.parseInt(txtCantidad.getText()), Integer.parseInt(String.valueOf(cboEstadoOrden.getSelectedItem()).split(" ")[0]), String.valueOf(cboProducto.getSelectedItem())), "Registro de orden", HEIGHT);
            actualizarTablaProductos();
        }
        if(!estaEditando){
            estaEditando = true;
            cboProducto.setEnabled(true);
            txtCantidad.setEditable(true);
            spnDia.setEnabled(true);
            spnAno.setEnabled(true);
            cboMes.setEnabled(true);
            cboEstadoOrden.setEnabled(true);
            chkTieneFecha.setEnabled(true);
            btnEditarOrden.setEnabled(true);
            btnCancelarOrden.setEnabled(true); 
        }
        
        if(!estaEditando){
            JOptionPane.showMessageDialog(rootPane, "ASDASDASD", "Actualización de orden", HEIGHT);
            String antiguaId = lblID.getText();
            lblID.setText(generarId());
            JOptionPane.showMessageDialog(rootPane, new Actualizacion().actualizarOrdenPedido(antiguaId, Integer.parseInt(txtCantidad.getText()), Integer.parseInt(String.valueOf(cboEstadoOrden.getSelectedItem()).split(" ")[0]), String.valueOf(cboProducto.getSelectedItem()), lblID.getText()), "Actualización de orden", HEIGHT);
            actualizarTablaProductos();                       
        }
    }//GEN-LAST:event_btnEditarOrdenActionPerformed

    private void btnCancelarOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarOrdenActionPerformed
        estaRegistrando = false;
        estaEditando = false;
        cboProducto.setEnabled(false);
        txtCantidad.setEditable(false);
        spnDia.setEnabled(false);
        spnAno.setEnabled(false);
        cboMes.setEnabled(false);
        cboEstadoOrden.setEnabled(false);
        chkTieneFecha.setEnabled(false);
        btnEditarOrden.setEnabled(false);
        btnCancelarOrden.setEnabled(false);
        btnEditarOrden.setText("Editar orden");
    }//GEN-LAST:event_btnCancelarOrdenActionPerformed

    public String generarId(){
        /*
            a) 999, los primeros tres dígitos corresponden al ID del Proveedor.
            b) 999, los tres siguientes dígitos corresponden a la familia del producto, por ejemplo: Prótesis.
            c) 99999999, los siguientes 8 dígitos corresponden a la fecha de vencimiento, si no tienen
            fecha de vencimiento se debe llenar con ceros.
            d) 999, los siguientes tres dígitos corresponden a un número secuencial que corresponde
            al tipo de producto.
        */
        String idProducto = "---";
        String idFamilia = "---";
        String fecha = "--------";
        String idTipo = "---";
        String idFinal = "00000000000000000";
        for(ProductoDTO producto : listaProductos){
            if(producto.getId() == Integer.valueOf(String.valueOf(cboProducto.getSelectedItem()).split(" ")[0])){
                idProducto = String.format("%03d", producto.getId());
                idFamilia = String.format("%03d", Integer.valueOf(producto.getIdFamilia().split(" ")[0]));
                if(chkTieneFecha.isSelected())
                    fecha = String.format("%02d", spnDia.getValue()) + String.format("%02d", Integer.valueOf(cboMes.getSelectedItem().toString().split(" ")[0])) + String.format("%03d", spnAno.getValue());
                else
                    fecha = "00000000";
                idTipo = String.format("%03d", Integer.valueOf(producto.getIdTipo().toString().split(" ")[0]));
                idFinal = idProducto + idFamilia + fecha + idTipo;
            }
        }
        return idFinal;
    }
           
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarOrden;
    private javax.swing.JButton btnCargarFichaOrden;
    private javax.swing.JButton btnEditarOrden;
    private javax.swing.JButton btnRegistrarOrden;
    private javax.swing.JComboBox<String> cboEstadoOrden;
    private javax.swing.JComboBox<String> cboMes;
    private javax.swing.JComboBox<String> cboProducto;
    private javax.swing.JCheckBox chkTieneFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblModo;
    private javax.swing.JSpinner spnAno;
    private javax.swing.JSpinner spnDia;
    private javax.swing.JTable tblOrdenes;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtRutBusqueda;
    // End of variables declaration//GEN-END:variables
}
