package Restaurante.Model;

import java.util.ArrayList;
import java.util.Random;

public class Monitor {

    private Lugar[] lugares;
    private ArrayList<Orden> ordenes = new ArrayList<>();
    private ArrayList<Orden> comidas = new ArrayList<>();
    private Random rnd;
    private boolean comidaLista;
    private boolean esperando;
    private boolean isCalled;
    private int nCliente;
    private Orden orden;


    public Monitor() {
        lugares = new Lugar[Config.cantClientes];
        for(int i=0; i<Config.cantClientes; i++){
            lugares[i] = new Lugar("","Disponible");
        }
        rnd = new Random(System.currentTimeMillis());
        nCliente = 0;
        comidaLista= false;
        esperando=false;
        isCalled=false;
    }

    //Recepcionista
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

    //Recepcionista
    public synchronized void reservaciones(String name){
        while(Config.numReservacion == Config.totalReservaciones || nCliente == Config.capacidadRest){
            try {
                //System.out.println(name+" En cola");
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
                Config.lugarReservado = i;
                Config.numReservacion++;
                break;
            }
        }
        nCliente++;
    }

    //Recepcionista
    public synchronized void asignarLugar(boolean isReservation, String name){
        if(isReservation){
            for(int i=0; i < Config.capacidadRest; i++){
                if(lugares[i].getName().equals(name)){
                    lugares[i].setStatus("Ocupado");
                    Config.lugar = i;
                    System.out.println(name+" llego a su reservación en lugar : "+ i);
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
                    //System.out.println(Config.lugar+"-"+lugares[i].getName());
                    break;
                }
            }
        }
        isCalled=true;
        this.notifyAll();
    }

    //Mesero
    public synchronized void atenderCliente(){
        while(nCliente==0 || !isCalled){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isCalled=false;
        for(int i =0; i<Config.capacidadRest;i++){
            if(lugares[i].getStatus().equals("Ocupado")){
                Config.irAMesa = i;
                lugares[i].setStatus("Atendido");
                String name;
                name = lugares[i].getName();
                //System.out.println(Thread.currentThread().getName()+ " Atendió a Cliente "+ name);
                orden = new Orden(name, "En proceso");
                /*ordenes.add(orden);

                this.notifyAll();*/
                break;
            }
        }
    }

    public synchronized void agregarOrden(){
        ordenes.add(orden);
        this.notifyAll();
    }

    //Cliente
    public synchronized void ordenTomada(){
        //esperando = true;
        while(esperando){
            try {
                System.out.println("ESPERANDO..."+ Thread.currentThread().getName()+" - ");
                this.wait();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(".....TIENE SU COMIDA "+ Thread.currentThread().getName()+ " ");
        Config.cantOrden++;
    }

    //Mesero
    public synchronized void verificarOrden(){
        if(comidaLista==true){
            for(int i=0;i<comidas.size();i++){
                if(comidas.get(0).getStatus().equals("En proceso")){
                    comidas.get(0).setStatus("Listo");
                    Orden orden;
                    orden = comidas.get(0);
                    comidas.remove(0);
                    for(int j=0;j<Config.capacidadRest;j++){
                        if(lugares[j].getStatus().equals("Atendido")){
                            if(lugares[j].getName().equals(orden.getName())){
                                esperando=false;
                                this.notifyAll();
                                System.out.println("Entrego orden "+ Thread.currentThread().getName());
                                Config.mesaServida = j;

                                break;
                            }
                        }
                    }
                    break;
                }
            }

        }
    }

 //Cocinero
    public synchronized void cocinarComida(){
        while(ordenes.isEmpty()){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(comidas.isEmpty()){
            comidaLista=false;
        }
        for(int i=0;i<ordenes.size();i++){
            if(ordenes.get(i).getStatus().equals("En proceso")){
                Orden orden;
                orden = ordenes.get(i);
                //System.out.println(Thread.currentThread().getName()+" cocinó la orden "+orden.getName());
                ordenes.remove(i);
                comidas.add(orden);
                comidaLista=true;
                break;
            }
        }
    }

    public synchronized void salirCliente(boolean isReservation, String name){
        for(int i=0; i < Config.capacidadRest; i++){
            if(lugares[i].getName().equals(name)){
                lugares[i].setStatus("Disponible");
                lugares[i].setName("");
                //lugares[i].setAttended(false);
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
