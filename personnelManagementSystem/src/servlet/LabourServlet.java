package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import po.Labour;
import service.LabourService;

/**
 * @author Qin Hao
 * @date 2020/6/10
 */

/**
 * Servlet implementation class LabourServlet
 */
public class LabourServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LabourService labourService = new LabourService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LabourServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    // 修改信息
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		String name = request.getParameter("name");
		String masterStr = request.getParameter("master");
		int master = Integer.parseInt(masterStr);
		String description = request.getParameter("description");
		
		Labour labour = new Labour(id, name, master, description);
		
		int result = labourService.UpdateLabour(id, labour);
		
		PrintWriter out = response.getWriter();
		if (result == 1) {
			out.print("<script>" + "alert('修改工会成功!');</script>");
			response.sendRedirect("***.jsp");
		} else {
			out.print("<script>" + "alert('修改工会失败!');</script>");
			response.sendRedirect("***.jsp");
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
		if (method.equals("update")) {
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
