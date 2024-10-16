package chapter8;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/8_5")
public class exam8_5 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("chapter8/8_5.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			req.setCharacterEncoding("UTF-8");
			String id=req.getParameter("id");
			String name=req.getParameter("name");
			String pw=req.getParameter("pw");
			String phone1=req.getParameter("phon1");
			String phone2=req.getParameter("phon2");
			String phone3=req.getParameter("phon3");
			String email=req.getParameter("email");
			
			req.setAttribute("id", id);
			req.setAttribute("name", name);
			req.setAttribute("pw", pw);
			req.setAttribute("phon1", phone1);
			req.setAttribute("phon2", phone2);
			req.setAttribute("phon3", phone3);
			req.setAttribute("email", email);

			
			req.getRequestDispatcher("chapter8/8_5_1.jsp").forward(req, resp);
			
	}

}
