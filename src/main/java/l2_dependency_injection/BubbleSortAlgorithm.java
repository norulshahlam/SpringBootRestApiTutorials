package l2_dependency_injection;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary //6. for multiple beans, just add @primary to the class u 1 2 implement
public class BubbleSortAlgorithm implements SortAlgorithm {
	

	public int[] sort(int[] numbers) {
		
		// logic for bubble sort
		return numbers;
	}
}
