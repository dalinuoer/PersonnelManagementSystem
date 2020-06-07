package service;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import po.Group;

public class GroupServiceTest {
	private GroupService groupservice = new GroupService();

	@Test
	public void testCreateGroup() {
		int result = groupservice.createGroup("111", "33", "345","yes ok!" );
		System.out.println("create "+ result);
		
	}

	@Test
	public void testGetCountOfGroup() {
		int count =groupservice.getCountOfGroup(2);
		System.out.println("人数  "+count);
	}

	@Test
	public void testFindGroupByName() {
		Group group = groupservice.findGroupByName("宝塔");
		System.out.println(group.toString());
	}

	@Test
	public void testFindAllGroup() {
		ArrayList<Group>list =groupservice.findAllGroup();
		for(Group group :list) {
			System.out.println(group.toString());
		}
	}

	@Test
	public void testDeleteGroup() {
		int result = groupservice.deleteGroup(234);
		System.out.println("delete "+result);
		
	}

}
