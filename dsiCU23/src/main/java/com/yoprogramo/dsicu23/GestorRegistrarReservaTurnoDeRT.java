
package com.yoprogramo.dsicu23;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GestorRegistrarReservaTurnoDeRT {
    private PantallaRegistrarReservaTurnoDeRT pantalla;
    private int btnOpcionReservarTurnoDeRT;
    private TipoRecursoTecnologico[] tiposDeRecursosTecnologicos;
    private ArrayList <String> cmbTiposDeRecursos;
    private String tipoRecursoSeleccionado;
    private ArrayList<RecursoTecnologico> recursosTecnologicos;
    private ArrayList<RecursoTecnologico> recursosAll ;
    private RecursoTecnologico recursoTecnologicoSeleccionado;
    private Usuario usuarioLogueado;
    private Date fechaActual;
    private ArrayList<Turno> turnoDelRT;
    private Turno turnoSeleccionado;
    private Estado estReservado;
    private String notificacionMail;
    private ArrayList <Estado> estados;
    private Sesion actualSesion; 
    private String correoInstitucionalCientifico;

    public GestorRegistrarReservaTurnoDeRT(PantallaRegistrarReservaTurnoDeRT pantalla) {
        this.pantalla = pantalla;
    }

    /*Constructor de la clase*/
    public ArrayList<Estado> getEstados() {
        return estados;
    }
    
    /*Metodos de la clase*/
    public Sesion getActualSesion() {
        return actualSesion;
    }

    public void setActualSesion(Sesion actualSesion) {
        this.actualSesion = actualSesion;
    }
    
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

    public Usuario getUsuarioLogueado() {
        return usuarioLogueado;
    }

    public void setUsuarioLogueado(Usuario usuarioLogueado) {
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

    // Metodos de la clase que se usa en el CU23
    /*Inicia el Caso de Uso (1)*/ 
    public void tomarOpcionReservarTurnoDeRecursoTecnologico( 
            TipoRecursoTecnologico[] tiposRTs, ArrayList rts, ArrayList estados, ArrayList centrosArray,
            Sesion sesion) throws InterruptedException{ 
        
        pantalla.setGestor(this);
        setActualSesion(sesion);
        setTiposDeRecursosTecnologicos(tiposRTs);
        setRecursosTecnologicos(rts);
        setEstados(estados);

        while(this.pantalla.getBtnOpcionReservarTurnoDeRT() == 0)
        {
            //(2)
            this.pantalla.habilitarPantalla();
        }
        if(this.pantalla.getBtnOpcionReservarTurnoDeRT() == 1){
            
            /*DEVUELVE UN ARRAY QUE CONTIENE TODOS LOS TIPOS DE RECURSO POSIBLES*/
            //(3)
            this.opcionReservaTurnoDeRT(this.pantalla.getBtnOpcionReservarTurnoDeRT());
 
            /*Se muestra los tipos de RT*/ //(6)
            this.pantalla.mostrarTiposDeRecursos();
            
            //(7)
            this.pantalla.solicitarSeleccionTipoDeRecurso();
                
            /*Se manda al gestor para que pueda obtener todos los recursos con el tipo pasado por parametro*/            
            recursosTecnologicos = buscarRTDeTipoSeleccionado(this.getTipoRecursoSeleccionado()); //(10)
            
            /*LE PASA LOS RECURSOS A LA PANTALLA*/ /////////////////////////RAAARO///////////////////////////////////////
            //this.pantalla.setListaRT(recursosTecnologicos);
            
            /*Se busca y obtiene los datos de los recursos*/ //(15)
            recursosAll = buscarInformacionRecursosTecnologicos(recursosTecnologicos);
          
            /*agruparRTPorCI() setea todos los centros que existen en un array list*/
            this.pantalla.setCentrosInvestigacion(centrosArray);                             
            
            /*Lleva los recursos a la pantalla para que los pueda mostrar por centro de investigacion*/
            this.pantalla.mostrarRTAgrupados(recursosAll); // 27 
            
            /*tomarRecursoTecnologicoSeleccionado()*/ //(32)
            setRecursoTecnologicoSeleccionado(this.pantalla.getRecursoSeleccionado());
            
            /*CIENTIFICO 1 SERN,CIENTIFICO 2 NASA, CIENTIFICO 3 SPACE X  CAMBIARLO PARA PROBAR*/
            buscarUsuarioLogueado(); //33
            
            correoInstitucionalCientifico = obtenerInformacionCientificoLogueado(); //35 revisa cambiar el nombre a Obtener CorreodeUsuario
 
            /*Obtiene la hora actual del sistema*/ //41
            setFechaActual(obtenerFechaYHoraActual());
            
            /*se obtiene turnos del RT*/
            obtenerTurnosDelRTSeleccionado();//42
            

            while(this.pantalla.getTurnoSeleccionado() == null){
                this.pantalla.mostrarTurnos(getTurnoDelRT(),fechaActual);//50
            }            /*solicitarSeleccionDeTurno() y tomarTurnoSeleccionado()*///48 49
            
            //mostrarDeNotificacio() y solicitarOpcionDeNotificacio() lo hace por checkbox en pantalla
            
            //solicitarConfirmacionReservaDeTurno() y tomatConfirmacionDeReservaDeTurno() lo hace con el boton Confrmar
            
            //Realizar reserva
            reservarTurnoDeRT();//60
            
            //enviar notificacion por mail
            generarNotificacionPorMail(correoInstitucionalCientifico); //69                  
        }
    }
    
    public ArrayList <String> opcionReservaTurnoDeRT(int a) {
        /*Metodo inicia que llama al metodo que busca los tipos de recurso y los devuelve*/
        if(a == 1){
            this.buscarTiposDeRecursos();//(4)
            return this.cmbTiposDeRecursos;
        }
        return null;        
    }
    
    public void buscarTiposDeRecursos() {
        /*Metodo que busca los tipos de recursos y los trae*/
        ArrayList<String> a = new ArrayList<>();
    
        for(int i=0;i<this.tiposDeRecursosTecnologicos.length;i++){           
            //(5)
            a.add(i,tiposDeRecursosTecnologicos[i].getNombre());         
        }        
        this.pantalla.setCmbTiposDeRecursos(a);
    }
    
    // (9)
    public void tomarTipoDeRecursoSeleccionado(String tipoDeRecursoSeleccionado){
        this.setTipoRecursoSeleccionado(tipoDeRecursoSeleccionado);
    }
    
    public ArrayList<RecursoTecnologico> buscarRTDeTipoSeleccionado(String tipo) {
        /*Se busca todos los recursos que coincidan con el tipo y luego se valida que sean reservables*/
        ArrayList<RecursoTecnologico> tipoR = new ArrayList<>();
        for(int i = 0; i<this.recursosTecnologicos.size() ; i++){ 
           
            if(((this.recursosTecnologicos.get(i).esTipoRTSeleccionado(tipo) || tipo.equals("TODOS")) //11
                && this.recursosTecnologicos.get(i).obtenerRTReservable()))//12
            {   
                tipoR.add(recursosTecnologicos.get(i)); 
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
            recursosDatos.add(i, recursos.get(i).mostrarRT()); //16
        }
        return recursosDatos;        
    }
    
    public void buscarUsuarioLogueado() { 
        
        setUsuarioLogueado(actualSesion.getUsuario()); //33
    }
    
    public Date obtenerFechaYHoraActual() { 
        Date horaActual = new Date();
        horaActual.getTime();
        return horaActual;        
    }

    public void reservarTurnoDeRT() {
        this.buscarEstadoReservado();//60
        this.recursoTecnologicoSeleccionado.reservarTurnoSeleccionado(getEstReservado(),this.pantalla.getTurnoSeleccionado(),getFechaActual());
            
    }

    private void buscarEstadoReservado() {
        
        /*Recorrer la clase estado con todos y preguntar si el string ambito es igual a el atributo ambito*/      
        for(int i = 0; i < this.estados.size(); i++){
            if(this.estados.get(i).esAmbitoTurno() && this.estados.get(i).esReservado())//61 y 62
            {
                this.setEstReservado(this.estados.get(i));
            }
        }
    }
    
    public ArrayList<Turno> obtenerTurnosDelRTSeleccionado() {
        /*TRAE LOS TURNOS PARA EL RECURSO SELECCIONADO*/
        this.turnoDelRT = this.recursoTecnologicoSeleccionado.buscarTurnosDesdeFechaYHoraActual(this.fechaActual);//43
        return this.turnoDelRT;    
    }
    
    public void generarNotificacionPorMail(String correoInstitucionalCientifico) {
        this.pantalla.pantallaConfirmacion(correoInstitucionalCientifico); //70 enviarMail()
    }

    private String obtenerInformacionCientificoLogueado() {
       if(recursoTecnologicoSeleccionado.esCientificoDeMiCI(usuarioLogueado) != null){
            return recursoTecnologicoSeleccionado.esCientificoDeMiCI(usuarioLogueado); //36
        }
        return "CIENTIFICO NO PERTENECE AL MISMO CENTRO DEL RECURSO SELECCIONADO";
    }
}