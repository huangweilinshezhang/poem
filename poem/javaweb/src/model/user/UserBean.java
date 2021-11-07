package model.user;

import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import model.student.Poem;

/**封装用户数据*/
public class UserBean {
	protected Long id;//数据库tb_user表的主键
	protected String name;//用户名
	protected String pwd;
	protected int age;
	protected String sex;
	protected String number;
	protected String email;
	protected String address;
	protected int staus;
	protected String midnNumber;
	protected int total;
	
	public String getMidnNumber() {
		return midnNumber;
	}
	public void setMidnNumber(String midnNumber) {
		this.midnNumber = midnNumber;
	}
	public int getStaus() {
		return staus;
	}
	public void setStaus(int staus) {
		this.staus = staus;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getNumber() {
		return number;
	}
	public void setNumber(String number2) {
		this.number = number2;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPwd() {return pwd;}
	public void setPwd(String pwd) {this.pwd = pwd;}
	public Long getId() {//source->generate getters and setters
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public static void main(String[] args) {
		UserBean user=new UserBean();
		user.setId(null);user.setName("张三");
//		Gson gson=new Gson();// {"id":23,"name":"张三"}
		GsonBuilder gb=new GsonBuilder();
		gb.setDateFormat("yyyy-MM-dd");
		gb.serializeNulls();
		Gson gson=gb.create();
//		1.把Java对象转换成JSON格式的字符串
		String s=gson.toJson(user);
		System.out.println(s);
//		2.把JSON格式的字符串转换成JAVA对象
		UserBean user2=gson.fromJson(s,UserBean.class);
		System.out.println(user2.getId()+"　"+user2.getName()+"  ");
		Driver driver=gson.fromJson(s, Driver.class);
	}
}
