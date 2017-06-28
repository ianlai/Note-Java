package permutation;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		Permutation p = new Permutation();
		int[] arr = new int[] { 1, 2, 3, 4, 5 };
		List<List<Integer>> result = p.getPermutation(arr);

		for (int i = 0; i < result.size(); ++i) {
			System.out.println(i + 1 + ": " + result.get(i));
		}

	}

}
