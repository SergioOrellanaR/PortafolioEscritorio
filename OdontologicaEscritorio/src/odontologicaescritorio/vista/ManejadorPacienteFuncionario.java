/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odontologicaescritorio.vista;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import odontologicaescritorio.controlador.*;
import odontologicaescritorio.modelo.*;

/**
 *
 * @author Marco Antonio
 */
public class ManejadorPacienteFuncionario extends javax.swing.JInternalFrame {

    /**
     * Creates new form ManejadorPacienteFuncionario
     */
    private ArrayList<PacienteDTO> listaPacientes;
    private ArrayList<FuncionarioDTO> listaFuncionarios;
    private ArrayList<BitacoraDTO> listaBitacoras;
    private int nivelAcceso;
    private int modoManejador;
    private int nivelVulnerabilidad = 25;
    private FuncionarioDTO funcionarioSesion;
    private int rutPacienteCargado;
    
    //modoManejador determina qué tipo de persona se está manejando:
    // 0 - Se están manejando personas de tipo funcionario.
    // 1 - Se están manejando personas de tipo paciente.
    public ManejadorPacienteFuncionario(int nivelAcceso, int modoManejador, FuncionarioDTO funcionarioSesion) {
        initComponents();
        poblarCboCiudades();
        poblarCboComunas();
        this.funcionarioSesion = funcionarioSesion;
        
        this.nivelAcceso = nivelAcceso;
        this.modoManejador = modoManejador;
        
        switch(nivelAcceso){
            case 0:
                btnEditarDatosPaciente.setVisible(true);
                break;
            case 1:
                btnRegistrarPaciente.setVisible(false);
                btnEditarDatosPaciente.setVisible(false);
                btnIngresarBitacora.setEnabled(true);
                break;
            case 2:
                btnEditarDatosPaciente.setVisible(true);
                btnModificar.setEnabled(true);
                break;
            case 3:
                this.dispose();
                break;  
            case 4:
                this.dispose();
                break;                
        }
        
        switch(modoManejador){
            case 0:
                lblListaPersonas.setText("Lista de funcionarios");
                btnRegistrarPaciente.setText("Registrar nuevo funcionario");
                tbDatosPersonas.remove(1);
                tbDatosPersonas.remove(1);
                this.setTitle("Manejo de funcionarios");
                actualizarListaFuncionarios();
                break;
            case 1:
                lblListaPersonas.setText("Lista de pacientes");
                btnRegistrarPaciente.setText("Registrar nuevo paciente");
                lblTipoFuncionario.setVisible(false);
                cboTipoFuncionario.setVisible(false);
                this.setTitle("Manejo de pacientes");
                actualizarListaPacientes();
                break;
        }
    }
    
    public void poblarCboCiudades(){
        for(CiudadDTO ciudad : new Lista().listarCiudades()){
            cboCiudad.addItem(ciudad.getIdNombre());
        }        
    }
    
    public void poblarCboComunas(){
        int idCiudad = Integer.parseInt(String.valueOf(cboCiudad.getSelectedItem()).split(" ")[0]);
        for(ComunaDTO comuna : new Lista().listarComunas(idCiudad)){
            cboComuna.addItem(comuna.getIdNombre());
        }
    }
    
    public void actualizarListaPacientes(){
        listaPacientes = new Lista().listarPacientes();
        String[] columnas = {"RUT","Nombres", "Apellidos"};
        DefaultTableModel modeloTabla = new DefaultTableModel(columnas, 0);
        
        for(PacienteDTO paciente : listaPacientes){
            String rut      = paciente.getRut() + "-" + paciente.getDv();
            String nombre   = paciente.getP_nombre() + " " + paciente.getS_nombre();
            String apellido = paciente.getP_apellido() + " " + paciente.getS_apellido();
            Object[] elemento = {rut, nombre, apellido};
            modeloTabla.addRow(elemento);
        };
        tblPacientes.setModel(modeloTabla);
    }
    
    public void actualizarListaFuncionarios(){
        listaFuncionarios = new Lista().listarFuncionarios();
        String[] columnas = {"RUT","Nombres", "Apellidos"};
        DefaultTableModel modeloTabla = new DefaultTableModel(columnas, 0);
        
        for(FuncionarioDTO funcionario : listaFuncionarios){
            String rut      = funcionario.getRut() + "-" + funcionario.getDv();
            String nombre   = funcionario.getP_nombre() + " " + funcionario.getS_nombre();
            String apellido = funcionario.getP_apellido() + " " + funcionario.getS_apellido();
            Object[] elemento = {rut, nombre, apellido};
            modeloTabla.addRow(elemento);
        };
        tblPacientes.setModel(modeloTabla);        
    };
    
