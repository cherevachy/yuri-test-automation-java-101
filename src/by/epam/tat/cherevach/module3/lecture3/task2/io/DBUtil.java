package by.epam.tat.cherevach.module3.lecture3.task2.io;

import java.sql.*;

public class DBUtil {

	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("org.hsqldb.jdbcDriver");  
			conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/testdb", "sa", "");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		return conn;
	}
}

