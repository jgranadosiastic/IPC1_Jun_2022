package com.jgranados.ipc1_jun_2022.buscaminas.be.partida;

import com.jgranados.ipc1_jun_2022.buscaminas.be.resultados.Empate;
import com.jgranados.ipc1_jun_2022.buscaminas.be.resultados.ManejadorResultados;
import com.jgranados.ipc1_jun_2022.buscaminas.be.resultados.Resultado;
import com.jgranados.ipc1_jun_2022.buscaminas.be.resultados.Victoria;
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
    private ManejadorResultados manejadorResultados;
    private int casillasDescubiertas = 0;

    public Partida(Jugador jugadorA, Jugador jugadorB, BuscaminasFrame frame,
            ManejadorResultados manejadorResultados) {
        this.jugadorInicia = jugadorA;
        this.jugadorTermina = jugadorB;
        this.manejadorResultados = manejadorResultados;
        // tambien se pudo hacer referencia a la partida en las casillas
        // en vez de aqui en la partida.
        this.frame = frame;
        tablero = new Tablero(this);
        tablero.crearCasillas();
        iniciar(jugadorA, jugadorB);
    }

    public Tablero obtenerTableroEnUso() {
        return tablero;
    }

    public Jugador obtenerJugadorEnTurno() {
        return turno ? jugadorInicia : jugadorTermina;
    }

    public int obtenerTurno() {
        return contadorTurno;
    }

    public void registrarClick() {
        casillasDescubiertas++;
        if (fueronDescubiertasTodas()) {
            Resultado empate = new Empate(jugadorInicia, jugadorTermina, contadorTurno);
            manejadorResultados.registrarResultado(empate);
            frame.reportarEmpate();
        } else {
            if (obtenerJugadorEnTurno().equals(jugadorTermina)) {
                contadorTurno++;
            }
            turno = !turno;
            frame.actualizarDatosJugadores();
            frame.actualizarDatosTurno();
        }
    }

    /**
     * Si alguien da un click en una mina entonces se reporta una victoria por
     * parte del jugador que NO ESTÁ en turno.
     */
    public void registrarClickEnMina() {
        Jugador ganador = obtenerGanador();
        Resultado victoria = new Victoria(ganador, contadorTurno);
        manejadorResultados.registrarResultado(victoria);
        frame.reportarVictoria(ganador);
    }

    /**
     * Define al jugador que inicia
     *
     * @param jugadorA
     * @param jugadorB
     */
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

    /**
     * El ganador es el jugador que no está en turno, porque el que está en
     * turno fue el que activó la mina.
     *
     * @return
     */
    private Jugador obtenerGanador() {
        return turno ? jugadorTermina : jugadorInicia;
    }

    private boolean fueronDescubiertasTodas() {
        int casillasNormales = tablero.obtenerCantidadCasillasNormales();
        return casillasDescubiertas == casillasNormales;
    }
}
