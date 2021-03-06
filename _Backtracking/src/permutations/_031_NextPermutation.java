package permutations;

import java.util.Arrays;

/*
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as the lowest possible order 
 * (ie, sorted in ascending order).
 * The replacement must be in-place, do not allocate extra memory.
 * Here are some examples. 
 * Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */

public class _031_NextPermutation {
	boolean isDebug = true;

	public static void main(String[] args) {
		_031_NextPermutation obj = new _031_NextPermutation();
		int[] arr1 = new int[]{1,2,3};
		int[] arr2 = new int[]{2,3,4,1};
		int[] arr3 = new int[]{3,3,1,3,2};
		int[] arr4 = new int[]{4,3,2,1};
		int[] arr5 = new int[]{1,5,9,6,6,3,7,2,5,6,9,7,5,2};
		
		System.out.println(Arrays.toString(arr1));
		obj.nextPermutation(arr1);
		System.out.println(Arrays.toString(arr1));
		System.out.println("-------------");
		
		System.out.println(Arrays.toString(arr2));
		obj.nextPermutation(arr2);
		System.out.println(Arrays.toString(arr2));
		System.out.println("-------------");
		
		System.out.println(Arrays.toString(arr3));
		obj.nextPermutation(arr3);
		System.out.println(Arrays.toString(arr3));
		System.out.println("-------------");
		
		System.out.println(Arrays.toString(arr4));
		obj.nextPermutation(arr4);
		System.out.println(Arrays.toString(arr4));
		System.out.println("-------------");
		
		System.out.println(Arrays.toString(arr5));
		obj.nextPermutation(arr5);
		System.out.println(Arrays.toString(arr5));
		System.out.println("-------------");
		
	}
    public void nextPermutation(int[] nums) {
        int l=nums.length;
        int lastUp=-1;
        int lastUpIndex = -1;
        
        /* Find the last increase index (lastUp) */
        for(int i=1; i<l; i++){
            if(nums[i-1] < nums[i]) 
                lastUpIndex = i-1; 
        }
        debug("lastUpIndex: " + lastUpIndex);
        
        /* Catch special case: 
         * Largest combination round up to smallest combination
         * Just reverse the array.
         * Ex. 321 -> 123
         * 
         */
        if(lastUpIndex==-1){
            int[] temp = new int[l];
            for(int i=0; i<l; i++){
                temp[l-i-1] = nums[i];  //reverse nums[]
            }
            for(int i=0; i<l; i++){
                nums[i] = temp[i];
            }
            return;
        }
        
        /* Normal case:
         * Ex. 123     -> 132
         * Ex. 132     -> 213
         * Ex. 1359872 -> 1372589  
         *       -----      -----
         *       5 is the last one increasing 
         *       It means the subarray right after 5 is descending. [9872]
         *       This also means it's the max of heading by 5. 
         *       If we want to do a next operation of this, 5 should be swap with one larger than it.[7]
         *       Then it becomes [7-9852]. 
         *       This is the max of heading by 7. 
         *       Because we need to find the min of heading by 7, we simply reverse the one after 7. 
         *       In conclusion: 
         *       (1) Find the last one increasing
         *       (2) Find the min larger than (1) after (1)
         *       (3) Swap (1) and (2)
         *       (4) Reverse the subarray after (1)
         */
        lastUp = nums[lastUpIndex];
        int lastGreaterThanLastUp=-1;
        int lastGreaterThanLastUpIndex=-1; 
        
        /* Find the last element greater than last increase element (lastGreaterThanLastUp) */
        for(int i=lastUpIndex+1; i<l; i++){
            if(nums[i] > lastUp) 
                lastGreaterThanLastUpIndex = i;
        }
        debug("lastGreaterThanLastUpIndex: " + lastGreaterThanLastUpIndex);
        lastGreaterThanLastUp = nums[lastGreaterThanLastUpIndex];
        
        /* Swap lastUp and lastGreaterThanLastUp */
        int swap = lastGreaterThanLastUp;
        nums[lastGreaterThanLastUpIndex] = lastUp;
        nums[lastUpIndex] = swap;
        
        /* Reverse the remaining elements after lastUp */ 
        int tempSize = l-lastUpIndex-1;
        int[] temp = new int[tempSize]; 
        for(int i=lastUpIndex+1; i<l; i++){
            temp[i-lastUpIndex-1] = nums[i];
        }
        for(int i=lastUpIndex+1; i<l; i++){
            nums[i] = temp[tempSize - 1 - i + (lastUpIndex+1)];
        }
    }
	// --------------------------------------------------
	private void debug(String s) {
		if (isDebug)
			System.out.println(s);
	}
}