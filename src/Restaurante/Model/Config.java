package Restaurante.Model;

public class Config {

    //NO Cambian
    public static int capacidadRest = 20;
    public static int cantClientes = 50;
    public static double cantMeseros = (capacidadRest * .10);
    public static double cantCocinero = (capacidadRest * .10);
    public static double totalReservaciones = capacidadRest * .20;

    //Cambian
    public static int lugarReservado = 0;
    public static int mesaServida = 0;
    public static int lugar = 0;
    public static int cantOrden = 0;
    public static int irAMesa = 0;
    public static double numReservacion = 0;
    public static int nClientes = 0;
    public static int clientesAfuera = cantClientes;
    public static int clientesEntrando = 0;
    public static int clientesSaliendo = 0;
    public static int clientesEsperando = 0;

    public static int numComida = 0;


}
