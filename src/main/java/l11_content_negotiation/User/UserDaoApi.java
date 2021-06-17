package l11_content_negotiation.User;

import java.util.List;

public interface UserDaoApi<User> {

	/*
	 * basic functions
	 * 
	 * get all user create 1 user delete 1 user get 1 user
	 */

	// get all user
	public List<User> findAll();

	// get 1 user
	public User getUser(int id);

	// create 1 user
	public User createUser(User user);

	// delete 1 user
	public User deleteUser(int id);

}
