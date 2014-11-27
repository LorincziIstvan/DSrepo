package edu.utcn.ds.lab1.backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.utcn.ds.lab1.User;

public class Persistence {

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/ds1";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "admin";

	public void update(User user) {
		Connection conn = null;
		Statement stmt = null;
		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			stmt = conn.createStatement();
			String sql;
			sql = "UPDATE `user` SET `displayname`='" + user.getDisplayName()
					+ "', `password`='" + user.getPassword() + "', `x`='"
					+ user.getxCoordinate() + "', `y`='"
					+ user.getyCoordinate() + "', `role`='" + user.getRole()
					+ "', `address`='" + user.getAddress()
					+ "', `birthdate`='" + user.getBirthDate()
					+ "' WHERE `username`='" + user.getUsername() + "';";
			stmt.executeUpdate(sql);
			// STEP 6: Clean-up environment
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}// nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}// end finally try
		}// end try
	}

	public User getUserByUsername(String username) {
		Connection conn = null;
		Statement stmt = null;
		User result = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT * FROM user WHERE username = '" + username + "';";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				result = new User();
				result.setUsername(username);
				result.setDisplayName(rs.getString("displayname"));
				result.setxCoordinate(rs.getDouble("x"));
				result.setyCoordinate(rs.getDouble("y"));
				result.setRole(rs.getString("role"));
				result.setPassword(rs.getString("password"));
				result.setAddress(rs.getString("address"));
				result.setBirthDate(rs.getString("birthdate"));
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}// nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}// end finally try
		}// end try
		return result;
	}

	public List<User> getUsers() {
		Connection conn = null;
		Statement stmt = null;
		List<User> list = null;
		User result = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			stmt = conn.createStatement();
			String sql;
			sql = "SELECT * FROM user";
			ResultSet rs = stmt.executeQuery(sql);
			list = new ArrayList<User>();
			while (rs.next()) {
				result = new User();
				result.setUsername(rs.getString("username"));
				result.setDisplayName(rs.getString("displayname"));
				result.setxCoordinate(rs.getDouble("x"));
				result.setyCoordinate(rs.getDouble("y"));
				result.setRole(rs.getString("role"));
				result.setPassword("password");
				result.setAddress(rs.getString("address"));
				result.setBirthDate(rs.getString("birthdate"));
				list.add(result);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}// nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}// end finally try
		}// end try
		return list;
	}

	public void deleteUser(User user) {
		Connection conn = null;
		Statement stmt = null;
		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			stmt = conn.createStatement();
			String sql;
			sql = "DELETE FROM `user` WHERE `username`='" + user.getUsername()
					+ "';";

			stmt.executeUpdate(sql);


			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}// nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}// end finally try
		}// end try
	}
	
	public void deleteUser(String user) {
		Connection conn = null;
		Statement stmt = null;
		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			stmt = conn.createStatement();
			String sql;
			sql = "DELETE FROM `user` WHERE `username`='" + user
					+ "';";

			stmt.executeUpdate(sql);


			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}// nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}// end finally try
		}// end try
	}

	public void insert(User user) {

		Connection conn = null;
		Statement stmt = null;
		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			stmt = conn.createStatement();
			String sql;
			sql = "INSERT INTO `user` (`username`, `displayname`, `password`, `x`, `y`, `role`,`address`,`birthdate`) "
					+ "VALUES ('"
					+ user.getUsername()
					+ "', '"
					+ user.getDisplayName()
					+ "', '"
					+ user.getPassword()
					+ "', '"
					+ user.getxCoordinate()
					+ "', '"
					+ user.getyCoordinate() + "', '" + user.getRole() 
					+ "', '" + user.getAddress()
					+ "', '" + user.getBirthDate()
					+ "');";

			stmt.executeUpdate(sql);
			// STEP 6: Clean-up environment
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}// nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}// end finally try
		}// end try
	}

	public boolean checkPassword(User user) {
		User aux = getUserByUsername(user.getUsername());
		if (aux != null) {
			if (aux.getPassword().equals(user.getPassword())) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public boolean exists(String username) {
		User aux = getUserByUsername(username);
		if (aux != null) {
			return true;
		}
		return false;
	}
}
