package service;

import static org.junit.Assert.*;


import org.junit.Test;

import po.Admin;

public class AdminServiceTest {
	
	private AdminService adminService=new AdminService();

	@Test
	public void testUpdate() {
		Admin admin = new Admin();
		admin.setLabourid(229);
		admin.setPwd("good！");
		System.out.println("更新操作      "+adminService.update(3, admin));
		
	}

	@Test
	public void testLogin() {
		System.out.println(adminService.login("225", "4").toString());
	}

	@Test
	public void testDeleteAdmin() {
		System.out.println("删除操作    " +adminService.deleteAdmin(2));
	}
	

}
