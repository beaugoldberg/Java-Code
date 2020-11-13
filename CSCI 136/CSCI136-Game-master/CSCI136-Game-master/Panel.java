import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**************************
 * Names: Beau Goldberg & Kellen Donahue
 * Date: 3/9/2018
 * Function: Creates the graphics
 * ************************
 */

public class Panel extends JPanel {
	Game game = new Game(this);
	ImageIcon playerIcon = new ImageIcon(game.getPlayer().getGraphic());
	ImageIcon enemyIcon = new ImageIcon(game.getEnemy().getGraphic());
	public Panel()
	{
		setPreferredSize(new Dimension(800,800));	
	}
	//Methods
	public void paintComponent(Graphics page)
	{
		super.paintComponent(page);
		page.drawImage(playerIcon.getImage(),game.getPlayer().getX(), game.getPlayer().getY(), null);
		page.drawImage(enemyIcon.getImage(), game.getEnemy().getX(), game.getEnemy().getY(), null);
	}

	
	public String toString()
	{
		return "Panel is instantiated";
	}
	
	
	


}
