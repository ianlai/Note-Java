package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//https://leetcode.com/problems/kth-largest-element-in-an-array/discuss/

public class _215_KthLargestElementInAnArray {

	public static void main(String[] args) {
		_215_KthLargestElementInAnArray obj = new _215_KthLargestElementInAnArray();
		int[] arr = new int[]{3,7,6,1,8,2,9,5,1,9,8,2,7,6,3};
		
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<arr.length; ++i){
			list.add(arr[i]);
		}
		
		System.out.println("===Original===");
		System.out.println(Arrays.toString(arr));
		
		//System.out.println("===Ascending ===");
		//Arrays.sort(arr);                                    //normal sorting (array and collection) 
		//System.out.println(Arrays.toString(arr));
		
		//System.out.println("===Descending ===");
		//Collections.sort(list, Collections.reverseOrder());  //reverse sorting (collection)
		//System.out.println(list);
		
		int k = 3; 
		System.out.println(obj.findKthLargest(arr, k));
	}

	    /* Sort collections in reverse order 
	     * 49.81%
	     */
	    // public int findKthLargest(int[] nums, int k) {
	    //     List<Integer> list = new ArrayList<Integer>();
	    //     for(int i=0; i<nums.length; ++i){
	    //         list.add(nums[i]);
	    //     }
	    //     Collections.sort(list, Collections.reverseOrder());
	    //     return list.get(k-1);
	    // }
	    
	    /* Sort primitive array in ascending order and then reverse */
	    /* Primitive array cannot sort reverse order directly 
	     * 79.54%
	     */
	    // public int findKthLargest(int[] nums, int k) {
	    //     Arrays.sort(nums);
	    //     int i=0; 
	    //     int j=nums.length-1;
	    //     while(i<j){
	    //         int temp = nums[j];
	    //         nums[j] = nums[i];
	    //         nums[i] = temp;
	    //         i++;
	    //         j--;
	    //     }
	    //     return nums[k-1];
	    // }
	    
	    /* Sort primitive array in ascending order and then take from the back 
	     * 94.53%
	     * Fatest!! 
	     */
	    public int findKthLargest(int[] nums, int k){
	        Arrays.sort(nums);
	        return nums[nums.length-k];
	    }
	    
	    /* Bubble sort: 
	     * 0.31% 
	     */
	    // public int findKthLargest(int[] nums, int k){
	    //     int n = nums.length;
	    //     for(int i=n-1; i>0 ;i--){
	    //         for(int j=0; j<i; j++){
	    //             if(nums[j]>nums[j+1]){
	    //                 int t=nums[j+1];
	    //                 nums[j+1] = nums[j];
	    //                 nums[j] = t; 
	    //             }
	    //         }
	    //     }   
	    //     return nums[n-k];
	    // }
	    
	    /* Bubble sort (optimized): 
	     * 2.46% 
	     */
	    // public int findKthLargest(int[] nums, int k){
	    //     int n = nums.length;
	    //     for(int i=n-1; i>n-1-k ;i--){
	    //         for(int j=0; j<i; j++){
	    //             if(nums[j]>nums[j+1]){
	    //                 int t=nums[j+1];
	    //                 nums[j+1] = nums[j];
	    //                 nums[j] = t; 
	    //             }
	    //         }
	    //     }   
	    //     return nums[n-k];
	    // }
}