package usersPackage;
import appServices.*;

import java.util.ArrayList;

/**
 * Administrator class contains all admin's information and functionalities
 * */
public class Administrator extends UserProfile{

	/**
	 * list of requested playgrounds
	 * */
	ArrayList<Playground> requestedPlaygrounds;
	
	/**
	 * SystemUI object that will link with main SysyemUI object
	 * */
	SystemUI system;
	
	/**
	 * default constructor
	 * */
	public Administrator()
	{
		this.name = "admin";
		this.mail = "admin";
		this.password = "admin";
		requestedPlaygrounds = new ArrayList<>();
	}
	
	
	/**
     * The constructor accepts arguments for Administrator.
     * @param name       The name of the Administrator.
     * @param mail 	     The mail for the Administrator.
     * @param password   The password for the Administrator.
     * @param phone      The phone for the Administrator.
     * @param city       The city for the Administrator.
     */
	public Administrator(String name, String mail, String password, String phone, String city)
	{
		this.name = name;
		this.mail = mail;
		this.password = password;
		this.phone = phone;
		this.city = city;
		requestedPlaygrounds = new ArrayList<>();
	}
	
	
	/**
	 * to link SystemUI object {@link Administrator#system}
	 * @param sys parameter of type {@link SystemUI}
	 * */
	public void linkWithSystemUI(SystemUI sys)
	{
		system = sys;
	}
	
	
	/**
	 * add new playground to list {@link Administrator#requestedPlaygrounds}
	 * @param playG parameter of type {@link SystemUI}
	 * */
	public void addRequestedPlayground(Playground playG)
	{
		requestedPlaygrounds.add(playG);
	}
	
	
	/**
	 * add accepted playground to available playgrounds list {@link Booking#livePlaygrounds}
	 * @param playG parameter of type {@link Playground}
	 * */
	public void addPlayGToLiveList(Playground playG)
	{
		system.booking.addPlayground(playG);
	}
	
	
	/**
	 * show all requested playgrounds from list {@link Administrator#requestedPlaygrounds}
	 * @return boolean false if list is empty else return true
	 * */
	public boolean showAllRequestedPlayGs()
	{
		int x = -1;
		if(!requestedPlaygrounds.isEmpty())
		{
			for(Playground i: requestedPlaygrounds)
			{
				x++;
				System.out.println("index: " + x);
				System.out.println(i.toString());
				
			}
			
			return true;
		}
		else
		{
			System.out.println("List is empty!!");
		}
		
		return false;
	}
	
    /**
     * getPlayGorund member function returns playGround from list {@link Administrator#requestedPlaygrounds}.
     *
     * @param index index of playground of type int
     * @return {@link Playground} returns playground with index equal to parameter value
     */
	public Playground getPlayG(int index)
	{
		return requestedPlaygrounds.get(index);
	}
	
	
}
