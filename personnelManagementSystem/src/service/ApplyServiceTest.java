package service;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import po.Apply;

public class ApplyServiceTest {
	private ApplyService applyservice = new ApplyService();

	@Test
	public void testApplyToGroup() {
		
        Apply apply = new Apply();
		apply.setPlayerid(345);
		apply.setDate(new Date());
		apply.setContent("contents");	
		System.out.println(" apply result" + applyservice.applyToGroup(apply));
	}

	@Test
	public void testDeleteApply() {
		System.out.println("删除申请"+applyservice.deleteApply(3));
	}

}
