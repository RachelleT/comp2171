import java.sql.*;
import javax.swing.*;

public class sqlConnection {
	Connection conn = null;
	public static Connection dbConnector(){
		try{
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\rache\\Downloads\\Year 2\\Semester 2\\COMP2171\\Final Presentation\\ELR.db");
			JOptionPane.showMessageDialog(null, "Connection Successful!");
			return conn;
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
}
