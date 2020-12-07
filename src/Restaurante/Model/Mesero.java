package Restaurante.Model;

import javafx.scene.image.Image;

import java.util.Observable;
import java.util.Random;

public class Mesero extends Observable implements Runnable {

    private Monitor monitor;
    private Image image;
    private Random random;

    public Mesero(Monitor monitor, Image image) {
        this.monitor = monitor;
        this.image = image;
        random = new Random(System.currentTimeMillis());
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
            /*try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            monitor.agregarOrden();
            this.setChanged();
            this.notifyObservers("AgregarOrden");
            monitor.verificarOrden();
            this.setChanged();
            this.notifyObservers("Servido");
        }
    }
}
