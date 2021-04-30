package l6_response_status.user;

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
		return service.findOne(id);
	} 

	@PostMapping("users")
	public ResponseEntity <Object> createUser(@RequestBody User user) {
		User savedUser = service.save(user);

		/* 
	for this method, input = user details, output = CREATED status & created URI
			  
	4. this part below is how to get http status code 'CREATED'. there are 2 parts:
	1st part is to get the uri from the current request created
	2nd part is to use the uri to set the http return status		 * 
	
	1st part:
	- ServletUriComponentsBuilder: a. this main method will create uri based on the current HttpServletRequest.
	- .fromCurrentRequest()  b. your current request is 'users' from @PostMapping("users")
	- .path("{id}")	c. this part is to append to the current req ie /users/{id}
	.buildAndExpand(savedUser.getId()) d. replace above request into this param
	.toUri(); // and from the param input, create URI.

		 */

		URI location = ServletUriComponentsBuilder
		.fromCurrentRequest()  
		.path("/{id}")	
		.buildAndExpand(savedUser.getId())
		.toUri(); 

		/* for testing. uri will be like "http://localhost:8080/users/4"	*/
		System.out.println("location is: "+location);
		

		/* 
		2nd part is:

		1. set return status of "created" by ResponseEntity
		this part take uri from the uri created above and return the status code.
		ResponseEntity - Create a new {@code ResponseEntity} with the given status code 
		and no body nor headers
		2. "created" - is the one that is repsponsible for returning the status code.
		or, create a new builder with a status and a location header set to the given URI.

		location refer to the location of the resource that was created in URI format

		this location will be added to the Headers tab -> content
		 */

		return ResponseEntity.created(location).build();
	}
}
