package com.zxz.empSys.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter{

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)arg0;
		HttpServletResponse resp=(HttpServletResponse)arg1;
		
		HttpSession session=req.getSession();
		
		if(req.getRequestURL().indexOf("login.jsp")!=-1
				||req.getRequestURL().indexOf("LoginServlet")!=-1
				||req.getRequestURL().indexOf("index.jsp")!=-1) {
			arg2.doFilter(req, resp);
			return;
		}
		
		//判断是否登录
		if(session.getAttribute("emp")!=null) {
			arg2.doFilter(req, resp);
		}else {
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
