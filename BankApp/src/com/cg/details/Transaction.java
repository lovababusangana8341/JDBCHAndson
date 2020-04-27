package com.cg.details;

import java.sql.*;

import java.util.Scanner;

//import com.mysql.cj.jdbc.PreparedStatement;

public class Transaction extends OpenAccount{
	
	
	String act;
	long bal;
	public Transaction(String accno, String name, long balance) {
		super(accno, name, balance);
		// TODO Auto-generated constructor stub
	}
	public Transaction() {
		
	}

	Scanner KB=new Scanner(System.in);
	Customer cus=new Customer();
	

	//method to deposit money
	public void deposit()
	{
		
		try {
			Connection mycon=DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb","root","SpyderSherlock@07");
		
			java.sql.PreparedStatement stmt=mycon.prepareStatement("select Balance from bankdetails "
					+ "where AccountNo=? ");
			
			PreparedStatement stmt1=(PreparedStatement) mycon.prepareStatement("select AccountNo from bankdetails where AccountNo=?");
			
			System.out.println("Enter your account no");
			String acno=KB.next();
			
			
			
			stmt1.setString(1,acno);
			
			ResultSet rs1=stmt1.executeQuery();
			while(rs1.next()) {
			 act=rs1.getString("AccountNo");
			}
			//System.out.printf("%s",act);
			
			if(acno.equals(act)) {
				
				long amt;
				System.out.println("Enter Amount U Want to Deposit : ");
				amt=KB.nextLong();
				
				stmt.setString(1,acno);
				
				ResultSet rs2=stmt.executeQuery();
				
				while(rs2.next()) {
				bal=rs2.getLong("Balance");
				
				}
				amt=amt+bal;
				//System.out.printf("%d",amt);
				//System.out.println();
				
				PreparedStatement stmt2=(PreparedStatement) mycon.prepareStatement("update bankdetails set Balance=? where AccountNo=?");
				
				stmt2.setLong(1,amt);
				stmt2.setString(2,acno);
				stmt2.executeUpdate();
				
				System.out.println("////////////////////////Update done////////////////////");
				
			}
		    
			
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	/*method to withdraw money
	public void withdrawal()
	{
		long amt;
		System.out.println("Enter Amount U Want to withdraw : ");
		amt=KB.nextLong();
		if(getBalance()>=amt)
		{ 
			balance=balance-amt;
		}
		else
		{
			System.out.println("Less Balance..Transaction Failed..");
		}
	}

	//method to search an account number
	public boolean search(String acn)
	{ 
		if(getAccno().equals(acn))
		{ 
			//showAccount();
			return(true);
		}
		return(false);
	}*/
	

}