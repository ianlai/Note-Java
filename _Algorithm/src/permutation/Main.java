package permutation;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		Permutation p = new Permutation();
		int[] arr = new int[] { 1, 2, 3 };
		List<List<Integer>> result1 = p.permute1(arr);
		List<List<Integer>> result2 = p.permute2(arr);
		List<List<Integer>> result3 = p.permuteUnique(arr);

		int[] arrRepeat = new int[] { 1, 2, 2, 3 };
		List<List<Integer>> resultRepeat1 = p.permute1(arrRepeat);
		List<List<Integer>> resultRepeat2 = p.permute2(arrRepeat);
		List<List<Integer>> resultRepeat3 = p.permuteUnique(arrRepeat);

		printList(result1); // correct
		printList(result2); // correct
		printList(result3); // correct
		printList(resultRepeat1); // wrong (redundant is also shown)
		printList(resultRepeat2); // wrong (no result because the element will
							      //        never be enough to be added in)
		printList(resultRepeat3); // correct

	}

	public static void printList(List<List<Integer>> ll) {
		for (int i = 0; i < ll.size(); ++i) {
			System.out.println(i + 1 + ": " + ll.get(i));
		}
		System.out.println("------------------------");
	}

}
