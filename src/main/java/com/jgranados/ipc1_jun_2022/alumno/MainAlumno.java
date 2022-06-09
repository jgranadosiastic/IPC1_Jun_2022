/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jgranados.ipc1_jun_2022.alumno;

import java.util.Scanner;

/**
 *
 * @author jose
 */
public class MainAlumno {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MainAlumno mainAlumno = new MainAlumno();
        String cui = mainAlumno.pedirCUI();
        String nombre = mainAlumno.pedirNombre();
        int[] notas = mainAlumno.pedirNotas();
        Alumno jose = new Alumno(cui, nombre, notas);
        jose.imprimirDatos();
    }

    public String pedirCUI() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("INgrese el CUI:");
        return scanner.nextLine();
    }
    
    public String pedirNombre() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre:");
        return scanner.nextLine();
    }
    
    public int[] pedirNotas() {
        int[] notas = new int[3];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.println("Ingrese una nota:");
            notas[i] = Integer.parseInt(scanner.nextLine());
        }
        
        return notas;
    }
}
