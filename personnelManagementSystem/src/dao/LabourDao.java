package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import po.Labour;
import util.DBUtil;

/**
 * @author Qin Hao
 * @date 2020/5/27
 * 工会表Labour的增删改查
 */
public class LabourDao {
	public int add(Labour labour) {
		Connection conn = DBUtil.getConn();
		String sql = "insert into labour(name, master, description) "
				+ "values(?, ?, ?)";
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, labour.getName());
			pstmt.setInt(2, labour.getMaster());
			pstmt.setString(3, labour.getDescription());
			
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
	
	public int delete(int id) {
		Connection conn = DBUtil.getConn();
		String sql = "delete from labour where id = ?";
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
	
	public int update(int id, Labour labour) {
		Connection conn = DBUtil.getConn();
		String sql = "update labour set name = ?, master = ?, description = ?";
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, labour.getName());
			pstmt.setInt(2, labour.getMaster());
			pstmt.setString(3, labour.getDescription());
			
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
	
	public Labour findLabourById(int id) {
		Connection conn = DBUtil.getConn();
		String sql = "select * from labour where id = ?";
		PreparedStatement pstmt = null;
		ResultSet rSet = null;
		Labour labour = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			rSet = pstmt.executeQuery();
			
			if (rSet.next()) {
				labour = new Labour(rSet.getInt(1), rSet.getString(2), 
						rSet.getInt(3), rSet.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeRst(rSet);
			DBUtil.closePstmt(pstmt);
			DBUtil.closeConn(conn);
		}
		return labour;
	}
	
	public Labour findLabourByName(String name) {
		Connection conn = DBUtil.getConn();
		String sql = "select * from labour where name = ?";
		PreparedStatement pstmt = null;
		ResultSet rSet = null;
		Labour labour = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			
			rSet = pstmt.executeQuery();
			
			if (rSet.next()) {
				labour = new Labour(rSet.getInt(1), rSet.getString(2), 
						rSet.getInt(3), rSet.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeRst(rSet);
			DBUtil.closePstmt(pstmt);
			DBUtil.closeConn(conn);
		}
		return labour;
	}
	
	public Labour findLabourByMaster(int master) {
		Connection conn = DBUtil.getConn();
		String sql = "select * from labour where master = ?";
		PreparedStatement pstmt = null;
		ResultSet rSet = null;
		Labour labour = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, master);
			
			rSet = pstmt.executeQuery();
			
			if (rSet.next()) {
				labour = new Labour(rSet.getInt(1), rSet.getString(2), 
						rSet.getInt(3), rSet.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeRst(rSet);
			DBUtil.closePstmt(pstmt);
			DBUtil.closeConn(conn);
		}
		return labour;
	}
	
}
