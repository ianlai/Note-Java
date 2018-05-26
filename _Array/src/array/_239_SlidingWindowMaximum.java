package array;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

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
		int[] a2 = new int[]{7,2,4,8,1,5,9,3}; 
		
		/* Slow */
		System.out.println(Arrays.toString(obj.maxSlidingWindowSlow(a1, 3))); // 3,3,5,5,6,7
		System.out.println(Arrays.toString(obj.maxSlidingWindowSlow(a1, 4))); // 3,5,5,6,7

		System.out.println(Arrays.toString(obj.maxSlidingWindowSlow(a2, 2))); // 7,4,8,8,5,9,9
		System.out.println(Arrays.toString(obj.maxSlidingWindowSlow(a2, 5))); // 8,8,9,9
		
		System.out.println("================");
		
		/* Fast */
		System.out.println(Arrays.toString(obj.maxSlidingWindow(a1, 3))); //3,3,5,5,6,7
		System.out.println(Arrays.toString(obj.maxSlidingWindow(a1, 4))); //3,5,5,6,7
		
		System.out.println(Arrays.toString(obj.maxSlidingWindow(a2, 2))); //7,4,8,8,5,9,9
		System.out.println(Arrays.toString(obj.maxSlidingWindow(a2, 5))); //8,8,9,9
		
	}
    /* Check the whole window each time, slow (6.5%), time complexity: O(nk) */
    public int[] maxSlidingWindowSlow(int[] nums, int k) {
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
    /* Use deque, fast (72%), time complexity: O(n) */ 
    /* nums : original array 
       deque: maintain the max at first, add the element at last (dynamic size)
       ans  : the max of sliding window
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        /* Corner case */
        if(nums==null || nums.length==0) return new int[0];
        
        Deque<Integer> deque = new ArrayDeque<>();
        int[] ans = new int[nums.length-k+1];
        
        for(int i=0; i<nums.length; i++){
            int cur = nums[i];
            
            /* Remove the elements less than cur from last */
            while(!deque.isEmpty() && cur>deque.peekLast()){
                deque.pollLast();  
            }
            
            /* Add cur */
            deque.addLast(cur);
            
            /* Remove the outdated max (if the max equals to the element k before) */
            if(i>=k && deque.peekFirst()==nums[i-k]){
                deque.pollFirst();
            }
            
            /* Get the max and put it into the ans array */
            if(i>=k-1){
                ans[i-k+1] = deque.peekFirst();
            }
        }
        return ans;
    }
}
