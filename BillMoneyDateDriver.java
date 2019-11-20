/** 
 * HW3.java: Simple driver to test all the methods in the
 * Money, Date, and Bill classes in order to ensure that 
 * they work properly. 
 * @author Rob Nash, borrowed from cfolsen
 * @author Sambhavi Pandey
 * @version (Last modified on April 26, 2018)
 */
public class BillMoneyDateDriver
{
    /** 
     * The main method tests the Money, Date, and
     * Bill class to ensure that they are working 
     * properly. 
     */
    public static void main(String[] args)
    {
        //Construct some money
        System.out.println("Tests for Money class:");

        //testing the constructor and copy constructor 
        Money money1 = new Money(10);
        Money money2 = new Money(money1);
        
        //equals method test in Money class
        System.out.println("Equal: " + money1.equals(money2));

        //testing setMoney method and reduction of cents in Money class
        money1.setMoney(20,400);
        //testing equals method
        System.out.println("Equal: " + money1.equals(money2));

        //testing no-argument constructor
        Money money3 = new Money();
        //testing overloaded add method
        money3.add(3);

        //no-args constructor test 
        Money money4 = new Money();
        //testing overloaded add method
        money4.add(money3);
        //testing the equals method
        System.out.println("Equal: " + money3.equals(money4));

        //test for getter methods 
        System.out.println("Dollars (money1):" + money1.getDollars());
        System.out.println("Cents (money1): " + money1.getCents());
        System.out.println("money2 (double): " + money2.getMoney());

        //Testing invalid money 
        //Money money5 = new Money(-5,45);
        
        //no-args constructor test
        Money money5 = new Money();
        
        //testing overloaded add method
        money5.add(24, 99);

        //testing toString method 
        System.out.println("Printing money:");
        System.out.println(money1.toString());
        System.out.println(money2.toString());
        System.out.println(money3.toString());
        System.out.println(money4.toString());
        System.out.println(money5.toString());
        System.out.println();//space between outputs

        //Construct some dates
        System.out.println("Tests for Date class:");

        //Test for constructor and copy constructor
        Date date1 = new Date(11,12,2017);
        Date date2 = new Date(date1);
        
        //equals method test
        System.out.println("Equal: " + date1.equals(date2));

        //no-arg constructor test
        Date date3 = new Date();
        
        //setter method test
        date3.setMonth(2);
        date3.setDay(4);
        date3.setYear(2019);

        //Testing invalid dates
        //Date date4 = new Date(-3,9,2001);
        
        //testing no-args constructor
        Date date4 = new Date();

        //testing getter methods
        System.out.println("Month (date3): " + date3.getMonth());
        System.out.println("Day (date3): " + date3.getDay());
        System.out.println("Year (date3): " + date3.getYear());
        System.out.println();//blank line between outputs

        //testing isAfter method
        System.out.println("date2 is after date3: " + date2.isAfter(date3));
        System.out.println("date4 is after date1: " + date4.isAfter(date1));

        //testing the toString method in Date class
        System.out.println("Printing dates: ");
        System.out.println(date1.toString());
        System.out.println(date2.toString());
        System.out.println(date3.toString());
        System.out.println(date4.toString());
        System.out.println();//space between outputs

        //Construct some bills
        System.out.println("Tests for Bill class:");

        //Initializing 
        Money amount = new Money(20);
        Date dueDate = new Date(5, 30, 2020);
        
        //Test for constructor
        Bill bill1 = new Bill(amount, dueDate, "the electric company");
        
        //testing isPaid method
        bill1.setPaid(date1);
        
        //testing Bill class constructor 
        Bill bill3 = new Bill(amount, dueDate, "the phone company");

        //testing setter methods
        //bill2.setDueDate(new Date(6, 29, 2021));
        amount.setMoney(44, 78);
        dueDate.setDay(28);

        //testing no-args constructor
        Bill bill4 = new Bill();
        
        //testing setter methods 
        bill4.setAmount(money1);
        bill4.setDueDate(date2);
        bill4.setOriginator("Jamba Juice");
        bill4.setPaid(date3);

        //testing getter methods
        System.out.println("Amount (bill2): " + bill3.getAmount());
        System.out.println("Due Date (bill2): " + bill3.getDueDate());
        System.out.println("Originator (bill2): " + bill4.getOriginator());
        
        //testing isPaid method
        System.out.println("Paid: " + bill3.isPaid());
        System.out.println();//blank line between outputs

        //testing toString method in the Bill class
        System.out.println("Printing Bills:");
        System.out.println(bill1.toString());
        System.out.println(bill3.toString());
        System.out.println(bill3.toString());
        System.out.println(bill4.toString());
    }
}