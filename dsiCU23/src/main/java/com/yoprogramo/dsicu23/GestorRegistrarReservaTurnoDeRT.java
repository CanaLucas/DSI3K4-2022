
package com.yoprogramo.dsicu23;

import java.util.ArrayList;
import java.util.Date;

public class GestorRegistrarReservaTurnoDeRT {
    private int btnOpcionReservarTurnoDeRT;
    private TipoRecursoTecnologico[] tiposDeRecursosTecnologicos;
    private ArrayList <String> cmbTiposDeRecursos;
    private String tipoRecursoSeleccionado;
    private ArrayList<RecursoTecnologico> recursosTecnologicos;
    private RecursoTecnologico recursoTecnologicoSeleccionado;
    private PersonalCientifico usuarioLogueado;
    private Date fechaActual;
    private ArrayList<Turno> turnoDelRT;
    private Turno turnoSeleccionado;
    private Estado estReservado;
    private String notificacionMail;
    private ArrayList <Estado> estados;
    
    /*Constructor de la clase*/
    public ArrayList<Estado> getEstados() {
        return estados;
    }
    
    /*Metodos de la clase*/
    
    public void setEstados(ArrayList<Estado> estados) {
        this.estados = estados;
    }

    public String getTipoRecursoSeleccionado() {
        return tipoRecursoSeleccionado;
    }

    public void setTipoRecursoSeleccionado(String tipoRecursoSeleccionado) {    
        this.tipoRecursoSeleccionado = tipoRecursoSeleccionado;
    }

    public int getBtnOpcionReservarTurnoDeRT() {
        return btnOpcionReservarTurnoDeRT;
    }
    
    public void setBtnOpcionReservarTurnoDeRT(int btnOpcionReservarTurnoDeRT) {
        this.btnOpcionReservarTurnoDeRT = btnOpcionReservarTurnoDeRT;
    }

    public TipoRecursoTecnologico[] getTiposDeRecursosTecnologicos() {
        return tiposDeRecursosTecnologicos;
    }

    public void setTiposDeRecursosTecnologicos(TipoRecursoTecnologico[] tiposDeRecursosTecnologicos) {
        this.tiposDeRecursosTecnologicos = tiposDeRecursosTecnologicos;
    }

    public ArrayList<RecursoTecnologico> getRecursosTecnologicos() {
        return recursosTecnologicos;
    }

    public void setRecursosTecnologicos(ArrayList<RecursoTecnologico> recursosTecnologicos) {
        this.recursosTecnologicos = recursosTecnologicos;
    }

    public RecursoTecnologico getRecursoTecnologicoSeleccionado() {
        return recursoTecnologicoSeleccionado;
    }

    public void setRecursoTecnologicoSeleccionado(RecursoTecnologico recursoTecnologicoSeleccionado) {
        this.recursoTecnologicoSeleccionado = recursoTecnologicoSeleccionado;
    }

    public PersonalCientifico getUsuarioLogueado() {
        return usuarioLogueado;
    }

    public void setUsuarioLogueado(PersonalCientifico usuarioLogueado) {
        this.usuarioLogueado = usuarioLogueado;
    }

    public Date getFechaActual() {
        return fechaActual;
    }

    public void setFechaActual(Date fechaActual) {
        this.fechaActual = fechaActual;
    }

    public ArrayList<Turno> getTurnoDelRT() {
        return turnoDelRT;
    }

    public void setTurnoDelRT(ArrayList<Turno> turnoDelRT) {
        this.turnoDelRT = turnoDelRT;
    }
    public Turno getTurnoSeleccionado() {
        return turnoSeleccionado;
    }

    public void setTurnoSeleccionado(Turno turnoSeleccionado) {
        this.turnoSeleccionado = turnoSeleccionado;
    }

    public Estado getEstReservado() {
        return estReservado;
    }

    public void setEstReservado(Estado esReservado) {
        this.estReservado = esReservado;
    }
    
    public String getNotificacionMail() {
        return notificacionMail;
    }

    public void setNotificacionMail(String notificacionMail) {
        this.notificacionMail = notificacionMail;
    }

    public ArrayList<String> getCmbTiposDeRecursos() {
        return cmbTiposDeRecursos;
    }

    public void setCmbTiposDeRecursos(ArrayList<String> cmbTiposDeRecursos) {
        this.cmbTiposDeRecursos = cmbTiposDeRecursos;
    }

    // Metodos de la clase que se usa en el CU23
    
