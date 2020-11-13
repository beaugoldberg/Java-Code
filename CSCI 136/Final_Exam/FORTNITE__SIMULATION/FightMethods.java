/********************************
 * Name: Beau Goldberg
 * Program: Fortnite Simulation
 * All the mehtods that the fighters use, inherited to reduce code in the main program
 *******************************
 */
package FORTNITE__SIMULATION;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class FightMethods {
	
	static ArrayList<Fighter> fighters = new ArrayList<Fighter>();
	static ArrayList attacks = new ArrayList();
	static Architect architect = new Architect(null,0,0,0,null);
	static int battlecount;

	
	public FightMethods()
	{
		
	}
	
	public static void addFighter(Fighter fighter)
	{
		fighters.add(fighter);
	}
	
	public static void addAttack(int attack1D)
	{
		attacks.add(attack1D);
	}
	
	public static void readInFighters()
	{
		File file = new File("./src/FORTNITE__SIMULATION/Fighters.txt");
        Scanner scan = null;
		try {
			scan = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
         while(scan.hasNextLine())
         {
         	String line = scan.nextLine();
         	Scanner scanner = new Scanner(line);
         	scanner.useDelimiter(",");
         	
         	while(scanner.hasNext())
         	{
         		String type = scanner.next();
         		if (type.equals("Architect"))
         		{
         			String fighter = type;
         			int level = scanner.nextInt();
         			int hitpoints = scanner.nextInt();
         			int attack1D = scanner.nextInt();
         			String attack1 = scanner.next();
         			
         			Architect architect = new Architect(fighter, level, hitpoints, attack1D, attack1);
         			addAttack(attack1D);
         			addFighter(architect);
         		}
         		if (type.equals("Siteseer"))
         		{
         			String fighter = type;
         			int level = scanner.nextInt();
         			int hitpoints = scanner.nextInt();
         			int attack1D = scanner.nextInt();
         			String attack1 = scanner.next();
         			
         			Siteseer siteseer = new Siteseer(fighter, level, hitpoints, attack1D, attack1);
         			addAttack(attack1D);
         			addFighter(siteseer);
         		}
         		if (type.equals("Lunatic"))
         		{
         			String fighter = type;
         			int level = scanner.nextInt();
         			int hitpoints = scanner.nextInt();
         			int attack1D = scanner.nextInt();
         			String attack1 = scanner.next();
         			
         			Lunatic lunatic = new Lunatic(fighter, level, hitpoints, attack1D, attack1);
         			addAttack(attack1D);
         			addFighter(lunatic);
         		}
         		if (type.equals("Destroyer"))
         		{
         			String fighter = type;
         			int level = scanner.nextInt();
         			int hitpoints = scanner.nextInt();
         			int attack1D = scanner.nextInt();
         			String attack1 = scanner.next();
         			
         			Destroyer destroyer = new Destroyer(fighter, level, hitpoints, attack1D, attack1);
         			addAttack(attack1D);
         			addFighter(destroyer);
         		}
         		if (type.equals("Competitor"))
         		{
         			String fighter = type;
         			int level = scanner.nextInt();
         			int hitpoints = scanner.nextInt();
         			int attack1D = scanner.nextInt();
         			String attack1 = scanner.next();
         			
         			Competitor competitor = new Competitor(fighter, level, hitpoints, attack1D, attack1);
         			addAttack(attack1D);
         			addFighter(competitor);
         		}   	
         		battlecount =1;
         	}  
         }  
	}//End of this method
	
	public static void Battle(Fighter fighter1, Fighter fighter2)
	{
		System.out.println("\nBattle " + battlecount);
		System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _");
		System.out.println("Before Battle");
		System.out.println(fighter1);
		System.out.println(fighter2);
		System.out.println("________________________");
		fighter1.Fight(fighter1, fighter2);
		fighter2.Fight(fighter2, fighter1);
		System.out.println("After Battle:");
		System.out.println(fighter1);
		System.out.println();
		System.out.println(fighter2);
		System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ ");
		battlecount++;
		if (fighter1.getHealth(fighter1) <= 0)// && fighter1.getHealth(fighter1) < fighter2.getHealth(fighter2))
		{
			fighters.remove(fighter1);
		}
		else if (fighter2.getHealth(fighter2) <= 0)// && fighter2.getHealth(fighter2) < fighter1.getHealth(fighter1) )
		{
			fighters.remove(fighter2);
		}
		else if (fighter2.getHealth(fighter2) <= 0 && fighter1.getHealth(fighter1) <= 0)
		{
			fighters.remove(fighter1);
			fighters.remove(fighter2);
		}
		else
		{
			Battle(fighter1, fighter2);
		}
	}
	
	public static void StartBattleRoyale()
	{
		if (fighters.size() == 1)
		{
			System.out.println("\nThe Winner is:" + "\n" + fighters.get(0));
		}
		else 
		{
			Random random = new Random();
			int fighter1 = random.nextInt(fighters.size());
			int fighter2 = random.nextInt(fighters.size());
			while (fighter2 == fighter1)
			{
				fighter2 = random.nextInt(fighters.size());
			}
			Battle(fighters.get(fighter1), fighters.get(fighter2));
			StartBattleRoyale();
		}
	}

}
