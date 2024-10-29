package chapter16;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/16_2")
public class exam16_2 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		RequestDispatcher rd=req.getRequestDispatcher("chapter16/16_3.jsp");
		rd.forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    req.setCharacterEncoding("UTF-8");

		String id=req.getParameter("id");
		String pw=req.getParameter("pw");
		String name=req.getParameter("name");
		
		dto dto=new dto();
		dto.setId(id);
		dto.setPw(pw);
		dto.setName(name);
		System.out.println(dto.getId());
		repository rp=repository.getinstance();
		rp.creat2(dto);
		
		
		RequestDispatcher rd=req.getRequestDispatcher("chapter16/16_2.jsp");
		rd.forward(req, resp);
		
		
		
		
		
	}
	
}
