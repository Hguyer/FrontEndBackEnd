import java.awt.*;  //need this for graphics
import javax.swing.*; //need this for graphics
import java.util.Scanner; //need this for user input
/******************************************************************************************
 *
 * Program:	NameWriter & NameWriterView
 * Created for Intro. Prog. by:	Katherine Bellafiore Sanden, 1/2/18
 * Edited for CS2 by: Z. Blickensderfer, 12/30/22
 *
 * Description:
 * This program demonstrates how to facilitate the transfer of information from
 * the back-end to the front-end, utilizing calls to repaint in the back-end to
 * prompt the front-end to update itself.
 *
 *****************************************************************************************/
public class NameWriter {

    private String name;
    private NameWriterView window; // An instance of my front-end.

    public NameWriter() {
        name = "[Enter your name]";
        window = new NameWriterView(name);
    }

    public void run() {
        // Get the name from the user
        System.out.print("Enter your name: ");
        Scanner s = new Scanner(System.in);
        name = s.nextLine();

        // Send the name to the window and repaint the window
        window.setName(name);

        window.repaint();
    }

    public static void main(String[] args) {
        NameWriter n = new NameWriter();
        n.run();
    }

}
