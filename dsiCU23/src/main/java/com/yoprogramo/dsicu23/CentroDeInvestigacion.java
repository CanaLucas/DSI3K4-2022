
package com.yoprogramo.dsicu23;

import java.util.ArrayList;
import java.util.Date;


public class CentroDeInvestigacion {
    /*Definicion de los atributos de la clase*/
    private String nombre;
    private String sigla;
    private String direccion;
    private String edificio;
    private String piso;
    private String coordenadas;
    private String telefonosContacto; /*Es un string o deberia ser un array de telefonos*/
    private String correoElectronico;
    private Integer numeroResolucionCreacion;
    private Date fechaResolucionCreacion;
    private String reglamento;
    private String caracteristicasGenerales;
    private Date fechaAlta;
    private Integer tiempoAntelacionReserva; /*Fijarse el tipo de dato q es*/
    private Date fechaBaja;
    private String motivoBaja;
    private ArrayList<RecursoTecnologico> recursosTecnologicos; /*Referencias a otras clases*/
    private ArrayList<AsignacionCientificoDelCI> asignacionCientifico;
    
    /* Constructor de la clase*/
    public CentroDeInvestigacion(String nombre, String sigla, String direccion, String edificio, String piso, String coordenadas, String telefonosContacto, String correoElectronico, Integer numeroResolucionCreacion, Date fechaResolucionCreacion, String reglamento, String caracteristicasGenerales, Date fechaAlta, Integer tiempoAntelacionReserva, Date fechaBaja, String motivoBaja, ArrayList<RecursoTecnologico> recursosTecnologicos, ArrayList<AsignacionCientificoDelCI> asignacionCientifico) {
        this.nombre = nombre;
        this.sigla = sigla;
        this.direccion = direccion;
        this.edificio = edificio;
        this.piso = piso;
        this.coordenadas = coordenadas;
        this.telefonosContacto = telefonosContacto;
        this.correoElectronico = correoElectronico;
        this.numeroResolucionCreacion = numeroResolucionCreacion;
        this.fechaResolucionCreacion = fechaResolucionCreacion;
        this.reglamento = reglamento;
        this.caracteristicasGenerales = caracteristicasGenerales;
        this.fechaAlta = fechaAlta;
        this.tiempoAntelacionReserva = tiempoAntelacionReserva;
        this.fechaBaja = fechaBaja;
        this.motivoBaja = motivoBaja;
        this.recursosTecnologicos = recursosTecnologicos;
        this.asignacionCientifico = asignacionCientifico;
    }
 
    /*Metodos de la clase*/

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEdificio() {
        return edificio;
    }

    public void setEdificio(String edificio) {
        this.edificio = edificio;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(String coordenadas) {
        this.coordenadas = coordenadas;
    }

    public String getTelefonosContacto() {
        return telefonosContacto;
    }

    public void setTelefonosContacto(String telefonosContacto) {
        this.telefonosContacto = telefonosContacto;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public Integer getNumeroResolucionCreacion() {
        return numeroResolucionCreacion;
    }

    public void setNumeroResolucionCreacion(Integer numeroResolucionCreacion) {
        this.numeroResolucionCreacion = numeroResolucionCreacion;
    }

    public Date getFechaResolucionCreacion() {
        return fechaResolucionCreacion;
    }

    public void setFechaResolucionCreacion(Date fechaResolucionCreacion) {
        this.fechaResolucionCreacion = fechaResolucionCreacion;
    }

    public String getReglamento() {
        return reglamento;
    }

    public void setReglamento(String reglamento) {
        this.reglamento = reglamento;
    }

    public String getCaracteristicasGenerales() {
        return caracteristicasGenerales;
    }

    public void setCaracteristicasGenerales(String caracteristicasGenerales) {
        this.caracteristicasGenerales = caracteristicasGenerales;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Integer getTiempoAntelacionReserva() {
        return tiempoAntelacionReserva;
    }

    public void setTiempoAntelacionReserva(Integer tiempoAntelacionReserva) {
        this.tiempoAntelacionReserva = tiempoAntelacionReserva;
    }

    public Date getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(Date fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public String getMotivoBaja() {
        return motivoBaja;
    }

    public void setMotivoBaja(String motivoBaja) {
        this.motivoBaja = motivoBaja;
    }

    public ArrayList<RecursoTecnologico> getRecursosTecnologicos() {
        return recursosTecnologicos;
    }

    public void setRecursosTecnologicos(ArrayList<RecursoTecnologico> recursosTecnologicos) {
        this.recursosTecnologicos = recursosTecnologicos;
    }

    public ArrayList<AsignacionCientificoDelCI> getAsignacionCientifico() {
        return asignacionCientifico;
    }

    public void setAsignacionCientifico(ArrayList<AsignacionCientificoDelCI> asignacionCientifico) {
        this.asignacionCientifico = asignacionCientifico;
    }
   public boolean tieneAlMenosUnRecurso(String tipo){
       
       for(int i = 0;i<this.recursosTecnologicos.size();i++){
           
           if(this.getNombre() == this.recursosTecnologicos.get(i).getCentro().getNombre() && (this.recursosTecnologicos.get(i).getTipoRecurso().getNombre() == tipo)|| tipo == "TODOS"){
              if(this.recursosTecnologicos.get(i).obtenerRTReservable()){
                  return true;
                  
              }
                   
           }
       }
       return false;
   }

    public String misCientificosActivos(PersonalCientifico a) {
        for(int i =0; i < this.asignacionCientifico.size();i++){
            if(this.asignacionCientifico.get(i).esCientificoActivo() != null){
                return this.asignacionCientifico.get(i).esCientificoActivo();
            }
        
        }
        return "No se encuentra conectado";
    }
}