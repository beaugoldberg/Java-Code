/********************************
 * Name: Beau Goldberg
 * Program: Fortnite Simulation
 * Main character class all other charachters inherit from this class
 *******************************
 */
package FORTNITE__SIMULATION;

public abstract class Fighter {
	
	String type, attack1;
	int level, hitpoints, attack1D;
	
	public Fighter(String Type, int level, int hitpoints, int attack1D, String attack1)
	{
		this.type = Type;
		this.level = level;
		this.hitpoints = hitpoints;
		this.attack1D = attack1D;
		this.attack1 = attack1;
	}

	public abstract void Fight(Fighter attacker, Fighter defender);
	
	public int getHealth(Fighter fighter)
	{
		return this.hitpoints;
	}
	
	public boolean CheckIfDead(Fighter attacker, Fighter defender) 
	{
		boolean dead = false;
		defender.setHealth(defender.getHealth(defender) - attacker.getAttack1D());
		if (defender.getHealth(defender) <=0)
		{
			dead = true;
		}
		return dead;
	}
	public void setHealth(int e)
	{
		this.hitpoints = e;
	}
	
	public int getAttack1D()
	{
		return this.attack1D;
	}
	
	public String toString()
	{
		return "Type: " + type + "\n" + "Level: " + level + "\n" + "Hitpoints: " + hitpoints;
	}
}
