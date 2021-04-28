package l7_exception_handling.user;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
public class UserResource {

	@Autowired
	private UserDaoService service;

	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		return service.findAll();
	}

	@GetMapping("users/{id}")
	public User retrieveUser(@PathVariable int id) {
		
		User user= service.findOne(id);
		
		if(user==null)
		// this will be created in another class
			throw new UserNotFoundException("id: "+id);
		
		
		return user;
		
		
	}

	@PostMapping("users")
	public ResponseEntity <Object> createUser(@RequestBody User user) {
		User savedUser = service.save(user);
		URI location = ServletUriComponentsBuilder
		.fromCurrentRequest()  
		.path("/{id}")	
		.buildAndExpand(savedUser.getId())
		.toUri(); 

		/* for testing. output will be like "http://localhost:8080/users/4"	*/
		System.out.println("location is: "+location);
		
		return ResponseEntity.created(location).build();
	}

}
