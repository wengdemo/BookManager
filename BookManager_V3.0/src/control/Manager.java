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

	// һ��Ŀ¼
	public void welcome() {
		System.out.println("****��ӭʹ��ͼ�����ϵͳ****");

		while (true) {
			s = new Scanner(System.in);
			try {
				System.out.println("��ѡ��������еĲ���:  1-��¼   2-ע��  3-�鿴�����û� 0-�˳�ϵͳ");
				int s_pass1 = s.nextInt();

				// �������1
				if (s_pass1 == 1) {
					// ��¼�ķ���
					user.login();
					// ��¼�ɹ������ж���Ŀ¼
					system_library();

					break;
				} else if (s_pass1 == 2) {
					//ע��ķ���
					user.register();
					continue;
				} else if (s_pass1 == 0) {
					System.out.println("�� лл��ӭ�´�ʹ�� ��");
					return;
				} else if (s_pass1 == 3) {
					//�鿴�����û��ķ���
					userDao.ShowAllUsers();
				}

				else {
					System.out.println("������������������");
					continue;
				}

		} catch (Exception e) {
				System.out.println("---------------------");
				System.out.println("�� �����봿���֣�������������������");
				System.out.println("---------------------");

			}
		}

	}

	public void system_library() {

		while (true) {
			s = new Scanner(System.in);

			try {

				System.out.println("��ѡ��������еĲ���:  1-�鿴����ͼ��   2-����ͼ��  3-�޸�ͼ��۸�  4-ɾ��ͼ��  0-ע��");
				int s_pass2 = s.nextInt();
				if (s_pass2 == 1) {
					bookDao.showBook();
				}
				if (s_pass2 == 2) {
					//���ͼ��
					book.addBook();
				}
				if (s_pass2 == 3) {
					//�޸�ͼ��۸�
					book.modifyBook();
				}
				if (s_pass2 == 4) {
					//ɾ��ͼ��
					book.deleteBook();
				}
				if (s_pass2 == 0) {
					user = new User();
					System.out.println("��ע���ɹ���");
					break;
				}
			} catch (Exception e) {
				System.out.println("---------------------");
				System.out.println("�����봿���֣�������������������");
				System.out.println("---------------------");

			}

		}
		start();
	}

}
