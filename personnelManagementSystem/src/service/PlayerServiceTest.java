package service;

import static org.junit.Assert.*;

import java.util.Date;

import service.PlayerService;

import org.junit.Test;

import po.Player;

public class PlayerServiceTest {
	private PlayerService ps =new PlayerService();

	@Test
	public void testLogin() {
		String name = "小狗";
		String password = "123";
		Player player=ps.login(name, password);
		if(player==null) {
		System.out.println("查无此人");}
		
	}

	@Test
	public void testRegister() {
		String name="小l";
		String password="ooo";
		int result=ps.register(name, password);
	    System.out.println("注册" +result);
	}

	@Test
	public void testChangeNameOrPwd() {
		Player player =new Player();
		player.setId(9);
		player.setName("小t");
		player.setPwd("ddd");
		player.setGroupid(34);
		player.setDate(new Date());
		int result = ps.changeNameOrPwd(player.getId(), player);
		System.out.println("改密"+ result);
	}

	@Test
	public void testDropGroup() {
		Player player =new Player();
		player.setId(9);
		player.setName("小t");
		player.setPwd("ddd");
		player.setGroupid(99);
		player.setDate(new Date());
		System.out.println("退出 "+ps.dropGroup(player.getId(), player));
		
	}

	@Test
	public void testJoinGroup() {
		Player player =new Player();
		player.setId(11);
		player.setName("小lll");
		player.setPwd("ddd");
		player.setGroupid(99);
		player.setDate(new Date());
		System.out.println("加入 "+ps.joinGroup(player.getId(), player));
		
	}

}
