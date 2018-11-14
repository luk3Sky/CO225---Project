/*
 * Fractal explorer 
 * CO225 - Programming construction
 * Project
 * E/15/142 - Jayalath A.H.G.D. 
 */

import java.awt.*; /* java abstract window toolkit */
import java.awt.event.*; 
import javax.swing.*;
import java.awt.geom.Line2D;
import java.util.Random;


public class FractalExplorer extends JFrame{
    
    // Private instantaneous varaibles.
    private final int WIDTH = 600;
    private final int HEIGHT = 600;    

	Canvas canvas;
	BufferedImage fractalImage;
	
	static final int MAX_ITER = 200;

	public FractalExplorer() {
		setInitialGUIProperties();
		addCanvas();
		canvas.addKeyStrokeEvents();
		updateFractal();
		this.setVisible(true);
	}

	private void addCanvas() {

		canvas = new Canvas();
		fractalImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		canvas.setVisible(true);
		this.add(canvas, BorderLayout.CENTER);

	} // addCanvas

    private void setInitialGUIProperties() {
			
        this.setTitle("Fractal Explorer");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WIDTH, HEIGHT);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
    } // setInitialGUIProperties

    @Override public Dimension getPreferredSize() {
        return new Dimension(WIDTH, HEIGHT);
    } // getPreferredSize

    public static void main(String[] args) {
        new FractalExplorer();
    }
}
