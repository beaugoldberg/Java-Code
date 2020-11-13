/********************************
 * Name: Beau Goldberg
 * Program: Kentucky Derby Simulation
 * creates the horses
 *******************************
 */
package KENTUCKY__DERBY;

public class Player extends Horse{

	String graphic1;
	int x1, y1;
	Panel panel1;
	Movement movement1 = new Movement();
	
	public Player(int x, int y, String Graphic, Panel panel) {
		super(x, y, Graphic, panel);
		this.x1 = x;
		this.y1 =y;
		this.graphic1 = Graphic;
		this.panel1 = panel;
		this.panel1.addKeyListener(this);
		this.panel1.setFocusable(true);
		
	}

}
