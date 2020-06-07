package service;
import dao.LabourDao;
import po.Labour;

public class LabourService {
	private LabourDao dao = new LabourDao();
	LabourService() {
		// TODO Auto-generated constructor stub
	}
    
    public int createLabour(String name,String master,String description) {
    	if(dao.findLabourByName(name)!=null) {
    		return -1;
    	}
    	Labour labour = new Labour();
    	labour.setName(name);
    	labour.setMaster(Integer.parseInt(master));
    	labour.setDescription(description);
    	return dao.add(labour);

    }
   
    public Labour GetlabourByid(int labourid) {
    	return dao.findLabourById(labourid);
    }
    
    public int UpdateLabour(int id,Labour labour) {
    	Labour a = dao.findLabourByName(labour.getName());
    	if(a!=null&&labour.getId()!=id) {
    		return -1;
    	}
    	return dao.update(id, labour);	
    }
}
