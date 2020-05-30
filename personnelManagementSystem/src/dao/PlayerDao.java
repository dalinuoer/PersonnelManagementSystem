package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import po.Player;
import util.DBUtil;

public class PlayerDao {
	//增
	public int add(Player player) {
		Connection conn = DBUtil.getConn();
		String sql = "insert into player(name,pwd,groupid,date) "
				+ "values(?,?,?,?)";
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, player.getName());
			pstmt.setString(2, player.getPwd());
			pstmt.setInt(3, player.getGroupid());
			DateFormat formatter=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			java.util.Date date=formatter.parse(player.getDate());
			java.sql.Date e = new java.sql.Date(date.getTime());
			pstmt.setDate(4, e);
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
	       e.printStackTrace();
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			DBUtil.closePstmt(pstmt);
			DBUtil.closeConn(conn);
		}
		return result;
	}
	//删
	public int delete(int id) {
		Connection conn = DBUtil.getConn();
		String sql = "delete from player where id =?";
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

	public int update(int id,Player player) {
		Connection conn = DBUtil.getConn();
		String sql="update player set name=?,pwd=?,groupid=?,date=? where id=?";
		PreparedStatement pstmt=null;
		int result=  0;
		try
		{
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, player.getName());
			pstmt.setString(2, player.getPwd());
			pstmt.setInt(3,player.getGroupid());
			SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			java.util.Date date=formatter.parse(player.getDate());
			java.sql.Date e = new java.sql.Date(date.getTime());
			pstmt.setDate(4,e);
			//pstmt.setString(4,player.getDate());
			pstmt.setInt(5,id);
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
			DBUtil.closePstmt(pstmt);
			DBUtil.closeConn(conn);
		}
		return result;
	}

	public Player findPlayerById(int id) {
		Connection conn = DBUtil.getConn();
		String sql = "select * from player where id = ?";
    	PreparedStatement pstmt = null;
    	ResultSet rSet = null;
		Player player = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rSet = pstmt.executeQuery();
			if (rSet.next()) {
				    player = new Player(rSet.getInt(1), rSet.getString(2),
					rSet.getString(3), rSet.getInt(4),rSet.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeRst(rSet);
			DBUtil.closePstmt(pstmt);
			DBUtil.closeConn(conn);
		}
		return player;
	}

	public Player findPlayerByName(String name) {
		Connection conn = DBUtil.getConn();
		String sql = "select * from player where name = ?";
		PreparedStatement pstmt = null;
		ResultSet rSet = null;
		Player player =null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rSet = pstmt.executeQuery();
			if(rSet.next()) {
				player=new Player(rSet.getInt(1), rSet.getString(2),
						rSet.getString(3),rSet.getInt(4),rSet.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeRst(rSet);
			DBUtil.closePstmt(pstmt);
			DBUtil.closeConn(conn);
		}
		return player;
	}

	public Player findPlayerByNameAndPwd(String name,String pwd) {
		Connection conn = DBUtil.getConn();
		String sql = "select * from player where name = ? and pwd =?";
		PreparedStatement pstmt = null;
		ResultSet rSet = null;
		Player player=null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, pwd);
			rSet = pstmt.executeQuery();
			if (rSet.next()) {
				player= new Player(rSet.getInt(1), rSet.getString(2),
						rSet.getString(3),rSet.getInt(4),rSet.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeRst(rSet);
			DBUtil.closePstmt(pstmt);
			DBUtil.closeConn(conn);
		}
		return player;
	}
}