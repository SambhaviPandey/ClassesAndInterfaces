/**
 * class Date is a program that represents the 
 * date (including month, day, year). 
 * All days are between 1-31, months are between 1-12, 
 * each month has 31 days, and years are between 
 * 2014-2024. If an invalid date is entered, an 
 * error message is printed and program ends.
 * This class also consists of:
 * Constructors
 * Accessor methods 
 * Mutator methods 
 * equals method
 * toString method 
 * 
 * @author (Sambhavi Pandey)
 * @version (Last modified on April 26, 2018)
 */
public class Date
{
    //Declaring instance variables
    private int month;
    private int day;
    private int year;

    /**
     * Date class constructor that takes no-arguments.
     */
    public Date()
    {
    }

    /**
     * Date constructor that takes three int 
     * arguments corresponding to the month, day,
     * year. The purpose of this constructor 
     * is to set the values for the month, day, and 
     * year.
     * 
     * @param month
     * @param day
     * @param year 
     */
    public Date(int month, int day, int year)
    {
        setMonth(month);
        setDay(day);
        setYear(year);
    }

    /**
     * Date class copy constructor takes an 
     * argument of the class type Date. The 
     * purpose of this constructor is to 
     * assign the instance variables to 
     * the value passed into the parameter.
     * 
     * @param other
     */
    public Date(Date other)
    {
        this.month = other.month;
        this.day = other.day;
        this.year = other.year;
    }

    /**
     * getYear is a method that takes no arguments
     * and returns a value of type int. The purpose of this 
     * method is to return a value corresponding
     * to the year.
     */
    public int getYear()
    {
        return this.year;
    }

    /**
     * getMonth is a method that takes no arguments
     * and returns a value of type int. The purpose of this 
     * method is to return a value corresponding
     * to the month.
     */
    public int getMonth()
    {
        return this.month;
    }

    /**
     * getDay is a method that takes no arguments
     * and returns a value of type int. The purpose of this 
     * method is to return a value corresponding
     * to the day.
     */
    public int getDay()
    {
        return this.day;
    }

    /**
     * setYear is a method that takes an int argument 
     * corresponding to the year. The purpose of this
     * method is to ensure that the year is set to a 
     * valid value (which is between the years 2014 and
     * 2024).
     * 
     * @param year 
     */
    public void setYear(int year)
    {
        //If year is invalid
        if ((year < 2014) || (year > 2024)) 
        {
            System.out.println("Invalid year");   
            System.exit(0);
        } 
        //If year is valid
        else 
        {
            this.year = year;
        }
    }

    /**
     * setMonth is a method that takes an int argument 
     * corresponding to the month. The purpose of this
     * method is to ensure that the month is set to a 
     * valid value (which is between 1 and 12) and each 
     * month being exactly 31 days.
     * 
     * @param month
     */
    public void setMonth(int month)
    {
        //If the month is invalid 
        if (month < 1 || month > 12) 
        {
            System.out.println("Invalid month");
            System.exit(0);
        }
        //If month is valid 
        else
        {
            this.month = month;
        }
    }

    /**
     * setDay is a method that takes an int argument 
     * corresponding to the day. The purpose of this
     * method is to ensure that the day is set to a 
     * valid value (which is between 1 and 31).
     * 
     * @param day
     */
    public void setDay(int day)
    {
        //If the day is invalid 
        if ((day <= 1) || (day >= 31))
        {
            System.out.println("Invalid day");
            System.exit(0);
        } 
        //If day is valid
        else 
        {
            this.day = day;
        }
    }

    /**
     * isAfter is a method that takes an argument of 
     * type Date and returns a boolean value. The 
     * purpose of this method is to check if the 
     * compareTo date is after the date. If the 
     * compareTo date is after the date, then it 
     * returns true. 
     * 
     * @param compareTo
     */
    public boolean isAfter(Date compareTo)
    {
        if ((compareTo != null) || (compareTo instanceof Date == true))
        {
            if ((this.year < compareTo.year) || ((this.year == compareTo.year)
                && (this.month < compareTo.month)) || ((this.year == compareTo.year)
                && (this.day < compareTo.day)))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * equals is a method that takes an argument of 
     * type Object and returns a boolean value. 
     * The purpose of this method is to compare 
     * this date object to the other date object.
     * 
     * @param date
     */
    public boolean equals(Object date)
    {
        Date other = (Date) date;
        if ((other != null) || (other instanceof Date == true))
        {
            if ((this.month == other.month) && 
            (this.day == other.day) &&
            (this.year == other.year)) 
            {
                return true;
            }
        }
        return false;
    }

    /**
     * toString method does not take any arguments 
     * and returns a value of type String. The purpose 
     * of this method is to output the month, day,
     * and year.
     */
    public String toString()
    {
        if ((this.month < 10) && (this.day < 10))
        {
            return "0" + this.month + "/0" + this.day + "/" + this.year;
        }
        else if (this.day < 10)
        {
            return this.month + "/0" + this.day + "/" + this.year;
        }
        else if(this.month < 10)
        {
            return "0" + this.month + "/" + this.day + "/" + this.year;
        }
        else 
        {
            return this.month + "/" + this.day + "/" + this.year;
        }
    }
}