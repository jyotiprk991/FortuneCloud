package database_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class database_connection {
	
	public static void main(String[] args) throws Exception 
	{

		String dbURL = "jdbc:sqlserver://127.0.0.1:1433;databaseName=dummy_data";
		String username = "sa";
	    String password = "sa";
	    String selectQuery = "select  *  from [dbo].[LogIN]";
	    
	    Connection con = DriverManager.getConnection(dbURL,username,password);
    	Statement stmt = con.createStatement();
    	
    	ResultSet rs = stmt.executeQuery(selectQuery);
    	
    	ResultSetMetaData rsmd = rs.getMetaData();
    
    	int columnsNumber = rsmd.getColumnCount();
    	
    	System.out.println(columnsNumber);
    	
    	while(rs.next())
    	{
    		for(int i = 1 ; i <= columnsNumber; i++)
    		{
    			 System.out.print(rs.getString(i) + " ");
    		}
    		System.out.println();
    	}
    	con.close();
	}
	

}
