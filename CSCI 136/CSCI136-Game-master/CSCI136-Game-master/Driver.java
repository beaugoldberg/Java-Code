import javax.swing.JFrame;

/**************************
 * Names: Beau Goldberg & Kellen Donahue
 * Date: 3/9/2018
 * Function: The frame for the program
 * ************************
 */

public class Driver {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Panel");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			
		
		frame.getContentPane().add(new Panel());
		
		frame.pack();
		frame.setVisible(true);
		
		

	}

}
