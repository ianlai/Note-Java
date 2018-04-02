package array;

import java.util.ArrayList;
import java.util.List;

/*
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), 
 * some elements appear twice and others appear once.
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * Could you do it without extra space and in O(n) runtime? 
 * You may assume the returned list does not count as extra space.
 * Example:
 * Input:  [4,3,2,7,8,2,3,1]
 * Output: [5,6]
 */

/* Each element appear: 0, 1, 2 times
 * If one element found 1st time: toggle its corresponding position to be negative
 * If one element found 2nd time: since its corresponding position is negative already, ignore it
 * When the traverse finished, both one-time and two-time will be negative. 
 * Only the positive one does not appear. 
 */
public class _448_FindAllNumbersDisappearedInAnArray {

	public static void main(String[] args) {
		_448_FindAllNumbersDisappearedInAnArray obj = new _448_FindAllNumbersDisappearedInAnArray();
		int[] arr1 = new int[]{4,5,2,5,1,6,4,3};  //7,8
		int[] arr2= new int[]{1,4,6,7,7,4,2};     //3,5
		
		System.out.println(obj.findDisappearedNumbers(arr1));
		System.out.println(obj.findDisappearedNumbers(arr2));
	}

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        if(nums==null || nums.length==0) return ans;
        for(int i=0; i<nums.length; i++){
            int index = Math.abs(nums[i])-1;
            if(nums[index]>0){   //1st
                nums[index] = -nums[index];
            }
            //ignore 2nd (don't care)
        }
        for(int i=0; i<nums.length; i++){
            if(nums[i]>0){
                ans.add(i+1);
            }
        }
        return ans;
    }
}