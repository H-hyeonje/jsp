package chapter11;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/11_4")
public class exam11_4 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("chapter11/11_4.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			int num1=Integer.parseInt(req.getParameter("num1"));
			int num2=Integer.parseInt(req.getParameter("num2"));
		try {
			int num3=num1/num2;
			
			req.setAttribute("num1", num1);
			req.setAttribute("num2", num2);
			req.setAttribute("num3", num3);
			req.getRequestDispatcher("chapter11/11_4_1.jsp").forward(req, resp);
			
		} catch (Exception e) {
			throw e;
			
		}
	}

}
