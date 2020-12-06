package Restaurante.Model;

import java.util.Observable;

public class Mesero extends Observable implements Runnable {

    private Orden orden;
    private Monitor monitor;

    public Mesero(Monitor monitor) {
        this.monitor = monitor;
    }


    public void setOrden(Orden orden) {
        this.orden = orden;
    }

    public Orden getOrden() {
        return orden;
    }

    @Override
    public void run() {
        while(true){
            monitor.atenderCliente();
            monitor.verificarOrden();
        }
    }
}
