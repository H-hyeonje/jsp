package filter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

public class LogFileFilter implements Filter {
		PrintWriter writer;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		String filename=filterConfig.getInitParameter("filename");
		
		if(filename==null) {
			throw new ServletException("로그 파일을 찾을수 없습니다.");
		}
			try {
				writer=new PrintWriter(new FileWriter(filename, true),true);
			} catch (IOException e) {
				throw new ServletException("로그 파일을 열 수 없습니다.");
			}
	}
	

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		writer.println("접속한 클라이언트 IP:"+arg0.getRemoteAddr());
		long start=System.currentTimeMillis();
		writer.println(" 접근 URL 경로"+ getURLPath(arg0));
		writer.println(" 요청 처리 시작 시각"+ getcurrentTime());
		
		arg2.doFilter(arg0, arg1);
		
		long end=System.currentTimeMillis();
		writer.println(" 요청 처리 종료 시각"+ getcurrentTime());
		writer.println(" 요청 처리 소요 시각"+ (end-start)+"ms");
	}
	
	@Override
	public void destroy() {
		writer.close();
	}
	
	private String getURLPath(ServletRequest arg0) {
		HttpServletRequest req;
		String currentPath="";
		String qureyString="";
		if(arg0 instanceof HttpServletRequest) {
			req=(HttpServletRequest)arg0;
			currentPath=req.getRequestURI();
			qureyString=req.getQueryString();
			if(qureyString==null) {
			    qureyString=null;
			}else {
				qureyString=("?"+qureyString);
			}
		
			
		}
		return currentPath+qureyString;
	}


	private String getcurrentTime() {
		DateFormat formatter=new SimpleDateFormat("yyy/MM/dd HH:mm:ss");
		Calendar calendar=Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());
		return formatter.format(calendar.getTime());
	}


	
}
