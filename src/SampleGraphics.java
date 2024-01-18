import java.util.Scanner;

/**
 * Program: SampleGraphics
 * Created for CS2 by Zach Blick in Jan. 2024
 *
 * Description:
 * 	This program demonstrated the Back-End of the Front-End/Back-End paradigm.
 * 	It creates a Front-End by instantiating its partner class, SampleGraphicsView.
 * 	Note that there is one piece of data shared from the Back-End to the Front-End:
 * 	the title of the window. This is an example of data-sharing. Generally, we want
 * 	to share as little data as possible between the two.
 *
 * 	Note that the call to window.repaint() implicitally calls the paint() method in
 * 	SampleGraphicsView. This is how the paint() method can be called without a
 * 	Graphics parameter.
 */
public class SampleGraphics {

	private SampleGraphicsView window;

	public SampleGraphics(String title) {
		window = new SampleGraphicsView(title);
	}

	public void run() {
		window.repaint();
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("What would you like to name the window?");
		String title = s.nextLine();
		SampleGraphics backEnd = new SampleGraphics(title);
		backEnd.run();
	}
}
