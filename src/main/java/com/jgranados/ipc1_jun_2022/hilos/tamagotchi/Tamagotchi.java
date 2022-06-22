/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.ipc1_jun_2022.hilos.tamagotchi;

import com.jgranados.ipc1_jun_2022.hilos.tamagotchi.fe.TamagotchiFrame;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jose
 */
public class Tamagotchi extends Thread {
    
    private static final String HAMBRIENTO_TEXT = "Hambriento";
    private static final String SUCIO_TEXT = "Sucio";
    private static final String ENFERMO_TEXT = "Enfermo";
    private static final String NORMAL_TEXT = "Normal";
    private static final String MUERTO_TEXT = "Muerto";
    private static final int VIDA = 100;
    private static final int CAMBIO_ESTADO = 10;
    
    private String image;
    private boolean hambriento;
    private boolean sucio;
    private boolean enfermo;
    
    private int vidaActual = VIDA;
    private int vidaMaxima = VIDA;
    private TamagotchiFrame frontend;
    private String nombre;
    private int contadorCambioEstado = 0;

    public Tamagotchi(String nombre, String image) {
        this.image = image;
        this.nombre = nombre;
        frontend = new TamagotchiFrame(image, this);
    }
    
    @Override
    public void run() {
        while (vidaActual > 0) {
            vidaActual--;
            try {
                sleep(1000);
                definirEstado();
                frontend.actualizarData();
            } catch (InterruptedException ex) {
                // liogica para manejar esta exception
            }
        }
    }
    
    public TamagotchiFrame obtenerFrontend() {
        return frontend;
    }
    
    public String obtenerEstadoTexto() {
        if (sucio) {
            return SUCIO_TEXT;
        } else if (enfermo) {
            return ENFERMO_TEXT;
        } else if (!estaVivo()) {
            return MUERTO_TEXT;
        }
        
        return NORMAL_TEXT;
    }

    public String obtenerNombre() {
        return nombre;
    }

    public String obtenerVidaTexto() {
        return String.format("%d de %d", vidaActual, vidaMaxima);
    }
    
    public boolean estaVivo() {
        return vidaActual > 0;
    }
    
    public void alimentar() {
        vidaActual = VIDA;
    }
    
    public void curar() {
        enfermo = false;
    }
    
    public void limpiar() {
        sucio = false;
    }
    
    private void definirEstado() {
        if (!sucio && !enfermo && contadorCambioEstado >= CAMBIO_ESTADO) {
            Random random = new Random();
            int valor = random.nextInt(100);
            if (valor <= 4) {
                enfermo = true;
            } else if (valor > 4 && valor <= 9) {
                sucio = true;
            }
            contadorCambioEstado = 0;
        }
        contadorCambioEstado++;
    }
}
