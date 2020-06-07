package dao;

import static org.junit.Assert.*;


import java.util.Date;

import org.junit.Test;

import po.Player;

public class PlayerDaoTest {
	private PlayerDao playerdao=new PlayerDao();

	@Test
	public void testAdd() {
		Player player = new Player();
		player.setName("小吴");
		player.setPwd("123456Y");
		player.setGroupid(0);
		player.setDate(new Date());
		int result=playerdao.add(player);
		System.out.println("添加操作是否成功:"+result);	
	}

	@Test
	public void testDelete() {
		int result=playerdao.delete(4);
		System.out.println("删除是否成功:"+result);
	}

	@Test
	public void testUpdate() {
		Player player = new Player();
		player.setName("小明");
		player.setPwd("123456S");
		player.setGroupid(299);
		player.setDate(new Date());
		int result=playerdao.update(6, player);
		System.out.println("更新是否成功"+result);
		
	}

	@Test
	public void testFindPlayerById() {
		Player player=playerdao.findPlayerById(5);
		System.out.println("by id查找："+player.toString());
	}

	@Test
	public void testFindPlayerByName() {
		Player player=playerdao.findPlayerByName("小胡");
		System.out.println("by name查找"+player.toString());
	}

	@Test
	public void testFindPlayerByNameAndPwd() {
		Player player=playerdao.findPlayerByNameAndPwd("小胡", "123456S");
		System.out.println("by name查找"+player.toString());
		
	}

}

