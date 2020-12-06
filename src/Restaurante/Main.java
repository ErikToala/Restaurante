package Restaurante;

import Restaurante.Model.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("View/Restaurante.fxml"));
        primaryStage.setTitle("Restaurante Marriot");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
       /* Cliente[] clientes = new Cliente[20];
        Mesero[] meseros = new Mesero[2];
        Cocinero[] cocineros = new Cocinero[2];

        Monitor monitor = new Monitor();
        for(int i = 0; i < Config.cantClientes; i++){
            Cliente cliente = new Cliente(monitor);
            clientes[i] = cliente;
        }
        for(int a = 0; a < Config.cantMeseros; a++){
            Mesero mesero = new Mesero(monitor);
            meseros[a] = mesero;
        }

        for(int b = 0; b < Config.cantCocinero; b++){
            Cocinero cocinero = new Cocinero(monitor);
            cocineros[b] = cocinero;
        }

        CrearClientes create = new CrearClientes(clientes);
        CrearMeseros meseritos = new CrearMeseros(meseros);
        CrearCocineros chef = new CrearCocineros(cocineros);

        create.start();
        meseritos.start();
        chef.start();*/

        launch(args);
    }
}
