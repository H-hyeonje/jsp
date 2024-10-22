package filter;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.spi.CalendarDataProvider;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

public class LogFilter implements Filter{
	


	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("BookMarket 초기화....");
	}


	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		System.out.println("접속한 클라이언트 IP :"+arg0.getRemoteAddr());
		long start = System.currentTimeMillis();
		System.out.println("접근한 URL경로 :"+getURLPath(arg0));
		System.out.println("요청 처리 시작 시간 :" +getcurrentTime());
		arg2.doFilter(arg0, arg1);
		
		long end=System.currentTimeMillis();
		System.out.println("요청 처리 종료 시간 :" +getcurrentTime());
		System.out.println("요청 처리 소요 시간 :"+(end-start)+"ms");
		System.out.println("================================================");
		
	}
	
	@Override
	public void destroy() {

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
