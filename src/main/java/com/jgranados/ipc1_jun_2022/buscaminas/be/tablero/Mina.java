package com.jgranados.ipc1_jun_2022.buscaminas.be.tablero;

import com.jgranados.ipc1_jun_2022.buscaminas.be.partida.Partida;

/**
 *
 * @author jose
 */
public class Mina extends Casilla {

    public Mina(Partida partidaEnCurso) {
        super(partidaEnCurso);
    }

    public void descubrir() {
        System.out.println("Descubriendo mina, boooooooom");
    }
}
