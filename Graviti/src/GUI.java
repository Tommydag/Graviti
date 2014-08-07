import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JSlider;

/**
 * @author dagosttv
 * @date 4/20/14
 * @version 0.2 Purpose: View the interactions of the bodies. Not Functional.
 */

public class GUI {

	/**
	 * Simple Display
	 * 
	 */
	public GUI() {
		JFrame frame = new JFrame();
		frame.setName("Graviti");
		frame.setIconImage((new ImageIcon("res/")).getImage());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JFrame.setDefaultLookAndFeelDecorated(true);
		frame.setResizable(true);
		frame.setLayout(new BorderLayout());

		// Adjusts starting resolution in accordance with screen aspect ratio
		// and resolution
		Dimension full_screen_size = Toolkit.getDefaultToolkit()
				.getScreenSize();
		if (full_screen_size.width % 16 == 0) {
			if (full_screen_size.height % 9 == 0) {
				frame.setSize(16 * 100, 9 * 100);
			} else {
				frame.setSize(16 * 100, 10 * 100);
			}
		} else {
			frame.setSize(4 * 150, 3 * 150);
		}

		GUI.addJMenuBar(frame);
		GUI.addJSlider(frame);

		View panel = new View();
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

	private static void addJMenuBar(JFrame f1) {
		JMenuBar jmb = new JMenuBar();
		JMenu file = new JMenu("File");
		JMenu edit = new JMenu("Edit");
		JMenu help = new JMenu("Help");
		jmb.add(file);
		jmb.add(edit);
		jmb.add(help);

		f1.setJMenuBar(jmb);
	}
	
	private static void addJSlider(JFrame f1){
		JSlider timeSlider = new JSlider(0,100,50);
		timeSlider.setPaintLabels(true);
		timeSlider.setPaintTicks(true);
		timeSlider.setMajorTickSpacing(10);
		timeSlider.setBackground(Color.darkGray);
		timeSlider.setForeground(Color.WHITE);
		f1.add(timeSlider,BorderLayout.SOUTH);
	}

}
