package Restaurante.Model;

import javafx.scene.effect.ImageInput;
import javafx.scene.image.Image;

import java.util.Observable;

public class Cocinero extends Observable implements Runnable {

    private Monitor monitor;
    private Image image;

    public Cocinero(Monitor monitor, Image image) {
        this.monitor = monitor;
        this.image = image;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Image getImage() {
        return image;
    }



    @Override
    public void run() {
        while(true){
            monitor.cocinarComida();
        }
    }
}
