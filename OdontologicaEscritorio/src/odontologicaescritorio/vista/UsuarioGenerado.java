/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odontologicaescritorio.vista;

/**
 *
 * @author Marco Antonio
 */
public class UsuarioGenerado extends javax.swing.JInternalFrame {

    /**
     * Creates new form UsuarioGenerado
     */
    private String nombreUsuario;
    private String claveUsuario;
    public UsuarioGenerado(String nombreUsuario, String claveUsuario) {
        initComponents();
        lblNombreUsuario.setText(nombreUsuario);
        lblClaveUsuario.setText(claveUsuario);
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
        jPanel4 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        lblNombreUsuario = new javax.swing.JLabel();
        lblClaveUsuario = new javax.swing.JLabel();
        btnFinalizar = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        chkEntregarUsuario = new javax.swing.JCheckBox();

        setTitle("Nuevo usuario de internet generado");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/odontologicaescritorio/vista/img/icn_pc.png"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(139, 156, 168));

        jPanel4.setBackground(new java.awt.Color(218, 210, 226));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel30.setBackground(new java.awt.Color(146, 128, 183));
        jLabel30.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/odontologicaescritorio/vista/img/icn_pc.png"))); // NOI18N
        jLabel30.setText("Enhorabuena, ¡usuario de internet generado con éxito!");
        jLabel30.setIconTextGap(0);
        jLabel30.setOpaque(true);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/odontologicaescritorio/vista/img/icn_persona.png"))); // NOI18N
        jLabel1.setText("Nombre de usuario:");

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/odontologicaescritorio/vista/img/icn_llave.png"))); // NOI18N
        jLabel31.setText("Contraseña de acceso (últimos 4 dígitos del rut):");

        lblNombreUsuario.setText("nombreUsuario");

        lblClaveUsuario.setText("claveAcceso");

        btnFinalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/odontologicaescritorio/vista/img/icn_avanzar.png"))); // NOI18N
        btnFinalizar.setText("Finalizar");
        btnFinalizar.setEnabled(false);

        jLabel32.setBackground(new java.awt.Color(204, 255, 204));
        jLabel32.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel32.setText("Nota: el paciente puede cambiar sus datos y clave en el portal de internet.");
        jLabel32.setIconTextGap(0);

        jLabel33.setBackground(new java.awt.Color(249, 255, 211));
        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/odontologicaescritorio/vista/img/icn_advertencia.png"))); // NOI18N
        jLabel33.setText("¡NO OLVIDE entregarles los datos de usuario al paciente!");
        jLabel33.setIconTextGap(0);
        jLabel33.setOpaque(true);

        jLabel34.setBackground(new java.awt.Color(204, 255, 204));
        jLabel34.setText("Se ha generado un usuario de internet para el paciente ingresado.");
        jLabel34.setIconTextGap(0);

        chkEntregarUsuario.setText("Confirmo que he cumplido con mi deber de informarle los datos de usuario al paciente.");
        chkEntregarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkEntregarUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnFinalizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblNombreUsuario))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel31)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblClaveUsuario))
                            .addComponent(chkEntregarUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblNombreUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(lblClaveUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkEntregarUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnFinalizar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chkEntregarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkEntregarUsuarioActionPerformed
        // TODO add your handling code here:
        if(chkEntregarUsuario.isSelected()){
            btnFinalizar.setEnabled(true);
        }else{
            btnFinalizar.setEnabled(false);
        }
    }//GEN-LAST:event_chkEntregarUsuarioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JCheckBox chkEntregarUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblClaveUsuario;
    private javax.swing.JLabel lblNombreUsuario;
    // End of variables declaration//GEN-END:variables
}
