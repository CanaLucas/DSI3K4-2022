
package com.yoprogramo.dsicu23;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



/**
 *
 * 
 */
public class PantallaRegistrarReservaTurnoDeRT extends javax.swing.JFrame {
    private int btnOpcionReservarTurnoDeRT;
    private ArrayList <String> cmbTiposDeRecursos;
    private String tipoRecursoSeleccionado; /*Agregado este atributo a la clase ya que lo toma al seleccionar el tipo que quiere buscar*/
    private ArrayList<RecursoTecnologico> listaRT;
    private RecursoTecnologico recursoSeleccionado; /*AGREGADO EL RECURSO SELECCIONADO*/
    private ArrayList<Turno> grillaTurnos;
    private String radioBtnNotificacion;
    private boolean btnConfirmarReserva;
    private boolean btnCancelar;
    private ArrayList <CentroDeInvestigacion> centrosInvestigacion;
    
    public ArrayList<CentroDeInvestigacion> getCentrosInvestigacion() {    
        return centrosInvestigacion;
    }

    public RecursoTecnologico getRecursoSeleccionado() {    
        return recursoSeleccionado;
    }

    /*Metodos de la pantalla*/
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

    public String getRadioBtnNotificacion() {
        return radioBtnNotificacion;
    }

    public void setRadioBtnNotificacion(String radioBtnNotificacion) {
        this.radioBtnNotificacion = radioBtnNotificacion;
    }

    public boolean isBtnConfirmarReserva() {
        return btnConfirmarReserva;
    }

    public void setBtnConfirmarReserva(boolean btnConfirmarReserva) {
        this.btnConfirmarReserva = btnConfirmarReserva;
    }

    public boolean isBtnCancelar() {
        return btnCancelar;
    }

    public void setBtnCancelar(boolean btnCancelar) {
        this.btnCancelar = btnCancelar;
    }
    
    /*HACE VISIBLE EL PRIMER FORMULARIO y espera hasta que el usuario haga click, esto no esta bien implementado porq manda a dormir el proceso y deberia esperar hasta q se haga click*/
    public void habilitarPantalla() throws InterruptedException {   
    
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
        
        /*LA PANTALLA OBTIENE LOS TIPOS DE RECURSOS*/
                
        /*HABILITA LA SEGUNDA INTERFAZ, LE SETEA UN TAMAÑO DE PANTALLA Y LLENA EL COMBOBOX PARA QUE EL USUARIO PUEDA ELEGIR*/ 
        this.interfazSeleccionRT.setBounds(300,150, 1200, 800);
        this.interfazSeleccionRT.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.interfazSeleccionRT.setVisible(true);      
        
        for(int i = 0; i < this.getCmbTiposDeRecursos().size();i++){
            cmbTiposRecursos.addItem(this.getCmbTiposDeRecursos().get(i));
        }
        /*Queda en loop hasta que se seleccione un tipo de recurso y se haga click en el boton*/        
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
    
    /*Setea el tipo de recurso que este al momento de hacer click en el form como atributo de la pantalla*/
    public void solicitarSeleccionTipoDeRecurso(String a) {
        this.setTipoRecursoSeleccionado(a);    
    }
    
    /*YA LA TOME CUANDO HICE EL SET EN SOLICITAR SELECCION TIPO...*/
    public void tomarSeleccionDeTipoDeRecurso(){}
    
    /*CREA LA INTERFAZ Y LLENA EL PRIMER COMBOBOX CON TODOS LOS CENTROS*/
    public RecursoTecnologico mostrarRTAgrupados(ArrayList<RecursoTecnologico> recursosAll) throws InterruptedException {
        
        this.setListaRT(recursosAll);
        /*Pregunto si la lista de recursos seleccionados esta vacia y si es así cierro el programa*/
        if(recursosAll.isEmpty()){
            JOptionPane.showMessageDialog(interfazSeleccionRT, "No hay Recursos Reservables del tipo "+ this.tipoRecursoSeleccionado, "Informacón",2);
            this.interfazSeleccionRT.dispose();
            System.exit(0);
        }
        /*Desactivo el tipo de recurso seleccionado para que no pueda volver a elegir otro*/
        this.cmbTiposRecursos.disable();
        /*AGREGO LOS CENTROS*/
        for(int i = 0; i < this.centrosInvestigacion.size();i++){
            
            if((this.centrosInvestigacion.get(i).tieneAlMenosUnRecurso(this.tipoRecursoSeleccionado) == true)){
               
                comboBoxCentros.addItem(this.centrosInvestigacion.get(i).getNombre());    
            }
        }   
        /*Permite que espere hasta q un recurso este seleccionado y se aprete el boton de seleccionar recurso*/
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
    
    public PantallaRegistrarReservaTurnoDeRT() {        
    
        initComponents();
        setLocationRelativeTo(null);/*PARA QUE QUEDE EN EL MEDIO DE LA PANTALLA*/
        setDefaultCloseOperation(EXIT_ON_CLOSE);
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
        cmbturnos = new javax.swing.JComboBox<>();
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
        pantallaConfirmacion = new javax.swing.JFrame();
        confirmacionFinal = new javax.swing.JButton();
        cancelacionFinal = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
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
        calendarTurnos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                calendarTurnosMouseClicked(evt);
            }
        });

