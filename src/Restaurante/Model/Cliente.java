package Restaurante.Model;

import javafx.scene.control.skin.TableHeaderRow;

import java.util.Observable;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Cliente extends Observable implements Runnable{

    private String name;
    private Boolean isReservation;
    private Random random;
    private Monitor monitor;

    public Cliente() { }

    public Cliente(String name, Boolean isReservation, Monitor monitor) {
        this.name = name;
        this.isReservation = isReservation;
        this.monitor = monitor;
        random = new Random(System.currentTimeMillis());
    }

    public Cliente(Monitor monitor) {
        this.monitor = monitor;
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

    @Override
    public void run() {
        if(isReservation){
            try {
                monitor.reservaciones(name);
                //Thread.sleep(ThreadLocalRandom.current().nextInt(3000) + 1000L);
                Thread.sleep(random.nextInt(3000)+1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else{
            monitor.recibirCliente();
        }
        monitor.asignarLugar(isReservation, name);
        monitor.ordenTomada();
        try {
            //Thread.sleep(ThreadLocalRandom.current().nextInt(3000) + 1000L);
            Thread.sleep(random.nextInt(5000)+2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        monitor.salirCliente(isReservation, name);

    }
}
