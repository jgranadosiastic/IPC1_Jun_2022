package com.jgranados.ipc1_jun_2022.abstractas;

/**
 *
 * @author jose
 */
public class Triangulo extends FiguraGeometrica {

    private int lado1;
    private int lado2;
    private int ladoBase;
    private int altura;
    
    @Override
    public double calcularArea() {
        return 0.5 * ladoBase * altura;
    }

    @Override
    public double calcularPerimetro() {
        return lado1 + lado2 + ladoBase;
    }
}
