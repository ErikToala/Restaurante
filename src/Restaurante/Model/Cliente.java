package Restaurante.Model;

public class Cliente {

    private Lugar place;
    private Boolean isReservation;

    public Cliente() { }

    public Cliente(Lugar place, Boolean isReservation) {
        this.place = place;
        this.isReservation = isReservation;
    }

    public void setPlace(Lugar place) {
        this.place = place;
    }

    public Lugar getPlace() {
        return place;
    }

    public void setReservation(Boolean reservation) {
        isReservation = reservation;
    }

    public Boolean getReservation() {
        return isReservation;
    }
}
