package com.dbConnection.DB_Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnection {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		  Statement stmt = null;
		  
		  //String myDriver = "com.mysql.jdbc.Driver";
	      String myUrl = "jdbc:mysql://129.150.192.243:3306/ojtool?useLegacyDatetimeCode=false&serverTimezone=IST";
	      String username= "root";
	      String password= "CapNAop2#d3vops";
	   Connection conn = DriverManager.getConnection(myUrl, username, password);
		  String buildID = null;
		
	   stmt = conn.createStatement();
	      String sql = "SELECT build_id FROM ojtool.tbl_build where test_completed='0' and (hpuft_test='1' or selenium='1' )ORDER BY build_id DESC LIMIT 1; ";
	     ResultSet rst= stmt.executeQuery(sql);
	      while(rst.next()) {
	    	buildID=rst.getString(1);
	    	//System.out.println(rst.getString(2));
	    	
	      }
	     

	      System.out.println("Test Execution for build number "+"JSP_BUILD_"+buildID);
	      stmt.close();
	      int buildid=Integer.parseInt(buildID);
	      PreparedStatement updateEXP = conn.prepareStatement("UPDATE ojtool.tbl_build SET test_completed=1 where build_id= '"+buildid+"' ");

	     // updateEXP.setString(1, buildID);
	      
	      updateEXP.executeUpdate();
	       
	      
		      conn.close();
	}

}
