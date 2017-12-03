package permutations;

import java.util.Arrays;

public class _031_NextPermutation {

	public static void main(String[] args) {
		_031_NextPermutation obj = new _031_NextPermutation();
		int[] arr1 = new int[]{1,2,3};
		int[] arr2 = new int[]{2,3,4,1};
		int[] arr3 = new int[]{3,3,1,3,2};
		int[] arr4 = new int[]{4,3,2,1};
		
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
        
        /* Catch special case: 
         * largest combination round up to smallest combination
         * Ex. 321 -> 123
         */
        if(lastUpIndex==-1){
            int[] temp = new int[l];
            for(int i=0; i<l; i++){
                temp[l-i-1] = nums[i];
            }
            for(int i=0; i<l; i++){
                nums[i] = temp[i];
            }
            return;
        }
        
        /* Normal case:
         * Ex. 123 -> 132
         * Ex. 132 -> 213
         */
        lastUp = nums[lastUpIndex];
        int lastGreaterThanLastUp=-1;
        int lastGreaterThanLastUpIndex=-1; 
        
        /* Find the last element greater than last increase element (lastGreaterThanLastUp) */
        for(int i=lastUpIndex+1; i<l; i++){
            if(nums[i] > lastUp) 
                lastGreaterThanLastUpIndex = i;
        }
        lastGreaterThanLastUp = nums[lastGreaterThanLastUpIndex];
        
        /* Swap lastUp and lastGreaterThanLastUp */
        int swap = lastGreaterThanLastUp;
        nums[lastGreaterThanLastUpIndex] = lastUp;
        nums[lastUpIndex] = swap;
        
        //System.out.println("After Swap:" + Arrays.toString(nums));
        //System.out.println("lastUp: " + lastUpIndex);
        //System.out.println("lastGr: " + lastGreaterThanLastUpIndex);
        
        /* Reverse the remaining elements after lastUp */ 
        int tempSize = l-lastUpIndex-1;
        int[] temp = new int[tempSize]; 
        for(int i=lastUpIndex+1; i<l; i++){
            temp[i-lastUpIndex-1] = nums[i];
        }
        for(int i=lastUpIndex+1; i<l; i++){
            nums[i] = temp[tempSize - 1 - i + (lastUpIndex+1)];
        }
        //System.out.println("After Reverse:" + Arrays.toString(nums));
    }
}