package ctrl.user;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import dao.user.UserDao;
import model.student.Poem;
import model.student.PoemListVo;
import model.student.PoemPostDto;
import model.student.Score;
import model.student.ScoreListVo;
import model.user.UserBean;
import model.user.UserLoginBean;


@Controller
public class UserCtrl {

	//1.用户注册mvc
	@RequestMapping("/reg.mvc")
	@ResponseBody
	public String register(UserBean user) throws IOException {
		System.out.println("成功进入/reg.mvc！!!"+user.getName()+" || "+user.getPwd());
			InputStream in =Resources.getResourceAsStream("mybatis-config.xml");
			SqlSessionFactory ssf=new SqlSessionFactoryBuilder().build(in);
			SqlSession session = ssf.openSession();
			user.setName(java.net.URLDecoder.decode(user.getName(),"utf-8"));
			System.out.println("user.name："+user.getName());
			int result;
			result=session.insert("addUser",user);
			session.commit();
			session.close();
			if(result>0) {
				System.out.println("成功用户注册数据！");
				String msg="200";
				Gson gson=new Gson();
				String jsonText=gson.toJson(msg);
				session.close();
				System.out.println("jsonText:"+jsonText);
			return jsonText;	
			}else{
				System.out.println("用户注册数据失败！");
				String msg="400";
				Gson gson=new Gson();
				String jsonText=gson.toJson(msg);
				session.close();
				System.out.println("jsonText:"+jsonText);
			return jsonText;	
			}	
	}
	

	//用户删除mvc
	@RequestMapping("/delete.mvc")
	@ResponseBody
	public String delete(UserBean user) throws IOException {
		System.out.print("成功进入/delete.mvc！");
			InputStream in =Resources.getResourceAsStream("mybatis-config.xml");
			SqlSessionFactory ssf=new SqlSessionFactoryBuilder().build(in);
			SqlSession session = ssf.openSession();
			int result;
			result=session.delete("deleteUser",user.getId());
			session.commit();
			session.close();
			if(result>0) {
				System.out.println("成功删除用户数据！");
				String msg="200";
				Gson gson=new Gson();
				String jsonText=gson.toJson(msg);
				session.close();
				System.out.println("jsonText:"+jsonText);
			return jsonText;	
			}else{
				System.out.println("用户删除数据失败！");
				String msg="400";
				Gson gson=new Gson();
				String jsonText=gson.toJson(msg);
				session.close();
				System.out.println("jsonText:"+jsonText);
			return jsonText;	
			}
	}
	//1.用户查看mvc
	@RequestMapping("/select.mvc")
	@ResponseBody
	public String select(
			@RequestParam(value= "page", required = false, defaultValue ="") String page,
			@RequestParam(value= "count", required = false, defaultValue ="")String count,
			PoemPostDto user) throws IOException {
		System.out.print("成功进入/select.mvc！");
			InputStream in =Resources.getResourceAsStream("mybatis-config.xml");
			SqlSessionFactory ssf=new SqlSessionFactoryBuilder().build(in);
			SqlSession session = ssf.openSession();
			List<UserBean> list=session.selectList("selectUser",user.getId());
			if(list.size()>0) {
				System.out.println("找到这个用户了");
			}else {
				System.out.println("没有这个用户");
			}
			System.out.println("用户有： "+list.size()+"位。");	
			session.commit();
			session.close();
			String msg="400";
			Gson gson=new Gson();
			String jsonText=gson.toJson(list);		
			System.out.println("jsonText:"+jsonText);
		return jsonText;
	}
	//1.用户查看所有mvc
		@RequestMapping("/selectAllUser.mvc")
		@ResponseBody
		public String selectAll(
				@RequestParam(value= "page", required = false, defaultValue ="") String page,
				@RequestParam(value= "count", required = false, defaultValue ="")String count,
				PoemPostDto poem) throws IOException {
			System.out.println("成功进入/selectAllUser.mvc！");
				InputStream in =Resources.getResourceAsStream("mybatis-config.xml");
				SqlSessionFactory ssf=new SqlSessionFactoryBuilder().build(in);
				SqlSession session = ssf.openSession();
				
				int begin=0;
				int end=0;
				int totalPage;
				page=poem.getPage();
				count=poem.getCount();
				if(page=="") {
					poem.setPage("1");
					page=poem.getPage();
				}
				if(count=="") {
					poem.setCount("10");//默认每10条一页
					count=poem.getCount();
				}
				if(page=="null") {
					poem.setPage("1");
					page=poem.getPage();
				}
				if(count=="null") {
					poem.setCount("10");//默认每10条一页
					count=poem.getCount();
				}
				System.out.println("total:"+poem.getTotal()+" page:"+poem.getPage()+" count:"+poem.getCount());
				List<PoemPostDto> list123=session.selectList("selectAllUser",poem);
				int total=list123.size();
				
				System.out.println("page2:"+page+"count:"+count);
				int page2=Integer.parseInt(page);
				int count2=Integer.parseInt(count);
				System.out.println("count2:"+count2+"   你输入的是第几页:"+page2);
				totalPage=(total/count2);
				if(total%count2>0) {
					totalPage=page2+1;
				}
				System.out.println("总计有"+totalPage+"页");
				if(begin==0) {
					begin=1;
				}
					begin=(page2-1)*count2;
					end=count2;
				if(count2==1){
					begin=1;
					end=count2;
				}
				poem.setBegin(Integer.toString(begin));
				poem.setEnd(Integer.toString(end));
				System.out.println(poem.getBegin()+"到"+poem.getEnd());
				
				
				
				List<PoemPostDto> list=session.selectList("selectAllUser",poem);
//				for(int i=0;i<list.size();i++) {
//					PoemPostDto plist=list.get(i);
//					plist.setTotal(total);
//				}
				if(list.size()>0) {
					System.out.println("成功找到全部诗人数据！");
					String msg="200";
					Gson gson=new Gson();
					String jsonText=gson.toJson(list);
					session.close();
					System.out.println("jsonText:"+jsonText);
				return jsonText;	
				}else{
					System.out.println("未找到全部诗词数据！");
					String msg="400";
					Gson gson=new Gson();
					String jsonText=gson.toJson(msg);
					session.close();
					System.out.println("jsonText:"+jsonText);
				return jsonText;	
				}	
				
		}
	
