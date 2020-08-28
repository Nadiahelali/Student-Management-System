import java.sql.*;
import javax.swing.*;
public class studentinfo {
		Connection a=null;
		public static Connection conector(){
			try{
				Class.forName("org.sqlite.JDBC");
				Connection a=DriverManager.getConnection("jdbc:sqlite:studentinformation.sqlite");
				//sJOptionPane.showMessageDialog(null, "connection successful");
				return a;
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, e);
				return null;
			}

			
		}

	}