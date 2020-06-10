package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import po.Apply;
import service.ApplyService;

/**
 * @author Qin Hao
 * @date 2020/6/10
 */

/**
 * Servlet implementation class ApplyServlet
 */
public class ApplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ApplyService applyService = new ApplyService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    // 申请
    protected void applyTo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		String playeridStr = request.getParameter("playerid");
		int playerid = Integer.parseInt(playeridStr);
		String content = request.getParameter("content");
		
		Apply apply = new Apply(id, playerid, content, new Date());
		
		int result = applyService.applyToGroup(apply);
		
		PrintWriter out = response.getWriter();
		if (result == 1) {
			out.print("<script>" + "alert('申请成功!');</script>");
			response.sendRedirect("***.jsp");
		} else {
			out.print("<script>" + "alert('申请失败!');</script>");
			response.sendRedirect("***.jsp");
		}
	}
    
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		
		int result = applyService.update(id);
		
		PrintWriter out = response.getWriter();
		if (result == 1) {
			out.print("<script>" + "alert('申请通过!');</script>");
			response.sendRedirect("***.jsp");
		} else {
			out.print("<script>" + "alert('申请未通过!');</script>");
			response.sendRedirect("***.jsp");
		}
	}
    
    // 删除
    protected void deleteApply(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		
		int result = applyService.deleteApply(id);
		
		PrintWriter out = response.getWriter();
		if (result == 1) {
			out.print("<script>" + "alert('申请删除成功!');</script>");
			response.sendRedirect("***.jsp");
		} else {
			out.print("<script>" + "alert('申请删除失败!');</script>");
			response.sendRedirect("***.jsp");
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String method = request.getParameter("method");
		if (method.equals("applyTo")) {
			applyTo(request, response);
		} else if (method.equals("deleteApply")) {
			deleteApply(request, response);
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
