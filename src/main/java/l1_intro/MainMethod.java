package l1_intro;
/*
 * this is the most basic example of loose coupling using interface
 * 
 * 2 classes (bubble & quick sort) implements and interface.
 * search class implements either one of this classes.
 * search class obj is created in main n runs this sort methods.
 * to achieve loose coupling, instead of implementing either of the 2 class in search class,
 * the interface itself is called in search class.
 * search class obj is still called in main, but is referenced to whichever 2 class u 1 2 use
 * 
 * 			
 * 
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainMethod {

	public static void main(String[] args) {
		
		
		// we use interface as ref for loose coupling. then we implement / 		change the classes we want
		BinarySearchImpl binarySearch = new BinarySearchImpl(new QuickSortAlgorithm());
		int result = binarySearch.binarySearch(new int[] {1,  2, 6}, 3);
		System.out.println(result);
		
		SpringApplication.run(MainMethod.class, args);
	}
}
