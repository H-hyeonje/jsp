package chapter16;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/16_4")
public class exam16_4 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd =req.getRequestDispatcher("chapter16/16_4.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		String pw=req.getParameter("pw");
		String name=req.getParameter("name");
		System.out.println("여왓냐");
		dto dto=new dto();
		dto.setId(id);
		dto.setPw(pw);
		dto.setName(name);
		System.out.println("여는");
		repostitory2 r2=repostitory2.getinstance();
		r2.creat(dto);
		System.out.println("여기는?");
		
		
		repostitory2 r3=repostitory2.getinstance();
		ArrayList arr=r3.read();
		
		req.setAttribute("arr", arr);
		RequestDispatcher rd =req.getRequestDispatcher("chapter16/16_4_1.jsp");
		rd.forward(req, resp);
	}

}
