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
		int[] arr1 = new int[]{1,1,2,2,2,3,4,5,5,6};
		int[] arr2 = new int[]{1,1,2,2,2,3,4,5,5,6};
		
		int newLength1 = obj.removeDuplicates1(arr1);
		int newLength2 = obj.removeDuplicates2(arr2);
		System.out.println("[Before]");
		System.out.println(Arrays.toString(arr1) + " -- " + arr1.length);
		
		System.out.println();
		System.out.println("[After]  //acutally array length does not change");
		System.out.println(Arrays.toString(arr1) + " -- " + arr1.length);
		System.out.println(Arrays.toString(arr2) + " -- " + arr2.length);
		
		System.out.println("[After]  //traverse for new length");
		for(int i=0;i<newLength1;i++){
			System.out.print(arr1[i] + ", ");
		}
		System.out.println();
		for(int i=0;i<newLength2;i++){
			System.out.print(arr2[i] + ", ");
		}
	}

    public int removeDuplicates1(int[] nums) {
        if(nums.length==0) return 0;

        int index = 0; 
        for(int i=1; i<nums.length; i++){
            if(nums[i-1]!=nums[i]) index++; 
            nums[index] = nums[i];
        }
        return index+1;
    }
    
    public int removeDuplicates2(int[] nums) {
        int cur = 0;
        for(int i=0; i<nums.length; i++){
            if(i>0 && nums[i-1]==nums[i]) continue; //skip the redundancies 
            nums[cur++] = nums[i];
        }
        return cur;  //cur already ++ in the last round  
    }
}