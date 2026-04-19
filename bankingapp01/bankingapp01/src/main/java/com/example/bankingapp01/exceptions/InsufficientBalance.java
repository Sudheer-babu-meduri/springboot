package com.example.bankingapp01.exceptions;

public class InsufficientBalance extends RuntimeException{

	public InsufficientBalance(String s){
		super(s);
	}
}
