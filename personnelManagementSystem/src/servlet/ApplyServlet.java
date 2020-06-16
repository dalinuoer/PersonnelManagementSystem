package servlet;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import po.Apply;
import po.Player;
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
		Player player=(Player) request.getSession().getAttribute("player");
		int playerid = player.getId();
		String content = request.getParameter("content");
		System.out.println(content);
		String lll =request.getParameter("lalala");
		System.out.println(lll);
		Apply apply = new Apply();
		apply.setContent(content);
		apply.setPlayerid(playerid);
		apply.setStatus(0);
		apply.setDate(new Date());
		int result = applyService.applyToGroup(apply);
		
		PrintWriter out = response.getWriter();
		if (result == 1) {
			out.print("<script>" + "alert('申请成功!');"+"window.location.href='"+request.getContextPath()+
					"/ApplyServlet?method=findApplyByPlayerId';"+"</script>");
		} else {
			out.print("<script>" + "alert('申请失败!');"+"window.location.href='"+request.getContextPath()+
					"/ApplyServlet?method=findApplyByPlayerId';"+"</script>");
		}
	}
    
//    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		String idStr = request.getParameter("id");
//		int id = Integer.parseInt(idStr);
//		
//		int result = applyService.update(id);
//		
//		PrintWriter out = response.getWriter();
//		if (result == 1) {
//			out.print("<script>" + "alert('申请通过!');</script>");
//			response.sendRedirect("***.jsp");
//		} else {
//			out.print("<script>" + "alert('申请未通过!');</script>");
//			response.sendRedirect("***.jsp");
//		}
//	}
    
    // 删除
    protected void deleteApply(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		
		int result = applyService.deleteApply(id);
		
		PrintWriter out = response.getWriter();
		if (result == 1) {
			out.print("<script>" + "alert('申请删除成功!');" + "window.location.href='"+request.getContextPath()
				+ "/ApplyServlet?method=findApplyByPlayerId';"+"</script>");
		} else {
			out.print("<script>" + "alert('申请删除失败!');" + "window.location.href='"
					+request.getContextPath()+"/ApplyServlet?method=findApplyByPlayerId';"+"</script>");
		}
	}
	private void findApplyByPlayerId(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		Player player =(Player)request.getSession().getAttribute("player");
		Apply apply =null;
		if(player==null) {
			response.sendRedirect(request.getContextPath()+"/user/login.jsp");
		}
		else {
			apply = applyService.getApply(player.getId());
			request.setAttribute("apply", apply);
			request.getRequestDispatcher("/user/apply.jsp").forward(request, response);
		}
		
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String method = request.getParameter("method");
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		if (method.equals("applyTo")) {
			applyTo(request, response);
		} else if (method.equals("deleteApply")) {
			deleteApply(request, response);
		}
//			else if (method.equals("update")) {
//			update(request, response);
//		}
		else if(method.equals("findApplyByPlayerId")) {
			findApplyByPlayerId(request,response);
		}
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
