package com.jgranados.ipc1_jun_2022.hilos;

/**
 *
 * @author jose
 */
public class CajeroRunnable /*extends de alguien*/ implements Runnable {
    
    private Cliente clienteEnProceso;

    @Override
    public void run() {
        atenderCliente();
    }
    
    public void setClienteEnProceso(Cliente clienteEnProceso) {
        this.clienteEnProceso = clienteEnProceso;
    }

    public void atenderCliente() {
        System.out.println(String.format(
                "Atendiend a cliente %s, con %d articulos",
                clienteEnProceso.getNombre(),
                clienteEnProceso.getArticulos())
        );
        try {
            for (int i = 0; i < clienteEnProceso.getArticulos(); i++) {
                Thread.sleep(1000);
                System.out.println(
                        String.format("Cliente %s: articulo procesado: %d",
                                clienteEnProceso.getNombre(),
                                i + 1)
                );
            }
        } catch (InterruptedException e) {
            // logica para manejar el error
        }
    }

}
