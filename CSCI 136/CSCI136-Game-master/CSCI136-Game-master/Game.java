/**************************
 * Names: Beau Goldberg & Kellen Donahue
 * Date: 3/9/2018
 * Function: Run the game
 * ************************
 */

public class Game {
	Player player;
	Enemy enemy;
	Collectible collectible;
	//Will use PLayer, Enemy, Collectible and Score
	public Game(Panel panel)
	{
		
		player = new Player(200, 200, "./src/dog.jpg", panel);
		enemy = new Enemy(400, 400, "./src/dog.jpg", panel);
		collectible = new Collectible(600, 600, "./src/dog.jpg", panel);
		
	}
	
	public Player getPlayer()
	{
		return player;
	}
	
	public Enemy getEnemy()
	{
		return enemy;
	}

	public Collectible getCollectible()
	{
		return collectible;
	}
}
