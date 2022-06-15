package com.jgranados.ipc1_jun_2022.buscaminas.be.resultados;

import com.jgranados.ipc1_jun_2022.buscaminas.be.partida.Jugador;

/**
 *
 * @author jose
 */
public class Victoria extends Resultado {
    private Jugador ganador;

    public Victoria(Jugador ganador, int cantidadTurnos) {
        super(cantidadTurnos);
        this.ganador = ganador;
    }

    @Override
    public String[] obtenerDatosEnFormaDeFila() {
        return new String[] {"" + cantidadTurnos, ganador.obtenerNombre(), "-", "-"};
    }
    
}
