package Restaurante.Model;

public class Lugar {
    private String name;
    private String status;

    public Lugar() { }

    public Lugar(String name, String status) {
        this.name = name;
        this.status = status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
