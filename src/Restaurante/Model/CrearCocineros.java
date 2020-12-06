package Restaurante.Model;

import java.util.Random;

public class CrearCocineros extends Thread {

    private Cocinero[] cocineros;
    private Random random;

    public CrearCocineros(Cocinero[] cocineros){
        this.cocineros = cocineros;
        random = new Random(System.currentTimeMillis());
    }

    @Override
    public void run() {
        Cocinero cocinero;
        for (int c =0; c< Config.cantCocinero; c++){
            cocinero = cocineros[c];
            new Thread(cocinero,"Chef"+c).start();
            try {
                Thread.sleep(random.nextInt(400)+100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
