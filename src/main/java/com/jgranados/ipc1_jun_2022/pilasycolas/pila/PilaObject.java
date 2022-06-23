package com.jgranados.ipc1_jun_2022.pilasycolas.pila;

import com.jgranados.ipc1_jun_2022.buscaminas.be.partida.Jugador;
import com.jgranados.ipc1_jun_2022.exceptions.PilaException;

/**
 *
 * @author jose
 */
public class PilaObject {

    private Object[] contenido;
    private int indiceTope;

    public PilaObject(int size) {
        this.contenido = new Object[size];
        indiceTope = -1;
    }
    
    public void apilarObject(Object alumno) throws PilaException {
        if (estaLlena()) {
            throw new PilaException("La pila está llena");
        } else {
            indiceTope++;
            contenido[indiceTope] = alumno;
        }
    }
    
    public Object desapilarObject() throws PilaException {
        if (estaVacia()) {
            throw new PilaException("La pila está vacia");
        } else {
            Object alumnoTope = contenido[indiceTope];
            indiceTope--;

            return alumnoTope;
        }
    }
    
    public boolean estaLlena() {
        return indiceTope == contenido.length - 1;
    }
    
    public boolean estaVacia() {
        return indiceTope == -1;
    }
}
