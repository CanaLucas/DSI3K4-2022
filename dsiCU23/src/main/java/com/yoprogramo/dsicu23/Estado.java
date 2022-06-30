
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
    /*Devuelve el valor del atributo es reservable*/
    public Boolean EsReservable() {
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
    
    
    
    /*Si el ambito del estado es recurso tecnologico devuelve un true, caso contrario un false*/
    public Boolean esAmbitoRecursoTecnologico(){
    
        if(this.getAmbito() == "Recurso Tecnologico"){
            return true;
        }
        return false;
    }

    
}
