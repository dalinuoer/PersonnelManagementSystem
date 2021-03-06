package service;

import dao.AdminDao;
import po.Admin;

public class AdminService {

		private AdminDao adminDao = new AdminDao();
		public AdminService() {
			// TODO Auto-generated constructor stub
		}
		
		//管理员更新,更新不成功返回 -1 0  成功的话返回 1 
		//并且检查是否更新为其他人的
		public int update(int id,Admin admin) {
			Admin a = adminDao.findByLabourId(admin.getLabourid());
			if(a!=null&&id!=a.getId()) {
				return -1;
			}
			else return adminDao.update(id, admin);	
		}
		
		//根据公会id登陆，返回Admin对象,如果登陆成功就返回admin 否则返回null
		public Admin login(String LabourIdStr,String password) {
			int LabourId=Integer.parseInt(LabourIdStr);	
			return adminDao.findByLabourIdAndPwd(LabourId, password);
		}
		
		//撤销公会会长，保留项目
		public int deleteAdmin(int id) {
			return adminDao.delete(id);
		}
}
