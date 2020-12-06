package Restaurante.View;

import Restaurante.Model.*;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.util.Observable;
import java.util.Observer;
import java.util.Random;

public class RestauranteController implements Observer {

    private int a,b,c = 0;
    private int numImagenes = 4;
    private ImageView[] clientesImg = new ImageView[20];
    private Image[] images = new Image[numImagenes];
    private Cliente[] clientes = new Cliente[Config.cantClientes];
    private Mesero[] meseros = new Mesero[(int) Config.cantMeseros];
    private Cocinero[] cocineros = new Cocinero[(int) Config.cantCocinero];


    @FXML
    private AnchorPane canvas;


    @FXML
    public void initialize(){

        String file = "file: src/Restaurante/Resources/";
        for(int x = 0; x<numImagenes; x++){
            images[x] = new Image(file+x+".png");
        }

        for(int i=0; i< Config.capacidadRest; i++){
            clientesImg[i] = new ImageView();
           if(i<5){
               clientesImg[i].setLayoutX(257 + (106*i)); clientesImg[i]. setLayoutY(351);
               clientesImg[i].setFitHeight(45); clientesImg[i].setFitWidth(50);
               canvas.getChildren().add(clientesImg[i]);
           }
           if(i>4 && i<10){
               clientesImg[i].setLayoutX(257 + (106*i)); clientesImg[i]. setLayoutY(284);
               clientesImg[i].setFitHeight(45); clientesImg[i].setFitWidth(50);
               canvas.getChildren().add(clientesImg[i]);
               a++;
           }
           if(i>9 && i<15){
               clientesImg[i].setLayoutX(257 + (106*i)); clientesImg[i]. setLayoutY(162);
               clientesImg[i].setFitHeight(45); clientesImg[i].setFitWidth(50);
               canvas.getChildren().add(clientesImg[i]);
               b++;
           }
           if(i>14 && i<20){
               clientesImg[i].setLayoutX(257 + (106*i)); clientesImg[i]. setLayoutY(91);
               clientesImg[i].setFitHeight(45); clientesImg[i].setFitWidth(50);
               canvas.getChildren().add(clientesImg[i]);
               c++;
           }
        }

        Monitor monitor = new Monitor();
        for(int i = 0; i < Config.cantClientes; i++){
            Cliente cliente = new Cliente(monitor);
            clientes[i] = cliente;
        }
        for(int a = 0; a < Config.cantMeseros; a++){
            //Mesero mesero = new Mesero(monitor, );
            //meseros[a] = mesero;
        }

        for(int b = 0; b < Config.cantCocinero; b++){
            //Cocinero cocinero = new Cocinero(monitor);
            //cocineros[b] = cocinero;
        }
    }

    @FXML
    void OnMouseClickedClose(MouseEvent event) {


    }

    @FXML
    void OnMouseClickedStart(MouseEvent event) {


    }

    @Override
    public void update(Observable o, Object arg) {

    }

    public Image getClienteImage(){
        Random random = new Random();
        Image image = images[random.nextInt(numImagenes)];
        return image;
    }


    /*public Image getMeseroImage(){
        Random random = new Random();
    }*/

    /*public Image getCocineroImage(){
        Random random = new Random();
    }*/
}
