package service;

import dao.ApplyDao;
import po.Apply;

public class ApplyService {
	
	private ApplyDao applydao = new ApplyDao();
	public ApplyService() {
		// TODO Auto-generated constructor stub
	}
	
	//申请,申请时需要把status变为0；
	public int applyToGroup(Apply apply) {
		//当前已有申请 servlet层查看
		return applydao.add(apply);
	}


	//用户自己撤销申请
	public int deleteApply(int id) {
		return applydao.delete(id);
		
	}
	
	public Apply getApply(int playerid) {
		return applydao.findApplyByPlayer(playerid);
	}
	    
}
    
