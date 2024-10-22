package chapter13;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/13_a")
public class exam13_1 extends HttpServlet{
	String xx="";
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("xx", xx);
		RequestDispatcher rd=req.getRequestDispatcher("chapter13/13_1.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		String pw=req.getParameter("pw");
		if(id.equals("admin")&&pw.equals("1234")) {
			HttpSession h_session=req.getSession();
			xx="안녕하세요 admin님";
			h_session.setAttribute("id", id);
			h_session.setAttribute("xx", xx);
			resp.sendRedirect("chapter13/13_1_1.jsp");
	
		}else {
			xx="개틀림";
			req.setAttribute("xx", xx);
			RequestDispatcher rd=req.getRequestDispatcher("chapter13/13_1.jsp");
			rd.forward(req, resp);
		}
		
	}

}
