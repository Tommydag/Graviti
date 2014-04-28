
import javax.swing.JFrame;

public class GUI {

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
