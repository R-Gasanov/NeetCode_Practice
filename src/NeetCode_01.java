
//import java.util.ArrayList;

class DynamicArray {
	
	public int DynmArray[]; // We are declaring an arraylist to be used throughout the applcation
	public int given_capacity;
	public int current_size = 0;

    public DynamicArray(int capacity) 
    {
        if (capacity > 0)
        { 
        	given_capacity = capacity; // Here, we are storing the size of the capacity
            DynmArray = new int[capacity]; // Here we are assigning the capacity      
        }
    }

    public int get(int i) 
    {
    	return DynmArray[i];
		
    }

    public void set(int i, int n) 
    {
    	DynmArray[i] = n; // Here we are assigning the specific element to a new value
    }

    public void pushback(int n) 
    {
    	if (current_size == given_capacity)
    	{
    		resize();
    	}
    	
    	DynmArray[current_size] = n;
    	current_size++;
    	
 
    }

    public int popback() 
    {
    	if (current_size > 0)
    	{
    		current_size--;
    	}
    	return DynmArray[current_size];
    }

    private void resize() 
    {
        given_capacity *= 2;
        int[] doubledArray = new int[given_capacity];
        for (int index = 0; index < current_size; index++)
        {
            doubledArray[index] = DynmArray[index];
        }
    	DynmArray = doubledArray;
    }

    public int getSize() 
    {
        return current_size;
    }

    public int getCapacity() 
    { // We made a global variable where it'll essentially be used to show the capacity provided
    	return given_capacity;
    }
}