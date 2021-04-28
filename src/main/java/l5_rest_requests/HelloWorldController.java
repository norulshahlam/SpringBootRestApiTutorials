package l5_rest_requests;

/*
 * this lesson will show a series of examples from most basic request
 * to advanced. 
 * 
 * 1. how to return hardcoded string
 * 2. how to return beans
 * it is impt to have constructor, and getter setters else there is be compile error
 * 
 * 3. how to use pathvariable - user input on the uri
 */
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

//	1. getmapping means using Get method. for post method, u can use postmapping
	@GetMapping(path="/hello-world")
	public String helloWorld(){
		return "Hello World";
	}
	
	// 2. how to return a bean
	@GetMapping(path="/hello-world-beans")
	public HelloWorldBean helloWorldBean(){
		return new HelloWorldBean("Hello World");
	}
	
	// 3. using path variable
	@GetMapping(path="/hello-world/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name){
		return new HelloWorldBean (String.format("Hello, %s", name));
	}
	
}








