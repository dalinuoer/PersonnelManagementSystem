package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import po.Admin;
import service.AdminService;

/**
 * @author Qin Hao
 * @date 2020/6/10
 */

/**
 * Servlet implementation class AdminServlet
 */
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminService adminService = new AdminService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    // 登录
    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String labourid = request.getParameter("labourid");
		String pwd = request.getParameter("pwd");
		
		Admin admin = adminService.login(labourid, pwd);
		
		PrintWriter out = response.getWriter();
		if (admin != null) {
			HttpSession session = request.getSession();
			session.setAttribute("admin", admin);
			out.print("<script>" + "alert('管理员登录成功!');</script>");
			response.sendRedirect("/admin/index.jsp");
		} else {
			request.setAttribute("labourid", labourid);
			out.print("<script>" + "alert('管理员登录失败!');</script>");
			request.getRequestDispatcher("/admin/login.jsp").forward(request, response);
		}
	}
    
    // 注销
    protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		session.removeAttribute("admin");
		PrintWriter out = response.getWriter();
		out.print("<script>" + "window.parent.location.href='" + request.getContextPath()
		+ "login.jsp';" + "</script>");
	}
    
    // 更新信息
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		String labouridStr = request.getParameter("labourid");
		int labourid = Integer.parseInt(labouridStr);
		String pwd = request.getParameter("pwd");
		
		Admin admin = new Admin(id, pwd, labourid);
		
		int result = adminService.update(id, admin);
		
		PrintWriter out = response.getWriter();
		if (result == 1) {
			HttpSession session = request.getSession();
			session.removeAttribute("admin");
			session.setAttribute("admin", admin);
			out.print("<script>" + "alert('修改成功!');" + "window.parent.location.href='" + request.getContextPath()
			+ "/admin/index.jsp';" + "</script>");
		} else {
			out.print("<script>" + "alert('修改失败!');" + "window.location.href='" + request.getContextPath()
			+ "/admin/update.jsp';" + "</script>");
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String method = request.getParameter("method");
		if (method.equals("login")) {
			login(request, response);
		} else if (method.equals("logout")) {
			logout(request, response);
		} else if (method.equals("update")) {
			update(request, response);
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
