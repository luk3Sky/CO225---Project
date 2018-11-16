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

public class Mandelbrot extends Fractal{

    public double c_r = 3;
    public double c_i = 4;

    public Mandelbrot(){
        setGUIprop();
        addPanel();
        updateFractal();
        this.setVisible(true);

    }
    public Mandelbrot(double real_r, double real_i, int n){
        setGUIprop();
        addPanel();
        setRealRegion(real_r, real_i);
        setIterations(n);
        updateFractal();
        this.setVisible(true);

    }
    public Mandelbrot(double real_r, double real_i, double imag_r, double imag_i, int n){
        setGUIprop();
        addPanel();
        setRealRegion(real_r, real_i);
        setImagRegion(imag_r, imag_i);
        setIterations(n);
        updateFractal();
        this.setVisible(true);
    }


    // for c complex number regions
    private void setRealRegion(double real_r, double real_i){
        this.real_p = real_r;
        this.real_n = real_i;
    }

    private void setImagRegion(double imag_r, double imag_i){
        this.img_n = imag_r;
        this.img_p = imag_i;
    }

    // Set iterations
    private static void setIterations(int n){
        MAX_N = n;
    }

// -------------------------------------------------------------------
    public void updateFractal() {
		
		for (int x = 0; x < WIDTH; x++ ) {
			for (int y = 0; y < HEIGHT; y++ ) {
				
				double c_r = getX(x);
				double c_i = getY(y);
				
				int iterCount = computeIterations(c_r, c_i);
				
				int pixelColor = makeColor(iterCount);
				fractalImage.setRGB(x, y, pixelColor);
				
			}
		}
		
		panel.repaint();
		
    }
    
// -------------------------------------------------------------------	coloring method
	private int makeColor( int iterCount ) {
        
        int color = 0b000101110101011000011100; 
		int mask  = 0b000000000000101100110101;
        int shiftMag = iterCount / 3;

		if (iterCount == MAX_N) 
			return Color.BLACK.getRGB();
		
		
        
        return color | (mask << shiftMag);
	} 

// -------------------------------------------------------------------

	private int computeIterations(double c_r, double c_i) {

		double z_r = 0.0;
		double z_i = 0.0;
		
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


}