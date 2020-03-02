import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ModifyRecords {
	
	private static Connection connect = null;

	public static void main(String[] args) throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Set up connection parameters
			String userName = "coms363";
			String password = "password";
			String dbServer = "jdbc:mysql://localhost:3306/coms363";
			// Set up connection
			connect = DriverManager.getConnection(dbServer, userName, password);
		} catch (Exception e) {
		}
		
		Statement stmt = null;
		stmt = connect.createStatement();
		
		String sql = "update students " + 
				"set name = 'Scott'" + 
				"where ssn = '746897816';";
		stmt.executeUpdate(sql);
		
		
		sql = "update major " + 
				"set name = 'Computer Science', level = 'MS'" + 
				"where snum = (select snum from students where ssn = '746897816');";
		stmt.executeUpdate(sql);
		
		
		sql = "delete from register " + 
				"where regtime = 'Spring2015';";
		//System.out.println(sql);
		stmt.executeUpdate(sql);
		
		
	}
}
