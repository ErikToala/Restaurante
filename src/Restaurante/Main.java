package Restaurante;

import Restaurante.Model.Cliente;
import Restaurante.Model.Config;
import Restaurante.Model.CrearActores;
import Restaurante.Model.Monitor;
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
        //primaryStage.show();
    }


    public static void main(String[] args) {
        Cliente[] clientes = new Cliente[20];
        Monitor monitor = new Monitor();
        for(int i = 0; i < Config.cantClientes; i++){
            Cliente cliente = new Cliente();
            clientes[i] = cliente;
        }
        CrearActores create = new CrearActores(clientes,monitor);

        create.start();

        launch(args);
    }
}
