package _Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//https://leetcode.com/problems/kth-largest-element-in-an-array/discuss/

public class FindKthLargest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[]{3,7,6,1,8,2,9,5,1,2,7,6,3};
		
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<arr.length; ++i){
			list.add(arr[i]);
		}
		
		System.out.println(Arrays.toString(arr));
		Arrays.sort(arr);                                    //normal sorting (array and collection) 
		System.out.println(Arrays.toString(arr));
		Collections.sort(list, Collections.reverseOrder());  //reverse sorting (collection)
		System.out.println(list);
		
		System.out.println(findKthLargest(arr, 3));
	}

    public static int findKthLargest(int[] nums, int k) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0; i<nums.length; ++i){
            list.add(nums[i]);
        }
        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list);
        
        int count=0;
        while(true){
            // if(count > 0 && list.get(count) == list.get(count-1)){
            //     count++;
            //     continue;
            // }
            if(k==1) return list.get(count);
            else {
                k--;
                count++;
            }
        }
    }
}