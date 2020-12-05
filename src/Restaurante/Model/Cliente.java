package Restaurante.Model;

import java.util.Observable;

public class Cliente extends Observable implements Runnable{

    private String name;
    private Boolean isReservation;

    public Cliente() { }

    public Cliente(String name, Boolean isReservation) {
        this.name = name;
        this.isReservation = isReservation;
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

    @Override
    public void run() {
        System.out.println(this.getReservation());
        System.out.println(Thread.currentThread().getName());
    }
}
