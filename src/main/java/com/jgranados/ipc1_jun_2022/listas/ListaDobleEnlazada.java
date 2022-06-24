package com.jgranados.ipc1_jun_2022.listas;

import com.jgranados.ipc1_jun_2022.exceptions.ListaException;

/**
 *
 * @author jose
 */
public class ListaDobleEnlazada<T> {

    private NodoDoble<T> inicio;
    private NodoDoble<T> ultimo;
    private int longitud = 0; 
    
    public void agregar(T elemento) {
        if (estaVacia()) {
            inicio = new NodoDoble<>(elemento);
            ultimo = inicio;
        } else {
            NodoDoble<T> nodo = new NodoDoble<>(elemento);
            ultimo.setSiguiente(nodo);
            nodo.setAnterior(ultimo);
            ultimo = nodo;
        }
        
        longitud++;
    }
    
    public boolean estaVacia() {
        return longitud == 0;
        //return inicio == null;
    }
    
    public T obtenerElemento(int indice) throws ListaException {
        // TODO
        return null;
    }
    
    public void eliminarUltimo() throws ListaException {
        // TODO
    }
    
    public void eliminarPorIndice(int indice) throws ListaException {
        // TODO
    }
    
    private NodoDoble<T> encontrarPorIndice(int indice) throws ListaException {
        if (indice < 0 || indice >= longitud) {
            throw new ListaException("Indice fuera de rango");
        }
        
        int mitad = longitud / 2;
        
        if (indice <= mitad) {
            return encontrarPorIndiceDeInicioAUltimo(indice);
        } else {
            return encontrarPorIndiceDeUltimoAInicio(indice);
        }
    }
    
    private NodoDoble<T> encontrarPorIndiceDeInicioAUltimo(int indice) throws ListaException {
        if (indice < 0 || indice >= longitud) {
            throw new ListaException("Indice fuera de rango");
        }
        
        NodoDoble<T> actual = inicio;
        for (int i = 0; i < indice; i++) {
            NodoDoble<T> siguiente = actual.getSiguiente();
            actual = siguiente;
        }
        
        return actual;
    }
    
    private NodoDoble<T> encontrarPorIndiceDeUltimoAInicio(int indice) throws ListaException {
        if (indice < 0 || indice >= longitud) {
            throw new ListaException("Indice fuera de rango");
        }
        
        int nuevoIndice = longitud - indice - 1;
        
        NodoDoble<T> actual = inicio;
        for (int i = 0; i < nuevoIndice; i++) {
            NodoDoble<T> anterior = actual.getAnterior();
            actual = anterior;
        }
        
        return actual;
    }
}
