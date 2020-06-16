package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import po.Group;
import po.Page;
import service.GroupService;
import vo.GroupInfo;

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
			out.print("<script>" + "alert('Successful!');</script>");
			response.sendRedirect("/personnelManagementSystem/admin/index.jsp");
		} else {
			out.print("<script>" + "alert('Failed!');</script>");
			response.sendRedirect("/personnelManagementSystem/admin/create_group.jsp");
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
			out.print("<script>" + "alert('Successful!');</script>");
			response.sendRedirect("/personnelManagementSystem/admin/index.jsp");
		} else {
			out.print("<script>" + "alert('Failed!');</script>");
			response.sendRedirect("/personnelManagementSystem/admin/delete_group.jsp");
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
    
    protected void findGroupByPage(HttpServletRequest request, HttpServletResponse response) {
    	String pageNoStr = request.getParameter("pageNo");
    	Page<GroupInfo> page = groupService.findGroupByPage(pageNoStr);
    	request.setAttribute("page", page);
    	try {
			request.getRequestDispatcher("/user/showAll.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
    }
    
    private void findGroupById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String groupidStr = request.getParameter("groupid");
		System.out.println("进来了");
		int groupid = Integer.parseInt(groupidStr);
		Group group = groupService.findGroupById(groupid);
	    int count = groupService.getCountOfGroup(groupid);
		request.setAttribute("group", group);
		request.setAttribute("number", count);
		System.out.println(group.toString());
		request.getRequestDispatcher("/user/personal.jsp").forward(request, response);;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String method = request.getParameter("method");
		if (method.equals("create")) {
			create(request, response);
		} else if (method.equals("delete")) {
			delete(request, response);
		} else if(method.equals("findGroupByPage")) {
			findGroupByPage(request,response);
		} else if(method.equals("findGroupById")) {
			 System.out.println("正在doget");
			 findGroupById(request,response);
			 //System.out.println("正在doget");
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
