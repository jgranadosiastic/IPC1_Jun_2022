package com.jgranados.ipc1_jun_2022.abstractas;

/**
 *
 * @author jose
 */
public class Cono extends Volumen {

    private int altura;
    private int base;
    
    @Override
    public double calcularVolumen() {
        return Math.PI * altura * base;
    }

    
}
