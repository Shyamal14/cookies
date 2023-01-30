package com.jsp.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet2")
public class Servlet2 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("name");
		String email = req.getParameter("email");

		Cookie cookies[] = req.getCookies();
		String cname = null;
		String cemail = null;
		int count = 0;
		for (Cookie c : cookies) {
			count++;
			if (c != null && count == 1) {
				System.out.println(c.getValue());
				cname = c.getValue();
			} else if (count == 2) {
				System.out.println(c.getValue());
				cemail = c.getValue();
			}
		}

		PrintWriter printWriter = resp.getWriter();
		printWriter.print(
		"<html><body><h1>" + "Welcome back " + cname + "your email is: " + cemail + "</h1></body></html>");

	}
}
