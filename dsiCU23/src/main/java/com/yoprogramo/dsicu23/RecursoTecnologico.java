
package com.yoprogramo.dsicu23;

import java.util.ArrayList;
import java.util.Date;


public class RecursoTecnologico {
    private Integer numeroRT;
    private Date fechaAlta;
    private String imagenes;/*Revisar tipo de dato q es*/
    private Date perioricidadMantenimientoPrev;
    private Integer duracionMantenimientoPrev; /*Revisar datos de todos estos q son y como usarlos*/
    private String fraccionHorarioTurnos;
    
    private Modelo modelo;              /*Referencias a la clases del modelo de analisis*/
    private TipoRecursoTecnologico tipoRecurso;
    private CambioEstadoRT cambioEstado;
    private ArrayList<Turno> turnos;
    private CentroDeInvestigacion centro;
 
    /*Constructor*/
    public RecursoTecnologico(Integer numeroRT, Date fechaAlta, String imagenes, Date perioricidadMantenimientoPrev, Integer duracionMantenimientoPrev, String fraccionHorarioTurnos, Modelo modelo, TipoRecursoTecnologico tipoRecurso, CambioEstadoRT cambioEstado, ArrayList<Turno> turnos, CentroDeInvestigacion centro) {    
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

    /*Metodos*/
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

    public CambioEstadoRT getCambioEstado() {
        return cambioEstado;
    }

    public void setCambioEstado(CambioEstadoRT cambioEstado) {
        this.cambioEstado = cambioEstado;
    }

    public ArrayList<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(ArrayList<Turno> turnos) {
        this.turnos = turnos;
    }   

    public CentroDeInvestigacion getCentro() {
        return centro;
    }

    public void setCentro(CentroDeInvestigacion centro) {
        this.centro = centro;
    }
   
    /*VALIDA QUE EL TIPO DEL RECURSO COINCIDA CON EL QUE SE LE PASA POR PARAMETRO */
    public boolean esTipoRTSeleccionado(String tipo) {
        
        if(this.getTipoRecurso().getNombre() == tipo){
            return true;
        }
        return false;
    }

    public boolean obtenerRTReservable() {
        boolean r = this.cambioEstado.esReservable();
        return r;        
    }
    
    /*Este mostrar deberia traer todos los datos de los recursos y guardarlos en el array para que se puedan agrupar y seleccionar, no me queda muy claro que hace*/
    public RecursoTecnologico mostrarRT() {
               
        this.getNumeroRT();
        this.getModelo().getNombre(); 
        this.cambioEstado.esUltimoCambioEstadoRT();
        this.getCentro();
        return this;
    }
    
    /*OTRA DEPENDENCIA PARA IMPLEMENTAR pero lo hago sin por ahora*/
    private void conocerCentroDeInvestigacion() {
    }
    
    public String toString(){
        return "Numero: "+this.getNumeroRT() + "-" +"Modelo: "+ this.getModelo().getNombre()+"--"+"Marca: "+ this.getModelo().conocerMarca()+"--"+"Estado: "+this.getCambioEstado().esUltimoCambioEstadoRT();
    }

    ArrayList<Turno> buscarTurnosDesdeFechaYHoraActual(Date fechaActual) {
        ArrayList<Turno> turnoRecurso = new ArrayList<>();
        for(int i =0; i< this.turnos.size();i++){
            if(this.turnos.get(i).esDesdeHoraFechaYHoraActual(fechaActual)){
                
                Turno a = this.turnos.get(i).mostrarTurno(this.turnos.get(i));
                turnoRecurso.add(a);
            }
        }
        return turnoRecurso;
    }
}
