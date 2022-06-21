package com.jgranados.ipc1_jun_2022.hilos;

/**
 *
 * @author jose
 */
public class Cliente {

    private int articulos;
    private String nombre;

    public Cliente(int articulos, String nombre) {
        this.articulos = articulos;
        this.nombre = nombre;
    }

    public int getArticulos() {
        return articulos;
    }

    public String getNombre() {
        return nombre;
    }
    
    
    
}
