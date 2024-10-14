package chapter6;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/6_1")
public class exam6_1 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("chapter6/6_1.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String id=req.getParameter("id");
		String pw=req.getParameter("pw");
		String phone1=req.getParameter("phone1");
		String phone2=req.getParameter("phone2");
		String phone3=req.getParameter("phone3");
		String name=req.getParameter("name");
		String sex=req.getParameter("sex");
		String[] hobby=req.getParameterValues("hobby");
		ArrayList<String> arr=new ArrayList<String>();
		
		if(hobby!=null) {
		for(int i=0;i<hobby.length;i++) {
			if(hobby[i]!=null) {
				arr.add(hobby[i]);
			}
		}
		}
		System.out.println(arr);
		
		req.setAttribute("id", id);
		req.setAttribute("pw", pw);
		req.setAttribute("phone1", phone1);
		req.setAttribute("phone2", phone2);
		req.setAttribute("phone3", phone3);
		req.setAttribute("sex", sex);
		req.setAttribute("hobby", arr);
		req.getRequestDispatcher("chapter6/6_1_1.jsp").forward(req, resp);

	}

}
