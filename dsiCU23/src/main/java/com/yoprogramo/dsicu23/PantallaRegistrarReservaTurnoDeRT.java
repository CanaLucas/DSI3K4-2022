
package com.yoprogramo.dsicu23;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
        
    public String mostrarTiposDeRecursos(ArrayList <String> cmb) throws InterruptedException{ 
        
        /*LA PANTALLA OBTIENE LOS TIPOS DE RECURSOS*/
        this.setCmbTiposDeRecursos(cmb);
        
        /*HABILITA LA SEGUNDA INTERFAZ, LE SETEA UN TAMAÑO DE PANTALLA Y LLENA EL COMBOBOX PARA QUE EL USUARIO PUEDA ELEGIR*/
        this.interfazTipoRecurso.setVisible(true);
        interfazTipoRecurso.setLocationRelativeTo(null);
        interfazTipoRecurso.setBounds(700, 400, 500, 200);
        for(int i = 0; i < cmb.size();i++){
            comboBoxTiposRecursos.addItem(cmb.get(i));
        }
                
        ActionListener click = new ActionListener() {
        @Override
            public void actionPerformed(ActionEvent e) {
             
                /*SI ESTA SELECCIONADO UN ELEMENTO DEL COMBOBOX Y SE HACE CLICK EN EL BOTON BUSCAR ENTONCES ESTE DEVUELVE EL TIPO DE RECURSO SELECCIONADO ADEMAS DE SETEARLO EN LA PANTALLA*/
                if(comboBoxTiposRecursos.getSelectedItem() != null){
                    tipoRecursoSeleccionado = comboBoxTiposRecursos.getSelectedItem().toString();         
                }
            }
        };
        btnBuscarXTipo.addActionListener(click);
            
        do{
            /*CANTIDAD DE TIEMPO DORMIDO, ESTO SIRVE PARA Q DE TIEMPO PARA ELEGIR LA OPCION Y PASE A LA SIGUIENTE ETAPA*/
            Thread.sleep(10000);
        }while (comboBoxTiposRecursos.getSelectedIndex() == -1);
        /*Cierro el formulario de tipo*/
        comboBoxTiposRecursos.removeAllItems();
        interfazTipoRecurso.dispose();
        return this.tipoRecursoSeleccionado;
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
        this.interfazSeleccionRT.setVisible(true);
        interfazSeleccionRT.setBounds(600,300,700,600);
        
        /*AGREGO LOS CENTROS*/
        for(int i = 0; i < this.centrosInvestigacion.size();i++){
            
            if(this.centrosInvestigacion.get(i).tieneAlMenosUnRecurso(this.tipoRecursoSeleccionado) == true){
               
                comboBoxCentros.addItem(this.centrosInvestigacion.get(i).getNombre());    
            }
        }
               
        do{
            /*CANTIDAD DE TIEMPO DORMIDO, ESTO SIRVE PARA Q DE TIEMPO PARA ELEGIR LA OPCION Y PASE A LA SIGUIENTE ETAPA*/
            Thread.sleep(5000);
        }while (recursoSeleccionado == null);
        
        /*crea la gui y devuelve el rt seleccionado, creo q se tendria q agregar como atributo*/
        return this.recursoSeleccionado;
    }
    
    public PantallaRegistrarReservaTurnoDeRT() {        
    
        initComponents();
        setLocationRelativeTo(null);/*PARA QUE QUEDE EN EL MEDIO DE LA PANTALLA*/
    }
    
    /*CODIGO QUE TENGA Q VER CON BOTONES DE LA INTERFAZ Y LAS ACCIONES QUE SE EJECUTAN AL PRESIONAR BOTONES*/

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        interfazTipoRecurso = new javax.swing.JFrame();
        jLabel2 = new javax.swing.JLabel();
        comboBoxTiposRecursos = new javax.swing.JComboBox<>();
        btnBuscarXTipo = new javax.swing.JButton();
        interfazSeleccionRT = new javax.swing.JFrame();
        jLabel3 = new javax.swing.JLabel();
        comboBoxCentros = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        seleccionarRT = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblRT = new javax.swing.JTable();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        turnos = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnOpcionReservar = new javax.swing.JButton();

        interfazTipoRecurso.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        interfazTipoRecurso.setTitle("Registrar Reserva Turno de Recurso Tecnológico");

        jLabel2.setText("Seleccionar Tipo de Recurso que desea Reservar:");

        btnBuscarXTipo.setText("Buscar");

        javax.swing.GroupLayout interfazTipoRecursoLayout = new javax.swing.GroupLayout(interfazTipoRecurso.getContentPane());
        interfazTipoRecurso.getContentPane().setLayout(interfazTipoRecursoLayout);
        interfazTipoRecursoLayout.setHorizontalGroup(
            interfazTipoRecursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(interfazTipoRecursoLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(interfazTipoRecursoLayout.createSequentialGroup()
                .addContainerGap(115, Short.MAX_VALUE)
                .addComponent(comboBoxTiposRecursos, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(btnBuscarXTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90))
        );
        interfazTipoRecursoLayout.setVerticalGroup(
            interfazTipoRecursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(interfazTipoRecursoLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(interfazTipoRecursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscarXTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxTiposRecursos))
                .addContainerGap(48, Short.MAX_VALUE))
        );

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

        javax.swing.GroupLayout interfazSeleccionRTLayout = new javax.swing.GroupLayout(interfazSeleccionRT.getContentPane());
        interfazSeleccionRT.getContentPane().setLayout(interfazSeleccionRTLayout);
        interfazSeleccionRTLayout.setHorizontalGroup(
            interfazSeleccionRTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(interfazSeleccionRTLayout.createSequentialGroup()
                .addGroup(interfazSeleccionRTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(interfazSeleccionRTLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE))
                    .addGroup(interfazSeleccionRTLayout.createSequentialGroup()
                        .addGroup(interfazSeleccionRTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(interfazSeleccionRTLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(interfazSeleccionRTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addGroup(interfazSeleccionRTLayout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(31, 31, 31)
                                        .addComponent(comboBoxCentros, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(interfazSeleccionRTLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(interfazSeleccionRTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addGroup(interfazSeleccionRTLayout.createSequentialGroup()
                                        .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(62, 62, 62)
                                        .addComponent(turnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(interfazSeleccionRTLayout.createSequentialGroup()
                .addGap(239, 239, 239)
                .addComponent(seleccionarRT)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        interfazSeleccionRTLayout.setVerticalGroup(
            interfazSeleccionRTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(interfazSeleccionRTLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(interfazSeleccionRTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comboBoxCentros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(seleccionarRT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(interfazSeleccionRTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(turnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(158, Short.MAX_VALUE))
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
                    fila [3] = listaRT.get(i).getCambioEstado().esUltimoCambioEstadoRT();
                    modelo.addRow(fila);
                }
            }
        } 
    }//GEN-LAST:event_comboBoxCentrosActionPerformed

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
                }
            }
        }
    }//GEN-LAST:event_seleccionarRTActionPerformed

    private void btnOpcionReservarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOpcionReservarMouseClicked
        // TODO add your handling code here:
       
    }//GEN-LAST:event_btnOpcionReservarMouseClicked
    
    public void mostrarTurnos(ArrayList<Turno> turnoDelRT) {
        
        for(int i = 0;i<turnoDelRT.size();i++){
            turnos.addItem(turnoDelRT.get(i).getFechaHoraInicio().toString()+"-"+turnoDelRT.get(i).getFechaHoraFin().toString());
        }
    }
    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaRegistrarReservaTurnoDeRT().setVisible(true);
            }
        });  
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarXTipo;
    private javax.swing.JButton btnOpcionReservar;
    private javax.swing.JComboBox<String> comboBoxCentros;
    private javax.swing.JComboBox<String> comboBoxTiposRecursos;
    private javax.swing.JFrame interfazSeleccionRT;
    private javax.swing.JFrame interfazTipoRecurso;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton seleccionarRT;
    private javax.swing.JTable tblRT;
    private javax.swing.JComboBox<String> turnos;
    // End of variables declaration//GEN-END:variables
}