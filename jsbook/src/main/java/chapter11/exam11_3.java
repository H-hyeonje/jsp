package chapter11;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/11_3")
public class exam11_3 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher ds=req.getRequestDispatcher("chapter11/11_3.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String num1=req.getParameter("num1");
		String num2=req.getParameter("num2");
		try {
			int num_1=Integer.parseInt(num1);
			int num_2=Integer.parseInt(num2);
			int num_3=num_1/num_2;
				req.setAttribute("num1", num_1);
				req.setAttribute("num2", num_2);
				req.setAttribute("num",num_3);
				RequestDispatcher ds=req.getRequestDispatcher("chapter11/11_3_a.jsp");
				ds.forward(req, resp);
	
		} catch (Exception e) {
			req.setAttribute("exception", e);
			req.getRequestDispatcher("chapter11/11_3_error.jsp").forward(req, resp);
		}	
			
	}

}
