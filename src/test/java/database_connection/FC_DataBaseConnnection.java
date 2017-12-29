package database_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FC_DataBaseConnnection
{
	public static String GET_UID() throws SQLException
	{
		String dbURL = "jdbc:sqlserver://127.0.0.1:1433;databaseName=dummy_data";
		String username = "sa";
	    String password = "sa";
	    String selectQuery = "select  *  from [dbo].[LogIN]";
	    
	    Connection con = DriverManager.getConnection(dbURL,username,password);
    	Statement stmt = con.createStatement();
    	
    	ResultSet rs = stmt.executeQuery(selectQuery);
    	
    	String UID = null;
    	
    	while(rs.next())
    	{
    		//UID = rs.getString("UID").concat("-").concat(rs.getString("PASS"));
    		UID = rs.getString("UID");
    	}
    	con.close();
    	
    	return UID;
	}
	public static String GET_PASS() throws SQLException
	{
		String dbURL = "jdbc:sqlserver://127.0.0.1:1433;databaseName=dummy_data";
		String username = "sa";
	    String password = "sa";
	    String selectQuery = "select  *  from [dbo].[LogIN]";
	    
	    Connection con = DriverManager.getConnection(dbURL,username,password);
    	Statement stmt = con.createStatement();
    	
    	ResultSet rs = stmt.executeQuery(selectQuery);
    	
    	String PASS = null;
    	
    	while(rs.next())
    	{
    		PASS = rs.getString("PASS");
    	}
    	con.close();
    	
    	return PASS;
	}

}
