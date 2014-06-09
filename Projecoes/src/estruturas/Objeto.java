package estruturas;

import java.util.ArrayList;

public class Objeto {

    public ArrayList<Superficie> objeto;
    public ArrayList<Ponto3D> pontos;

    public Objeto() {
        this.objeto = new ArrayList();
        this.pontos = new ArrayList();
    }

    public void aplicaTransf(Matriz transf) {
        for (Ponto3D ponto : pontos) {
            ponto.aplicaTransf(transf);
        }
    }

    public void coordHomog() {
        for (Ponto3D ponto : pontos) {
            ponto.coordHomog();
        }
    }
}
