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
		int result = dao.delete(2);
		System.out.println("删除操作： "+ result);

	}
	



	@Test

	public void testUpdate() {
		Labour labour=new Labour();
		labour.setDescription("我是大居居");
		labour.setMaster(1234);
		labour.setName("mokamoka");
		int result=dao.update(3, labour);
		System.out.println("更新操作:"+result);

	}



	@Test

	public void testFindLabourById() {

		Labour labour=new Labour();
		labour=dao.findLabourById(5);
		System.out.println("通过id："+labour.toString());		
	}



	@Test
	public void testFindLabourByName() {
		Labour labour=new Labour();
		labour=dao.findLabourByName("工会一");
		System.out.println("通过姓名查找："+labour.toString());		

	}



	@Test

	public void testFindLabourByMaster() {

		Labour labour=new Labour();
		labour=dao.findLabourByMaster(202005285);
		System.out.println("通过master查找："+labour.toString());		

	}



}
