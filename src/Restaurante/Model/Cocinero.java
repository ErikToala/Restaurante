package Restaurante.Model;

import javafx.scene.effect.ImageInput;
import javafx.scene.image.Image;

import java.util.Observable;

public class Cocinero extends Observable implements Runnable {

    private Orden orden;
    private Image image;

    public Cocinero(Monitor monitor, Image image) {
        this.monitor = monitor;
        this.image = image;
    }

    private Monitor monitor;

    public Monitor getMonitor() {
        return monitor;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void setMonitor(Monitor monitor) {
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
            monitor.cocinarComida();
        }
    }
}
