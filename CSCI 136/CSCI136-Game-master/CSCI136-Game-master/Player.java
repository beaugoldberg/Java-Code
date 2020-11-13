import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**************************
 * Names: Beau Goldberg & Kellen Donahue
 * Date: 3/9/2018
 * Function: Creates an Player
 * ************************
 */

public class Player extends Character implements KeyListener {

	int X,Y;
	String graphic;
	Panel panel;
	public Player(int X, int Y, String graphic, Panel panel) {
		super(X, Y, graphic, panel);
		this.X = X;
		this.Y = Y;
		this.graphic = graphic;
		this.panel = panel;
		this.panel.addKeyListener(this);
		this.panel.setFocusable(true);
		
	}


	
	

	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getKeyCode() == KeyEvent.VK_LEFT)
		{
			setX(getX()-5);
		}
		
		else if(arg0.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			setX(getX()+5);
		}
		
		else if(arg0.getKeyCode() == KeyEvent.VK_UP)
		{
			setY(getY()-5);
		}
		
		else if(arg0.getKeyCode() == KeyEvent.VK_DOWN)
		{
			setY(getY()+5);
		}
		panel.repaint();
	}





	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}





	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


}
