package Restaurante.Model;

public class Orden {
    private String name;
    private String status;

    public Orden() { }

    public Orden(String name, String status) {
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
