package Restaurante.Model;

import java.util.Observable;

public class Cocinero extends Observable implements Runnable {

    private Orden orden;

    public Cocinero(Monitor monitor) {
        this.monitor = monitor;
    }

    private Monitor monitor;

    public void setOrden(Orden orden) {
        this.orden = orden;
    }

    public Orden getOrden() {
        return orden;
    }

    @Override
    public void run() {
        while(true){
            monitor.cocinarComida();
        }
    }
}
