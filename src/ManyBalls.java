import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

/*********************************************************************************
 *
 * ManyBalls
 *
 * NEW STUFF: Ball class
 * 		   Use an actual timer to control the motion!
 *
 * This code moves only one ball. It moves around the screen,
 * bouncing off the walls. This version demonstrates an elegant solution to the
 * problem of timing the moving ball.
 *
 * YOUR JOB: 1) Make sure that you can run this program!
 *           2) Modify the program by creating an array of 100 Balls, each of which
 * 				is created with a random color, size, position and velocity and
 * 				each of which moves and considers bouncing at each clock tick.
 *
 *              Be sure each ball starts entirely visible on the window, is equally
 *              likely to be anywhere on the window, and starts with velocity
 *              components that are equally likely to be positive or negative.
*
 ***********************************************************************************/
public class ManyBalls implements ActionListener {
						// This says "I promise to have an actionPerformed() method"
	private Ball[] balls;
	private ManyBallsView window;                   // The front-end.
	private static final int MAX_WIDTH = 600;		// Window size
	private static final int MAX_HEIGHT = 700;		// Window size
	private static final int TOP_OF_WINDOW = 22;	// Top of the visible window

	private static final int DELAY_IN_MILLISEC = 20;  // Time delay between ball updates

	/**
	 * main -- Start up the window.
	 * @param	args
	 */
	public static void main(String args[]) {
		// Create the back-end:
		ManyBalls mb = new ManyBalls();
	}

	/**
	 * Constructor for ManyBallsWithTimer class.
	 * Creates one Ball object, starts up the window and starts the timer.
	 */
	public ManyBalls() {

		// Initialize the Ball.
		balls = new Ball[100];

		for (int i = 0; i < 100; i++) {
			int radius = (int) (Math.random() * 70) + 1;
			int x = (int) (Math.random() * (MAX_WIDTH - radius)) + radius;
			int y = (int) (Math.random() * (MAX_HEIGHT - radius)) + radius;
			int dx = (int) (Math.random() * 11) - 5;
			int dy = (int) (Math.random() * 11) - 5;
			Color color = new Color((int)(Math.random() * 256), (int)(Math.random() * 256), (int)(Math.random() * 256));
			balls[i] = new Ball(x, y, dx, dy, radius, color);
		}



		// Create the front-end:
		// Version ONE: our basic view. Notice how the animation is a little jerky?
		//this.window = new ManyBallsView(MAX_WIDTH, MAX_HEIGHT, balls);

		// Version TWO: using inheritance, let's make a double-buffered version of ManyBallsView.
		this.window = new ManyBallsViewDoubleBuffered(MAX_WIDTH, MAX_HEIGHT, balls);

		// Toolkit.getDefaultToolkit().sync();  // Consider this to reduce flicker

		// Sets up a timer but does not start it.  Once started, the timer will go
		//  off every DELAY_IN_MILLISEC milliseconds.  When it goes off all it does
		//  is call this.actionPerformed().  It then goes back to sleep for another
		//  DELAY_IN_MILLISEC.
		Timer clock = new Timer(DELAY_IN_MILLISEC, this);

		// Now actually start the timer.
		clock.start();
	}

	/**
	 * actionPerformed() is called automatically by the timer every time the requested
	 * delay has elapsed.  It will keep being called until the clock is stopped or the
	 * program ends.  All actions that we want to happen then should be performed here.
	 * Any class that implements ActionListener MUST have this method.
	 *
	 * In this example it is called to move the ball every DELAY_IN_MILLISEC.
	 *
	 * @param e		Contains info about the event that caused this method to be called
	 */
	public void actionPerformed(ActionEvent e) {		// NEW #5 !!!!!!!!!!

		// Move the ball.
		for (Ball ball : balls) {
			ball.move();
			ball.bounce(0, MAX_WIDTH, TOP_OF_WINDOW, MAX_HEIGHT);
		}
		window.repaint();
	}
}


