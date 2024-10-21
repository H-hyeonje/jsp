package chapter11;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/11_5")
public class exam11_5 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				RequestDispatcher rq=req.getRequestDispatcher("chapter11/11_5.jsp");
				rq.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				String a=req.getParameter("num1");
				String b=req.getParameter("num2");
		
		   try {
				int num1 =Integer.parseInt(a);
				int num2 =Integer.parseInt(b);
					int num3=num1/num2;
					req.setAttribute("num1", num1);
					req.setAttribute("num2", num2);
					req.setAttribute("num3", num3);
					RequestDispatcher rq=req.getRequestDispatcher("chapter11/11_5_a.jsp");
					rq.forward(req, resp);
					
				} catch (Exception e) {
					req.setAttribute("num1", a);
					req.setAttribute("num2", b);
					RequestDispatcher rq=req.getRequestDispatcher("chapter11/11_5_error.jsp");
					rq.forward(req, resp);
				}
		
			
	}

}
