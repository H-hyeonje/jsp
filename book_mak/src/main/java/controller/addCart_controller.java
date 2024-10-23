package controller;

import java.io.IOException;
import java.util.ArrayList;

import dao.BookRepository;
import dto.Book;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;
@WebServlet("/addCart")
public class addCart_controller extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String aa=req.getParameter("aa");
		String id=req.getParameter("bookid");
		HttpSession session=req.getSession(false);
		session.getAttribute("cartlist");
		if(aa.equals("1")) {
			
			resp.sendRedirect("cart.jsp");
			
		}
		else {
			resp.sendRedirect("cart.jsp");	
		}
		
		
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		String id=req.getParameter("id");
		if(id==null || id.trim().equals("")) {
			resp.sendRedirect("/Books");
			
		}
	BookRepository dao=BookRepository.getInstance();
	
	Book book=dao.getBookById(id);
		if(book==null) {
			resp.sendRedirect("/error");
		}
		
	ArrayList<Book> goodsList=dao.getAllBooks();
	Book goods=new Book();
		for(int i=0;i< goodsList.size();i++) {
			goods=goodsList.get(i);
			if(goods.getBookId().equals(id)) {
				break;
			}
		}
		
		
	ArrayList<Book> list=(ArrayList<Book>)session.getAttribute("cartlist");
		if(list==null) {
			list=new ArrayList<Book>();
			session.setAttribute("cartlist", list);
		}
		
	int cnt=0;
	Book goodsQnt=new Book();
		for(int i=0;i<list.size();i++) {
			goodsQnt=list.get(i);
			if(goodsQnt.getBookId().equals(id)) {
				cnt++;
				int orderQuantity=goodsQnt.getQuantity()+1;
				goodsQnt.setQuantity(orderQuantity);
			}
		}
		
		if(cnt==0) {
			goods.setQuantity(1);
			list.add(goods);
		}
	resp.sendRedirect("cart.jsp");
		
	}
	
}