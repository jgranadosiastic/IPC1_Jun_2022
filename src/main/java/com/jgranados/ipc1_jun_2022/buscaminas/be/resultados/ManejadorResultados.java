package com.jgranados.ipc1_jun_2022.buscaminas.be.resultados;

/**
 *
 * @author jose
 */
public class ManejadorResultados {
    public static final int MAX_RESULTADOS = 10;
    private Resultado[] resultados;
    private int contadorResultados = 0;

    public ManejadorResultados() {
        this.resultados = new Resultado[MAX_RESULTADOS];
    }
    
    public void registrarResultado(Resultado resultado) {
        if (contadorResultados >= MAX_RESULTADOS) {
            contadorResultados = 0;
        }
        resultados[contadorResultados] = resultado;
        contadorResultados++;
    }
    
    public Resultado[] obtenerListadoResultados() {
        return resultados;
    }
}
