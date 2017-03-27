/**
 * Class: Account
 * 
 * Version: Assignment 5 
 * 
 * Date: 11/13/2012
 *
 * Copyright Notice: 10,000 to use this
 *
 * @author Zach Bladow
 */

public class Customer 
{
	
	/**
	 * Declare All Variables of string type
	 */
    private String firstName;
    private String lastName;
    private String streetAddress;
    private String City;
    private String State;
    private String Zip;
    private String Email;
    
    /**
     * Default Constructor for Customer
     * Setting Variables to "" nothing
     */
    public Customer()
    {
        setFirstName("");
        setLastName("");
        setStreetAddress("");
        setCity("");
        setState("");
        setZip("");
        setEmail("");        
    }

    /**
     * returns customer firstName
     * @return string
     */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * sets customer firstName
	 * @param firstName the firstName is set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

    /**
     * returns customer lastName
     * @return string
     */
	public String getLastName() {
		return lastName;
	}

	/**
	 * sets customer lastName
	 * @param lastName the lastName is set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

    /**
     * returns customer StreetAddress
     * @return string
     */
	public String getStreetAddress() {
		return streetAddress;
	}

	/**
	 * sets customer StreetAddress
	 * @param StreetAddress the StreetAddress is set
	 */
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

    /**
     * returns customer City
     * @return string
     */
	public String getCity() {
		return City;
	}

	/**
	 * sets customer City
	 * @param City the City is set
	 */
	public void setCity(String city) {
		City = city;
	}

    /**
     * returns customer State
     * @return string
     */
	public String getState() {
		return State;
	}

	/**
	 * sets customer State
	 * @param State the State is set
	 */
	public void setState(String state) {
		State = state;
	}

    /**
     * returns customer Zip
     * @return string
     */
	public String getZip() {
		return Zip;
	}

	/**
	 * sets customer Zip
	 * @param Zip the Zip is set
	 */
	public void setZip(String zip) {
		Zip = zip;
	}

    /**
     * returns customer Email
     * @return string
     */
	public String getEmail() {
		return Email;
	}

	/**
	 * sets customer Email
	 * @param Email the Email is set
	 */
	public void setEmail(String email) {
		Email = email;
	}
}