    public void actualizarBitacoras(int rutPaciente){
        listaBitacoras = new Lista().listaBitacorasPorRut(rutPaciente);
        String[] columnas = {"Fecha", "Descripcion"};
        DefaultTableModel modeloTabla = new DefaultTableModel(columnas, 0);
        
        for(BitacoraDTO bitacora : listaBitacoras){
            String fecha         = bitacora.getFecha().toString();
            String descripcion   = bitacora.getDescripcion();
            Object[] elemento    = {fecha, descripcion};
            modeloTabla.addRow(elemento);
        };
        tblBitacoras.setModel(modeloTabla);        
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
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPacientes = new javax.swing.JTable();
        txtRutBusqueda = new javax.swing.JTextField();
        btnBuscarRUT = new javax.swing.JButton();
        btnCargarFichaPaciente = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        btnRegistrarPaciente = new javax.swing.JButton();
        lblListaPersonas = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        tbDatosPersonas = new javax.swing.JTabbedPane();
        pnlDatosPaciente = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtPNombre = new javax.swing.JTextField();
        txtSNombre = new javax.swing.JTextField();
        txtPApellido = new javax.swing.JTextField();
        txtSApellido = new javax.swing.JTextField();
        txtRUT = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        cboDv = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnEditarDatosPaciente = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        cboSexo = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        cboComuna = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        cboCiudad = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        txtDia = new javax.swing.JTextField();
        cboMes = new javax.swing.JComboBox<>();
        txtAno = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        lblTipoFuncionario = new javax.swing.JLabel();
        cboTipoFuncionario = new javax.swing.JComboBox<>();
        lblModo = new javax.swing.JLabel();
        pnlBitacoraPaciente = new javax.swing.JPanel();
        txtBitacora = new javax.swing.JTextField();
        lblListaPersonas1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBitacoras = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        btnVerBitacora = new javax.swing.JButton();
        btnIngresarBitacora = new javax.swing.JButton();
        lblIdBitacora = new javax.swing.JLabel();
        lblFunBitacora = new javax.swing.JLabel();
        lblFechaBitacora = new javax.swing.JLabel();
        pnlSocioeconomica = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        barVulnerabilidad = new javax.swing.JProgressBar();
        jLabel14 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        spnVulnerabilidad = new javax.swing.JSpinner();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Manejo de personas");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/odontologicaescritorio/vista/img/icn_persona.png"))); // NOI18N
        setNormalBounds(new java.awt.Rectangle(0, 0, 0, 0));

        jPanel1.setBackground(new java.awt.Color(139, 156, 168));
        jPanel1.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 0));

        jPanel6.setBackground(new java.awt.Color(218, 210, 226));
        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel6.setPreferredSize(new java.awt.Dimension(480, 461));

        tblPacientes.setBackground(new java.awt.Color(255, 255, 153));
        tblPacientes.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblPacientes);

        btnBuscarRUT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/odontologicaescritorio/vista/img/icn_buscar.png"))); // NOI18N
        btnBuscarRUT.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnBuscarRUT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarRUTActionPerformed(evt);
            }
        });

        btnCargarFichaPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/odontologicaescritorio/vista/img/icn_cargarficha.png"))); // NOI18N
        btnCargarFichaPaciente.setText("Cargar ficha");
        btnCargarFichaPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarFichaPacienteActionPerformed(evt);
            }
        });

        jLabel13.setBackground(new java.awt.Color(146, 128, 183));
        jLabel13.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Centro de acciones");
        jLabel13.setOpaque(true);

        btnRegistrarPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/odontologicaescritorio/vista/img/icn_agregar.png"))); // NOI18N
        btnRegistrarPaciente.setText("Registrar");
        btnRegistrarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarPacienteActionPerformed(evt);
            }
        });

        lblListaPersonas.setBackground(new java.awt.Color(146, 128, 183));
        lblListaPersonas.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        lblListaPersonas.setForeground(new java.awt.Color(255, 255, 255));
        lblListaPersonas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/odontologicaescritorio/vista/img/icn_persona.png"))); // NOI18N
        lblListaPersonas.setText("Lista de personas");
        lblListaPersonas.setOpaque(true);

        jLabel32.setBackground(new java.awt.Color(204, 255, 204));
        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/odontologicaescritorio/vista/img/icn_lupa.png"))); // NOI18N
        jLabel32.setText("Buscar por RUT (Ingrese sin DV):");
        jLabel32.setIconTextGap(0);
        jLabel32.setOpaque(true);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblListaPersonas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtRutBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarRUT, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnCargarFichaPaciente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRegistrarPaciente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblListaPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarRUT)
                    .addComponent(txtRutBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCargarFichaPaciente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegistrarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tbDatosPersonas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tbDatosPersonas.setOpaque(true);

        pnlDatosPaciente.setBackground(new java.awt.Color(218, 210, 226));
        pnlDatosPaciente.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Nombres:");

        txtPNombre.setEditable(false);

        txtSNombre.setEditable(false);
        txtSNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSNombreActionPerformed(evt);
            }
        });

        txtPApellido.setEditable(false);

        txtSApellido.setEditable(false);

        txtRUT.setEditable(false);

        txtTelefono.setEditable(false);

        cboDv.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "K" }));
        cboDv.setEnabled(false);

        jLabel3.setText("RUT y digito verificador:");

        txtEmail.setEditable(false);

        jLabel4.setText("Teléfono de contacto:");

        jLabel5.setText("Correo electrónico:");

        btnEditarDatosPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/odontologicaescritorio/vista/img/icn_editar.png"))); // NOI18N
        btnEditarDatosPaciente.setText("Editar datos personales");
        btnEditarDatosPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarDatosPacienteActionPerformed(evt);
            }
        });

        jLabel6.setText("Sexo:");

        cboSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M - Masculino", "F - Femenino", "X - No binario" }));
        cboSexo.setEnabled(false);

        jLabel7.setBackground(new java.awt.Color(146, 128, 183));
        jLabel7.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/odontologicaescritorio/vista/img/icn_mapa.png"))); // NOI18N
        jLabel7.setText("Dirección");
        jLabel7.setIconTextGap(0);
        jLabel7.setOpaque(true);

        jLabel8.setBackground(new java.awt.Color(146, 128, 183));
        jLabel8.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/odontologicaescritorio/vista/img/icn_persona.png"))); // NOI18N
        jLabel8.setText("Datos generales");
        jLabel8.setIconTextGap(0);
        jLabel8.setOpaque(true);

        jLabel9.setBackground(new java.awt.Color(146, 128, 183));
        jLabel9.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/odontologicaescritorio/vista/img/icn_dialogo.png"))); // NOI18N
        jLabel9.setText("Datos de contacto");
        jLabel9.setIconTextGap(0);
        jLabel9.setOpaque(true);

        jLabel10.setText("Dirección:");

        txtDireccion.setEditable(false);

        jLabel11.setText("Comuna:");

        cboComuna.setEnabled(false);

        jLabel12.setText("-");

        jLabel15.setText("Apellidos:");

        jLabel16.setText("Comuna:");

        cboCiudad.setEnabled(false);

        jLabel17.setText("Fecha de nacimiento:");

        txtDia.setEditable(false);

        cboMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01 - Enero", "02 - Febrero", "03 - Marzo", "04 - Abril", "05 - Mayo", "06 - Junio", "07 - Julio", "08 - Agosto", "09 - Septiembre", "10 - Octubre", "11 - Noviembre", "12 - Diciembre" }));
        cboMes.setEnabled(false);

        txtAno.setEditable(false);

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/odontologicaescritorio/vista/img/icn_cancelar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setEnabled(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblTipoFuncionario.setText("Tipo de funcionario:");

        cboTipoFuncionario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0 - ADMINISTRADOR", "1 - ODONTÓLOGO", "3 - RECEPCIONISTA", "4 - BODEGUERO" }));
        cboTipoFuncionario.setEnabled(false);

        lblModo.setBackground(new java.awt.Color(204, 255, 204));
        lblModo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/odontologicaescritorio/vista/img/icn_ver.png"))); // NOI18N
        lblModo.setText("Usted está en modo vista.");
        lblModo.setOpaque(true);

        javax.swing.GroupLayout pnlDatosPacienteLayout = new javax.swing.GroupLayout(pnlDatosPaciente);
        pnlDatosPaciente.setLayout(pnlDatosPacienteLayout);
        pnlDatosPacienteLayout.setHorizontalGroup(
            pnlDatosPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosPacienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDatosPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDatosPacienteLayout.createSequentialGroup()
                        .addGroup(pnlDatosPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlDatosPacienteLayout.createSequentialGroup()
                                .addGroup(pnlDatosPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(pnlDatosPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboComuna, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(233, 233, 233))
                    .addGroup(pnlDatosPacienteLayout.createSequentialGroup()
                        .addGroup(pnlDatosPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(lblTipoFuncionario))
                        .addGap(18, 18, 18)
                        .addGroup(pnlDatosPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlDatosPacienteLayout.createSequentialGroup()
                                .addComponent(txtDia, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboMes, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAno, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cboTipoFuncionario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(72, 72, 72))
                    .addGroup(pnlDatosPacienteLayout.createSequentialGroup()
                        .addGroup(pnlDatosPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(pnlDatosPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel10)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(pnlDatosPacienteLayout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtRUT, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel12)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cboDv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(pnlDatosPacienteLayout.createSequentialGroup()
                                    .addGroup(pnlDatosPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel15))
                                    .addGap(74, 74, 74)
                                    .addGroup(pnlDatosPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtPApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtPNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cboSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(pnlDatosPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtSNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtSApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
                                .addGroup(pnlDatosPacienteLayout.createSequentialGroup()
                                    .addGroup(pnlDatosPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel5))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(pnlDatosPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(pnlDatosPacienteLayout.createSequentialGroup()
                                    .addComponent(btnEditarDatosPaciente)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlDatosPacienteLayout.createSequentialGroup()
                        .addComponent(lblModo, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        pnlDatosPacienteLayout.setVerticalGroup(
            pnlDatosPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDatosPacienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblModo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDatosPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtRUT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboDv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDatosPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDatosPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtPApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDatosPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cboSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDatosPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(cboMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDatosPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipoFuncionario)
                    .addComponent(cboTipoFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDatosPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDatosPacienteLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(4, 4, 4)
                        .addComponent(cboComuna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlDatosPacienteLayout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(4, 4, 4)
                        .addComponent(cboCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addGap(4, 4, 4)
                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDatosPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDatosPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDatosPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditarDatosPaciente)
                    .addComponent(btnCancelar))
                .addContainerGap(76, Short.MAX_VALUE))
        );

        tbDatosPersonas.addTab("Datos de la persona", pnlDatosPaciente);

        pnlBitacoraPaciente.setBackground(new java.awt.Color(218, 210, 226));
        pnlBitacoraPaciente.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblListaPersonas1.setBackground(new java.awt.Color(146, 128, 183));
        lblListaPersonas1.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        lblListaPersonas1.setForeground(new java.awt.Color(255, 255, 255));
        lblListaPersonas1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/odontologicaescritorio/vista/img/icn_dialogo.png"))); // NOI18N
        lblListaPersonas1.setText("Bitácora de atenciones");
        lblListaPersonas1.setOpaque(true);

        tblBitacoras.setBackground(new java.awt.Color(204, 255, 204));
        tblBitacoras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Descripcion"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblBitacoras);

        jLabel1.setText("ID:");

        jLabel21.setText("Funcionario:");

        jLabel23.setText("Fecha:");

        btnVerBitacora.setIcon(new javax.swing.ImageIcon(getClass().getResource("/odontologicaescritorio/vista/img/icn_ver.png"))); // NOI18N
        btnVerBitacora.setText("Ver");
        btnVerBitacora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerBitacoraActionPerformed(evt);
            }
        });

        btnIngresarBitacora.setIcon(new javax.swing.ImageIcon(getClass().getResource("/odontologicaescritorio/vista/img/icn_agregar.png"))); // NOI18N
        btnIngresarBitacora.setText("Ingresar");
        btnIngresarBitacora.setEnabled(false);
        btnIngresarBitacora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarBitacoraActionPerformed(evt);
            }
        });

        lblIdBitacora.setText("---");

        lblFunBitacora.setText("---");

        lblFechaBitacora.setText("---");

        javax.swing.GroupLayout pnlBitacoraPacienteLayout = new javax.swing.GroupLayout(pnlBitacoraPaciente);
        pnlBitacoraPaciente.setLayout(pnlBitacoraPacienteLayout);
        pnlBitacoraPacienteLayout.setHorizontalGroup(
            pnlBitacoraPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBitacoraPacienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBitacoraPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblListaPersonas1, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
                    .addComponent(txtBitacora)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(pnlBitacoraPacienteLayout.createSequentialGroup()
                        .addGroup(pnlBitacoraPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlBitacoraPacienteLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblIdBitacora))
                            .addGroup(pnlBitacoraPacienteLayout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblFunBitacora))
                            .addGroup(pnlBitacoraPacienteLayout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblFechaBitacora))
                            .addGroup(pnlBitacoraPacienteLayout.createSequentialGroup()
                                .addComponent(btnVerBitacora)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnIngresarBitacora)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlBitacoraPacienteLayout.setVerticalGroup(
            pnlBitacoraPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBitacoraPacienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblListaPersonas1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlBitacoraPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblIdBitacora))
                .addGap(3, 3, 3)
                .addGroup(pnlBitacoraPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(lblFunBitacora))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlBitacoraPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(lblFechaBitacora))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBitacora, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlBitacoraPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVerBitacora)
                    .addComponent(btnIngresarBitacora))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                .addContainerGap())
        );

        tbDatosPersonas.addTab("Bitácora de atenciones", pnlBitacoraPaciente);

        pnlSocioeconomica.setBackground(new java.awt.Color(218, 210, 226));
        pnlSocioeconomica.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel3.setBackground(new java.awt.Color(153, 153, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        barVulnerabilidad.setForeground(new java.awt.Color(153, 0, 255));
        barVulnerabilidad.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        barVulnerabilidad.setStringPainted(true);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(barVulnerabilidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(barVulnerabilidad, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel14.setText("Escala de vulnerabilidad:");

        jLabel18.setBackground(new java.awt.Color(146, 128, 183));
        jLabel18.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/odontologicaescritorio/vista/img/icn_persona.png"))); // NOI18N
        jLabel18.setText("Situación socioeconómica");
        jLabel18.setIconTextGap(0);
        jLabel18.setOpaque(true);

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/odontologicaescritorio/vista/img/icn_avanzar.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setEnabled(false);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        spnVulnerabilidad.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));

        jLabel19.setText("%");

        jLabel20.setText("Cambiar escala de vulnerabilidad:");

        jPanel4.setBackground(new java.awt.Color(204, 255, 204));

        jLabel22.setBackground(new java.awt.Color(204, 255, 204));
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/odontologicaescritorio/vista/img/icn_informacion.png"))); // NOI18N
        jLabel22.setText("<html><b>Acerca de la escala de vulnerabilidad:</b><br>La escala de vulnerabilidad índica el porcentaje de descuento que se aplicará<br>sobre los servicios entregados a un cliente.</html>");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlSocioeconomicaLayout = new javax.swing.GroupLayout(pnlSocioeconomica);
        pnlSocioeconomica.setLayout(pnlSocioeconomicaLayout);
        pnlSocioeconomicaLayout.setHorizontalGroup(
            pnlSocioeconomicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSocioeconomicaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSocioeconomicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSocioeconomicaLayout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(spnVulnerabilidad, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlSocioeconomicaLayout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlSocioeconomicaLayout.setVerticalGroup(
            pnlSocioeconomicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSocioeconomicaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlSocioeconomicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificar)
                    .addComponent(spnVulnerabilidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(290, Short.MAX_VALUE))
        );

        tbDatosPersonas.addTab("Situación socioeconómica", pnlSocioeconomica);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tbDatosPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tbDatosPersonas)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 944, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCargarFichaPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarFichaPacienteActionPerformed
        // TODO add your handling code here:
        int fila = tblPacientes.getSelectedRow();
        int rut  = Integer.parseInt(String.valueOf(tblPacientes.getValueAt(fila, 0)).split("-")[0]);
        switch(modoManejador){
            case 0:
                for(FuncionarioDTO funcionario : listaFuncionarios){
                    if(funcionario.getRut() == rut){
                        txtRUT.setText(String.valueOf(funcionario.getRut()));
                        cboDv.setSelectedItem(String.valueOf(funcionario.getDv()));
                        txtPNombre.setText(funcionario.getP_nombre());
                        txtSNombre.setText(funcionario.getS_nombre());
                        txtPApellido.setText(funcionario.getP_apellido());
                        txtSApellido.setText(funcionario.getS_apellido());
                        txtTelefono.setText(String.valueOf(funcionario.getTelefono()));
                        txtEmail.setText(funcionario.getEmail());
                        txtDireccion.setText(funcionario.getDireccion());
                        cboComuna.setSelectedItem(funcionario.getComuna());
                        if(funcionario.getSexo() == 'M' || funcionario.getSexo() == 'm') cboSexo.setSelectedIndex(0);
                        if(funcionario.getSexo() == 'F' || funcionario.getSexo() == 'f') cboSexo.setSelectedIndex(1);
                        if(funcionario.getSexo() != 'M' && funcionario.getSexo() != 'm' && funcionario.getSexo() != 'F' && funcionario.getSexo() != 'f') cboSexo.setSelectedIndex(3);
                        //Obtener la fecha de nacimiento
                        txtDia.setText(String.valueOf(funcionario.getF_nacimiento().getDayOfMonth()));
                        txtAno.setText(String.valueOf(funcionario.getF_nacimiento().getYear()));
                        cboMes.setSelectedIndex(funcionario.getF_nacimiento().getMonthValue() - 1);
                    }
                }
                break;            
            case 1:
                for(PacienteDTO paciente : listaPacientes){
                    if(paciente.getRut() == rut){
                        txtRUT.setText(String.valueOf(paciente.getRut()));
                        cboDv.setSelectedItem(String.valueOf(paciente.getDv()));
                        txtPNombre.setText(paciente.getP_nombre());
                        txtSNombre.setText(paciente.getS_nombre());
                        txtPApellido.setText(paciente.getP_apellido());
                        txtSApellido.setText(paciente.getS_apellido());
                        txtTelefono.setText(String.valueOf(paciente.getTelefono()));
                        txtEmail.setText(paciente.getEmail());
                        cboComuna.setSelectedItem(paciente.getComuna());
                        txtDireccion.setText(paciente.getDireccion());
                        if(paciente.getSexo() == 'M' || paciente.getSexo() == 'm') cboSexo.setSelectedIndex(0);
                        if(paciente.getSexo() == 'F' || paciente.getSexo() == 'f') cboSexo.setSelectedIndex(1);
                        if(paciente.getSexo() != 'M' && paciente.getSexo() != 'm' && paciente.getSexo() != 'F' && paciente.getSexo() != 'f') cboSexo.setSelectedIndex(3);
                        //Obtener la fecha de nacimiento
                        txtDia.setText(String.valueOf(paciente.getF_nacimiento().getDayOfMonth()));
                        txtAno.setText(String.valueOf(paciente.getF_nacimiento().getYear()));
                        cboMes.setSelectedIndex(paciente.getF_nacimiento().getMonthValue() - 1);
                        //Actualizar índice de vulnerabilidad
                        barVulnerabilidad.setValue(paciente.getVulnerable());
                        //Cargar bitacora.
                        actualizarBitacoras(paciente.getRut());
                        this.rutPacienteCargado = paciente.getRut();
                    }
                }
                break;
        }        
    }//GEN-LAST:event_btnCargarFichaPacienteActionPerformed

    private void btnRegistrarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarPacienteActionPerformed
        RegistroPacienteFuncionario ventanaRegistro;
        JDesktopPane panelEscritorio;
        
        switch(modoManejador){
            case 0:
                ventanaRegistro = new RegistroPacienteFuncionario(0);
                panelEscritorio = this.getDesktopPane();
                panelEscritorio.add(ventanaRegistro);
                ventanaRegistro.setVisible(true);
                break;
            case 1:
                ventanaRegistro = new RegistroPacienteFuncionario(1);
                panelEscritorio = this.getDesktopPane();
                panelEscritorio.add(ventanaRegistro);
                ventanaRegistro.setVisible(true);
                break;
        }        
    }//GEN-LAST:event_btnRegistrarPacienteActionPerformed
    
    boolean estaEditando = false;
    private boolean validarFormularios(){
        if(txtRUT.getText().length() == 0){
            JOptionPane.showMessageDialog(rootPane, "El RUT no puede estar vacío.", "Ha ingresado mal un dato", HEIGHT);
            return false;
        }
        try{
            Integer.parseInt(txtRUT.getText());
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, "El campo de RUT solo admite números.", "Ha ingresado mal un dato", HEIGHT);
            return false;            
        }
        if(txtPNombre.getText().length() == 0){
            JOptionPane.showMessageDialog(rootPane, "El primer nombre no debe estar vacío.", "Ha ingresado mal un dato", HEIGHT);
            return false;
        }
        if(txtPApellido.getText().length() == 0){
            JOptionPane.showMessageDialog(rootPane, "El primer apellido no debe estar vacío.", "Ha ingresado mal un dato", HEIGHT);
            return false;
        }      
        if(txtDireccion.getText().length() == 0){
            JOptionPane.showMessageDialog(rootPane, "La dirección no debe estar vacía.", "Ha ingresado mal un dato", HEIGHT);
            return false;
        }   
        if(txtTelefono.getText().length() == 0){
            JOptionPane.showMessageDialog(rootPane, "El teléfono no debe estar vacío.", "Ha ingresado mal un dato", HEIGHT);
            return false;
        }
        try{
            Integer.parseInt(txtTelefono.getText());
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, "El campo de Teléfono solo admite números.", "Ha ingresado mal un dato", HEIGHT);
            return false;            
        }        
        if(txtDia.getText().length() == 0){
            JOptionPane.showMessageDialog(rootPane, "El día de nacimiento no debe estar vacío.", "Ha ingresado mal un dato", HEIGHT);
            return false;
        }
        if(txtAno.getText().length() == 0){
            JOptionPane.showMessageDialog(rootPane, "El año de nacimiento no debe estar vacío.", "Ha ingresado mal un dato", HEIGHT);
            return false;
        }
        if(!validarFecha()){
            JOptionPane.showMessageDialog(rootPane, "La fecha que usted ha ingresado es inválida", "Ha ingresado mal un dato", HEIGHT);
            return false;            
        }
        return true;          
    }
    
    private boolean validarFecha(){
        int dia;
        int ano;
        int mes = Integer.parseInt(String.valueOf(cboMes.getSelectedItem()).substring(0, 2));
        boolean biciesto = false;
        int anoActual = java.time.Year.now().getValue();
        
        try{
            dia = Integer.parseInt(txtDia.getText());
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, "El día de nacimiento debe ser un número", "Ha ingresado mal un dato", HEIGHT);
            return false;            
        }
        try{
            ano = Integer.parseInt(txtAno.getText());
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, "El año de nacimiento debe ser un número", "Ha ingresado mal un dato", HEIGHT);
            return false;            
        }
        
        //Validamos que el año sea menor al año actual.
        if(ano > anoActual){
            return false;
        }
        
        //Validamos que el año sea biciesto.
        if((ano % 400) == 0){
            biciesto = true;
        }else{
            if((ano % 100) != 0 && (ano % 4) == 0){
                biciesto = true;
            }
        }
        
        //Validamos que los días sean coherentes con el mes.
        if(mes == 1 || mes == 3 || mes == 5|| mes == 7|| mes == 8|| mes == 10|| mes == 12){
            if(dia >= 1 && dia <= 31){
                return true;
            }
        }else{
            if(mes == 4 || mes == 6 || mes == 9|| mes == 11){
                if(dia >= 1 && dia <= 30){
                    return true;
                }                
            }else{
                if(mes == 2){
                    if(biciesto && (dia >= 1 && dia <= 29)) return true;
                    if(!biciesto && (dia >= 1 && dia <= 28)) return true;
                }
            }
        }
        return false;
    }
    
    private void btnBuscarRUTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarRUTActionPerformed
        int rutBuscar = Integer.parseInt(txtRutBusqueda.getText());
        for(int i = 0; i < tblPacientes.getRowCount(); i++){
            int rutSeleccionado  = Integer.parseInt(String.valueOf(tblPacientes.getValueAt(i, 0)).split("-")[0]);
            if(rutSeleccionado == rutBuscar){
                tblPacientes.setRowSelectionInterval(i, i);
                JOptionPane.showMessageDialog(rootPane, "Se ha encontrado y seleccionado la incidencia.", "Paciente encontrado", WIDTH);
                return;
            }
        }
        JOptionPane.showMessageDialog(rootPane, "La busqueda no arrojó resultados.", "Paciente no encontrado", WIDTH);
    }//GEN-LAST:event_btnBuscarRUTActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        barVulnerabilidad.setValue(Integer.parseInt(spnVulnerabilidad.getValue().toString()));
        JOptionPane.showMessageDialog(rootPane, new Actualizacion().actualizarVulnerabilidadPaciente(Integer.parseInt(txtRUT.getText()), Integer.parseInt(spnVulnerabilidad.getValue().toString())), "Actualización de estado de vulnerabilidad", HEIGHT);
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEditarDatosPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarDatosPacienteActionPerformed
        // TODO add your handling code here:
        if(!estaEditando){
            btnCancelar.setEnabled(true);
            lblModo.setText("Usted está en modo edición.");
            lblModo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/odontologicaescritorio/vista/img/icn_editar.png")));
            estaEditando = true;
            txtRUT.setEditable(true);
            txtPNombre.setEditable(true);
            txtSNombre.setEditable(true);
            txtPApellido.setEditable(true);
            txtSApellido.setEditable(true);
            txtDireccion.setEditable(true);
            txtTelefono.setEditable(true);
            txtEmail.setEditable(true);
            cboMes.setEnabled(true);
            cboCiudad.setEnabled(true);
            cboTipoFuncionario.setEnabled(true);
            cboComuna.setEnabled(true);
            cboSexo.setEnabled(true);
            cboDv.setEnabled(true);
            btnRegistrarPaciente.setEnabled(false);
            btnCargarFichaPaciente.setEnabled(false);
            tblPacientes.setEnabled(false);
            btnBuscarRUT.setEnabled(false);
            txtRutBusqueda.setEditable(false);
            btnEditarDatosPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/odontologicaescritorio/vista/img/icn_guardar.png")));
            btnEditarDatosPaciente.setText("Guardar cambios");
        }else{
            if(validarFormularios()){
                JOptionPane.showMessageDialog(rootPane, "Se han actualizado correctamente los datos del paciente.", "Registro completado", HEIGHT);
            }

        }
    }//GEN-LAST:event_btnEditarDatosPacienteActionPerformed

    private void txtSNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSNombreActionPerformed

    private void btnVerBitacoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerBitacoraActionPerformed
        int fila = tblBitacoras.getSelectedRow();
        BitacoraDTO bitacoraVista = listaBitacoras.get(fila);
        txtBitacora.setText(bitacoraVista.getDescripcion());
        lblFechaBitacora.setText(bitacoraVista.getFecha().toString());
        lblFunBitacora.setText(String.valueOf(bitacoraVista.getRutFuncionario()));
        lblIdBitacora.setText(String.valueOf(bitacoraVista.getId()));
    }//GEN-LAST:event_btnVerBitacoraActionPerformed

    private void btnIngresarBitacoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarBitacoraActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(rootPane, new Registro().registrarBitacoraoBD(txtBitacora.getText(), LocalDate.now(), funcionarioSesion.getRut(), rutPacienteCargado), "Registro de bitácoras", HEIGHT);
    }//GEN-LAST:event_btnIngresarBitacoraActionPerformed
    

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        estaEditando = false;
        lblModo.setText("Usted está en modo vista.");
        lblModo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/odontologicaescritorio/vista/img/icn_ver.png")));
        estaEditando = false;
        txtRUT.setEditable(false);
        txtPNombre.setEditable(false);
        txtSNombre.setEditable(false);
        txtPApellido.setEditable(false);
        txtSApellido.setEditable(false);
        txtDireccion.setEditable(false);
        txtTelefono.setEditable(false);
        txtEmail.setEditable(false);
        cboMes.setEnabled(false);
        cboTipoFuncionario.setEnabled(false);
        cboCiudad.setEnabled(false);
        cboComuna.setEnabled(false);
        cboSexo.setEnabled(false);
        cboDv.setEnabled(false);
        btnBuscarRUT.setEnabled(true);
        txtRutBusqueda.setEditable(true);
        btnEditarDatosPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/odontologicaescritorio/vista/img/icn_editar.png")));
        btnEditarDatosPaciente.setText("Editar datos personales");
        btnRegistrarPaciente.setEnabled(true);
        btnCargarFichaPaciente.setEnabled(true);
        tblPacientes.setEnabled(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barVulnerabilidad;
    private javax.swing.JButton btnBuscarRUT;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCargarFichaPaciente;
    private javax.swing.JButton btnEditarDatosPaciente;
    private javax.swing.JButton btnIngresarBitacora;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrarPaciente;
    private javax.swing.JButton btnVerBitacora;
    private javax.swing.JComboBox<String> cboCiudad;
    private javax.swing.JComboBox<String> cboComuna;
    private javax.swing.JComboBox<String> cboDv;
    private javax.swing.JComboBox<String> cboMes;
    private javax.swing.JComboBox<String> cboSexo;
    private javax.swing.JComboBox<String> cboTipoFuncionario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblFechaBitacora;
    private javax.swing.JLabel lblFunBitacora;
    private javax.swing.JLabel lblIdBitacora;
    private javax.swing.JLabel lblListaPersonas;
    private javax.swing.JLabel lblListaPersonas1;
    private javax.swing.JLabel lblModo;
    private javax.swing.JLabel lblTipoFuncionario;
    private javax.swing.JPanel pnlBitacoraPaciente;
    private javax.swing.JPanel pnlDatosPaciente;
    private javax.swing.JPanel pnlSocioeconomica;
    private javax.swing.JSpinner spnVulnerabilidad;
    private javax.swing.JTabbedPane tbDatosPersonas;
    private javax.swing.JTable tblBitacoras;
    private javax.swing.JTable tblPacientes;
    private javax.swing.JTextField txtAno;
    private javax.swing.JTextField txtBitacora;
    private javax.swing.JTextField txtDia;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtPApellido;
    private javax.swing.JTextField txtPNombre;
    private javax.swing.JTextField txtRUT;
    private javax.swing.JTextField txtRutBusqueda;
    private javax.swing.JTextField txtSApellido;
    private javax.swing.JTextField txtSNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
