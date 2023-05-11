package com.t12ejercicio9tresenraya;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private TextField fieldPlayer1;
    @FXML
    private TextField fieldPlayer2;
    @FXML
    private Button botonReset;
    @FXML
    private Button botonStart;
    @FXML
    private GridPane panelBotones;

    @FXML
    private void pulsadoBoton(ActionEvent event){
        Button boton = (Button) event.getSource();

        boton.setText("X");
        boton.setDisable(true);
    }

    private void limpiarTablero(){
        for(Node boton : panelBotones.getChildren()){
            boton.setDisable(false);
            if(boton instanceof Button){
                ((Button) boton).setText("");
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        botonStart.setOnAction(event -> {
            limpiarTablero();
        });

        botonReset.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            limpiarTablero();
            fieldPlayer1.setText("0");
            fieldPlayer2.setText("0");
        });
    }
}