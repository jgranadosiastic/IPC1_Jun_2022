package com.jgranados.ipc1_jun_2022.buscaminas.be.partida;

/**
 *
 * @author jose
 */
public class Jugador {
    private String nombre;

    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    public String obtenerNombre() {
        return nombre;
    }
    
}
