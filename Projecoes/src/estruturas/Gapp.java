package estruturas;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Gapp extends JFrame {

    public Gapp() {
        setBackground(Color.white);
    }// constructor

    public void initComponents(Objeto obj) throws Exception {
        setLocation(new java.awt.Point(0, 30));
        setSize(new java.awt.Dimension(800, 600));
        setTitle("Projeções");
        getContentPane().add(new Gcanvas(obj));

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                thisWindowClosing(e);
            }
        });
    }//end - initComponents

    void thisWindowClosing(java.awt.event.WindowEvent e) {
        // Close the window when the close box is clicked
        dispose();
    }//end - thisWindowClosing

}//end of class -- Gapp -------------------------------------------
