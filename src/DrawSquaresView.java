import javax.swing.*;
import java.awt.*;
/******************************************************************************************
 *
 * Program:	Circle, CirclePatters, and CirclePatternsView
 * Created for CS2 @ Menlo School by Z. Blickensderfer on 1/14/23
 *
 * Description:
 *  This program prompts the user for a number of circles three times,
 *  first printing a row of circles alternating in color,
 *  then a diagonal of circles (again, alternating in color),
 *  and, finally, a target made of circles that (you guessed it) alternate in color.
 *
 *****************************************************************************************/
public class DrawSquaresView extends JFrame {

    public static final String TITLE = "DRAW SQUARES"; // Information for the window
    public static final int WINDOW_WIDTH = 600,
            WINDOW_HEIGHT = 400,
            FIRST_X = 30,
            FIRST_Y = 30;

    public static final double OFFSET = 1.1;    // This controls how far apart the squares are

    private int numSquares;
    private int sideLength;

    // Initialize all instance variables. Set NumSquares to 0 initially.
    public DrawSquaresView() {
        this.numSquares = 0;
        this.sideLength = 0;

        this.setTitle(TITLE);
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void setNumSquares(int numSquares) {
        this.numSquares = numSquares;
    }

    public void setSideLength(int sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public void paint(Graphics g) {
        // Clear the screen
        g.setColor(Color.WHITE);
        g.fillRect(0,0, WINDOW_WIDTH, WINDOW_HEIGHT);

        // Prepare to draw squares
        int x = FIRST_X;
        int y = FIRST_Y;
        g.setColor(Color.GREEN);

        // For each square, draw it, then adjust the x value for the next square.
        for (int i = 0; i < numSquares; i++)
        {
            g.fillRect(x, y, sideLength, sideLength);
            x += (int) (sideLength * OFFSET);
        }
    }
}
