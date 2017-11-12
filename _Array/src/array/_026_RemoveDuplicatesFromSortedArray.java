package array;

import java.util.Arrays;

/* 
 * Input array  : [1,1,2,2,2,3,4,5,5,6]  //sorted
 * Output array : [1,2,3,4,5,6] and new length = 6
 * 
 * Note: Cannot create a new array 
 */
public class _026_RemoveDuplicatesFromSortedArray {

	public static void main(String[] args) {
		_026_RemoveDuplicatesFromSortedArray obj = new _026_RemoveDuplicatesFromSortedArray();
		int[] arr = new int[]{1,1,2,2,2,3,4,5,5,6};
		int newLength = obj.removeDuplicates(arr);
		System.out.println("[Before]");
		System.out.println(Arrays.toString(arr) + " -- " + arr.length);
		
		System.out.println();
		System.out.println("[After] //acutally array length does not change");
		System.out.println(Arrays.toString(arr) + " -- " + arr.length);
		for(int i=0;i<newLength;i++){
			System.out.print(arr[i] + ", ");
		}
	}

    public int removeDuplicates(int[] nums) {
        if(nums.length==0) return 0;

        int index = 0; 
        for(int i=1; i<nums.length; i++){
            if(nums[i-1]!=nums[i]) index++; 
            nums[index] = nums[i];
        }
        return index+1;
    }
}