/********************************
 * Name: Beau Goldberg
 * Program: Fortnite Simulation
 * Runs the code
 *******************************
 */
package FORTNITE__SIMULATION;

import java.util.ArrayList;

public class Game extends FightMethods {
	
	static FightMethods fight = new FightMethods();
	
	public static void main(String[] args) {
		fight.readInFighters();
		fight.StartBattleRoyale();
	}

}
