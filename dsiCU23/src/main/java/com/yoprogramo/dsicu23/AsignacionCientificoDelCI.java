
package com.yoprogramo.dsicu23;

import java.util.Date;

public class AsignacionCientificoDelCI {
    
    private Date fechaDesde;
    private Date fechaHasta;
    private PersonalCientifico personalCientifico;
    
    /* Constructor de la clase */
    public AsignacionCientificoDelCI(Date fechaDesde, Date fechaHasta, PersonalCientifico personalCientifico) {
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        this.personalCientifico = personalCientifico;
    }
   
    /* Definición de los metodos de la clase*/

    public Date getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(Date fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public Date getFechaHasta() {
        return fechaHasta;
    }

    public PersonalCientifico getPersonalCientifico() {
        return personalCientifico;
    }

    public void setPersonalCientifico(PersonalCientifico personalCientifico) {
        this.personalCientifico = personalCientifico;
    }
    
    public void setFechaHasta(Date fechaHasta) {
        this.fechaHasta = fechaHasta;
    }
    
    /*Verifica que el cientifico siga en el centro ya que no tiene una fecha hasta*/
    public String esCientificoActivo(){
    
        if(this.getFechaHasta() == null){
            String correo = this.personalCientifico.getCorreoElectronicoInstitucional();
            return correo;
        }
        return null;
    }
}