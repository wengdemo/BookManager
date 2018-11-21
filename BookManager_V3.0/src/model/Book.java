package model;

import java.util.Scanner;

import dao.BookDao;
import dao.BookDaoImp;

public class Book {
	public String bookNumber;//�鱾���
	public String bookName;//�鱾����
	public String author;// ����
	public double price;// �鱾�۸�

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

	//book���вι���
	public Book(String bookNumber, String bookName, String author, Double price) {
		this.bookNumber = bookNumber;
		this.bookName = bookName;
		this.author = author;
		this.price = price;
	}

	//���ͼ�鷽��
	public void addBook() {
		System.out.println("----��ʼ����ͼ��----");
		while (true) {
			System.out.println("��������������ͼ��ı��");
			this.setBookNumber(s.next());
			if (bookDao.checkNum(this.getBookNumber()) >= 0) {
				System.out.println("�Բ����Ѿ����ڸ��飬����������");
				continue;
			} else {

				break;
			}
		}
		System.out.println("��������������ͼ�������");
		this.setBookName(s.next());
		System.out.println("��������������ͼ�������");
		this.setAuthor(s.next());
		while (true) {
			s = new Scanner(System.in);
			try {
				System.out.println("��������������ͼ��ļ۸�");
				this.setPrice(s.nextDouble());
			} catch (Exception e) {
				System.out.println("---------------------");
				System.out.println("�۸������봿���֣�������������������");
				System.out.println("---------------------");
				continue;
			}
			break;
		}

		Book b = new Book(getBookNumber(), getBookName(), getAuthor(), getPrice());
		bookDao.addBook(b);

	}
	
	
	//�޸�ͼ��۸񷽷�
	public void modifyBook() {
		System.out.println("----��ʼ���ļ۸�----");
		while (true) {
			s = new Scanner(System.in);
			System.out.println("������������ļ۸��ͼ����");
			this.setBookNumber(s.next());
			int r =bookDao.checkNum(this.getBookNumber());
			if ( r < 0) {
				System.out.println("�Բ�����鲻���ڣ�����������");
				continue;
			} else {
				
				try {
					System.out.println("������������ĵļ۸�");
					this.setPrice(s.nextDouble());
				} catch (Exception e) {
					System.out.println("---------------------");
					System.out.println("�۸������봿���֣�������������������");
					System.out.println("---------------------");
					continue;
				}
				bookDao.modifyBook(r, getPrice());
				break;
			}

		}

		
			
		

		

	}
	
	//ɾ��ͼ�鷽��
	public void deleteBook() {
		
		System.out.println("----��ʼɾ��ͼ��----");
		while (true) {
			System.out.println("����������ɾ����ͼ����");
			this.setBookNumber(s.next());
			int r = bookDao.checkNum(this.getBookNumber());
			if (r < 0) {
				System.out.println("�Բ�����鲻���ڣ�����������");
				continue;
			} else {
				bookDao.deleteBook(r);
				break;
			}
		}

		

	}

}
