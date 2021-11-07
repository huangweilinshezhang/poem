package servlet.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.user.UserDao;
import model.user.UserBean;
import pub.DatagridBean;
@WebServlet("/user/grid")
public class UsergridServlet extends HttpServlet{
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//String json="{\"total\":1,\"rows\":[{\"id\":1,\"name\":\"ada\"}]}";
		//{"total":1,"rows":[{"id":12,"name":"abc"}] }System.out.println("ab\"cd");
		String p=req.getParameter("page");
		String m=req.getParameter("rows");
		if(p==null) p="1";//如果前台没有传参数，默认显示第一页的数据
		if(m==null) m="2";//如果前台没有传参数，默认每一页最多显示2条数据
		int page=Integer.parseInt(p);int max=Integer.parseInt(m);
		
		UserDao dao=new UserDao();
		List<UserBean> list=dao.queryUserList(page, max);//dao.queryUserList(1, 10);
		DatagridBean data=new DatagridBean();
		data.setTotal(dao.countTotal());
		data.setRows(list);
		Gson gson=new Gson();
		String json=gson.toJson(data);
		System.out.println("发送给datagrid的数据是:\n\t"+json);
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().println(json);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
}
