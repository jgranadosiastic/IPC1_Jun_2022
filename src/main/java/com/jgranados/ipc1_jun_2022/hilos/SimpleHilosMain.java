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
public class SimpleHilosMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cajero cajeroUnico = new Cajero();
        Cliente clienteA = new Cliente(5, "a");
        Cliente clienteB = new Cliente(3, "b");
        Cliente clienteC = new Cliente(8, "c");
        Cliente clienteD = new Cliente(1, "d");
        
        cajeroUnico.setClienteEnProceso(clienteA);
        cajeroUnico.atenderCliente();
        cajeroUnico.setClienteEnProceso(clienteB);
        cajeroUnico.atenderCliente();
        cajeroUnico.setClienteEnProceso(clienteC);
        cajeroUnico.atenderCliente();
        /*cajeroUnico.setClienteEnProceso(clienteD);
        cajeroUnico.atenderCliente();*/
        
    }
    
}
