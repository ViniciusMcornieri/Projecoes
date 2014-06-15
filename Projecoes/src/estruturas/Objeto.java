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
    
    public void refletir(){
        for (Ponto3D ponto : pontos) {
            ponto.sety((-1)*ponto.y());
        }
    }
    
    public void visibilidade(Ponto3D visao){
        for (Superficie superficie : objeto) {
            superficie.visibilidade(visao);
        }
    }
    
    public void viewport(float uMax, float uMin, float vMax, float vMin){
        float xMin = Float.MAX_VALUE;
        float xMax = Float.MIN_VALUE;
        float yMin = Float.MAX_VALUE;
        float yMax = Float.MIN_VALUE;
        for (Ponto3D ponto : pontos) {
            xMin = Math.min(xMin, ponto.x());
            xMax = Math.max(xMax, ponto.x());
            yMin = Math.min(yMin, ponto.y());
            yMax = Math.max(yMax, ponto.y());
        }
        //yMax = 8;
        float sx = (uMax - uMin) / (xMax - xMin);
        float sy = (vMax - vMin) / (yMax - yMin);
        
      for (Ponto3D ponto : pontos) {
           ponto.setx(sx*ponto.x()- sx*xMin);
           ponto.sety(sy*ponto.y()- sy*yMin);
        }
    }
}
