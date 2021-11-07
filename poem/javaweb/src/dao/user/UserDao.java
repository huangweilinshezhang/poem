package dao.user;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import model.user.UserBean;
import pub.Database;

public class UserDao {
	/**
	 * 分页查询用户数据
	 * @param page  查看第几页
	 * @param max   每一页显示多少条数据
	 * @return 没有数据返回空列表，而不是返回null
	 */
	public java.util.List<Long> queryUsers(int page,int max){
		ArrayList<Long> users=new ArrayList<Long>();
		try {
			Connection con=Database.connect();
			int skip=(page-1)*max;
			String sql="select id from tb_user limit "+skip+","+max;
			Statement stmt=con.createStatement();
			java.sql.ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				Long id=rs.getLong(1);
				users.add(id);
			}
			con.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}
	public boolean insert(String name) {
		try {
			Connection con=Database.connect();
			Statement stmt=con.createStatement();
			String sql="insert into tb_user (name)"
					  +" values ('"+name+"')";
			stmt.execute(sql);
			con.close();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 分页查询用户数据
	 * @param page  查看第几页
	 * @param max   每一页显示多少条数据
	 * @return 没有数据返回空列表，而不是返回null
	 */
	public List<UserBean> queryUserList(int page,int max){
		List<UserBean> list=new ArrayList<UserBean>();
		try {
			Connection con=Database.connect();
			Statement stmt=con.createStatement();
			int skip=(page-1)*max;
			String sql="select id,name,pwd,sex,age,email,number,address from tb_user limit "+skip+","+max;
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				Long id=rs.getLong(1);
				String name=rs.getString(2);
				String pwd=rs.getString(3);
				String sex=rs.getString(4);
				int age=rs.getInt(5);
				String email=rs.getString(6);
				String number=rs.getString(7);
				String address=rs.getString(8);
				UserBean user=new UserBean();
				user.setId(id);
				user.setName(name);
				user.setPwd(pwd);
				user.setSex(sex);
				user.setAge(age);
				user.setEmail(email);
				user.setNumber(number);
				user.setAddress(address);
				list.add(user);
			}
			con.close();
		}catch (Exception e) {e.printStackTrace();}
		return list;
	}//{"total":1,"rows":[{"id":12,"name":"abc"}] }
	/**统计tb_user表一共有多少条数据（不考虑性能）*/
	public int countTotal() {
		int total=0;
		try {
			Connection con=Database.connect();
			Statement stmt=con.createStatement();
			String sql="select count(*) from tb_user";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				total=rs.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return total;
	}
	public boolean insert(UserBean user) {
		try {
			Connection con=Database.connect();
			String sql="insert into tb_user (name,pwd,sex,age,email,number,address) values (?,?,?,?,?,?,?)";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setString(1, user.getName());
			stmt.setString(2, user.getPwd());
			stmt.setString(3, user.getSex());
			stmt.setInt(4, user.getAge());
			stmt.setString(5, user.getEmail());
			stmt.setString(6, user.getNumber());
			stmt.setString(7, user.getAddress());
			stmt.execute();
			con.close();
		}catch(Exception e) {e.printStackTrace();
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		UserDao dao=new UserDao();
		List<UserBean> list=dao.queryUserList(1, 2);
		Gson gson=new Gson();
		String json=gson.toJson(list);
		System.out.println(json);
		System.out.println("{\"total\":5,\"rows\":"+json+"}");
		for(int i=0;i<list.size();i++) {
			UserBean user=list.get(i);
			System.out.println("{\"id\":"+user.getId()+",\"name\":\""+user.getName());
		}
	}
	
}
