package com.jgranados.ipc1_jun_2022.pilasycolas.pila.generica;

import com.jgranados.ipc1_jun_2022.alumno.Alumno;
import com.jgranados.ipc1_jun_2022.exceptions.PilaException;

/**
 *
 * @author jose
 */
public class Pila<T> {

    private T[] contenido;
    private int indiceTope;

    public Pila(int size) {
        this.contenido = (T[])new Object[size];
        indiceTope = -1;
    }

    public void apilar(T elemento) throws PilaException {
        if (estaLlena()) {
            throw new PilaException("La pila está llena");
        } else {
            indiceTope++;
            contenido[indiceTope] = elemento;
        }
    }

    public T desapilar() throws PilaException {
        if (estaVacia()) {
            throw new PilaException("La pila está vacia");
        } else {
            T elementoTope = contenido[indiceTope];
            indiceTope--;

            return elementoTope;
        }
    }

    public boolean estaLlena() {
        return indiceTope == contenido.length - 1;
    }

    public boolean estaVacia() {
        return indiceTope == -1;
    }
}
