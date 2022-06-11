/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jgranados.ipc1_jun_2022.swing;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author jose
 */
public class HelloWorldSwing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame helloWorldFrame = new JFrame("Hello World!!");
        helloWorldFrame.setSize(400, 500);
        helloWorldFrame.setLayout(null);
        
        JButton boton = new JButton("Press Me!");
        boton.setBounds(30, 50, 200, 40);
        boton.setForeground(Color.red);
        boton.setBackground(Color.WHITE);
        
        JLabel texto = new JLabel("Hello World!!");
        texto.setBounds(30, 150, 400, 40);
        
        helloWorldFrame.add(boton);
        helloWorldFrame.add(texto);
        
        helloWorldFrame.setVisible(true);
        
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (texto.isVisible()) {
                    texto.setVisible(false);
                } else {
                    texto.setVisible(true);
                }
            }
        });
        
        
    }
    
}
