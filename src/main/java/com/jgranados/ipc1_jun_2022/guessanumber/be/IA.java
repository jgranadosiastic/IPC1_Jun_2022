package com.jgranados.ipc1_jun_2022.guessanumber.be;

import java.util.Random;

/**
 *
 * @author jose
 */
public class IA {
    private static final int CANTIDAD_FALLOS_PERMITIDOS = 5;
    private static final int PUNTOS = 10;
    
    private int numeroAdivinar;
    private int cantidadFallosSeguidos;
    
    public int generarNumero() {
        Random random = new Random();
        numeroAdivinar = random.nextInt(101);
        System.out.println("numero: " + numeroAdivinar);
        return numeroAdivinar;
    }
    
    public boolean validarEntrada(int entrada, Jugador jugador) {
        if (numeroAdivinar == entrada) {
            jugador.darPuntos(PUNTOS);
            reiniciarFallos();
            generarNumero();
            return true;
        } else {
            aumentarFallos();
            return false;
        }
        
    }
    
    public void reiniciarFallos() {
        cantidadFallosSeguidos = 0;
    }
    
    public void aumentarFallos() {
        cantidadFallosSeguidos++;
    }
    
    public boolean sigueConVida() {
        boolean sigueConVida = cantidadFallosSeguidos < CANTIDAD_FALLOS_PERMITIDOS;
        if (!sigueConVida) {
            reiniciarFallos();
        }
        return sigueConVida;
    }
    
    public int obtenerIntentosRestantes() {
        return CANTIDAD_FALLOS_PERMITIDOS - cantidadFallosSeguidos;
    }
}
