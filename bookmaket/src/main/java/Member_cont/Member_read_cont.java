package Member_cont;

import java.io.IOException;
import java.util.Date;

import dao.mrepository;
import dto.mdto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/member_add")
public class Member_read_cont extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd=req.getRequestDispatcher("addMember.jsp");
		rd.forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//전처리
		req.setCharacterEncoding("UTF-8");

		String id = req.getParameter("id");
		String password = req.getParameter("password");
		String name = req.getParameter("name");
		String gender = req.getParameter("gender");
		String year = req.getParameter("birthyy");
		String month = req.getParameterValues("birthmm")[0];
		String day = req.getParameter("birthdd");
		String birth = year + "/" + month + "/" + day;
		String mail1 = req.getParameter("mail1");
		String mail2 = req.getParameterValues("mail2")[0];
		String mail = mail1 + "@" + mail2;
		String phone = req.getParameter("phone");
		String address = req.getParameter("address");

		Date currentDatetime = new Date(System.currentTimeMillis());
		java.sql.Date sqlDate = new java.sql.Date(currentDatetime.getTime());
		java.sql.Timestamp timestamp = new java.sql.Timestamp(currentDatetime.getTime());
		
		
		mdto mt=new mdto();
		mt.setId(id);
		mt.setPassword(password);
		mt.setName(name);
		mt.setGender(gender);
		mt.setBirth(birth);
		mt.setMail(mail);
		mt.setPhone(phone);
		mt.setAddress(address);
		mt.setRegist_day(timestamp);
	
		//모델이동
		mrepository mr=mrepository.getMr();
		mr.create(mt);
		//뷰이동
		resp.sendRedirect("/bookmaket");
	}

}
