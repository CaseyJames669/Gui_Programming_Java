/**
 * Class: Account
 * 
 * Version: Assignment 5 
 * 
 * Date: 10/30/2012
 *
 * Copyright Notice: 10,000 to use this
 *
 * @author Zach Bladow
 */

public class Account 
{
        protected double balance;

        /** sets the amt to the balance
        * @param  amt a double that is set to the balance
        */
        public Account( double amt )
	{   balance = amt;
	}

        /** initializes the account to a balance of zero
        */
        public Account()
	{       balance = 0.0;
	}

        /** adds the balance to the amt
        * @param  amt a double that is how much you want to add
        */
        public void deposit( double amt )
	{
		balance = balance + amt;
	}

        /** sets the account balance to the differences between the amount and the balance
        * @param  amt a double that is being subtracted from the balance
        * @return amt returns the account amount after being calculated if balance is less then amt returns 0
        */
        public double withdraw( double amt )
	{
		if (balance >= amt)
		{        balance = balance - amt;
                        return amt;
		}
		else     return 0.0;
	}

        /** returns the balance
        * @return balance returns the account balance
        * @see MSUM Website
        */
        public double findBalance()
	{
                return balance;
	}
}  
