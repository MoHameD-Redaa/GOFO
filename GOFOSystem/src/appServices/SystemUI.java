package appServices;
import java.util.Scanner;

import usersPackage.*;

/**
 * Class SystemUI is responsible for interaction between users and other system 
 * 
 * */
public class SystemUI {
	
	/**
	 * object that has all users' information
	 * */
	Database database;
	
	/**
	 * object that has all available playgrounds
	 * */
	public Booking booking;
	
	/**
	 * object of user to handle all users' types
	 * */
	UserProfile currentUser;
	
	/**
	 * object of default admin user
	 * */
	Administrator defaultAdmin;
	
	
	/**
	 * get user's input
	 * */
	Scanner scan = new Scanner(System.in);

	/**
	 * default constructor of SystemUI class
	 * that initiates member variables
	 * 
	 * {@link SystemUI#booking} 	 initiate booking object
	 * {@link SystemUI#database} 	 initiate database object
	 * {@link SystemUI#defaultAdmin} initiate Administrator object
	 */
	public SystemUI()
	{
		this.booking = new Booking();
		this.database = new Database();
		defaultAdmin = database.adminList.get(0);
		defaultAdmin.linkWithSystemUI(this);
		
	}
	
	
	/**
	 * Sign up new player and save its information in database object
	 * 
	 * @param player parameter type is {@link Player}
	 * */
	public void signUpPlayer(Player player)
	{
		database.addPlayer(player);
	}
	
	
	/**
	 * Sign up new playground owner and save its information in database object
	 * 
	 * @param owner parameter type is {@link PlaygroundOwner}
	 * */
	public void signUpPlaygroundOwner(PlaygroundOwner owner)
	{
		database.addPlaygroundOwner(owner);
	}
	
	
	/**
	 * Sign up new administrator and save its information in database object
	 * 
	 * @param admin parameter type is {@link Administrator}
	 * */
	public void signUpAdmin(Administrator admin)
	{
		database.addadmin(admin);
	}
	
	
	/**
	 * perform login operation and check if user found in database
	 * 
	 * @param email parameter type is String
	 * @param password parameter type is String
	 * */
	public void login(String email, String password)
	{
		int userType = database.isValidAccount(email, password); // if return equals 0 that means user not found, else if 1 it's admin
																// else if 2 it's player, else if 3 it's owner
		boolean valid = false;
		
		while(!valid)
		{
			switch(userType)
			{
				case 0:
				{
					System.out.println("Invalid email or password");
					
					valid = true;
					break;
				}
				
				default:
				{
					currentUser = database.user;
					valid = true;
					
					if(userType == 1)
					{
						defaultAdmin = (Administrator)currentUser;
						adminMenu();
						
					}
					else if(userType == 2)
					{
						playerMenu();
					}
					else
					{
						ownerMenu();
					}
				}
			}
		}
		
	}
	
	
	/**
	 * Show player screen
	 * */
	public void playerMenu()
	{
		Player player = (Player)currentUser; 
		
		int choice = 0;
		boolean valid = true;
		
		boolean correctChoice = false;
		while(valid)
		{
			
			while(!correctChoice)
			{
				System.out.println("1- Book Playground\n"
						  +"2- View my requests\n"
						  +"3- logOut");
		
				choice = scan.nextInt();
				
				if(choice >=1 && choice <= 3)
				{
					correctChoice = true;
				}
				else
				{
					correctChoice = false;
				}
			}
		
			switch(choice)
			{
				case 1:
				{
					int index;
					booking.showAvailablePlayG();
					
					System.out.println("1- choose playground\n"+
									   "2- Go back to menu");
					int num = scan.nextInt();
					if(num == 2)
					{
						correctChoice = false;
						break;
					}
					System.out.println("type playground index");
					index = scan.nextInt();
					
					Playground tmpPlayG = booking.getPlayG(index);
					
					//player enter details of reservation date
					
					System.out.println("type your time slot details");
					System.out.println("Day:");
					int day = scan.nextInt();
					
					System.out.println("month:");
					int month = scan.nextInt();
					
					System.out.println("year:");
					int year = scan.nextInt();
					
					System.out.println("start hour:");
					int startTime = scan.nextInt();
					
					System.out.println("end hour:");
					int endTime = scan.nextInt();
					
					BookingDate date = new BookingDate(day, month, year, startTime, endTime);
					
					booking.book(tmpPlayG, player, date);
					
					correctChoice = false;
					break;
				}
				
				case 2:
				{
					player.showMyRequests();
					correctChoice = false;
					break;
				}
				
				case 3:
				{
					valid = false;
					break;
				}
				
				default:
				{
					valid = true;
				}
			}
		
		}
	}
	
	
	/**
	 * Show playground owner screen
	 * */
	public void ownerMenu()
	{
		PlaygroundOwner owner = (PlaygroundOwner)currentUser; 
		
		int choice = 0;
		boolean valid = true;
		
		boolean correctChoice = false;
		while(valid)
		{
			
			while(!correctChoice)
			{
				System.out.println("1- add playground\n"
								  +"2- View my requests\n"
								  +"3- logOut");
		
				choice = scan.nextInt();
				
				if(choice >=1 && choice <= 3)
				{
					correctChoice = true;
				}
				else
				{
					correctChoice = false;
				}
			}
		
			switch(choice)
			{
				case 1:
				{
					// Enter new playground information
					
					System.out.println("playground name:");
					String name = scan.next();
					
					System.out.println("playground size:");
					int size = scan.nextInt(); 
					
					System.out.println("price per hour:");
					double pricePerHour = scan.nextDouble();
					
					System.out.println("location:");
					String location = scan.next();
					
					Playground tmpPlayG = new Playground(owner, name, size, pricePerHour, location);
					
					owner.addPlayground(tmpPlayG);
					defaultAdmin.addRequestedPlayground(tmpPlayG);
					
					correctChoice = false;
					break;
				}
				
				case 2:
				{
					if(owner.showMyRequests()) // if true that means list isn't empty
					{
						System.out.println("1- choose request to accept\n"+
								   "2- Go back to menu");
						int num = scan.nextInt();
						if(num == 2)
						{
							correctChoice = false;
							break;
						}
						
						System.out.println("Enter Index of request");
						int reqNum = scan.nextInt();
						
						owner.acceptReq(reqNum);
						
					}
					
					correctChoice = false;
					break;
				}
				
				case 3:
				{
					valid = false;
					break;
				}
				
				default:
				{
					valid = true;
					correctChoice = false;
				}
			}
		
		}
		
	}
	
