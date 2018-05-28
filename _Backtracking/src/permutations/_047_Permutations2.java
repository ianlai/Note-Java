package permutations;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class _047_Permutations2 {
	boolean isDebug = true;
	
	public static void main(String[] args){
		int[] arr = new int[] { 1, 2, 3, 4};
		int[] arrRepeat = new int[] { 1, 2, 2, 3 };
		_047_Permutations2 obj = new _047_Permutations2();
		List<List<Integer>> result1 = obj.permuteUnique(arr);        //ok
		List<List<Integer>> result2 = obj.permuteUnique(arrRepeat);  //ok

		printList(result1); // correct
	    printList(result2); // correct
	}

	/*
	 * Get all the permutations. Input element might have duplicates. 
	 * Use backtrack function (try).
	 * 
	 * Remove the redundant: 
	 * If it is a duplicated number, it can be used only when the previous duplicate is used! 
	 * Don't put same value element at the same position.
	 * 
     * Ex.  1 2a 2b 2c 3
     *      1 2b            x skip this because 2a (previous) is not used
	 *      1 2a 2c         x skip this because 2a 2b pattern exists (2b not used)
     *      1 2c            x skip this because 2b (previous) is not used
     *      1 3 2a 2b 2c    o not skip this because 2b is in used, so they are different pattern  
	 */
 
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);   //sorting first!
		backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
		return list;
	}
	/* nums    : input 
	 * list    : answer
	 * tempList: use to create a list 
	 * used    : to identify the element is used or not
	 */
	private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, boolean[] used) {
		if (tempList.size() == nums.length) {
			list.add(new ArrayList<>(tempList));
		} else {
			for (int i = 0; i < nums.length; i++) {
				if (used[i])                                   //skip1: This is the normal permute 
					continue;
				if (i > 0 && nums[i]==nums[i-1] && !used[i-1]) //skip2: Handle duplicates 
					continue;                                  
				used[i] = true;
				tempList.add(nums[i]);
				backtrack(list, tempList, nums, used);
				used[i] = false;
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
