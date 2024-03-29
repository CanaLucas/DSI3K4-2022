
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
    
    public void setFechaHasta(Date fechaHasta) {
        this.fechaHasta = fechaHasta;
    }
    
    public PersonalCientifico getPersonalCientifico() {
        return personalCientifico;
    }

    public void setPersonalCientifico(PersonalCientifico personalCientifico) {
        this.personalCientifico = personalCientifico;
    }
    
    // Metodos de la clase que se usa en el CU23
    
    public String esCientificoActivo(Usuario a){
          
        /*Verifica que el cientifico siga en el centro ya que no tiene una fecha hasta*/  
        if(this.getFechaHasta() == null && personalCientifico.esUsuarioLogueado(a)==true) //38
        {
            return personalCientifico.getCorreoElectronicoInstitucional(); //39        
        }
        return null;
    }
}