package com.dbs.util;
import java.io.*;
import java.sql.*;
import java.util.*;

/**
 * @author Anthony
 * @date 2019/08/20
 * @version V1.0
 *
 */
public class DBUtil {
	private static String driver;
	private static String url;
	private static String user;
	private static String pass;
	
	/**
	 * load the property file
	 */
	static {
		Properties props = new Properties();
		InputStream is = DBUtil.class.getClassLoader().getResourceAsStream("dbConfig.properties");
		try {
			props.load(is);
			//º”‘ÿ∂¡»°∆˜
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver = props.getProperty("driver");
		url = props.getProperty("url");
		user = props.getProperty("user");
		pass = props.getProperty("pass");
	}
	
	/**
	 * register the driver
	 */
	static {
		try {
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Open the database connection
	 * @return
	 */
	public static Connection getConn() {
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(url,user,pass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * Close the database connection
	 * @return
	 */
	public static void closeAll(ResultSet rs,Statement st,Connection conn) {
		try {
			close(rs);
			close(st);
			close(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * close ResultSet
	 * @param rs
	 * @throws SQLException
	 */
	private static void close(ResultSet rs) throws SQLException {
		if(rs != null) {
			rs.close();
		}
	} 
	
	/**
	 * close Statement
	 * @param st
	 * @throws SQLException
	 */
	private static void close(Statement st) throws SQLException {
		if(st != null) {
			st.close();
		}
	} 
	
	/**
	 * close Connection
	 * @param conn
	 * @throws SQLException
	 */
	private static void close(Connection conn) throws SQLException {
		if(conn != null) {
			conn.close();
		}
	} 
}
