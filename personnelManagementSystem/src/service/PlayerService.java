package service;

import java.util.Date;

import dao.PlayerDao;
import po.Player;

public class PlayerService {
	private PlayerDao dao = new PlayerDao();

	public PlayerService() {
		// TODO Auto-generated constructor stub
	}
	
	//如果null就是用户名或密码错误
	public Player login(String name,String password) {
		return dao.findPlayerByNameAndPwd(name, password);
	}
	//用户名重复返回-1;否则返回 0 或1
	//用户没有group时，设置值为0;
	public int register(String name ,String password) {
		if(dao.findPlayerByName(name)!=null) {
			return -1;
		}
		Player player =new Player();
		player.setName(name);
		player.setPwd(password);
		player.setGroupid(0);
		player.setDate(new Date());
		return dao.add(player);	
	}
	
	//返回-1 便是用户名重复,传入的player已经为封装好的player
		public int update(int id, Player player) {
			Player a = dao.findPlayerByName(player.getName());
			if(a != null && a.getId()!=id) {
				return -1;
			}
			return dao.update(id, player);
		}
		public int updateByPlayer(int id, Player player) {
			Player a = dao.findPlayerByName(player.getName());
			if(a != null && a.getId()!=id) {
				return -1;
			}
			return dao.updateByPlayer(id, player);
		}
	
	//返回-1 便是用户名重复,传入的player已经为封装好的player
	public int changeNameOrPwd(int id,Player player) {
		Player a = dao.findPlayerByName(player.getName());
		if(a != null && a.getId()!=id) {
			return -1;
		}
		return dao.update(id, player);
	}
	
	public Player findPlayerById(int id) {
		return dao.findPlayerById(id);
	}
	//只需要传入名称就可以了吧
   public int dropGroup(int id,Player player) {
	  player.setGroupid(0);
	  player.setDate(new Date());  
	  return dao.update(id, player);  
   }
  //查询当前用户是否加入一个组的任务由客户端完成 
   //日期计算由servlet完成
   public int joinGroup(int id, Player player) {
	   //当前团人数已满
	   return dao.update(id, player);
	   
   }
   
   public Player findPlayerByName(String name) {
	   return dao.findPlayerByName(name);
   }
}
