/********************************
 * Name: Beau Goldberg
 * Program: Kentucky Derby Simulation
 * sets up the key listener makes horses a player type, contains methods
 *******************************
 */
package KENTUCKY__DERBY;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Horse implements KeyListener {
	
	String graphic;
	int x, y;
	Panel panel;
	Movement movement = new Movement();
	
	public Horse (int x, int y, String Graphic, Panel panel)
	{
		this.x = x;
		this.y =y;
		this.graphic = Graphic;
		this.panel = panel;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public void setX(int X)
	{
		this.x = X;
	}
	
	public void setY(int Y)
	{
		this.y = Y;
	}
	
	public String getGraphic()
	{
		return graphic;
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		if(arg0.getKeyCode() == KeyEvent.VK_LEFT)
		{
			movement.moveLeft(this);
		}
		
		else if(arg0.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			movement.moveRight(this);
		}
		
		else if(arg0.getKeyCode() == KeyEvent.VK_UP)
		{
			movement.moveUp(this);
		}
		
		else if(arg0.getKeyCode() == KeyEvent.VK_DOWN)
		{
			movement.moveDown(this);
		}
		panel.repaint();
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
