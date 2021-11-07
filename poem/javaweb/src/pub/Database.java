package pub;
import java.sql.*;
public class Database {
	/**获取一个数据库连接（连接一个数据库）*/
	public static Connection connect() {
		try {
			//1.加载数据库驱动程序
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2.填写连接参数，连接数据库
			return DriverManager
				  .getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=UTC "//数据库ip、端口、名称
				  , "root"//用户名
				  , "123456");//密码
			
		}catch(Exception e) {
			e.printStackTrace();return null;
		}
	}
	public static void main(String[] args) throws Exception {
		Connection con=connect();
		Statement stmt=con.createStatement();
		String sql="create table tb_user (id int auto_increment"
				  +",username varchar(100)"
				  +",password varchar(50)"
				  +",primary key (id) )";
		stmt.execute(sql);
		con.close();
		System.out.println("create table finished.");
	}
}
