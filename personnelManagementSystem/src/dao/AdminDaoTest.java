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
	public void testFindByLabourIdAndPwd() {
		Admin admin=admindao.findByLabourIdAndPwd(234,"222");
		System.out.println("name and pwd :"+admin.toString());
	}

	
	
	@Test
	public void testFindByLabourid() {
		Admin admin=admindao.findByLabourId(225);
		System.out.println("id and pwd"+admin.toString());
	}

}
