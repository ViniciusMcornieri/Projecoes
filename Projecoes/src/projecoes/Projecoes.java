package projecoes;

import estruturas.*;

public class Projecoes {
    // A interface deve receber
    //a string com o caminho da leitura
    //3 pontos(x,y,z) do plano
    //um ponto de vista
    //selecao de projeçao perspectiva ou paralela
    public static void main(String[] args) {
        System.out.println("leitura");
        Leitor leitor = new Leitor("data/casa.txt");
        System.out.println("Carregamento");
        Objeto obj = leitor.carregar();
        System.out.println("Calculos");
        Ponto3D p1 = new Ponto3D(0, 0, 0);
        Ponto3D p2 = new Ponto3D(1, 0, 0);
        Ponto3D p3 = new Ponto3D(0, 1, 0);
        Superficie spf = new Superficie();
        spf.vertices.add(p1);
        spf.vertices.add(p2);
        spf.vertices.add(p3);
        spf.vertices.add(p1);
        Ponto3D pv = new Ponto3D(-20, -50, -50);
        spf.calculaNormal();
        Perspectiva pf = new Perspectiva(spf, pv);
        pf.calculaMatriz();
        System.out.println("" + pf.toString());
        obj.aplicaTransf(pf);
        obj.coordHomog();
        obj.refletir();
        obj.viewport(600, 0, 480, 0);
        obj.visibilidade(pv);
        for (Ponto3D pt : obj.pontos) {
            System.out.println("p" + pt.toString());
        }
        //Imprimi Projeção
        try {
            Gapp myGapp = new Gapp();
            myGapp.initComponents(obj);
            myGapp.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("FOI!");
    }

}
