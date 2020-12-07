package Restaurante.View;

import Restaurante.Model.*;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.util.Observable;
import java.util.Observer;
import java.util.Random;

public class RestauranteController implements Observer {

    //Cantidad de imagenes
    private int numImgCliente = 4;
    private int numImgMesero = 2;
    private int numImgChef = 2;
    //Arreglos de Imagenes
    private Image[] imagesClientes = new Image[numImgCliente];
    private Image[] imagesMesero = new Image[numImgMesero];
    private Image[] imagesChefs = new Image[numImgChef];
    //Arreglos de Actores
    private Cliente[] clientes = new Cliente[Config.cantClientes];
    private Mesero[] meseros = new Mesero[(int) Config.cantMeseros];
    private Cocinero[] chefs = new Cocinero[(int) Config.cantCocinero];
    //Arreglos de Imagenes de Actores
    private ImageView[] clientesImg = new ImageView[20];
    private ImageView[] meserosImg = new ImageView[20];
    private ImageView[] chefsImg = new ImageView[2];
    private ImageView[] reservacionesImg = new ImageView[20];
    private ImageView[] comidasImg = new ImageView[20];
    private ImageView[] bufferComidas = new ImageView[5];

    @FXML
    private AnchorPane canvas;
    @FXML
    private ImageView mesero1Img;
    @FXML
    private ImageView mesero0Img;
    @FXML
    private Label lbCountIn;
    @FXML
    private Label lbCountOut;
    /*@FXML
    private Label lbCountEsperando;*/

    @FXML
    private Label lbCountClient;

