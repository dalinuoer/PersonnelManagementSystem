package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import po.Player;
import service.PlayerService;

/**
 * @author Qin Hao
 * @date 2020/6/8
 */

/**
 * Servlet implementation class PlayerServlet
 * 
 */

public class PlayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PlayerService playerService = new PlayerService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlayerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    // 登录
    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	System.out.println("正在login");
		String name = request.getParameter("name");
		System.out.println(name);
		String pwd = request.getParameter("pwd");
		System.out.println(pwd);
		Player player = playerService.login(name, pwd);
		//response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		if(player != null) {
			HttpSession session = request.getSession();
			session.setAttribute("player", player);
			//out.print("<script>alert('success!');</script>");
			response.sendRedirect(request.getContextPath()+"/user/main.jsp");
		} else {
			request.setAttribute("name", name);
			//out.print("<script>" + "alert('登录失败!');</script>");
			request.getRequestDispatcher("/user/login.jsp").forward(request, response);
		}
	}
    
     //注销
    protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("player");
		PrintWriter out = response.getWriter();
		out.print("<script>" + "window.parent.location.href='" + request.getContextPath()
		+ "/user/login.jsp';" + "</script>");
	}
//    
    // 注册
    protected void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		System.out.println("正在注册");
	
		int result = playerService.register(name, pwd);
		//response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		if (result == 1) {
			out.print("<script>" + "alert('注册成功!');" + "window.parent.location.href='" + request.getContextPath()
			+ "/user/login.jsp';" + "</script>");
		} else if(result == -1) {
			out.print("<script>" + "alert('当前用户名重复');" + "window.location.href='" + request.getContextPath()
			+ "/user/register.jsp';" + "</script>");
		}
		else {
			out.print("<script>" + "alert('注册失败');" + "window.location.href='" + request.getContextPath()
			+ "/user/register.jsp';" + "</script>");	
		}
	}
//    
    // 更新
    protected void updateByPlayer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		Player player = playerService.findPlayerById(id);
		player.setName(name);
		player.setPwd(pwd);
		int result = playerService.changeNameOrPwd(id, player);	
		PrintWriter out = response.getWriter();
		if (result == 1) {
			HttpSession session = request.getSession();
			session.removeAttribute("player");
			session.setAttribute("player", player);
			out.print("<script>" + "alert('修改成功!');" + "window.parent.location.href='" + request.getContextPath()
			+ "/user/personal.jsp';" + "</script>");
		}  else if(result == -1) {
			out.print("<script>" + "alert('当前用户名重复');" + "window.location.href='" + request.getContextPath()
			+ "/user/changePwd.jsp';" + "</script>");
		}
		else {
			out.print("<script>" + "alert('修改失败');" + "window.location.href='" + request.getContextPath()
			+ "/user/changePwd.jsp';" + "</script>");	
		}
	}
    
    protected void updateByAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String groupidStr = request.getParameter("groupid");
		int groupid = Integer.parseInt(groupidStr);
	
		Player player = new Player(id, name, pwd, groupid, new Date());
		
		int result = playerService.update(id, player);
		
		PrintWriter out = response.getWriter();
		if (result == 1) {
			HttpSession session = request.getSession();
			session.removeAttribute("player");
			session.setAttribute("player", player);
			out.print("<script>" + "alert('Successful!');" + "window.parent.location.href='" + request.getContextPath()
			+ "/admin/index.jsp';" + "</script>");
		} else {
			out.print("<script>" + "alert('Failed!');" + "window.location.href='" + request.getContextPath()
			+ "/admin/update_player.jsp';" + "</script>");
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
		if (method.equals("login")) {
			login(request, response);
		} else if (method.equals("logout")) {
			logout(request, response);
		} else if(method.equals("register")) {
			register(request, response);
		} else if (method.equals("updateByPlayer")) {
			updateByPlayer(request, response);
		} else if (method.equals("updateByAdmin")) {
			updateByAdmin(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("来post!");
		doGet(request, response);
	}

}
