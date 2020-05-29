package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import po.Apply;
import util.DBUtil;

public class ApplyDao {
	public int add(Apply apply) {

		Connection conn = DBUtil.getConn();

		String sql = "insert into apply(playerid,content, date) "

				+ "values(?, ?, ?)";

		PreparedStatement pstmt = null;

		int result = 0;

		try {

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, apply.getPlayerid());

			pstmt.setString(2, apply.getContent());
			SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date date=formatter.parse(apply.getDate());
			java.sql.Date e = new java.sql.Date(date.getTime());
			pstmt.setDate(3,e);
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
//			java.sql.Date date =rSet.getDate(4);   
//			  
//			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");   
//			  
//			String data_str = format.format(date); //2013-01-14 

			if (rSet.next()) {

				apply = new Apply(rSet.getInt(1), rSet.getInt(2), 

						rSet.getString(3),rSet.getString(4));//date转换为 string

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
}
