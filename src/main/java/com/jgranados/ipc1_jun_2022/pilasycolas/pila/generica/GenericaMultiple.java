package com.jgranados.ipc1_jun_2022.pilasycolas.pila.generica;

/**
 *
 * @author jose
 */
public class GenericaMultiple<T1, T2, T3> {

    private T1 valorTipo1;
    private T2 valorTipo2;
    private T3 valorTipo3;

    public GenericaMultiple(T1 valorTipo1, T2 valorTipo2, T3 valorTipo3) {
        this.valorTipo1 = valorTipo1;
        this.valorTipo2 = valorTipo2;
        this.valorTipo3 = valorTipo3;
    }

    public T1 getValorTipo1() {
        return valorTipo1;
    }

    public T2 getValorTipo2() {
        return valorTipo2;
    }

    public T3 getValorTipo3() {
        return valorTipo3;
    }
    
    
    
}
