package Restaurante.Model;

import java.util.Random;

public class Monitor {

    private Lugar[] lugares;
    private Random rnd;
    private int nCliente;

    public Monitor() {
        lugares = new Lugar[Config.cantClientes];
        for(int i=0; i<Config.cantClientes; i++){
            lugares[i] = new Lugar("","Disponible");
        }
        rnd = new Random(System.currentTimeMillis());
        nCliente = 0;
    }

    public synchronized void recibirCliente(){
        while(nCliente == Config.capacidadRest){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        nCliente++;
    }

    public synchronized void reservaciones(String name){
        while(Config.numReservacion == Config.totalReservaciones || nCliente == Config.capacidadRest){
            try {
                System.out.println(name+" En cola");
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for(int i=0; i < Config.capacidadRest; i++){
            if(lugares[i].getStatus().equals("Disponible")){
                lugares[i].setStatus("Reservado");
                lugares[i].setName(name);
                System.out.println(name+" con reservación en lugar: "+ i);
                Config.lugar = i;
                Config.numReservacion++;
                break;
            }
        }
        nCliente++;
    }

    public synchronized void asignarLugar(boolean isReservation, String name){
        if(isReservation){
            for(int i=0; i < Config.capacidadRest; i++){
                if(lugares[i].getName().equals(name)){
                    lugares[i].setStatus("Ocupado");
                    System.out.println(name+" llego a su reservación en lugar : "+ i);
                    Config.lugar = i;
                    break;
                }
            }
        }else {
            for(int i=0; i < Config.capacidadRest; i++){
                if(lugares[i].getStatus().equals("Disponible")){
                    lugares[i].setStatus("Ocupado");
                    lugares[i].setName(name);
                    System.out.println(name+" en lugar : "+ i);
                    Config.lugar = i;
                    break;
                }
            }
        }
    }

    public synchronized void salirCliente(boolean isReservation, String name){
        for(int i=0; i < Config.capacidadRest; i++){
            if(lugares[i].getName().equals(name)){
                lugares[i].setStatus("Disponible");
                lugares[i].setName("");
                System.out.println("SALIO del restaurante el: "+name);
                Config.lugar = i;
                nCliente--;
                if(isReservation){
                    Config.numReservacion--;
                }
                break;
            }
        }
        if(nCliente < Config.capacidadRest){
            this.notifyAll();
        }
    }


}
