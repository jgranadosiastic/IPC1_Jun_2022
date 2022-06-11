package com.jgranados.ipc1_jun_2022.herencia;

/**
 *
 * @author jose
 */
public class BicicletaVelocidad extends Bicicleta {
    
    private int peso;
    
    public void frenarDespacio() {
        velocidad--;
        System.out.println("la bicicleta de velocidad está frenando Despacio");
    }

}