        jLabel6.setText("Seleccione Tipo de Notificación:");

        cbxMail.setSelected(true);
        cbxMail.setText("Mail");
        cbxMail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxMailActionPerformed(evt);
            }
        });

        cbxWhatsapp.setText("Whatsapp");

        btnConfirmar.setText("Confirmar");
        btnConfirmar.setEnabled(false);
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

        cmbTiposRecursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTiposRecursosActionPerformed(evt);
            }
        });

        busquedaTipoRT.setText("Buscar");

        jLabel2.setText("Seleccionar Fecha en la que desea Reservar:");

        buscarTurnoFecha.setText("Buscar Turnos en esta Fecha");
        buscarTurnoFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarTurnoFechaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout interfazSeleccionRTLayout = new javax.swing.GroupLayout(interfazSeleccionRT.getContentPane());
        interfazSeleccionRT.getContentPane().setLayout(interfazSeleccionRTLayout);
        interfazSeleccionRTLayout.setHorizontalGroup(
            interfazSeleccionRTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(interfazSeleccionRTLayout.createSequentialGroup()
                .addGroup(interfazSeleccionRTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, interfazSeleccionRTLayout.createSequentialGroup()
                        .addGap(0, 600, Short.MAX_VALUE)
                        .addComponent(btnConfirmar)
                        .addGap(21, 21, 21)
                        .addComponent(btnCancelarr))
                    .addGroup(interfazSeleccionRTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(interfazSeleccionRTLayout.createSequentialGroup()
                            .addGap(61, 61, 61)
                            .addGroup(interfazSeleccionRTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(interfazSeleccionRTLayout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addGap(40, 40, 40)
                                    .addComponent(cbxMail)
                                    .addGap(18, 18, 18)
                                    .addComponent(cbxWhatsapp))
                                .addComponent(jLabel2)
                                .addGroup(interfazSeleccionRTLayout.createSequentialGroup()
                                    .addComponent(calendarTurnos, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(interfazSeleccionRTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(interfazSeleccionRTLayout.createSequentialGroup()
                                            .addGap(150, 150, 150)
                                            .addComponent(seleccionarRT))
                                        .addGroup(interfazSeleccionRTLayout.createSequentialGroup()
                                            .addGap(102, 102, 102)
                                            .addComponent(buscarTurnoFecha))))
                                .addComponent(jLabel5)
                                .addComponent(cmbturnos, javax.swing.GroupLayout.PREFERRED_SIZE, 699, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(interfazSeleccionRTLayout.createSequentialGroup()
                            .addGap(68, 68, 68)
                            .addGroup(interfazSeleccionRTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4)
                                .addGroup(interfazSeleccionRTLayout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(31, 31, 31)
                                    .addComponent(comboBoxCentros, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(interfazSeleccionRTLayout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addGap(51, 51, 51)
                                    .addComponent(cmbTiposRecursos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(47, 47, 47)
                                    .addComponent(busquedaTipoRT))))))
                .addContainerGap())
        );
        interfazSeleccionRTLayout.setVerticalGroup(
            interfazSeleccionRTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(interfazSeleccionRTLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(interfazSeleccionRTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cmbTiposRecursos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(busquedaTipoRT))
                .addGap(36, 36, 36)
                .addGroup(interfazSeleccionRTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comboBoxCentros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(interfazSeleccionRTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(interfazSeleccionRTLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2))
                    .addGroup(interfazSeleccionRTLayout.createSequentialGroup()
                        .addComponent(seleccionarRT)
                        .addGap(0, 26, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(interfazSeleccionRTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(interfazSeleccionRTLayout.createSequentialGroup()
                        .addComponent(calendarTurnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel5))
                    .addComponent(buscarTurnoFecha))
                .addGap(18, 18, 18)
                .addComponent(cmbturnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82)
                .addGroup(interfazSeleccionRTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(interfazSeleccionRTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbxMail)
                        .addComponent(cbxWhatsapp)))
                .addGap(111, 111, 111)
                .addGroup(interfazSeleccionRTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirmar)
                    .addComponent(btnCancelarr))
                .addGap(25, 25, 25))
        );

        confirmacionFinal.setText("Confirmar Reserva");

        cancelacionFinal.setText("Cancelar Reserva");

        jLabel8.setText("Desea Reservar el Recurso tecnologico:");

        javax.swing.GroupLayout pantallaConfirmacionLayout = new javax.swing.GroupLayout(pantallaConfirmacion.getContentPane());
        pantallaConfirmacion.getContentPane().setLayout(pantallaConfirmacionLayout);
        pantallaConfirmacionLayout.setHorizontalGroup(
            pantallaConfirmacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pantallaConfirmacionLayout.createSequentialGroup()
                .addGap(146, 146, 146)
                .addComponent(confirmacionFinal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 150, Short.MAX_VALUE)
                .addComponent(cancelacionFinal)
                .addGap(206, 206, 206))
            .addGroup(pantallaConfirmacionLayout.createSequentialGroup()
                .addGap(157, 157, 157)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pantallaConfirmacionLayout.setVerticalGroup(
            pantallaConfirmacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pantallaConfirmacionLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 191, Short.MAX_VALUE)
                .addGroup(pantallaConfirmacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmacionFinal)
                    .addComponent(cancelacionFinal))
                .addGap(14, 14, 14))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SeCyT - Gestión de Recursos Tecnológicos de Centro de Investigación");
        setName("menuOpciones"); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Seleccionar opción:");

        btnOpcionReservar.setText("Registrar Reserva Turno De Recurso Tecnologico");
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
        this.cmbturnos.removeAllItems();
        if(this.calendarTurnos.getDate() != null){
            System.out.print("\n");
            System.out.print(this.calendarTurnos.getCalendar().getTime().toString());
            for(int i = 0;i<this.grillaTurnos.size();i++){
                /*Comparo dia,año y mes*/
                if((this.calendarTurnos.getCalendar().getTime().getYear() == this.grillaTurnos.get(i).getFechaHoraInicio().getYear() &&
                    this.calendarTurnos.getCalendar().getTime().getDay() == this.grillaTurnos.get(i).getFechaHoraInicio().getDay() &&
                    this.calendarTurnos.getCalendar().getTime().getMonth() == this.grillaTurnos.get(i).getFechaHoraInicio().getMonth()
                )){
                    /*Agrego al comboBox si se cumplen las condiciones*/

                    cmbturnos.addItem("Desde el: "+this.grillaTurnos.get(i).getFechaHoraInicio().toString()+"- Hasta el: "+this.grillaTurnos.get(i).getFechaHoraFin().toString());

                }
                else{
                    /*SI SE SELECCIONA UNA FECHA ANTERIOR A LA FECHA ACTUAL MUESTRA*/
                    if(this.calendarTurnos.getCalendar().getTime().before(Calendar.getInstance().getTime())){
                        cmbturnos.removeAllItems();
                        cmbturnos.addItem("La fecha seleccionada ya paso...");
                    }
                    
                }
                

            }
            
            this.btnConfirmar.enable();
        }

    }//GEN-LAST:event_buscarTurnoFechaActionPerformed

    private void cmbTiposRecursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTiposRecursosActionPerformed

    }//GEN-LAST:event_cmbTiposRecursosActionPerformed

    private void btnCancelarrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarrActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(interfazSeleccionRT, "¿Esta seguro que desea salir de la reserva?", "Informacón",2);
        System.exit(0);
    }//GEN-LAST:event_btnCancelarrActionPerformed

    private void cbxMailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxMailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxMailActionPerformed

    private void calendarTurnosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_calendarTurnosMouseClicked
        System.out.print(this.calendarTurnos.getDate());
    }//GEN-LAST:event_calendarTurnosMouseClicked

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
                    JOptionPane.showMessageDialog(interfazSeleccionRT, "Recurso numero :"+this.recursoSeleccionado.getNumeroRT()+" seleccionado", "Informacón",2);
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
        }

    }//GEN-LAST:event_comboBoxCentrosActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        /*SI HAY UN TURNO SELECCIONADO Y ADEMAS SE SELECCIONO O POR MAIL O POR WSP*/
        if((this.cmbturnos.getSelectedIndex() != -1 || this.cmbturnos.getSelectedItem() != "La fecha seleccionada ya paso...") && (this.cbxMail.isSelected() || this.cbxWhatsapp.isSelected())){
            
            
        }
    }//GEN-LAST:event_btnConfirmarActionPerformed
    
    public void mostrarTurnos(ArrayList<Turno> turnoDelRT) {
        this.setGrillaTurnos(turnoDelRT);
        
        
    }
    
    public void setearCalendario(Date fecha) {
        calendarTurnos.setMinSelectableDate(fecha);
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
    private javax.swing.JButton cancelacionFinal;
    private javax.swing.JCheckBox cbxMail;
    private javax.swing.JCheckBox cbxWhatsapp;
    private javax.swing.JComboBox<String> cmbTiposRecursos;
    private javax.swing.JComboBox<String> cmbturnos;
    private javax.swing.JComboBox<String> comboBoxCentros;
    private javax.swing.JButton confirmacionFinal;
    private javax.swing.JFrame interfazSeleccionRT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JFrame pantallaConfirmacion;
    private javax.swing.JButton seleccionarRT;
    private javax.swing.JTable tblRT;
    // End of variables declaration//GEN-END:variables
}