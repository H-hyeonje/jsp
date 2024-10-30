package bookmaket;

import java.io.IOException;
import java.util.ArrayList;

import dao.repository;
import dto.dto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/editbook")
public class cont6_del extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("edit doget 접속");
		//전처리
		String edit=req.getParameter("edit");
		ArrayList<dto> arr=new ArrayList();
		//모델이동
		repository rp=repository.getInstance();
		arr=rp.allread();
		//뷰이동 
		req.setAttribute("list",arr);
		req.setAttribute("edit",edit );
		RequestDispatcher rs=req.getRequestDispatcher("editBook.jsp");
		rs.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("edit dopost 접속");
	}
	
}
