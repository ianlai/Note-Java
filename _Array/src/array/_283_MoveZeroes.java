package array;
/*
 * Given an array nums, write a function to move all 0's to the end of it 
 * while maintaining the relative order of the non-zero elements.
 * 
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, 
 * nums should be [1, 3, 12, 0, 0].
 */

import java.util.Arrays;

public class _283_MoveZeroes {

	public static void main(String[] args) {
		_283_MoveZeroes obj = new _283_MoveZeroes();
		int[] arr = new int[]{0,0,5,9,0,4,2,0};
		System.out.println("Before: " + Arrays.toString(arr));
		obj.moveZeroes(arr);
		System.out.println("After : " + Arrays.toString(arr));
	}
    public void moveZeroes(int[] nums) {
        int cur = 0;
        
        /* Move all the non-zero elements to the front */
        for(int i=0; i<nums.length; i++){
            if(nums[i]==0) continue;
            nums[cur]=nums[i];
            cur++;
        }
        /* Pad the rest of the spaces with zero */
        for(int i=cur; i<nums.length; i++){
            nums[i]=0;
        }
    }
}