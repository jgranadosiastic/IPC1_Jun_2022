package com.jgranados.ipc1_jun_2022.buscaminas.be.tablero;

import com.jgranados.ipc1_jun_2022.buscaminas.be.partida.Partida;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.event.MouseInputListener;

/**
 *
 * @author jose
 */
public class Casilla extends JLabel {
    public static final String IMAGEN_ROOT_PATH = "/com/jgranados/ipc1_jun_2022/buscaminas/fe/";
    public static final String IMAGEN_SQUARE = "square.png";
    private Partida partidaEnCurso;
    
    public Casilla(Partida partidaEnCurso) {
        this.setIcon(new ImageIcon(getClass().getResource(IMAGEN_ROOT_PATH + IMAGEN_SQUARE)));
        this.partidaEnCurso = partidaEnCurso;
        agregarActionListener();
    }
    
    public void descubrir() {
        System.out.println("Descubriendo casilla normal");
    }
    
    private void agregarActionListener() {
        this.addMouseListener(new MouseInputListener() {
            

            @Override
            public void mouseReleased(MouseEvent e) {
                descubrir();
                partidaEnCurso.registrarClick();
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
