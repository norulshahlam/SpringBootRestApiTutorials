package l2_dependency_injection;

import org.springframework.stereotype.Component;


@Component //1. tell spring this is a bean
public class QuickSortAlgorithm implements SortAlgorithm {
	
	public int[] sort(int[] numbers) {
		
		// logic for bubble sort
		return numbers;
	}
}
