package servlet.user;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.user.UserBean;

@WebServlet("/userlogin")
public class LoginServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			  throws ServletException, IOException {
		String answer=req.getParameter("answer");
		System.out.println("用户输入的验证码是:"+answer);
		HttpSession session = req.getSession();
		String code=(String)session.getAttribute("trueAnswer");
		if(answer.equals(code)) {
			System.out.println("验证码填写正确");
		}else {
			System.out.println("验证码填写不正确");
		}
//		Cookie[] cks=req.getCookies();
//		if(  cks !=  null) {//有cookie
//			for(Cookie ck:cks) {
//				if("hasLogined".equals(ck.getName())) {//有已经登录过的标记
//					resp.getWriter().println("login again");return ;
//				}
//			}
//		}
		String username=req.getParameter("user");
		String pwd     =req.getParameter("password");
		if("root".equals(username)  &&  "1".equals(pwd)) {//处理数据
			Cookie ck=new Cookie("hasLogined","abcdefg1234567");
			ck.setMaxAge(60*10);
			resp.addCookie(ck);
			resp.getWriter().println("login success");
			//保存用户登录状态
			UserBean bean=new UserBean();
			bean.setName(username);
			session.setAttribute("loginedUser", bean);
		}else {
			resp.getWriter().println("login fail");
		}
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
		//		//把表单中的数据，按照数据名称name提取出来
//		String username=req.getParameter("user");
//		String pwd     =req.getParameter("password");
//		if("root".equals(username)  &&  "1".equals(pwd)) {//处理数据
//			resp.getWriter().println("login success");
//		}else {
//			resp.getWriter().println("login fail");
//		}
	}
	
}
