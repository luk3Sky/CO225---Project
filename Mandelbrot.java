import java.util.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import javax.swing.*;

public class Mandelbrot extends Fractal{
    //panel
    Panel panel;
    BufferedImage fractalImage;

    public Mandelbrot(){
        this.setGUIprop();
        this.addPanel();
        this.updateFractal();
		this.setVisible(true);
    }

    // -------------------------------------------------------------------
    // return x coordinates
	private double getX(double x) {
		return (x/WIDTH)*(real_p-real_n) + real_n;
	} 

    // return y coordinates
	private double getY(double y) {
		return (y/HEIGHT)*(img_n-img_p) + img_p;
	} 
    // -------------------------------------------------------------------

//------------------------------
   /*
    Main Window
    */
    private void setGUIprop(){
        this.setTitle("Fractals");
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

//------------------------

    private void updateFractal() {
            
        for (int x = 0; x < WIDTH; x++ ) {
            for (int y = 0; y < HEIGHT; y++ ) {
                
                double c_r = getX(x);
                double c_i = getY(y);
                
                int iterCount = this.computeIterations(c_r, c_i);
                
                int pixelColor = makeColor(iterCount);
                fractalImage.setRGB(x, y, pixelColor);
                
            }
        }
        
        panel.repaint();
        
    }

    public int computeIterations(double c_r, double c_i) {

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

    private class Panel extends JPanel{    //inherit JPanel

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