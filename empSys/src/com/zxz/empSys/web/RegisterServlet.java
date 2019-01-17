package com.zxz.empSys.web;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Enumeration;
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
 * 控制注册的servlet
 * 
 * @author Administrator
 */
@SuppressWarnings("serial")
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

	/**
	 * 空参构造
	 */
	public RegisterServlet() {
	}

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


		// 调用service方法进行注册
		IEmpSysService service = new EmpSysService();
		service.Add(emp);
		// 返回登录界面
		// 在页面显示信息
		resp.getWriter().write("注册成功...返回主页");
		// 重定向至主页
		resp.setHeader("refrsh", "3;url" + context.getContextPath() + "/login.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
