
package com.yoprogramo.dsicu23;

public class Estado {
    
    /*Definicion de los atributos de la clase*/
    private String nombre;
    private String descripcion;
    private String ambito;
    private Boolean esReservable;
    private Boolean esCancelable;
    
    /*Definicion del constructor*/
    public Estado(String nombre, String descripcion, String ambito, Boolean esReservable, Boolean esCancelable) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.ambito = ambito;
        this.esReservable = esReservable;
        this.esCancelable = esCancelable;
    }

    /* Metodos de la clase*/

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAmbito() {
        return ambito;
    }

    public void setAmbito(String ambito) {
        this.ambito = ambito;
    }

    public Boolean getEsReservable() {
        return esReservable;
    }

    public void setEsReservable(Boolean esReservable) {
        this.esReservable = esReservable;
    }

    public Boolean getEsCancelable() {
        return esCancelable;
    }

    public void setEsCancelable(Boolean esCancelable) {
        this.esCancelable = esCancelable;
    }
    
    // Metodos de la clase que se usa en el CU23
    
    public boolean esReservado(){
        return "Reservado".equals(this.getNombre());
    }

    public boolean esAmbitoTurno() {
        return "Turno".equals(this.getNombre());
    } 

    public boolean esReservable() {
        return this.getEsReservable()==true;
    }
}