package com.olympic.cis143.lab1.add;

public class IntArrayAdd {

    private int[] data;

    public IntArrayAdd() {
        this.data = new int[0];
    }

    public int[] getData() {
        return this.data;
    }

    /**
     * This method will need to add an element to the end of an array.
     *
     * @param value The value to be added.
     */
    public void add(int value)
    {
        int[] newArray = new int[this.data.length + 1];
        
        for(int n = 0; n < this.data.length; n++)
        {
        	newArray[n] = this.data[n];
        }
        
        newArray[this.data.length] = value;   
        this.data = newArray;
    }
}
