package chapter12;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/12_2a")
public class exam12_2a extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String id=req.getParameter("id");
			String pw=req.getParameter("password");
			
			req.setAttribute("id", id);
			req.setAttribute("pw", pw);
			req.getRequestDispatcher("chapter12/12_2a.jsp").forward(req, resp);
	}
	
}
