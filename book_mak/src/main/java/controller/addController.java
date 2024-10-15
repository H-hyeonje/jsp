package controller;
import java.io.IOException;
import dao.*;
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
		
		String bookId=req.getParameter("bookId");
		String name=req.getParameter("name");
		String unitPrice=req.getParameter("unitPrice");
		String author=req.getParameter("author");
		String publisher=req.getParameter("publisher");
		String releaseDate=req.getParameter("releaseDate");
		String description=req.getParameter("description");
		String category=req.getParameter("category");
		String unitsInStock=req.getParameter("unitsInStock");
		String condition=req.getParameter("condition");
		
			System.out.println(bookId);
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
			

		
		dao.addBook(newBook);
		resp.sendRedirect("books.jsp");
	
	}
	
}
