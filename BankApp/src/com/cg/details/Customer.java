package com.cg.details;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.sql.*;

public class Customer {
	
	
	private String accno,name;
	private long balance;
    
	
	public Customer(String accno, String name, long balance) {
		super();
		this.accno = accno;
		this.name = name;
		this.balance = balance;
	}
	public Customer() {
		
	}

	
	//getters and setters

	public void setAccno(String accno) {
		 this.accno = accno;
	}
	public String getAccno() {
		return accno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}
	public String toString() {
		return accno +" "+balance+" "+name;
		
	}
	


	

}