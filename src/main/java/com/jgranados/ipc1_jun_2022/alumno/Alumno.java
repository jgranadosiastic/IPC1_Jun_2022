package com.jgranados.ipc1_jun_2022.alumno;

import java.io.Serializable;

/**
 *
 * @author jose
 */
public class Alumno implements Serializable {
    
    private static final long serialVersionUID = 121L;

    private String cui;
    private String nombre;
    private int[] notas;
    
    public Alumno(String cui, String nombre, int[] notas) {
        this.cui = cui;
        this.nombre = nombre;
        this.notas = notas;
    }
    
    public boolean esAprobado() {
        return calcularPromedio() >= 61;
        /*if (calcularPromedio() >= 61) {
            return true;
        } else {
            return false;
        }*/
    }
    
    public void imprimirDatos() {
        System.out.println("CUI: " + cui);
        System.out.println("Nombre: " + nombre);
        System.out.println("Nota promedio final: " + calcularPromedio());
        if (esAprobado()) {
            System.out.println("El estudiante aprobo.");
        } else {
            System.out.println("El estudiante reprobo.");
        }
    }
    
    public int calcularPromedio() {
        int total = 0;
        for (int i = 0; i < notas.length; i++) {
            total += notas[i];
        }
        
        return total / 3;
    }

    public String getCui() {
        return cui;
    }

    public String getNombre() {
        return nombre;
    }

    public void setCui(String cui) {
        this.cui = cui;
    }
    
    
}
