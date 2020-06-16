package dao;


import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import po.Group;
import po.Page;
import util.DBUtil;
import vo.GroupInfo;


public class GroupDao {
	
	//增
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
	//删
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
		try 
		{
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, group.getName());
			pstmt.setInt(2, group.getMaster());
			pstmt.setInt(3,group.getLabourid());
			pstmt.setString(4,group.getDescription());
			pstmt.setInt(5,id);
			result=pstmt.executeUpdate();	
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
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
	//模
	
	public int getCountOfGroup(int id) {
		Connection conn = DBUtil.getConn();
		int count=0;
		String sql = "select count(id) from player where groupid = ?";
		PreparedStatement pstmt = null;
		ResultSet rSet = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,id);
			rSet = pstmt.executeQuery();
			if(rSet.next()) {
				count = rSet.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block	
			e.printStackTrace();
		} finally {
			DBUtil.closeRst(rSet);
			DBUtil.closePstmt(pstmt);
			DBUtil.closeConn(conn);
		}
		return count;
	}

	public Group findGroupByName(String name) {
		Connection conn = DBUtil.getConn();
		Group group = null;
		if(name != null && !" ".equals(name)) 
		{
		String sql = "select * from team where name = ?" ;
		PreparedStatement pstmt = null;
		ResultSet rSet = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,name);
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
		}//end if
		return group;
	}
	
	public ArrayList<Group> findAllGroup(){
		Connection conn = DBUtil.getConn();
		String sql = "select * from team";
		PreparedStatement pstmt = null;
		ResultSet rSet = null;
		ArrayList<Group> group = new ArrayList<Group>();
		try {
			pstmt = conn.prepareStatement(sql);
			rSet = pstmt.executeQuery();
			while (rSet.next()) {
				group. add(new Group(rSet.getInt(1), rSet.getString(2), 
						rSet.getInt(3),rSet.getInt(4),rSet.getString(5)));
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
	
	public int getGroupSum() {
		Connection conn = DBUtil.getConn();
		int count=0;
		String sql = "select count(id) from team";
		PreparedStatement pstmt = null;
		ResultSet rSet = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rSet = pstmt.executeQuery();
			if(rSet.next()) {
				count = rSet.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block	
			e.printStackTrace();
		} finally {
			DBUtil.closeRst(rSet);
			DBUtil.closePstmt(pstmt);
			DBUtil.closeConn(conn);
		}
		return count;
	}
	
	public Page<GroupInfo> findGroupByPage(Page<GroupInfo> page){
		Connection conn = DBUtil.getConn();
	    String sql = "select t.id,t.name,t.master,t.labourid,t.description,"
	    		+ "l.name from team t,labour l where t.labourid = l.id limit ? ,?";
	    ArrayList<GroupInfo> groupinfolist = new ArrayList<GroupInfo>();
	    PreparedStatement pstmt = null;
	    ResultSet rSet = null;
	    page.setCountNo(getGroupSum()); 
	    	try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1,(page.getPageNo()-1) * Page.show_items);
		    	pstmt.setInt(2, Page.show_items);
		    	rSet = pstmt.executeQuery();
		    	while(rSet.next()) {
		    		GroupInfo groupinfo = new GroupInfo();
		    		groupinfo.setId(rSet.getInt(1));
		    		groupinfo.setName(rSet.getString(2));
		    		groupinfo.setMaster(rSet.getInt(3));
		    		groupinfo.setLabourid(rSet.getInt(4));
		    		groupinfo.setDescription(rSet.getString(5));
		    		groupinfo.setLabourname(rSet.getString(6));
		    		groupinfo.setNumber(getCountOfGroup(rSet.getInt(1)));
		    		groupinfolist.add(groupinfo);
		    	}
		    	page.setList(groupinfolist);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				DBUtil.closeRst(rSet);
				DBUtil.closePstmt(pstmt);
				DBUtil.closeConn(conn);
			}
	    	return page;	
	}

}
