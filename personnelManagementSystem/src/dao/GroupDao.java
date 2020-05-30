package dao;


import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import po.Group;
import util.DBUtil;



public class GroupDao {

	//å¢ž
	public int add(Group group) {
		Connection conn = DBUtil.getConn();
		String sql = "insert into team(name, master, labourid, description) "
				+ "values(?, ?, ?, ?)";
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, group.getName());
			pstmt.setInt(2, group.getMaster());
			pstmt.setInt(3, group.getLabourid());
			pstmt.setString(4, group.getDescription());

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
	//åˆ 
	public int delete(int id) {
		Connection conn = DBUtil.getConn();
		String sql = "delete from team where id = ?";
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

	public int update(int id,Group group) {
		Connection conn = DBUtil.getConn();
		String sql="update team set name=?,master=?,labourid=?,description= ? where id=?";
		PreparedStatement pstmt=null;
		int result=  0;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, group.getName());
			pstmt.setInt(2, group.getMaster());
			pstmt.setInt(3,group.getLabourid());
			pstmt.setString(4,group.getDescription());
			pstmt.setInt(5,id);

			result=pstmt.executeUpdate();

		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closePstmt(pstmt);
			DBUtil.closeConn(conn);
		}
		return result;
	}

	public Group findGroupById(int id) {
		Connection conn = DBUtil.getConn();
		String sql = "select * from team where id = ?";
    	PreparedStatement pstmt = null;
    	ResultSet rSet = null;
		Group group = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rSet = pstmt.executeQuery();
			if (rSet.next()) {
				group = new Group(rSet.getInt(1), rSet.getString(2),
						rSet.getInt(3), rSet.getInt(4),rSet.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeRst(rSet);
			DBUtil.closePstmt(pstmt);
			DBUtil.closeConn(conn);
		}
		return group;
	}

	public Group findGroupByName(String name) {
		Connection conn = DBUtil.getConn();
		String sql = "select * from team where name = ?";
		PreparedStatement pstmt = null;
		ResultSet rSet = null;
		Group group=null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rSet = pstmt.executeQuery();
			if(rSet.next()) {
				group=new Group(rSet.getInt(1), rSet.getString(2),
						rSet.getInt(3),rSet.getInt(4),rSet.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeRst(rSet);
			DBUtil.closePstmt(pstmt);
			DBUtil.closeConn(conn);
		}
		return group;
	}

	public Group findGroupByMaster(int master) {
		Connection conn = DBUtil.getConn();
		String sql = "select * from team where master = ?";
		PreparedStatement pstmt = null;
		ResultSet rSet = null;
		Group group = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, master);
			rSet = pstmt.executeQuery();
			if (rSet.next()) {
				group = new Group(rSet.getInt(1), rSet.getString(2),
						rSet.getInt(3),rSet.getInt(4),rSet.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeRst(rSet);
			DBUtil.closePstmt(pstmt);
			DBUtil.closeConn(conn);
		}
		return group;
	}
}
