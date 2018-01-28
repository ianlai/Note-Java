package permutations;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class _046_Permutations {
	boolean isDebug = true;
	
	public static void main(String[] args){
		
		int[] arr = new int[] { 1, 2, 3, 4};
		int[] arrRepeat = new int[] { 1, 2, 2, 3 };
		_046_Permutations  p1 = new _046_Permutations();
		List<List<Integer>> result1 = p1.permute1(arr);  //ok
		List<List<Integer>> result2 = p1.permute2(arr);  //ok
		List<List<Integer>> result3 = p1.permute1(arrRepeat);  //no
		List<List<Integer>> result4 = p1.permute2(arrRepeat);  //no

		printList(result1); // correct
	    printList(result2); // correct
		printList(result3); // wrong: redundant result
		printList(result4); // wrong: no result 
	}

	/*
	 * Get all the permutations. Notice that all the input element should be
	 * distinct. Use swap. 
	 */
	public List<List<Integer>> permute1(int[] arr) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> input = new ArrayList<Integer>();
		if (arr.length == 0)
			return result;
		for (int e : arr) {
			input.add(e);
		}
		helper(input, 0, result);
		return result;
	}

	private void helper(List<Integer> arr, int k, List<List<Integer>> list) {
		if (k == arr.size() - 1) {
			List l = new ArrayList(arr);
			// list.add(arr); //No, we need to create a new list to put into the
			// double list
			list.add(l);
			return;
		}
		for (int i = k; i < arr.size(); ++i) {
			//debug(i+"");
			Collections.swap(arr, i, k);
			helper(arr, k + 1, list);
			Collections.swap(arr, k, i);
		}
	}

	// --------------------------------------------------
	/* IMPORTANT */
	/*
	 * Get all the permutations. Notice that all the input element should be
	 * distinct. Use backtrack function (try).
	 * This is clearer, but it tries more in the loop. 
	 */
	public List<List<Integer>> permute2(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		// Arrays.sort(nums); // not necessary
		backtrack(list, new ArrayList<>(), nums);
		return list;
	}

	private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums) {
		if (tempList.size() == nums.length) {
			list.add(new ArrayList<>(tempList));
		} else {
			for (int i = 0; i < nums.length; i++) {
				//debug(i+"");
				if (tempList.contains(nums[i]))
					continue; // element already exists, skip
				tempList.add(nums[i]);
				backtrack(list, tempList, nums);
				tempList.remove(tempList.size() - 1);
			}
		}
	}

	// --------------------------------------------------
	private void debug(String s) {
		if (isDebug)
			System.out.println(s);
	}
	public static void printList(List<List<Integer>> ll) {
		for (int i = 0; i < ll.size(); ++i) {
			System.out.println(String.format("%3s: %s", i+1, ll.get(i)));
		}
		System.out.println("------------------------");
	}
}
