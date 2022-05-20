package usersPackage;

import java.util.ArrayList;

import appServices.Requests;

/**
 * It contains the data for the PlaygroundOwner and some helpful methods.
 */
public class PlaygroundOwner extends UserProfile{

	/**
	 * list of requested slots of a playground
	 * */
	ArrayList<Requests> requests;
	
	/**
	 * list of playgrounds
	 * */
	ArrayList<Playground> playgrounds;
	
    /**
     * The constructor accepts arguments for PlaygroundOwner.
     * @param name       The name of the PlaygroundOwner.
     * @param mail 	     The mail for the PlaygroundOwner.
     * @param password   The password for the PlaygroundOwner.
     * @param phone      The phone for the PlaygroundOwner.
     * @param city       The city for the PlaygroundOwner.
     * Create arrayList for PlaygroundOwner requests.
     * Create arrayList for playgrounds that PlaygroundOwner has.
     */
	public PlaygroundOwner(String name, String mail, String password, String phone, String city)
	{
		this.name = name;
		this.mail = mail;
		this.password = password;
		this.phone = phone;
		this.city = city;
		requests = new ArrayList<>();
		playgrounds = new ArrayList<>();
	}
	
    /**
     * This function add the newest Requests for Playground booking to the playgroundOwner.
     * @param req new request that will be added to list {@link PlaygroundOwner#requests}
     */
	
	public void addNewRequest(Requests req)
	{
		requests.add(req);
	}
	
    /**
     * This function display all PlaygroundOwner requests if found.
     * @return boolean if list is empty returns false else returns true
     */
	
	public boolean showMyRequests()
	{
		int x = 0;
		
		if(!requests.isEmpty())
		{
			System.out.println("Requests");
			
			for(Requests i: requests)
			{
				System.out.println("index: " + x);
				System.out.println(i.toString());
				x++;
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
     * This function add  Playground to PlaygroundOwner.
     * @param playG 	add new playground to list {@link PlaygroundOwner#playgrounds}
     */
	public void addPlayground(Playground playG)
	{
		playgrounds.add(playG);
	}
	

    /**
     * This function allow the PlaygroundOwner to accept the request for booking playground.
     * @param index index of request to be accepted
     */
	public void acceptReq(int index)
	{
		requests.get(index).updateStatus(RequestStatus.Accepted);
	}
	
	
//	public boolean deleteReq(int id) {return true;}
	
	
}
