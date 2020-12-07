package Restaurante.Model;

import javafx.scene.image.Image;

import java.util.Observable;

public class Mesero extends Observable implements Runnable {

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

    @Override
    public void run() {
        while(true){
            monitor.atenderCliente();
            this.setChanged();
            this.notifyObservers("Atendido");
            monitor.verificarOrden();
            this.setChanged();
            this.notifyObservers("Servido");
        }
    }
}
