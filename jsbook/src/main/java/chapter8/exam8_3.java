package chapter8;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/8_3")
public class exam8_3 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ooao");
		req.getRequestDispatcher("chapter8/8_3.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		String pw=req.getParameter("pw");
		
		req.setAttribute("id", id);
		req.setAttribute("pw", pw);
		req.getRequestDispatcher("chapter8/8_3_1.jsp").forward(req, resp);
	}

}
