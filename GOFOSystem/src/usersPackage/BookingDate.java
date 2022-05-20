package usersPackage;

/**
 * It contains details data about the booking of the Playground.
 */

public class BookingDate {

	/**
	 * day of reservation
	 * */
	private	int day;
	
	/**
	 * month of reservation
	 * */
	private int month;
	
	/**
	 * year of reservation
	 * */
	private	int year;
	
	/**
	 * start time of reservation
	 * */
	private int startTime;
	
	/**
	 * end time of reservation
	 * */
	private int endTime;
	
	/**
	 * player who booked this slot
	 * */
	private	String playerName;
	
	/**
	 * slot status
	 * */
	private	boolean isBooked; 
	
	
	/**
	 * default constructor
	 * */
	public BookingDate()
	{
		this.day = 6;
		this.month = 6;
		this.year = 2021;
		this.startTime = 6;
		this.endTime = 7;
		this.playerName = "";
		this.isBooked = false;
	}
	
    /**
     * The constructor accepts arguments for BookingDate.
     * @param day       		The day for the BookingDate.
     * @param month 	     	The month of the BookingDate.
     * @param year   			The year of the BookingDate.
     * @param startTime      	The startTime for the BookingDate.
     * @param endTime 			The endTime for the BookingDate.
     * initially Make it not booked untill the playgroundOwner accept.
     */
	public BookingDate(int day, int month, int year, int startTime, int endTime)
	{
		this.day = day;
		this.month = month;
		this.year = year;
		this.startTime = startTime;
		this.endTime = endTime;
		this.playerName = "";
		this.isBooked = false;
	}
	
    /**
     * This function set that playground booked to specific playerName
     * 
     * @param playerName parameter of type {@link String}
     */
	public void bookTo(String playerName) {
		this.playerName = playerName;
		isBooked = true;
	}
	
    /**
     * Check if the playground is booked or not.
     * @return returns true if booked before else false.
     */
	public boolean isBooked()
	{
		return isBooked;
	}
	
    /**
     * Get booked hours.
     * @return int returns number of hours that booked.
     */
	public int getHours()
	{
		return endTime - startTime;
	}
	
	
    /**
     * Print Booking Details.
     * @return String returns Booking data details in string format.
     */
	
	@Override
	public String toString() {
		return "BookingDate [day=" + day + ", month=" + month + ", year=" + year + ", startTime=" + startTime
				+ ", endTime=" + endTime + "]";
	}
	
	
	
	
}
