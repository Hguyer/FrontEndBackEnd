import javax.swing.*;
import java.awt.*;
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
public class NameWriterView extends JFrame {

    public static final int WINDOW_WIDTH = 600, WINDOW_HEIGHT = 500;
    private String name;

    public NameWriterView(String name) {
       this.name = name;

       this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
       this.setTitle("Name Writer");
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setVisible(true);
   }

   public void setName(String name) {
       this.name = name;
   }

   @Override
   public void paint(Graphics g) {
       g.setColor(Color.WHITE);
       g.fillRect(0,0,WINDOW_WIDTH,WINDOW_HEIGHT);
       g.setColor(Color.BLACK);
       g.drawString(name, WINDOW_WIDTH / 2, WINDOW_HEIGHT / 2);
   }
}
