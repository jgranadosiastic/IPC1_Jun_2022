package com.jgranados.ipc1_jun_2022.guessanumber.be;

/**
 *
 * @author jose
 */
public class Jugador {
    private String nombre;
    private int punteo;

    public Jugador(String nombre) {
        this.nombre = nombre;
    }
    
    public String obtenerNombre() {
        return nombre;
    }
    
    public int obtenerPunteo() {
        return punteo;
    }
    
    public void darPuntos(int puntos) {
        punteo += puntos;
    }
    
    public String[] obtenerDatosEnFormaDeFila() {
        return new String[] {nombre, ""+ punteo};
    }
    
}
