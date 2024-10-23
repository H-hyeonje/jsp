package chapter14;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/14_1")
public class exam14_1  extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd=req.getRequestDispatcher("chapter14/14_1.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user_id=req.getParameter("id");
		String uesr_pw=req.getParameter("pw");
		
		if(user_id.equals("admin") &&uesr_pw.equals("1234")) {
				Cookie cookie_id=new Cookie("user_id",user_id);
				Cookie cookie_pw=new Cookie("uesr_pw",uesr_pw);
				resp.addCookie(cookie_id);
				resp.addCookie(cookie_pw);
				System.out.println("쿠키 생성이 성공함");
				System.out.println(user_id+"님 환영");
				RequestDispatcher rd=req.getRequestDispatcher("chapter14/14_2.jsp");
				rd.forward(req, resp);
		}else {
			System.out.println("쿠키 실패");
			RequestDispatcher rd=req.getRequestDispatcher("chapter14/14_1.jsp");
			rd.forward(req, resp);
		}

	}
	
}
