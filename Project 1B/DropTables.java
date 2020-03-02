import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DropTables {
	
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
		
		String sql = "drop table minor;";
		stmt.executeUpdate(sql);
		
		sql = "drop table major;";
		stmt.executeUpdate(sql);
		
		sql = "drop table register;";
		stmt.executeUpdate(sql);
		
		sql = "drop table courses;";
		stmt.executeUpdate(sql);
		
		sql = "drop table degrees;";
		stmt.executeUpdate(sql);
		
		sql = "drop table departments;";
		stmt.executeUpdate(sql);
		
		sql = "drop table students;";
		stmt.executeUpdate(sql);
	}
}
