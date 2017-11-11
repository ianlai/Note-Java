package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class _384_ShuffleAnArray {

	public static void main(String[] args) {
		int[] arr = new int[]{1,2,3,4,5,6,7,8,9};
		Solution s = new Solution(arr);
		
		int[] shuffle = s.shuffle();
		int[] reset   = s.reset();
		
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(shuffle));
		System.out.println(Arrays.toString(reset));

	}
	
	static class Solution {
	    public static int[] ori;
	    public static int size;
	    public Solution(int[] nums) {
	        size = nums.length;
	        ori = new int[size];
	        for(int i=0; i<size; i++){
	            ori[i] = nums[i];
	        }
	    }
	    
	    /** Resets the array to its original configuration and return it. */
	    public int[] reset() {
	        return ori;
	    }
	    
	    /** Returns a random shuffling of the array. */
	    public int[] shuffle() {
	        List<Integer> list = new ArrayList<Integer>();
	        for(int i=0; i<size; i++){
	            list.add(ori[i]);
	        }
	        int[] result = new int[size];
	        Random rand = new Random();
	        for(int i=0; i<size; i++){
	            int r = rand.nextInt(list.size());
	            result[i] = list.get(r);
	            list.remove(r);
	        }
	        return result;
	    }
	}

}


/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */