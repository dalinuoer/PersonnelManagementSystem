package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Qin Hao
 * @date 2020/5/27
 */

public class DBUtil {
	private static String drivername = null;
	private static String url = null;
	private static String username = null;
	private static String password = null;
	
	static {
		try {
			// 读取配置文件，加载JDBC四大参数
			drivername = "com.mysql.jdbc.Driver";
			url = "jdbc:mysql://39.98.107.126:3306/root_blog";
			username = "root_blog";
			password = "123456";
			//加载驱动类
			Class.forName(drivername);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// 建立连接
	public static Connection getConn() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url, username, password);
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