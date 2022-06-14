package com.jgranados.ipc1_jun_2022.buscaminas.be.tablero;

import com.jgranados.ipc1_jun_2022.buscaminas.be.partida.Partida;
import java.util.Random;

/**
 *
 * @author jose
 */
public class Tablero {
    public static final int FILAS = 4;
    public static final int COLUMNAS = 6;
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
                    casillas[i][j] = new Mina(partidaEnCurso);
                    minasDefinidas++;
                } else {
                    casillas[i][j] = new Casilla(partidaEnCurso);
                }
            }
        }
        
        return minasDefinidas;
    }
    
    public Casilla[][] obtenerCasillas() {
        return casillas;
    }
}
