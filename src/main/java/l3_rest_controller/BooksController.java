package l3_rest_controller;

import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
/*
 * we will be create simple rest controller on getting info on books
 * 1st: creaete pojo of book
 * generate getters setters, constructor, toString methods
 * 
 * 2nd: creeate class to handle requests - we return a mock data here just to simulate the response
 */
@RestController
public class BooksController {

	
	@GetMapping("/books")
	public List<Book> getAllBooks(){
		return Arrays.asList(new Book(1l,"Master microservices", "Shah"));
		
	}
}
