package com.cg.details;

import java.util.*;

import java.sql.*;

public class OpenAccount extends Customer {
	
	
	List<Customer> list=new ArrayList<Customer>();
	
	public OpenAccount(String accno, String name, long balance) {
		super(accno, name, balance);
		// TODO Auto-generated constructor stub
	}
	
	public OpenAccount() {
		
	}
	
	Scanner KB=new Scanner(System.in);
	
	
	public Customer openAccount()
		{
			try {
				Connection mycon=DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb","root","SpyderSherlock@07");
				

				Customer cus=new Customer();
				
				//String sql="insert into bankdetails(AccountNo,Name,Balance)"
						//+ "values (?,?,?)";
				System.out.print("Enter Account No: ");
				cus.setAccno(KB.next());
				String acno=cus.getAccno();
				
				System.out.print("Enter Name: ");
				cus.setName(KB.next());
				String name=cus.getName();
				
				System.out.print("Enter Balance: ");
				cus.setBalance(KB.nextLong());
				Long bal=cus.getBalance();
				
				
				
				PreparedStatement scmt=mycon.prepareStatement("insert into bankdetails(AccountNo,Name,Balance)"
						+ "values (?,?,?)");
				
				scmt.setString(1,acno);
				scmt.setString(2,name);
				scmt.setLong(3,bal);
				
				list.add(cus);
				
			
				   scmt.executeUpdate();
				   System.out.println("One row inserted");
		         
				
				} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
			
			
		}

	
}


