package service;

import java.util.Date;

import dao.ApplyDao;
import po.Apply;

public class ApplyService {
	
	private ApplyDao applydao = new ApplyDao();
	public ApplyService() {
		// TODO Auto-generated constructor stub
	}
	
	//申请
	public int applyToGroup(int playerid,String content) {
		//当前已有申请 servlet层查看
		Apply apply = new Apply();
		apply.setContent(content);
		apply.setPlayerid(playerid);
		apply.setDate(new Date());
		return applydao.add(apply);
	}
	
	//
	
	//处理完一个当即删除一个
	public int deleteApply(int id) {
		return applydao.delete(id);
		
	}
	    
}
    
