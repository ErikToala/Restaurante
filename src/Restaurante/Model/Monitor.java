package Restaurante.Model;

import java.util.ArrayList;
import java.util.Random;

public class Monitor {

    private Lugar[] lugares;
    private ArrayList<Orden> ordenes = new ArrayList<>();
    private ArrayList<Orden> comidas = new ArrayList<>();
    private Random rnd;
    private boolean esperando, comidaLista, isCalled;
    private int nCliente;

    public Monitor() {
        lugares = new Lugar[Config.cantClientes];
        for(int i=0; i<Config.cantClientes; i++){
            lugares[i] = new Lugar("","Disponible", false);
        }
        rnd = new Random(System.currentTimeMillis());
        nCliente = 0;
        esperando = true;
        comidaLista= false;
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
        isCalled = true;
        System.out.println("ISCALLED "+ isCalled + Thread.currentThread().getName() );
        this.notifyAll();
    }

 // Mesero
    public synchronized void atenderCliente(){
        while(nCliente==0 || !isCalled){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for(int i =0; i<Config.capacidadRest;i++){
            if(lugares[i].getStatus().equals("Ocupado")){
                if(!lugares[i].isAttended()){
                    lugares[i].setAttended(true);
                    String name;
                    name = lugares[i].getName();
                    System.out.println(Thread.currentThread().getName()+ " Atendió a Cliente "+ name);
                    Orden orden = new Orden(name, "En proceso");
                    ordenes.add(orden);
                    isCalled = false;
                    this.notifyAll();
                }
            }
        }
    }

    public synchronized void verificarOrden(){
        System.out.println("-------------------------------------------------------------------------------"+comidaLista);
        if(comidaLista==true){
            for(int i=0;i<comidas.size();i++){
                if(comidas.get(i).equals("En proceso")){
                    comidas.get(i).setStatus("Listo");
                    Orden orden;
                    orden = comidas.get(i);
                    comidas.remove(i);
                    for(int j=0;j<Config.capacidadRest;i++){
                        if(lugares[j].getName().equals(orden.getName())){
                            esperando=false;
                            System.out.println("--------------------------------------------------------Verificar Orden "+ Thread.currentThread().getName());
                            Config.irAMesa = j;
                            break;
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
                System.out.println("Cocinero "+ Thread.currentThread().getName());
                ordenes.remove(i);
                comidas.add(orden);
                comidaLista=true;
                break;
            }
        }
    }

// Cliente

    public synchronized void ordenTomada(){
        while(esperando==true){
            try {
                System.out.println("ESPERANDO..."+ Thread.currentThread().getName());
                this.wait();
                System.out.println(".....TIENE SU COMIDA"+ Thread.currentThread().getName()+ " " + esperando);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //esperando=true;
        Config.cantOrden++;
    }


    public synchronized void salirCliente(boolean isReservation, String name){
        for(int i=0; i < Config.capacidadRest; i++){
            if(lugares[i].getName().equals(name)){
                lugares[i].setStatus("Disponible");
                lugares[i].setName("");
                lugares[i].setAttended(false);
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
