package po;

import java.util.Date;

/**
 * Apply
 * @author Qin Hao
 * @date 2020/5/27
 */

public class Apply {
	private int id;
	private int playerid;
	private String content;
	private Date date;
	private int status;

	public Apply() {
		super();
	}

	public Apply(int id, int playerid, String content, Date date, int status) {
		super();
		this.id = id;
		this.playerid = playerid;
		this.content = content;
		this.date = date;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPlayerid() {
		return playerid;
	}

	public void setPlayerid(int playerid) {
		this.playerid = playerid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Apply [id=" + id + ", playerid=" + playerid + ", content=" + 
				content + ", date=" + date + ", status="
				+ status + "]";
	}
}