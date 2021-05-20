package com.olympic.cis143.m05.student.lab.trycatch;

public class MyException extends Exception {
	
	public MyException(String mess, Throwable t) {
		super(mess, t);
	}
}
