package Restaurante.Model;

public class Lugar {
    private String name;
    private String status;
    private boolean isAttended;

    public Lugar() { }

    public Lugar(String name, String status, boolean isAttended) {
        this.name = name;
        this.status = status;
        this.isAttended = isAttended;
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

    public void setAttended(boolean attended) {
        isAttended = attended;
    }


    public boolean isAttended() {
        return isAttended;
    }
}
