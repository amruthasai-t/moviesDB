package movies;

import java.sql.Connection;
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.SQLException;  
public class insertingData {

    

	private Connection connect() {  
        // SQLite connection string  
        String url = "jdbc:sqlite:/C:\\sqlite\\sqlite-tools-win32-x86-3390200\\movies.db";  
        Connection con = null;  
        try {  
            con = DriverManager.getConnection(url);  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
        return con;  
    }  
   
  
    public void insert(String name, String ACTOR, String ACTRESS, String DIRECTOR, double yearofrelease) {  
        String sql = "INSERT INTO MOVIES(NAME, ACTOR, ACTRESS, DIRECTOR, YEAR_OF_RELEASE) VALUES(?,?,?,?,?)";  
   
        try{  
            Connection con = this.connect();  
            PreparedStatement pstmt = con.prepareStatement(sql);  
            pstmt.setString(1, name);  
            pstmt.setString(2, ACTOR);
            pstmt.setString(3, ACTRESS);
            pstmt.setString(4, DIRECTOR);
            pstmt.setDouble(5, yearofrelease);
            pstmt.executeUpdate();  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
}

    public static void main(String[] args) {  
    	   
        insertingData app = new insertingData();    
        app.insert("Titanic", "Leonardo Dicaprio","Kate Winslet","James Cameron",1997);
        app.insert("Avatar","Sam Worthington", "Zoe Saldana", "James Cameron", 2009 );  
        app.insert("RRR","Ram Charan", "Alia Bhatt", "Rajamouli", 2022 );  
        app.insert("3 Idiots","Aamir Khan","Kareena Kapoor","Rajkumar Hirani",2009);
        app.insert("Geetha Govindam", "Vijay Devarakonda", "Rashmika Mandanna", "Parasuram", 2018);
    }  
}