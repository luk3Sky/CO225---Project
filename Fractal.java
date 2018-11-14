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

    //may change 
    static final int MAX_N=1000;    //maximum no. of iterations


    //may change---------------------------------------
    //static final double DEFAULT_ZOOM       = 800.0;
    static final double DEFAULT_REAL_N = -1.0;
    static final double DEFAULT_REAL_P = +1.0;
    static final double DEFAULT_IMG_N  = -1.0;
    static final double DEFAULT_IMG_P  = +1.0;
	
	//double zoomFactor = DEFAULT_ZOOM;
	double real_p   = DEFAULT_REAL_P;
    double real_n   = DEFAULT_REAL_N;
    double img_n   = DEFAULT_IMG_N;
    double img_p   = DEFAULT_IMG_P;
     
    // -------------------------------------------------------------------	coloring method
	public int makeColor( int iterCount ) {
        
        int color = 0b000101110101011000011100; 
		int mask  = 0b000000000000101100110101;
        int shiftMag = iterCount / 3;

		if (iterCount == MAX_N) 
            return Color.BLACK.getRGB();
            
        return color | (mask << shiftMag);
	} 


// -------------------------------------------------------------------
    public static void main(String[] args) {
        if (args[0].equals("Mandelbrot")) {
            new Mandelbrot();  //creating a new instance of Fractal
        }else if(args[0].equals("Julia")){
            System.out.println("Julia");
            new Julia();
        }else {
            System.out.println("Usage");
        }

    }



}
