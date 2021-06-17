package l11_content_negotiation.User;

import java.net.URI;
import java.util.List;

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
public class UserController {

	@Autowired
	private UserDaoService service;

	@GetMapping("/users")
	public List<User> getAllUsers() {

		return service.findAll();
	}

	@GetMapping("/users/{id}")
	public User getUser(@PathVariable int id) {

		User user = service.getUser(id);
		return user;

	}

	@PostMapping("/create")
	public ResponseEntity<String> createUser(@RequestBody User user) {
		User savedUser = service.createUser(user);

		if (savedUser != null) {
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
					.toUri();
			return ResponseEntity.created(location).body("User created!");
		}

		return ResponseEntity.badRequest().body("User exists");
	}

	@DeleteMapping("/delete/{id}")
	public User deleteUser(@PathVariable int id) {

		User user = service.deleteUser(id);
		return user;

	}

	/*
	 * define http response and message
	 */

}
