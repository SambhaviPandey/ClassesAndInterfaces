/**
 * class ExpenseAccount extends ArrayList.
 *
 * @author (Sambhavi Pandey)
 * @version (Last modified May 17, 2018)
 */
public class ExpenseAccount extends ArrayList
{
    /**
     * insert method calls super and takes 
     * two arguments corresponding to the 
     * index and the Bill. 
     * 
     * @param object 
     * @param index
     */
    public void insert (Bill object, int index)
    {
        super.insert(object, index);
    }
    
    /**
     * get method returns a value of 
     * type bill and takes one argument 
     * corresponding to the index. 
     * 
     * @param index
     */
    public Bill get (int index)
    {
        return (Bill) (super.get(index));
    }
}
