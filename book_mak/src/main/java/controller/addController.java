package controller;
import java.io.IOException;
import java.util.Enumeration;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.BookRepository;
import dto.Book;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/add")
public class addController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			req.getRequestDispatcher("addBook.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		
		String realFolder=req.getServletContext().getRealPath("/resources/images");
		int maxSize=5*1024*1024;
		String encType="utf-8";
		System.out.println(realFolder);
		MultipartRequest multi=new MultipartRequest(req,realFolder,maxSize,encType,new DefaultFileRenamePolicy());
		
		String bookId=multi.getParameter("bookId");
		String name=multi.getParameter("name");
		String unitPrice=multi.getParameter("unitPrice");
		String author=multi.getParameter("author");
		String publisher=multi.getParameter("publisher");
		String releaseDate=multi.getParameter("releaseDate");
		String description=multi.getParameter("description");
		String category=multi.getParameter("category");
		String unitsInStock=multi.getParameter("unitsInStock");
		String condition=multi.getParameter("condition");
		String fileName = multi.getFilesystemName("BookImge");
		
		Integer price=0;
		if(unitPrice!=null) {
			if(unitPrice.isEmpty()) {
				price=0;
			}
			else {
				price=Integer.valueOf(unitPrice);
				}
			}
		
		
		long stock=0;
		if(unitsInStock!=null) {
			if(unitsInStock.isEmpty()){
				stock=0;
			}
			else{
				stock=Long.valueOf(unitsInStock);
			}
		}
		BookRepository dao=BookRepository.getInstance();
		
		Book newBook=new Book(bookId,name,price);
			newBook.setAuthor(author);
			newBook.setDescription(description);
			newBook.setPublisher(publisher);
			newBook.setCategory(category);
			newBook.setUnitsInStock(stock);		
			newBook.setReleaseDate(releaseDate);
			newBook.setCondition(condition);
			newBook.setFileName(fileName);
		System.out.println(realFolder);
		System.out.println(fileName);
		dao.addBook(newBook);
		resp.sendRedirect("books.jsp");
	
	}
	
}
