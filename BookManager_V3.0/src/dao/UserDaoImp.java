package dao;

import model.User;
import util.Datebase;

public class UserDaoImp implements UserDao {

	// ��ȡ�����û��ķ���
	public void ShowAllUsers() {
		System.out.println("�˻�\t" + "����\t" + "����\t");
		// ����
		for (int i = 0; i < Datebase.usera.size(); i++) {
			User u = Datebase.usera.get(i);
			System.out.println(u.getAccount() + "\t" + u.getPassword() + "\t"
					+ u.getUsername());

		}
	}

	// ����������˺ź����룬��ȡһ���û��ķ���
	@Override
	public User findUser(String account, String password) {

		for (int i = 0; i < Datebase.usera.size(); i++) {
			User u = Datebase.usera.get(i);
			if (account.equals(u.getAccount())
					&& password.equals(u.getPassword())) {

				return u;
			}

		}
		return null;

	}

	//����Ƿ������ͬ�˻�
	@Override
	public boolean checkAcc(String account) {
		for (int i = 0; i < Datebase.usera.size(); i++) {
			User u = Datebase.usera.get(i);
			if (account.equals(u.getAccount())) {
				return true;
			}
		}

		return false;
	}

	//����û�
	@Override
	public void addUser(User user) {

		Datebase.usera.add(user);
		/*User[] userArray = new User[Datebase.userArray.length + 1];
		for (int i = 0; i < Datebase.userArray.length; i++) {
			userArray[i] = Datebase.userArray[i];
		}

		userArray[userArray.length - 1] = new User(user.getAccount(), user.getPassword(), user.getUsername());
		Datebase.userArray = userArray;*/
		System.out.println("�� ע��ɹ� ��");
	}

}
