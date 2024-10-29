package bookmaket;

import java.io.IOException;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.repository;
import dto.dto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/add")
public class cont5_add extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd =req.getRequestDispatcher("addform.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
/*		String realFolder=req.getServletContext().getRealPath("/resources/images");
		int maxSize=5*1024*1024;
		String encType="utf-8";
		MultipartRequest multi=new MultipartRequest(req,realFolder,maxSize,encType,new DefaultFileRenamePolicy());*/
		String bookId=req.getParameter("bookId");
		String name=req.getParameter("name");
		int unitprice=Integer.parseInt(req.getParameter("unitprice"));
		String author=req.getParameter("author");
		String description=req.getParameter("description");
		String publisher=req.getParameter("publisher");
		String category=req.getParameter("category");
		long unitsInStock=Long.parseLong(req.getParameter("unitsInStock"));
		String releaseDate=req.getParameter("releaseDate");
		String conditione=req.getParameter("conditione");
		String fileName=req.getParameter("fileName");
		
		dto dto=new dto();
		dto.setBookId(bookId);
		dto.setBookname(name);
		dto.setUnitprice(unitprice);
		dto.setAuthor(author);
		dto.setBookdescription(description);
		dto.setPublisher(publisher);
		dto.setCategory(category);
		dto.setUnitsInStock(unitsInStock);
		dto.setReleaseDate(releaseDate);
		dto.setBookconditione(conditione);
		dto.setFileName(fileName);
		
		repository rp=repository.getInstance();
		rp.create(dto);
		
		resp.sendRedirect("books");
	}
	
}
