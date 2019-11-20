/**
 * class Money is used to track a USD amount 
 * consisting of two integers corresponding to 
 * dollars and cents. All amounts are positive or zero
 * and the cents are never returned as greater than
 * 99. If the value of cents is greater than 99, the
 * appropriate value is added to the dollar amount.
 * 
 * @author (Sambhavi Pandey)
 * @version (Last modified on April 26, 2018)
 */
public class Money
{
    //Declaring instance variables 
    private int dollars;
    private int cents;

    /**
     * Money class constructor that takes no-arguments.
     */
    public Money()
    {
    }

    /**
     * Money class constructor takes an argument of 
     * type int corresponding to dollars. The purpose
     * of this constructor is to set the dollar 
     * amount and set the cents value to 0.
     * 
     * @param dol
     */
    public Money (int dol)
    {
        this.setMoney(dol,0);
    }

    /**
     * Money class constructor takes two int
     * arguments corresponding to the dollars 
     * and cents. The purpose of this constructor
     * is to initialize the dollars and cents. 
     * 
     * @param dol
     * @param cent 
     */
    public Money(int dol, int cent)
    {
        this.setMoney(dol,cent);
    }

    /**
     * Money class copy constructor takes an 
     * argument of the class type Money. The 
     * purpose of this constructor is to 
     * initialize the instance variables to 
     * the value passed into the parameter.
     * 
     * @param other
     */
    public Money (Money other)
    {
        //Checks if it is a Money object
        if ((other != null) || (other instanceof Money == true))
        {
            //Initializes money based on the parameter values
            this.setMoney(other.dollars, other.cents);
        }
        //Invalid Money object
        else
        {
            System.out.println("Invalid money");
            System.exit(0);
        }
    }

    /**
     * getDollars is a method that takes no arguments
     * and returns a value of type int. The purpose of this 
     * method is to return a value corresponding
     * to the dollars. 
     */
    public int getDollars()
    {
        return dollars;
    }

    /**
     * getCents method takes no arguments and
     * returns a value of type int. The purpose of this
     * method is to return a value corresponding to the
     * cents. 
     */
    public int getCents()
    {
        return cents;
    }

    /**
     * setMoney method takes two int arguments 
     * corresponding to the dollars and cents. The 
     * purpose of this method is to set the value 
     * of the instance variables to the parameter 
     * values, as long as the dollars and cents 
     * are not a negative value. If the dollars 
     * and cents are less than 0 (a negative 
     * value), then an error message is displayed
     * and the program ends.
     *
     * @param dollars
     * @param cents 
     */
    public void setMoney(int dollars, int cents)
    {
        //Checks if dollars and cents are valid values
        if ((dollars >= 0) && (cents >= 0))   
        {
            this.dollars = dollars + (cents/100);
            this.cents = cents % 100;
        }
        else 
        {
            System.out.println("Error: Money has a negative value");
            System.exit(0);
        }
    }

    /**
     * getMoney is a method that takes no arguments
     * and returns a value of type double. The purpose 
     * of this method is to get the money amount 
     * as a double. 
     */
    public double getMoney()
    {
        double money = 0.0;
        money = dollars + (double)(cents/100);
        return money;
    }

    /**
     * add is a method that takes an int argument 
     * corresponding to the dollar value that needs
     * to be added to the instance variable. The 
     * purpose of this method is to add to the instance
     * variable, the dollar value passed in the parameter.
     * 
     * @param dollars
     */
    public void add(int dollars)
    {
        this.dollars += dollars;
    }

    /**
     * add is a method that takes two int arguments 
     * corresponding to the dollar and the cent. 
     * The purpose of this method is to add the dollar
     * and cent value passed in the parameter to the 
     * instance variable after reducing the cents.
     * 
     * @param dollars
     * @param cents
     */
    public void add(int dollars, int cents)
    {
        this.dollars = this.dollars + dollars + ((this.cents + cents)/100);
        this.cents = (this.cents + cents) % 100;
    }

    /**
     * add is a method that takes one argument
     * of type Money. The purpose of this method
     * is to add the dollar and cent value passed 
     * in the Money object to the instance variable
     * in the other Money object. 
     * 
     * @param other
     */
    public void add(Money other)
    {
        this.add(other.dollars, other.cents);
    }

    /**
     * equals method takes an argument of type 
     * Object and returns a boolean value. The 
     * purpose of this method is to compare this 
     * money object to the other money object. 
     * 
     * @param o
     */
    public boolean equals(Object o)
    {
        //Type casting into Money class object
        Money m = (Money)o;
        //Checking for validity
        if ((m != null) && (m instanceof Money == true))
        {
            //Check to determine if the objects are the same
            if ((this.dollars == m.dollars) && (this.cents == m.cents))
            {
                return true;
            }
        }
        return false;
    }
    
    /**
     * String method takes no arguments and 
     * returns a String value. The purpose of 
     * this method is to output the money as 
     * a String.
     */
    public String toString()
    {
        double temp = dollars + cents/100.0;  
        return String.format("$%.2f", temp);
    }
}