package houseRobber;

public class _213_HouseRobber2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//Cycle 
	public int robCycle(int[] nums) {
		if (nums.length == 0)
			return 0;
		if (nums.length == 1)
			return nums[0];
		return Math.max(rob2(nums, 0, nums.length - 2), rob2(nums, 1, nums.length - 1));
	}
	
	//Same as _198_HouseRobber::rob2
	public int rob2(int[] nums, int l, int h) {
		if (l == h)
			return nums[l];
		int size = h - l + 1;
		int[] dp = new int[size];
		dp[0] = nums[l];
		dp[1] = Math.max(nums[l], nums[l + 1]);
		for (int i = 2; i < size; ++i) {
			dp[i] = Math.max(dp[i - 2] + nums[l + i], dp[i - 1]); // nums[l+i],
																	// not
																	// nums[i]
		}
//		for (int i = 0; i < dp.length; ++i) {
//			System.out.println(i + " : " + dp[i]);
//		}
		return dp[size - 1];
	}

}
