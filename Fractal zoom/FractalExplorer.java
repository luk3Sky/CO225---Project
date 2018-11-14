/*
 * Fractal explorer 
 * CO225 - Programming construction
 * Project
 * E/15/142 - Jayalath A.H.G.D. 
 */

import java.awt.*; /* java abstract window toolkit */
import java.awt.event.*; 
import java.awt.image.*;
import javax.swing.*;
import java.awt.geom.Line2D;
import java.util.Random;


public class FractalExplorer extends JFrame{
    
    // Private instantaneous varaibles.
    private final int WIDTH = 800;
    private final int HEIGHT = 800;    

	Canvas canvas;
	BufferedImage fractalImage;
	
	// static final int MAX_ITER = 200;

	public FractalExplorer() {
		setInitialGUIProperties();
		addCanvas();
		// canvas.addKeyStrokeEvents();
		// updateFractal();
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

    private class Canvas extends JPanel {
		
		// public Canvas() {
		// 	addMouseListener(this);
		// } 
		
		@Override public Dimension getPreferredSize() {
			return new Dimension(WIDTH, HEIGHT);
		} // getPreferredSize
		
		@Override public void paintComponent(Graphics drawingObj) {
			drawingObj.drawImage( fractalImage, 0, 0, null );
		} // paintComponent
		
		// @Override public void mousePressed(MouseEvent mouse) {
			
		// 	double x = (double) mouse.getX();
		// 	double y = (double) mouse.getY();
			
		// 	switch( mouse.getButton() ) {
				
		// 		// Left
		// 		case MouseEvent.BUTTON1:
		// 			adjustZoom( x, y, zoomFactor*2 );
		// 			break;
				
		// 		// Right
		// 		case MouseEvent.BUTTON3:
		// 			adjustZoom( x, y, zoomFactor/2 );
		// 			break;
				
		// 	}
			
		// } // mousePressed
		
		// public void addKeyStrokeEvents() {
			
		// 	KeyStroke wKey = KeyStroke.getKeyStroke(KeyEvent.VK_W, 0 );
		// 	KeyStroke aKey = KeyStroke.getKeyStroke(KeyEvent.VK_A, 0 );
		// 	KeyStroke sKey = KeyStroke.getKeyStroke(KeyEvent.VK_S, 0 );
		// 	KeyStroke dKey = KeyStroke.getKeyStroke(KeyEvent.VK_D, 0 );
			
		// 	Action wPressed = new AbstractAction() {
		// 		@Override public void actionPerformed(ActionEvent e) {
		// 			moveUp();
		// 		}
		// 	};
			
		// 	Action aPressed = new AbstractAction() {
		// 		@Override public void actionPerformed(ActionEvent e) {
		// 			moveLeft();
		// 		}
		// 	};
			
		// 	Action sPressed = new AbstractAction() {
		// 		@Override public void actionPerformed(ActionEvent e) {
		// 			moveDown();
		// 		}
		// 	};
			
		// 	Action dPressed = new AbstractAction() {
		// 		@Override public void actionPerformed(ActionEvent e) {
		// 			moveRight();
		// 		}
		// 	}; 
			
		// 	this.getInputMap().put( wKey, "w_key" );
		// 	this.getInputMap().put( aKey, "a_key" );
		// 	this.getInputMap().put( sKey, "s_key" );
		// 	this.getInputMap().put( dKey, "d_key" );
			
		// 	this.getActionMap().put( "w_key", wPressed );
		// 	this.getActionMap().put( "a_key", aPressed );
		// 	this.getActionMap().put( "s_key", sPressed );
		// 	this.getActionMap().put( "d_key", dPressed );
			
		// } // addKeyStrokeEvents
		
		// @Override public void mouseReleased(MouseEvent mouse){ }
		// @Override public void mouseClicked(MouseEvent mouse) { }
		// @Override public void mouseEntered(MouseEvent mouse) { }
		// @Override public void mouseExited (MouseEvent mouse) { }
		
	} // Canvas
}
