package model;

import java.util.Scanner;

import dao.UserDao;
import dao.UserDaoImp;
import util.Datebase;

public class User {
	public String account;// 账户
	public String password;// 密码
	public String username;// 用户名

	Scanner s = new Scanner(System.in);
	UserDao userDao = new UserDaoImp();
	private User u;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public User() {
	}

	public User(String account, String password, String username) {
		this.account = account;
		this.password = password;
		this.username = username;
	}

	// 登录
	public void login() {
		while (true) {
			s = new Scanner(System.in);
			System.out.println("----登录界面----");
			System.out.println("请输入账户");
			String account1 = s.next();

			System.out.println("请输入密码");
			String password1 = s.next();

			// System.out.println("您输入的账号为：" + account + " 密码为：" + password);

			u = userDao.findUser(account1, password1);

			if (u==null) {
				System.out.println("账户或密码错误，请重新输入");
				continue;
				
			} else if(account1.equals(u.getAccount()) && password1.equals(u.getPassword())){
				System.out.println("----" + u.getUsername() + ",欢迎进入图书管理系统----");
				System.out.println("【 登录成功 】");
				break;
			}else{
				System.out.println("账户或密码错误，请重新输入");
				continue;
			}

		}
		

	}

	// 注册
	public void register() {

		while (true) {

			System.out.println("----注册界面----");

			System.out.println("请输入您想注册的账户");

			this.setAccount(s.next());

			if (userDao.checkAcc(account)) {

				System.out.println("账户已存在，请重新注册");
				continue;
			} else {

				break;
			}
		}
		System.out.println("请输入您想使用的密码");
		setPassword(s.next());

		System.out.println("请输入您想使用的用户名");
		setUsername(s.next());

		User u = new User(account, password, username);
		userDao.addUser(u);

	}

}
