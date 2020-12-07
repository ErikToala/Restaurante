package Restaurante.Model;

import java.util.Random;

public class CrearClientes extends Thread {

    private Cliente[] clientes;
    private Random random;

    public CrearClientes(Cliente[] clientes) {
        this.clientes = clientes;
        random = new Random(System.currentTimeMillis());
    }

    @Override
    public void run() {
        Cliente cliente;
        for (int a = 0; a < Config.cantClientes; a++){
            cliente = clientes[a];
            new Thread(cliente, "C"+ a).start();
            try {
                Thread.sleep(random.nextInt(400)+100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
