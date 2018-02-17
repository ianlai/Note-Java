package array;

import java.util.Arrays;

/* Given an array and a value, remove all instances of that value in-place and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place 
 * with O(1) extra memory.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * Example:
 * Given nums = [3,2,2,3], val = 3,
 * Your function should return length = 2, with the first two elements of nums being 2.
 */

public class _027_RemoveElement {

	public static void main(String[] args) {
		_027_RemoveElement obj = new _027_RemoveElement();
		int[] arr = new int[]{4,2,3,7,6,7,3,2,9,1};
		int del = 3;
		int newlength = obj.removeElement(arr, del);
		
		/* All elements */
		System.out.println(Arrays.toString(arr));
		
		/* Within new length */
		for(int i=0; i<newlength; i++){
			System.out.print(arr[i] + " ");
		}
	}

    public int removeElement(int[] nums, int val) {
        int cur = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==val) continue;
            nums[cur++] = nums[i];
        }
        return cur;
    }
}