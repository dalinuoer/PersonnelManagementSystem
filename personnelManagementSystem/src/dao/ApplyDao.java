package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import po.Apply;
import util.DBUtil;

public class ApplyDao {
	public int add(Apply apply) {
		Connection conn = DBUtil.getConn();
		
		String sql = "insert into apply(playerid,content, date, status) values(?, ?, ?, ?)";
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, apply.getPlayerid());
			pstmt.setString(2, apply.getContent());
			pstmt.setTimestamp(3, new Timestamp(apply.getDate().getTime()));
			pstmt.setString(4, apply.getStatus());
			
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
		String sql = "delete from apply where id = ?";
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
	
	public int update(int id) {
		Connection conn = DBUtil.getConn();
		
		String sql = "update apply set status=? where id=?";
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "通过");
			pstmt.setInt(2, id);
			
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
	
	public Apply findApplyByPlayer(int playerid) {
		Connection conn = DBUtil.getConn();
		String sql = "select * from apply where playerid = ?";
		PreparedStatement pstmt = null;
		ResultSet rSet = null;
		Apply apply = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, playerid);
			rSet = pstmt.executeQuery();
			if (rSet.next()) {
				apply = new Apply(rSet.getInt(1), rSet.getInt(2), 
						rSet.getString(3),rSet.getTimestamp(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeRst(rSet);
			DBUtil.closePstmt(pstmt);
			DBUtil.closeConn(conn);
		}
		return apply;
	}
	
	public Apply findApplyById(int id) {
		Connection conn = DBUtil.getConn();
		String sql = "select * from apply where id = ?";
		PreparedStatement pstmt = null;
		ResultSet rSet = null;
		Apply apply = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rSet = pstmt.executeQuery();
			if (rSet.next()) {
				apply = new Apply(rSet.getInt(1), rSet.getInt(2), 
						rSet.getString(3),rSet.getTimestamp(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeRst(rSet);
			DBUtil.closePstmt(pstmt);
			DBUtil.closeConn(conn);
		}
		return apply;
	}
	
	public ArrayList<Apply> findAllApply() {
		Connection conn = DBUtil.getConn();
		String sql = "select * from apply";
		PreparedStatement pstmt = null;
		ResultSet rSet = null;
		Apply apply = null;
		ArrayList<Apply> applyList = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			rSet = pstmt.executeQuery();
			if (rSet.next()) {
				apply = new Apply(rSet.getInt(1), rSet.getInt(2), rSet.getString(3),rSet.getTimestamp(4));
				applyList.add(apply);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeRst(rSet);
			DBUtil.closePstmt(pstmt);
			DBUtil.closeConn(conn);
		}
		return applyList;
	}
}
