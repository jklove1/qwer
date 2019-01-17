package com.zxz.empSys.web;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/ValidateServlet")
public class ValidateServlet extends HttpServlet {

	/**
	 * 空参构造
	 */
	public ValidateServlet() {

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 第一步:首先产生字符串区
		String str = "abcdefghijkmnpqrstuvwxyABCDEFGHJKLMNPQRSTUVWXY23456789";

		// 第二步:随机获取四个字符
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			sb.append(str.charAt(getRandom(str.length())));
		}

		// 第三步:把获取到的四个字符存入到session中
		req.getSession().setAttribute("validate", sb.toString());

		// 第四步:在内存中创建图片duix
		int width = 80;
		int height = 70;
		int imgType = BufferedImage.TYPE_INT_RGB;
		BufferedImage img = new BufferedImage(width, height, imgType);

		// 第五步:在图片中获取"画笔"对象
		Graphics g = img.getGraphics();

		g.setFont(new Font("楷体", Font.BOLD, 30));

		for (int i = 0; i < 5; i++) {
			g.setColor(new Color(getRandom(256), getRandom(256), getRandom(256)));

			g.drawLine(getRandom(15), getRandom(30)+10, getRandom(50), getRandom(50)+10);

		}
		g.drawString(sb.toString(), 20, 20);

		// 设置响应头通知浏览器以图片的形式打开
		resp.setContentType("image/jpeg");// 等同于response.setHeader("Content-Type", "image/jpeg");
		// 设置响应头控制浏览器不要缓存
		resp.setDateHeader("expries", -1);
		resp.setHeader("Cache-Control", "no-cache");
		resp.setHeader("Pragma", "no-cache");

		// 第六步:将图片写给浏览器
		ImageIO.write(img, "jpg", resp.getOutputStream());
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doGet(req, resp);
	}

	/**
	 * 获取随机数的方法
	 * 
	 * @param r
	 * @return
	 */
	private int getRandom(int r) {
		Random ran = new Random();
		return ran.nextInt(r);
	}
}
