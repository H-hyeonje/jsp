package Member_cont;

import java.io.IOException;
import java.util.Date;

import dao.mrepository;
import dto.mdto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/member_login")
public class Member_read_one_cont extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//전처리
		//모델이동
		//뷰이동
		System.out.println("도착");
		String error=req.getParameter("error");
		req.setAttribute("error", error);
		RequestDispatcher rd=req.getRequestDispatcher("loginMember.jsp");
		rd.forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//전처리
		String id=req.getParameter("id");
		String password=req.getParameter("password");
		//모델이동
		mrepository mr=mrepository.getMr();
		mdto dto=mr.getUse(id,password);
			if(dto!=null && dto.getId().equals(id)) { 
				HttpSession session=req.getSession(true);
				session.setAttribute("member", dto);
				RequestDispatcher rd=req.getRequestDispatcher("resultMember.jsp?msg=2");
				rd.forward(req, resp);

			}
			else{
				System.out.println("여는");
				resp.sendRedirect("member_login?error=1");
			}
		}	

	}


