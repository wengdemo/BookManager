package dao;

import model.User;

public interface UserDao {

	// ��ʾ�����û��ķ���
	public void ShowAllUsers();

	// ����������˺ź����룬��ȡһ���û��ķ���
	public User findUser(String account, String password);

	// �ж�ע��ʱ������Զ����˺��Ƿ��ظ��ķ���
	public boolean checkAcc(String account);

	// ���û�����������/����û� �ķ���
	public void addUser(User user);
}
