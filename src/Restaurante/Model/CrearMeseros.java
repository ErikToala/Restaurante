package Restaurante.Model;

import java.util.Random;

public class CrearMeseros extends Thread {

    private Mesero[] meseros;
    private Random random;

    public CrearMeseros(Mesero[] meseros) {
        this.meseros = meseros;
        random = new Random(System.currentTimeMillis());
    }

    @Override
    public void run() {
        Mesero mesero;
        for (int a =0; a< Config.cantMeseros; a++){
            mesero = meseros[a];
            new Thread(mesero,"Mesero"+a).start();
            try {
                Thread.sleep(random.nextInt(400)+100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
