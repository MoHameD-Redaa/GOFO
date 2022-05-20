package usersPackage;

import java.util.ArrayList;

/**
 * It contains the data for the Playground and some helpful methods.
 */

public class Playground {

	/**
	 * owner of the playground
	 * */
	private PlaygroundOwner owner;
	
	/**
	 * playground name
	 * */
	private	String name;
	
	/**
	 * playground size
	 * */
	private int size;
	
	/**
	 * playground price per hour
	 * */
	private double pricePerHour;
	
	/**
	 * playground status
	 * */
	protected boolean isActive;
	
	/**
	 * playground location
	 * */
	private String location;
	
	
	/**
	 * list of playground slots
	 * */
	ArrayList<BookingDate> bookingData;
	
	
    /**
     * The constructor accepts arguments for Playground.
     * @param owner       		The owner name for the Playground.
     * @param name 	     		The name of the Playground.
     * @param size   			The size of the Playground.
     * @param pricePerHour      The pricePerHour for the Playground.
     * @param location			playground location
     * create array list for the booking data.
     * initially Make it not active
     */
	public Playground(PlaygroundOwner owner, String name, int size, double pricePerHour, String location)
	{
		this.owner = owner;
		this.name = name;
		this.size = size;
		this.pricePerHour = pricePerHour;
		this.location = location;
		bookingData = new ArrayList<>();
		isActive = false;
	}


    /**
     * Print Playground Details.
     * @return String returns Playground details in string format.
     */
	@Override
	public String toString() {
		return "Playground [owner name =" + owner.getName() + ", Playground name=" + name + ", size=" + size + ", pricePerHour=" + pricePerHour
				+ " location: " + location+"]";
	}
	
	
	/**
     * getMyOwner member function returns the owner for the playground.
     * @return {@link PlaygroundOwner} the owner of the playground.
     */
	public PlaygroundOwner getMyOwner()
	{
		return owner;
	}
	
    /**
     * This function add new slot for Playground to be booked.
     * @param date		new booked slot of type {@link BookingDate}
     */
	
	public void addNewSlot(BookingDate date)
	{
		bookingData.add(date);
	}
	
    /**
     * Get price per hour  for the playground.
     * @return double returns the pricePerHour for the playground.
     */
	public double getPrice()
	{
		return pricePerHour;
	}
	
    /**
     * Check if the playground is Activated or not.
     * @return boolean returns true if active else false
     */
	public boolean isActive()
	{
		return isActive;
	}
	
	
    /**
     * Check if particular slot is free to be booked.
     * @param time 	parameter type of {@link BookingDate}
     * @return boolean returns true if free else false
     */
	public boolean isItFreeSlot(BookingDate time)
	{
		return time.isBooked();
	}
	
	
    /**
     * Get getDate for booking.
     * @param index parameter type is int
     * @return {@link BookingDate} returns data for booking.
     */
	public BookingDate getDate(int index)
	{
		return bookingData.get(index);
	}
	
	
	 /**
     * Search booking data .
     * @param date		date to be searched for, of type {@link BookingDate} 
     * @return returns the index of the booking data in the array list of BookingDate.
     */
	public int findBookingDate(BookingDate date)
	{
		int x = -1;
		for(BookingDate i: bookingData)
		{
			x++;
			if(i.equals(date))
			{
				return x;
			}
		}
		return x;
	}
	
	
	
}
