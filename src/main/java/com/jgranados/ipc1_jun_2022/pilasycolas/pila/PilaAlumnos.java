package com.jgranados.ipc1_jun_2022.pilasycolas.pila;

import com.jgranados.ipc1_jun_2022.alumno.Alumno;
import com.jgranados.ipc1_jun_2022.exceptions.PilaException;

/**
 *
 * @author jose
 */
public class PilaAlumnos {
    private Alumno[] contenido;
    private int indiceTope;

    public PilaAlumnos(int size) {
        this.contenido = new Alumno[size];
        indiceTope = -1;
    }
    
    public void apilarAlumno(Alumno alumno) throws PilaException {
        if (estaLlena()) {
            throw new PilaException("La pila está llena");
        } else {
            indiceTope++;
            contenido[indiceTope] = alumno;
        }
    }
    
    public Alumno desapilarAlumno() throws PilaException {
        if (estaVacia()) {
            throw new PilaException("La pila está vacia");
        } else {
            Alumno alumnoTope = contenido[indiceTope];
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
