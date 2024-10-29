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
@WebServlet("/books")
public class cont2_books extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		repository rp=repository.getInstance();
		ArrayList<dto> arr;
		try {
			arr= rp.allread();
			req.setAttribute("arr", arr);
			RequestDispatcher rd=req.getRequestDispatcher("books.jsp");
			rd.forward(req, resp);
		} catch (Exception e) {
			System.out.println("실패"+e.getMessage());
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
