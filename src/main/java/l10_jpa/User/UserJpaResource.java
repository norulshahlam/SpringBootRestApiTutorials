package l10_jpa.User;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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

/*
 * when implementing jpa into rest service, we wont be using our create method.
 * we will use methods given by jparepository
 * some of the exception will be handled by jpa
 */

@RestController
public class UserJpaResource {

	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private UserRepo userRepo;

	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		return userRepo.findAll();
	}

	@GetMapping("users/{id}")
	public Optional<User> retrieveUser(@PathVariable int id) {
		
		Optional<User> user= userRepo.findById(id);
		
		if(!user.isPresent()) {
				//this is the status message and exception class
			throw new UserNotFoundException("id: "+id+" not found. enter exisiting user id");
		}
		
		return user;
	}

	@PostMapping("users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = userRepo.save(user);

		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri(); 

				/* for testing. uri is like "http://localhost:8080/users/4"	*/
				System.out.println("location is: "+location);
				
				return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("users/{id}")
	public void deleteUser(@PathVariable int id) {
		
		userRepo.deleteById(id);
	}
	
	//	retrieve post of user
	@GetMapping("users/{id}/posts")
	public List<Post> retrievePostUsers(@PathVariable int id){
		Optional<User> userPost = userRepo.findById(id);
		
		if(!userPost.isPresent())
			throw new UserNotFoundException("user post not found. id: "+id);
		
		return userPost.get().getPosts();
	}
	
	
	
	//	create post of user
	@PostMapping("users/{id}/posts")
	public ResponseEntity<Object> createPostUsers(@PathVariable int id, @RequestBody Post post){
		
		Optional<User> userPost = userRepo.findById(id); //Retrieves an entity by its id.
		
		if(!userPost.isPresent())
			throw new UserNotFoundException("user post not found. id: "+id);
		
		//	create new post
		User user = userPost.get();		//insert val of user into user,
		post.setUser(user); //map user to post
		postRepo.save(post);	//save post
		
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}").buildAndExpand(post.getId()).toUri(); 

				/* for testing. uri is like "http://localhost:8080/users/4"	*/
				System.out.println("location is: "+location);
				
				return ResponseEntity.created(location).build();
	}
}








