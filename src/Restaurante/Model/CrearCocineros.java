package Restaurante.Model;

import java.util.Random;

public class CrearCocineros extends Thread {

    private Cocinero[] cocineros;

    public CrearCocineros(Cocinero[] cocineros){
        this.cocineros = cocineros;
    }

    @Override
    public void run() {
        Cocinero cocinero;
        for (int c =0; c< Config.cantCocinero; c++){
            cocinero = cocineros[c];
            new Thread(cocinero,"Chef"+c).start();
        }
    }
}
