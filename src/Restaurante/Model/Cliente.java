package Restaurante.Model;

import javafx.scene.control.skin.TableHeaderRow;
import javafx.scene.image.Image;

import java.util.Observable;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Cliente extends Observable implements Runnable{

    private String name;
    private Boolean isReservation;
    private Random random;
    private Monitor monitor;
    private int lugar;
    private Image image;

    public Cliente(String name, Boolean isReservation, Monitor monitor, Image image) {
        this.name = name;
        this.isReservation = isReservation;
        this.monitor = monitor;
        this.image = image;
        random = new Random(System.currentTimeMillis());
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setReservation(Boolean reservation) {
        isReservation = reservation;
    }

    public Boolean getReservation() {
        return isReservation;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public int getLugar() {
        return lugar;
    }

    @Override
    public void run() {
        if(isReservation){
            try {
                monitor.reservaciones(name);
                this.setChanged();
                this.notifyObservers("Reservacion");

                Thread.sleep(random.nextInt(3000)+1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else{
            monitor.recibirCliente();
        }
        Config.clientesEntrando++;
        Config.clientesAfuera--;
        monitor.asignarLugar(isReservation, name);
        lugar = Config.lugar;
        this.setChanged();
        this.notifyObservers("LugarAsig");
        try {
            //Thread.sleep(ThreadLocalRandom.current().nextInt(3000) + 1000L);
            Thread.sleep(random.nextInt(2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        monitor.ordenTomada();
        setChanged();
        notifyObservers("OrdenTomada");
        try {
            //Thread.sleep(ThreadLocalRandom.current().nextInt(3000) + 1000L);
            Thread.sleep(random.nextInt(5000)+2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Config.clientesSaliendo++;
        monitor.salirCliente(isReservation, name, lugar);

        this.setChanged();
        this.notifyObservers("Salio");
    }
}
