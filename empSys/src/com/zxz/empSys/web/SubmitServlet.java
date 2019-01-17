package com.zxz.empSys.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/SubmitServlet")
public class SubmitServlet extends HttpServlet {

	/**
	 * 空参构造
	 */
	public SubmitServlet() {
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 获取session的令牌
		String token1 = (String) req.getSession().getAttribute("TOKEN_IN_SESSION");
		// 获取请求的令牌
		String token2 = req.getParameter("token");

		if (token2 == null || !token1.equals(token2)) {
			System.out.println("表单已提交,禁止操作");
			return;
		}

		String text = req.getParameter("text");
		System.out.println(text);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
