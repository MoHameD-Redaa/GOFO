package usersPackage;

/**
 * UserProfile contains user information and getter methods
 * */
public class UserProfile {
	
	/**
	 * user name
	 * */
	String name;
	
	/**
	 * user email
	 * */
	String mail;
	
	/**
	 * user password
	 * */
	String password;
	
	/**
	 * user phone number
	 * */
	String phone;
	
	/**
	 * user city name
	 * */
	String city;
    
	
	
	/**
     * getName returns the value in member variable name.
     * @return String The name of the UserProfile.
     */
	
	public String getName()
	{
		return name;
	}
	
	
    /**
     * get mail returns the value in member variable mail.
     *
     * @return String The mail of the UserProfile.
     */
	public String getmail()
	{
		return mail;
	}
	
	
    /**
     * get password returns the value in member variable password.
     *
     * @return String The password of the UserProfile.
     */
	public String getpassword()
	{
		return password;
	}
	
	
}
