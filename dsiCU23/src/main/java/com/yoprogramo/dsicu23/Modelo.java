
package com.yoprogramo.dsicu23;

public class Modelo {
    /*Definicion de atributos de la clase*/
    private String nombre;
    private Marca marca;
    
    /*Constructor*/
    public Modelo(String nombre, Marca marca) {
        this.nombre = nombre;
        this.marca = marca;
    }
    
    /*Metodos de la clase*/

    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
    
    // Metodos de la clase que se usa en el CU23
    public String conocerMarca(){
        return this.marca.getNombre(); //(21)
    }  
}