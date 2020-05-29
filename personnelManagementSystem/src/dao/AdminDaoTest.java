package dao;

import static org.junit.Assert.*;

import org.junit.Test;

import po.Admin;

public class AdminDaoTest {
	private AdminDao admindao=new AdminDao();

	@Test
	public void testDelete() {
		int result=admindao.delete(1);
		System.out.println("delete："+result);
		
	}
		

	@Test
	public void testUpdate() {
		Admin admin =new Admin();
		admin.setLabourid(123);
        admin.setPwd("12345t");	
       int result= admindao.update(2, admin);
       System.out.println("更新结果 "+result);
		
	}

	@Test
	public void testFindByIDAndPwd() {
		Admin admin=admindao.findByIDAndPwd(3,"222");
		System.out.println("id and pwd"+admin.toString());
	}

	@Test
	public void testFindByLabourid() {
		Admin admin=admindao.findByLabourid(225);
		System.out.println("id and pwd"+admin.toString());
	}

}
