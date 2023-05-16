package com.t12ejercicio9tresenraya;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.transform.MatrixType;

import java.lang.reflect.Array;
import java.net.URL;
import java.util.Arrays;
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

    private boolean jugando;

    private final String[] simboloJugador = {"O", "X"};
    private int turnoJugador;

    private final String[][] matrizLimpia = {{"", "", "",}, {"", "", "",}, {"", "", "",}};

    private String[][] matrizTablero = new String[3][3];

    @FXML
    private void pulsadoBoton(ActionEvent event){
        if(jugando) {
            Button boton = (Button) event.getSource();

            boton.setText(simboloJugador[turnoJugador]);
            boton.setDisable(true);

            matrizTablero[GridPane.getRowIndex(boton)][GridPane.getColumnIndex(boton)] = simboloJugador[turnoJugador];

            if (comprobarVictoria()) {
                victoria();
            }

            if (turnoJugador == 0) {
                turnoJugador = 1;
            } else {
                turnoJugador = 0;
            }
        }
    }

    /**
     * @return Valor <strong>boolean</strong> dependiendo de si se ha cumplido la condicion de victoria o no.
     */
    private boolean comprobarVictoria(){
        Utilidades.imprimirMatriz(matrizTablero);

        for (int i = 0; i < matrizTablero.length; i++) {    //Filas
            if(matrizTablero[i][0].equals(matrizTablero[i][1]) && matrizTablero[i][0].equals(matrizTablero[i][2]) && !matrizTablero[i][0].equals("")){
                return true;
            }
        }
        for (int j = 0; j < matrizTablero[0].length; j++) { //Columnas
            if(matrizTablero[0][j].equals(matrizTablero[1][j]) && matrizTablero[0][j].equals(matrizTablero[2][j]) && !matrizTablero[0][j].equals("")){
                return true;
            }
        }
        if(matrizTablero[0][0].equals(matrizTablero[1][1]) && matrizTablero[0][0].equals(matrizTablero[2][2]) && !matrizTablero[0][0].equals("")){ //Diagonal Izquierda
            return true;
        }
        if(matrizTablero[0][2].equals(matrizTablero[1][1]) && matrizTablero[0][2].equals(matrizTablero[2][0]) && !matrizTablero[0][2].equals("")){ //Diagonal Derecha
            return true;
        }

        return false;
    }

    private void victoria(){
        jugando = false;
        int puntos;
        if(turnoJugador == 0){
            puntos = Integer.parseInt(fieldPlayer1.getText());
            puntos++;
            fieldPlayer1.setText(Integer.toString(puntos));
        }else{
            puntos = Integer.parseInt(fieldPlayer2.getText());
            puntos++;
            fieldPlayer2.setText(Integer.toString(puntos));
        }
    }

    private void limpiarTablero(){
        for(Node boton : panelBotones.getChildren()){
            boton.setDisable(false);
            if(boton instanceof Button){
                ((Button) boton).setText("");
            }
        }

        Utilidades.copiarMatrices(matrizLimpia, matrizTablero);
        turnoJugador = 0;
        jugando = true;
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

        //Establece el column y row index de los nodos cuyos index sean null a 0
        for(Node boton : panelBotones.getChildren()){
            if(GridPane.getColumnIndex(boton) == null){
                GridPane.setColumnIndex(boton, 0);
            }
            if(GridPane.getRowIndex(boton) == null){
                GridPane.setRowIndex(boton, 0);
            }
        }

        Utilidades.copiarMatrices(matrizLimpia, matrizTablero);
        turnoJugador = 0;
        jugando = false;
    }
}