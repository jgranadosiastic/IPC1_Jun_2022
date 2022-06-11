package com.jgranados.ipc1_jun_2022.herencia;

/**
 *
 * @author jose
 */
public class BicicletaMontaña extends Bicicleta {

    private int amortiguadorFrontal;
    private int amortiguadorTrasero;
    
    public void absorberImpacto() {
        System.out.println("Absorbiendo impacto");
    }
    
    public void cambiarCadena(int numeroCadena) {
        System.out.println("esto es en bicicleta monta;a");
    }
}
