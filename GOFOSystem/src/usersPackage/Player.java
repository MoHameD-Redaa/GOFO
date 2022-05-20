package usersPackage;

import java.util.ArrayList;

import appServices.Requests;

/**
 * It contains the data for the Player and some helpful methods.
 */
public class Player extends UserProfile{

	/**
	 * list of player requests
	 * */
	ArrayList<Requests> requests;
	
    
	/**
     * The constructor accepts arguments for Player.
     * @param name       The name of the Player.
     * @param mail 	     The mail for the Player.
     * @param password   The password for the Player.
     * @param phone      The phone for the Player.
     * @param city       The city for the Player.
     */
	public Player(String name, String mail, String password, String phone, String city) {
		this.name = name;
		this.mail = mail;
		this.password = password;
		this.phone = phone;
		this.city = city;
		
		requests = new ArrayList<>();
	}
	
	
    /**
     * This function add new request for player requests.
     * @param req parameter of type {@link Requests}
     */
	public void addNewRequest(Requests req)
	{
		requests.add(req);
	}
	
	
    /**
     * This function display all player requests.
     */
	public void showMyRequests()
	{
		if(!requests.isEmpty())
		{
			System.out.println("Requests");
			
			for(Requests i: requests)
			{
				System.out.println(i.toString());
			}
		}
		else
		{
			System.out.println("List is empty!!");
		}
	}
	
	
//	public void deleteReq(int id) {}
	
	
}
