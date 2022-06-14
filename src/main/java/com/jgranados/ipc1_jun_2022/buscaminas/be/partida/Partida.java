package com.jgranados.ipc1_jun_2022.buscaminas.be.partida;

import com.jgranados.ipc1_jun_2022.buscaminas.be.tablero.Tablero;
import com.jgranados.ipc1_jun_2022.buscaminas.fe.BuscaminasFrame;
import java.util.Random;

/**
 *
 * @author jose
 */
public class Partida {

    private boolean turno;
    private int contadorTurno = 1;
    private Jugador jugadorInicia;
    private Jugador jugadorTermina;
    private Tablero tablero;
    private BuscaminasFrame frame;

    public Partida(Jugador jugadorA, Jugador jugadorB, BuscaminasFrame frame) {
        this.jugadorInicia = jugadorA;
        this.jugadorTermina = jugadorB;
        this.frame = frame;
        tablero = new Tablero(this);
        tablero.crearCasillas();
        iniciar(jugadorA, jugadorB);
    }
    
    public Tablero obtenerTableroEnUso() {
        return tablero;
    }
    
    private void iniciar(Jugador jugadorA, Jugador jugadorB) {
        turno = true;
        Random random = new Random();
        int val = random.nextInt(100);
        if (val < 50) {
            jugadorInicia = jugadorA;
            jugadorTermina = jugadorB;
        } else {
            jugadorInicia = jugadorB;
            jugadorTermina = jugadorA;
        }
    }
    
    public Jugador obtenerJugadorEnTurno() {
        return turno ? jugadorInicia : jugadorTermina;
    }
    
    public int obtenerTurno() {
        return contadorTurno;
    }
    
    public void registrarClick() {
        if (obtenerJugadorEnTurno().equals(jugadorTermina)) {
            contadorTurno++;
        }
        turno = !turno;
        frame.actualizarDatosJugadores();
        frame.actualizarDatosTurno();
    }
}
