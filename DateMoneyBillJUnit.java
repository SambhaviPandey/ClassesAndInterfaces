/*
 * JUnit tests for Date, Money, and Bill classes
 * @author Lesley Kalmin
 *  CSS162
 */
import static org.junit.Assert.*;
import org.junit.Test;
/**
 * class DateMoneyBillJUnit includes the 
 * JUnit tests of Money,Date, and Bill classes.
 * @author (Lesley Kalmin)
 * @author (Sambhavi Pandey)
 * @version (Last modified on April 26, 2018)
 */
public class DateMoneyBillJUnit {
    @Test
    /**
     * Written by Lesley Kalmin. 
     * Testing overloaded constructor in the 
     * class Money.
     */
    public void ConstructMoneyTest() 
    {
        Money money1 = new Money(10);
        assertEquals(10, money1.getDollars());		
    }

    @Test
    /**
     * Written by Lesley Kalmin. 
     * Testing setMoney method in the money class.
     */
    public void SetMoneyTest()
    {
        Money money1 = new Money();
        money1.setMoney(30,50);
        assertEquals(30, money1.getDollars());      
        assertEquals(50, money1.getCents());
    }

    @Test
    /**
     * Written by Lesley Kalmin
     * Testing copy constructor in the Money
     * class.
     */
    public void ConstructMoneyCopyTest() 
    {
        Money money1 = new Money();
        money1.setMoney(10,40);		
        Money money2 = new Money(money1);
        assertEquals(10, money1.getDollars());       
        assertEquals(40, money2.getCents());
    }

    @Test
    /**
     * Written by Lesley Kalmin.
     * Testing toString method in Money class.
     */
    public void PrintMoneyTest()
    {
        Money money1 = new Money(10);
        money1.setMoney(30,50);
        assertEquals("$30.50", money1.toString());
    }

    @Test
    /**
     * Written by Sambhavi Pandey.
     * Testing the equals method in the Money class.
     */
    public void equalsTest()
    {
        //Creating objects needed for test
        Money money1 = new Money(100);
        Money money2 = new Money(100);
        Money money3 = new Money(200);
        //Testing
        assertEquals(money1, money2);
        assertNotEquals(money1, money3);
    }

    @Test
    /**
     * Written by Sambhavi Pandey
     * Testing if the cents are greater than 
     * 99.
     */
    public void centsTest()
    {
        //Creating object needed for test
        Money money = new Money(1, 100);
        //Testing
        assertEquals("$2.00", money.toString());		
    }

    @Test
    /**
     * Written by Sambhavi Pandey.
     * Test for the Date constructor.
     */
    public void dateTest()
    {
        //Creating object needed for test
        Date date = new Date(03,13,2018);
        //Testing
        assertEquals(date.toString(),"03/13/2018");
    }

    @Test
    /**
     * Written by Sambhavi Pandey.
     * Tests the copy constructor in the Date class.
     */
    public void copyConstructorTest()
    {
        //Creating objects needed for test
        Date date1 = new Date(6,16,2017);
        Date date2 = new Date(date1);
        //Test
        assertEquals(date1, date2);
    }

    /**
     * Written by Sambhavi Pandey
     * Test for setOriginator method in the Bill class.
     */
    @Test 
    public void setOriginatorTest() {
        //Creating object
        Bill b = new Bill(); 
        //Method call
        b.setOriginator("Tracy");
        //Test
        assertEquals("Tracy",b.getOriginator());
    }
}