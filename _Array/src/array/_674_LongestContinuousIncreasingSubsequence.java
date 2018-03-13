package array;

import java.util.Arrays;

public class _674_LongestContinuousIncreasingSubsequence {

	public static void main(String[] args) {
		_674_LongestContinuousIncreasingSubsequence obj = new _674_LongestContinuousIncreasingSubsequence();
		int[] arr1 = new int[]{2,5,6,3,6,7,9,2,1,5,6,7,9};
		int[] arr2 = new int[]{12,35,26,53,76,47,69,32,41,35,62,79,29};
		int r1 = obj.findLengthOfLCIS(arr1);
		int r2 = obj.findLengthOfLCIS(arr2);
		System.out.println(Arrays.toString(arr1) + " --> " + r1);
		System.out.println(Arrays.toString(arr2) + " --> " + r2);
	}
    public int findLengthOfLCIS(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int lcis=1;
        int local=1; 
        for(int i=1; i<nums.length; i++){
            if(nums[i-1]<nums[i]) local++;
            else local=1;
            lcis = lcis>local ? lcis : local; 
        }
        return lcis; 
    }
}