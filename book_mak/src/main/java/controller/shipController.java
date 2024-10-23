package controller;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/shipp")
public class shipController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cartId=req.getParameter("cartId");
		HttpSession session=req.getSession(false);
		session.getAttribute("cartId");
		if("1".equals(req.getParameter("a"))) {
			//배송 정보
			session.setAttribute("cartId", cartId);
			System.out.println(req.getParameter("cartId"));
			req.getRequestDispatcher("shipping.jsp").forward(req, resp);
		}
		
		if("12".equals(req.getParameter("aa"))) {
			req.setCharacterEncoding("utf-8");
			
			 cartId=session.getId();
			 String shipping_cartId="";
			 String shipping_name="";
			 String shipping_shippingDate="";
			 String shipping_country="";
			 String shipping_zipCode="";
			 String shipping_addressName="";
			 
			Cookie[] cookies=req.getCookies();
			if(cookies!=null) {
				for(int i=0;i<cookies.length;i++) {
					Cookie thisCookie=cookies[i];
					String n=thisCookie.getName();
					if(n.equals("shipping_cartId")) {
						shipping_cartId=URLDecoder.decode((thisCookie.getValue()),"utf-8");
					}
					if(n.equals("shipping_name")) {
						shipping_name=URLDecoder.decode((thisCookie.getValue()),"utf-8");
					}
					if(n.equals("shipping_shippingDate")) {
						shipping_shippingDate=URLDecoder.decode((thisCookie.getValue()),"utf-8");
					}
					if(n.equals("shipping_country")) {
						shipping_country=URLDecoder.decode((thisCookie.getValue()),"utf-8");
					}
					if(n.equals("shipping_zipCode")) {
						shipping_zipCode=URLDecoder.decode((thisCookie.getValue()),"utf-8");
					}
					if(n.equals("shipping_addressName")) {
						shipping_addressName=URLDecoder.decode((thisCookie.getValue()),"utf-8");
					}
				}
			}
			System.out.println(shipping_cartId);
			req.setAttribute("cookie", shipping_cartId);
			req.getRequestDispatcher("orderConfirmation.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession(false);
		session.getAttribute("cartId");
		
		req.setCharacterEncoding("utf-8");
		
		Cookie cartId=new Cookie("Shipping_cartId",URLEncoder.encode(req.getParameter("cartId"),"utf-8"));
		
		Cookie name=new Cookie("Shipping_name",URLEncoder.encode(req.getParameter("name"),"utf-8"));
		Cookie shippingDate=new Cookie("Shipping_shippingDate",URLEncoder.encode(req.getParameter("shippingDate"),"utf-8"));
		Cookie country=new Cookie("Shipping_country",URLEncoder.encode(req.getParameter("country"),"utf-8"));
		Cookie zipCode=new Cookie("Shipping_zipCode",URLEncoder.encode(req.getParameter("zipCode"),"utf-8"));
		Cookie addressName=new Cookie("Shipping_addressName",URLEncoder.encode(req.getParameter("addressName"),"utf-8"));
		
		cartId.setMaxAge(24*60*60);
		name.setMaxAge(24*60*60);
		shippingDate.setMaxAge(24*60*60);
		country.setMaxAge(24*60*60);
		zipCode.setMaxAge(24*60*60);
		addressName.setMaxAge(24*60*60);
		
		resp.addCookie(cartId);
		resp.addCookie(name);
		resp.addCookie(shippingDate);
		resp.addCookie(country);
		resp.addCookie(zipCode);
		resp.addCookie(addressName);
		
		
		resp.sendRedirect("shipp?aa=12");
	}
	
}
