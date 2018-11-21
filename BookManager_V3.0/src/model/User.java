package model;

import java.util.Scanner;

import dao.UserDao;
import dao.UserDaoImp;
import util.Datebase;

public class User {
	public String account;// �˻�
	public String password;// ����
	public String username;// �û���

	Scanner s = new Scanner(System.in);
	UserDao userDao = new UserDaoImp();
	private User u;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public User() {
	}

	public User(String account, String password, String username) {
		this.account = account;
		this.password = password;
		this.username = username;
	}

	// ��¼
	public void login() {
		while (true) {
			s = new Scanner(System.in);
			System.out.println("----��¼����----");
			System.out.println("�������˻�");
			String account1 = s.next();

			System.out.println("����������");
			String password1 = s.next();

			// System.out.println("��������˺�Ϊ��" + account + " ����Ϊ��" + password);

			u = userDao.findUser(account1, password1);

			if (u==null) {
				System.out.println("�˻��������������������");
				continue;
				
			} else if(account1.equals(u.getAccount()) && password1.equals(u.getPassword())){
				System.out.println("----" + u.getUsername() + ",��ӭ����ͼ�����ϵͳ----");
				System.out.println("�� ��¼�ɹ� ��");
				break;
			}else{
				System.out.println("�˻��������������������");
				continue;
			}

		}
		

	}

	// ע��
	public void register() {

		while (true) {

			System.out.println("----ע�����----");

			System.out.println("����������ע����˻�");

			this.setAccount(s.next());

			if (userDao.checkAcc(account)) {

				System.out.println("�˻��Ѵ��ڣ�������ע��");
				continue;
			} else {

				break;
			}
		}
		System.out.println("����������ʹ�õ�����");
		setPassword(s.next());

		System.out.println("����������ʹ�õ��û���");
		setUsername(s.next());

		User u = new User(account, password, username);
		userDao.addUser(u);

	}

}
