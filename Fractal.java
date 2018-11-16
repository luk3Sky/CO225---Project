/*
* CO225 - Software Construction
* E/15/142 - Jayalath A.H.G.D.
* E/15/154 - Jayasooriya J.K.C.N.
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
    static protected final int WIDTH=800;
    static protected final int HEIGHT=800;

    //may change 
    static int MAX_N = 1000;    //maximum no. of iterations

    //panel
    Panel panel;
    BufferedImage fractalImage;

    //static final double DEFAULT_ZOOM       = 800.0;
    static protected double DEFAULT_REAL_N = -1.0;
    static protected double DEFAULT_REAL_P = +1.0;
    static protected double DEFAULT_IMG_N  = -1.0;
    static protected double DEFAULT_IMG_P  = +1.0;
	
	//double zoomFactor = DEFAULT_ZOOM;
	double real_p   = DEFAULT_REAL_P;
    double real_n   = DEFAULT_REAL_N;
    double img_n   = DEFAULT_IMG_N;
    double img_p   = DEFAULT_IMG_P;
    //---------------------------------------------------
    /*
    Main Window
    */
    public void setGUIprop(){
        this.setTitle("Fractal");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WIDTH,HEIGHT);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void addPanel(){
        panel = new Panel();
        fractalImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        panel.setVisible(true);
        this.add(panel,BorderLayout.CENTER);
    }

// -------------------------------------------------------------------
    // return x coordinates
	public double getX(double x) {
		return (x/WIDTH)*(real_p-real_n) + real_n;
	} 

    // return y coordinates
	public double getY(double y) {
		return (y/HEIGHT)*(img_n-img_p) + img_p;
	}

	
// -------------------------------------------------------------------
    public static void main(String[] args) {
        // try {
            if (args[0].equals("Mandelbrot")) {
                switch (args.length) {
                    case 6:
                        new Mandelbrot(Double.parseDouble(args[1]), Double.parseDouble(args[2]), Double.parseDouble(args[3]), Double.parseDouble(args[4]), Integer.parseInt(args[5]));
                        break;
                    case 4:
                        new Mandelbrot(Double.parseDouble(args[1]), Double.parseDouble(args[2]), Integer.parseInt(args[3]));
                        break;
                    case 1:
                        new Mandelbrot();
                        break;
               }
                return;
            }else if(args[0].equals("Julia")){
                switch (args.length) {
                    case 4:
                        new Julia(Double.parseDouble(args[1]), Double.parseDouble(args[2]), Integer.parseInt(args[3]));
                        break;
                    case 3:
                        new Julia(Double.parseDouble(args[1]), Double.parseDouble(args[2]));
                        break;
                    case 1:
                        new Julia();
                        break;
               }
            }else {
                System.out.println("Usage: \"java Fractal\" <Type> <C/R> <Ite>\nTypes:Julia/Mandelbrot \nC: c_real, c_imaginary/ R: real_interval[a,b], imaginary_interval\nIte: Maximum iterations(Optional)");
            }
    }


    public class Panel extends JPanel{    //inherit JPanel

        @Override
        public Dimension getPreferredSize(){    //Dimension class encapsulates the width and height of a component (in integer precision) in a single object
            return new Dimension(WIDTH,HEIGHT);
        }

        @Override
        public void paintComponent(Graphics g){
            g.drawImage(fractalImage, 0, 0, null);
        }
    }
}
