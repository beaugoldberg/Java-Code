/********************************
 * Name: Beau Goldberg
 * Program: Kentucky Derby Simulation
 * Runnung of the program
 *******************************
 */
package KENTUCKY__DERBY;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

import javafx.scene.layout.Border;

public class Panel extends JPanel {
	
	long userTime, Horse1Time, Horse2Time, starttime, endtime, H1racetime, H2racetime, userracetime;
	int num, num1;
	String horseName, ownerEmail, horseNumber;
	JPanel startscreen, namescreen, numberscreen, emailscreen, racescreen, endscreen;
	JLabel nameslabel, numberlabel, emaillabel, endlabel;
	JTextField nameField, numberField, emailField;
	JButton startbutton;
	Game game = new Game(this);
	ImageIcon userIcon = new ImageIcon(game.userhorse.getGraphic());
	ImageIcon H1icon = new ImageIcon(game.horse1.getGraphic());
	ImageIcon H2Icon = new ImageIcon(game.horse2.getGraphic());
	ImageIcon UserHorseIcon = new ImageIcon(userIcon.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH));
	ImageIcon HorseIcon1 = new ImageIcon(H1icon.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH));
	ImageIcon HorseIcon2 = new ImageIcon(H2Icon.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH));
	Timer myTimer = new Timer(80, new timerListener());
	Timer userTimer = new Timer(80, new timerListener2());
	Timer H1Timer = new Timer(80, new timerListener2());
	Timer H2Timer = new Timer(80, new timerListener2());;
	

	
	public Panel()
	{
		startscreen = new JPanel();
		startscreen.setLayout(new BorderLayout());
		setPreferredSize(new Dimension(900, 800));
		namescreen = new JPanel();
		nameField = new JTextField();
		nameField.setPreferredSize(new Dimension(100,25));
		nameslabel = new JLabel("Please enter the horses name: ");
		namescreen.add(nameField);
		namescreen.add(nameslabel);
		startscreen.add(namescreen, BorderLayout.NORTH);
		numberscreen = new JPanel();
		numberField = new JTextField();
		numberField.setPreferredSize(new Dimension(100,25));
		numberlabel = new JLabel("Please enter the horses race number: ");
		numberscreen.add(numberField);
		numberscreen.add(numberlabel);
		startscreen.add(numberscreen, BorderLayout.CENTER);
		emailscreen = new JPanel();
		emailField = new JTextField();
		emailField.setPreferredSize(new Dimension(100,25));
		emaillabel = new JLabel("Please enter the owners email: ");
		emailscreen.add(emailField);
		emailscreen.add(emaillabel);
		startbutton = new JButton("Start");
		startbutton.addActionListener(new buttonhandler());
		startscreen.add(emailscreen, BorderLayout.SOUTH);
		startscreen.add(startbutton, BorderLayout.EAST);
		starttime = System.currentTimeMillis();
		add(startscreen);
		
	}
	
	private class buttonhandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			horseName = nameField.getText();
			horseNumber = numberField.getText();
			ownerEmail = emailField.getText();
			Pattern names = null;
			names = Pattern.compile("[A-Z]{1,20}");
			Matcher namematcher = names.matcher(horseName.toUpperCase());
			if (!namematcher.matches())
			{
				System.out.println("Please enter a valid name: \n");
				horseName = nameField.getText();
				namematcher = names.matcher(horseName.toUpperCase());
			}
			Pattern number = null;
			number = Pattern.compile("[0-9]{1,20}");
			Matcher numbermatcher = number.matcher(horseNumber.toUpperCase());
			if (!numbermatcher.matches())
			{
				System.out.println("Please enter a valid number 1-20: \n");
				horseNumber = numberField.getText();
				numbermatcher = number.matcher(horseNumber.toUpperCase());
			}
			Pattern email = null;
			email = Pattern.compile("[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}");
			Matcher emailmatcher = email.matcher(ownerEmail.toUpperCase());
			if (!emailmatcher.matches())
			{
				System.out.println("Please enter a valid email: \n");
				ownerEmail = emailField.getText();
				emailmatcher = email.matcher(ownerEmail.toUpperCase());
			}
			if (namematcher.matches() && numbermatcher.matches() && emailmatcher.matches())
			{
			remove(startscreen);
			myTimer.start();
			H1Timer.start();
			H2Timer.start();
			userTimer.start();
			validate();
			repaint();
			}
			else
			{
				validate();
				repaint();
			}
		}
	}

	public void paintComponent(Graphics page)
	{
		super.paintComponent(page);
		page.drawImage(UserHorseIcon.getImage(), game.userhorse.getX(), game.userhorse.getY(), null);
		page.drawImage(HorseIcon1.getImage(), game.horse1.getX(), game.horse1.getY(), null);
		page.drawImage(HorseIcon2.getImage(), game.horse2.getX(), game.horse2.getY(), null);
	}
	private class timerListener2 implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			if (game.horse1.getX() >= 750)// || game.horse2.getX() >= 750 || game.userhorse.getX() >= 750)
			{
				H1Timer.stop();
			}
			if (game.horse2.getX() >= 750)
			{
				H2Timer.stop();
			}
			if (game.userhorse.getX() >= 750)
			{
				userTimer.stop();
				userTime = System.currentTimeMillis();
			}
		}
	}
	
	private class timerListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			//Randomly moes horse 1
			Random random = new Random();
			boolean done = false;
			if (done == false)
			{
			num = random.nextInt(3);
			if (num==0)
			{
			game.horse1.movement.moveHorse(game.horse1);
			}
			else if (num==1)
			{
				game.horse1.movement.moveDist = 7;
				game.horse1.movement.moveHorse(game.horse1);
			}
			else if (num==2)
			{
				game.horse1.movement.moveDist = 10;
				game.horse1.movement.moveHorse(game.horse1);
			}
			}
			//Randomly moves horse2
			boolean done2 = false;
			if (done2 == false)
			{
			num1 = random.nextInt(3);
			if (num1==0)
			{
			game.horse2.movement.moveHorse(game.horse2);
			}
			else if (num1==1)
			{
				game.horse2.movement.moveDist = 7;
				game.horse2.movement.moveHorse(game.horse2);
			}
			else if (num1==2)
			{
				game.horse2.movement.moveDist = 10;
				game.horse2.movement.moveHorse(game.horse2);
			}
			}
			if (game.horse1.getX() >= 750)// || game.horse2.getX() >= 750 || game.userhorse.getX() >= 750)
			{
				Horse1Time = System.currentTimeMillis();
				done = true;
				num=200;
			}
			if (game.horse2.getX() >= 750)
			{
				Horse2Time = System.currentTimeMillis();
				done2 = true;
				num1=200;
			}
			if (game.userhorse.getX() >= 750)
			{
				setEnabled(false);
			}
			if (done && done2)
			{
				setEnabled(false);
				myTimer.stop();
				endtime = System.currentTimeMillis();
				userracetime = userTime - starttime;
				H1racetime = Horse1Time - starttime;
				H2racetime = Horse2Time - starttime;
				if (Math.abs(userracetime) < H1racetime && userracetime/1000 < 20)
				{
					remove(startscreen);
					JLabel winner = new JLabel("<html><body>Congrats!! You won!! " + "<br>" + "Your Horse Info: " + "<br>" + 
												"Horse Name: " + horseName + "<br>" + "Horse Number: " + horseNumber + "<br>"
												+ "Race Time: " + (userracetime/1000)+" seconds" + "<br>" + "Owner Email: " + ownerEmail);
					endscreen = new JPanel();
					endscreen.add(winner);
					add(endscreen);
				}
				else if (userracetime < H1racetime && game.horse1.getX() > game.horse2.getX())
				{
					remove(startscreen);
					JLabel winner = new JLabel("<html><body>You Lost!" + "<br>" + "Horse 2 won!!");
					endscreen = new JPanel();
					endscreen.add(winner);
					add(endscreen);
				}
				else if (userracetime < H1racetime && game.horse2.getX() > game.horse1.getX())
				{
					remove(startscreen);
					JLabel winner = new JLabel("<html><body>You Lost!" + "<br>" + "Horse 3 won!!");
					endscreen = new JPanel();
					endscreen.add(winner);
					add(endscreen);
				}
			}
			validate(); 
			repaint();
		}
	}
	
}
