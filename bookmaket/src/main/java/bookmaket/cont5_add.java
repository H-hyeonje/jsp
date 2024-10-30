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
		
		String realFolder=req.getServletContext().getRealPath("/resources/images");
		System.out.println(realFolder);
		int maxSize=5*1024*1024;
		String encType="utf-8";
		MultipartRequest multi=new MultipartRequest(req,realFolder,maxSize,encType,new DefaultFileRenamePolicy());
		String bookId=multi.getParameter("bookid");
		String Bookname=multi.getParameter("bookname");
		
		String author=multi.getParameter("author");
		String Bookdescription=multi.getParameter("bookdescription");
		String publisher=multi.getParameter("publisher");
		String category=multi.getParameter("category");
		int unitprice=0;
		long unitsInStock=0;
		String releaseDate=multi.getParameter("releaseDate");
		String Bookconditione=multi.getParameter("conditione");
		String fileName=multi.getParameter("bookImage");
		if(multi.getParameter("unitprice")!=null||multi.getParameter("unitsInStock")!=null) {
		unitprice=Integer.parseInt(multi.getParameter("unitprice"));
		unitsInStock=Long.parseLong(multi.getParameter("unitsInStock"));
		}
		dto dto=new dto();
		dto.setBookId(bookId);
		dto.setBookname(Bookname);
		dto.setUnitprice(unitprice);
		dto.setAuthor(author);
		dto.setBookdescription(Bookdescription);
		dto.setPublisher(publisher);
		dto.setCategory(category);
		dto.setUnitsInStock(unitsInStock);
		dto.setReleaseDate(releaseDate);
		dto.setBookconditione(Bookconditione);
		dto.setFileName(fileName);
		System.out.println(dto.getBookId());
		repository rp=repository.getInstance();
		rp.create(dto);
		
		resp.sendRedirect("books");
	}
	
}
