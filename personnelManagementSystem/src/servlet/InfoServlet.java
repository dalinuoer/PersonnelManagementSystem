package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import po.Apply;
import service.ApplyService;
import service.GroupService;
import service.LabourService;
import service.PlayerService;

/**
 * @author Qin Hao
 * @date 2020/6/10
 */

/**
 * Servlet implementation class InfoServlet
 */
public class InfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LabourService labourService = new LabourService();
	private GroupService groupService = new GroupService();
	private PlayerService playerService = new PlayerService();
	private ApplyService applyService = new ApplyService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    // 所有申请
    protected void findApplyById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	String idStr = request.getParameter("id");
    	int id = Integer.parseInt(idStr);
    	Apply apply = applyService.findApplyById(id);
    	request.setAttribute("apply", apply);
    	request.getRequestDispatcher("***.jsp").forward(request, response);
	}
    
    protected void findAllApply(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<Apply> applyList = applyService.findAllApply();
		request.setAttribute("applyList", applyList);
    	request.getRequestDispatcher("***.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String method = request.getParameter("method");
		if (method.equals("findAllApply")) {
			findAllApply(request, response);
		} else if (method.equals("findApplyById")) {
			findApplyById(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
