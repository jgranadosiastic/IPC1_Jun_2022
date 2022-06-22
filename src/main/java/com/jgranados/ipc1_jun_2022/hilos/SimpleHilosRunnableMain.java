/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jgranados.ipc1_jun_2022.hilos;

/**
 *
 * @author jose
 */
public class SimpleHilosRunnableMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CajeroRunnable cajeroRunnable1 = new CajeroRunnable();
        CajeroRunnable cajeroRunnable2 = new CajeroRunnable();
        CajeroRunnable cajeroRunnable3 = new CajeroRunnable();
        
        Cliente clienteA = new Cliente(5, "a");
        Cliente clienteB = new Cliente(3, "b");
        Cliente clienteC = new Cliente(8, "c");
        Cliente clienteD = new Cliente(1, "d");
        
        cajeroRunnable1.setClienteEnProceso(clienteA);
        cajeroRunnable2.setClienteEnProceso(clienteB);
        cajeroRunnable3.setClienteEnProceso(clienteC);
        
        Thread hilo1 = new Thread(cajeroRunnable1);
        Thread hilo2 = new Thread(cajeroRunnable2);
        Thread hilo3 = new Thread(cajeroRunnable3);
        
        hilo1.start();
        hilo2.start();
        hilo3.start();
        
        
    }
    
}
