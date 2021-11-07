package servlet.user;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.user.UserService;
@WebServlet("/servlet/user/register")
public class RegServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			  throws ServletException, IOException {
		String user=req.getParameter("username");
		UserService service=new UserService();
		boolean result=service.register(user);
		if(result==true) {
			resp.getWriter().println("success");
		}else {
			resp.getWriter().println("!!error!!");
		}
	}
}
