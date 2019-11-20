import java.util.Iterator;
/**
 * class ArrayList creates an ArrayList 
 * and methods that store, remove, and 
 * print objects, determine if the array 
 * is empty, resize the array, and determine the  
 * index of an object in the ArrayList.
 * Additionally, this class contains an equals 
 * method and a toString method. This class 
 * also implements the Iterable interface. 
 * 
 * @author (Sambhavi Pandey)
 * @version (Last modified May 17, 2018)
 */
public class ArrayList implements Iterable
{
    //Declaring instance variables
    Object[] array;
    //Tracks live objects in array 
    private int numberOfElements;

    /**
     * An ArrayList constructor that takes no arguments.
     * It's purpose is to initialize the instance
     * variables. 
     */
    public ArrayList() 
    {
        // Initializing
        array = new Object[100];
        numberOfElements = 0;
    }

    /**
     * insert method is a void method that takes
     * two arguments, one of type Object and one of 
     * type int. The purpose of this method is to 
     * add an object at the specified index. 
     * 
     * @param o
     * @param index
     */
    public void insert(Object o, int index) 
    {
        //checks if the index is valid 
        if (index > numberOfElements) 
        {
            System.out.println("Index Out of Bounds");
        }
        //Checks if the object is valid 
        if (o != null) 
        {
            //Checks if it needs to be resized 
            if (index == numberOfElements) 
            {
                //methods that resizes 
                resize();
            }
            //If it is valid, then space for the object is created
            System.arraycopy(array, index, array, 
                index + 1, array.length - 1 - index);
            //Parameter value is assigned to array at an index 
            array[index] = o;
            //Increases count of live objects 
            numberOfElements++;
        }
        //If object is not valid 
        else 
        {
            System.out.println("Not valid");
        }
    }

    /**
     * remove method is a method that takes an int 
     * argument and returns a value of type Object.
     * The purpose of this method is to remove and 
     * return the object at a specified index.
     * 
     * @param index 
     */
    public Object remove(int index) 
    {
        //Checks if the index is greater than the 
        //number of elements in array - in order to 
        //determine if it is a valid index 
        if (index >= numberOfElements) {
            System.out.println("Index Out of Bounds");
            return null;
        }
        //Passing element from array at index to a new 
        //Object type
        Object obj = array[index];
        //Decreases live object count 
        numberOfElements--;
        //Array size is adjusted 
        System.arraycopy(array, index + 1, 
            array, index, numberOfElements - index);
        return obj;
    }

    /**
     * size method is a method that takes no arguments and 
     * returns a value of type int. The purpose of this method 
     * is to check the size of the ArrayList. 
     */
    public int size() 
    {
        return numberOfElements;
    }

    /**
     * isEmpty is a method that takes no arguments and 
     * returns a value of type boolean. The purpose of 
     * this method is to check if the ArrayList is empty.
     */
    public boolean isEmpty() 
    {
        //Goes through the array 
        for (int i = 0; i < numberOfElements; i++) 
        {
            //Determines if the array contains objects 
            if (array[i] != null) 
            {
                return false;
            }
        }
        return true;
    }

    /**
     * indexOf is a method that takes an argument 
     * corresponding to the Object class and returns
     * an int value. The purpose of this method is 
     * to determine the index of the object and 
     * return -1 if the index is not found.
     * 
     * @param o
     */
    public int indexOf(Object o) 
    {
        int index = -1;
        //Going through the array 
        for (int i = 0; i < numberOfElements; i++) 
        {
            //Determines if the elemenets in the array are
            //equal and if the object is passed 
            if (array[i].equals(o)) 
            {
                //index is set to i (of the loop)
                index = i;
            }
        }
        return index;
    }

    /**
     * equals is a method that takes an argument of the 
     * Object class and returns a boolean value. The purpose 
     * of this method is to compare sizes and elements in the
     * data structure.
     * 
     * @param obj
     */
    public boolean equals(Object o) 
    {
        boolean check = false;
        //determining if the object passed in is valid 
        if ((o != null) && (o instanceof ArrayList == true)) 
        {
            //type-cast 
            ArrayList object = (ArrayList) o;
            //determines if the array size is equivalent 
            if (this.array.length == object.array.length) 
            {
                //Goes through the array 
                for (int i = 0; i < numberOfElements; i++) 
                {
                    //Determines if the arrays are equal 
                    if (this.array[i].equals(object.array[i])) 
                    {
                        check = true;
                    } 
                    //If the array is not equal 
                    else 
                    {
                        check = false;
                        break;
                    }
                }
            }
        }
        return check;
    }

    /**
     * get is a method that takes an int value and 
     * returns a value of type Object. The purpose 
     * of this method is to return the object at the 
     * specified index. 
     * 
     * @param index
     */
    public Object get(int index) 
    {
        //Checks if the index is greater than the 
        //number of elements in array - in order to 
        //determine if it is a valid index 
        if (index > numberOfElements) 
        {
            System.out.println("Index Out of Bounds");
            return null;
        }
        return array[index];
    }

    /**
     * resize method increases the size of the
     * ArrayList by doubling it if the ArrayList 
     * is full. 
     */
    private void resize() 
    {
        //increases the size of the array by doubling it
        Object[] arr = new Object[array.length * 2];
        //copies old array into new array
        System.arraycopy(array, 0, arr, 0, array.length);
        array = arr;
    }

    /**
     * toString is a method that takes no arguments 
     * and returns a value of type String. The purpose of 
     * this method is to print the array after determining 
     * if each element in the array is valid. 
     */
    public String toString() 
    {
        String s = "";
        //prints array
        for (int i = 0; i < numberOfElements; i++) 
        {
            //Determines if the array is valid 
            if (array[i] == null)
            {
                continue;
            }
            //if it is the last element then array is printed
            else if (i == (numberOfElements - 1)) 
            {
                s = s + array[i];
            }
            //if it is not the last element of the array
            else 
            {
                s = s + array[i] + " ";
            }
        }
        return s;
    }

    /**
     * This interface is utilized to traverse/iterate
     * through the ArrayList.
     */
    @Override
    public Iterator<Object> iterator()
    {
        return new Iter();
    }

    //This class is created to implement the Iterator 
    private class Iter implements Iterator <Object>
    {
        //Declaring variable 
        int index;
        /**
         * No-argument constructor utilized to 
         * intialize the variable. 
         */
        public Iter()
        {
            index = 0;
        }

        /**
         * hasNext method returns a value of 
         * type boolean. The purpose of this 
         * method is to determine if the 
         * ArrayList contains another element. 
         */
        public boolean hasNext()
        {
            //If it does contain another element 
            if (this.index < size())
            {
                return true;
            }
            //Does not contain another element 
            else
            {
                return false; 
            }
        }
        
        /**
         * next method returns a value of type 
         * Object. The purpose of this method 
         * is to return the next value in the 
         * ArrayList.
         */
        public Object next()
        {
            //If there is a next value 
            if (hasNext() == true)
            {
                return array[this.index++];
            }
            //If there are no more elements 
            else
            {
                return null;
            }
        }
    }
}
