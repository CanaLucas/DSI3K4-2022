
package com.yoprogramo.dsicu23;

import java.util.ArrayList;
import java.util.Date;

public class RecursoTecnologico {
    private Integer numeroRT;
    private Date fechaAlta;
    private String imagenes;
    private Date perioricidadMantenimientoPrev;
    private Integer duracionMantenimientoPrev; 
    private String fraccionHorarioTurnos;
    
    private Modelo modelo;              
    private TipoRecursoTecnologico tipoRecurso;
    private ArrayList <CambioEstadoRT> cambioEstado;
    private ArrayList<Turno> turnos;
    private CentroDeInvestigacion centro;
 
    /*Constructor*/
    public RecursoTecnologico(Integer numeroRT, Date fechaAlta, String imagenes, Date perioricidadMantenimientoPrev, Integer duracionMantenimientoPrev, String fraccionHorarioTurnos, Modelo modelo, TipoRecursoTecnologico tipoRecurso, ArrayList<CambioEstadoRT> cambioEstado, ArrayList<Turno> turnos, CentroDeInvestigacion centro) {
        this.numeroRT = numeroRT;
        this.fechaAlta = fechaAlta;
        this.imagenes = imagenes;
        this.perioricidadMantenimientoPrev = perioricidadMantenimientoPrev;
        this.duracionMantenimientoPrev = duracionMantenimientoPrev;
        this.fraccionHorarioTurnos = fraccionHorarioTurnos;
        this.modelo = modelo;
        this.tipoRecurso = tipoRecurso;
        this.cambioEstado = cambioEstado;
        this.turnos = turnos;
        this.centro = centro;
    }
    
    /*Metodos de la Clase*/
    public Integer getNumeroRT() {
        return numeroRT;
    }

    public void setNumeroRT(Integer numeroRT) {
        this.numeroRT = numeroRT;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getImagenes() {
        return imagenes;
    }

    public void setImagenes(String imagenes) {
        this.imagenes = imagenes;
    }

    public Date getPerioricidadMantenimientoPrev() {
        return perioricidadMantenimientoPrev;
    }

    public void setPerioricidadMantenimientoPrev(Date perioricidadMantenimientoPrev) {
        this.perioricidadMantenimientoPrev = perioricidadMantenimientoPrev;
    }

    public Integer getDuracionMantenimientoPrev() {
        return duracionMantenimientoPrev;
    }

    public void setDuracionMantenimientoPrev(Integer duracionMantenimientoPrev) {
        this.duracionMantenimientoPrev = duracionMantenimientoPrev;
    }

    public String getFraccionHorarioTurnos() {
        return fraccionHorarioTurnos;
    }

    public void setFraccionHorarioTurnos(String fraccionHorarioTurnos) {
        this.fraccionHorarioTurnos = fraccionHorarioTurnos;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public TipoRecursoTecnologico getTipoRecurso() {
        return tipoRecurso;
    }

    public void setTipoRecurso(TipoRecursoTecnologico tipoRecurso) {
        this.tipoRecurso = tipoRecurso;
    }

    public ArrayList<CambioEstadoRT> getCambioEstado() {
        return cambioEstado;
    }

    public void setCambioEstado(ArrayList<CambioEstadoRT> cambioEstado) {
        this.cambioEstado = cambioEstado;
    }

    public ArrayList<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(ArrayList<Turno> turnos) {
        this.turnos = turnos;
    }   

    // seria el Metodo de conocerCentroDeInvestigacion()
    public CentroDeInvestigacion getCentro() {
        return centro;
    }

    public void setCentro(CentroDeInvestigacion centro) {
        this.centro = centro;
    }
    
    // Metodos de la clase que se usa en el CU23
    
    public boolean esTipoRTSeleccionado(String tipo) {
         /*VALIDA QUE EL TIPO DEL RECURSO COINCIDA CON EL QUE SE LE PASA POR PARAMETRO */
        return this.getTipoRecurso().getNombre().equals(tipo);
    }

    public boolean obtenerRTReservable() {
        
        /* Se recorren todos los cambios de estado que tenga el recurso y encuentro el actual sabiendo q no tiene fecha hasta*/
        for(int i = 0; i < this.cambioEstado.size();i++){
            /*(13) */
            if (this.cambioEstado.get(i).esUltimoCambioEstadoRT()== true){
                // (14)
                if(this.cambioEstado.get(i).getEstado().esReservable() == true){
                   return true;
                }   
            }
        }
        return false;
    }       
       
    public CambioEstadoRT ultimoCambioEstado() {
        //devulve el ultimo cambio de estado
        for(int i = 0; i < this.cambioEstado.size();i++){
            
            if(this.cambioEstado.get(i).esUltimoCambioEstadoRT()){
                return this.cambioEstado.get(i); ///(23) revisar
            }
        }
        return null;
    }
    
    public RecursoTecnologico mostrarRT() {
        /*Se muestra la info para el RT*/      
        this.getNumeroRT(); //(17)
        this.miModeloYMarca(); //(18)
        this.ultimoCambioEstado();//(22)
        this.conocerCentroDeInvestigacion();//25
        return this;
    }
    
    public String toString(){
        return "Numero: "+this.getNumeroRT() + "-" +"Modelo: "+ this.getModelo().getNombre()+"--"+"Marca: "+ this.getModelo().conocerMarca()+"--"+"Estado: "+this.ultimoCambioEstado().getEstado().getNombre();
    }

    public ArrayList<Turno> buscarTurnosDesdeFechaYHoraActual(Date fechaActual) {
        
        ArrayList<Turno> turnoRecurso = new ArrayList<>();
        
        for(int i =0; i< this.turnos.size();i++){
            
            if(this.turnos.get(i).esDesdeFechaYHoraActual(fechaActual))//44
            {    
                Turno a = this.turnos.get(i).mostrarTurno(this.turnos.get(i));//45
                turnoRecurso.add(a);
            }
        }
        return turnoRecurso;
    }

    public void reservarTurnoSeleccionado(Estado reservado, Turno turnoSeleccionado, Date fechaActual) {
        turnoSeleccionado.reservar(reservado,fechaActual);//64
    }
    
    public void miModeloYMarca() {
        modelo.getNombre();//(19)
        modelo.conocerMarca();//(20)
    }

    public String esCientificoDeMiCI(Usuario user) {
        if (centro.misCientificosActivos(user) != null) {
            return centro.misCientificosActivos(user); //37
        }
        return null;
    }
    
    public void conocerCentroDeInvestigacion(){
        this.centro.getNombre();//26
    }
}