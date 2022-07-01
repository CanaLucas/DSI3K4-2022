
package com.yoprogramo.dsicu23;

public class TipoRecursoTecnologico {
    private String nombre;
    private String descripcion;
    
    /*Contructor*/
    public TipoRecursoTecnologico(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }   
    
    /*Metodos de la clase*/
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
}