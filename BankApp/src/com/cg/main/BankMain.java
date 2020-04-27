package com.cg.main;



import java.sql.*;
import java.util.*;
import com.cg.details.*;

 

public class BankMain {

 

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        try {
            Connection mycon=DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb","root","ikram786md");
            Scanner KB=new Scanner(System.in);
            
            PreparedStatement scmt=mycon.prepareStatement("select * from bankdetails");
            ResultSet rs=null;
            
            
            int ch;
            do
            {
                System.out.println("Main Menu");
                System.out.println("1.Open Account");
                System.out.println("2.Display All");
                System.out.println("3.checkBalance");
                System.out.println("4.Deposit");
                System.out.println("5.Withdrawal");
                System.out.println("6.Exit");    
                        
                System.out.println("Ur Choice :");
                ch=KB.nextInt();
                switch(ch)
                { 
                    
                  
                case 1:
                    OpenAccount oa=new OpenAccount();
                    oa.openAccount();
                    
                    //scmt.executeUpdate(sql)
                    break;
                    
                
                
                
                    case 2:
                         rs= scmt.executeQuery();
                         while(rs.next()) {
                                
                                String name=rs.getString("Name");
                                String acno=rs.getString("AccountNo");
                                long bal=rs.getLong("Balance");
                                
                                System.out.printf("%s,%s,%d",name,acno,bal);
                                System.out.println();
                            }
                        
                        break;

 

                    /*case 3:
                        System.out.print("Enter Account No U Want to Search...: ");
                        String acn=KB.next();
                        boolean found=false;
                        for(int i=0;i<C.length;i++)
                        {  
                            found=C[i].search(acn);
                            if(found)
                            {
                                break;
                            }
                        }
                        if(!found)
                        {
                            System.out.println("Search Failed..Account Not Exist..");
                        }
                        break;*/

 

                    case 4:
                        Transaction tr=new Transaction();
                        tr.deposit();
                        break;

 

                        //method for withdrawl
                    /*case 5:
                        System.out.print("Enter Account No : ");
                        acn=KB.next();
                        found=false;
                        for(int i=0;i<C.length;i++)
                        {  
                            found=C[i].search(acn);
                            if(found)
                            {
                                C[i].withdrawal();
                                break;
                            }
                        }
                        if(!found)
                        {
                            System.out.println("Search Failed..Account Not Exist..");
                        }
                        break;*/

 

                    case 6:
                        System.out.println("Good Bye..");
                        break;
                }
            }
            while(ch!=6);

 

        }
        catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
        

 

    }

 

}
 