package com.jsp.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet1")
public class Servlet1 extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		//Create Cookie
		Cookie cookie1=new Cookie("name",name);
		Cookie cookie2=new Cookie("email",email);
		resp.addCookie(cookie1);
		resp.addCookie(cookie2);
PrintWriter printWriter = resp.getWriter();
	printWriter.print("<html><body><h1>" + "Welcome " + name + "</h1></body></html>");
    printWriter.print("<a href='servlet2'>"+"GoTO servlet2"+"</a>");
	}
}
