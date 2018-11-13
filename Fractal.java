/*
*
*/

import java.util.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import javax.swing.*;

public class Fractal extends JFrame{    //inherit JFrame
    /*
    global variables for frame size
    */
    static final int WIDTH=800;
    static final int HEIGHT=800;



    /*
    constructor
    */
    public Fractal(){
        setGUIprop();
        addPanel();
    }

    public void addPanel(){
        panel = new Panel();
        fractalImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        this.add(panel,BorderLayout.CENTER);
        panel.setVisible(true);
    }


    public void setGUIprop(){
        this.setTitle("Fractals");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WIDTH,HEIGHT);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    /*
    canvas
    */
    Panel panel;
    BufferedImage fractalImage;


    public static void main(String[] args) {
        new Fractal();  //creating a new instance of Fractal
    }


    private class Panel extends JPanel{    //inherit JPanel

        @Override
        public Dimension getPreferredSize(){    //Dimension class encapsulates the width and height of a component (in integer precision) in a single object
            return new Dimension(WIDTH,HEIGHT);
        }

        @Override
        public void paintComponent(Graphics obj){
            obj.drawImage(fractalImage, 0, 0, null);
        }
    }
}