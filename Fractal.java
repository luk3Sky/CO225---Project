/*
*
*/

import java.util.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import javax.swing.*;

public class Fractal extends JFrame{
    static final int WIDTH=800;
    static final int HEIGHT=800;

    /*
    constructor
    */
    public Fractal(){
        setGUIprop();
    }

    public void setGUIprop(){
        this.setTitle("Fractals");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WIDTH,HEIGHT);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Fractal();  //creating a new instance of Fractal
    }
}