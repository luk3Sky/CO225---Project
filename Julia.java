public class Julia extends Fractal{

    static double c_r = 3;
    static double c_i = 4;
    public void updateFractal() {


		for (int x = 0; x < WIDTH; x++ ) {
			for (int y = 0; y < HEIGHT; y++ ) {

                double z_r = getXPos(x);
                double z_i = getYPos(y);
				int iterCount = computeIterations_2(z_r, z_i);
				
				int pixelColor = makeColor(iterCount);
				fractalImage.setRGB(x, y, pixelColor);
				
			}
		}
		
		panel.repaint();
		
    } // updateFractal

    private int computeIterations(double z_r, double z_i) {
            
        /*
        
        Let c = c_r + c_i
        Let z = z_r + z_i
        
        z' = z*z + c
        = (z_r + z_i)(z_r + z_i) + (c_r + c_i)
        = z_r² + 2*z_r*z_i - z_i² + c_r + c_i

            z_r' = z_r² - z_i² + c_r
            z_i' = 2*z_i*z_r + c_i
            
        */

        // double z_r = 0.0;
        // double z_i = 0.0;
        
        int iterCount = 0;

        // Modulus (distance) formula:
        // √(a² + b²) <= 2.0
        // a² + b² <= 4.0
        while ( z_r*z_r + z_i*z_i <= 4.0 ) {
            
            double z_r_tmp = z_r;
            
            z_r = z_r*z_r - z_i*z_i + c_r;
            z_i = 2*z_i*z_r_tmp + c_i;
            // System.out.println("Inside");
            // Point was inside the Mandelbrot set
            if (iterCount >= MAX_N) 
                return MAX_N;
            
            iterCount++;
            
        }
        
        // Complex point was outside Mandelbrot set
        
        // System.out.println("Outside");
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