package model;

import java.util.Scanner;

import dao.BookDao;
import dao.BookDaoImp;

public class Book {
	public String bookNumber;//书本编号
	public String bookName;//书本名字
	public String author;// 作者
	public double price;// 书本价格

	Scanner s = new Scanner(System.in);
	BookDao bookDao = new BookDaoImp();

	public String getBookNumber() {
		return bookNumber;
	}

	public void setBookNumber(String bookNumber) {
		this.bookNumber = bookNumber;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Book() {

	}

	//book的有参构造
	public Book(String bookNumber, String bookName, String author, Double price) {
		this.bookNumber = bookNumber;
		this.bookName = bookName;
		this.author = author;
		this.price = price;
	}

	//添加图书方法
	public void addBook() {
		System.out.println("----开始新增图书----");
		while (true) {
			System.out.println("请输入您想新增图书的编号");
			this.setBookNumber(s.next());
			if (bookDao.checkNum(this.getBookNumber()) >= 0) {
				System.out.println("对不起已经存在该书，请重新输入");
				continue;
			} else {

				break;
			}
		}
		System.out.println("请输入您想新增图书的书名");
		this.setBookName(s.next());
		System.out.println("请输入您想新增图书的作者");
		this.setAuthor(s.next());
		while (true) {
			s = new Scanner(System.in);
			try {
				System.out.println("请输入您想新增图书的价格");
				this.setPrice(s.nextDouble());
			} catch (Exception e) {
				System.out.println("---------------------");
				System.out.println("价格请输入纯数字！！！！！！！！！！");
				System.out.println("---------------------");
				continue;
			}
			break;
		}

		Book b = new Book(getBookNumber(), getBookName(), getAuthor(), getPrice());
		bookDao.addBook(b);

	}
	
	
	//修改图书价格方法
	public void modifyBook() {
		System.out.println("----开始更改价格----");
		while (true) {
			s = new Scanner(System.in);
			System.out.println("请输入你想更改价格的图书编号");
			this.setBookNumber(s.next());
			int r =bookDao.checkNum(this.getBookNumber());
			if ( r < 0) {
				System.out.println("对不起该书不存在，请重新输入");
				continue;
			} else {
				
				try {
					System.out.println("请输入你想更改的价格");
					this.setPrice(s.nextDouble());
				} catch (Exception e) {
					System.out.println("---------------------");
					System.out.println("价格请输入纯数字！！！！！！！！！！");
					System.out.println("---------------------");
					continue;
				}
				bookDao.modifyBook(r, getPrice());
				break;
			}

		}

		
			
		

		

	}
	
	//删除图书方法
	public void deleteBook() {
		
		System.out.println("----开始删除图书----");
		while (true) {
			System.out.println("请输入你想删除的图书编号");
			this.setBookNumber(s.next());
			int r = bookDao.checkNum(this.getBookNumber());
			if (r < 0) {
				System.out.println("对不起该书不存在，请重新输入");
				continue;
			} else {
				bookDao.deleteBook(r);
				break;
			}
		}

		

	}

}
