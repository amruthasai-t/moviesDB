package movies;
import java.sql.DriverManager;  
import java.sql.Connection;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.sql.Statement;  
public class selectingAllRows {
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
   
  
    public void selectAll(){  
        String sql = "SELECT * FROM MOVIES";  
          
        try {  
            Connection con = this.connect();  
            Statement stmt  = con.createStatement();  
            ResultSet rs    = stmt.executeQuery(sql);  
              
            // loop through the result set  
            while (rs.next()) {  
                System.out.println(rs.getString("name") +  "\t" +   
                                   rs.getString("ACTOR") + "\t" + 
                		           rs.getString("ACTRESS") +"\t"+
                                   rs.getString("DIRECTOR")+"\t"+
                                   rs.getDouble("YEAR_OF_RELEASE"));  
            }  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
    }
    public static void main(String[] args) {  
        selectingAllRows app = new selectingAllRows();  
        app.selectAll();  
    }  
}
