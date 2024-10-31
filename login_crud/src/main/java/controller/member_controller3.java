package controller;

import java.io.IOException;

import dao.memberrepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/delete")
public class member_controller3 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 전처리
		String id=req.getParameter("id");
		
		//모델이동
		memberrepository mr=memberrepository.getInstance();
		mr.deleteuser(id);
		//뷰이동
		resp.sendRedirect("readall");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
	
}