package po;



/**

 * Admin

 * @author Qin Hao

 * @date 2020/5/27

 *

 */



public class Admin {

	private int id;

	private String pwd;

	private int labourid;

	

	public Admin() {

		super();

	}

	

	public Admin(int id, String pwd, int labourid) {

		super();

		this.id = id;

		this.pwd = pwd;

		this.labourid = labourid;

	}



	public int getId() {

		return id;

	}



	public void setId(int id) {

		this.id = id;

	}



	public String getPwd() {

		return pwd;

	}



	public void setPwd(String pwd) {

		this.pwd = pwd;

	}



	public int getLabourid() {

		return labourid;

	}



	public void setLabourid(int labourid) {

		this.labourid = labourid;

	}



	//@Override

	public String toString() {

		return "Admin [id=" + id + ", pwd=" + pwd + ", labourid=" + labourid + 

				"]";

	}

}