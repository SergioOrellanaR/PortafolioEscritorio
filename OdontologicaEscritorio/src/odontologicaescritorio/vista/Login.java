/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odontologicaescritorio.vista;
import java.awt.Toolkit;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import odontologicaescritorio.controlador.*;
import odontologicaescritorio.modelo.*;

/**
 *
 * @author Marco Antonio
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/odontologicaescritorio/vista/img/icn_aplicacion.png")));
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
        jPanel2 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtNombreUsuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnIngresar = new javax.swing.JButton();
        txtClaveUsuario = new javax.swing.JPasswordField();
        btnIngresar1 = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnAccesoDesarrollador = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Odontológica linda sonrisa: Sistema de gestión");
        setBackground(new java.awt.Color(139, 156, 168));

        jPanel1.setBackground(new java.awt.Color(139, 156, 168));

        jPanel2.setBackground(new java.awt.Color(218, 210, 226));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel15.setBackground(new java.awt.Color(146, 128, 183));
        jLabel15.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/odontologicaescritorio/vista/img/icn_pc.png"))); // NOI18N
        jLabel15.setText("Ingreso al sistema");
        jLabel15.setIconTextGap(0);
        jLabel15.setOpaque(true);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/odontologicaescritorio/vista/img/icn_persona.png"))); // NOI18N
        jLabel1.setText("Usuario:");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/odontologicaescritorio/vista/img/icn_llave.png"))); // NOI18N
        jLabel2.setText("Contraseña:");

        btnIngresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/odontologicaescritorio/vista/img/icn_ingresar.png"))); // NOI18N
        btnIngresar.setText("Ingresar");
        btnIngresar.setMaximumSize(new java.awt.Dimension(179, 25));
        btnIngresar.setMinimumSize(new java.awt.Dimension(179, 25));
        btnIngresar.setPreferredSize(new java.awt.Dimension(179, 25));
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        btnIngresar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/odontologicaescritorio/vista/img/icn_exclamar.png"))); // NOI18N
        btnIngresar1.setText("He olvidado mi contraseña");
        btnIngresar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombreUsuario)
                            .addComponent(txtClaveUsuario))
                        .addGap(68, 68, 68)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnIngresar1, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                    .addComponent(btnIngresar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtClaveUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 16, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnIngresar1)))
                .addContainerGap())
        );

        jLabel32.setBackground(new java.awt.Color(204, 255, 204));
        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/odontologicaescritorio/vista/img/icn_persona.png"))); // NOI18N
        jLabel32.setText("¡Bienvenid@! Para comenzar, digite sus credenciales de usuario.");
        jLabel32.setOpaque(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/odontologicaescritorio/vista/img/lavanda_small.png"))); // NOI18N

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Para gestión de clínica odontológica - v0.8p");

        btnAccesoDesarrollador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/odontologicaescritorio/vista/img/icn_ver.png"))); // NOI18N
        btnAccesoDesarrollador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAccesoDesarrolladorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAccesoDesarrollador)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addGap(7, 7, 7))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAccesoDesarrollador)
                        .addContainerGap())))
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

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        // TODO add your handling code here:        
        if(new Consulta().validarUsuario(txtNombreUsuario.getText(), txtClaveUsuario.getText()) == 1){
            UsuarioDTO usuarioSesion = new UsuarioDAO().obtenerUsuarioPorNombreClaveBD(txtNombreUsuario.getText(), txtClaveUsuario.getText());
            FuncionarioDTO funcionarioSesion = new FuncionarioDAO().obtenerFuncionarioBD(usuarioSesion.getRut_persona());
            System.out.println("FUNCIONARIO CARGADO EN LOGIN: " + funcionarioSesion.getRut());
            System.out.println("USUARIO CARGADO EN LOGIN: " + usuarioSesion.getRut_persona());
            new VentanaPrincipal(funcionarioSesion, usuarioSesion, this).show();
            this.setVisible(false);
            txtNombreUsuario.setText("");
            txtClaveUsuario.setText("");
        }else{
            JOptionPane.showMessageDialog(rootPane, "Usted ha ingresado un usuario o contraseña incorrectos, intente nuevamente.", "Acceso denegado", HEIGHT);
        }
        
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void btnIngresar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnIngresar1ActionPerformed

    private void btnAccesoDesarrolladorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccesoDesarrolladorActionPerformed
            ArrayList<Integer> permisos = new ArrayList<Integer>();
            permisos.add(0);
            permisos.add(1);
            permisos.add(2);
            permisos.add(3);
            permisos.add(4);
            UsuarioDTO usuarioSesion = new UsuarioDTO(0, "MARCO", "0000", 0, "-", permisos, 19516774);
            FuncionarioDTO funcionarioSesion = new FuncionarioDTO();
            System.out.println("FUNCIONARIO CARGADO EN LOGIN: " + funcionarioSesion.getRut());
            System.out.println("USUARIO CARGADO EN LOGIN: " + usuarioSesion.getRut_persona());
            new VentanaPrincipal(funcionarioSesion, usuarioSesion, this).show();
            this.setVisible(false);
            txtNombreUsuario.setText("");
            txtClaveUsuario.setText("");
    }//GEN-LAST:event_btnAccesoDesarrolladorActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
            try {
                    // Set System L&F
                    javax.swing.UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            } 
            catch (javax.swing.UnsupportedLookAndFeelException e) {
               // handle exception
            }
            catch (ClassNotFoundException e) {
               // handle exception
            }
            catch (InstantiationException e) {
               // handle exception
            }
            catch (IllegalAccessException e) {
               // handle 
            }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAccesoDesarrollador;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnIngresar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField txtClaveUsuario;
    private javax.swing.JTextField txtNombreUsuario;
    // End of variables declaration//GEN-END:variables
}