    @FXML
    private Label lbCountPeople;
    @FXML
    public void initialize(){

        String file = "file:src/Restaurante/Resources/";
        for(int x = 0; x<numImgCliente; x++){
            imagesClientes[x] = new Image(file+"Cliente"+x+".png");
        }

        for(int x = 0; x<numImgMesero; x++){
            imagesMesero[x] = new Image(file+"Mesero"+x+".png");
        }

        /*for(int x = 0; x<numImgChef; x++){
            imagesChefs[x] = new Image(file+"Chef"+x+".png");
        }*/

        //LLenar el Restaurante de Actores
        int a=0,b=0,c=0;
        for(int i=0; i< Config.capacidadRest; i++){
            clientesImg[i] = new ImageView();
            meserosImg[i] = new ImageView();
            reservacionesImg[i] = new ImageView();
            comidasImg[i] = new ImageView();
           if(i<5){
               clientesImg[i].setLayoutX(257 + (106*i)); clientesImg[i]. setLayoutY(351);
               clientesImg[i].setFitHeight(45); clientesImg[i].setFitWidth(45);
               clientesImg[i].setRotate(180);

               meserosImg[i].setLayoutX(216+(106*i)); meserosImg[i].setLayoutY(382);
               meserosImg[i].setFitHeight(37); meserosImg[i].setFitWidth(50);
               meserosImg[i].setRotate(270);

               reservacionesImg[i].setLayoutX(249+(106*i));
               reservacionesImg[i].setLayoutY(375);
               reservacionesImg[i].setFitWidth(67);
               reservacionesImg[i].setFitHeight(50);

               comidasImg[i].setLayoutX(268+(105*i));
               comidasImg[i].setLayoutY(385);
               comidasImg[i].setFitWidth(30);
               comidasImg[i].setFitHeight(30);

               canvas.getChildren().addAll(clientesImg[i],meserosImg[i], reservacionesImg[i], comidasImg[i]);

           }
           if(i>4 && i<10){
               clientesImg[i].setLayoutX(257 + (106*a)); clientesImg[i]. setLayoutY(284);
               clientesImg[i].setFitHeight(45); clientesImg[i].setFitWidth(45);

               meserosImg[i].setLayoutX(216+(106*a)); meserosImg[i].setLayoutY(264);
               meserosImg[i].setFitHeight(37); meserosImg[i].setFitWidth(50);
               meserosImg[i].setRotate(270);

               reservacionesImg[i].setLayoutX(249+(106*a));
               reservacionesImg[i].setLayoutY(254);
               reservacionesImg[i].setFitWidth(67);
               reservacionesImg[i].setFitHeight(50);

               comidasImg[i].setLayoutX(268+(105*a));
               comidasImg[i].setLayoutY(263);
               comidasImg[i].setFitWidth(30);
               comidasImg[i].setFitHeight(30);

               canvas.getChildren().addAll(clientesImg[i],meserosImg[i], reservacionesImg[i], comidasImg[i]);
               a++;
           }
           if(i>9 && i<15){
               clientesImg[i].setLayoutX(257 + (106*b)); clientesImg[i]. setLayoutY(162);
               clientesImg[i].setFitHeight(45); clientesImg[i].setFitWidth(45);
               clientesImg[i].setRotate(180);

               meserosImg[i].setLayoutX(216+(106*b)); meserosImg[i].setLayoutY(193);
               meserosImg[i].setFitHeight(37); meserosImg[i].setFitWidth(50);
               meserosImg[i].setRotate(270);

               reservacionesImg[i].setLayoutX(249+(106*b));
               reservacionesImg[i].setLayoutY(187);
               reservacionesImg[i].setFitWidth(67);
               reservacionesImg[i].setFitHeight(50);

               comidasImg[i].setLayoutX(268+(105*b));
               comidasImg[i].setLayoutY(197);
               comidasImg[i].setFitWidth(30);
               comidasImg[i].setFitHeight(30);

               canvas.getChildren().addAll(clientesImg[i],meserosImg[i], reservacionesImg[i], comidasImg[i]);
               b++;
           }
           if(i>14 && i<20){
               clientesImg[i].setLayoutX(257 + (106*c)); clientesImg[i]. setLayoutY(91);
               clientesImg[i].setFitHeight(45); clientesImg[i].setFitWidth(45);

               meserosImg[i].setLayoutX(216+(106*c)); meserosImg[i].setLayoutY(68);
               meserosImg[i].setFitHeight(37); meserosImg[i].setFitWidth(50);
               meserosImg[i].setRotate(270);

               reservacionesImg[i].setLayoutX(249+(106*c));
               reservacionesImg[i].setLayoutY(62);
               reservacionesImg[i].setFitWidth(67);
               reservacionesImg[i].setFitHeight(50);

               comidasImg[i].setLayoutX(268+(105*c));
               comidasImg[i].setLayoutY(71);
               comidasImg[i].setFitWidth(30);
               comidasImg[i].setFitHeight(30);

               canvas.getChildren().addAll(clientesImg[i],meserosImg[i], reservacionesImg[i], comidasImg[i]);
               c++;
           }
        }

        for(int k=0;k<5;k++){
            bufferComidas[k] = new ImageView();
            bufferComidas[k].setFitWidth(30);
            bufferComidas[k].setFitHeight(30);
            bufferComidas[k].setLayoutX(178);
            bufferComidas[k].setLayoutY(80+(35*k));
            canvas.getChildren().add(bufferComidas[k]);
        }

        Monitor monitor = new Monitor();
        int numR = 0;
        int numN = 0;
        for(int i = 0; i < Config.cantClientes; i++){
            Cliente cliente = new Cliente("C"+i,getReservacion(),monitor, getClienteImage());
            cliente.addObserver(this);
            /*System.out.println("Quiere reservación? "+cliente.getReservation());
            if(cliente.getReservation()){
                numR++;
            }else{
                numN++;
            }*/
            clientes[i] = cliente;
        }
        //System.out.println("Reservados: "+numR+" - Normales: "+numN);

        for(int j = 0; j < Config.cantMeseros; j++){
            Mesero mesero = new Mesero(monitor,imagesMesero[j]);
            mesero.addObserver(this);
            meseros[j] = mesero;
        }

        for(int k = 0; k < Config.cantCocinero; k++){
            Cocinero chef = new Cocinero(monitor, imagesChefs[k]);
            chef.addObserver(this);
            chefs[k] = chef;
        }
    }

    @FXML
    void OnMouseClickedClose(MouseEvent event) {
        Platform.exit();
        System.exit(1);

    }