    public ArrayList <String> opcionReservaTurnoDeRT(int a) {
        /*Metodo inicia que llama al metodo que busca los tipos de recurso y los devuelve*/
        if(a == 1){
            this.buscarTiposDeRecursos();
            return this.cmbTiposDeRecursos;
        }
        return null;        
    }
    
    public void buscarTiposDeRecursos() {
        /*Metodo que busca los tipos de recursos y los trae*/
        ArrayList<String> a = new ArrayList<>();
    
        for(int i=0;i<this.tiposDeRecursosTecnologicos.length;i++){           
            
            a.add(i,tiposDeRecursosTecnologicos[i].getNombre());         
        }        
        this.setCmbTiposDeRecursos(a);
    }
    
    public ArrayList<RecursoTecnologico> buscarRTDeTipoSeleccionado(String tipo) {
        /*Se busca todos los recursos que coincidan con el tipo y luego se valida que sean reservables*/
        ArrayList<RecursoTecnologico> tipoR = new ArrayList<>();
        for(int i = 0; i<this.recursosTecnologicos.size() ; i++){ 
           
            /*esTipoRTTipoSeleccionado()*/
            if(((this.recursosTecnologicos.get(i).getTipoRecurso().getNombre().equals(tipo) || tipo.equals("TODOS")) && this.recursosTecnologicos.get(i).obtenerRTReservable())){
                
                /*obtenerRTReservables() y esReservable()*/
                if(this.recursosTecnologicos.get(i).ultimoCambioEstado().getEstado().getNombre() != "Baja Tecnica" || this.recursosTecnologicos.get(i).ultimoCambioEstado().getEstado().getNombre() != "Baja Definitiva")
                {    
                    tipoR.add(recursosTecnologicos.get(i));
                }  
            }
        }
        
        if(tipoR.isEmpty()){
            System.out.print("No hay recursos de tipo: " + tipo + " reservables en ningún Centro al que pertenezca.");
        }            
        return tipoR;        
    }

    public ArrayList<RecursoTecnologico> buscarInformacionRecursosTecnologicos(ArrayList<RecursoTecnologico> recursos) {        
        /*Desencadena todos los mensajes para obtener atributos de los recursos ya filtrados por tipo de recurso*/
        ArrayList <RecursoTecnologico> recursosDatos = new ArrayList <>();
        
        for(int i = 0; i < recursos.size(); i++){
            recursosDatos.add(i, recursos.get(i).mostrarRT());  
        }
        return recursosDatos;        
    }
    
    public boolean buscarUsuarioLogueado(PersonalCientifico a) {
        /*Busca al usuario y obtiene su legajo*/
        if(this.usuarioLogueado.getLegajo().equals(a.getLegajo())){            
            return true;
        }
        return false;
    }
    
    /*SALTA EL CASO 35 Y 36 Y VA DIRECTO AL CENTRO*/
    public String verificarCIDeCientifico(PersonalCientifico a) {
        //este metodo no hace laverificacion completa ya que segun el CU siempre seria un cientifico del mismo CI
        String correo = this.recursoTecnologicoSeleccionado.getCentro().misCientificosActivos(a);
        if(a.getCorreoElectronicoInstitucional().equals(correo)){
            return correo;
        }
        return "CIENTIFICO NO PERTENECE AL MISMO CENTRO DEL RECURSO SELECCIONADO";
    }
    
    public Date obtenerFechaYHoraActual() { 
        
        Date horaActual = new Date();
        horaActual.getTime();
        return horaActual;        
    }

    public void reservarTurnoDeRT() {
        this.buscarEstadoReservado();
    }

    private void buscarEstadoReservado() {
        
        /*Recorrer la clase estado con todos y preguntar si el string ambito es igual a el atributo ambito*/      
        for(int i = 0; i < this.estados.size(); i++){
            if(this.estados.get(i).esAmbitoTurno() && this.estados.get(i).esReservado()){
                this.setEstReservado(this.estados.get(i));
            }
        }
    }
    
    public ArrayList<Turno> obtenerTurnosDelRTSeleccionado() {
        /*TRAE LOS TURNOS PARA EL RECURSO SELECCIONADO*/
        this.turnoDelRT = this.recursoTecnologicoSeleccionado.buscarTurnosDesdeFechaYHoraActual(this.fechaActual);
        return this.turnoDelRT;    
    }
    
    public void generarNotificacionPorMail(String correoInstitucionalCientifico, PantallaRegistrarReservaTurnoDeRT pantalla) {
        pantalla.pantallaConfirmacion(correoInstitucionalCientifico);
    }
}