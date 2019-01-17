package com.zxz.empSys.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.zxz.empSys.domain.Emp;
import com.zxz.empSys.service.EmpSysService;
import com.zxz.empSys.service.IEmpSysService;

/**
 * 修改数据的servlet
 */
@SuppressWarnings("serial")
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {

	/**
	 * 空参构造
	 */
	public UpdateServlet() {

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 获取全局参数
		ServletContext context = req.getServletContext();
		String encoding = context.getInitParameter("encoding");
		// 设置编码格式
		req.setCharacterEncoding(encoding);
		resp.setContentType("text/html;charset=" + encoding);

		Map<String, String[]> map = req.getParameterMap();

		Emp emp = new Emp();
		try {
			// 将map所得到的表单数据封装到user实体类
			BeanUtils.populate(emp, map);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		IEmpSysService service = new EmpSysService();
		service.upDate(emp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
