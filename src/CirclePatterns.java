import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;
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
public class CirclePatterns {
    private static final int    FIRST_CORNER_X = 30,
                                FIRST_CORNER_Y = 50,
                                DIAMETER = 30,
                                SMALLEST_RADIUS = 10,
                                CHANGE_IN_RADIUS = 30;
    private CirclePatternsView window;

    private ArrayList<Circle> circles;

    public CirclePatterns() {
        circles = new ArrayList<Circle>();
        window = new CirclePatternsView(circles);
    }

    public int getNumCircles() {
        Scanner s = new Scanner(System.in);
        System.out.print("How many circles should I draw? ");
        int n = s.nextInt();
        s.nextLine();
        return n;
    }

    public void makeRow(int numCircles) {
        // TODO: Write makeRow so it adds the row of circles to the ArrayList of circles.
        int currentX = FIRST_CORNER_X;
        int currentY = FIRST_CORNER_Y;
        for (int i = 0; i < numCircles; i++){
            Color color;
            if (i % 2 == 0) {
                color = Color.BLUE;
            } else{
                color = Color.RED;
            }
            circles.add(new Circle(currentX, currentY, DIAMETER, color));
            currentX += DIAMETER;
        }

    }

    public void makeDiagonal(int numCircles) {
        // TODO: Write makeDiagonal so it adds the diagonal of circles to the ArrayList of circles.
        int currentX = FIRST_CORNER_X;
        int currentY = FIRST_CORNER_Y;
        for (int i = 0; i < numCircles; i++) {
            Color color;
            if (i % 2 == 0) {
                color = Color.BLUE;
            } else {
                color = Color.RED;
            }

            circles.add(new Circle(currentX, currentY, DIAMETER, color));
            currentX += DIAMETER;
            currentY += DIAMETER;
        }
    }

    public void makeTarget(int numCircles) {
        // TODO: Write makeTarget so it adds the target of circles to the ArrayList of circles.
        // Key idea: the circles have to start big, then get small.
        // That way, when drawn in order, they appear on top of each other.
            int centerX = 400;
            int centerY = 300;

            int radius = SMALLEST_RADIUS + (numCircles) * CHANGE_IN_RADIUS;
            for (int i = 0; i < numCircles; i++) {
                Color color;
                if (i % 2 == 0) {
                    color = Color.RED;
                } else {
                    color = Color.BLACK;
                }
                circles.add(new Circle(centerX - radius, centerY - radius, radius * 2, color));
                radius -= CHANGE_IN_RADIUS;
            }
    }

    public void run() {
        int numCircles = this.getNumCircles();
        this.makeRow(numCircles);
        window.repaint();

        // Part 2
        numCircles = this.getNumCircles();
        this.makeDiagonal(numCircles);
        window.repaint();

        // Part 3
        numCircles = this.getNumCircles();
        this.makeTarget(numCircles);
        window.repaint();
    }

    public static void main(String[] args) {
        CirclePatterns c = new CirclePatterns();
        c.run();
    }
}
