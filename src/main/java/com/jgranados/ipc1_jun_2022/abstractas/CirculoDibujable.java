package com.jgranados.ipc1_jun_2022.abstractas;

/**
 *
 * @author jose
 */
public class CirculoDibujable extends Circulo implements Dibujable {
    
    public CirculoDibujable(int radio) {
        super(radio);
    }
    @Override
    public void dibujar() {
        System.out.println("Dibujando Circulo");
    }
}
