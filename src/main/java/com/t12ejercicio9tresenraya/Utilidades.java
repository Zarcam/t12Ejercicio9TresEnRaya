package com.t12ejercicio9tresenraya;

public class Utilidades {
    public static void imprimirMatriz(String[][] matriz){
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j]);
            }
            System.out.println();
        }
    }

    public static void copiarMatrices(String[][] origen, String[][] destino){
        if(origen.length == destino.length && origen[0].length == destino[0].length){
            for (int i = 0; i < origen.length; i++) {
                for (int j = 0; j < origen[i].length; j++) {
                    destino[i][j] = origen[i][j];
                }
            }
        }
    }
}
