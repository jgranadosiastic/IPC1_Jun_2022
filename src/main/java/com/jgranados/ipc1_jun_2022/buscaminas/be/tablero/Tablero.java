package com.jgranados.ipc1_jun_2022.buscaminas.be.tablero;

import com.jgranados.ipc1_jun_2022.buscaminas.be.partida.Partida;
import java.util.Random;

/**
 *
 * @author jose
 */
public class Tablero {

    public static final int FILAS = 6;
    public static final int COLUMNAS = 4;
    private static final int CANTIDAD_MINAS_INFERIOR = 4;
    private static final int CANTIDAD_MINAS_SUPERIOR = 6;

    private Casilla[][] casillas;
    private int cantidadMinas;
    private Partida partidaEnCurso;

    public Tablero(Partida partidaEnCurso) {
        this.casillas = new Casilla[FILAS][COLUMNAS];
        this.partidaEnCurso = partidaEnCurso;
    }

    public void crearCasillas() {
        cantidadMinas = definirCantidadMinas();
        int minasDefinidas = distribuirCasillas();
        while (minasDefinidas != cantidadMinas) {
            minasDefinidas = distribuirCasillas();
        }
    }

    public Casilla[][] obtenerCasillas() {
        return casillas;
    }

    public int obtenerCantidadMinasAlrederor(int fila, int columna) {
        int cantidadMinas = 0;
        if (esMina(fila - 1, columna - 1)) {
            cantidadMinas++;
        }
        if (esMina(fila - 1, columna)) {
            cantidadMinas++;
        }
        if (esMina(fila - 1, columna + 1)) {
            cantidadMinas++;
        }
        if (esMina(fila, columna + 1)) {
            cantidadMinas++;
        }
        if (esMina(fila + 1, columna + 1)) {
            cantidadMinas++;
        }
        if (esMina(fila + 1, columna)) {
            cantidadMinas++;
        }
        if (esMina(fila + 1, columna - 1)) {
            cantidadMinas++;
        }
        if (esMina(fila, columna - 1)) {
            cantidadMinas++;
        }

        return cantidadMinas;
    }

    public int obtenerCantidadCasillasNormales() {
        return obtenerTotalCasillas() - obtenerCantidadMinasDefinidas();
    }

    private int definirCantidadMinas() {
        Random random = new Random();
        return random.nextInt(CANTIDAD_MINAS_SUPERIOR - CANTIDAD_MINAS_INFERIOR + 1) + CANTIDAD_MINAS_INFERIOR;
    }

    private int distribuirCasillas() {
        int minasDefinidas = 0;
        Random random = new Random();
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                int randomVal = random.nextInt(100);
                if (minasDefinidas < cantidadMinas && randomVal >= 50) {
                    casillas[i][j] = new Mina(partidaEnCurso, i, j);
                    minasDefinidas++;
                } else {
                    casillas[i][j] = new Casilla(partidaEnCurso, i, j);
                }
            }
        }

        return minasDefinidas;
    }

    /**
     * Verifica que la casilla ubiccada por la fila y columna sea una mina. Si
     * el valor de la fila o la columna están fuera del tablero, entonces se
     * indica que no hay mina.
     *
     * @param fila
     * @param columna
     * @return
     */
    private boolean esMina(int fila, int columna) {
        if (fila < 0 || fila >= FILAS || columna < 0 || columna >= COLUMNAS) {
            return false;
        }

        return casillas[fila][columna] instanceof Mina;
    }

    private int obtenerCantidadMinasDefinidas() {
        return cantidadMinas;
    }

    private int obtenerTotalCasillas() {
        return FILAS * COLUMNAS;
    }
}
