package service;

import java.util.ArrayList;

import dao.GroupDao;
import po.Group;
import po.Page;
import vo.GroupInfo;

public class GroupService {

	public GroupService() {
		// TODO Auto-generated constructor stub
	}
    
	private GroupDao dao = new GroupDao(); 
	
	//有重名的返回-1
	public int createGroup(String name,String labouridStr,String masterStr,String description ) {
		if(dao.findGroupByName(name)!=null) {
			return -1;
		}
		Group group =new Group();	
		group.setName(name);
		int  labourid = Integer.parseInt(labouridStr);
		group.setLabourid(labourid);
		int master = Integer.parseInt(masterStr);
		group.setMaster(master);
		group.setDescription(description);
		return dao.add(group);
	}
	
	public Page<GroupInfo> findGroupByPage(String pageNoStr){
		  int pageNo = 1;
		  if( pageNoStr!=null && !pageNoStr.equals(""))
		    {
		      pageNo = Integer.parseInt(pageNoStr);
		    }
		  Page<GroupInfo> page = new Page<GroupInfo>();
		  page.setPageNo(pageNo);
		   return dao.findGroupByPage(page);	  
	  }
	  
	public int getCountOfGroup(int id) {
		return dao.getCountOfGroup(id);
	}
	
	public Group findGroupById(int groupid) {
		  return dao.findGroupById(groupid);
	}
	
	public Group findGroupByName(String name) {
		return dao.findGroupByName(name);
	}	
	
	public ArrayList<Group> findAllGroup(){
		return dao.findAllGroup();
	}
	  
	//有人的话就不能删除成功
	public int deleteGroup(int id) {
		if(dao.getCountOfGroup(id)!=0) {
			return -1;
		}
		return dao.delete(id);
	}
	
	public int update(int id, Group group) {
		return dao.update(id, group);
	}
}