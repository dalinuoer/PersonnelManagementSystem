package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import po.Group;
import service.GroupService;

/**
 * @author Qin Hao
 * @date 2020/6/10
 */

/**
 * Servlet implementation class GroupServlet
 */
public class GroupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GroupService groupService = new GroupService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GroupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    // 创建团体
    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String labourid = request.getParameter("labourid");
		String master = request.getParameter("master");
		String description = request.getParameter("description");
		
		int result = groupService.createGroup(name, labourid, master, description);
		
		PrintWriter out = response.getWriter();
		if (result == 1) {
			out.print("<script>" + "alert('创建团体成功!');</script>");
			response.sendRedirect("***.jsp");
		} else {
			out.print("<script>" + "alert('创建团体失败!');</script>");
			response.sendRedirect("***.jsp");
		}
	}
    
    // 删除团体
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		
		int result = groupService.deleteGroup(id);
		
		PrintWriter out = response.getWriter();
		if (result == 1) {
			out.print("<script>" + "alert('删除团体成功!');</script>");
			response.sendRedirect("***.jsp");
		} else {
			out.print("<script>" + "alert('删除团体失败!');</script>");
			response.sendRedirect("***.jsp");
		}
	}
    
    // 修改信息
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	String idStr = request.getParameter("id");
    	int id = Integer.parseInt(idStr);
		String name = request.getParameter("name");
		String labouridStr = request.getParameter("labourid");
		int labourid = Integer.parseInt(labouridStr);
		String masterStr = request.getParameter("master");
		int master = Integer.parseInt(masterStr);
		String description = request.getParameter("description");
		
		Group group = new Group(id, name, master, labourid, description);
		
		int result = groupService.update(id, group);
		
		PrintWriter out = response.getWriter();
		if (result == 1) {
			out.print("<script>" + "alert('修改团体成功!');</script>");
			response.sendRedirect("***.jsp");
		} else {
			out.print("<script>" + "alert('修改团体失败!');</script>");
			response.sendRedirect("***.jsp");
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String method = request.getParameter("method");
		if (method.equals("create")) {
			create(request, response);
		} else if (method.equals("delete")) {
			delete(request, response);
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
