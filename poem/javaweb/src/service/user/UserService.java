package service.user;

import dao.user.UserDao;

/**封装用户管理的业务功能*/
public class UserService {
	/**业务功能：用户注册
	 * 业务逻辑：
	 * 1.用户名不能为空
	 * 2.用户名长度不能超过10个字符
	 * 3.用户名不能重复*/
	public boolean register(String name) {
		name=name.trim();//去除字符串前后的空格
		if(name == null || name.isEmpty() ) {
			return false;
		}
		if(name.length()>10) {
			return false;
		}
		//TODO 检查用户名是否重复
		UserDao dao=new UserDao();
		return dao.insert(name);
	}
}
