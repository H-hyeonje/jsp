package controller;

import java.io.IOException;
import java.util.ArrayList;

import dao.memberrepository;
import dto.memberdto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/readall")
public class member_controller2 extends HttpServlet {
// 목표 : read 여러개의 dto를 읽어와서 뷰에 출력하는것이 목표
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//전처리 : 파라미터 없어서 생략함
		
		
		
		//모델이동
		memberrepository  mr= memberrepository.getInstance();
		ArrayList<memberdto> arr;
		//뷰이동
		try {
			arr = mr.getAllmember();
			req.setAttribute("list",arr);
			RequestDispatcher rd=req.getRequestDispatcher("all.jsp");
			rd.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
