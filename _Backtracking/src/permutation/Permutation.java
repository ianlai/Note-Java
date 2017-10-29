package permutation;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Permutation {
	boolean isDebug = true;

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
		_permutation(input, 0, result);
		return result;
	}

	private void _permutation(List<Integer> arr, int k, List<List<Integer>> list) {
		if (k == arr.size() - 1) {
			List l = new ArrayList(arr);
			// list.add(arr); //No, we need to create a new list to put into the
			// double list
			list.add(l);
			return;
		}
		for (int i = k; i < arr.size(); ++i) {
			Collections.swap(arr, i, k);
			_permutation(arr, k + 1, list);
			Collections.swap(arr, k, i);
		}
	}

	// --------------------------------------------------
	/*
	 * Get all the permutations. Notice that all the input element should be
	 * distinct. Use backtrack function (try).
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
				if (tempList.contains(nums[i]))
					continue; // element already exists, skip
				tempList.add(nums[i]);
				backtrack(list, tempList, nums);
				tempList.remove(tempList.size() - 1);
			}
		}
	}

	// --------------------------------------------------
	/*
	 * Get all the permutations. Input element might have duplicates. 
	 * Use backtrack function (try).
	 */
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
		return list;
	}

	private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, boolean[] used) {
		if (tempList.size() == nums.length) {
			list.add(new ArrayList<>(tempList));
		} else {
			for (int i = 0; i < nums.length; i++) {
				if (used[i])                                         //skip1: This is the normal permute 
					continue;
				if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) //skip2: Handle duplicates 
					continue;                                        //       Don't put same value element at the same position
					                                                 //       1 2a 2b 2c 3
					                                                 //       1 2b            x skip this because 2a is not used
					                                        		 //       1 2a 2c         x skip this because 2a 2b pattern exists (2b not used)
				                                                     //       1 2c            x skip this because 2b==2c and 2b not used
				                                                     //       1 3 2a 2b 2c    o not skip this because 2b is in used, so they are different pattern   
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
}
