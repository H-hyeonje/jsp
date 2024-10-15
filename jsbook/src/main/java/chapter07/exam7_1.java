package chapter07;

import java.io.IOException;
import java.util.Enumeration;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/7_1")
public class exam7_1 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("chapter7/7_1.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String save=req.getServletContext().getRealPath("img");
		MultipartRequest multi=new MultipartRequest(req,save,5* 1024*1024,"utf-8",new DefaultFileRenamePolicy()); 	
		String name=multi.getParameter("name");
		String subject=multi.getParameter("subject");
		String filename=multi.getFilesystemName("filename");
		req.setAttribute("aa",name );
		req.setAttribute("bb",subject );
		req.setAttribute("cc",filename );
		req.getRequestDispatcher("chapter7/7_1_1.jsp").forward(req, resp);
		
	}
	
}
