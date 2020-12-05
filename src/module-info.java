module Restaurante {

    requires javafx.fxml;
    requires javafx.controls;

    opens Restaurante.Model to javafx.base;
    opens Restaurante.View to javafx.fxml;

    exports Restaurante;
}