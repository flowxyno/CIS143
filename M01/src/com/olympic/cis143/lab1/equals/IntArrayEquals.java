package com.olympic.cis143.lab1.equals;

public class IntArrayEquals {

    private int[] data;

    public IntArrayEquals(int[] values) {
        if (values == null) {
            throw new RuntimeException("Values passed cannot be null");
        }
        this.data = values;
    }

    /**
     * This method will return false if the array:
     * 1. is null
     * 2. Arrays have different lengths
     * 3. Data within the array is not the same and in the same order
     *
     * If the above conditions are true, the method returns true.
     * @param compareMe The integer array to compare the internal array with.
     * @return True if equal else false.
     */
    public boolean equals(int[] compareMe) 
    {
       if(compareMe == null)
       {
    	   return false;
       }
       if(this.data.length != compareMe.length)
       {
    	   return false;
       }
       for(int n = 0; n < this.data.length; n++)
       {
    	   if(this.data[n] != compareMe[n])
    	   {
    		   return false;
    	   }
       }
    	return true;
    }
}
