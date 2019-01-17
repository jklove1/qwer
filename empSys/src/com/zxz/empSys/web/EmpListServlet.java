package com.zxz.empSys.web;

import java.io.IOException;
import java.util.List;

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
 * 员工列表的Servlet
 */
@SuppressWarnings("serial")
@WebServlet("/EmpListServlet")
public class EmpListServlet extends HttpServlet {

	/**
	 * 空参构造
	 */
	public EmpListServlet() {
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获取全局参数
		ServletContext context = req.getServletContext();
		String encoding = context.getInitParameter("encoding");
		// 设置编码格式
		req.setCharacterEncoding(encoding);
		resp.setContentType("text/html;charset=" + encoding);

		// 通过service获取所有员工信息
		IEmpSysService service = new EmpSysService();
		List<Emp> list = service.findAll();

		// 把所有员工信息存入到请求域中
		req.setAttribute("list", list);
		System.out.println(list);

		// 请求转发
		req.getRequestDispatcher("/empList.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
