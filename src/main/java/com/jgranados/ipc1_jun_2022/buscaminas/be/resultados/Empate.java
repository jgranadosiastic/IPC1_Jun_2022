package com.jgranados.ipc1_jun_2022.buscaminas.be.resultados;

import com.jgranados.ipc1_jun_2022.buscaminas.be.partida.Jugador;

/**
 *
 * @author jose
 */
public class Empate extends Resultado {

    private final Jugador jugadorA;
    private final Jugador jugadorB;
    
    public Empate(Jugador jugadorA, Jugador jugadorB, int cantidadTurnos) {
        super(cantidadTurnos);
        this.jugadorA = jugadorA;
        this.jugadorB = jugadorB;
    }

    public Jugador getJugadorA() {
        return jugadorA;
    }

    public Jugador getJugadorB() {
        return jugadorB;
    }

    @Override
    public String[] obtenerDatosEnFormaDeFila() {
        return new String[] {"" + cantidadTurnos, "-", jugadorA.obtenerNombre(), jugadorB.obtenerNombre()};
    }
}
