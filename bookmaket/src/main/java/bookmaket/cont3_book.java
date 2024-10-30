package bookmaket;

import java.io.IOException;

import dao.repository;
import dto.dto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/book")
public class cont3_book extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String bookid1=req.getParameter("id");
		System.out.println("bookid1");
		dto dto=new dto();
		repository rp=repository.getInstance();
		dto=rp.read(bookid1);
		System.out.println("여옴");
		req.setAttribute("dto", dto);
		RequestDispatcher rd=req.getRequestDispatcher("book.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
	
}
