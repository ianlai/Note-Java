package _Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//https://leetcode.com/problems/kth-largest-element-in-an-array/discuss/

public class _215_KthLargestElementInAnArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		System.out.println(findKthLargest(arr, k));
	}

    public static int findKthLargest(int[] nums, int k) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0; i<nums.length; ++i){
            list.add(nums[i]);
        }
        System.out.println("===Descending ===");
        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list);
        System.out.println("k:" + k);
        
        return list.get(k-1);
    }
}