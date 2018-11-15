/*
*
*/

import java.util.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import javax.swing.*;

public class Julia extends Fractal{    //inherit JFrame
    /*
    global variables for frame size
    */
    // static final int WIDTH=800;
    // static final int HEIGHT=800;
    
    public double c_r;
    public double c_i;
    
// -------------------------------------------------------------------
//constructors with different signatures
    public Julia(){
        setGUIprop();
        addPanel();
        setC(-0.4,0.6);
        updateFractal();
        this.setVisible(true);

    }
    public Julia(double c_r, double c_i){
        setGUIprop();
        addPanel();
        setC(c_r, c_i);
        updateFractal();
        this.setVisible(true);

    }
    public Julia(double c_r, double c_i, int n){
        setGUIprop();
        addPanel();
        setC(c_r, c_i);
        setIterations(n);
        updateFractal();
        this.setVisible(true);
    }

// -------------------------------------------------------------------

    // for c complex number
    private void setC(double r, double i){
        this.c_r = r;
        this.c_i = i;
    }

    // Set iterations
    private static void setIterations(int n){
        MAX_N = n;
    }

// -------------------------------------------------------------------

	public void updateFractal() {
		
		for (int x = 0; x < WIDTH; x++ ) {
			for (int y = 0; y < HEIGHT; y++ ) {
				
				double z_r = getX(x);
				double z_i = getY(y);
				
				int iterCount = computeIterations(z_r, z_i);
				
				int pixelColor = makeColor(iterCount);
				fractalImage.setRGB(x, y, pixelColor);
				
			}
		}
		
		panel.repaint();
		
    }
    
// -------------------------------------------------------------------	coloring method
	private int makeColor( int iterCount ) {
        
        int color = 0b010001000010101000111000; 
		int mask  = 0b000000000001000100010111;
        int shiftMag = iterCount / 15;

		if (iterCount == MAX_N) 
			return Color.BLACK.getRGB();
		
		
        
        return color | (mask << shiftMag);
	} 

// -------------------------------------------------------------------

	private int computeIterations(double z_r, double z_i) {

		
		int iterCount = 0;

		while ( z_r*z_r + z_i*z_i <= 4.0 ) {
			
			double z_r_tmp = z_r;
			
			z_r = z_r*z_r - z_i*z_i + c_r;
			z_i = 2*z_i*z_r_tmp + c_i;
			
			// Point was inside the Mandelbrot set
			if (iterCount >= MAX_N) 
				return MAX_N;
			
			iterCount++;
			
		}
		
		// Complex point was outside Mandelbrot set
		return iterCount;
		
	} // computeIterations
}