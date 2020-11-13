/********************************
 * Name: Beau Goldberg
 * Program: Kentucky Derby Simulation
 * Makes movement for the horses
 *******************************
 */
package KENTUCKY__DERBY;

public class Movement {

	int moveDist = 5;

	public void moveHorse(Horse horse)
	{
		horse.setX(horse.getX()+moveDist);
	}
	
	public void moveLeft(Horse horse)
	{
		horse.setX(horse.getX()-moveDist);
	}
	public void moveRight(Horse horse)
	{
		horse.setX(horse.getX()+moveDist);
	}
	public void moveUp(Horse horse)
	{
		horse.setY(horse.getY()-moveDist);
	}
	public void moveDown(Horse horse)
	{
		horse.setY(horse.getY()+moveDist);
	}
}
