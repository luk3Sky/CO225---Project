import java.util.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import javax.swing.*;

public class Julia extends JFrame{    //inherit JFrame
    /*
    global variables for frame size
    */
    static final int WIDTH=800;
    static final int HEIGHT=800;

    //may change 
    static final int MAX_N=1000;    //maximum no. of iterations

public class Julia extends Fractal{
    //panel
    Panel panel;
    BufferedImage fractalImage;
    /*
    constructor
    */
    public Julia(){
        setGUIprop();
        addPanel();
        updateFractal();
		    this.setVisible(true);
    }


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

    double c_r = -0.8;
    double c_i = +0.156;
    //---------------------------------------------------
    /*
    Main Window
    */
    public void setGUIprop(){
    
    public Julia(){
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

//------------------------



    private void updateFractal() {
            
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

// -------------------------------------------------------------------
    public static void main(String[] args) {
        new Julia();  //creating a new instance of Fractal
    }




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

