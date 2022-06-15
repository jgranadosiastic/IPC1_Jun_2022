package com.jgranados.ipc1_jun_2022.buscaminas.be.tablero;

import com.jgranados.ipc1_jun_2022.buscaminas.be.partida.Partida;
import java.awt.Font;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.event.MouseInputListener;

/**
 *
 * @author jose
 */
public class Casilla extends JLabel {

    public static final String IMAGEN_ROOT_PATH = "/com/jgranados/ipc1_jun_2022/buscaminas/fe/";
    public static final String IMAGEN_SQUARE = "square.png";
    protected Partida partidaEnCurso;
    protected int fila;
    protected int columna;

    public Casilla(Partida partidaEnCurso, int fila, int columna) {
        this.setIcon(new ImageIcon(getClass().getResource(IMAGEN_ROOT_PATH + IMAGEN_SQUARE)));
        this.partidaEnCurso = partidaEnCurso;
        this.fila = fila;
        this.columna = columna;
        this.setFont(new Font("Arial", 1, 30));
        this.setHorizontalTextPosition(SwingConstants.CENTER);
        agregarActionListener();
    }

    public void descubrir() {
        System.out.println("Descubriendo casilla normal");
        int minasAlrededor = partidaEnCurso.obtenerTableroEnUso().obtenerCantidadMinasAlrederor(fila, columna);
        this.setText("" + minasAlrededor);
        partidaEnCurso.registrarClick();

    }

    private void agregarActionListener() {
        this.addMouseListener(new MouseInputListener() {

            @Override
            public void mouseReleased(MouseEvent e) {
                descubrir();
            }

            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }

            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });
    }

}
