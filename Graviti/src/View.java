
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * 
 */

/**
 * GUI Component of the Simulator
 * 
 * @author dagosttv. Created Nov 15, 2013.
 */
public class View extends JPanel {
	private int X;
	private int Y;

	/**
	 * Creates a JPanel to be displayed
	 *
	 */
	public View() {
		this.setBackground(Color.BLACK);
		this.Y = (int) this.getSize().getHeight();
		this.X = (int) this.getSize().getWidth();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		

	}
	public void dataSet(ArrayList)

}