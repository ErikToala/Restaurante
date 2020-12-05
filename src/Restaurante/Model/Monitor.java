package Restaurante.Model;

import java.util.Random;

public class Monitor {

    private String[] lugares;
    private Random rnd;

    public Monitor() {
        lugares = new String[Config.cantClientes];
        for(int i=0; i<Config.cantClientes; i++){
            lugares[i] = "disponible";
        }
        rnd = new Random(System.currentTimeMillis());
    }
}
