package l8_customized_handling.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
			
			//this is the status message and exception class
			throw new UserNotFoundException("id: "+id+" not found. enter exisiting user id");
		
		return user;
	}

	@PostMapping("users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = service.save(user);

		if(savedUser==null)
		return ResponseEntity.badRequest().body("User exists");

		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri(); 

				/* for testing. uri is like "http://localhost:8080/users/4"	*/
				System.out.println("location is: "+location);
				
				return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("users/{id}")
	public void deleteUser(@PathVariable int id) {
		
		User user= service.deleteById(id);
		
		if(user==null)
			throw new UserNotFoundException("id: "+id+" not found - no deletion happens");
		
	}
}








