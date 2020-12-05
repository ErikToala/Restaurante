package Restaurante.Model;

public class Orden {
    private int id;
    private String status;

    public Orden() { }

    public Orden(int id, String status) {
        this.id = id;
        this.status = status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
