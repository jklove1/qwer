package com.zxz.empSys.web;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.zxz.empSys.domain.Emp;
import com.zxz.empSys.service.EmpSysService;
import com.zxz.empSys.service.IEmpSysService;

/**
 * 控制删除的servlet
 */
@SuppressWarnings("serial")
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	
	/**
	 * 空参构造
	 */
	public DeleteServlet() {
		
	}
	
	@SuppressWarnings("all")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 获取全局参数
		ServletContext context = req.getServletContext();
		String encoding = context.getInitParameter("encoding");
		// 设置编码格式
		req.setCharacterEncoding(encoding);
		resp.setContentType("text/html;charset=" + encoding);
		
		int id=Integer.parseInt(req.getParameter("id"));
		IEmpSysService service = new EmpSysService();
		Emp emp = service.findById(id);
		req.getSession().setAttribute("emp", emp);
		service.deleteById(id);
	
		Emp emp1= (Emp) req.getSession().getAttribute("emp");
		req.setAttribute("emp", emp);
		req.getRequestDispatcher("/delete.jsp").forward(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
