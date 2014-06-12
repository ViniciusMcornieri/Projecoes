package estruturas;


import java.awt.*;
import javax.swing.*;

class Gcanvas extends JPanel {
    public Objeto obj;
    public Gcanvas(Objeto obj){
        super();
        this.obj = obj;
    }
    
    
    
    public void paintComponent(Graphics g) {
        for (Superficie spf : obj.objeto) {
            if(spf.visibilidade){
                this.paintSuperficie(g, spf);
            }
        }
        //paintSuperficie(g, obj.objeto.get(1));
      
    }

    public void paintSuperficie(Graphics g, Superficie spf) {
        for (int i = 0; i < spf.vertices.size()-1; i++) {
            int x1, y1, x2, y2;
            x1 = (int) spf.vertices.get(i).x();
            y1 = (int) spf.vertices.get(i).y();
            x2 = (int) spf.vertices.get(i+1).x();
            y2 = (int) spf.vertices.get(i+1).y();
            g.drawLine(x1, y1, x2, y2);
        }
    }
}
