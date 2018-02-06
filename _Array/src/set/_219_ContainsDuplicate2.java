package set;

import java.util.HashSet;
import java.util.Set;

/* Given an array of integers and an integer k, 
 * find out whether there are two distinct indices i and j in the array 
 * such that nums[i] = nums[j] and the absolute difference 
 * between i and j is at most k.
 */
public class _219_ContainsDuplicate2 {

	public static void main(String[] args) {
		_219_ContainsDuplicate2 obj = new _219_ContainsDuplicate2();
		int[] arr1 = new int[]{7,3,5,6,2,3,4,9,8,5};
		System.out.println(obj.containsNearbyDuplicate(arr1, 1)); //false
		System.out.println(obj.containsNearbyDuplicate(arr1, 2)); //false
		System.out.println(obj.containsNearbyDuplicate(arr1, 3)); //false
		System.out.println(obj.containsNearbyDuplicate(arr1, 4)); //true (3)
		System.out.println(obj.containsNearbyDuplicate(arr1, 5)); //true (3)
	}

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        
        k = Math.min(k, nums.length); //k might be larger than the length
        
        /* Add first k elements into set to check the duplicate */
        for(int i=0; i<k; i++){
            if(!set.add(nums[i])) return true;
        }
        
        /* After k elements, we need to remove the oldest one after adding the newest one 
           Note that adding should be done before removal which means in a certain moment, 
           the size of the set will be k+1 
         */
        for(int i=k; i<nums.length; i++){      
            if(!set.add(nums[i])) return true;  //add first 
            set.remove(nums[i-k]);              //remove later 
        }
        return false;
    }
}