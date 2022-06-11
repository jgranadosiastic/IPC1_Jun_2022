/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jgranados.ipc1_jun_2022.herencia;

/**
 *
 * @author jose
 */
public class MainBicicleta {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Bicicleta normal1 = new Bicicleta();
        BicicletaMontaña montaña1 = new BicicletaMontaña();
        BicicletaVelocidad velocidad1 = new BicicletaVelocidad();
        BicicletaSuperMontaña super1 = new BicicletaSuperMontaña();
        
        Bicicleta[] arrBicicleta = new Bicicleta[4];
        
        arrBicicleta[0] = normal1;
        arrBicicleta[1] = montaña1;
        arrBicicleta[2] = velocidad1;
        arrBicicleta[3] = super1;
        
        normal1.cambiarCadena(4);
        montaña1.cambiarCadena(4);
        velocidad1.cambiarCadena(4);
        super1.cambiarCadena(4);
        System.out.println("------------");
        for (int i = 0; i < arrBicicleta.length; i++) {
            Bicicleta bicicleta = arrBicicleta[i];
            bicicleta.cambiarCadena(i);
            if (bicicleta instanceof BicicletaVelocidad) {
                BicicletaVelocidad nuevaVariable = (BicicletaVelocidad) bicicleta;
                nuevaVariable.frenarDespacio();
            }
        }
        
    }
    
}
