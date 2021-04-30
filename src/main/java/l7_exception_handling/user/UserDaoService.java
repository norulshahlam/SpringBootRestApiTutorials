package l7_exception_handling.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<>();
	private static int usersCount = 3;

	// mock data
	static {
		users.add(new User(1, "Adam", new Date()));
		users.add(new User(2, "eve", new Date()));
		users.add(new User(3, "jack", new Date()));
	}

	// get all user
	public List<User> findAll() {
		return users;
	}

	// add user
	public User save(User user) {

		//if no id is added, we add for user
		if (user.getId() == null) {
			user.setId(++usersCount);
		}
		users.add(user);
		return user;
	}

	// find user
	public User findOne(int id) {
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}
}