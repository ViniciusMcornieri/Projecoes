package projecoes;

import java.io.File;
import java.io.IOException;

public class Projecoes {
    // A interface deve receber
    //a string com o caminho da leitura
    //3 pontos(x,y,z) do plano
    //um ponto de vista
    //selecao de projeçao perspectiva ou paralela
    public static void main(String[] args) {
        Tela tela = new Tela();
        tela.setVisible(true);
        tela.setText(System.getProperty("user.dir"));
    }
}
