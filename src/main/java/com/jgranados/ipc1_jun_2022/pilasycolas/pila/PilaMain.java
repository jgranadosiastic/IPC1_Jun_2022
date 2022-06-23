/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jgranados.ipc1_jun_2022.pilasycolas.pila;

import com.jgranados.ipc1_jun_2022.alumno.Alumno;
import com.jgranados.ipc1_jun_2022.guessanumber.be.Jugador;
import com.jgranados.ipc1_jun_2022.pilasycolas.pila.generica.GenericaMultiple;
import com.jgranados.ipc1_jun_2022.pilasycolas.pila.generica.Pila;
import javax.swing.JButton;

/**
 *
 * @author jose
 */
public class PilaMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        /*PilaFrame frame = new PilaFrame();
        frame.setVisible(true);*/
        
        //PilaObject pilaAlumno = new PilaObject(3);
        //PilaObject pilaJugador = new PilaObject(2);
        Pila<Alumno> pilaAlumno = new Pila<>(3);
        Pila<Jugador> pilaJugador = new Pila<>(2);
        
        try {

        
        //pilaAlumno.apilarObject(new Alumno("xxx", "xxxx", new int[] {1,2,3}));
        pilaAlumno.apilar(new Alumno("xxx", "xxxx", new int[] {1,2,3}));
        //Alumno alumno = (Alumno) pilaAlumno.desapilarObject();
        Alumno alumno = pilaAlumno.desapilar();
        
        //pilaJugador.apilarObject(new Jugador("nombre"));
        pilaJugador.apilar(new Jugador("nombre"));
        //Jugador jugador = (Jugador) pilaJugador.desapilarObject();
        Jugador jugador = pilaJugador.desapilar();
        
        
        
        //pilaJugador.apilar(new Alumno("xxx", "xxxx", new int[] {1,2,3}));
        
        
        
        Jugador jugador2 = pilaJugador.desapilar();
        jugador2.darPuntos(15);
                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        GenericaMultiple<Jugador, JButton, Alumno> multiple1 = new GenericaMultiple<>(
                new Jugador("aaa"),
                new JButton(),
                new Alumno("xxx", "xxxx", new int[] {1,2,3}) 
        );
        
        
        
    }
    
}
