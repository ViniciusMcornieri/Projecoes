package estruturas;


import java.awt.*;
import javax.swing.*;

class Gcanvas extends JPanel {

    public void paintComponent(Graphics g, Objeto obj) {
        for (Superficie spf : obj.objeto) {
            if(spf.visibilidade){
                this.paintSuperficie(g, spf);
            }
        }
        //g.drawLine(800, 1, 1, 1);
       //g.drawLine(50, 50, 50, 150);
       /** g.drawLine(50, 150, 100, 100);
       // g.drawLine(100, 100, 100, 150);
       // g.drawLine(100, 150, 200, 150);
        g.drawLine(200, 150, 200, 50);
        g.drawLine(200, 50, 100, 50);
        g.drawLine(100, 50, 100, 100);
        g.drawLine(100, 100, 50, 50);
        g.drawLine(200, 50, 250, 100);
        g.drawLine(250, 100, 200, 150); **/
    }//paintComponent

    public void paintSuperficie(Graphics g, Superficie spf) {
        for (int i = 0; i < spf.vertices.size()-1; i++) {
            int x1, y1, x2, y2;
            x1 = (int) spf.vertices.get(i).x();
            y1 = (int) spf.vertices.get(i).y();
            x2 = (int) spf.vertices.get(i+1).x();
            y2 = (int) spf.vertices.get(i+1).y();
            g.drawLine(x1, y1, x2, y2);
        }
        //g.drawLine(800, 1, 1, 1);
       //g.drawLine(50, 50, 50, 150);
       /** g.drawLine(50, 150, 100, 100);
       // g.drawLine(100, 100, 100, 150);
       // g.drawLine(100, 150, 200, 150);
        g.drawLine(200, 150, 200, 50);
        g.drawLine(200, 50, 100, 50);
        g.drawLine(100, 50, 100, 100);
        g.drawLine(100, 100, 50, 50);
        g.drawLine(200, 50, 250, 100);
        g.drawLine(250, 100, 200, 150); **/
    }
}//end of -- Gcanvas --------------------------------------------
