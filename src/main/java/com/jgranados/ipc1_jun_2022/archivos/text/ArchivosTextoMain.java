/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jgranados.ipc1_jun_2022.archivos.text;

import com.jgranados.ipc1_jun_2022.alumno.Alumno;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author jose
 */
public class ArchivosTextoMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // /media/jose/DATA/CUNOC/Parcial1.txt
        String path = "";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese path del archivo:");
        path = scanner.nextLine();

        File file = new File(path);
        System.out.println("Existe: " + file.exists());
        System.out.println("Se puede escribir: " + file.canWrite());
        System.out.println("Path absoluto: " + file.getAbsolutePath());
        System.out.println("Carpeta padre: " + file.getParent());
        System.out.println("es carpeta? " + file.isDirectory());

        try {
            Scanner scannerFile = new Scanner(file);
            String linea;
            while (scannerFile.hasNextLine()) {
                linea = scannerFile.nextLine();
                System.out.println("la linea leida: " + linea);
            }
            scannerFile.close();

        } catch (FileNotFoundException e) {
        }

        Alumno[] alumnos = new Alumno[3];
        alumnos[0] = new Alumno("111", "nombre1", new int[]{25, 100, 100});
        alumnos[1] = new Alumno("222", "nombre2", new int[]{65, 40, 75});
        alumnos[2] = new Alumno("333", "nombre3", new int[]{55, 61, 100});

        // Escribir a archivo de texto
        System.out.println("Ingrese un path para escribir:");
        path = scanner.nextLine();
        File archivoTexto = new File(path);

        try {
            FileWriter writer = new FileWriter(archivoTexto, true);
            
            // PrintWriter printer = new PrintWriter(writer);
            PrintWriter printer = new PrintWriter(archivoTexto);
            for (Alumno alumno : alumnos) {
                printer.println("ALUMNO:");
                printer.println(
                        String.format(
                                "CUI: %s, Nombre: %s, Promedio: %d",
                                alumno.getCui(),
                                alumno.getNombre(),
                                alumno.calcularPromedio()
                        )
                );
            }
            printer.close();
        } catch (Exception e) {
        }

    }

}
