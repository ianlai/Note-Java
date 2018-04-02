package array;

import java.util.ArrayList;
import java.util.List;

/* https://leetcode.com/problems/find-all-duplicates-in-an-array/description/
 * special condition-1:  1 ≤ a[i] ≤ n (n = size of array)
 * special condition-2:  once or twice 
 * constraint: O(n)
 * constraint: no extra space 
 * return: list containing the duplicates 
 */ 

/* Because the input has condition-1 and condition-2 constrains, 
 * we can use positive or negative of the original array to 
 * store the information whether there are duplicates*/

public class _442_DuplicatesInArray {
	public static void main(String[] args) {
		int[] arr = new int[]{4,3,2,7,8,2,3,1};
		System.out.println(findDuplicates(arr));
	}
    public static List<Integer> findDuplicates(int[] nums) {
        
        List<Integer> l = new ArrayList<>();
        if(nums==null || nums.length==0) return l;
        for(int i=0; i<nums.length; ++i){
            int index = Math.abs(nums[i])-1;  //value -> index
            if(nums[index]<0){  //2nd 
                int val = index + 1;          //index -> value
                l.add(val);
            }else{              //1st
                nums[index] = -nums[index];
            }    
        }
        return l;
        
        /* use extra space */ 
        /*
        Set<Integer> s = new HashSet<>();
        List<Integer> l = new ArrayList<>();
        if(nums==null || nums.length==0) return l;
        for(int i=0; i<nums.length; ++i){
            if(s.contains(nums[i])){
                l.add(nums[i]);
            }else{           
                s.add(nums[i]);
            }
        }
        return l;
        */
    }
}