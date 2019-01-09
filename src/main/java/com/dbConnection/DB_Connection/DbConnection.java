package com.dbConnection.DB_Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnection {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		  Statement stmt = null;
		  
		  //String myDriver = "com.mysql.jdbc.Driver";
	      String myUrl = "jdbc:mysql://localhost:3306/ojtool?useLegacyDatetimeCode=false&serverTimezone=IST";
	      String username= "root";
	      String password= "CapNAop2#d3vops";
	   Connection conn = DriverManager.getConnection(myUrl, username, password);
		  
		
	   stmt = conn.createStatement();
	      String sql = "select build_id,qa_schedule_time from tbl_build where promote_to_qa=1";
	     ResultSet rst= stmt.executeQuery(sql);
	      while(rst.next()) {
	    	System.out.println(rst.getString(1));
	    	System.out.println(rst.getString(2));
	    	
	      }
	      stmt.close();
	      conn.close();

	}

}
