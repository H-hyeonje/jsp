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
import jakarta.websocket.Session;
@WebServlet("/BoardListAction")
public class board_read_cont extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int pagenum = Integer.parseInt(req.getParameter("pagenum")) ;
		// 한페이지에 출력할 글의 갯수를 제한
		int Limit=5;
		
		
		bordrepository br=bordrepository.getBr();
		ArrayList<Board> arr=br.getAllBoard();
		int total_record =br.getTotalCount();
		int total_page=0;
		if(total_record % Limit==0) {
			 total_page=total_record/Limit;
		}else {
			total_page=(total_record/Limit)+1;
			
		}
		HttpSession session=req.getSession(false);
		mdto mdto=null;
		if(session!=null) {
		mdto=(mdto)session.getAttribute("member");
		if(mdto!=null) {
			mdto.getId();
		}
		}
		req.setAttribute("total_page", total_page);
		req.setAttribute("total_record", total_record);//전체 글의 갯수
		req.setAttribute("pagenum", pagenum );//현재 페이지 번호
		req.setAttribute("list", arr);//전체 글을 담은 객체
		req.getRequestDispatcher("list.jsp").forward(req, resp);
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
