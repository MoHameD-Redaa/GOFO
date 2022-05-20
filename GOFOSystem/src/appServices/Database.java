package appServices;
import java.util.ArrayList;

import usersPackage.*;

/**
 * Database class contains all users information of registered users
 * */
public class Database {

	/**
	 * players list
	 * */
	ArrayList<Player> playerList;
	
	/**
	 * playground owner list
	 * */
	ArrayList<PlaygroundOwner> ownerList;
	
	/**
	 * Administrator list
	 * */
	ArrayList<Administrator> adminList;
	
	/**
	 * object of user to handle current user type
	 * */
	UserProfile user;
	
	
	
	/**
	 * default constructor of Database class
	 * that initiates member variables and create default Administrator info(email: admin, password: admin)
	 * 
	 * {@link Database#playerList} 	 initiate array of objects Player
	 * {@link Database#ownerList} 	 initiate array of objects PlaygroundOwner
	 * {@link Database#adminList} initiate array of objects Administrator
	 */
	public Database()
	{
		playerList = new ArrayList<>();
		ownerList = new ArrayList<>();
		adminList = new ArrayList<>();
		
		adminList.add(new Administrator());
	}
	
	
	/**
	 * add new playground owner to list {@link Database#ownerList}
	 * 
	 * @param owner parameter type is {@link PlaygroundOwner}
	 * */
	public void addPlaygroundOwner(PlaygroundOwner owner)
	{
		ownerList.add(owner);
	}
	
	
	/**
	 * add new player to list {@link Database#playerList}
	 * 
	 * @param player parameter type is {@link Player}
	 * */
	public void addPlayer(Player player)
	{
		playerList.add(player);
	}
	
	
	/**
	 * add new Administrator to list {@link Database#adminList}
	 * 
	 * @param admin parameter type is {@link Administrator}
	 * */
	public void addadmin(Administrator admin)
	{
		adminList.add(admin);
	}
	
	
	/**
	 * check validation of user information
	 * 
	 * @param email parameter type is String
	 * @param password parameter type is String
	 * @return int if 0 so user not founded else if 1 user founded in adminList else if 2 user founded in playerList else if 3 user founded in ownerList
	 * */
	public int isValidAccount(String email, String password)
	{
		
		for(Administrator i: adminList)
		{
			if(i.getmail().equals(email))
			{
				user = i;
				return 1;
			}
		}
		
		for(Player i: playerList)
		{
			if(i.getmail().equals(email) && i.getpassword().equals(password))
			{
				user = i;
				return 2;
			}
		}
		
		for(PlaygroundOwner i: ownerList)
		{
			if(i.getmail().equals(email) && i.getpassword().equals(password))
			{
				user = i;
				return 3;
			}
		}
		
		// not found in database
		
		return 0;
	}
	
}
