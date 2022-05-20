package appServices;
import java.util.ArrayList;

import usersPackage.*;

/**
 * Booking class contains all activated playgrounds, book a playground, send booking requests for players and playground owners
 * */
public class Booking {

	/**
	 * list of activated playgrounds  
	 * */
	private ArrayList<Playground> livePlaygrounds;
	
	/**
	 * list of requested reservation  
	 * */
	private ArrayList<Requests> allReqs;
	
	/**
	 * unique ID for each request  
	 * */
	private static int requestID = 0;
	
	/**
	 * default Constructor
	 * that initiates member variables
	 * 
	 * {@link Booking#livePlaygrounds} 	 initiate array of objects {@link Playground}
	 * {@link Booking#allReqs} 	 initiate array of objects {@link Requests}
	 * */
	public Booking() 
	{
		livePlaygrounds = new ArrayList<>();
		allReqs = new ArrayList<>();
	}
	
	/**
	 * add new playground
	 * @param newPlayG new playground that will be added to available playgrounds menu
	 * */
	public void addPlayground(Playground newPlayG)
	{
		livePlaygrounds.add(newPlayG);
	}
	
	
	/**
	 * get playground from available playgrounds list {@link Booking#livePlaygrounds}
	 * 
	 * @param index index of chosen playground on list
	 * @return {@link Playground}
	 * */
	public Playground getPlayG(int index)
	{
		return livePlaygrounds.get(index);
	}
	
	
	/**
	 * Show available playgrounds from {@link Booking#livePlaygrounds}
	 * */
	public void showAvailablePlayG()
	{
		int x = 0;
		if(!livePlaygrounds.isEmpty())
		{
			for(Playground playG: livePlaygrounds)
			{
				System.out.println("------------------------------\n" + "index: " + x +"\n" + playG.toString() + "\n------------------------------\n");
				x++;
			}
		}
		else
		{
			System.out.println("List is empty!!");
		}
	}
	
	
	/**
	 * send reservation request to player and playground owner
	 * @param playG reserved playground
	 * @param player player who reserved the playground
	 * @param req reservation request
	 * */
	public void sendBookingReq(Playground playG, Player player, Requests req)
	{
		player.addNewRequest(req);
		playG.getMyOwner().addNewRequest(req);
		allReqs.add(req);
	}
	
	
	/**
	 * To book a slot in playground
	 * @param playG chosen playground to be booked
	 * @param player player who reserved the playground
	 * @param date chosen slot
	 * */
	public void book(Playground playG, Player player, BookingDate date)
	{
		
		//check if chosen slot is free
		int index = playG.findBookingDate(date); // index of date
		
		if(index != -1) // date found
		{
			if(playG.getDate(index).isBooked())
			{
				System.out.println("Sorry this slot is booked");
			}
			else
			{
				requestID++; // generate new id for this request
				
				playG.getDate(index).bookTo(player.getName());
				double price = playG.getPrice() * playG.getDate(index).getHours();
				
				// create request to send it to owner and player
				
				Requests tmpRequest = new Requests(requestID, player, playG, date, RequestStatus.Pending);
				sendBookingReq(playG, player, tmpRequest);
				
				//send feedback
				System.out.println("Reservation completed successfully and you will pay: " + price + " $");
			}
		}
		else // if this time slot not reserved before
		{
			requestID++; // generate new id for this request
			
			playG.addNewSlot(date); // add this new slot to playground slots 
			index = playG.findBookingDate(date); // index of date
			
			playG.getDate(index).bookTo(player.getName());
			double price = playG.getPrice() * playG.getDate(index).getHours();
			
			// create request to send it to owner and player
			
			Requests tmpRequest = new Requests(requestID, player, playG, date, RequestStatus.Pending);	
			sendBookingReq(playG, player, tmpRequest);
			
			//send feedback
			System.out.println("Reservation completed successfully and you will pay: " + price + " $");
			
			
		}
	}
	
	
}