	//用户修改mvc
		@RequestMapping("/update.mvc")
		@ResponseBody
		public String update(
				UserBean user) throws IOException {
			System.out.print("成功进入/update.mvc！");
				InputStream in =Resources.getResourceAsStream("mybatis-config.xml");
				SqlSessionFactory ssf=new SqlSessionFactoryBuilder().build(in);
				SqlSession session = ssf.openSession();
//				user.setName(java.net.URLDecoder.decode(user.getName(),"utf-8"));
				int result;
				result=session.delete("updateUser",user);
				session.commit();
				session.close();
				System.out.println("result结果:"+result);
				if(result>0) {
					System.out.println("成功用户修改数据！");
					String msg="200";
					Gson gson=new Gson();
					String jsonText=gson.toJson(msg);
					session.close();
					System.out.println("jsonText:"+jsonText);
				return jsonText;	
				}else{
					System.out.println("用户修改数据失败！");
					String msg="400";
					Gson gson=new Gson();
					String jsonText=gson.toJson(msg);
					session.close();
					System.out.println("jsonText:"+jsonText);
				return jsonText;	
				}
		}
		//用户登录mvc
				@RequestMapping(value="/userLogin.mvc",method=RequestMethod.POST)
				@ResponseBody
				public String userLogin(UserBean user) throws IOException {
					
					String name="";
					String pwd="";
					System.out.println("成功进入/userLogin.mvc！");
					System.out.println("用户登录数据："+user.getName()+" :"+user.getPwd());
					System.out.println("用户登录数据:"+name+pwd);
					InputStream in =Resources.getResourceAsStream("mybatis-config.xml");
					SqlSessionFactory ssf=new SqlSessionFactoryBuilder().build(in);
					SqlSession session = ssf.openSession();
					UserLoginBean ulb=new UserLoginBean();
					List<UserBean> list=session.selectList("userLogin",user);
					session.commit();
					System.out.println("result结果:"+list.size());
					if(list.size()>0) {
						String msg="";
						System.out.println("用户登录成功！");
						for(int i=0;i<list.size();i++) {
							UserBean ulist=list.get(i);
							ulb.setMsg("200");
							ulb.setStaus(ulist.getStaus());
							ulb.setId(ulist.getId());
							System.out.println("诗词数据getStaus："+ulist.getStaus()+" : "+ulist.getId());
						}
						
						Gson gson=new Gson();
						String jsonText=gson.toJson(ulb);
						session.close();
						System.out.println("jsonText:"+jsonText);
					return jsonText;	
					}else{
						System.out.println("用户登录失败！");
						String msg="400";
						Gson gson=new Gson();
						String jsonText=gson.toJson(msg);
						session.close();
						System.out.println("jsonText:"+jsonText);
					return jsonText;	
					}
				}
	
}
