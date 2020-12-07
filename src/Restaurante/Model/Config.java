package Restaurante.Model;

public class Config {

    //NO Cambian
    public static int capacidadRest = 20;
    public static int cantClientes = 20;
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
    public static int clientesAfuera = 0;
    public static int ordenLista =0;
}
