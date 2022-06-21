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
public class SimpleHilosImplementadosMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        CajeroHilo cajero1 = new CajeroHilo();
        CajeroHilo cajero2 = new CajeroHilo();
        CajeroHilo cajero3 = new CajeroHilo();
        
        Cliente clienteA = new Cliente(5, "a");
        Cliente clienteB = new Cliente(3, "b");
        Cliente clienteC = new Cliente(8, "c");
        Cliente clienteD = new Cliente(1, "d");
        
        cajero1.setClienteEnProceso(clienteA);
        cajero1.start();
        cajero2.setClienteEnProceso(clienteB);
        cajero2.start();
        cajero3.setClienteEnProceso(clienteC);
        cajero3.start();
        
        cajero1.join();
        cajero2.join();
        cajero3.join();
        
        cajero1 = new CajeroHilo();
        cajero1.setClienteEnProceso(clienteD);
        cajero1.start();
        cajero1.join();
        
        System.out.println("Fin hilo principal");
        
        /*
        cajero1.setClienteEnProceso(clienteD);
        cajero1.start();*/
    }
    
}
