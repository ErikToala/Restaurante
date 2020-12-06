package Restaurante.Model;

import javafx.scene.image.Image;

import java.util.Observable;

public class Mesero extends Observable implements Runnable {

    private Orden orden;
    private Monitor monitor;
    private Image image;

    public Mesero(Monitor monitor, Image image) {
        this.monitor = monitor;
        this.image = image;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
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
