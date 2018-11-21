package dao;

import model.Book;
import util.Datebase;

public class BookDaoImp implements BookDao {

	// 显示所有的图书信息方法
	@Override
	public void showBook() {
		System.out.println("编号\t" + "书名\t" + "作者\t" + "价格\t");
		for (int i = 0; i < Datebase.booka.size(); i++) {
			Book b = Datebase.booka.get(i);
			System.out.println(b.getBookNumber() + "\t" + b.getBookName() + "\t"
					+ b.getAuthor() + "\t" + b.getPrice());

		}
	}

	// 查询是否存在该书的方法
	@Override
	public int checkNum(String num) {
		//遍历数据库，如果存在相同的编号，说明存在
		
		for (int i = 0; i < Datebase.booka.size(); i++) {
			Book b = Datebase.booka.get(i);
			if (num.equals(b.getBookNumber())) {
				return i;
			}
		}
		
		return -1;
	}

	// 添加图书的方法
	@Override
	public void addBook(Book book) {
		Datebase.booka.add(book);
		/*Book[] bookArray = new Book[Datebase.bookArray.length + 1];
		for (int i = 0; i < Datebase.bookArray.length; i++) {
			bookArray[i] = Datebase.bookArray[i];
		}
		bookArray[bookArray.length - 1] = book;
		Datebase.bookArray = bookArray;*/
		System.out.println("【 添加成功 】");
	}

	// 修改图书的价格的方法
	@Override
	//String bookNumber, String bookName, String author, Double price
	public void modifyBook(int index, double price) {
		Datebase.booka.get(index).setPrice(price);
		/*for (int i = 0; i < Datebase.bookArray.length; i++) {
			if (index==i) {
				Datebase.bookArray[i].price = price;
			}
		}*/
		System.out.println("【 修改成功 】");
	}

	// 删除图书的方法
	@Override
	public void deleteBook(int index) {
		
		Datebase.booka.remove(index);
		/*Book[] bookArray = new Book[Datebase.booka.size() - 1];
		for (int i =0; i < index; i++) {
			Book b = Datebase.booka.get(i);
			bookArray[i] = b;
		}
		for(int i = index;i<bookArray.length;i++){
			bookArray[i] = Datebase.bookArray[i+1];
		}

		Datebase.bookArray = bookArray;*/
		System.out.println("【删除成功】");
	}

}
