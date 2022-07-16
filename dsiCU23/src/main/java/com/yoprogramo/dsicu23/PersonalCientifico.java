
package com.yoprogramo.dsicu23;

public class PersonalCientifico {

    /*Atributos de la clase*/
    private Integer legajo;
    private String nombre;
    private String apellido;
    private Integer numeroDocumento;
    private String correoElectronicoInstitucional;
    private String correoElectronicoPersonal;
    private Integer telefonoCelular;
    private Usuario usuario;
   
    /*Constructor de la clase*/

    public PersonalCientifico(Integer legajo, String nombre, String apellido, Integer numeroDocumento, String correoElectronicoInstitucional, String correoElectronicoPersonal, Integer telefonoCelular, Usuario usuario) {
        this.legajo = legajo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroDocumento = numeroDocumento;
        this.correoElectronicoInstitucional = correoElectronicoInstitucional;
        this.correoElectronicoPersonal = correoElectronicoPersonal;
        this.telefonoCelular = telefonoCelular;
        this.usuario = usuario;
    }
    
    /*Metodos de la clase*/

    public Integer getLegajo() {
        return legajo;
    }// se usa

    public void setLegajo(Integer legajo) {
        this.legajo = legajo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(Integer numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getCorreoElectronicoInstitucional() {
        return correoElectronicoInstitucional;
    }

    public void setCorreoElectronicoInstitucional(String correoElectronicoInstitucional) {
        this.correoElectronicoInstitucional = correoElectronicoInstitucional;
    }

    public String getCorreoElectronicoPersonal() {
        return correoElectronicoPersonal;
    }

    public void setCorreoElectronicoPersonal(String correoElectronicoPersonal) {
        this.correoElectronicoPersonal = correoElectronicoPersonal;
    }

    public Integer getTelefonoCelular() {
        return telefonoCelular;
    }

    public void setTelefonoCelular(Integer telefonoCelular) {
        this.telefonoCelular = telefonoCelular;
    }
    
    // Metodos de la clase que se usa en el CU23
    public boolean esUsuarioLogueado(Usuario a){
        return a.equals(usuario);
    }
}