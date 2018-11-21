package dao;

import model.Book;
import util.Datebase;

public class BookDaoImp implements BookDao {

	// ��ʾ���е�ͼ����Ϣ����
	@Override
	public void showBook() {
		System.out.println("���\t" + "����\t" + "����\t" + "�۸�\t");
		for (int i = 0; i < Datebase.booka.size(); i++) {
			Book b = Datebase.booka.get(i);
			System.out.println(b.getBookNumber() + "\t" + b.getBookName() + "\t"
					+ b.getAuthor() + "\t" + b.getPrice());

		}
	}

	// ��ѯ�Ƿ���ڸ���ķ���
	@Override
	public int checkNum(String num) {
		//�������ݿ⣬���������ͬ�ı�ţ�˵������
		
		for (int i = 0; i < Datebase.booka.size(); i++) {
			Book b = Datebase.booka.get(i);
			if (num.equals(b.getBookNumber())) {
				return i;
			}
		}
		
		return -1;
	}

	// ���ͼ��ķ���
	@Override
	public void addBook(Book book) {
		Datebase.booka.add(book);
		/*Book[] bookArray = new Book[Datebase.bookArray.length + 1];
		for (int i = 0; i < Datebase.bookArray.length; i++) {
			bookArray[i] = Datebase.bookArray[i];
		}
		bookArray[bookArray.length - 1] = book;
		Datebase.bookArray = bookArray;*/
		System.out.println("�� ��ӳɹ� ��");
	}

	// �޸�ͼ��ļ۸�ķ���
	@Override
	//String bookNumber, String bookName, String author, Double price
	public void modifyBook(int index, double price) {
		Datebase.booka.get(index).setPrice(price);
		/*for (int i = 0; i < Datebase.bookArray.length; i++) {
			if (index==i) {
				Datebase.bookArray[i].price = price;
			}
		}*/
		System.out.println("�� �޸ĳɹ� ��");
	}

	// ɾ��ͼ��ķ���
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
		System.out.println("��ɾ���ɹ���");
	}

}
