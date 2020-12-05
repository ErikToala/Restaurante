package Restaurante.Model;

import java.util.Random;

public class CrearActores extends Thread {

    private Cliente[] clientes;
    private Mesero[] meseros;
    private Cocinero[] cocineros;
    private Random random;

    public CrearActores(Cliente[] clientes, Mesero[] meseros, Cocinero[] cocineros) {
        this.clientes = clientes;
        this.meseros = meseros;
        this.cocineros = cocineros;
        random = new Random(System.currentTimeMillis());
    }

    @Override
    public void run() {
        Cliente cliente;
        for (int a = 0; a < Config.cantClientes; a ++){
            cliente = clientes[a];
            //new Thread(cliente,i).start();
            try {
                Thread.sleep(random.nextInt(400)+100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Mesero mesero;
        for (int a =0; a< Config.cantMeseros; a++){
            mesero = meseros[a];
            //new Thread(mesero,a).start();
            try {
                Thread.sleep(random.nextInt(400)+100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Cocinero cocinero;
        for (int c =0; c< Config.cantCocinero; c++){
            cocinero = cocineros[c];
            //new Thread(mesero,a).start();
            try {
                Thread.sleep(random.nextInt(400)+100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }



    }
}
