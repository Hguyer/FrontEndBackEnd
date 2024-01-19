import java.util.Scanner;

/******************************************************************************************
 *
 * Program:	DrawSquares and DrawSquaresView
 * Created for CS2 @ Menlo School by Z. Blickensderfer on 1/19/24
 *
 * Description:
 *  This program prompts the user for a number of squares and a value for thier
 *  side lengths. Then, it draws all of those sqaures (in green!). It continues
 *  to repeat this process until the user chooses to exit the program.
 *
 *****************************************************************************************/

public class DrawSquares {
    private DrawSquaresView window;

    public DrawSquares () {
        this.window = new DrawSquaresView();
    }

    public void run() {
        boolean isPlaying = true;
        do {
            // Get input
            Scanner s = new Scanner(System.in);
            System.out.print("How many sqares should I draw? ");
            int numSquares = s.nextInt();
            s.nextLine();
            System.out.print("How long should their sides be? ");
            int sideLength = s.nextInt();
            s.nextLine();

            // Send values to window
            window.setNumSquares(numSquares);
            window.setSideLength(sideLength);
            window.repaint();

            // Prompt for again?
            System.out.print("Would you like to play again? ");
            String response = s.nextLine();
            isPlaying = response.equalsIgnoreCase("yes") || response.equalsIgnoreCase("y");

        } while (isPlaying);
    }

    public static void main(String[] args) {
        DrawSquares e = new DrawSquares();
        e.run();
    }
}
