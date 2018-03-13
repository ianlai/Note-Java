package dp;

import java.util.Arrays;

public class _300_LongestIncreasingSubsequence {

	public static void main(String[] args) {
		_300_LongestIncreasingSubsequence obj = new _300_LongestIncreasingSubsequence();
		int[] arr1 = new int[]{3,5,2,7,12,4,8,9};
		int[] arr2 = new int[]{3,1,2,15,27,5,22,18,64,72,31,91,43,68};
		int r1 = obj.lengthOfLIS(arr1);
		int r2 = obj.lengthOfLIS(arr2);
		System.out.println(Arrays.toString(arr1) + " -> " + r1);
		System.out.println(Arrays.toString(arr2) + " -> " + r2);
	}
    public int lengthOfLIS(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int[] lis = new int[nums.length];
        Arrays.fill(lis, 1);
        for(int i=1; i<nums.length; i++){
            for(int j=0; j<i; j++){
                if(nums[j]<nums[i] && lis[j]+1>lis[i]) 
                    lis[i] = lis[j]+1;
            }
        }
        //System.out.println(Arrays.toString(lis));
        int max=-1;
        for(int i=0; i<nums.length; i++){
            max = Math.max(lis[i], max);
        }
        return max;
    }
}