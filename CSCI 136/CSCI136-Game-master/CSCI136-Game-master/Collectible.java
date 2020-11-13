/**************************
 * Names: Beau Goldberg & Kellen Donahue
 * Date: 3/9/2018
 * Function: Creates an Collectible
 * ************************
 */

public class Collectible extends Character {
	
	int X,Y;
	String graphic;
	Panel panel;
	public Collectible(int X, int Y, String graphic, Panel panel) {
		super(X, Y, graphic, panel);
		this.X = X;
		this.Y = Y;
		this.graphic = graphic;
		this.panel = panel;
	}
}
