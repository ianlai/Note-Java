package array;

import java.util.Arrays;

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
            if(nums[i] < nums[i-1]) return i-1;
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