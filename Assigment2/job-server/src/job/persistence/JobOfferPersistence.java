package job.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import job.model.Category;
import job.model.JobOffer;


public class JobOfferPersistence {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/ds2";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "admin";

	
	public Category getCat(String in) {
		if(in==null) return Category.IT;
		switch(in){
		case "IT": return Category.IT;
		case "FOOD": return Category.FOOD;
		case "ECONOMY": return Category.ECONOMY;
		default: return Category.IT;
		}
	}
	

	public List<JobOffer> getJobOffers() {
		Connection conn = null;
		Statement stmt = null;
		List<JobOffer> list = null;
		JobOffer result = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			stmt = conn.createStatement();
			String sql;
			sql = "SELECT * FROM offer";
			ResultSet rs = stmt.executeQuery(sql);
			list = new ArrayList<JobOffer>();
			while (rs.next()) {
				result = new JobOffer();
				result.setTitle(rs.getString("title"));
				result.setCompanyName(rs.getString("companyname"));
				result.setCategory(getCat(rs.getString("category")));
				result.setDeadline(rs.getDate("deadline"));
				result.setSpecification(rs.getString("specification"));
				result.setContact(rs.getString("contact"));
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

	public void deleteJobOffer(JobOffer jobOffer) {
		Connection conn = null;
		Statement stmt = null;
		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			stmt = conn.createStatement();
			String sql;
			sql = "DELETE FROM `offer` WHERE `title`='" + jobOffer.getTitle()
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
	
	public void deleteJobOffer(String jobOffer) {
		Connection conn = null;
		Statement stmt = null;
		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			stmt = conn.createStatement();
			String sql;
			sql = "DELETE FROM `offer` WHERE `title`='" + jobOffer
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

	public void insert(JobOffer jobOffer) {

		Connection conn = null;
		Statement stmt = null;
		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			//INSERT INTO `ds2`.`offer` (`title`, `companyname`, `deadline`, `contact`, `specification`, `category`) VALUES ('dasd', 'fdgd', '1999/2/3', 'sdfsdfsdf', 'gdfhdfhdfh', 'dfhdfh');
			stmt = conn.createStatement();
			String sql;
			sql = "INSERT INTO `offer` (`title`, `companyname`, `deadline`, `contact`, `specification`, `category`) "
					+ "VALUES ('"
					+ jobOffer.getTitle()
					+ "', '"
					+ jobOffer.getCompanyName()
					+ "', '"
					+ jobOffer.getDeadline()
					+ "', '"
					+ jobOffer.getContact()
					+ "', '"
					+jobOffer.getSpecification()
					+ "', '" 
					+ jobOffer.getCategory()
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
}
