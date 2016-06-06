package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import constants.Constants;
import models.User;
@WebFilter("/registered/*")
public class MainFilter implements Filter{

	public void destroy() {
		
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest) arg0;
		HttpServletResponse resp=(HttpServletResponse) arg1;
		User user=(User) req.getSession().getAttribute(Constants.USER);
		boolean isUser=!("".equals(user) || user==null);
		if(!isUser){
			resp.sendRedirect(req.getContextPath()+"/");		
		}
		else{
			arg2.doFilter(arg0, arg1);
		}

	}

	public void init(FilterConfig arg0) throws ServletException {
		
	}
	
}
