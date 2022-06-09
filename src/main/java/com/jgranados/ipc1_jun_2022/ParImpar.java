package com.jgranados.ipc1_jun_2022;

import java.util.Scanner;

/**
 *
 * @author jose
 */
public class ParImpar {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cantidadNumeros;
        System.out.println("Ingrese la cantidad de numeros");

        cantidadNumeros = Integer.parseInt(scanner.nextLine());

        int[] numeros = new int[cantidadNumeros];
        numeros = capturarNumeros(cantidadNumeros);

        imprimirPares(numeros, cantidadNumeros);

        imprimirImpares(numeros, cantidadNumeros);

    }

    public static int[] capturarNumeros(int cantidad) {
        Scanner scanner = new Scanner(System.in);
        int[] numeros = new int[cantidad];
        int contador = 0;
        int numero;
        // ciclo para pedir los numeros
        while (contador < cantidad) {
            System.out.println("Ingrese un numero");
            numero = scanner.nextInt();
            numeros[contador] = numero;

            contador++;
        }

        return numeros;
    }

    public static void imprimirPares(int[] numeros, int cantidad) {
        int contador = 0;
        System.out.println("numeros pares son:");

        while (contador < cantidad) {
            if (numeros[contador] % 2 == 0) {
                System.out.println(numeros[contador]);
            }
            contador++;
        }

    }

    public static void imprimirImpares(int[] numeros, int cantidad) {
        int contador = 0;
        System.out.println("numeros impares son:");

        while (contador < cantidad) {
            if (numeros[contador] % 2 != 0) {
                System.out.println(numeros[contador]);
            }
            contador++;
        }

    }
}
