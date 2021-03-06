/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odontologicaescritorio.vista;
import odontologicaescritorio.modelo.*;
import odontologicaescritorio.controlador.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Marco Antonio
 */
public class ManejadorServicios extends javax.swing.JInternalFrame {

    /**
     * Creates new form ManejadorServicios
     */
    ArrayList<ServicioDTO> listaServicios;
    public ManejadorServicios() {
        initComponents();
        actualizarListaServicios();
    }
    
    public void actualizarListaServicios(){
        listaServicios = new Lista().listarServicios();
        String[] columnas = {"ID","Nombre", "Valor"};
        DefaultTableModel modeloTabla = new DefaultTableModel(columnas, 0);
        
        for(ServicioDTO servicio : listaServicios){
            String id       = String.valueOf(servicio.getId());
            String nombre   = String.valueOf(servicio.getDescripcion());
            String precio   = String.valueOf(servicio.getPrecio());
            Object[] elemento = {id, nombre, precio};
            modeloTabla.addRow(elemento);
        };
        tblServicios.setModel(modeloTabla);        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblServicios = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        btnCargarServicio = new javax.swing.JButton();
        btnRegistrarServicio = new javax.swing.JButton();
        lblListaPersonas4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblListaPersonas3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtNombreServicio = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        lblIdServicio = new javax.swing.JLabel();
        lblModo = new javax.swing.JLabel();
        btnEditarDatosServicios = new javax.swing.JButton();
        btnCancelarServicio = new javax.swing.JButton();

        setBackground(new java.awt.Color(139, 156, 168));
        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Manejo de servicios");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/odontologicaescritorio/vista/img/icn_servicio.png"))); // NOI18N

        jPanel6.setBackground(new java.awt.Color(218, 210, 226));
        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tblServicios.setBackground(new java.awt.Color(255, 255, 153));
        tblServicios.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tblServicios);

        jLabel14.setBackground(new java.awt.Color(146, 128, 183));
        jLabel14.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Centro de acciones");
        jLabel14.setOpaque(true);

        btnCargarServicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/odontologicaescritorio/vista/img/icn_cargarficha.png"))); // NOI18N
        btnCargarServicio.setText("Cargar ficha de servicio");
        btnCargarServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarServicioActionPerformed(evt);
            }
        });

        btnRegistrarServicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/odontologicaescritorio/vista/img/icn_agregar.png"))); // NOI18N
        btnRegistrarServicio.setText("Registrar nuevo servicio");
        btnRegistrarServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarServicioActionPerformed(evt);
            }
        });

        lblListaPersonas4.setBackground(new java.awt.Color(146, 128, 183));
        lblListaPersonas4.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        lblListaPersonas4.setForeground(new java.awt.Color(255, 255, 255));
        lblListaPersonas4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/odontologicaescritorio/vista/img/icn_servicio.png"))); // NOI18N
        lblListaPersonas4.setText("Lista de servicios");
        lblListaPersonas4.setOpaque(true);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCargarServicio, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                    .addComponent(btnRegistrarServicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblListaPersonas4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblListaPersonas4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCargarServicio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegistrarServicio)
                .addGap(12, 12, 12))
        );

        jPanel1.setBackground(new java.awt.Color(218, 210, 226));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblListaPersonas3.setBackground(new java.awt.Color(146, 128, 183));
        lblListaPersonas3.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        lblListaPersonas3.setForeground(new java.awt.Color(255, 255, 255));
        lblListaPersonas3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/odontologicaescritorio/vista/img/icn_servicio.png"))); // NOI18N
        lblListaPersonas3.setText("Datos del servicio");
        lblListaPersonas3.setOpaque(true);

        jLabel1.setText("ID del servicio (no editable):");

        jLabel10.setText("Nombre del servicio:");

        txtNombreServicio.setEditable(false);

        jLabel11.setText("Precio del servicio:");

        txtPrecio.setEditable(false);

        lblIdServicio.setText("-");

        lblModo.setBackground(new java.awt.Color(204, 255, 204));
        lblModo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/odontologicaescritorio/vista/img/icn_ver.png"))); // NOI18N
        lblModo.setText("Usted está en modo vista.");
        lblModo.setOpaque(true);

        btnEditarDatosServicios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/odontologicaescritorio/vista/img/icn_editar.png"))); // NOI18N
        btnEditarDatosServicios.setText("Editar servicio");
        btnEditarDatosServicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarDatosServiciosActionPerformed(evt);
            }
        });

        btnCancelarServicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/odontologicaescritorio/vista/img/icn_cancelar.png"))); // NOI18N
        btnCancelarServicio.setText("Cancelar");
        btnCancelarServicio.setEnabled(false);
        btnCancelarServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarServicioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblListaPersonas3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblModo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblIdServicio))
                            .addComponent(jLabel10)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtNombreServicio)
                            .addComponent(btnEditarDatosServicios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCancelarServicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 179, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblListaPersonas3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblModo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblIdServicio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombreServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditarDatosServicios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelarServicio)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    boolean estaRegistrando = false;
    private void btnRegistrarServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarServicioActionPerformed
        // TODO add your handling code here:
        if(!estaRegistrando){
            lblIdServicio.setText("-");
            estaRegistrando = true;
            txtNombreServicio.setEditable(true);
            txtPrecio.setEditable(true);
            lblModo.setText("Usted está en modo registro.");
            btnEditarDatosServicios.setText("Registrar servicio");
            btnEditarDatosServicios.setEnabled(true);
            btnEditarDatosServicios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/odontologicaescritorio/vista/img/icn_guardar.png")));
            btnCancelarServicio.setEnabled(true);
            tblServicios.setEnabled(false);
            btnRegistrarServicio.setEnabled(false);
            btnCargarServicio.setEnabled(false);
        }
    }//GEN-LAST:event_btnRegistrarServicioActionPerformed

    boolean estaEditando = false;
    private void btnEditarDatosServiciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarDatosServiciosActionPerformed
        if(!estaEditando){
            estaEditando = true; 
            txtNombreServicio.setEditable(true);
            txtPrecio.setEditable(true);
            btnCancelarServicio.setEnabled(true);
            tblServicios.setEnabled(false);
            btnRegistrarServicio.setEnabled(false);
            btnCargarServicio.setEnabled(false);            
        }else{
            estaEditando = false;
            txtNombreServicio.setEditable(false);
            txtPrecio.setEditable(false);
            btnCancelarServicio.setEnabled(false);
            tblServicios.setEnabled(true);
            btnRegistrarServicio.setEnabled(true);
            btnCargarServicio.setEnabled(true);            
        }
        //Si está en modo registro, el botón editar se transforma en un boton "registrar".
        if(estaRegistrando){
            JOptionPane.showMessageDialog(rootPane, new Registro().registrarServicioBD(txtNombreServicio.getText(), Integer.parseInt(txtPrecio.getText())), "Registro de servicios", HEIGHT);
            actualizarListaServicios();
            txtNombreServicio.setText("");
            txtPrecio.setText("");
            btnCancelarServicio.setEnabled(true);
        }
    }//GEN-LAST:event_btnEditarDatosServiciosActionPerformed

    private void btnCancelarServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarServicioActionPerformed
        // TODO add your handling code here:
        if(estaRegistrando){
            estaRegistrando = false;
            txtNombreServicio.setEditable(false);
            txtPrecio.setEditable(false);
            lblModo.setText("Usted está en modo vista.");
            btnEditarDatosServicios.setText("Editar servicio");
            btnEditarDatosServicios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/odontologicaescritorio/vista/img/icn_editar.png")));
            btnEditarDatosServicios.setEnabled(false);
            btnCancelarServicio.setEnabled(false);         
            tblServicios.setEnabled(true);
            btnRegistrarServicio.setEnabled(true);
            btnCargarServicio.setEnabled(true);              
        }
        if(estaEditando){
            estaEditando = false;
            txtNombreServicio.setEditable(false);
            txtPrecio.setEditable(false);            
            lblModo.setText("Usted está en modo vista.");
            btnEditarDatosServicios.setText("Editar servicio");
            btnEditarDatosServicios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/odontologicaescritorio/vista/img/icn_editar.png")));
            btnEditarDatosServicios.setEnabled(false);
            btnCancelarServicio.setEnabled(false);
            tblServicios.setEnabled(true);
            btnRegistrarServicio.setEnabled(true);
            btnCargarServicio.setEnabled(true);              
        }
    }//GEN-LAST:event_btnCancelarServicioActionPerformed

    private void btnCargarServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarServicioActionPerformed
        // TODO add your handling code here:
        int fila = tblServicios.getSelectedRow();
        int id  = Integer.parseInt(String.valueOf(tblServicios.getValueAt(fila, 0)));
        String nombre = String.valueOf(tblServicios.getValueAt(fila, 1));
        int precio = Integer.parseInt(String.valueOf(tblServicios.getValueAt(fila, 2)));
        txtNombreServicio.setText(nombre);
        lblIdServicio.setText(String.valueOf(id));
        txtPrecio.setText(String.valueOf(precio));
    }//GEN-LAST:event_btnCargarServicioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarServicio;
    private javax.swing.JButton btnCargarServicio;
    private javax.swing.JButton btnEditarDatosServicios;
    private javax.swing.JButton btnRegistrarServicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblIdServicio;
    private javax.swing.JLabel lblListaPersonas3;
    private javax.swing.JLabel lblListaPersonas4;
    private javax.swing.JLabel lblModo;
    private javax.swing.JTable tblServicios;
    private javax.swing.JTextField txtNombreServicio;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
