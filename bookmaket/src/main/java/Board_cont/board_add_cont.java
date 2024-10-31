package Board_cont;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import dao.bordrepository;
import dao.mrepository;
import dto.Board;
import dto.mdto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/BoardWriteForm")
public class board_add_cont extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Boar add_cont의 doget()");
		HttpSession session= req.getSession(false);
		if(session==null) {
			resp.sendRedirect("member_login");
		}
		req.getRequestDispatcher("writeForm.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
