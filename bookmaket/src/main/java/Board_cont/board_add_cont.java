package Board_cont;

import java.io.IOException;
import java.security.Timestamp;
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
		else if(session!=null) {
			mdto mdto=(mdto)session.getAttribute("member");
			if(mdto==null) {
				resp.sendRedirect("member_login");
			}else if(mdto!=null) {
				mdto.getId();
				req.getRequestDispatcher("writeForm.jsp").forward(req, resp);
			}
		}
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("board_add_cont.java dopost() 옴");
		//전처리
		String name=req.getParameter("name");
		String id = null;
		String subject=req.getParameter("subject");
		String content=req.getParameter("content");
		HttpSession session=req.getSession(false);
		if(session!=null) {
			mdto mdto=(mdto)session.getAttribute("member");
			if(mdto!=null) {
				id=mdto.getId();
			}
		}
		 Date currentDatetime = new Date(System.currentTimeMillis());
	     java.sql.Date sqlDate = new java.sql.Date(currentDatetime.getTime());
	     java.sql.Timestamp timestamp = new java.sql.Timestamp(currentDatetime.getTime());

		int hit =0;
		String ip=req.getRemoteAddr();
		Board bd=new Board();
		if(id!=null) {
		bd.setId(id);}
		bd.setName(name);
		bd.setSubject(subject);
		bd.setContent(content);
		bd.setRegist_day(timestamp);
		bd.setHit(hit);
		bd.setIp(ip);
		
		//모델이동
		bordrepository br=bordrepository.getBr();
		br.create(bd);
		
		//뷰이동
		resp.sendRedirect("BoardListAction");
		
	}

}
