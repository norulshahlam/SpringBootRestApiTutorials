package l2_dependency_injection;

/*
 * last lesson we learnt that obj of interface SortAlgorithm
 * is the dependency are other classes are depended on, and how
 * it is implemented in service class and main class.
 * 
 * now in this lesson we r 
 * 1. using spring to acheieve dependency injection so some of earlier codes will be modified
 * there are 2 types of injection n we will be showing both.
 * 
 * 2. also how to enable log to see what is happening behind by 
 * configuring application.properties
 * 
 * some of the steps:
 * 
 * 1. what are beans? how to define beans? @Component
 * 
 * 	By definition, a Spring bean is an object that form the backbone of your application and 		that is managed by the Spring IoC container. A bean is an object that is instantiated, 		assembled, and otherwise managed by a Spring IoC container
 * 	
 * 2. where are the dependencies of a beans? how to define them @Autowired
 * 3. where to scan for beans when called? since bean is same package as 
 *	  main, we dont need to specify that @ComponentScan
 * 
 * 4. what kind of injection? if setter, generate setter. if constr, generate constr.
 *    note that if u dont do either one, by default it'll b setter.
 * 
 * 5. after config all above, how to get the beans?
 * 
 * 6. can u have multiple beans? YES! just add @primary to the class u 1 2 implement
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@SpringBootApplication
public class MainMethod {

	public static void main(String[] args) {

		// 5. after config below, how to get the beans? use application context
		ApplicationContext applicationContext = SpringApplication.run(MainMethod.class, args);

		/*
		 we dont need below code as spring will create 1 for us. which class u 1 2
		 implement, just add @component to the class. u can add to both class but add

			BinarySearchImpl binarySearch = new BinarySearchImpl(new
			QuickSortAlgorithm());
		 
		 add @primary to the class u 1 2 implement
		 */

		BinarySearchImpl binarySearch = applicationContext.getBean(BinarySearchImpl.class);

		int result = binarySearch.binarySearch(new int[] { 1, 2, 6 }, 3);
		System.out.println(result);
	}
}