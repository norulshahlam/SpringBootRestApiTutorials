package l6_response_status.user;

/*

in this lesson we will learn how to create user bean and user service
user will be a hardcoded data
1. how to find all users, 
2. find 1 user, 
3. save user using REST client
4. how to enhanced POST method to return http status code,
  how to properly create a resource by returning a proper status code eg 200, 204 etc	
  b) also returning the location of the created user in the response header.
  this only shows the created status without any message or any validation.

1st: create your user pojo
2nd: create dao layer
3rd: create controller

1&2. to find all / 1 user, GET request is used and u can 
submit this request thru the browser

3. to add user, POST request is used. but u cant use thru the browser.
only way is to use rest client thru command line or postman 
in postman, under POST request, go to BODY and input the data 
in proper json format. make sure it is in RAW and JSON format is checked.

what is @RequestBody? 

this is to map the data u input in postman when creating user, to 
the user object in your controller

how to view hierarchical
https://stackoverflow.com/questions/3915961/how-to-view-hierarchical-package-structure-in-eclipse-package-explorer
 * 
 * to see formatted json, install json viewer chrome plugin
 * 
 */
import java.util.ArrayList;
import java.util.Date;
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
}

























