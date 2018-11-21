package dao;

import model.Book;

public interface BookDao {

	// 显示所有的图书信息方法
	public void showBook();

	// 查询是否存在该书的方法
	public int checkNum(String num);

	// 添加图书的方法
	public void addBook(Book book);

	// 修改图书的价格的方法
	public void modifyBook(int index, double price);

	// 删除图书的方法
	public void deleteBook(int index);
}
