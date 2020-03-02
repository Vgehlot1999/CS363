import java.sql.*;

public class CreateTables {

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
		
		String sql = "Create Table students (" + 
				"	snum integer," + 
				"    ssn integer," + 
				"    name varchar(10)," + 
				"    gender varchar(1)," + 
				"    dob datetime," + 
				"    c_addr varchar(20)," + 
				"    c_phone varchar(10)," + 
				"    p_addr varchar(20)," + 
				"    p_phone varchar(10)," + 
				"    Primary Key (ssn)," + 
				"    Unique (snum));";
		stmt.executeUpdate(sql);
		
		
		sql = "Create Table departments (" + 
				"	code integer," + 
				"    name varchar(50)," + 
				"    phone varchar(10)," + 
				"    college varchar(20)," + 
				"    Primary Key (code)," + 
				"    Unique (name));";
		stmt.executeUpdate(sql);
		
		
		sql = "Create Table degrees (" + 
				"	name varchar(50)," + 
				"    level varchar(5)," + 
				"    department_code integer," + 
				"    Primary Key (name, level)," + 
				"    Foreign Key (department_code) references departments(code));";
		stmt.executeUpdate(sql);
		
		
		sql = "Create Table courses (" + 
				"	number integer," + 
				"    name varchar(50)," + 
				"    description varchar(50)," + 
				"    credithours integer," + 
				"    level varchar(20)," + 
				"    department_code integer," + 
				"    Primary key (number)," + 
				"    Foreign Key (department_code) references departments(code)," + 
				"    Unique (name));";
		stmt.executeUpdate(sql);
		
		
		sql = "Create Table register (" + 
				"	snum integer," + 
				"    course_number integer," + 
				"    regtime varchar(20)," + 
				"    grade integer," + 
				"    Primary Key (snum, course_number)," + 
				"    Foreign Key (snum) references students(snum)," + 
				"    foreign Key (course_number) references courses(number));";
		stmt.executeUpdate(sql);
		
		
		sql = "Create Table major (" + 
				"	snum integer," + 
				"    name varchar(50)," + 
				"    level varchar(5)," + 
				"    Primary Key (snum, name, level)," + 
				"    Foreign Key (snum) references students(snum)," + 
				"    Foreign Key (name, level) references degrees(name, level));";
		stmt.executeUpdate(sql);
		
		
		sql = "Create Table minor (" + 
				"	snum integer," + 
				"    name varchar(50)," + 
				"    level varchar(5)," + 
				"    Primary Key (snum, name, level)," + 
				"    Foreign Key (snum) references students(snum)," + 
				"    Foreign Key (name, level) references degrees(name, level));";
		stmt.executeUpdate(sql);

	}

}
