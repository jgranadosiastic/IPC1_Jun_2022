package com.jgranados.ipc1_jun_2022.abstractas;

/**
 *
 * @author jose
 */
public class Circulo extends FiguraGeometrica {

    private int radio;

    public Circulo(int radio) {
        this.radio = radio;
    }

    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * Math.PI * radio;
    }
    
    
}
