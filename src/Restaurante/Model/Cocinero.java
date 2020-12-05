package Restaurante.Model;

import java.util.Observable;

public class Cocinero extends Observable implements Runnable {

    private Orden orden;

    public void setOrden(Orden orden) {
        this.orden = orden;
    }

    public Orden getOrden() {
        return orden;
    }

    @Override
    public void run() {

    }
}
