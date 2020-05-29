package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import po.Admin;
import util.DBUtil;

public class AdminDao {

	public int delete(int id) {

		Connection conn = DBUtil.getConn();

		String sql = "delete from admin where id = ?";

		PreparedStatement pstmt = null;

		int result = 0;

		try {

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			result = pstmt.executeUpdate();

		} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {

			DBUtil.closePstmt(pstmt);
			DBUtil.closeConn(conn);

		}

		return result;

	}
	public int update(int id, Admin admin) {

		Connection conn = DBUtil.getConn();

		String sql = "update admin set pwd = ?,labourid = ? where id = ?";

		PreparedStatement pstmt = null;

		int result = 0;

		try {

			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, admin.getPwd());
			pstmt.setInt(2, admin.getLabourid());
			pstmt.setInt(3, id);
			
			result = pstmt.executeUpdate();

		} catch (SQLException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		} finally {

			DBUtil.closePstmt(pstmt);
			DBUtil.closeConn(conn);

		}

		return result;

	}
	public Admin findByIDAndPwd(int id, String pwd) {

		Connection conn = DBUtil.getConn();
		String sql = "select * from admin where id =? and pwd=?";
		PreparedStatement pstmt = null;
		ResultSet rSet = null;
		Admin admin = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,id);
			pstmt.setString(2, pwd);

			rSet = pstmt.executeQuery();

			if (rSet.next()) {

				admin = new Admin(rSet.getInt(1), rSet.getString(2), rSet.getInt(3));

			}

		} catch (SQLException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		} finally {

			DBUtil.closeRst(rSet);
			DBUtil.closePstmt(pstmt);
			DBUtil.closeConn(conn);

		}

		return admin;

	}
	
	public Admin findByLabourid(int labourid) {

		Connection conn = DBUtil.getConn();
		String sql = "select * from admin where labourid=?";
		PreparedStatement pstmt = null;
		ResultSet rSet = null;
		Admin admin = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,labourid);
			rSet = pstmt.executeQuery();

			if (rSet.next()) {

				admin = new Admin(rSet.getInt(1), rSet.getString(2), rSet.getInt(3));

			}

		} catch (SQLException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		} finally {

			DBUtil.closeRst(rSet);
			DBUtil.closePstmt(pstmt);
			DBUtil.closeConn(conn);

		}

		return admin;

	}
}
