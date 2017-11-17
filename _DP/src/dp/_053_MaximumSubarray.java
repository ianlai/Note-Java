package dp;

import java.util.Arrays;

public class _053_MaximumSubarray {

	public static void main(String[] args) {
		_053_MaximumSubarray obj = new _053_MaximumSubarray();
		int[] arr = new int[]{-2,1,-3,4,-1,2,1,-5,4};
		int res = obj.maxSubArray(arr);
		System.out.println(Arrays.toString(arr) + " --> " + res);
	}

    public int maxSubArray(int[] A) {
        int length = A.length;
        if(length==0) return 0;
        int[] dp = new int[length];
        dp[0] = A[0];
        int max = A[0];
        for(int i=1; i<length; i++){
            dp[i] = Math.max(dp[i-1]+A[i], A[i]);
            max = Math.max(dp[i], max);
        }
        return max;
    }
}