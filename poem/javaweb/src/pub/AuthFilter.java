package pub;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
/**检查用户是否登录*/
//@WebFilter("/*")//三种配置方式:/*(/xx/*)    后缀名*.txt       精确匹配
public class AuthFilter implements Filter{
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("AuthFilter.doFilter()");
		HttpServletRequest req=(HttpServletRequest)request;
		String[] whiteList= {"/javaweb/login.html","/javaweb/reg.jsp"
		,"/javaweb/code","/javaweb/userlogin","/javaweb/servlet/user/register"};
		String target=req.getRequestURI();//要访问的目标资源
		boolean isInWhiteList=false;//是否在白名单中
		for(String white:whiteList) {
			if(target.equals(white)) {
				isInWhiteList=true;break;
			}
		}
		if(target.startsWith("/javaweb/js/")) {
			isInWhiteList=true;
		}
		HttpSession session=req.getSession();
		Object obj=session.getAttribute("loginedUser");
		if( obj != null || isInWhiteList) {//用户已经登录
			chain.doFilter(request, response);//放行，到下一个环节（可能是另一个过滤器，也可能是目标资源）
		}else {
			//拦截，不放行
		}
	}
	public void init(FilterConfig arg0) throws ServletException {}
	public void destroy() {}
}
