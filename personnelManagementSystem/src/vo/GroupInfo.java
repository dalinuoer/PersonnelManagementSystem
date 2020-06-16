package vo;

public class GroupInfo {

	public GroupInfo() {
		// TODO Auto-generated constructor stub
	}
	private int id;
	private String name;
	private int master;
	private int labourid;
	private String description;
	private int number;//总人数
	
	@Override
	public String toString() {
		return "GroupInfo [id=" + id + ", name=" + name + ", master=" + master + ", labourid=" + labourid
				+ ", description=" + description + ", number=" + number + ", labourname=" + labourname + "]";
	}
	private String labourname;
	
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
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getLabourname() {
		return labourname;
	}
	public void setLabourname(String labourname) {
		this.labourname = labourname;
	}
}
