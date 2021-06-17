package l11_content_negotiation.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component // tell spring this is a bean
public class UserDaoService implements UserDaoApi<User> {

	// mock data
	private static List<User> users = new ArrayList<>();
	// private static int userCount = 6;

	static {
		users.add(new User(1, "Adam", new Date()));
		users.add(new User(2, "eve", new Date()));
		users.add(new User(3, "jack", new Date()));
		users.add(new User(4, "bob", new Date()));
		users.add(new User(5, "jane", new Date()));
		users.add(new User(6, "mary", new Date()));
	}

	@Override
	public List<User> findAll() {
		return users;
	}

	/*
	 * use enhanced for loop to find for 1 user
	 */
	@Override
	public User getUser(int id) {
		for (User user : users) {
			if (user.getId() == id)
				return user;
		}
		return null;
	}

	@Override
	public User createUser(User user) {

		// if user id exists,
		for (User newUser : users) {
			if (user.getId() == newUser.getId()) {
				System.out.println("exists");
				return null;
			}
		}
		System.out.println("created: " + user);
		users.add(user);
		return user;

	}

	@Override
	public User deleteUser(int id) {

		/*
		 * we cant use for loop bcos we cant del a user in btwn-request. we can add a
		 * temp list to it by iterator() & then del user
		 */

		Iterator<User> iterator = users.iterator();
		while (iterator.hasNext()) {
			User user = iterator.next();

			if (user.getId() == id) {
				iterator.remove();
				return user;
			}
		}

		return null;

	}
}
