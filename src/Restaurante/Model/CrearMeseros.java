package Restaurante.Model;

import java.util.Random;

public class CrearMeseros extends Thread {

    private Mesero[] meseros;

    public CrearMeseros(Mesero[] meseros) {
        this.meseros = meseros;
    }

    @Override
    public void run() {
        Mesero mesero;
        for (int a =0; a < Config.cantMeseros; a++){
            mesero = meseros[a];
            new Thread(mesero,"Mesero"+a).start();
        }
    }
}
