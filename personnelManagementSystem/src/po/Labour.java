package po;

/**
 * Labour
 * @author Qin Hao
 * @date 2020/5/27
 *
 */

public class Labour {
	private int id;
	private String name;
	private int master;
	private String description;

	public Labour() {
		super();
	}

	public Labour(int id, String name, int master, String description) {
		super();
		this.setId(id);
		this.setName(name);
		this.setMaster(master);
		this.setDescription(description);
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	//@Override
	public String toString() {
		return "Labour [id=" + id + ", name=" + name + ", master=" + master + ","
				+ " description=" + description + "]";
	}
}