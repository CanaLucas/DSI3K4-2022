
package com.yoprogramo.dsicu23;

import java.util.Date;

public class CambioEstadoTurno {
    private Date fechaHoraDesde;
    private Date fechaHoraHasta;
    private Estado estado; /* relacion a estado*/
    
    /*Constructor de la clase*/
    public CambioEstadoTurno(Date fechaHoraDesde, Date fechaHoraHasta, Estado estado) {
        this.fechaHoraDesde = fechaHoraDesde;
        this.fechaHoraHasta = fechaHoraHasta;
        this.estado = estado;
    }
    
    /*Metodos de la clase*/

    public Date getFechaHoraDesde() {
        return fechaHoraDesde;
    }

    public void setFechaHoraDesde(Date fechaHoraDesde) {
        this.fechaHoraDesde = fechaHoraDesde;
    }

    public Date getFechaHoraHasta() {
        return fechaHoraHasta;
    }

    public void setFechaHoraHasta(Date fechaHoraHasta) {
        this.fechaHoraHasta = fechaHoraHasta;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    public boolean esUltimoCambioEstadoTurno(){
        if(this.getFechaHoraHasta() == null){
            return true;
        }
        return false;
    
    }
    
}