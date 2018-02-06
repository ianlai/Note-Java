package set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* Given an array of integers, find if the array contains any duplicates. 
 * Your function should return true if any value appears at least twice in the array, 
 * and it should return false if every element is distinct.
 * 
 * Return true if there is any duplicates. 
 * Otherwise, return false.
 */
public class _217_ContainsDuplicate {

	public static void main(String[] args) {
		_217_ContainsDuplicate obj = new _217_ContainsDuplicate();
		int[] arr1 = new int[]{8,4,2,6,1,6,9,3};                  //true
		int[] arr2 = new int[]{8,4,2,1,6,9,3,12,74,23,5};         //false
		int[] arr3 = new int[]{8,4,2,1,6,9,5,7,14,18,84,23,51};   //false
		System.out.println(obj.containsDuplicate1(arr1));
		System.out.println(obj.containsDuplicate2(arr2));
		System.out.println(obj.containsDuplicate2(arr3));
	}
	
	/* Beats 26.37% ; 21ms (two-time judge) */ 
    public boolean containsDuplicate1(int[] nums) {
        if(nums.length==0) return false;
        Set<Integer> set = new HashSet<Integer>();
        for(int e: nums){
            if(set.contains(e)) return true;
            else set.add(e);
        }
        return false;
    }
    
    /* Beats 66.58% ; 14ms (one-time judge) */ 
    public boolean containsDuplicate2(int[] nums) {
        if(nums.length==0) return false;
        Set<Integer> set = new HashSet<Integer>();
        for(int e: nums){
            if(!set.add(e)) return true;
        }
        return false;
    }
    
    /* Beats 86.04% ; 6ms (sorting) */ 
    public boolean containsDuplicate3(int[] nums) {
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i++) {
            if(nums[i-1]==nums[i])  return true;
        }
        return false;
    }
}