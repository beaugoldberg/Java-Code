/********************************
 * Name: Beau Goldberg
 * Program: Kentucky Derby Simulation
 * Instantiates the horses
 *******************************
 */
package KENTUCKY__DERBY;

import javax.swing.JPanel;

public class Game {

	Horse userhorse, horse1, horse2;
	Panel panel;
	
	public Game(Panel panel)
	{
		this.panel = panel;
		userhorse = new Player(200,200,"./src/KENTUCKY__DERBY/horse.jpg", panel); 
		horse1 = new Horse(200,400,"./src/KENTUCKY__DERBY/horse2.png", panel);
		horse2 = new Horse(200,600,"./src/KENTUCKY__DERBY/horse3.jpg", panel);
	}
}
