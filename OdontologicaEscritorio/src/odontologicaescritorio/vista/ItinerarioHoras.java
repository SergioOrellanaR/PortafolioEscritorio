/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odontologicaescritorio.vista;

import javax.swing.table.DefaultTableModel;
import odontologicaescritorio.controlador.*;
import odontologicaescritorio.modelo.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Marco Antonio
 */
public class ItinerarioHoras extends javax.swing.JInternalFrame {

    /**
     * Creates new form ItinerarioHoras
     */
    private int rutOdontologo;
    private String nombreOdontologo;    
    private int mes;
    private int ano;
    private int modoAcceso;
    private String matriz[][];
    
    //Modo acceso:
    //0 - Recepcionista
    //1 - Odontologo
    public ItinerarioHoras(int rutOdontologo, String nombreOdontologo, int mes, int ano, int modoAcceso) {
        initComponents();
        String meses[] = new String[]{"Indefinido", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        this.rutOdontologo = rutOdontologo;
        this.mes = mes;
        this.ano = ano;
        this.modoAcceso = modoAcceso;
        lblAno.setText(String.valueOf(ano));
        lblMes.setText(String.valueOf(mes));
        lblNombreMes.setText(meses[mes]);
        lblRutOdontologo.setText(String.valueOf(rutOdontologo));
        lblNombreOdontologo.setText(nombreOdontologo);
        
        cargarDatosItinerario();
        
        if(modoAcceso == 1){
            btnAgendarHora.setEnabled(false);
            btnCancelarHora.setEnabled(false);
        }
    }
    
    public void cargarDatosItinerario(){
        double totalHoras = new Hora().obtenerMaximoTotalHorasJornadaBD(mes, ano);
        ArrayList<DiaDTO> listaDias = new Hora().obtenerDiasPorFuncionario(rutOdontologo);
        ArrayList<HoraDTO> listaHoras = new Hora().obtenerHorasPorFuncionario(rutOdontologo, mes, ano);
        LocalTime[] limiteHoras = new Hora().obtenerMaximoLargoJornada(mes, ano);
        
        for(HoraDTO hora : listaHoras){
            System.out.println(hora.getFecha() + " " + hora.getHora());
        }
        
        matriz = new String[((int)totalHoras * 2) + 1 + 2] //Se deja espacio para la columna de horas.
                           [listaDias.size() + 1]; //Se deja espacio para la fila de días.
                                      
        //Definir cabecera de la tabla.
        String[] columnas;
        matriz[0][0] = "Hora";
        System.out.print(matriz[0][0]);
        
        //Llenar cabecera de días.
        for(int i = 0; i < listaDias.size(); i++){
            matriz[0][i + 1] = String.valueOf(listaDias.get(i).getDia().getDayOfMonth());
            System.out.print(" " + matriz[0][i + 1]);
        }
        System.out.println();
        //LLenar columna de horas.
        LocalTime contadorHoras = limiteHoras[0];
        for(int y = 1; y < (totalHoras*2) + 2; y++){ 
            matriz[y][0] = contadorHoras.toString();
            System.out.println(matriz[y][0]);
            contadorHoras = contadorHoras.plusMinutes(30);
        }
        
        for(int y = 0; y < matriz.length; y++){
            for(int x = 0; x < matriz[0].length; x++){
                for(HoraDTO hora : listaHoras){
                    if((String.valueOf(hora.getFecha().getDayOfMonth()).equals(matriz[0][x])) && (hora.getHora().toString().equals(matriz[y][0]))){
                        matriz[y][x] = "<html><body bgcolor='#00FF00'><b> " + hora.getId() + " </b></body></html>"; //Se deben dejar espacios en las etiquetas HTML, para poder extraer el ID con split.
                    }
                }
            }
        }
        
        //-- JTABLE NO TOCAR --
        
        columnas = matriz[0];
        
        DefaultTableModel modeloTabla = new DefaultTableModel(columnas, 0){
            //Modificamos la primera columna, de tal manera que:
            //No sea editable.
            @Override
            public boolean isCellEditable(int row, int column){
                if (0 == column)
                    return false;
                return super.isCellEditable(row, column);
            }                      
        };
        
        //Modificamos la primera columna, de tal manera que:
        //Parezca cabecera.   
        tblHorario.getColumnModel().getColumn(0).setCellRenderer(tblHorario.getTableHeader().getDefaultRenderer());  
        
        //Agrega las filas, excepto la primera, que contiene las cabeceras.
        for(int i = 1; i < matriz.length; i++ ){
            modeloTabla.addRow(matriz[i]);
        }
        
        //Finalizamos formateo de tabla
        tblHorario.setModel(modeloTabla);        
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHorario = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblRutOdontologo = new javax.swing.JLabel();
        lblNombreOdontologo = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblMes = new javax.swing.JLabel();
        lblAno = new javax.swing.JLabel();
        lblNombreMes = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        btnAgendarHora = new javax.swing.JButton();
        btnCancelarHora = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Asistente de agenda de horas");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/odontologicaescritorio/vista/img/icn_reloj.png"))); // NOI18N
        setMinimumSize(new java.awt.Dimension(900, 512));

        jPanel1.setBackground(new java.awt.Color(139, 156, 168));

        tblHorario.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        tblHorario.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblHorario);

        jPanel2.setBackground(new java.awt.Color(218, 210, 226));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel8.setBackground(new java.awt.Color(146, 128, 183));
        jLabel8.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/odontologicaescritorio/vista/img/icn_reloj.png"))); // NOI18N
        jLabel8.setText("Cronograma mensual de horas");
        jLabel8.setIconTextGap(0);
        jLabel8.setOpaque(true);

        jLabel1.setText("Funcionario:");

        lblRutOdontologo.setText("(RUT)");

        lblNombreOdontologo.setText("(NOMBRE)");

        jLabel4.setText("Mes:");

        jLabel5.setText("Año:");

        lblMes.setText("-");

        lblAno.setText("-");

        lblNombreMes.setText("(NOMBREMES)");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblAno))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblMes)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblNombreMes))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblRutOdontologo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblNombreOdontologo)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblMes)
                    .addComponent(lblNombreMes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblAno))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblRutOdontologo)
                    .addComponent(lblNombreOdontologo))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(218, 210, 226));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel9.setBackground(new java.awt.Color(146, 128, 183));
        jLabel9.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/odontologicaescritorio/vista/img/icn_pc.png"))); // NOI18N
        jLabel9.setText("Centro de acciones");
        jLabel9.setIconTextGap(0);
        jLabel9.setOpaque(true);

        btnAgendarHora.setIcon(new javax.swing.ImageIcon(getClass().getResource("/odontologicaescritorio/vista/img/icn_agregar.png"))); // NOI18N
        btnAgendarHora.setText("Agendar una nueva hora");
        btnAgendarHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgendarHoraActionPerformed(evt);
            }
        });

        btnCancelarHora.setIcon(new javax.swing.ImageIcon(getClass().getResource("/odontologicaescritorio/vista/img/icn_cancelar.png"))); // NOI18N
        btnCancelarHora.setText("Cancelar una hora");
        btnCancelarHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarHoraActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/odontologicaescritorio/vista/img/icn_cargarficha.png"))); // NOI18N
        jButton3.setText("Exportar cronograma a EXCEL");

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/odontologicaescritorio/vista/img/icn_ver.png"))); // NOI18N
        jButton4.setText("Ver hora seleccionada");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAgendarHora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCancelarHora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 124, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgendarHora)
                    .addComponent(btnCancelarHora))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                .addContainerGap())
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

    private void btnAgendarHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgendarHoraActionPerformed
        // TODO add your handling code here:        
        int x = tblHorario.getSelectedColumn();
        int y = tblHorario.getSelectedRow();
        if(matriz[y+1][x] == null && x > -1 && y > -1){
            int dia = Integer.parseInt(matriz[0][x]);
            LocalTime hora = LocalTime.parse(matriz[y+1][0]);
            LocalDate fecha = LocalDate.of(ano, mes, dia);
            AgendarHora agendarHora = new AgendarHora(fecha, hora, this, Integer.parseInt(lblRutOdontologo.getText()), lblNombreOdontologo.getText());
            javax.swing.JDesktopPane panelEscritorio = this.getDesktopPane();
            panelEscritorio.add(agendarHora);
            agendarHora.setVisible(true);            
        }else{
            JOptionPane.showMessageDialog(rootPane, "Esta hora ya esta ocupada.\nSi desea agendar otra hora acá, debe primero eliminar la hora seleccionada.", "Hora ocupada", HEIGHT);
        }

    }//GEN-LAST:event_btnAgendarHoraActionPerformed

    private void btnCancelarHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarHoraActionPerformed
        // TODO add your handling code here:
        int x = tblHorario.getSelectedColumn();
        int y = tblHorario.getSelectedRow();
        if(matriz[y+1][x] != null && x > -1 && y > -1){
            int idHora = Integer.parseInt(matriz[y+1][x].split(" ")[2]); //Debemos hacer split, porque en la matriz está guardado el formateo HTML.
            int dialogResult = JOptionPane.showConfirmDialog(rootPane, "¿Está seguro de que desea eliminar la hora seleccionada?", "Confirmar eliminación", WIDTH);
            if(dialogResult == JOptionPane.YES_OPTION){
              JOptionPane.showMessageDialog(rootPane, new Eliminacion().eliminarHora(idHora), "Eliminación de hora", HEIGHT);
              cargarDatosItinerario();
            }            
        }else{
            JOptionPane.showMessageDialog(rootPane, "Para cancelar una hora, seleccione una celda que no esté vacía.", "Hora vacía", HEIGHT);
        }       
    }//GEN-LAST:event_btnCancelarHoraActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        int fila = tblHorario.getSelectedRow();
        int columa = tblHorario.getSelectedColumn();
        int idHora = Integer.valueOf(String.valueOf(tblHorario.getValueAt(fila, columa)).split(" ")[2]);
        String hora = String.valueOf(tblHorario.getValueAt(fila, 0));
        int dia = Integer.parseInt(tblHorario.getColumnName(columa));
        javax.swing.JDesktopPane panelEscritorio = this.getDesktopPane();
        VerHora verHora = new VerHora(idHora, dia ,mes, ano, hora);
        panelEscritorio.add(verHora);
        verHora.setVisible(true);           
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgendarHora;
    private javax.swing.JButton btnCancelarHora;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAno;
    private javax.swing.JLabel lblMes;
    private javax.swing.JLabel lblNombreMes;
    private javax.swing.JLabel lblNombreOdontologo;
    private javax.swing.JLabel lblRutOdontologo;
    private javax.swing.JTable tblHorario;
    // End of variables declaration//GEN-END:variables
}
