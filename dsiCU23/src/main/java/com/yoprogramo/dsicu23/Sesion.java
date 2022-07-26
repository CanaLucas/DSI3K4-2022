
package com.yoprogramo.dsicu23;

import java.util.Date;

public class Sesion {
    
    private Usuario usuario;
    private Date fechaInicio;
    private Date fechaFin;

    public Sesion(Usuario usuario, Date fechaInicio, Date fechaFin) {
        this.usuario = usuario;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
}