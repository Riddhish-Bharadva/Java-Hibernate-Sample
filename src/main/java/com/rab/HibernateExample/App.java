package com.rab.HibernateExample;

import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
    	DBOperations DBO = new DBOperations(); // Object of class DBOperations which contains all functions we can perform on DB using this application.
    	int exit = 0, Option = 0; // Initializing variables.
        System.out.println( "This application is an example of Hibernate." );
        while(exit != 1) // This will run unless user choose to exit program.
        {
           	System.out.println("Please choose transaction to perform from below:");
        	System.out.println("1. Insert single value into table.");
        	System.out.println("2. Update existing value from table.");
        	System.out.println("3. Display all values from table.");
        	System.out.println("4. Delete single value from table.");
        	System.out.println("5. Delete/Truncate all values from the table.");
        	System.out.println("6. Exit");
        	while(Option == 0) // While Option is 0, take input from user.
        	{
        		System.out.println("Enter appropriate option.");
            	@SuppressWarnings("resource")
				Scanner sc = new Scanner(System.in);
        		if(sc.hasNextInt())
        		{
        			Option = sc.nextInt();
        			if(Option<1 && Option>6)
        				Option = 0;
        		}
        	}
        	if(Option == 1) // Insert logic.
        	{
        		String WN=null, EI=null, P=null;
            	while(true)
            	{
            		System.out.println("Enter WebsiteName");
                	@SuppressWarnings("resource")
    				Scanner sc = new Scanner(System.in);
                	WN = sc.nextLine();
                	if(WN.length() != 0)
            		{
            			break;
            		}
            	}
            	while(true)
            	{
            		System.out.println("Enter Email Id");
                	@SuppressWarnings("resource")
    				Scanner sc = new Scanner(System.in);
        			EI = sc.nextLine();
            		if(EI.length() != 0)
            		{
            			break;
            		}
            	}
            	while(true)
            	{
            		System.out.println("Enter Password");
                	@SuppressWarnings("resource")
    				Scanner sc = new Scanner(System.in);
        			P = sc.nextLine();
            		if(P.length() != 0)
            		{
            			break;
            		}
            	}
        		System.out.println("Inserting value.");
        		DBO.InsertValue(WN, EI, P);
        		Option = 0;
        	}
        	else if(Option == 2) // Update logic.
        	{
        		int Id = 0;
        		String WN=null, EI=null, P=null;
            	while(true)
            	{
            		System.out.println("Enter Id for which you want to update value.");
                	@SuppressWarnings("resource")
    				Scanner sc = new Scanner(System.in);
            		if(sc.hasNextInt())
            		{
            			Id = sc.nextInt();
            			break;
            		}
            	}
            	while(true)
            	{
            		System.out.println("Enter new value for WebsiteName");
                	@SuppressWarnings("resource")
    				Scanner sc = new Scanner(System.in);
                	WN = sc.nextLine();
                	if(WN.length() != 0)
            		{
            			break;
            		}
            	}
            	while(true)
            	{
            		System.out.println("Enter new value for Email Id");
                	@SuppressWarnings("resource")
    				Scanner sc = new Scanner(System.in);
        			EI = sc.nextLine();
            		if(EI.length() != 0)
            		{
            			break;
            		}
            	}
            	while(true)
            	{
            		System.out.println("Enter new value for Password");
                	@SuppressWarnings("resource")
    				Scanner sc = new Scanner(System.in);
        			P = sc.nextLine();
            		if(P.length() != 0)
            		{
            			break;
            		}
            	}
        		System.out.println("Updating existing values for Id:"+Id);
        		DBO.UpdateValue(Id, WN, EI, P);
        		Option = 0;
        	}
        	else if(Option == 3) // Displaying all values.
        	{
        		DBO.DisplayValues();
        		Option = 0;
        	}
        	else if(Option == 4) // Delete single value logic.
        	{
        		int Id = 0;
            	while(true)
            	{
            		System.out.println("Enter Id to delete record.");
                	@SuppressWarnings("resource")
    				Scanner sc = new Scanner(System.in);
            		if(sc.hasNextInt())
            		{
            			Id = sc.nextInt();
            			break;
            		}
            	}
        		System.out.println("Deleting single value.");
        		DBO.DeleteValue(1, Id);
        		Option = 0;
        	}
        	else if(Option == 5) // Delete all values logic.
        	{
        		System.out.println("Deleting all values from table.");
        		DBO.DeleteValue(2, 0);
        		Option = 0;
        	}
        	else if(Option == 6) // Exit program logic.
        	{
        		System.out.println("Exiting program.");
        		exit = 1;
        		Option = 0;
        	}
        	else // In case none of above satisfies, handling logic.
        		Option = 0;
        	System.out.println("\n");
        }
    }
}
