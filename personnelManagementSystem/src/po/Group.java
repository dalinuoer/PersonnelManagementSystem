package po;

/**
 * Group
 * @author Qin Hao
 * @date 2020/5/27
 *
 */
public class Group {
	private int id;
	private String name;
	private int master;
	private int labourid;
	private String description;
	
	public Group() {
		super();
	}
	
	public Group(int id, String name, int master, int labourid, 
			String description) {
		super();
		this.id = id;
		this.name = name;
		this.master = master;
		this.labourid = labourid;
		this.description = description;
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
	
	public int getMaster() {
		return master;
	}
	
	public void setMaster(int master) {
		this.master = master;
	}
	
	public int getLabourid() {
		return labourid;
	}
	
	public void setLabourid(int labourid) {
		this.labourid = labourid;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Group [id=" + id + ", name=" + name + ", master=" + master + ","
				+ " labourid=" + labourid + ", description="
				+ description + "]";
	}
}
