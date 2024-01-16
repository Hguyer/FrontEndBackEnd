import java.util.Scanner;

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
