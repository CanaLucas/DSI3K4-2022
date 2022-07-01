
package com.yoprogramo.dsicu23;

import java.util.ArrayList;
import java.util.Date;


public class Turno {
    private Date fechaGeneracion;
    private String diaSemana;
    private Date fechaHoraInicio;
    private Date fechaHoraFin;
    private ArrayList <CambioEstadoTurno> cambioEstadoTurno;  /* Relacion a cambio de estados*/
    
    /*Contructor*/
    public Turno(Date fechaGeneracion, String diaSemana, Date fechaHoraInicio, Date fechaHoraFin, ArrayList<CambioEstadoTurno> cambioEstadoTurno) {
        this.fechaGeneracion = fechaGeneracion;
        this.diaSemana = diaSemana;
        this.fechaHoraInicio = fechaHoraInicio;
        this.fechaHoraFin = fechaHoraFin;
        this.cambioEstadoTurno = cambioEstadoTurno;
    }

    /*Metodos*/
    public Date getFechaGeneracion() {
        return fechaGeneracion;
    }

    public void setFechaGeneracion(Date fechaGeneracion) {
        this.fechaGeneracion = fechaGeneracion;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public Date getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public void setFechaHoraInicio(Date fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }

    public Date getFechaHoraFin() {
        return fechaHoraFin;
    }

    public void setFechaHoraFin(Date fechaHoraFin) {
        this.fechaHoraFin = fechaHoraFin;
    }

    public ArrayList<CambioEstadoTurno> getCambioEstadoTurno() {
        return cambioEstadoTurno;
    }

    public void setCambioEstadoTurno(ArrayList<CambioEstadoTurno> cambioEstadoTurno) {
        this.cambioEstadoTurno = cambioEstadoTurno;
    }
    
    /*PREGUNTA SI LA HORA QUE SE LE PASA POR PARAMETRO ES MENOR A LA HORA DE INICIO DEL TURNO*/
    public boolean esDesdeHoraFechaYHoraActual(Date fechaActual) {
        return this.fechaHoraInicio.after(fechaActual);
    }

    public Turno mostrarTurno(Turno t) {
        
        for (int i = 0; i< this.cambioEstadoTurno.size();i++){
            if(this.cambioEstadoTurno.get(i).esUltimoCambioEstadoTurno()){
                this.cambioEstadoTurno.get(i).getEstado().getNombre();
            }
                
        }
        return this;
    } 

    public void reservar(Estado reservado, Date fechaActual) {
        CambioEstadoTurno ultimoCE = this.conocerEstadoActual();
        if(ultimoCE != null){
            ultimoCE.setFechaHoraHasta(fechaActual);
            this.crearNuevoCambio(reservado,fechaActual);        
        }
        
    }

    public CambioEstadoTurno conocerEstadoActual() {
        for(int i = 0; i < this.cambioEstadoTurno.size();i++){
            if(this.cambioEstadoTurno.get(i).esUltimoCambioEstadoTurno()){
                return this.cambioEstadoTurno.get(i);
            }
        
        }
        return null;
    }

    public void crearNuevoCambio(Estado e, Date fechaActual) {
        CambioEstadoTurno nuevoCmbE = new CambioEstadoTurno(fechaActual,null,e);
    }

    

    
   
    
}