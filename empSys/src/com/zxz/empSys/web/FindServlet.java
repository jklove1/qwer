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
 * 控制修改数据的servlet
 */
@SuppressWarnings("serial")
@WebServlet("/FindServlet")
public class FindServlet extends HttpServlet {

	/**
	 * 空参构造
	 */
	public FindServlet() {

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获取全局参数
		ServletContext context = req.getServletContext();
		String encoding = context.getInitParameter("encoding");
		// 设置编码格式
		req.setCharacterEncoding(encoding);
		resp.setContentType("text/html;charset=" + encoding);

		int id = Integer.valueOf(req.getParameter("id"));
		IEmpSysService service = new EmpSysService();
		Emp emp = service.findById(id);

		// 把员工信息存入到请求域中
		req.setAttribute("emp", emp);
		// 请求转发
		req.getRequestDispatcher("/update.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
