/********************************
 * Name: Beau Goldberg
 * Program: Kentucky Derby Simulation
 * Frame for the program
 *******************************
 */
package KENTUCKY__DERBY;

import javax.swing.JFrame;

public class Driver {

	 public static void main(String[] args) 
     {
     	JFrame myFrame = new JFrame("KENTUCKY DERBY SIMULATION");
     	myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     	Panel myPanel = new Panel();
     	myFrame.getContentPane().add(myPanel);
     	myFrame.pack();
     	myFrame.setVisible(true);
     	
     }
}
