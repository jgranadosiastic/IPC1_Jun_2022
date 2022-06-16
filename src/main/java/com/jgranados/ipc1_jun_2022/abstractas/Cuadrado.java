package com.jgranados.ipc1_jun_2022.abstractas;

/**
 *
 * @author jose
 */
public class Cuadrado extends FiguraGeometrica {
    private int lado;

    public Cuadrado(int lado) {
        this.lado = lado;
    }

    
    @Override
    public double calcularArea() {
        return lado * lado;
    }

    @Override
    public double calcularPerimetro() {
        return 4 * lado;
    }
    
    
    
}
