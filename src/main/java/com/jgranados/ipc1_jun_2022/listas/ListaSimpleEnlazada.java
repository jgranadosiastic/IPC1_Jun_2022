package com.jgranados.ipc1_jun_2022.listas;

import com.jgranados.ipc1_jun_2022.exceptions.ListaException;

/**
 *
 * @author jose
 */
public class ListaSimpleEnlazada<T> {
    
    private Nodo<T> inicio;
    private Nodo<T> ultimo;
    private int longitud = 0; 

    public void agregar(T elemento) {
        if (estaVacia()) {
            /*Nodo<T> nodo = new Nodo<>(elemento);
            inicio = nodo;
            ultimo = nodo;*/
            
            inicio = new Nodo<>(elemento);
            ultimo = inicio;
        } else {
            Nodo<T> nodo = new Nodo<>(elemento);
            ultimo.setSiguiente(nodo);
            ultimo = nodo;
        }
        longitud++;
    }
    
    public boolean estaVacia() {
        return longitud == 0;
        //return inicio == null;
    }
    
    public T obtenerElemento(int indice) throws ListaException {
        return encontrarPorIndice(indice).getContenido();
    }
    
    public void eliminarUltimo() throws ListaException {
        if (estaVacia()) {
            throw new ListaException("La lista esta vacia.");
        } else if (longitud == 1) {
            inicio = null;
            ultimo = null;
        } else {
            Nodo<T> penultimo = encontrarPorIndice(longitud - 2);
            penultimo.setSiguiente(null);
            ultimo = penultimo;
        }
        
        longitud--;
    }
    
    public void eliminarPorIndice(int indice) throws ListaException {
        if (estaVacia()) {
            throw new ListaException("La lista esta vacia.");
        } else if (indice == 0) {
            inicio = inicio.getSiguiente();
            longitud--;
        } else if (indice == longitud - 1) {
            eliminarUltimo();
        } else {
            Nodo<T> anterior = encontrarPorIndice(indice - 1);
            Nodo<T> aEliminar = encontrarPorIndice(indice);
            anterior.setSiguiente(aEliminar.getSiguiente());
            longitud--;
        }
    }
    
    private Nodo<T> encontrarPorIndice(int indice) throws ListaException {
        if (indice < 0 || indice >= longitud) {
            throw new ListaException("Indice fuera de rango");
        }
        
        Nodo<T> actual = inicio;
        for (int i = 0; i < indice; i++) {
            Nodo<T> siguiente = actual.getSiguiente();
            actual = siguiente;
        }
        
        return actual;
    }
}
