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

@WebServlet("/update")
public class cont8_update extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		dto dto=new dto();
		repository rp=repository.getInstance();
		dto =rp.read(id);
		System.out.println("여기왓냐");
		req.setAttribute("dto", dto);
		RequestDispatcher rd=req.getRequestDispatcher("updateBook.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//전처리
		System.out.println("update");
		req.setCharacterEncoding("utf-8");
		String realFolder=req.getServletContext().getRealPath("/resources/images");
	    String encType = "utf-8"; //인코딩 타입
	    int maxSize = 5 * 1024 * 1024; //최대 업로드될 파일의 크기5Mb
	    dto dto=new dto();
		MultipartRequest multi=new MultipartRequest(req,realFolder,maxSize,encType,new DefaultFileRenamePolicy());
		String bookid=multi.getParameter("bookid");
		String bookname=multi.getParameter("bookname");
		int unitprice=0;
				if(multi.getParameter("unitprice")!=null) {
					unitprice=Integer.parseInt(multi.getParameter("unitprice"));
				}
		String author=multi.getParameter("author");
		String publisher=multi.getParameter("publisher");
		String releaseDate=multi.getParameter("releaseDate");
		String bookdescription=multi.getParameter("bookdescription");
		String category=multi.getParameter("category");
		long unitsInStock=0;
			if(multi.getParameter("unitsInStock")!=null) {
				unitsInStock=Long.parseLong(multi.getParameter("unitsInStock"));
			}
		String bookcondition=multi.getParameter("bookcondition");
		String filename=null;
			if(multi.getParameter("fileName")!=null) {
				filename=multi.getParameter("fileName");
			}
			
			
		dto.setBookId(bookid);
		dto.setBookname(bookname);
		dto.setUnitprice(unitprice);
		dto.setAuthor(author);
		dto.setPublisher(publisher);
		dto.setReleaseDate(releaseDate);
		dto.setBookdescription(bookdescription);
		dto.setCategory(category);
		dto.setUnitsInStock(unitsInStock);
		dto.setBookconditione(bookcondition);
		dto.setFileName(filename);
		


		
		
		//모델이동
		repository rp=repository.getInstance();
		rp.update(dto);
		System.out.println("update3");
		//뷰이동
		resp.sendRedirect("books");
		
	}
		
}
