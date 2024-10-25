package controller;

import java.io.IOException;

import dao.memberrepository;
import dto.memberdto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class member_controller4 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//전처리
		String userid =req.getParameter("id");
		
		//모델 이동
		memberrepository mr=memberrepository.getInstance();
		memberdto dto=mr.getonemember(userid);
		
		
		//뷰이동
		req.setAttribute("dto", dto);
		RequestDispatcher rd=req.getRequestDispatcher("updateform.jsp");
		rd.forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		String pw =req.getParameter("pw");
		int age=Integer.parseInt(req.getParameter("age"));
		memberdto dto=new memberdto();
		dto.setId(id);
		dto.setPw(pw);;
		dto.setAge(age);
		memberrepository mr=memberrepository.getInstance();
		mr.updatemember(dto);
		
		resp.sendRedirect("readall");
	}

}
