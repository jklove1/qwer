package com.zxz.empSys.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zxz.empSys.domain.Emp;
import com.zxz.empSys.service.EmpSysService;
import com.zxz.empSys.service.IEmpSysService;

/**
 * 控制登录的Servlet
 * 
 * @author Administrator
 *
 */
@WebServlet("/LoginServlet")
@SuppressWarnings("all")
public class LoginServlet extends HttpServlet {
	/**
	 * 空参构造
	 */
	public LoginServlet() {

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获取全局参数
		ServletContext context = req.getServletContext();
		String encoding = context.getInitParameter("encoding");
		// 设置编码格式
		req.setCharacterEncoding(encoding);
		resp.setContentType("text/html;charset=" + encoding);

		// 获取请求的账号和密码
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		
		//获取用户验证码
		String validate = req.getParameter("validate");
		
		//获取session的验证码
		String val_in_session =(String) req.getSession().getAttribute("validate");
		
		if(!(val_in_session.equals(validate))) {
			req.setAttribute("val_msg", "验证码有错");
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
			
			return;
		}
		

		// 调用service方法进行登录查找
		IEmpSysService service = new EmpSysService();
		// 通过调用findEmpByNmaeAndPassword来查找用户
		Emp emp = service.findEmpByNmaeAndPassword(name, password);

		if (emp != null) {
			// 把登录用户存入到session中,
			HttpSession session = req.getSession();
			session.setAttribute("emp", emp);

			// 记录登录时间
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			String lastTime = sdf.format(new Date());

			// 获取请求cookie
			Cookie[] cookies = req.getCookies();
			if (cookies != null) {
				int i = 0;
				Cookie c = null;
				for (Cookie cookie : cookies) {
					String cookieName = cookie.getName();
					if ("lastTime".equals(cookieName)) {
						c = cookie;
						i = 1;
						break;
					}
				}

				if (i == 1) {
					String value = c.getValue();
					req.setAttribute("lastTime", value);
					c.setValue(lastTime);
					resp.addCookie(c);
					req.getRequestDispatcher("/index.jsp").forward(req, resp);
				} else {
					c = new Cookie("lastTime", lastTime);
					// 设置cookie
					c.setPath("/");
					c.setMaxAge(60 * 60 * 24 * 60);
					req.setAttribute("lastTime", lastTime);
					resp.addCookie(c);
					req.getRequestDispatcher("/index.jsp").forward(req, resp);
				}
			} else {
				Cookie c = new Cookie("lastTime", lastTime);
				// 设置cookie
				c.setPath("/");
				c.setMaxAge(60 * 60 * 24 * 60);
				req.setAttribute("lastTime", lastTime);
				resp.addCookie(c);
				req.getRequestDispatcher("/index.jsp").forward(req, resp);
			}

			// 在页面显示信息
			resp.getWriter().write("登录成功...返回主页");
			// 重定向至主页
			resp.setHeader("refrsh", "3;url" + context.getContextPath() + "/index.jsp");

			return;
		} else {
			req.setAttribute("error_msg", "账号或密码有误");
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
			return;
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
