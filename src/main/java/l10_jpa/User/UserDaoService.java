package l10_jpa.User;

/*
 * last lesson we learnt how to define a status message with standard 
 * structure defined by spring mvc.
 * 
 * 1. this lesson will learn how to customize response structure (to fit our requirement)
 * we will have different status code for diff exception
 * usually the standard structure will be timestamp, message, detail.
 * 
 * 2. we will also learn how to delete user and give status code if fail or success
 * if fail - we return the same exception handling used in retrieveUser()
 * 
 * 
 * 
 * 3. how to do validation - eg make sure name is atleast 2 char 
 *  add validation dependencies
 * add @Valid in UserResource.createUser. then,
 * add @Size & @Past in user pojo to define your validation - name > 2char, date !today onwards
 * use customised excepton handler to set your own status message 
 * and default message, like the ones used in retrieveUSer()
 * 
 * we can also add our own details when validation failed in pojo eg:
 * @Size(min = 2, message = "name must have atleast 2 char")
 * 
 * getBindingResult() - contains details of what went wrong 
 * when validation fails
 * 
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.validation.constraints.Size;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseStatus;

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

























