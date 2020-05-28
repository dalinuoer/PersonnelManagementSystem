package dao;

import static org.junit.Assert.*;

import org.junit.Test;

import po.Labour;

public class LabourDaoTest {
	private LabourDao dao = new LabourDao();
	
	@Test
	public void testAdd() {
		Labour labour = new Labour ();
		labour.setName("工会一");
		labour.setMaster(202005281);
		labour.setDescription("描述");
		int result = dao.add(labour);
		if (result == 1) {
			System.out.println("Success");
		} else {
			System.out.println("Failed");
		}
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindLabourById() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindLabourByName() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindLabourByMaster() {
		fail("Not yet implemented");
	}

}
