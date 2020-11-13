/**************************
 * Names: Beau Goldberg & Kellen Donahue
 * Date: 3/9/2018
 * Function: Holds most of the methods for other classes to inherit. Has all main character attributes and methods
 * ************************
 */
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;


public class Character {
	
	//Attributes
	private int X;
	private int Y;
	private String name, graphic;
	Panel panel;
	
	public Character(int X, int Y, String graphic, Panel panel)
	{
		this.X = X;
		this.Y  = Y;
		this.graphic = graphic;
		this.panel = panel;
	}
	
	//Methods
	public int getX()
	{
		return X;
	}
	
	public int getY()
	{
		return Y;
	}
	
	public void setX(int X)
	{
		this.X = X;
	}
	
	public void setY(int Y)
	{
		this.Y = Y;
	}
	private String Getplayername()
	{
		return name;
	}

	public String getGraphic()
	{
		return graphic;
	}
	public String toString()
	{
		return name + " is instantiated";
	}
	
	//Possibly put KeyListener into Character class to update the screen when a key is pressed
	

}
