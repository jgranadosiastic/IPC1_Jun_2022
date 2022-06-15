package com.jgranados.ipc1_jun_2022.buscaminas.be.resultados;

/**
 *
 * @author jose
 */
public abstract class Resultado {

    protected int cantidadTurnos;

    public Resultado(int cantidadTurnos) {
        this.cantidadTurnos = cantidadTurnos;
    }

    public int getTurnos() {
        return cantidadTurnos;
    }
    
    public abstract String[] obtenerDatosEnFormaDeFila();
}
