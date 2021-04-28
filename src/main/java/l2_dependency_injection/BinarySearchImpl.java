package l2_dependency_injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component //1. tell spring this is a bean
public class BinarySearchImpl {

	@Autowired //2. define this as dependency
	private SortAlgorithm sortAlgorithm;

	/*
	 * if u 1 setter injection, generate setter.
	 * if u 1 constr injection, generate constr.
	 * if u dont both either one, it'll be setter by default 
	 */

	/*
	public BinarySearchImpl(SortAlgorithm sortAlgorithm) {
		super();
		this.sortAlgorithm = sortAlgorithm;
	}
	 */
	public void setSortAlgorithm(SortAlgorithm sortAlgorithm) {
		this.sortAlgorithm = sortAlgorithm;
	}





	public int binarySearch(int[] numbers, int numberToSearchFor) {

		// implement whatever logic by using the interface as the reference.
		int[] sortedNumbers = sortAlgorithm.sort(numbers);
		System.out.println(sortAlgorithm);


		return 3;
	}


}
