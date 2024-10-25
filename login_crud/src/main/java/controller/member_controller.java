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
@WebServlet("/join")
public class member_controller extends HttpServlet{
// 목표 :creat 데이터를 데이터베이스에 입력하는게 목표
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd=req.getRequestDispatcher("join.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 전처리
		req.setCharacterEncoding("utf-8");
		String id= req.getParameter("id");
		String pw= req.getParameter("pw");
		int age= Integer.parseInt(req.getParameter("age"));
		
		memberdto dto=new memberdto();
		dto.setId(id);
		dto.setPw(pw);
		dto.setAge(age);
		
		// 모델 이동
		memberrepository mr =memberrepository.getInstance();
		mr.member_create(dto);
		
		
		//뷰이동
		resp.sendRedirect("readall");
	}

}
