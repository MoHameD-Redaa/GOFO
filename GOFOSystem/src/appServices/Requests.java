package appServices;
import usersPackage.*;



/**
 * Class Requests is responsible for playground reservation in specific slot
 * */

public class Requests {

	/**
	 * request id
	 * */
	int id;
	
	/**
	 * requested player
	 * */
	Player player;
	
	/**
	 * reserved playground
	 * */
	Playground playG;
	
	/**
	 * request status
	 * */
	RequestStatus status;
	
	/**
	 * request date
	 * */
	BookingDate date;

		
	
	/**
	 * default constructor
	 * */
	public Requests(){}
	
	/**
	 * request parameterized constructor
	 * 
	 * @param id	 request ID
	 * @param player player who reserved the playground
	 * @param playG  playground to be booked
	 * @param date   date of reservation
	 * @param status request status
	 * 
	 */
	public Requests(int id, Player player, Playground playG, BookingDate date, RequestStatus status) {
		this.player = player;
		this.playG = playG;
		this.status = status;
		this.id = id;
		this.date = date;
		
	}

	
	/**
	 * update request status
	 * 
	 * @param status parameter type is {@link RequestStatus}
	 * */
	public void updateStatus(RequestStatus status)
	{
		this.status = RequestStatus.Accepted;
	}
	
	
	/**
	 * get request ID
	 * 
	 * @return int request id
	 * */
	public int getID()
	{
		return id;
	}


	/**
	 * print request
	 * 
	 * @return String request details
	 * */
	@Override
	public String toString() {
		return "Requests [Request_ID= " + id + ", player=" + player.getName() + "\n"+ playG.toString() + ", status=" + status + "\n" + date.toString() + "]\n";
	}


	

	
	
	
}
