import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GirlScouts {
	
	
	ArrayList customers = new ArrayList();
	String firstname, lastname, cost, numpurchased;
	static String removalpath, removalpath2, updatepath, menu, boi, costupdated, nameupdatepath, nameupdatepath2;
	static int updatepathcost, number, neworder;
	Date date;
	int removeindex;
	List<String> lines;
	
	public GirlScouts(String firstname, String lastname, Date date, String numpurchased, String cost)
	{
		this.firstname = firstname;
		this.lastname = lastname;
		this.date = date;
		this.numpurchased = numpurchased;
		this.cost = cost;
	}
	
	public void addCustomer(String firstname, String lastname, Date date, String numpurchased, String cost)
	{
		GirlScouts person = new GirlScouts(firstname, lastname, date, numpurchased, cost);
		customers.add(person);
	}
	
	public static void removeCustomer(String removename, String removepath2) throws ParseException, IOException {

	   removalpath = removename;
	   removalpath2 = removepath2;
	   File temp = new File("./src/TempFile");
	   File file = new File("./src/Customers");
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
        		String first = scanner.next();
        		String lastnamecheck = scanner.next();
        		while (first.equals(removalpath) && lastnamecheck.equals(" " +removalpath2))
        		{
        			String first1 = first;
                	String last = lastnamecheck;
                 	String date = scanner.next();
                 	String num = scanner.next();
                 	String c = scanner.next();
                 	removalpath = null;
                 	removalpath2 = null;
 
        		}
        		while (scanner.hasNext())
        		{
        		String firstname = first;
            	String lastname = lastnamecheck;
             	String datepath = scanner.next();
             	String numpurchased = scanner.next();
             	String cost = scanner.next();
        		DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS");
        		//Date d = formatter.parse(dpath);
        		
        		FileWriter writer = new FileWriter(temp, true);	
				BufferedWriter write = new BufferedWriter(writer);
				PrintWriter realwrite = new PrintWriter(write);
				
				realwrite.write(firstname + "," + lastname + "," + datepath + "," + numpurchased + "," + cost + "\n");
        		realwrite.close();
        		}
        		
        	}         	
        }
	}
	
	public void endprompt()
	{
		Scanner input = new Scanner(System.in);
		int k=0;
		while (k==0)
		{
		menu= input.next();
		if (menu.equals("Yes"))
		{
			menu = "Enter";
			boi = "hi";
			k=2;
		}
		else if (menu.equals("No"))
		{
			System.out.println("Please return soon!");
			k=23;
		}
		else 
		{
			System.out.println("Please enter 'Yes' to go back to the menu. Or enter 'No' to end the program.");
		}
		}
	}
	
	public void rewriteCustomers() throws ParseException, IOException
	{
		File sourceFile = new File("./src/TempFile");
		/* destination file, where the content to be pasted */
		File destFile = new File("./src/Customers");
	
		InputStream input = null;
		OutputStream output = null;

		try {

			/* FileInputStream to read streams */
			input = new FileInputStream(sourceFile);

			/* FileOutputStream to write streams */
			output = new FileOutputStream(destFile);

			byte[] buf = new byte[1024];
			int bytesRead;

			while ((bytesRead = input.read(buf)) > 0) {
				output.write(buf, 0, bytesRead);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		finally {
			try {

				if (null != input) {
					input.close();
				}
				
				if (null != output) {
					output.close();
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void EraseTempFileContext() throws FileNotFoundException
	{
		File file = new File("./src/TempFile");
		PrintWriter writer = new PrintWriter(file);
		writer.print("");
		writer.close();
	}
	
	public void updateOrder(int updatedpurchase, String nameofupdate, String lastnameupdate) throws IOException
	{
		updatepath = (updatedpurchase + "");
		updatepathcost = updatedpurchase * 8;
		costupdated = " " + updatepathcost + ".0";
		nameupdatepath = nameofupdate;
		nameupdatepath2 = lastnameupdate;
		
		   File temp = new File("./src/TempFile");
		   File file = new File("./src/Customers");
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
	        		String first = scanner.next();
	        		String bleh = scanner.next();
	        		if (first.equals(nameupdatepath) && bleh.equals(" " +nameupdatepath2))
	        		{
	        			String first1 = first;
	                	String last = bleh;
	                 	String date = scanner.next();
	                 	String num = updatepath;
	                 	String c = costupdated;
	                 	nameupdatepath = null;
	                	String bleh1 = scanner.next();
	                	String bleh2 = scanner.next();
	                 	
	                 	
	                 	FileWriter writer = new FileWriter(temp, true);	
						BufferedWriter write = new BufferedWriter(writer);
						PrintWriter realwrite = new PrintWriter(write);
						
						realwrite.write(first1 + "," + last+ "," + date + "," + num + "," + c + "\n");
		        		realwrite.close();
	 
	        		}
	        		else 
	        		{
	        		String firstname = first;
	            	String lastname = bleh;
	             	String datepath = scanner.next();
	             	String numpurchased = scanner.next();
	             	String cost = scanner.next();
	        		DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS");
	        		//Date d = formatter.parse(dpath);
	        		
	        		FileWriter writer = new FileWriter(temp, true);	
					BufferedWriter write = new BufferedWriter(writer);
					PrintWriter realwrite = new PrintWriter(write);
					
					realwrite.write(firstname + "," + lastname + "," + datepath + "," + numpurchased + "," + cost + "\n");
	        		realwrite.close();
	        		}
	        		
	        	}         	
	        }
	}
	
	public void addCustomersToArray() throws ParseException
	{
		File file = new File("./src/Customers");
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
         		String firstname = scanner.next();
         		String lastname = scanner.next();
         		String datepath = scanner.next();
         		String numpurchased = scanner.next();
         		String cost = scanner.next();
         		DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS");
         		Date date = formatter.parse(datepath);
         		
         		GirlScouts customer = new GirlScouts(null, null, null, null ,null);
         		customer.addCustomer(firstname, lastname, date, numpurchased, cost);
         		
         	       		
         	}         	
         }
	}
	
	public void displayCustomers() throws ParseException
	{
		File file = new File("./src/Customers");
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
         		String firstname = scanner.next();
         		String lastname = scanner.next();
         		String datepath = scanner.next();
         		String numpurchased = scanner.next();
         		String cost = scanner.next();
         		DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS");
         		Date date = formatter.parse(datepath);
         		
         		GirlScouts customer = new GirlScouts(null, null, null, null ,null);
         		customer.addCustomer(firstname, lastname, date, numpurchased, cost);
         		
         		int i;
         		for(i=0; i< customer.customers.size(); i++)
         		{
         			System.out.println(customer.customers.get(i));
         		}         		
         	}         	
         }
	}
	
	
	public String toString()
	{
		return "\n" + "Name: " + firstname + "" + lastname + "\n" + "Date Purchased: " + date + "\n" +
				"Amount Purchased: " + numpurchased + "\n" + "Total Cost: $" + cost;
	}
	
	public static void main(String[] args) throws ParseException, IOException {
		
				GirlScouts person = new GirlScouts(null, null, null, null, null);
				Scanner input = new Scanner(System.in);
				System.out.println("Enter 'Enter' To Begin the Program");
				int t=0;
				//Uses a while loop to loop endlessly until the user enters enter to start the program
				while (t==0)
				{
				if (input.next().equals("Enter"))
				{
					menu = "Enter";
					t = 2;
				}
				else
				{
					System.out.println("Please enter 'Enter' to begin the program.");
				}
				}
				while (menu.equals("Enter") || boi.equals("hi"))
				{
				System.out.println("\nWelcome to the Girl Scouts Directory: ");
				System.out.println("To display customer information enter 'D'");
				System.out.println("To add a customer enter 'A'");
				System.out.println("To remove a customer enter 'R'");
				System.out.println("To update an order enter 'U");
				System.out.println("Enter 'End' to end program");
				boi = input.next();
				if (boi.equals("D"))
				{
					person.displayCustomers();
					System.out.println("\nWould you like to go back to the main menu? Enter 'Yes' to do so. Enter 'No' to end the program.");
					person.endprompt();
				}
				else if (boi.equals("A"))
				{
					//Uses a pattern taking in only letters in order to restrict input to a string 
					System.out.println("Enter Customers First Name: ");
					String fname = input.next();
					Pattern names = null;
					names = Pattern.compile("[A-Z]{1,20}");
					Matcher namematcher = names.matcher(fname.toUpperCase());
					while (!namematcher.matches())
					{
						System.out.println("Please Enter the Customers Name: ");
						fname = input.next();
						namematcher = names.matcher(fname.toUpperCase());
					}
					//Uses a pattern taking in only letters in order to restrict input to a string 
					System.out.println("Enter Customers Last Name: ");
					String lname = input.next();
					Matcher namematcher2 = names.matcher(lname.toUpperCase());
					while (!namematcher2.matches())
					{
						System.out.println("Please Enter the Customers Last Name: ");
						lname = input.next();
						namematcher2 = names.matcher(lname.toUpperCase());
					}
					//Uses a pattern matcher to ensure the string is entered as in the following format to avoid a parse error
					System.out.println("Enter date of purchase in the following format: DD-MM-YYYY ");
					String inputdate = input.next();
					Pattern myPattern = null;
					myPattern = Pattern.compile("[0-9]{2}+-[0-9]{2}+-[0-9]{4}");
					Matcher mymatcher = myPattern.matcher(inputdate.toUpperCase());
					while (!mymatcher.matches())
					{
						System.out.println("Date is invalid");
						System.out.println("Enter date of purchase in the following format: DD-MM-YYYY ");
						inputdate = input.next();
						mymatcher = myPattern.matcher(inputdate.toUpperCase());
					}
					//Uses a pattern and a for loop to continuesly ask the user for input until they match the time pattern presented
					System.out.println("Enter time of purchase in the following format: HH:MM:SS.SSS");
					System.out.println("No need to be super specific on the time!");
					System.out.println("You can enter 'skip' if you would like to skip this step!");
					String inputtime = null;
					int s=0;
					int u=1;
					for(s=0;s<u;s++)
					{
					String choice = input.next();
					if (choice.equals("skip"))
					{
						inputtime = "10:45:00.000";
						s=u;
					}
					else
					{
						Pattern timepattern = null;
						timepattern = Pattern.compile("[0-9]{2}+\\:[0-9]{2}+\\:[0-9]{2}+\\.[0-9]{3}");
						Matcher timematcher = timepattern.matcher(choice.toUpperCase());
						if (!timematcher.matches())
						{
							System.out.println("Time is invalid");
							System.out.println("Please enter time of purchase in the following format: HH:MM:SS.SSS");
						}
						if (timematcher.matches())
						{
							inputtime = choice;
							s=u;
						}
						u++;
					}
					}
					DateFormat formatter = new SimpleDateFormat("DD-MM-YYYY HH:MM:SS.SSS");
	         		Date date = formatter.parse(inputdate + " " + inputtime);
	         		//Uses a try catch inside of a while loop to ensure that a number is entered
					System.out.println("Enter number of items purchased: ");
					while (true)
					{
					try
					{
						number = input.nextInt();
						break;
					}
					catch (InputMismatchException ex)
					{
						System.out.println("Please enter a number");
						input.next();
						continue;
					}
					}
					int cost = 8 * number;
					
					FileWriter writer = new FileWriter("./src/Customers", true);	
					BufferedWriter write = new BufferedWriter(writer);
					PrintWriter realwrite = new PrintWriter(write);
					realwrite.write("\n");
					realwrite.write(fname + ", ");
					realwrite.write(lname + ", ");
					realwrite.write(inputdate + " " + inputtime + ",");
					realwrite.write(number +",");
					realwrite.write((double)cost + "");
					realwrite.close();
					
					System.out.println("Would you like to go back to the main menu? Enter 'Yes' to do so.");
					person.endprompt();
				}
				else if (boi.equals("R"))
				{
					//Uses a pattern taking in only letters in order to restrict input to a string 
					//Made it so you have to put in first and last name to remove someone in the case that two people have the same first name
					System.out.println("Enter the first name of the customer you would like removed: ");
					person.addCustomersToArray();
					String firstname = input.next();
					Pattern names = null;
					names = Pattern.compile("[A-Z]{1,20}");
					Matcher namematcher = names.matcher(firstname.toUpperCase());
					while (!namematcher.matches())
					{
						System.out.println("Please enter the customers name that you would like to remove: ");
						firstname = input.next();
						namematcher = names.matcher(firstname.toUpperCase());
					}
					//Uses a pattern taking in only letters in order to restrict input to a string 
					System.out.println("Enter the last name of the customer you would like removed: ");
					String lastnamename = input.next();
					Pattern names2 = null;
					names2 = Pattern.compile("[A-Z]{1,20}");
					Matcher namematcher2 = names2.matcher(lastnamename.toUpperCase());
					while (!namematcher.matches())
					{
						System.out.println("Please enter the customers name that you would like to remove: ");
						lastnamename = input.next();
						namematcher2 = names2.matcher(lastnamename.toUpperCase());
					}
					person.removeCustomer(firstname, lastnamename);
					person.rewriteCustomers();
					person.EraseTempFileContext();
					
					System.out.println("Return to menu and display customers to check if they were removed!!\n");
					System.out.println("Would you like to go back to the main menu? Enter 'Yes' to do so.");
					person.endprompt();
				}
				else if (boi.equals("U"))
				{
					//Uses a pattern taking in only letters in order to restrict input to a string 
					System.out.println("Enter the first name of the person whos order you would like to update: ");
					String name = input.next();
					Pattern names = null;
					names = Pattern.compile("[A-Z]{1,20}");
					Matcher namematcher = names.matcher(name.toUpperCase());
					while (!namematcher.matches())
					{
						System.out.println("Please enter the customers name whos order you would like to update: ");
						name = input.next();
						namematcher = names.matcher(name.toUpperCase());
					}
					//Uses a pattern taking in only letters in order to restrict input to a string 
					System.out.println("Enter the last name of the person whos order you would like to update:");
					String lastname = input.next();
					Pattern names2 = null;
					names2 = Pattern.compile("[A-Z]{1,20}");
					Matcher namematcher2 = names2.matcher(lastname.toUpperCase());
					while (!namematcher2.matches())
					{
						System.out.println("Please enter the customers name whos order you would like to update: ");
						lastname = input.next();
						namematcher2 = names2.matcher(lastname.toUpperCase());
					}
					//Uses a try catch inside of a while loop to insure that a number is entered
					System.out.println("Enter the new order number: ");
					while (true)
					{
					try
					{
						neworder = input.nextInt();
						break;
					}
					catch (InputMismatchException ex)
					{
						System.out.println("Please enter the new order number: ");
						input.next();
						continue;
					}
					}
					person.updateOrder(neworder, name, lastname);
					person.rewriteCustomers();
					person.EraseTempFileContext();
					
					System.out.println("Return to menu and display customers to check if their order was updated!\n");
					System.out.println("Would you like to go back to the main menu? Enter 'Yes' to do so.");
					person.endprompt();
				}
				if (boi.equals("End"))
				{
					System.out.println("\nPlease return again soon!");
					boi = "blah";
					menu = "bleh";
				}
				else
				{
					System.out.println("\nPlease enter a prompted action.");
				}
				
		}	
	}
}	


