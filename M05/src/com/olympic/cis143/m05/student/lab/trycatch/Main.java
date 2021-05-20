package com.olympic.cis143.m05.student.lab.trycatch;

import javax.management.BadStringOperationException;

public class Main {

    public static void main (String[] a) throws BadStringOperationException, InterruptedException {
        Main main = new Main();
        main.testNeedsToBeModified();;
    }

    public void testNeedsToBeModified() {
    	try {
        	new ThrowsException().throwAnExceptionForMe();
    	} catch (MyException e) {
    		System.out.println("Exception caught.");
    		throw new RuntimeException();
    	}
    }
}
