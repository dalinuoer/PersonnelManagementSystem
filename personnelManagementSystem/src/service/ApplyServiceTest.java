package service;

import static org.junit.Assert.*;

import org.junit.Test;

public class ApplyServiceTest {
	private ApplyService applyservice = new ApplyService();

	@Test
	public void testApplyToGroup() {
		System.out.println(" apply result" + applyservice.applyToGroup(34, "lllaaaa"));
	}

	@Test
	public void testDeleteApply() {
		System.out.println("删除申请"+applyservice.deleteApply(3));
	}

}
