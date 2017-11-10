package array;

import java.util.HashSet;
import java.util.Set;

public class _217_ContainsDuplicate {

	public static void main(String[] args) {
		_217_ContainsDuplicate obj = new _217_ContainsDuplicate();
		int[] arr1 = new int[]{8,4,2,6,1,6,9,3};
		int[] arr2 = new int[]{8,4,2,1,6,9,3,12,74,23,5};
		System.out.println(obj.containsDuplicate(arr1));
		System.out.println(obj.containsDuplicate(arr2));
	}
    public boolean containsDuplicate(int[] nums) {
        if(nums.length==0) return false;
        Set<Integer> set = new HashSet<Integer>();
        for(int e: nums){
            if(set.contains(e)) return true;
            else set.add(e);
        }
        return false;
    }
}