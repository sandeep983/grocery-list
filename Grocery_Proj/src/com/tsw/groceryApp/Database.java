package com.tsw.groceryApp;
import java.sql.*;
import java.util.ArrayList;

public class Database {
	private static Connection con = null;
	private static PreparedStatement pstmt = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	private static String qry = null;
	private static ArrayList<String> groceryList = new ArrayList<>();
	

	// To check if the table exists in the database
	private static boolean tableExists(Connection con) throws SQLException {
		qry = "SELECT * FROM information_schema.tables WHERE table_schema = 'tsw' AND TABLE_NAME = 'grocery' LIMIT 1";
		pstmt = con.prepareStatement(qry);
		rs = pstmt.executeQuery();
		if(rs.next()) {
			return true;
		}
		return false;
	}


	// To fetch the GroceryList from the database
	public static ArrayList<String> fetchAllData() {
		try {
			// Registering the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Creating the connection
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			
			// If table exists, get all the data and put it inside the ArrayList
			if(tableExists(con)) {
				qry = "SELECT * FROM tsw.grocery";
				pstmt = con.prepareStatement(qry);
				rs = pstmt.executeQuery();

				while(rs.next()) {
					groceryList.add(rs.getString(1));
				}
			}
			// If table doesn't exist, create it
			else {
				qry = "CREATE TABLE tsw.grocery (NAME VARCHAR(250), PRIMARY KEY (NAME))";
				pstmt = con.prepareStatement(qry);
				pstmt.executeUpdate();
			}
		}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
		finally {
			// ResultSet
			if (rs != null) {
				try {
					rs.close();
				} 
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
			// PreparedStatement
			if (pstmt != null) {
				try {
					pstmt.close();
				} 
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
			// Connection
			if (con != null) {
				try {
					con.close();
				} 
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return groceryList;
	}


	// To save the modified GroceryList in the database
	public static void saveAllData(ArrayList<String> groceryList) {
		try {
			// Registering the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Creating the connection
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			
			// Deleting all the previous records from the table
			qry = "TRUNCATE TABLE tsw.grocery";
			stmt = con.createStatement();
			stmt.execute(qry);

			// Inserting all the new records from the groceryList into the table
			for(String items : groceryList) {
				qry = "INSERT INTO tsw.grocery VALUES(?)";
				pstmt = con.prepareStatement(qry);
				pstmt.setString(1, items);
				pstmt.executeUpdate();
			}
		}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
		finally {
			// ResultSet
			if (rs != null) {
				try {
					rs.close();
				} 
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
			// PreparedStatement
			if (pstmt != null) {
				try {
					pstmt.close();
				} 
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
			//Statement
			if(stmt != null) {
				try {
					stmt.close();
				} 
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
			// Connection
			if (con != null) {
				try {
					con.close();
				} 
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
