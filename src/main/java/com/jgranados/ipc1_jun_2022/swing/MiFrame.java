package com.jgranados.ipc1_jun_2022.swing;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author jose
 */
public class MiFrame extends JFrame {

    private JButton boton;
    private JLabel texto;

    public MiFrame() {
        this.setTitle("Hello World!!");
        this.setSize(400, 500);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        boton = new JButton("Press Me!");
        boton.setBounds(30, 50, 200, 40);
        boton.setForeground(Color.red);
        boton.setBackground(Color.WHITE);

        texto = new JLabel("Hello World!!");
        texto.setBounds(30, 150, 400, 40);

        this.add(boton);
        this.add(texto);

        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accionBoton();
            }
        });
    }

    private void accionBoton() {
        texto.setVisible(!texto.isVisible());
        /*
        if (texto.isVisible()) {
            texto.setVisible(false);
        } else {
            texto.setVisible(true);
        }*/
    }
}
