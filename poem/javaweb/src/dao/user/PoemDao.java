package dao.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.google.gson.Gson;

import model.student.Poem;
import model.user.UserBean;
import pub.Database;

public class PoemDao {
	//poem的插入语句
	public boolean insert(Poem poem) {
		try {
			Connection con=Database.connect();
			String sql="insert into tb_poem (title,dynasty,auther,content) values (?,?,?,?)";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setString(1,poem.getTitle());
			stmt.setString(2,poem.getDynasty());
			stmt.setInt(3,poem.getPoemId());
			stmt.setString(4,poem.getContent());
			stmt.execute();	
			con.close();
		}catch(Exception e) {e.printStackTrace();
			return false;
		}
		return true;
	
	}
}
