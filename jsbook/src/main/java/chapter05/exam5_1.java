package chapter05;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/5_1")
public class exam5_1 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String userid=req.getParameter("id");
		String password=req.getParameter("passwd");
		req.setAttribute("aa", userid);
		req.setAttribute("bb", password);
		RequestDispatcher a=req.getRequestDispatcher("chapter5/5_1.jsp");
		a.forward(req, resp);
	}
	
}