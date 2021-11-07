package ctrl.user;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dao.user.PoemDao;
import model.student.GameData;
import model.student.Poem;
import model.student.PoemPostDto;
import model.student.Poet;
import model.user.Driver;
import model.user.UserBean;
import model.student.Poem;

@Controller
public class PoemCtrl {
	//
	
	//1.查询所有诗词数据
	@RequestMapping("/ctrl/selectAllPoem.mvc")
	@ResponseBody
	public String selectAllPoem(
			@RequestParam(value= "poet", required = false, defaultValue ="") String poet,
			@RequestParam(value= "dynasty", required = false, defaultValue ="")String dynasty,
			@RequestParam(value= "type", required = false, defaultValue ="")String type,
			@RequestParam(value= "page", required = false, defaultValue ="") String page,
			@RequestParam(value= "count", required = false, defaultValue ="")String count,
			PoemPostDto poem) throws IOException {
		System.out.println("进入selectAllPoem：");
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
			System.out.println("total:"+poem.getTotal()+" page:"+poem.getPage()+" count:"+poem.getCount());
			List<PoemPostDto> list123=session.selectList("selectAllPoem",poem);
			int total=list123.size();
			
			System.out.println("total!==>"+total);
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
			
			List<PoemPostDto> list=session.selectList("selectAllPoem",poem);
			for(int i=0;i<list.size();i++) {
				PoemPostDto plist=list.get(i);
				poem.setTotal(list.size());	
				plist.setTotal(total);
			}
			if(list.size()>0) {
				System.out.println("成功找到全部诗词数据！");
				
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
//2.结束	
	
	
	//2.增加诗词spring-mvc
		@RequestMapping("/ctrl/addPoem.mvc")
		@ResponseBody
		public String addPoem(PoemPostDto poem) throws IOException {
				InputStream in =Resources.getResourceAsStream("mybatis-config.xml");
				SqlSessionFactory ssf=new SqlSessionFactoryBuilder().build(in);
				SqlSession session = ssf.openSession();
				List<PoemPostDto> list=session.selectList("selectAutherId",poem.getAuther());
				for(int i=0;i<list.size();i++) {
					PoemPostDto plist=list.get(i);
					System.out.println("诗词数据"+plist.getId());
					int pid = Integer.parseInt(String.valueOf(plist.getId()));
					poem.setPoemId(pid);
				}
				if(list.size()==0) {
					int result=session.insert("addPoet",poem);
					if(result>0) {System.out.println("成功增加诗人数据！");}else {System.out.println("失败增加诗人数据！");}
					List<PoemPostDto> list2=session.selectList("selectAutherId",poem.getAuther());
					for(int i=0;i<list2.size();i++) {
						PoemPostDto plist=list2.get(i);
						System.out.println("诗词数据"+plist.getId());
						int pid = Integer.parseInt(String.valueOf(plist.getId()));
						poem.setPoemId(pid);
					}
				}
				System.out.println("poem:"+" poemId:"+poem.getPoemId()+" "+poem.getTitle()+" "+poem.getAuther()+" "+poem.getContent());
				int result;
				result=session.insert("addPoem",poem);
				session.commit();
				session.close();
				System.out.println("result结果:"+result);
				if(result>0) {
					System.out.println("成功增加诗词数据！");
					String msg="200";
					Gson gson=new Gson();
					String jsonText=gson.toJson(msg);
					session.close();
					System.out.println("jsonText:"+jsonText);
				return jsonText;	
				}else{
					System.out.println("增加诗词数据失败！");
					String msg="400";
					Gson gson=new Gson();
					String jsonText=gson.toJson(msg);
					session.close();
					System.out.println("jsonText:"+jsonText);
				return jsonText;	
				}
		}
//3.删除诗词spring-mvc
				@RequestMapping("/ctrl/deletePoem.mvc")
				@ResponseBody
				public String deletePoem(Poem poem) throws IOException {
						
						InputStream in =Resources.getResourceAsStream("mybatis-config.xml");
						SqlSessionFactory ssf=new SqlSessionFactoryBuilder().build(in);
						SqlSession session = ssf.openSession();
						int result;
						result=session.insert("deletePoem",poem.getId());
						session.commit();
						session.close();
						
						System.out.println("result结果:"+result);
						if(result>0) {
							System.out.println("成功删除诗词数据！");
							String msg="200";
							Gson gson=new Gson();
							String jsonText=gson.toJson(msg);
							session.close();
							System.out.println("jsonText:"+jsonText);
						return jsonText;	
						}else{
							System.out.println("删除诗词数据失败！");
							String msg="400";
							Gson gson=new Gson();
							String jsonText=gson.toJson(msg);
							session.close();
							System.out.println("jsonText:"+jsonText);
						return jsonText;	
						}
				}
//4.修改诗词spring-mvc
				@RequestMapping("/ctrl/updatePoem.mvc")
				@ResponseBody
				public String updatePoem(PoemPostDto poem) throws IOException {
						System.out.println("成功进入/updatePoem.mvc！"
								+poem.getId()+" "+poem.getTitle()+" "+poem.getPoemId());
						InputStream in =Resources.getResourceAsStream("mybatis-config.xml");
						SqlSessionFactory ssf=new SqlSessionFactoryBuilder().build(in);
						SqlSession session = ssf.openSession();
						Gson gson=new Gson();
						int result;
						int result1;
						int result2;
						int pid;
						List<PoemPostDto> list=session.selectList("selectAutherId",poem.getAuther());
						session.commit();
						for(int i=0;i<list.size();i++) {
							PoemPostDto plist=list.get(i);
						    pid = Integer.parseInt(String.valueOf(plist.getId()));
						    poem.setPoemId(pid);
						  //修改诗句
							result1=session.insert("updatePoemId",poem);
							session.commit();
							result=session.insert("updatePoem2",poem);
							session.commit();
						}
						if(list.size()>0) {
							System.out.println("查询有这个诗人存在:"
									+poem.getId()+" "+poem.getTitle()+" "+poem.getPoemId());
							//修改诗句的诗人
							result1=session.insert("updatePoem",poem);
							session.commit();
							if(result1>0) {
								System.out.println("成功修改诗词的诗人id数据！");
							}
							System.out.println("成功修改诗词数据！");
							String msg="200";
							String jsonText=gson.toJson(msg);
							session.close();
							System.out.println("jsonText:"+jsonText);
						return jsonText;	
						}else{
							System.out.println("没有这个诗人");
							String msg="400";
							String jsonText=gson.toJson(msg);
							session.close();
							System.out.println("jsonText:"+jsonText);
						return jsonText;	
						}		
				}
//5.查看诗词spring-mvc
				@RequestMapping("/ctrl/selectPoem.mvc")
				@ResponseBody
				public String selectPoem(PoemPostDto poem) throws IOException {
						System.out.println("成功进入/selectPoem.mvc！");
						InputStream in =Resources.getResourceAsStream("mybatis-config.xml");
						SqlSessionFactory ssf=new SqlSessionFactoryBuilder().build(in);
						SqlSession session = ssf.openSession();
						
						List<PoemPostDto> list=session.selectList("selectPoem",poem.getId());
						for(int i=0;i<list.size();i++) {
							PoemPostDto plist=list.get(i);
							System.out.println("成功"+plist);
						}
						if(list.size()>0) {
							System.out.println("成功找到全部诗词数据！");
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
//6.查看诗词所有类型spring-mvc
				@RequestMapping("/ctrl/selectAllType.mvc")
				@ResponseBody
				public String selectAllType(PoemPostDto poem) throws IOException {
						System.out.println("成功进入/selectAllType.mvc！");
						InputStream in =Resources.getResourceAsStream("mybatis-config.xml");
						SqlSessionFactory ssf=new SqlSessionFactoryBuilder().build(in);
						SqlSession session = ssf.openSession();
						String page="";
						String count="";
						int begin=0;
						int end=0;
						int totalPage;
						page=poem.getPage();
						count=poem.getCount();
						if(page=="") {
							poem.setPage("1");
							
						}
						if(count=="") {
							poem.setCount("10");//默认每10条一页
							
						}
						if(page=="null") {
							poem.setPage("1");
						}
						if(count=="null") {
							poem.setCount("10");//默认每10条一页	
						}
						System.out.println("total:"+poem.getTotal()+" page:"+poem.getPage()+" count:"+poem.getCount());
						List<PoemPostDto> list123=session.selectList("selectAllPoem",poem);
						int total=list123.size()+1;
						int page2=Integer.parseInt(poem.getPage());
						int count2=Integer.parseInt(poem.getCount());
						System.out.println("count2:"+count2+"   你输入的是第几页:"+page2);
						totalPage=(total/count2);
						if((total-1)%count2>0) {
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
						List<PoemPostDto> list=session.selectList("selectAllType",poem);
						for(int i=0;i<list.size();i++) {
							PoemPostDto plist=list.get(i);
							System.out.println("成功"+plist);
						}
						if(list.size()>0) {
							System.out.println("成功找到全部诗词数据！");
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
//7.查看所有作者spring-mvc
				@RequestMapping("/ctrl/selectAllAuther.mvc")
				@ResponseBody
				public String selectAllAuther(
						@RequestParam(value= "poet", required = false, defaultValue ="") String poet,
						@RequestParam(value= "dynasty", required = false, defaultValue ="")String dynasty,
						@RequestParam(value= "type", required = false, defaultValue ="")String type,
						@RequestParam(value= "page", required = false, defaultValue ="") String page,
						@RequestParam(value= "count", required = false, defaultValue ="")String count,
						PoemPostDto poem) throws IOException {
						System.out.println("成功进入/selectAllAuther.mvc！"+poem.getPoet());
						InputStream in =Resources.getResourceAsStream("mybatis-config.xml");
						SqlSessionFactory ssf=new SqlSessionFactoryBuilder().build(in);
						SqlSession session = ssf.openSession();
						
						int begin=0;
						int end=0;
						int totalPage;
						int totalAuther;
						
						System.out.println("dynasty:==>"+dynasty+"");
						System.out.println("poet:==>"+poet+"]");
						if(dynasty!="") {
//							System.out.println("进入到了年代不为空的判断");
							List<PoemPostDto> list444=session.selectList("selectAllPoemId",poem);
							System.out.println("啊啊啊啊"+list444.size());
							//开始
							for(int i=0;i<list444.size();i++) {
								PoemPostDto plist=list444.get(i);
//								plist.setTotal(list444.size());
								System.out.println("获取到的poemId==>:"+plist.getPoemId());
								int a=plist.getPoemId();
								long b=(int) a;
								poem.setId(b);
								List<PoemPostDto> list151=session.selectList("selectPoetById",poem.getId());
								System.out.println("----------->"+list151.size());
								System.out.println("成功找到诗人数据!!!!!!!!!!!!！");
								Gson gson=new Gson();
								String jsonText=gson.toJson(list151);
								session.close();
								System.out.println("list151的jsonText:"+jsonText);
								return jsonText;
							}
							//结束
							
						}
						page=poem.getPage();
						count=poem.getCount();
						if(page=="") {
							poem.setPage("1");
							
						}
						if(count=="") {
							poem.setCount("10");//默认每10条一页
							
						}
						if(page=="null") {
							poem.setPage("1");
						}
						if(count=="null") {
							poem.setCount("10");//默认每10条一页	
						}
						System.out.println("total:"+poem.getTotal()+" page:"+poem.getPage()+" count:"+poem.getCount());
						totalAuther=Integer.parseInt(poem.getCount());
						List<PoemPostDto> list123=session.selectList("selectAllAuther",poem);
						int total=list123.size()+1;
//						System.out.println("total:!!!!!!!!!!!:"+total);
						int page2=Integer.parseInt(poem.getPage());
						int count2=Integer.parseInt(poem.getCount());
						System.out.println("count2:"+count2+"   你输入的是第几页:"+page2);
						totalPage=(total/count2);
						if((total-1)%count2>0) {
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
						page=poem.getPage();
						count=poem.getCount();
						
						poem.setBegin(Integer.toString(begin));
						poem.setEnd(Integer.toString(end));
						
						System.out.println("开始："+poem.getBegin()+"结束:"+poem.getEnd());
						List<PoemPostDto> list=session.selectList("selectAllAuther",poem);
						for(int i=0;i<list.size();i++) {
							PoemPostDto plist=list.get(i);
							plist.setBegin(poem.getBegin());
							plist.setEnd(poem.getEnd());
							plist.setTotal(list123.size());
//							System.out.println("成功total:"+plist.getTotal());
						}
						
						if(list.size()>0) {
							System.out.println("成功找到全部诗词数据！");
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
//8.查看所有朝代spring-mvc
				@RequestMapping("/ctrl/selectAllDynasty.mvc")
				@ResponseBody
				public String selectAllDynasty(PoemPostDto poem) throws IOException {
						System.out.println("成功进入/selectAllDynasty.mvc！"+poem.getId());
						InputStream in =Resources.getResourceAsStream("mybatis-config.xml");
						SqlSessionFactory ssf=new SqlSessionFactoryBuilder().build(in);
						SqlSession session = ssf.openSession();
						String page="";
						String count="";
						int begin=0;
						int end=0;
						int totalPage;
						page=poem.getPage();
						count=poem.getCount();
						if(page=="") {
							poem.setPage("1");	
						}
						if(count=="") {
							poem.setCount("10");//默认每10条一页							
						}
						if(page=="null") {
							poem.setPage("1");	
						}
						if(count=="null") {
							poem.setCount("10");//默认每10条一页
						}
						System.out.println("total:"+poem.getTotal()+" page:"+poem.getPage()+" count:"+poem.getCount());
						List<PoemPostDto> list123=session.selectList("selectAllPoem",poem);
						int total=list123.size();
						int page2=Integer.parseInt(poem.getPage());
						int count2=Integer.parseInt(poem.getCount());
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
						
						List<PoemPostDto> list=session.selectList("selectAllDynasty",poem);
						for(int i=0;i<list.size();i++) {
							PoemPostDto plist=list.get(i);
							System.out.println("找到获得到的古诗的Id成功"+plist.getId());
						}
						if(list.size()>0) {
							System.out.println("成功找到全部诗词数据！");
							String msg="200";
							Gson gson=new Gson();
							String jsonText=gson.toJson(list);
							session.close();
							System.out.println("jsonText!!!!:"+jsonText);
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
//9.分类查看诗词spring-mvc
				@RequestMapping("/ctrl/classified_Query.mvc")
				@ResponseBody
				public String classified_Query(PoemPostDto poem) throws IOException {
						System.out.println("成功进入/classified_Query=.mvc！"+poem.getId());
						InputStream in =Resources.getResourceAsStream("mybatis-config.xml");
						SqlSessionFactory ssf=new SqlSessionFactoryBuilder().build(in);
						SqlSession session = ssf.openSession();
						String page="";
						String count="";
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
						System.out.println("total:"+poem.getTotal()+" page:"+poem.getPage()+" count:"+poem.getCount());
						List<PoemPostDto> list123=session.selectList("selectAllPoem",poem);
						int total=list123.size();
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
						session.commit();
						List<PoemPostDto> list2=session.selectList("classified_Query",poem);
						session.commit();
						if(list2.size()>0) {
							System.out.println("找到这个诗歌了");
						}else {
							System.out.println("没有这个诗歌");
						}
						System.out.println("诗歌有： "+list2.size()+"首。");
						Gson gson=new Gson();
						String jsonText=gson.toJson(list2);
						session.close();
						System.out.println("jsonText:"+jsonText);
					return jsonText;
				}
//10.根据作者查找古诗spring-mvc
				@RequestMapping("/ctrl/selectPoemByAuther.mvc")
				@ResponseBody
				public String selectPoemByAuther(PoemPostDto poem) throws IOException {
						System.out.println("成功进入/classified_Query=.mvc！"+poem.getId());
						InputStream in =Resources.getResourceAsStream("mybatis-config.xml");
						SqlSessionFactory ssf=new SqlSessionFactoryBuilder().build(in);
						SqlSession session = ssf.openSession();
						String page="";
						String count="";
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
						System.out.println("total:"+poem.getTotal()+" page:"+poem.getPage()+" count:"+poem.getCount());
						List<PoemPostDto> list123=session.selectList("selectAllPoem",poem);
						int total=list123.size();
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
						session.commit();
						List<PoemPostDto> list=session.selectList("selectAutherId",poem);
						for(int i=0;i<list.size();i++) {
							PoemPostDto plist=list.get(i);
							System.out.println("诗词数据ID:"+plist.getId());
							int pid = Integer.parseInt(String.valueOf(plist.getId()));
							poem.setPoemId(pid);
						}
						List<PoemPostDto> list2=session.selectList("selectPoemByAuther",poem);
						if(list2.size()>0) {
							System.out.println("找到这个诗歌了");
						}else {
							System.out.println("没有这个诗歌");
						}
						System.out.println("诗歌有： "+list2.size()+"首。");
						Gson gson=new Gson();
						String jsonText=gson.toJson(list2);
						session.close();
						System.out.println("jsonText:"+jsonText);
					return jsonText;
				}
//11.根据朝代查找古诗spring-mvc
				@RequestMapping("/ctrl/selectPoemByDynasty.mvc")
				@ResponseBody
				public String selectPoemByDynasty(PoemPostDto poem) throws IOException {
						System.out.println("成功进入/classified_Query=.mvc！"+poem.getDynasty());
						InputStream in =Resources.getResourceAsStream("mybatis-config.xml");
						SqlSessionFactory ssf=new SqlSessionFactoryBuilder().build(in);
						SqlSession session = ssf.openSession();
						String page="";
						String count="";
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
						System.out.println("total:"+poem.getTotal()+" page:"+poem.getPage()+" count:"+poem.getCount());
						List<PoemPostDto> list123=session.selectList("selectAllPoem",poem);
						int total=list123.size();
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
						
						session.commit();
						List<PoemPostDto> list=session.selectList("selectPoemByDynasty",poem);
						session.commit();
						if(list.size()>0) {
							System.out.println("找到这个诗歌了");
						}else {
							System.out.println("没有这个诗歌");
						}
						System.out.println("诗歌有： "+list.size()+"首。");
						Gson gson=new Gson();
						String jsonText=gson.toJson(list);
						session.close();
						System.out.println("jsonText:"+jsonText);
					return jsonText;
				}
//12.查询所有作者数据
		@RequestMapping("/ctrl/selectAllPoet.mvc")
		@ResponseBody
		public String selectAllPoet(PoemPostDto poem) throws IOException {
				InputStream in =Resources.getResourceAsStream("mybatis-config.xml");
				SqlSessionFactory ssf=new SqlSessionFactoryBuilder().build(in);
				SqlSession session = ssf.openSession();
				String page="";
				String count="";
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
				System.out.println("total:"+poem.getTotal()+" page:"+poem.getPage()+" count:"+poem.getCount());
				List<PoemPostDto> list123=session.selectList("selectAllPoem",poem);
				int total=list123.size();
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
				List<PoemPostDto> list=session.selectList("selectAllPoet",poem);
				for(int i=0;i<list.size();i++) {
					PoemPostDto plist=list.get(i);
					System.out.println("成功"+plist);
				}
				
				poem.setTotal(list.size());
				System.out.println("total："+list.size());
				
				
				
				
				if(list.size()>0) {
					System.out.println("成功找到全部诗词数据！");
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
//12.添加作者
				@RequestMapping("/ctrl/addtwoPoet.mvc")
				@ResponseBody
				public String addPoet(PoemPostDto poem) throws IOException {
						InputStream in =Resources.getResourceAsStream("mybatis-config.xml");
						SqlSessionFactory ssf=new SqlSessionFactoryBuilder().build(in);
						SqlSession session = ssf.openSession();
						List<PoemPostDto> list666=session.selectList("selectAutherId",poem.getAuther());
						System.out.println("list666:"+list666.size());
						if(list666.size()>0) {
							String msg="400,重复诗人名字";
							Gson gson=new Gson();
							String jsonText=gson.toJson(msg);
							session.close();
							System.out.println("jsonText:"+jsonText);
						return jsonText;
						}else {
							
						
						int result=session.insert("addPoet2",poem);
						if(result>0) {System.out.println("成功增加诗人数据！");}else {System.out.println("失败增加诗人数据！");}
						System.out.println("poem:"+" poemId:"+poem.getPoemId()+" "+poem.getTitle()+" "+poem.getAuther()+" "+poem.getContent());
						session.commit();
						
						System.out.println("result结果:"+result);
						if(result>0) {
							System.out.println("成功增加诗词数据！");
							String msg="200";
							Gson gson=new Gson();
							String jsonText=gson.toJson(msg);
							session.close();
							System.out.println("jsonText:"+jsonText);
						return jsonText;	
						}else{
							System.out.println("增加诗词数据失败！");
							String msg="400";
							Gson gson=new Gson();
							String jsonText=gson.toJson(msg);
							session.close();
							System.out.println("jsonText:"+jsonText);
						return jsonText;	
						}
						}
				}		
//13.编辑作者信息
				@RequestMapping("/ctrl/updatePoet.mvc")
				@ResponseBody
				public String updatePoet(PoemPostDto poem) throws IOException {
					System.out.println("poem:"+" poemId:"+poem.getAuther()+" "+poem.getDynasty()+" "+poem.getMsg());
						InputStream in =Resources.getResourceAsStream("mybatis-config.xml");
						SqlSessionFactory ssf=new SqlSessionFactoryBuilder().build(in);
						SqlSession session = ssf.openSession();
						List<PoemPostDto> list=session.selectList("selectAutherId",poem.getAuther());
						System.out.println("poem:"+" poemId:"+poem.getPoemId()+" "+poem.getTitle()+" "+poem.getAuther()+" "+poem.getContent());
						
						int result=session.insert("updatePoet",poem);
						
						if(result>0) {System.out.println("成功编辑诗人数据！");}else {System.out.println("失败编辑诗人数据！");}
						System.out.println("Id:"+poem.getId()+" "+poem.getTitle()+" "+poem.getAuther()+" "+poem.getContent());
						session.commit();
						session.close();
						System.out.println("result结果:"+result);
						if(result>0) {
							System.out.println("成功增加诗词数据！");
							String msg="200";
							Gson gson=new Gson();
							String jsonText=gson.toJson(msg);
							session.close();
							System.out.println("jsonText:"+jsonText);
						return jsonText;	
						}else{
							System.out.println("增加诗词数据失败！");
							String msg="400";
							Gson gson=new Gson();
							String jsonText=gson.toJson(msg);
							session.close();
							System.out.println("jsonText:"+jsonText);
						return jsonText;	
						}
				}	
//15.删除诗词spring-mvc
				@RequestMapping("/ctrl/deletePoet.mvc")
				@ResponseBody
				public String deletePoet(PoemPostDto poem) throws IOException {
						InputStream in =Resources.getResourceAsStream("mybatis-config.xml");
						SqlSessionFactory ssf=new SqlSessionFactoryBuilder().build(in);
						SqlSession session = ssf.openSession();
						System.out.println("作者数据！"+poem.getAuther());
						int result;
						result=session.insert("deletePoet",poem.getAuther());
						session.commit();
					
						System.out.println("result结果:"+result);
						if(result>0) {
							System.out.println("成功删除作者数据！");
							String msg="200";
							Gson gson=new Gson();
							String jsonText=gson.toJson(msg);
							session.close();
							System.out.println("jsonText:"+jsonText);
						return jsonText;	
						}else{
							System.out.println("删除作者数据失败！");
							String msg="400,没有这位作者名字";
							Gson gson=new Gson();
							String jsonText=gson.toJson(msg);
							session.close();
							System.out.println("jsonText:"+jsonText);
						return jsonText;	
						}
				}			
				
//16.吟诗作词（根据类型作者朝代随机获取一首古诗）：
				@RequestMapping("/ctrl/game1.mvc")
				@ResponseBody
				public String game1(PoemPostDto poem) throws IOException {
						System.out.println("成功进入/game1.mvc！");
						InputStream in =Resources.getResourceAsStream("mybatis-config.xml");
						SqlSessionFactory ssf=new SqlSessionFactoryBuilder().build(in);
						SqlSession session = ssf.openSession();
						List<PoemPostDto> list=session.selectList("game1");
//						List<PoemPostDto> list2=session.selectList("game1");
						String problem="";
						Gson gson=new Gson();
						GameData data=new GameData();
						boolean a=true;
						for(int i=0;i<list.size();i++) {
							PoemPostDto plist=list.get(i);
							String str=plist.getContent();
							
							 String[] id =str.split("，|。|？|! |,");
							 if(id.length!=1) {
							 int random=(int)(Math.random()*id.length);
							 System.out.println("random的大小："+random);
							 int editPoemNum=0;
							 int errormsg=0;
							 boolean a1=a;
							 
							 if(random==0) {
								  editPoemNum=1;
								  a=false;
								  int errorRandom=(int)(Math.random()*id.length*10);
								  if(errorRandom%2==0) {
									  errormsg=editPoemNum+1;
								  }else {
									  errormsg=editPoemNum+2;
								  }
								  System.out.println(id[random]+"，"+"________________。");
							 }else if(random==(id.length-1)) {
								  editPoemNum=(id.length-2);
								  a=true;
								  int errorRandom=(int)(Math.random()*id.length*10);
								  if(errorRandom%2==0) {
									  errormsg=editPoemNum-1;
								  }else {
									  errormsg=editPoemNum-2;
								  }
								  System.out.println("________________，"+id[random]);
							 }else if(random!=0&&random!=id.length-1){
								 int random2=(int)(Math.random()*id.length*10);
								 if(random2%2==0) {
									 editPoemNum=random+1;
									 a=false;
									 errormsg=editPoemNum-2;
									 System.out.println(id[random]+"，"+"（后半句）________________。");
								 }
								 if(random2%2==1){
									 editPoemNum=random-1;
									 a=true;
									 errormsg=editPoemNum+2;
									 System.out.println("(前半句)________________，"+id[random]+"。");
								 }
							 }		
							 System.out.println("提问的位置:"+a1);
							 String msg=id[random];
							 String emsg=id[editPoemNum];
							String[] asas=new String[2];
							asas[0]=emsg;
							asas[1]=id[errormsg];
//							String[] Arrerrormsg=new String[1];
//							Arrerrormsg[0]=id[errormsg];
							data.setAuther(plist.getAuther());
							data.setTitle(plist.getTitle());
							data.setDynater(plist.getDynasty());
							data.setFlag(a);
							data.setChoose(asas);
							data.setTrueAnswer(id[editPoemNum]);
							data.setSuggestiveVerse(id[random]);
//							System.out.println("data:"+data.getChoose());
							 problem=" msg："+msg+"的，   "+a+"是："+" emsg"+emsg+"   errorMsg:"+errormsg+":"+id[errormsg];
//							 System.out.println("problem: "+problem);
						}else {
							String msg="400";
							problem="没得找到诗歌，在找一次。";
							System.out.println("找到诗词数据一行不能够进行游戏！");
						}
						}
						//1.String 正确选项
						//2.【】 一个数组，包含一个正确的，N个错误的
						
						
						
//						2.把JSON格式的字符串转换成JAVA对象
//						PoemPostDto user2=gson2.fromJson(s,PoemPostDto.class);
//						System.out.println(user2.getId()+"　"+user2.getTitle()+"  ");
						if(list.size()>0) {
							String jsonText=gson.toJson(data);
							session.close();
							System.out.println("jsonText:"+jsonText);
						return jsonText;	
						}else{
							System.out.println("未找到诗词数据！");
							String msg="400,没得找到诗歌，请重新获取一次。";
							String jsonText=gson.toJson(msg);
							session.close();
							System.out.println("jsonText:"+jsonText);
						return jsonText;	
						}
				}
				
				

	//game2:.吟诗作词（根据类型作者朝代随机获取一首古诗）：
		@RequestMapping("/ctrl/game2.mvc")
		@ResponseBody
/*
 * 				@RequestParam(value= "poet", required = false, defaultValue ="") String poet,
				@RequestParam(value= "dynasty", required = false, defaultValue ="")String dynasty,
				@RequestParam(value= "type", required = false, defaultValue ="")String type,
 * */
		public String game2(
				@RequestParam(value= "poet", required = false, defaultValue ="") String poet,
				@RequestParam(value= "dynasty", required = false, defaultValue ="")String dynasty,
				@RequestParam(value= "type", required = false, defaultValue ="")String type,
				 PoemPostDto poem) throws IOException {
				System.out.println("成功进入/game2.mvc！");
				InputStream in =Resources.getResourceAsStream("mybatis-config.xml");
				SqlSessionFactory ssf=new SqlSessionFactoryBuilder().build(in);
				SqlSession session = ssf.openSession();
				poem.setPoet(poet);
				poem.setDynasty(dynasty);
				poem.setType(type);
				System.out.println("game2数据的是："+poet+":"+dynasty+":"+type);
				List<PoemPostDto> list=session.selectList("game2",poem);
				
				if(list.size()>0) {
					System.out.println("成功找到诗词数据！");
					String msg="200";
					Gson gson=new Gson();
					String jsonText=gson.toJson(list);
					session.close();
					System.out.println("jsonText:"+jsonText);
				return jsonText;	
				}else{
					System.out.println("未找到指定类型的诗词！");
					String msg="{}";
					Gson gson=new Gson();
					String jsonText=gson.toJson(msg);
					session.close();
					System.out.println("jsonText:"+jsonText);
				return jsonText;	
				}
		}
				

		
//1.开始
		//superGame2:.吟诗作词（根据类型作者朝代随机获取古诗）：
		@RequestMapping("/ctrl/superGame2.mvc")
		@ResponseBody
		public String superGame2(
				@RequestParam(value= "poet", required = false, defaultValue ="") String poet,
				@RequestParam(value= "dynasty", required = false, defaultValue ="")String dynasty,
				@RequestParam(value= "type", required = false, defaultValue ="")String type,
				@RequestParam(value= "page", required = false, defaultValue ="") String page,
				@RequestParam(value= "count", required = false, defaultValue ="")String count,	
		PoemPostDto poem) throws IOException {
				System.out.println("成功进入/superGame2.mvc！");
				InputStream in =Resources.getResourceAsStream("mybatis-config.xml");
				SqlSessionFactory ssf=new SqlSessionFactoryBuilder().build(in);
				SqlSession session = ssf.openSession();
				//开始
				
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
				System.out.println("selectAllPoem==》total:"+poem.getTotal()+" page:"+poem.getPage()+" count:"+poem.getCount());
				List<PoemPostDto> list123=session.selectList("selectAllPoem",poem);
				int total=list123.size();
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
				List<PoemPostDto> list=session.selectList("selectAllPoet",poem);
				for(int i=0;i<list.size();i++) {
					PoemPostDto plist=list.get(i);
					System.out.println("成功"+plist);
				}
				
				poem.setTotal(total);
				System.out.println("total："+list.size());
				
				List<PoemPostDto> list2=session.selectList("superGame2",poem);
				
				if(list2.size()>0) {
					System.out.println("成功找到诗词数据！");
					String msg="200";
					Gson gson=new Gson();
					String jsonText=gson.toJson(list2);
					session.close();
					System.out.println("jsonText:"+jsonText);
				return jsonText;	
				}else{
					System.out.println("未找到指定类型的诗词！");
					String msg="{}";
					Gson gson=new Gson();
					String jsonText=gson.toJson(msg);
					session.close();
					System.out.println("jsonText:"+jsonText);
				return jsonText;	
				}
		}
//2.结束
		
}
