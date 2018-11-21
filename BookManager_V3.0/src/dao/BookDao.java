package dao;

import model.Book;

public interface BookDao {

	// ��ʾ���е�ͼ����Ϣ����
	public void showBook();

	// ��ѯ�Ƿ���ڸ���ķ���
	public int checkNum(String num);

	// ���ͼ��ķ���
	public void addBook(Book book);

	// �޸�ͼ��ļ۸�ķ���
	public void modifyBook(int index, double price);

	// ɾ��ͼ��ķ���
	public void deleteBook(int index);
}
