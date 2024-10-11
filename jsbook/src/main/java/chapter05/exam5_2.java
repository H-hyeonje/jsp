package chapter05;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/5_2")
public class exam5_2 extends HttpServlet{
	ArrayList a=new ArrayList();
	ArrayList b=new ArrayList();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Enumeration en=req.getHeaderNames();
		while(en.hasMoreElements()) {
			String headerName=(String) en.nextElement();
			String headerValue=req.getHeader(headerName);
			a.add(headerName);
			b.add(headerValue);

		}
		req.setAttribute("aa", a);
		req.setAttribute("en", b);
		RequestDispatcher a=req.getRequestDispatcher("chapter5/5-2.jsp");
		a.forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
	
}
