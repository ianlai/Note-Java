package array;

import java.util.Arrays;

/*
 * Given an array nums, there is a sliding window of size k which is moving from the very left 
 * of the array to the very right. 
 * You can only see the k numbers in the window. 
 * Each time the sliding window moves right by one position. Return the max sliding window.

	Example:
	
	Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
	Output: [3,3,5,5,6,7] 
	Explanation: 
	
	Window position                Max
	---------------               -----
	[1  3  -1] -3  5  3  6  7       3
	 1 [3  -1  -3] 5  3  6  7       3
	 1  3 [-1  -3  5] 3  6  7       5
	 1  3  -1 [-3  5  3] 6  7       5
	 1  3  -1  -3 [5  3  6] 7       6
	 1  3  -1  -3  5 [3  6  7]      7
	Note: 
	You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.
	
	Follow up:
	Could you solve it in linear time?
 */
public class _239_SlidingWindowMaximum {
	public static void main(String[] args) {
		_239_SlidingWindowMaximum obj = new _239_SlidingWindowMaximum();
		int[] a1 = new int[]{1,3,-1,-3,5,3,6,7};
		
		System.out.println(Arrays.toString(obj.maxSlidingWindow(a1, 3))); //3,3,5,5,6,7
		System.out.println(Arrays.toString(obj.maxSlidingWindow(a1, 4))); //3,5,5,6,7
		
	}
    /* Slow method: O(nk) */
    public int[] maxSlidingWindow(int[] nums, int k) {
		if(nums.length==0) return new int[0];

        int[] ans = new int[nums.length-k+1];
        
        for(int i=k-1; i<nums.length; i++){
            int max=Integer.MIN_VALUE; 
            for(int j=0; j<k; j++){
                if(nums[i-j]>max) max=nums[i-j];
            }
            ans[i-k+1]=max;
        }
        return ans;
    }

}
