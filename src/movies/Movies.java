package movies;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Movies {

	public static void createTable() {
       String jdbcUrl="jdbc:sqlite:/C:\\sqlite\\sqlite-tools-win32-x86-3390200\\movies.db";
       //Connecting to SQLite and creating movies table
       try {
       Connection con=DriverManager.getConnection(jdbcUrl);
       String sql="CREATE TABLE MOVIES"+
       "(NAME TEXT NOT NULL,"+
    	"ACTOR TEXT NOT NULL,"+
       "ACTRESS TEXT NOT NULL,"+
    	"DIRECTOR TEXT NOT NULL,"+
       "YEAR_OF_RELEASE INT)";
       Statement stmt=con.createStatement();
       stmt.executeQuery(sql);
       
       stmt.close();
       con.close();
       
       }catch(SQLException e) {
    	   System.out.println("Error connecting to SQLite Database");
    	   e.printStackTrace();
       }
	}
	public static void main(String args[]) {
		createTable();
	}

}
