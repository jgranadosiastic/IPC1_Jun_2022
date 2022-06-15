package com.jgranados.ipc1_jun_2022.buscaminas.be.tablero;

import com.jgranados.ipc1_jun_2022.buscaminas.be.partida.Partida;
import javax.swing.ImageIcon;

/**
 *
 * @author jose
 */
public class Mina extends Casilla {
    
    public static final String IMAGEN_MINA = "mine.png";

    public Mina(Partida partidaEnCurso, int fila, int columna) {
        super(partidaEnCurso, fila, columna);
    }

    @Override
    public void descubrir() {
        System.out.println("Descubriendo mina, boooooooom");
        this.setIcon(new ImageIcon(getClass().getResource(IMAGEN_ROOT_PATH + IMAGEN_MINA)));
        partidaEnCurso.registrarClickEnMina();
    }
}
