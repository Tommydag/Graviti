
import javax.swing.JFrame;

/**
 * @author dagosttv
 * @date 4/20/14
 * @version 0.1
 * Purpose: View the interactions of the bodies. Not Functional.
 */

public class GUI {

	/**
	 *Simple Display
	 *
	 */
	public GUI() {
		JFrame frame = new JFrame();
		View panel = new View();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JFrame.setDefaultLookAndFeelDecorated(true);
		frame.setResizable(true);
		frame.setSize(1792, 1008);
		frame.add(panel);
		frame.setVisible(true);
		while (true) {
			panel.repaint();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
