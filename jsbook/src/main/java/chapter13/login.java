package chapter13;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/13")
public class login extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("chapter13/13.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//전처리
		String id=req.getParameter("id");
		String pw=req.getParameter("pw");
		
		//모델
		if(id.equals("admin")&&pw.equals("1234")){
			// getSession(true)==getSession()은 현재 세션 객체가 있으면 그냥 쓰고 없으면 새로생성한다.
			//getSession(false)는 현재 세션 객체가 있으면 그냥쓰고 없으면 null을 반환
			HttpSession session=req.getSession(true);
			session.setAttribute("id", id);
			session.setAttribute("pw", pw);
			req.getRequestDispatcher("chapter13/13_print.jsp").forward(req, resp);
		}
		else {
			
		}
		//이동
		

	}

}