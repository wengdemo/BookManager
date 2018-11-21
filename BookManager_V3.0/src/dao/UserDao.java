package dao;

import model.User;

public interface UserDao {

	// 显示所有用户的方法
	public void ShowAllUsers();

	// 根据输入的账号和密码，获取一个用户的方法
	public User findUser(String account, String password);

	// 判断注册时输入的自定义账号是否重复的方法
	public boolean checkAcc(String account);

	// 将用户插入数组中/添加用户 的方法
	public void addUser(User user);
}
