package projecoes;
import estruturas.*;

public class Projecoes {

    public static void main(String[] args) {
        Leitor leitor = new Leitor("data/casa.txt");
        Objeto obj = leitor.carregar();
        Ponto3D p1 = new Ponto3D(0, 0, 0);
        Ponto3D p2 = new Ponto3D(1, 0, 0);
        Ponto3D p3 = new Ponto3D(0, 1, 0);
        Superficie spf = new Superficie();
        spf.vertices.add(p1);
        spf.vertices.add(p2);
        spf.vertices.add(p3);
        spf.vertices.add(p1);
        Ponto3D pv = new Ponto3D(0, 0, -1);
        spf.calculaNormal();
        Perspectiva pf = new Perspectiva(spf, pv);
        pf.calculaMatriz();
        System.out.println(""+pf.toString());
        obj.aplicaTransf(pf);
        obj.coordHomog();
        obj.refletir();
        obj.viewport(640, 0, 480, 0);
        obj.visibilidade(pv);
        for (Ponto3D pt : obj.pontos) {
            System.out.println("p"+ pt.toString());
        }
        
    }
    
}
