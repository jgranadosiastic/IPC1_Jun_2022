/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jgranados.ipc1_jun_2022.listas;

import com.jgranados.ipc1_jun_2022.exceptions.ListaException;

/**
 *
 * @author jose
 */
public class ListasMAin {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ListaSimpleEnlazada<String> lista = new ListaSimpleEnlazada<>();
        lista.agregar("a");
        lista.agregar("b");
        lista.agregar("c");

        try {
            lista.eliminarUltimo();
            lista.eliminarUltimo();
            lista.eliminarUltimo();
        } catch (ListaException e) {
            e.printStackTrace();
        }

    }

}
