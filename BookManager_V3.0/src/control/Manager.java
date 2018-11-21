package control;

import java.util.Scanner;

import dao.BookDao;
import dao.BookDaoImp;
import dao.UserDao;
import dao.UserDaoImp;
import model.Book;
import model.User;
import util.Datebase;

public class Manager {
	Scanner s = new Scanner(System.in);
	User user = new User();
	Book book = new Book();

	UserDao userDao = new UserDaoImp();
	BookDao bookDao = new BookDaoImp();

	public void start() {
		Datebase.initDB();
		welcome();

	}

	// 一级目录
	public void welcome() {
		System.out.println("****欢迎使用图书管理系统****");

		while (true) {
			s = new Scanner(System.in);
			try {
				System.out.println("请选择您想进行的操作:  1-登录   2-注册  3-查看所有用户 0-退出系统");
				int s_pass1 = s.nextInt();

				// 如果输入1
				if (s_pass1 == 1) {
					// 登录的方法
					user.login();
					// 登录成功后运行二级目录
					system_library();

					break;
				} else if (s_pass1 == 2) {
					//注册的方法
					user.register();
					continue;
				} else if (s_pass1 == 0) {
					System.out.println("【 谢谢欢迎下次使用 】");
					return;
				} else if (s_pass1 == 3) {
					//查看所有用户的方法
					userDao.ShowAllUsers();
				}

				else {
					System.out.println("输入有误，请重新输入");
					continue;
				}

		} catch (Exception e) {
				System.out.println("---------------------");
				System.out.println("【 请输入纯数字！！！！！！！！！！");
				System.out.println("---------------------");

			}
		}

	}

	public void system_library() {

		while (true) {
			s = new Scanner(System.in);

			try {

				System.out.println("请选择您想进行的操作:  1-查看所有图书   2-新增图书  3-修改图书价格  4-删除图书  0-注销");
				int s_pass2 = s.nextInt();
				if (s_pass2 == 1) {
					bookDao.showBook();
				}
				if (s_pass2 == 2) {
					//添加图书
					book.addBook();
				}
				if (s_pass2 == 3) {
					//修改图书价格
					book.modifyBook();
				}
				if (s_pass2 == 4) {
					//删除图书
					book.deleteBook();
				}
				if (s_pass2 == 0) {
					user = new User();
					System.out.println("【注销成功】");
					break;
				}
			} catch (Exception e) {
				System.out.println("---------------------");
				System.out.println("请输入纯数字！！！！！！！！！！");
				System.out.println("---------------------");

			}

		}
		start();
	}

}
