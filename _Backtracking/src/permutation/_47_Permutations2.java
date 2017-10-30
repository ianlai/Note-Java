package permutation;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class _47_Permutations2 {
	boolean isDebug = true;

	/* IMPORTANT */
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
