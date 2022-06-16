/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jgranados.ipc1_jun_2022.abstractas;

/**
 *
 * @author jose
 */
public class AbstractasEInterfacesMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FiguraGeometrica[] figuras = new FiguraGeometrica[3];
        Circulo circulo = new Circulo(5);
        Cuadrado cuadrado = new Cuadrado(2);
        Circulo circulo2 = new Circulo(4);
        
        CirculoDibujable circuloDibujable = new CirculoDibujable(6);
        
        figuras[0] = circulo;
        figuras[1] = cuadrado;
        figuras[2] = circuloDibujable;
        
        for (int i = 0; i < figuras.length; i++) {
            System.out.println("Area: " + figuras[i].calcularArea());
            if (figuras[i] instanceof Dibujable) {
                ((Dibujable) figuras[i]).dibujar();
            }
        }
    }
    
}
