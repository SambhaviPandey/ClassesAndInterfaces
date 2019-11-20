import java.io.Serializable;
/**
 * class Bill represents an outstanding or paid bill.
 * This class contains the amount of bill as a 
 * Money object, the due date of the bill as a Date
 * object, and a Date object that tracks the date paid.
 * This class also consists of:
 * Constructors
 * Accessor methods 
 * Mutator methods 
 * equals method
 * toString method 
 * compareTo method 
 * clone method 
 * 
 * @author (Sambhavi Pandey)
 * @version (Last modified on May 17, 2018)
 */
public class Bill implements Comparable<Bill>, 
                   Cloneable, Serializable
{
    //Declaring instance variables 
    private Money amount;
    private Date dueDate;
    private Date paidDate;
    private String originator;

    /**
     * Bill class constructor that takes no-arguments.
     */
    public Bill()
    {
    }

    /**
     * Bill constructor that takes an argument 
     * of type Money, an argument of 
     * type Date, and an argument of type String.
     * The purpose of this constructor is to initialize
     * the instance variables. 
     * 
     * @param amount
     * @param dueDate
     * @param originator
     */
    public Bill(Money amount, Date dueDate, String originator)
    {
        this.amount = amount;
        this.dueDate = dueDate;
        this.originator = originator;
        this.paidDate = null;
    }

    /**
     * Bill class copy constructor that takes an argument 
     * of type Bill.The purpose of this constructor is 
     * to assign the instance variables to the value 
     * passed into the parameter.
     * 
     * @param toCopy
     */
    public Bill(Bill toCopy)
    {
        this.amount = new Money(toCopy.amount);
        this.dueDate = new Date(toCopy.dueDate);
        this.originator = new String(toCopy.originator);
        this.paidDate = new Date(toCopy.paidDate);
    }

    /**
     *  getAmount method takes no arguments and 
     *  returns a value of type Money. The purpose of 
     *  this method is to return the amount of Money.
     */
    public Money getAmount()
    {
        return this.amount.clone();
    }

    /**
     * getDueDate method takes no argument and 
     * returns a value of type Date. The purpose 
     * of this method is to return the due date.
     */
    public Date getDueDate() 
    {
        return this.dueDate.clone();
    }

    /**
     * getOriginator method takes no argument and
     * returns a value of type String. The purpose
     * of this method is to return the originator.
     */
    public String getOriginator()
    {
        return new String(this.originator);
    }

    /**
     * isPaid method takes no argument and returns 
     * a boolean value. The purpose of this method 
     * is to check if the bill is paid. If the bill
     * is paid then it returns true, otherwise it returns 
     * false.
     */
    public boolean isPaid()
    {
        if(this.paidDate != null)
        {
            return true;
        }  
        else 
        {
            return false;
        }
    }

    /**
     * setPaid method takes an argument of type 
     * Date and returns a boolean value. 
     * The purpose of this method is to check
     * if the bill is paid. If the bill
     * is paid then it returns true, otherwise it returns 
     * false.
     * 
     * @param datePaid 
     */
    public boolean setPaid(Date datePaid)
    {
        if (datePaid.isAfter(dueDate))
        {
            return false;
        }
        else 
        {
            this.paidDate = datePaid;
        }
        return true;
    }

    /**
     * setDueDate method takes an argument of type 
     * Date and returns a boolean value. 
     * The purpose of this method is to set the due 
     * date. If the bill has already been paid then it
     * is false, else it resets the due date and 
     * returns true. 
     * 
     * @param nextDate
     */
    public boolean setDueDate(Date nextDate)
    {
        //if the bill is paid 
        if (this.isPaid() == true)
        {
            return false; 
        }
        //if the bill is not paid 
        else 
        {
            this.dueDate = nextDate;
            return true;
        }
    }

    /**
     * setAmount method takes an argument of type 
     * Money and returns a boolean value. 
     * The purpose of this method is to set the 
     * amount owed. If it has already been paid
     * then it returns false and does not change 
     * the amount owed, else it changes the 
     * amount and return true.
     * 
     * @param amount
     */
    public boolean setAmount(Money amount)
    {
        //if the bill is paid 
        if(this.isPaid()== true)
        {
            return false; 
        }
        //if the bill is not paid 
        else 
        {
            this.amount = amount;
            return true;
        }
    }

    /**
     * setOriginator method takes an argument of
     * type String. The purpose of this method is to 
     * set the instance variable equal to the 
     * parameter value.
     * 
     * @param originator
     */
    public void setOriginator(String originator)
    {
        this.originator = originator;
    }

    /**
     * toString method does not take any arguments 
     * and returns a value of type String. The purpose 
     * of this method is to output the amount, when it 
     * is due, to whom, if it is paid, and if it is paid, 
     * the date it is paid.
     */
    public String toString()
    {
        //if the bill is already paid 
        if (this.isPaid() == true)
        {
            return this.amount + " " + this.dueDate + " " 
            + this.originator + " was paid and paid on " 
            + this.paidDate;
        }
        //if the bill is not paid 
        else 
        {
            return this.amount + " " + this.dueDate + " "
            + this.originator + " was not paid ";
        }
    }

    /**
     * equals method takes an argument of type 
     * Object and returns a boolean value. The 
     * purpose of this method is to determine if 
     * the two objects are same. 
     * 
     * @param toCompare
     */
    public boolean equals(Object toCompare)
    {
        //type-cast into a Bill class object 
        Bill b = (Bill)toCompare;
        //determines if the objects entered are valid 
        if ((b != null) || (b instanceof Bill == true))
        {
            //if the objects are the same 
            if ((this.amount.equals(b.amount)) && 
            (this.dueDate.equals(b.dueDate)) &&
            (this.paidDate.equals(b.paidDate)) &&
            (this.originator.equals(b.originator)))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * compareTo method takes an argument 
     * of type Bill and returns a value of 
     * type int. The purpose of this method 
     * is to compare two Bill objects.
     * 
     * @param b
     */
    @Override
    public int compareTo(Bill b) 
    {
        //if the class is not equal 
        if (this.getClass() != b.getClass()) 
        {
            throw new IllegalArgumentException("Invalid class");
        }

        //if the getOriginator method is equal
        if (this.getOriginator().compareTo(b.getOriginator()) == 0) 
        {
            return 0;
        }

        //if this.getOriginator() is greater than b.getOriginator()
        if (this.getOriginator().compareTo(b.getOriginator()) > 0)
        {
            return 1;
        }
        //if this.getOriginator() is less than b.getOriginator()
        else
        {
            return -1;
        }
    }

    /**
     * clone method takes copy of the instance 
     * variable. 
     */
    @Override
    public Bill clone() 
    {
        return new Bill(this.amount.clone(),
                       this.dueDate.clone(),
                       this.originator);
    }
}
