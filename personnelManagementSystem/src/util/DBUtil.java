package util;



import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;



/**

 * DBUtil

 * @author Qin Hao

 * @date 2020/5/27

 * 数据库连接

 */



public class DBUtil {

	private static String driverName = null;
	private static String url = null;
	private static String userName = null;
	private static String password = null;
	static {

		// 读取配置文件，加载JDBC四大参数

		driverName = "com.mysql.jdbc.Driver";
		url = "jdbc:mysql://39.98.107.126:3306/root_blog";
		userName = "root_blog";
		password = "123456";

		//加载驱动类

		try {
			Class.forName(driverName);

		} catch (ClassNotFoundException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

	// 建立连接

	public static Connection getConn() {

		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url, userName, password);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	// 关闭连接

	public static void closeConn(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 关闭preparedStatement

	public static void closePstmt(PreparedStatement pstmt) {

		try {
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 关闭结果集ResultSet

	public static void closeRst(ResultSet rst) {

		try {
			rst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}