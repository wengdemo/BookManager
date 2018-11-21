package util;

import java.util.ArrayList;

import model.Book;
import model.User;

public class Datebase {
	//动态初始化
	
	public static ArrayList<User> usera = new ArrayList<User>();
	public static ArrayList<Book> booka = new ArrayList<Book>();

	//
	private Datebase() {
	}

	// 初始化数据库的方法
	public static void initDB() {
		// 初始化用户
		usera.add(new User("admin", "123", "初始管理员"));
		

		// 初始化书籍
		booka.add(new Book("MZ001", "西游记", "吴承恩", 19.9));
		booka.add(new Book("MZ002", "三国演义", "罗贯中", 19.9));
		booka.add(new Book("MZ003", "水浒传", "施耐庵", 19.9));
		booka.add(new Book("MZ004", "红楼梦", "曹雪芹", 19.9));
		
		

	}
}
