package FORTNITE__SIMULATION;

import java.util.Random;

public class Siteseer extends Fighter {

	public Siteseer(String Type, int level, int hitpoints, int attack1d, String attack1) {
		super(Type, level, hitpoints, attack1d, attack1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Fight(Fighter attacker, Fighter defender) 
	{
		defender.setHealth(defender.getHealth(defender) - attacker.getAttack1D());
//		if (defender.getHealth(defender) <=0)
//		{
//			defender.setHealth(0);
//		}
	}
}
