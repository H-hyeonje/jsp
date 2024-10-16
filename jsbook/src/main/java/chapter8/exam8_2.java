package chapter8;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/8_2")
public class exam8_2 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("chapter8/8_2.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=(String)req.getParameter("id");
		String pw=(String)req.getParameter("pw");
		
		req.setAttribute("id", id);
		req.setAttribute("pw", pw);
		req.getRequestDispatcher("chapter8/8_2_1.jsp").forward(req, resp);
	}

}
