import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	static Connection connection = null;

	static void getDBConnection() {
		System.out.println("-------- MySQL JDBC Connection Testing ------------");
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
			return;
		}
		System.out.println("MySQL JDBC Driver Registered!");

		connection = null;
		try {
			String url = "jdbc:mysql://ec2-18-217-7-101.us-east-2.compute.amazonaws.com:3306/tech";
			String user = "newmysqlremoteuser";
			String password = "mypassword";
			connection = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		}

		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
	}
}
