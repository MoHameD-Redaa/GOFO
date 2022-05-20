package appServices;

import java.util.Scanner;
import usersPackage.Administrator;
import usersPackage.Player;
import usersPackage.PlaygroundOwner;

/**
 * Main class show main screen(registration page)
 * */
public class Main {

	public static void main(String[] args) {
		
		SystemUI systemUI = new SystemUI(); // initiate SystemUI object
		
		Scanner scan = new Scanner(System.in);
		
		boolean exit = false;
		
		while(!exit)
		{
			
			System.out.println("1- login\n"+
					   "2- SignUp\n"+
					   "3- exit");
	
			int choice = scan.nextInt();
			
			switch(choice)
			{
				case 1:
				{
				
					System.out.println("Enter login Info");
					
					
					System.out.println("Email:");
					String email = scan.next();
					
					System.out.println("password:");
					String password = scan.next();
					
					systemUI.login(email, password);
					
					
					
					
					
					break;
				}
				case 2:
				{
					int type;
					System.out.println("chose your type");
					System.out.println("1- player\n"+
									   "2- playground owner\n" +
									   "3- Admin");
					
					type = scan.nextInt();
		
					System.out.println("type your name:");
					String name = scan.next();
					System.out.println("type your mail:");
					String mail = scan.next();
					System.out.println("type your password:");
					String password = scan.next();
					System.out.println("type your phone:");
					String phone = scan.next();
					System.out.println("type your city:");
					String city = scan.next();
					
					switch(type)
					{
						case 1:
						{
							Player player = new Player(name, mail, password, phone, city);
							systemUI.signUpPlayer(player);
							break;
						}
						
						case 2:
						{
							PlaygroundOwner owner = new PlaygroundOwner(name, mail, password, phone, city);
							systemUI.signUpPlaygroundOwner(owner);;
							break;
						}
						
						case 3:
						{
							// admin is saved by default as email: admin password admin
							Administrator admin = new Administrator(name, mail, password, phone, city);
							systemUI.signUpAdmin(admin);
							break;
						}
					}
					
					
					break;
				}
				
				case 3:
				{
					exit = true;
				}
			}
		}

		scan.close();
	}

}
