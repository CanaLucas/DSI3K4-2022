
package com.yoprogramo.dsicu23;

import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class PantallaRegistrarReservaTurnoDeRT extends javax.swing.JFrame {
    private int btnOpcionReservarTurnoDeRT;
    private ArrayList <String> cmbTiposDeRecursos;
    private String tipoRecursoSeleccionado; 
    private ArrayList<RecursoTecnologico> listaRT;
    private RecursoTecnologico recursoSeleccionado;
    private ArrayList<Turno> grillaTurnos;
    private ArrayList <CentroDeInvestigacion> centrosInvestigacion;
    private Turno turnoSeleccionado;
    
    public PantallaRegistrarReservaTurnoDeRT() {        
    
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public ArrayList<CentroDeInvestigacion> getCentrosInvestigacion() {    
        return centrosInvestigacion;
    }

    public Turno getTurnoSeleccionado() {
        return turnoSeleccionado;
    }
    
    public RecursoTecnologico getRecursoSeleccionado() {    
        return recursoSeleccionado;
    }

    public void setRecursoSeleccionado(RecursoTecnologico recursoSeleccionado) {
        this.recursoSeleccionado = recursoSeleccionado;
    }

    public void setCentrosInvestigacion(ArrayList<CentroDeInvestigacion> centrosInvestigacion) {
        this.centrosInvestigacion = centrosInvestigacion;
    }

    public int getBtnOpcionReservarTurnoDeRT() {
        return btnOpcionReservarTurnoDeRT;
    }

    public void setBtnOpcionReservarTurnoDeRT(int btnOpcionReservarTurnoDeRT) {
        this.btnOpcionReservarTurnoDeRT = btnOpcionReservarTurnoDeRT;
    }

    public String getTipoRecursoSeleccionado() {
        return tipoRecursoSeleccionado;
    }

    public void setTipoRecursoSeleccionado(String tipoRecursoSeleccionado) {
        this.tipoRecursoSeleccionado = tipoRecursoSeleccionado;
    }

    public ArrayList<String> getCmbTiposDeRecursos() {
        return cmbTiposDeRecursos;
    }

    public void setCmbTiposDeRecursos(ArrayList<String> cmbTiposDeRecursos) {
        this.cmbTiposDeRecursos = cmbTiposDeRecursos;
    }
    
    public ArrayList<RecursoTecnologico> getListaRT() {
       return listaRT;
    }

    public void setListaRT(ArrayList<RecursoTecnologico> listaRT) {        
        this.listaRT = listaRT;
    }

    public ArrayList<Turno> getGrillaTurnos() {
        return grillaTurnos;
    }

    public void setGrillaTurnos(ArrayList<Turno> grillaTurnos) {
        this.grillaTurnos = grillaTurnos;
    }
    
    // Metodos de la clase que se usa en el CU23
    
    public void habilitarPantalla() throws InterruptedException {   
        /*habilitaPantalla*/
        this.setVisible(true);
        
        ActionListener click = new ActionListener() {
        @Override
            public void actionPerformed(ActionEvent e) {
                btnOpcionReservarTurnoDeRT = 1;     
            }
        };
        btnOpcionReservar.addActionListener(click);  
    }
        
    public void mostrarTiposDeRecursos() throws InterruptedException{ 
             
        this.interfazSeleccionRT.setBounds(300,150, 800, 700);
        this.interfazSeleccionRT.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.interfazSeleccionRT.setVisible(true); 
        this.btnConfirmar.setEnabled(false);
        
        for(int i = 0; i < this.getCmbTiposDeRecursos().size();i++){
            cmbTiposRecursos.addItem(this.getCmbTiposDeRecursos().get(i));
        }
              
        while(this.getTipoRecursoSeleccionado() == null){
            ActionListener busquedaTipo = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(cmbTiposRecursos.getSelectedItem() != null){
                        tipoRecursoSeleccionado = cmbTiposRecursos.getSelectedItem().toString();
                    }
                }
            };
            this.busquedaTipoRT.addActionListener(busquedaTipo); 
        }   
    }
    
    /*solicitarSeleccionTipoDeRecurso() y  tomarSeleccionDeTipoDeRecurso*///(7)y(8)
    public void solicitarSeleccionTipoDeRecurso(String a) {
        this.setTipoRecursoSeleccionado(a);    
    }
    
    public RecursoTecnologico mostrarRTAgrupados(ArrayList<RecursoTecnologico> recursosAll) throws InterruptedException {
        
        this.setListaRT(recursosAll);
        
        /*Validacion de RT Reservables*/
        if(recursosAll.isEmpty()){
            JOptionPane.showMessageDialog(interfazSeleccionRT, "No hay Recursos Reservables del tipo "+ this.tipoRecursoSeleccionado, "Información",2);
            this.interfazSeleccionRT.dispose();
            System.exit(0);
        }
        
        /* Se desactiva el tipo de recurso seleccionado para que no pueda volver a elegir otro*/
        this.cmbTiposRecursos.setEnabled(false);
        
        /*Se agregan los CI*/
        for(int i = 0; i < this.centrosInvestigacion.size();i++){
            
            if((this.centrosInvestigacion.get(i).tieneAlMenosUnRecurso(this.tipoRecursoSeleccionado) == true)){
               
                comboBoxCentros.addItem(this.centrosInvestigacion.get(i).getNombre());    
            }
        }   
        
        /*solicitarSeleccionDeRT()*/ //(28)y(29)y(30)
        while(this.recursoSeleccionado == null){
            ActionListener recursoSeleccionado = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                }
            };
            this.seleccionarRT.addActionListener(recursoSeleccionado);
        }       
        return this.recursoSeleccionado;
    }
    
    /*CODIGO QUE TENGA Q VER CON BOTONES DE LA INTERFAZ Y LAS ACCIONES QUE SE EJECUTAN AL PRESIONAR BOTONES*/
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        interfazSeleccionRT = new javax.swing.JFrame();
        jLabel3 = new javax.swing.JLabel();
        comboBoxCentros = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        seleccionarRT = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblRT = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        calendarTurnos = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        cbxMail = new javax.swing.JCheckBox();
        cbxWhatsapp = new javax.swing.JCheckBox();
        btnConfirmar = new javax.swing.JButton();
        btnCancelarr = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        cmbTiposRecursos = new javax.swing.JComboBox<>();
        busquedaTipoRT = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        buscarTurnoFecha = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaTurnos = new javax.swing.JTable();
        pantallaConfirmacion = new javax.swing.JFrame();
        confirmacionFinal = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        infoReserva = new javax.swing.JTextArea();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnOpcionReservar = new javax.swing.JButton();

        interfazSeleccionRT.setTitle("Registrar Reserva Turno de Recurso Tecnológico");
        interfazSeleccionRT.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        interfazSeleccionRT.setFocusable(false);

        jLabel3.setText("Seleccionar Centro:");

        comboBoxCentros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxCentrosActionPerformed(evt);
            }
        });

        jLabel4.setText("Recursos del Centro seleccionado:");

        seleccionarRT.setText("Seleccionar Recurso Tecnológico");
        seleccionarRT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionarRTActionPerformed(evt);
            }
        });

        tblRT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Número RT", "Marca", "Modelo", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblRT.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane2.setViewportView(tblRT);

        jLabel5.setText("Seleccionar Turno del Recurso a Reservar:");

        calendarTurnos.setMinSelectableDate(new java.util.Date(-62135755114000L));

        jLabel6.setText("Seleccionar Tipo de Notificación:");

        cbxMail.setSelected(true);
        cbxMail.setText("Mail");

        cbxWhatsapp.setText("Whatsapp");

        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        btnCancelarr.setText("Cancelar");
        btnCancelarr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarrActionPerformed(evt);
            }
        });

        jLabel7.setText("Seleccionar Tipo de Recurso que desea reservar:");

        busquedaTipoRT.setText("Buscar");

        jLabel2.setText("Seleccionar Fecha en la que desea Reservar:");

        buscarTurnoFecha.setText("Buscar Turnos en esta Fecha");
        buscarTurnoFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarTurnoFechaActionPerformed(evt);
            }
        });

        tablaTurnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Fecha Inicio ", "Fecha Final", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tablaTurnos);

        javax.swing.GroupLayout interfazSeleccionRTLayout = new javax.swing.GroupLayout(interfazSeleccionRT.getContentPane());
        interfazSeleccionRT.getContentPane().setLayout(interfazSeleccionRTLayout);
        interfazSeleccionRTLayout.setHorizontalGroup(
            interfazSeleccionRTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, interfazSeleccionRTLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(seleccionarRT)
                .addGap(17, 17, 17))
            .addGroup(interfazSeleccionRTLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jLabel7)
                .addGap(51, 51, 51)
                .addComponent(cmbTiposRecursos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(busquedaTipoRT)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, interfazSeleccionRTLayout.createSequentialGroup()
                .addContainerGap(68, Short.MAX_VALUE)
                .addGroup(interfazSeleccionRTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, interfazSeleccionRTLayout.createSequentialGroup()
                        .addGroup(interfazSeleccionRTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(interfazSeleccionRTLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(40, 40, 40)
                                .addComponent(cbxMail)
                                .addGap(18, 18, 18)
                                .addComponent(cbxWhatsapp))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addGroup(interfazSeleccionRTLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(31, 31, 31)
                                .addComponent(comboBoxCentros, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2)
                            .addGroup(interfazSeleccionRTLayout.createSequentialGroup()
                                .addComponent(calendarTurnos, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(buscarTurnoFecha))
                            .addComponent(jLabel5)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, interfazSeleccionRTLayout.createSequentialGroup()
                        .addComponent(btnConfirmar)
                        .addGap(21, 21, 21)
                        .addComponent(btnCancelarr)
                        .addGap(38, 38, 38))))
        );
        interfazSeleccionRTLayout.setVerticalGroup(
            interfazSeleccionRTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(interfazSeleccionRTLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(interfazSeleccionRTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cmbTiposRecursos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(busquedaTipoRT))
                .addGap(18, 18, 18)
                .addGroup(interfazSeleccionRTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comboBoxCentros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(interfazSeleccionRTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(interfazSeleccionRTLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel2))
                    .addGroup(interfazSeleccionRTLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(seleccionarRT)))
                .addGap(18, 18, 18)
                .addGroup(interfazSeleccionRTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(calendarTurnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscarTurnoFecha))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(interfazSeleccionRTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(interfazSeleccionRTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbxMail)
                        .addComponent(cbxWhatsapp)))
                .addGap(1, 1, 1)
                .addGroup(interfazSeleccionRTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirmar)
                    .addComponent(btnCancelarr))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pantallaConfirmacion.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        pantallaConfirmacion.setPreferredSize(new java.awt.Dimension(800, 800));

        confirmacionFinal.setText("Confirmar Reserva");
        confirmacionFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmacionFinalActionPerformed(evt);
            }
        });

        jLabel8.setText("¿Desea Confirmar la Reserva del siguente Turno del Recurso Seleccionado?");

        infoReserva.setColumns(20);
        infoReserva.setRows(5);
        jScrollPane1.setViewportView(infoReserva);

        javax.swing.GroupLayout pantallaConfirmacionLayout = new javax.swing.GroupLayout(pantallaConfirmacion.getContentPane());
        pantallaConfirmacion.getContentPane().setLayout(pantallaConfirmacionLayout);
        pantallaConfirmacionLayout.setHorizontalGroup(
            pantallaConfirmacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pantallaConfirmacionLayout.createSequentialGroup()
                .addGroup(pantallaConfirmacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pantallaConfirmacionLayout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(pantallaConfirmacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pantallaConfirmacionLayout.createSequentialGroup()
                        .addGap(299, 299, 299)
                        .addComponent(confirmacionFinal)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        pantallaConfirmacionLayout.setVerticalGroup(
            pantallaConfirmacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pantallaConfirmacionLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(confirmacionFinal)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SeCyT - Gestión de Recursos Tecnológicos de Centro de Investigación");
        setName("menuOpciones"); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Seleccionar opción:");

        btnOpcionReservar.setText("Registrar Reserva Turno De Recurso Tecnológico");
        btnOpcionReservar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnOpcionReservarMouseClicked(evt);
            }
        });
        btnOpcionReservar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clickBtnOpcion(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(btnOpcionReservar)))
                .addContainerGap(146, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnOpcionReservar)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clickBtnOpcion(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clickBtnOpcion
        
        this.setBtnOpcionReservarTurnoDeRT(1);        
        this.dispose();        
    }//GEN-LAST:event_clickBtnOpcion
    
    private void btnOpcionReservarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOpcionReservarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnOpcionReservarMouseClicked

    private void buscarTurnoFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarTurnoFechaActionPerformed

        JTextFieldDateEditor dateChooserEditor = ((JTextFieldDateEditor)this.calendarTurnos.getDateEditor()); 
        
        if(this.calendarTurnos.getDate() != null){
            
            DefaultTableModel modelo2=(DefaultTableModel) tablaTurnos.getModel();
            int filas=tablaTurnos.getRowCount();
            
            for (int i = 0;filas>i; i++) {
                modelo2.removeRow(0);
            }
            
            for(int i = 0; i < this.grillaTurnos.size();i++){
                
                if(        
                    (this.calendarTurnos.getCalendar().getTime().toString().substring(4, 11)+this.calendarTurnos.getCalendar().getTime().toString().substring(24,28)).toString().equals(
                            
                    (this.grillaTurnos.get(i).getFechaHoraInicio().toString().substring(4, 11)+this.grillaTurnos.get(i).getFechaHoraInicio().toString().substring(24, 28)).toString()
                    )   
                ){
                    Object [] fila = new Object[3];
                    fila [0] = (grillaTurnos.get(i).getFechaHoraInicio().toString().substring(4,19)+grillaTurnos.get(i).getFechaHoraInicio().toString().substring(23,28).toString());
                    fila [1] = (grillaTurnos.get(i).getFechaHoraFin().toString().substring(4,19)+grillaTurnos.get(i).getFechaHoraFin().toString().substring(23,28).toString());
                    fila [2] = grillaTurnos.get(i).conocerEstadoActual().getEstado().getNombre();
                    modelo2.addRow(fila);
                }
            
            }
            
            DefaultTableCellRenderer Renderer2 = new DefaultTableCellRenderer(){
                @Override public Component getTableCellRendererComponent(JTable table,Object value,boolean isSelected,boolean hasFocus,int row,int column){
                        super.getTableCellRendererComponent(table,value,isSelected,hasFocus,row,column);
                    if(column == 2){
                        if(value == "Disponible"){
                            setBackground(Color.blue);
                        }
                        else{
                            if(value == "Reservado"){
                                setBackground(Color.red);
                            }
                            else{
                                if(value == "Pendiente Confirmacion"){
                                    setBackground(Color.gray);
                                }
                            }
                        }                      
                    }
                    else{
                        setBackground(Color.white);
                    }
                    return this;
                }
            };
            tablaTurnos.setDefaultRenderer(Object.class,Renderer2);
 
            /*SETEA EL COLOR DE LA FECHA SEGUN SI HAY O NO TURNOS ESE DIA*/
            if(this.tablaTurnos.getRowCount() > 0){
                dateChooserEditor.setForeground(new Color(0,0,255));
            }
            else{
                dateChooserEditor.setForeground(new Color(255,0,0));
            }
            this.btnCancelarr.setEnabled(false);
            this.btnConfirmar.setEnabled(true);
        }
    }//GEN-LAST:event_buscarTurnoFechaActionPerformed

    private void btnCancelarrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarrActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(interfazSeleccionRT, "¿Está seguro que desea salir de la Reserva?", "Informacón",2);
        System.exit(0);
    }//GEN-LAST:event_btnCancelarrActionPerformed

    /*AL HACER CLICK EN EL BOTON RECUPERA EL SELECCIONADO Y LO SETEA EN LA PANTALLA COMO RECURSO SELECCIONADO*/
    private void seleccionarRTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleccionarRTActionPerformed

        int filaseleccionada = tblRT.getSelectedRow();
        if (filaseleccionada == -1){
            JOptionPane.showMessageDialog(null, "Seleccione un Recurso Tecnológico.");
        }
        else {
            String a = tblRT.getValueAt(filaseleccionada, 0).toString();

            for(int i = 0;i<this.listaRT.size();i++){
                if(this.listaRT.get(i).getNumeroRT().equals(Integer.parseInt(a))){
                    this.setRecursoSeleccionado(this.listaRT.get(i));
                    JOptionPane.showMessageDialog(interfazSeleccionRT, "Seleccionó el Recurso con Número: "+this.recursoSeleccionado.getNumeroRT(), "Información",2);
                }
            }
        }
    }//GEN-LAST:event_seleccionarRTActionPerformed

    /*LLENA LA TABLA CON LOS RECURSOS SEGUN EL CENTRO SELECCIONADO
    */
    private void comboBoxCentrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxCentrosActionPerformed

        DefaultTableModel modelo=(DefaultTableModel) tblRT.getModel();
        int filas=tblRT.getRowCount();
        
        for (int i = 0;filas>i; i++) {
            modelo.removeRow(0);
        }

        if(comboBoxCentros.getSelectedIndex() != -1){

            for(int i = 0; i < listaRT.size();i++){

                if(listaRT.get(i).getCentro().getNombre().equals(this.comboBoxCentros.getSelectedItem())){
                    Object [] fila = new Object[4];
                    fila [0] = listaRT.get(i).getNumeroRT().toString();
                    fila [1] = listaRT.get(i).getModelo().getMarca().getNombre();
                    fila [2] = listaRT.get(i).getModelo().getNombre();
                    /*METODO QUE BUSCA LOS CAMBIOS DE ESTADO Y DEVUELVE EL NOMBRE DEL ESTADO ACTUAL*/
                    fila [3] = listaRT.get(i).ultimoCambioEstado().getEstado().getNombre();
                    modelo.addRow(fila);  
                }
            }
            
            /*SE ENCARGA DE CAMBIAR EL COLOR DE LA CELDA SEGUN EL VALOR DEL ESTADO ACTUAL DEL RECURSO TECNOLOGICO*/
            DefaultTableCellRenderer Renderer = new DefaultTableCellRenderer(){
                @Override public Component getTableCellRendererComponent(JTable table,Object value,boolean isSelected,boolean hasFocus,int row,int column){
                        super.getTableCellRendererComponent(table,value,isSelected,hasFocus,row,column);
                    if(column == 3){
                        if(value == "Disponible"){
                            setBackground(Color.blue);
                        }
                        else{
                            if(value == "En Mantenimiento"){
                                setBackground(Color.green);
                            }
                            else{
                                if(value == "Inicio Mantenimiento Correctivo"){
                                    setBackground(Color.gray);
                                }
                            }
                        }                      
                    }
                    else{
                        setBackground(Color.white);
                    }
                    return this;
                }
            };
            tblRT.setDefaultRenderer(Object.class,Renderer);        
        }
    }//GEN-LAST:event_comboBoxCentrosActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        
        int filaseleccionada2 = tablaTurnos.getSelectedRow();
        
        if (filaseleccionada2 == -1){
            JOptionPane.showMessageDialog(null, "Seleccione un Turno.");
        }
        else{
            
            String encontrarT = this.tablaTurnos.getValueAt(filaseleccionada2,0).toString();
            
            for(int i = 0; i < this.grillaTurnos.size();i++){
                if(encontrarT.equals((grillaTurnos.get(i).getFechaHoraInicio().toString().substring(4,19)+grillaTurnos.get(i).getFechaHoraInicio().toString().substring(23,28)))){
                    if(this.grillaTurnos.get(i).conocerEstadoActual().getEstado().getNombre() == "Disponible" && this.cbxMail.isSelected() ^ this.cbxWhatsapp.isSelected()){
                        this.turnoSeleccionado = this.grillaTurnos.get(i);
                    }
                    else{
                        
                        if(this.grillaTurnos.get(i).conocerEstadoActual().getEstado().getNombre() != "Disponible"){
                        JOptionPane.showMessageDialog(null, "El turno no se puede seleccionar debido a que su estado es: "+
                            this.grillaTurnos.get(i).conocerEstadoActual().getEstado().getNombre()    );
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Seleccione una opción de notificación.");
                        }
                    }                
                }
            }            
        }
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void confirmacionFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmacionFinalActionPerformed
        JOptionPane.showMessageDialog(interfazSeleccionRT,"Turno Reservado", "Información",2);
        System.exit(0);
    }//GEN-LAST:event_confirmacionFinalActionPerformed
    
    public void mostrarTurnos(ArrayList<Turno> turnoDelRT,Date fecha) {
        
        this.setGrillaTurnos(turnoDelRT);
        this.calendarTurnos.setMinSelectableDate(fecha);
        
        while(this.turnoSeleccionado == null){
            ActionListener recursoSeleccionado = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {            
                }
            };
            this.seleccionarRT.addActionListener(recursoSeleccionado);
        }
    }
    
    public void setearCalendario(Date fecha) {
        calendarTurnos.setMinSelectableDate(fecha);
    }
    
    public void pantallaConfirmacion(String correoInstitucionalCientifico) {
    
        this.interfazSeleccionRT.dispose();
        this.pantallaConfirmacion.setVisible(true);
        this.pantallaConfirmacion.setBounds(500, 150, 800, 300);
        
        this.infoReserva.setText(
        "Se le enviará un mail a: "+correoInstitucionalCientifico+" para la reserva del recurso "+"\n"+
                "Número: "+this.recursoSeleccionado.getNumeroRT()+ " - Marca: "+this.recursoSeleccionado.getModelo().getMarca().getNombre()+
                " - Modelo: "+this.recursoSeleccionado.getModelo().getNombre()+" del tipo: "+this.recursoSeleccionado.getTipoRecurso().getNombre()+"\n"+
                "El turno inicia: "+ (this.turnoSeleccionado.getFechaHoraInicio().toString().substring(4,19)+this.turnoSeleccionado.getFechaHoraInicio().toString().substring(23,28))+"\n"+                
                "El turno finaliza: "+(this.turnoSeleccionado.getFechaHoraFin().toString().substring(4,19)+this.turnoSeleccionado.getFechaHoraFin().toString().substring(23,28))
        );
    }

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaRegistrarReservaTurnoDeRT().setVisible(true);
            }
        });  
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarr;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnOpcionReservar;
    private javax.swing.JButton buscarTurnoFecha;
    private javax.swing.JButton busquedaTipoRT;
    private com.toedter.calendar.JDateChooser calendarTurnos;
    private javax.swing.JCheckBox cbxMail;
    private javax.swing.JCheckBox cbxWhatsapp;
    private javax.swing.JComboBox<String> cmbTiposRecursos;
    private javax.swing.JComboBox<String> comboBoxCentros;
    private javax.swing.JButton confirmacionFinal;
    private javax.swing.JTextArea infoReserva;
    private javax.swing.JFrame interfazSeleccionRT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JFrame pantallaConfirmacion;
    private javax.swing.JButton seleccionarRT;
    private javax.swing.JTable tablaTurnos;
    private javax.swing.JTable tblRT;
    // End of variables declaration//GEN-END:variables
}