    @FXML
    void OnMouseClickedStart(MouseEvent event) {
        CrearClientes clientitos = new CrearClientes(clientes);
        CrearMeseros meseritos = new CrearMeseros(meseros);
        CrearCocineros chefsitos = new CrearCocineros(chefs);
        meseritos.start();
        chefsitos.start();
        clientitos.start();

    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof Cliente){
            if(String.valueOf(arg).compareTo("Reservacion")==0){
                //.out.println("Hizo reservación: "+((Cliente) o).getName()+" - "+Config.lugarReservado);
                Image img = new Image("file:src/Restaurante/Resources/Reservado.png");
                ImageView valorRe = reservacionesImg[Config.lugarReservado];
                Platform.runLater(()->{
                    valorRe.setImage(img);
                });
            }
            if(String.valueOf(arg).compareTo("LugarAsig")==0){
                ImageView valor = clientesImg[((Cliente) o).getLugar()];
                if(((Cliente) o).getReservation()){
                    ImageView valorR = reservacionesImg[((Cliente) o).getLugar()];
                    //System.out.println("********Llego "+((Cliente) o).getName()+" a la reservación" + ((Cliente) o).getLugar());
                    Platform.runLater(()->{
                        valorR.setImage(null);
                    });
                }
                Platform.runLater(()->{
                    lbCountPeople.setText("Afuera: "+Config.clientesAfuera);
                    lbCountIn.setText("Entrando: "+Config.clientesEntrando);
                    //System.out.println("_______Llego "+((Cliente) o).getName()+" - "+((Cliente) o).getLugar());
                    valor.setImage(((Cliente) o).getImage());

                });

            }
            if(String.valueOf(arg).compareTo("OrdenTomada")==0){
                ImageView valorC = comidasImg[((Cliente) o).getLugar()];
                Image img = new Image("file:src/Restaurante/Resources/Comida.png");
                Platform.runLater(()->{
                    valorC.setImage(img);
                });
            }
            if(String.valueOf(arg).compareTo("Salio")==0){
                ImageView valorC = comidasImg[((Cliente) o).getLugar()];
                ImageView valor = clientesImg[((Cliente) o).getLugar()];
                //System.out.println("{{{{{{{{{{{{{{{{Salio"+((Cliente) o).getName()+" - "+((Cliente) o).getLugar());
                Platform.runLater(()->{
                    valor.setImage(null);
                    valorC.setImage(null);
                    lbCountOut.setText("Saliendo: "+Config.clientesSaliendo);
                });
            }
        }else if(o instanceof Mesero){
            /*ImageView valorM = meserosImg[Config.irAMesa];
            if(String.valueOf(arg).compareTo("Atendido")==0){
                System.out.println(Thread.currentThread().getName()+ " Atendió a Cliente");

                if(((Mesero) o).getImage().getUrl().equals("file:src/Restaurante/Resources/Mesero0.png")){
                    Platform.runLater(()->{
                        mesero0Img.setVisible(false);
                        valorM.setImage(((Mesero )o).getImage());
                    });
                }else{
                    Platform.runLater(()->{
                        mesero1Img.setVisible(false);
                        valorM.setImage(((Mesero )o).getImage());
                    });
                }
            }*/
            /*if(String.valueOf(arg).compareTo("Servido")==0){
                //ImageView valorM = meserosImg[Config.irAMesa];
                Platform.runLater(()->{
                    valorM.setImage(((Mesero )o).getImage());
                });
            }*/

        }else if(o instanceof Cocinero){
            if(String.valueOf(arg).compareTo("ComidaLista")==0){
                Image img = new Image("file:src/Restaurante/Resources/Comida.png");
                ImageView valor = bufferComidas[Config.numComida];
                Platform.runLater(()->{
                    valor.setImage(img);
                });
            }
            /*if(String.valueOf(arg).compareTo("AgregarOrden")==0){
                if(((Mesero) o).getImage().getUrl().equals("file:src/Restaurante/Resources/Mesero0.png")){
                    Platform.runLater(()->{
                        mesero0Img.setVisible(true);
                        valorM.setImage(null);
                    });
                }else{
                    Platform.runLater(()->{
                        mesero1Img.setVisible(true);
                        valorM.setImage(null);
                    });
                }
            }*/
        }
    }

    public Image getClienteImage(){
        Random random = new Random();
        Image image = imagesClientes[random.nextInt(numImgCliente)];
        return image;
    }

    public boolean getReservacion(){
        Random rnd = new Random();
        return rnd.nextBoolean();
    }
}
