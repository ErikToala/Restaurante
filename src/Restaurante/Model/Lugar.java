package Restaurante.Model;

public class Lugar {
    private int id;
    private String status;

    public Lugar() { }

    public Lugar(int id, String status) {
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
