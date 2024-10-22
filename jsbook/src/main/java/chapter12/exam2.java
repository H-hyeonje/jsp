package chapter12;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Authenticator.RequestorType;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class exam2 implements Filter {
	
	private FilterConfig filterConfig=null;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("Filter02 초기화..");
		this.filterConfig=filterConfig;
		
	}


	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		System.out.println("Filter02 수행..");
		
		
		
		String id=arg0.getParameter("id");
		String pw=arg0.getParameter("password");
		
		String param1=filterConfig.getInitParameter("parm1");
		String param2=filterConfig.getInitParameter("parm2");
	
		String message;
		
		arg1.setCharacterEncoding("utf-8");
		arg1.setContentType("text/html; charset=UTF-8");
		PrintWriter writer=arg1.getWriter();
		
		if(id.equals(param1)&&pw.equals(param2)) {
			message="로그인 성공했습니다.";
		}
		else {
			message="로그인 실패했습니다.";
		}
		
		writer.println(message);
		arg2.doFilter(arg0, arg1);
		
	}
	
	
	@Override
	public void destroy() {
		System.out.println("Filter02 해제..");
	}


	
}
