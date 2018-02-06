package array;

import java.util.Arrays;
/*
 * A peak element is an element that is greater than its neighbors.
 * Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.
 * The array may contain multiple peaks, in that case 
 * return the index to any one of the peaks is fine.  //any peak element's index is fine
 * You may imagine that num[-1] = num[n] = -∞.
 * 
 * For example, in array [1, 2, 3, 1], 3 is a peak element 
 * and your function should return the index number 2.
 */
public class _162_FindPeakElement {

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] arr = new int[]{1,2,2,3,3,4,4,5,4,7,8,9,4,3,5};
		System.out.println(Arrays.toString(arr));
		System.out.println(s.findPeakElement(arr));
	}
}

class Solution {
	
	/* Sol1: Faster than Sol2 */
    public int findPeakElement(int[] nums) {
        if(nums==null || nums.length==0) return -1;
        for(int i=1; i<nums.length; i++){
        	/* Why only test right hand side is enough? (main is i-1)
        	 * Because if nums[i-2] > nums[i-1], i-2 should be returned before.
        	 * 
        	 * Or, we can think, from nums[-1]=Integer.MIN_VALUE, 
        	 * nums[0] must larger than nums[-1], 
        	 * then nums[1] must larger than nums[0], //or nums[0] should be returned
        	 * then nums[2] must larger than nums[1], //or nums[1] should be returned
        	 * until the end of the array. 
        	 */
            if(nums[i-1] > nums[i]) return i-1;  
        }
        return nums.length-1;
    }
    
    /* Sol2: Work, but not efficient enough */
    // public int findPeakElement(int[] nums) {
    //     if(nums==null || nums.length==0) return -1;
    //     for(int i=0; i<nums.length; i++){
    //         if(i==0 && i==nums.length-1){  //only one element
    //             return i; 
    //         }
    //         if(i==0){
    //             if(nums[i] > nums[i+1]) return i;
    //         }else if(i==nums.length-1){
    //             if(nums[i] > nums[i-1]) return i;
    //         }else{
    //             if(nums[i] > nums[i-1] && nums[i] > nums[i+1]) return i;   
    //         }
    //     }
    //     return -1;
    // }
}