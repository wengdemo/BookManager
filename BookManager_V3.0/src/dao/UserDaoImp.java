package dao;

import model.User;
import util.Datebase;

public class UserDaoImp implements UserDao {

	// 获取所有用户的方法
	public void ShowAllUsers() {
		System.out.println("账户\t" + "密码\t" + "姓名\t");
		// 遍历
		for (int i = 0; i < Datebase.usera.size(); i++) {
			User u = Datebase.usera.get(i);
			System.out.println(u.getAccount() + "\t" + u.getPassword() + "\t"
					+ u.getUsername());

		}
	}

	// 根据输入的账号和密码，获取一个用户的方法
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

	//检查是否存在相同账户
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

	//添加用户
	@Override
	public void addUser(User user) {

		Datebase.usera.add(user);
		/*User[] userArray = new User[Datebase.userArray.length + 1];
		for (int i = 0; i < Datebase.userArray.length; i++) {
			userArray[i] = Datebase.userArray[i];
		}

		userArray[userArray.length - 1] = new User(user.getAccount(), user.getPassword(), user.getUsername());
		Datebase.userArray = userArray;*/
		System.out.println("【 注册成功 】");
	}

}