	/**
	 * Show Administrator screen
	 * */
	public void adminMenu()
	{ 	
		int choice = 0;
		boolean valid = true;
		
		boolean correctChoice = false;
		while(valid)
		{
			
			while(!correctChoice)
			{
				System.out.println("1- check new requested playgrounds\n"
						  		  +"2- logOut");
		
				choice = scan.nextInt();
				
				if(choice >=1 && choice <= 2)
				{
					correctChoice = true;
					if(choice == 2)
					{
						valid = false;
					}
				}
				else
				{
					correctChoice = false;
				}
			}
		
			switch(choice)
			{
				case 1:
				{
					
					if(defaultAdmin.showAllRequestedPlayGs()) // if true that means list isn't empty
					{
						System.out.println("\n1- choose playground to accept\n2- Go back to menu");
						int num = scan.nextInt();
						
						if(num == 1)
						{
							System.out.println("Enter playground index to accept");
							int index = scan.nextInt();
							
							Playground tmpPlayG = defaultAdmin.getPlayG(index);
							
							defaultAdmin.addPlayGToLiveList(tmpPlayG);
							
							System.out.println("playground Accepted!");
						
						}
						
					}
					
					
					correctChoice = false;
					break;
				}
				
				case 2:
				{
					valid = false;
					break;
				}
			
				
				default:
				{
					valid = false;
				}
			}
		
		}
	}
	

}
