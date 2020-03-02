import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Query {

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
		
		ResultSet resultSet = null;
		Statement stmt = null;
		String sqlQuery = "";
		String outputString = "";
		
		//Query 1
		sqlQuery = "SELECT * FROM students " + 
				"WHERE students.name = 'Becky';";
		stmt = connect.createStatement();
		resultSet = stmt.executeQuery(sqlQuery);
		while(resultSet.next())
		{
			outputString += resultSet.getInt("snum") + "....";
			outputString += resultSet.getString("ssn") + "....";
			outputString += resultSet.getString("name") + "\n";
		}
		System.out.println(outputString);
		
		
		
		sqlQuery = "SELECT * FROM major " + 
				"where snum = (select snum from students where ssn = '123097834');";
		stmt = connect.createStatement();
		resultSet = stmt.executeQuery(sqlQuery);
		outputString = "";
		while(resultSet.next())
		{
			outputString += resultSet.getString("name") + "....";
			outputString += resultSet.getString("level") + "\n";
		}
		System.out.println(outputString);
		
		
		
		sqlQuery = "SELECT * FROM courses " + 
				"where department_code = (select code from departments where name = 'Computer Science');";
		stmt = connect.createStatement();
		resultSet = stmt.executeQuery(sqlQuery);
		outputString = "";
		while(resultSet.next())
		{
			outputString += resultSet.getString("name") + "\n";
		}
		System.out.println(outputString);
		
		
		
		sqlQuery = "SELECT * FROM degrees " + 
				"where department_code = (select code from departments where name = 'Computer Science');";
		stmt = connect.createStatement();
		resultSet = stmt.executeQuery(sqlQuery);
		outputString = "";
		while(resultSet.next())
		{
			outputString += resultSet.getString("name") + "....";
			outputString += resultSet.getString("level") + "\n";
		}
		System.out.println(outputString);
		
		
		
		sqlQuery = "SELECT * FROM students s " + 
				"where snum in (select snum from minor);";
		stmt = connect.createStatement();
		resultSet = stmt.executeQuery(sqlQuery);
		outputString = "";
		while(resultSet.next())
		{
			outputString += resultSet.getString("s.name") + "\n";
		}
		System.out.println(outputString);

	}
}