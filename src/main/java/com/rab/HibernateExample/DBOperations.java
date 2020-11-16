package com.rab.HibernateExample;

import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DBOperations {
	SessionFactory SF;
	Session session;
// Below is method to start DB Transaction.
    private Transaction StartTransaction(Object DBPT)
    {
        Configuration config = new Configuration().configure().addAnnotatedClass(DBPasswordTable.class);
        SF = config.buildSessionFactory();
        session = SF.openSession();
        Transaction tx = session.beginTransaction();
        return tx;
    }
// Below is method to end already started session.
    private void EndTransaction()
    {
    	session.close();
    	SF.close();
    }
    public void InsertValue(String WN, String EI, String P)
    {
    	DBPasswordTable DBPT = new DBPasswordTable();
    	DBPT.setWebsiteName(WN);
    	DBPT.setEmailId(EI);
    	DBPT.setPassword(P);
    	try
    	{
        	Transaction t = StartTransaction(DBPT);
            session.save(DBPT);
        	t.commit();
        	EndTransaction();
        	System.out.println("Data has been successfully inserted into Database.");
    	}
    	catch(Exception e)
    	{
    		System.out.println("Cannot insert data. Exception occurred while performing this operation on Database: "+e);
    	}
    }
    public void UpdateValue(int Id, String WN, String EI, String P)
    {
    	DBPasswordTable DBPT = new DBPasswordTable();
    	DBPT.setId(Id);
    	DBPT.setWebsiteName(WN);
    	DBPT.setEmailId(EI);
    	DBPT.setPassword(P);
    	try
    	{
        	Transaction t = StartTransaction(DBPT);
        	session.update(DBPT);
        	t.commit();
        	EndTransaction();
        	System.out.println("Data has been successfully updated in Database.");
    	}
    	catch(Exception e)
    	{
    		System.out.println("Cannot update data. Exception occurred while performing this operation on Database: "+e);
    	}
    }
    public void DisplayValues()
    {
    	try
    	{
    		System.out.println("Displaying all values.");
    		DBPasswordTable DBPT = new DBPasswordTable();
    		StartTransaction(DBPT);
    		Query q = session.createQuery("from DBPasswordTable"); // Here I am using HQL (Hibernate Query Language) to fetch all the records from DB.
			@SuppressWarnings("unchecked")
			List <DBPasswordTable> DBPTList = q.getResultList();
    		for(int i=0; i<DBPTList.size(); i++)
    		{
    			System.out.println(DBPTList.get(i).toString());
    		}
        	EndTransaction();
        	System.out.println("End of values.");
    	}
    	catch(Exception e)
    	{
    		System.out.println("Cannot display values. Exception occurred while performing this operation on Database: "+e);
    	}
    }
    public void DeleteValue(int Option, int Id)
    {
    	try
    	{
        	if(Option == 1)
        	{
            	DBPasswordTable DBPT = new DBPasswordTable();
            	DBPT.setId(Id);
            	Transaction t = StartTransaction(DBPT);
            	session.delete(DBPT);
            	t.commit();
            	EndTransaction();
            	System.out.println("Data has been successfully deleted from Database.");
        	}
        	else
        	{
        		DBPasswordTable DBPT = new DBPasswordTable();
        		Transaction t = StartTransaction(DBPT);
        		Query q = session.createNativeQuery("Truncate table Password");
        		q.executeUpdate();
        		t.commit();
        		EndTransaction();
        	    System.out.println("Database has been successfully truncated.");
        	}
    	}
    	catch(Exception e)
    	{
    		System.out.println("Cannot delete data. Exception occurred while performing this operation on Database: "+e);
    	}
    }
}
