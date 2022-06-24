package com.jgranados.ipc1_jun_2022.listas;

/**
 *
 * @author jose
 */
public class Nodo<T> {
    
    private T contenido;
    private Nodo siguiente;

    public Nodo(T contenido) {
        this.contenido = contenido;
    }

    public T getContenido() {
        return contenido;
    }

    public void setContenido(T contenido) {
        this.contenido = contenido;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }   
}
