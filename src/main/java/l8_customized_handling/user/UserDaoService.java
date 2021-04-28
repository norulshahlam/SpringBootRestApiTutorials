package l8_customized_handling.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<>();
	private static int usersCount = 3;
	
	//mock data
	static {
		users.add(new User(1, "Adam", new Date()));
		users.add(new User(2, "eve", new Date()));
		users.add(new User(3, "jack", new Date()));
		users.add(new User(4, "bob", new Date()));
		users.add(new User(5, "jane", new Date()));
		users.add(new User(6, "mary", new Date()));
	}
	
	//get all user
	public List<User> findAll(){
		return users;
	}
	
	
	//add user
	public User save(User user) {

			// if user id exists,
			for (User newUser : users) {
				if (user.getId() == newUser.getId()) {
					System.out.println("exists");
					return null;
				}
			}
		
		if(user.getId()==null) {
			user.setId(++usersCount );
		}
		users.add(user);
		return user;
	}
	
	//find user
	public User findOne(int id) {
		for(User user:users) {
			if(user.getId()==id) {
				return user;
			}
		}
		return null;
	}
	
	public User deleteById(int id) {
		
		/*
		 * we cant use for loop bcos we cant del a user in btwn-request.
		 * we can add a temp list to it by iterator() & then del user
		 */
		Iterator<User> iterator = users.iterator();
		while (iterator.hasNext()) {
			User user = iterator.next();
			
			if(user.getId()==id) {
				iterator.remove();
				return user;
			}
		}
		return null;
	}

}

























