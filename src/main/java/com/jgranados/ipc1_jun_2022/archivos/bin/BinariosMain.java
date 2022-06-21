/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jgranados.ipc1_jun_2022.archivos.bin;

import com.jgranados.ipc1_jun_2022.alumno.Alumno;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 *
 * @author jose
 */
public class BinariosMain {

    private static final String PATH_BINARIO = "/media/jose/DATA/CUNOC/IPC1/";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Alumno[] alumnos = new Alumno[3];
        alumnos[0] = new Alumno("111", "nombre1", new int[]{25, 100, 100});
        alumnos[1] = new Alumno("222", "nombre2", new int[]{65, 40, 75});
        alumnos[2] = new Alumno("333", "nombre3", new int[]{55, 61, 100});

        //.
        //.
        //.
        //.
        //.
        //grabarAlumnos(alumnos);
        buscarAlumno();
    }

    public static void grabarAlumnos(Alumno[] alumnos) {

        try {
            for (Alumno alumno : alumnos) {
                File fileBinarioAlumno1 = new File(PATH_BINARIO + alumno.getCui() + ".dat");

                FileOutputStream outputStream = new FileOutputStream(fileBinarioAlumno1);
                ObjectOutputStream objectStream = new ObjectOutputStream(outputStream);

                objectStream.writeObject(alumno);
                objectStream.close();

            }
        } catch (IOException e) {

        }
    }

    public static void buscarAlumno() {
        boolean repetir = true;
        Scanner scanner = new Scanner(System.in);
        while (repetir) {
            System.out.println("Ingrese el cui del alumno a leer: ");
            String cui = scanner.nextLine();
            String pathFinal = PATH_BINARIO + cui + ".dat";
            File alumnoFile = new File(pathFinal);
            if (alumnoFile.exists()) {
                Alumno alumno = cargarAlumno(alumnoFile);
                alumno.imprimirDatos();
            } else {
                System.out.println("Eso no existe!!!");
            }

        }
    }

    public static Alumno cargarAlumno(File alumnoFile) {
        // Try con recursos
        try (
                FileInputStream inputStream = new FileInputStream(alumnoFile);
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);) {

            Object alumnoObject = objectInputStream.readObject();

            Alumno alumno = (Alumno) alumnoObject;

            return alumno;
        } catch (IOException | ClassNotFoundException exception) {
            // logica para manejar esto
            exception.printStackTrace();
            // mas logica
        }

        // Try sin recursos
        /*ObjectInputStream objectInputStream = null;
        try {
            FileInputStream inputStream = new FileInputStream(alumnoFile);
            objectInputStream = new ObjectInputStream(inputStream);

            Object alumnoObject = objectInputStream.readObject();

            objectInputStream.close();

            Alumno alumno = (Alumno) alumnoObject;

            return alumno;
        } catch (IOException | ClassNotFoundException exception) {
            // logica para manejar esto
            exception.printStackTrace();
            // mas logica
        } finally {
            if (objectInputStream != null) {
                objectInputStream.close();
            }
        }*/

        return null;
    }

}
