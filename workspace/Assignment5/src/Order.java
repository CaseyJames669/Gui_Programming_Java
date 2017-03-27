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

public class Order 
{    
	/**
	 * Declare All Variables of string type
	 */
	private String CustomerNum;
	private String Title;
	private String Qty;
	private String Cover;
	private String Shipping;
	private String Total;
    
    /**
     * Default Constructor for Order
     * Setting Variables to "" nothing
     */
    public Order()
    {
    	setCustomerNum("");
    	setTitle("");
    	setQty("");
    	setCover("");
    	setShipping("");
    	setTotal("");
    }

    /**
     * returns Order CustomerNum
     * @return string
     */
	public String getCustomerNum() {
		return CustomerNum;
	}

	/**
	 * sets Order CustomerNum
	 * @param CustomerNum the CustomerNum is set
	 */
	public void setCustomerNum(String customerNum) {
		CustomerNum = customerNum;
	}

    /**
     * returns Order Title
     * @return string
     */
	public String getTitle() {
		return Title;
	}

	/**
	 * sets Order Title
	 * @param Title the Title is set
	 */
	public void setTitle(String title) {
		Title = title;
	}

    /**
     * returns Order Qty
     * @return string
     */
	public String getQty() {
		return Qty;
	}

	/**
	 * sets Order Qty
	 * @param Qty the Qty is set
	 */
	public void setQty(String qty) {
		Qty = qty;
	}

    /**
     * returns Order Cover
     * @return string
     */
	public String getCover() {
		return Cover;
	}

	/**
	 * sets Order Cover
	 * @param Cover the Cover is set
	 */
	public void setCover(String cover) {
		Cover = cover;
	}

	 /**
     * returns Order Shipping
     * @return string
     */
	public String getShipping() {
		return Shipping;
	}

	/**
	 * sets Order Shipping
	 * @param Shipping the Shipping is set
	 */
	public void setShipping(String shipping) {
		Shipping = shipping;
	}

	 /**
     * returns Order Total
     * @return string
     */
	public String getTotal() {
		return Total;
	}

	/**
	 * sets Order Total
	 * @param Total the Total is set
	 */
	public void setTotal(String total) {
		Total = total;
	}

}
