package po;

import java.util.Date;

/**
 * Player
 * @author Qin Hao
 * @date 2020/5/27
 *
 */

public class Player {
	private int id;
	private String name;
	private String pwd;
	private int groupid;
	private Date date;
	
	public Player() {
		super();
	}

	public Player(int id, String name, String pwd, int groupid, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.groupid = groupid;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public int getGroupid() {
		return groupid;
	}

	public void setGroupid(int groupid) {
		this.groupid = groupid;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	//@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", pwd=" + pwd + ", "
				+ "groupid=" + groupid + ", date=" + date + "]";
	}
}