package util;

import java.util.ArrayList;

import model.Book;
import model.User;

public class Datebase {
	//��̬��ʼ��
	
	public static ArrayList<User> usera = new ArrayList<User>();
	public static ArrayList<Book> booka = new ArrayList<Book>();

	//
	private Datebase() {
	}

	// ��ʼ�����ݿ�ķ���
	public static void initDB() {
		// ��ʼ���û�
		usera.add(new User("admin", "123", "��ʼ����Ա"));
		

		// ��ʼ���鼮
		booka.add(new Book("MZ001", "���μ�", "��ж�", 19.9));
		booka.add(new Book("MZ002", "��������", "�޹���", 19.9));
		booka.add(new Book("MZ003", "ˮ䰴�", "ʩ����", 19.9));
		booka.add(new Book("MZ004", "��¥��", "��ѩ��", 19.9));
		
		

	}
}
